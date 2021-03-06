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
package com.amazonaws.services.ecs.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * <p>
 * Linux-specific options that are applied to the container, such as Linux <a>KernelCapabilities</a>.
 * </p>
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ecs-2014-11-13/LinuxParameters" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class LinuxParameters implements Serializable, Cloneable, StructuredPojo {

    /**
     * <p>
     * The Linux capabilities for the container that are added to or dropped from the default configuration provided by
     * Docker.
     * </p>
     */
    private KernelCapabilities capabilities;
    /**
     * <p>
     * Any host devices to expose to the container. This parameter maps to <code>Devices</code> in the <a
     * href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/#create-a-container">Create a
     * container</a> section of the <a
     * href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/">Docker Remote API</a> and the
     * <code>--device</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * </p>
     */
    private com.amazonaws.internal.SdkInternalList<Device> devices;
    /**
     * <p>
     * Run an <code>init</code> process inside the container that forwards signals and reaps processes. This parameter
     * maps to the <code>--init</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * This parameter requires version 1.25 of the Docker Remote API or greater on your container instance. To check the
     * Docker Remote API version on your container instance, log into your container instance and run the following
     * command: <code>sudo docker version | grep "Server API version"</code>
     * </p>
     */
    private Boolean initProcessEnabled;

    /**
     * <p>
     * The Linux capabilities for the container that are added to or dropped from the default configuration provided by
     * Docker.
     * </p>
     * 
     * @param capabilities
     *        The Linux capabilities for the container that are added to or dropped from the default configuration
     *        provided by Docker.
     */

    public void setCapabilities(KernelCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * <p>
     * The Linux capabilities for the container that are added to or dropped from the default configuration provided by
     * Docker.
     * </p>
     * 
     * @return The Linux capabilities for the container that are added to or dropped from the default configuration
     *         provided by Docker.
     */

    public KernelCapabilities getCapabilities() {
        return this.capabilities;
    }

    /**
     * <p>
     * The Linux capabilities for the container that are added to or dropped from the default configuration provided by
     * Docker.
     * </p>
     * 
     * @param capabilities
     *        The Linux capabilities for the container that are added to or dropped from the default configuration
     *        provided by Docker.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public LinuxParameters withCapabilities(KernelCapabilities capabilities) {
        setCapabilities(capabilities);
        return this;
    }

    /**
     * <p>
     * Any host devices to expose to the container. This parameter maps to <code>Devices</code> in the <a
     * href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/#create-a-container">Create a
     * container</a> section of the <a
     * href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/">Docker Remote API</a> and the
     * <code>--device</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * </p>
     * 
     * @return Any host devices to expose to the container. This parameter maps to <code>Devices</code> in the <a
     *         href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/#create-a-container">Create a
     *         container</a> section of the <a
     *         href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/">Docker Remote API</a> and
     *         the <code>--device</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker
     *         run</a>.
     */

    public java.util.List<Device> getDevices() {
        if (devices == null) {
            devices = new com.amazonaws.internal.SdkInternalList<Device>();
        }
        return devices;
    }

    /**
     * <p>
     * Any host devices to expose to the container. This parameter maps to <code>Devices</code> in the <a
     * href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/#create-a-container">Create a
     * container</a> section of the <a
     * href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/">Docker Remote API</a> and the
     * <code>--device</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * </p>
     * 
     * @param devices
     *        Any host devices to expose to the container. This parameter maps to <code>Devices</code> in the <a
     *        href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/#create-a-container">Create a
     *        container</a> section of the <a
     *        href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/">Docker Remote API</a> and the
     *        <code>--device</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     */

    public void setDevices(java.util.Collection<Device> devices) {
        if (devices == null) {
            this.devices = null;
            return;
        }

        this.devices = new com.amazonaws.internal.SdkInternalList<Device>(devices);
    }

    /**
     * <p>
     * Any host devices to expose to the container. This parameter maps to <code>Devices</code> in the <a
     * href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/#create-a-container">Create a
     * container</a> section of the <a
     * href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/">Docker Remote API</a> and the
     * <code>--device</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setDevices(java.util.Collection)} or {@link #withDevices(java.util.Collection)} if you want to override
     * the existing values.
     * </p>
     * 
     * @param devices
     *        Any host devices to expose to the container. This parameter maps to <code>Devices</code> in the <a
     *        href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/#create-a-container">Create a
     *        container</a> section of the <a
     *        href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/">Docker Remote API</a> and the
     *        <code>--device</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public LinuxParameters withDevices(Device... devices) {
        if (this.devices == null) {
            setDevices(new com.amazonaws.internal.SdkInternalList<Device>(devices.length));
        }
        for (Device ele : devices) {
            this.devices.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * Any host devices to expose to the container. This parameter maps to <code>Devices</code> in the <a
     * href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/#create-a-container">Create a
     * container</a> section of the <a
     * href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/">Docker Remote API</a> and the
     * <code>--device</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * </p>
     * 
     * @param devices
     *        Any host devices to expose to the container. This parameter maps to <code>Devices</code> in the <a
     *        href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/#create-a-container">Create a
     *        container</a> section of the <a
     *        href="https://docs.docker.com/engine/reference/api/docker_remote_api_v1.27/">Docker Remote API</a> and the
     *        <code>--device</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public LinuxParameters withDevices(java.util.Collection<Device> devices) {
        setDevices(devices);
        return this;
    }

    /**
     * <p>
     * Run an <code>init</code> process inside the container that forwards signals and reaps processes. This parameter
     * maps to the <code>--init</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * This parameter requires version 1.25 of the Docker Remote API or greater on your container instance. To check the
     * Docker Remote API version on your container instance, log into your container instance and run the following
     * command: <code>sudo docker version | grep "Server API version"</code>
     * </p>
     * 
     * @param initProcessEnabled
     *        Run an <code>init</code> process inside the container that forwards signals and reaps processes. This
     *        parameter maps to the <code>--init</code> option to <a
     *        href="https://docs.docker.com/engine/reference/run/">docker run</a>. This parameter requires version 1.25
     *        of the Docker Remote API or greater on your container instance. To check the Docker Remote API version on
     *        your container instance, log into your container instance and run the following command:
     *        <code>sudo docker version | grep "Server API version"</code>
     */

    public void setInitProcessEnabled(Boolean initProcessEnabled) {
        this.initProcessEnabled = initProcessEnabled;
    }

    /**
     * <p>
     * Run an <code>init</code> process inside the container that forwards signals and reaps processes. This parameter
     * maps to the <code>--init</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * This parameter requires version 1.25 of the Docker Remote API or greater on your container instance. To check the
     * Docker Remote API version on your container instance, log into your container instance and run the following
     * command: <code>sudo docker version | grep "Server API version"</code>
     * </p>
     * 
     * @return Run an <code>init</code> process inside the container that forwards signals and reaps processes. This
     *         parameter maps to the <code>--init</code> option to <a
     *         href="https://docs.docker.com/engine/reference/run/">docker run</a>. This parameter requires version 1.25
     *         of the Docker Remote API or greater on your container instance. To check the Docker Remote API version on
     *         your container instance, log into your container instance and run the following command:
     *         <code>sudo docker version | grep "Server API version"</code>
     */

    public Boolean getInitProcessEnabled() {
        return this.initProcessEnabled;
    }

    /**
     * <p>
     * Run an <code>init</code> process inside the container that forwards signals and reaps processes. This parameter
     * maps to the <code>--init</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * This parameter requires version 1.25 of the Docker Remote API or greater on your container instance. To check the
     * Docker Remote API version on your container instance, log into your container instance and run the following
     * command: <code>sudo docker version | grep "Server API version"</code>
     * </p>
     * 
     * @param initProcessEnabled
     *        Run an <code>init</code> process inside the container that forwards signals and reaps processes. This
     *        parameter maps to the <code>--init</code> option to <a
     *        href="https://docs.docker.com/engine/reference/run/">docker run</a>. This parameter requires version 1.25
     *        of the Docker Remote API or greater on your container instance. To check the Docker Remote API version on
     *        your container instance, log into your container instance and run the following command:
     *        <code>sudo docker version | grep "Server API version"</code>
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public LinuxParameters withInitProcessEnabled(Boolean initProcessEnabled) {
        setInitProcessEnabled(initProcessEnabled);
        return this;
    }

    /**
     * <p>
     * Run an <code>init</code> process inside the container that forwards signals and reaps processes. This parameter
     * maps to the <code>--init</code> option to <a href="https://docs.docker.com/engine/reference/run/">docker run</a>.
     * This parameter requires version 1.25 of the Docker Remote API or greater on your container instance. To check the
     * Docker Remote API version on your container instance, log into your container instance and run the following
     * command: <code>sudo docker version | grep "Server API version"</code>
     * </p>
     * 
     * @return Run an <code>init</code> process inside the container that forwards signals and reaps processes. This
     *         parameter maps to the <code>--init</code> option to <a
     *         href="https://docs.docker.com/engine/reference/run/">docker run</a>. This parameter requires version 1.25
     *         of the Docker Remote API or greater on your container instance. To check the Docker Remote API version on
     *         your container instance, log into your container instance and run the following command:
     *         <code>sudo docker version | grep "Server API version"</code>
     */

    public Boolean isInitProcessEnabled() {
        return this.initProcessEnabled;
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCapabilities() != null)
            sb.append("Capabilities: ").append(getCapabilities()).append(",");
        if (getDevices() != null)
            sb.append("Devices: ").append(getDevices()).append(",");
        if (getInitProcessEnabled() != null)
            sb.append("InitProcessEnabled: ").append(getInitProcessEnabled());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof LinuxParameters == false)
            return false;
        LinuxParameters other = (LinuxParameters) obj;
        if (other.getCapabilities() == null ^ this.getCapabilities() == null)
            return false;
        if (other.getCapabilities() != null && other.getCapabilities().equals(this.getCapabilities()) == false)
            return false;
        if (other.getDevices() == null ^ this.getDevices() == null)
            return false;
        if (other.getDevices() != null && other.getDevices().equals(this.getDevices()) == false)
            return false;
        if (other.getInitProcessEnabled() == null ^ this.getInitProcessEnabled() == null)
            return false;
        if (other.getInitProcessEnabled() != null && other.getInitProcessEnabled().equals(this.getInitProcessEnabled()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getCapabilities() == null) ? 0 : getCapabilities().hashCode());
        hashCode = prime * hashCode + ((getDevices() == null) ? 0 : getDevices().hashCode());
        hashCode = prime * hashCode + ((getInitProcessEnabled() == null) ? 0 : getInitProcessEnabled().hashCode());
        return hashCode;
    }

    @Override
    public LinuxParameters clone() {
        try {
            return (LinuxParameters) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.amazonaws.services.ecs.model.transform.LinuxParametersMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
