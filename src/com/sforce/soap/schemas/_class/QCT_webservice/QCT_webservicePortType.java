/**
 * QCT_webservicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap.schemas._class.QCT_webservice;

public interface QCT_webservicePortType extends java.rmi.Remote {
    public java.lang.String[] getEditFields(java.lang.String strObjectAPIName) throws java.rmi.RemoteException;
    public java.lang.String[] getPicklistValues(java.lang.String strObjectAPIName, java.lang.String strFieldName) throws java.rmi.RemoteException;
    public java.lang.String[] getReadFields(java.lang.String strObjectAPIName) throws java.rmi.RemoteException;
    public java.lang.String getRecordsAsPXML(java.lang.String strXMLupdate) throws java.rmi.RemoteException;
    public java.lang.String[] getRecordsAsStrings(java.lang.String strQuery) throws java.rmi.RemoteException;
    public java.lang.String insertRecordReturnResultsAsPXML(java.lang.String strQuery) throws java.rmi.RemoteException;
    public java.lang.String insertRecordReturnResultsAsStrings(java.lang.String strXMLupdate) throws java.rmi.RemoteException;
    public java.lang.String updateFieldsReturnResultsAsPXML(java.lang.String strXMLupdate) throws java.rmi.RemoteException;
    public java.lang.String updateFieldsReturnResultsAsStrings(java.lang.String strXMLupdate) throws java.rmi.RemoteException;
    public java.lang.String updateMultipleRecordsReturnResultsAsPXML(java.lang.String strXMLupdate) throws java.rmi.RemoteException;
    public java.lang.String[] updateMultipleRecordsReturnResultsAsStrings(java.lang.String strXMLupdate) throws java.rmi.RemoteException;
}
