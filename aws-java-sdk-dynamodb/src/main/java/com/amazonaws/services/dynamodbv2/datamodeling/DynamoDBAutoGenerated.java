/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a property as using a custom auto-generator.
 *
 * May be annotated on a user-defined annotation to pass additional information
 * to the {@link DynamoDBAutoGenerator}.
 *
 * A minimal example using getter annotations,
 * <pre class="brush: java">
 * &#064;DynamoDBTable(tableName=&quot;TestTable&quot;)
 * public class TestClass {
 *     private String key, value;
 *
 *     &#064;DynamoDBHashKey
 *     &#064;CustomGeneratedKey(prefix=&quot;test-&quot;) //&lt;- user-defined annotation
 *     public String getKey() { return this.key; }
 *     public void setKey(String key) { this.key = key; }
 *
 *     public String getValue() { return this.value; }
 *     public void setValue(String value) { this.value = value; }
 * }
 * </pre>
 *
 * And user-defined annotation,
 * <pre class="brush: java">
 * &#064;DynamoDBAutoGenerated(generator=CustomGeneratedKey.Generator.class)
 * &#064;Retention(RetentionPolicy.RUNTIME)
 * &#064;Target({ElementType.METHOD})
 * public &#064;interface CustomGeneratedKey {
 *     String prefix() default &quot;&quot;;
 *
 *     public static final class Generator implements DynamoDBAutoGenerator&lt;String&gt; {
 *         private final String prefix;
 *         public Generator(final Class&lt;String&gt; targetType, final CustomGeneratedKey annotation) {
 *             this.prefix = annotation.prefix();
 *         }
 *         public Generator() {
 *             this.prefix = "";
 *         }
 *         &#064;Override
 *         public DynamoDBAutoGenerateStrategy getGenerateStrategy() {
 *             return DynamoDBAutoGenerateStrategy.CREATE;
 *         }
 *         &#064;Override
 *         public final String generate(final String currentValue) {
 *             return prefix + UUID.randomUUID.toString();
 *         }
 *     }
 * }
 * </pre>
 *
 * Alternatively, the property/field may be annotated directly (which requires
 * the generator to provide a default constructor),
 * <pre class="brush: java">
 * &#064;DynamoDBHashKey
 * &#064;DynamoDBAutoGenerated(generator=CustomGeneratedKey.Generator.class)
 * public String getKey() { return this.key; }
 * </pre>
 *
 * @see com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedDefault
 * @see com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey
 * @see com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp
 * @see com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerator
 * @see com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersionAttribute
 */
@DynamoDB
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface DynamoDBAutoGenerated {

    /**
     * The auto-generator class for this property.
     */
    Class<? extends DynamoDBAutoGenerator> generator();

    /**
     * Annotation auto-generator factory.
     */
    static final class Generators {
        static <T> DynamoDBAutoGenerator<T> of(final Class<T> targetType, final Annotation annotation) {
            final DynamoDBAutoGenerated generated;

            if (annotation.annotationType() == DynamoDBAutoGenerated.class) {
                generated = (DynamoDBAutoGenerated)annotation;
            } else {
                generated = annotation.annotationType().getAnnotation(DynamoDBAutoGenerated.class);
                if (generated == null) {
                    throw new DynamoDBMappingException("could not resolve auto-generator: " + annotation);
                }
            }

            Class<DynamoDBAutoGenerator<T>> clazz = (Class<DynamoDBAutoGenerator<T>>)generated.generator();
            DynamoDBAutoGenerator<T> generator = null;

            try {
                if (annotation != generated) {
                    try {
                        generator = clazz.getConstructor(Class.class, annotation.annotationType())
                            .newInstance(targetType, annotation);
                    } catch (final NoSuchMethodException no) {}
                }
                if (generator == null) {
                    try {
                        generator = clazz.getConstructor(Class.class).newInstance(targetType);
                    } catch (final NoSuchMethodException no) {
                        generator = clazz.newInstance();
                    }
                }
            } catch (final Exception e) {
                throw new DynamoDBMappingException("could not create auto-generator: " + annotation, e);
            }

            if (generator.getGenerateStrategy() == DynamoDBAutoGenerateStrategy.CREATE && targetType.isPrimitive()) {
                throw new DynamoDBMappingException("type [" + targetType + "] is not supported" +
                    "; primitives are not allowed when auto-generate strategy is CREATE");
            }

            return generator;
        }
    }

}