/**
 * QCT_webserviceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap.schemas._class.QCT_webservice;

public class QCT_webserviceServiceLocator extends org.apache.axis.client.Service implements com.sforce.soap.schemas._class.QCT_webservice.QCT_webserviceService {

    public QCT_webserviceServiceLocator() {
    }


    public QCT_webserviceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public QCT_webserviceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for QCT_webservice
    private java.lang.String QCT_webservice_address = "https://cs30.salesforce.com/services/Soap/class/QCT_webservice";

    public java.lang.String getQCT_webserviceAddress() {
        return QCT_webservice_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String QCT_webserviceWSDDServiceName = "QCT_webservice";

    public java.lang.String getQCT_webserviceWSDDServiceName() {
        return QCT_webserviceWSDDServiceName;
    }

    public void setQCT_webserviceWSDDServiceName(java.lang.String name) {
        QCT_webserviceWSDDServiceName = name;
    }

    public com.sforce.soap.schemas._class.QCT_webservice.QCT_webservicePortType getQCT_webservice() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(QCT_webservice_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getQCT_webservice(endpoint);
    }

    public com.sforce.soap.schemas._class.QCT_webservice.QCT_webservicePortType getQCT_webservice(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sforce.soap.schemas._class.QCT_webservice.QCT_webserviceBindingStub _stub = new com.sforce.soap.schemas._class.QCT_webservice.QCT_webserviceBindingStub(portAddress, this);
            _stub.setPortName(getQCT_webserviceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setQCT_webserviceEndpointAddress(java.lang.String address) {
        QCT_webservice_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sforce.soap.schemas._class.QCT_webservice.QCT_webservicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sforce.soap.schemas._class.QCT_webservice.QCT_webserviceBindingStub _stub = new com.sforce.soap.schemas._class.QCT_webservice.QCT_webserviceBindingStub(new java.net.URL(QCT_webservice_address), this);
                _stub.setPortName(getQCT_webserviceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("QCT_webservice".equals(inputPortName)) {
            return getQCT_webservice();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/QCT_webservice", "QCT_webserviceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/QCT_webservice", "QCT_webservice"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("QCT_webservice".equals(portName)) {
            setQCT_webserviceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
