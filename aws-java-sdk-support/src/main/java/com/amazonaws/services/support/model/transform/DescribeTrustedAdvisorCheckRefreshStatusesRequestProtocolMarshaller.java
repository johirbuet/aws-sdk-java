/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.support.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.support.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * DescribeTrustedAdvisorCheckRefreshStatusesRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class DescribeTrustedAdvisorCheckRefreshStatusesRequestProtocolMarshaller implements
        Marshaller<Request<DescribeTrustedAdvisorCheckRefreshStatusesRequest>, DescribeTrustedAdvisorCheckRefreshStatusesRequest> {

    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().protocol(Protocol.AWS_JSON).requestUri("/")
            .httpMethodName(HttpMethodName.POST).hasExplicitPayloadMember(false).hasPayloadMembers(true)
            .operationIdentifier("AWSSupport_20130415.DescribeTrustedAdvisorCheckRefreshStatuses").serviceName("AWSSupport").build();

    private final com.amazonaws.protocol.json.SdkJsonProtocolFactory protocolFactory;

    public DescribeTrustedAdvisorCheckRefreshStatusesRequestProtocolMarshaller(com.amazonaws.protocol.json.SdkJsonProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<DescribeTrustedAdvisorCheckRefreshStatusesRequest> marshall(
            DescribeTrustedAdvisorCheckRefreshStatusesRequest describeTrustedAdvisorCheckRefreshStatusesRequest) {

        if (describeTrustedAdvisorCheckRefreshStatusesRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            final ProtocolRequestMarshaller<DescribeTrustedAdvisorCheckRefreshStatusesRequest> protocolMarshaller = protocolFactory.createProtocolMarshaller(
                    SDK_OPERATION_BINDING, describeTrustedAdvisorCheckRefreshStatusesRequest);

            protocolMarshaller.startMarshalling();
            DescribeTrustedAdvisorCheckRefreshStatusesRequestMarshaller.getInstance().marshall(describeTrustedAdvisorCheckRefreshStatusesRequest,
                    protocolMarshaller);
            return protocolMarshaller.finishMarshalling();
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
