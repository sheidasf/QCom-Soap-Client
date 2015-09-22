package com.sforce.soap.schemas._class.QCT_webservice;

public class QCT_webservicePortTypeProxy implements com.sforce.soap.schemas._class.QCT_webservice.QCT_webservicePortType {
  private String _endpoint = null;
  private com.sforce.soap.schemas._class.QCT_webservice.QCT_webservicePortType qCT_webservicePortType = null;
  
  public QCT_webservicePortTypeProxy() {
    _initQCT_webservicePortTypeProxy();
  }
  
  public QCT_webservicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initQCT_webservicePortTypeProxy();
  }
  
  private void _initQCT_webservicePortTypeProxy() {
    try {
      qCT_webservicePortType = (new com.sforce.soap.schemas._class.QCT_webservice.QCT_webserviceServiceLocator()).getQCT_webservice();
      if (qCT_webservicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)qCT_webservicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)qCT_webservicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (qCT_webservicePortType != null)
      ((javax.xml.rpc.Stub)qCT_webservicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sforce.soap.schemas._class.QCT_webservice.QCT_webservicePortType getQCT_webservicePortType() {
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType;
  }
  
  public java.lang.String[] getEditFields(java.lang.String strObjectAPIName) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.getEditFields(strObjectAPIName);
  }
  
  public java.lang.String[] getPicklistValues(java.lang.String strObjectAPIName, java.lang.String strFieldName) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.getPicklistValues(strObjectAPIName, strFieldName);
  }
  
  public java.lang.String[] getReadFields(java.lang.String strObjectAPIName) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.getReadFields(strObjectAPIName);
  }
  
  public java.lang.String getRecordsAsPXML(java.lang.String strXMLupdate) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.getRecordsAsPXML(strXMLupdate);
  }
  
  public java.lang.String[] getRecordsAsStrings(java.lang.String strQuery) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.getRecordsAsStrings(strQuery);
  }
  
  public java.lang.String insertRecordReturnResultsAsPXML(java.lang.String strQuery) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.insertRecordReturnResultsAsPXML(strQuery);
  }
  
  public java.lang.String insertRecordReturnResultsAsStrings(java.lang.String strXMLupdate) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.insertRecordReturnResultsAsStrings(strXMLupdate);
  }
  
  public java.lang.String updateFieldsReturnResultsAsPXML(java.lang.String strXMLupdate) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.updateFieldsReturnResultsAsPXML(strXMLupdate);
  }
  
  public java.lang.String updateFieldsReturnResultsAsStrings(java.lang.String strXMLupdate) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.updateFieldsReturnResultsAsStrings(strXMLupdate);
  }
  
  public java.lang.String updateMultipleRecordsReturnResultsAsPXML(java.lang.String strXMLupdate) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.updateMultipleRecordsReturnResultsAsPXML(strXMLupdate);
  }
  
  public java.lang.String[] updateMultipleRecordsReturnResultsAsStrings(java.lang.String strXMLupdate) throws java.rmi.RemoteException{
    if (qCT_webservicePortType == null)
      _initQCT_webservicePortTypeProxy();
    return qCT_webservicePortType.updateMultipleRecordsReturnResultsAsStrings(strXMLupdate);
  }
  
  
}