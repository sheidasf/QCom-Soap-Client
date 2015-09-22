package com.qualcomm.sfclient;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import java.io.*;
import java.util.*;

import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.*;
import com.sforce.soap.partner.SessionHeader_element;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

import com.sforce.soap.schemas._class.QCT_webservice.QCT_webserviceBindingStub;
import com.sforce.soap.schemas._class.QCT_webservice.QCT_webserviceServiceLocator;
import com.sforce.soap.schemas._class.QCT_webservice.SessionHeader;

public class SalesforceClient {

	private PartnerConnection partnerConnection = null;
	private QCT_webserviceBindingStub QCTStub = null;
	private String partnerEndpoint = null;
	private String QCTEndpoint = null;	
	private String authEndpoint = null;	
	private String sessionId = null;
	private ConnectorConfig config = null;
	
	public SalesforceClient(String authURL, String pURL, String QURL, String username, String password)
			throws RemoteException, ServiceException {

		partnerEndpoint = pURL;
		QCTEndpoint = QURL;
		authEndpoint = authURL;
		
		try {
			config = new ConnectorConfig();
			config.setUsername (username);
			config.setPassword(password);
			config.setAuthEndpoint(authEndpoint);
			
			partnerConnection = (PartnerConnection) new PartnerConnection(config);
		} catch (ConnectionException e1) {
			e1.printStackTrace();
		}
		
		sessionId = config.getSessionId();
		System.out.println ("session id:" + sessionId);
		config.getServiceEndpoint();
		



/*		
		enterpriseStub._setProperty(SoapBindingStub.ENDPOINT_ADDRESS_PROPERTY,
				loginResult.getServerUrl());	
		SessionHeader sh = new SessionHeader();
		sh.setSessionId(loginResult.getSessionId());			
		enterpriseStub.setHeader(new SforceServiceLocator().getServiceName()
				.getNamespaceURI(), "SessionHeader", sh);
*/
	}

	public String getUserFullName() throws ConnectionException {
		return partnerConnection.getUserInfo().getUserFullName();
	}

	public void logout() throws ConnectionException {
		partnerConnection.logout();
		sessionId = null;
	}

	public String getSessionId(){
		return sessionId;
	}

	public void prepareQCTstub() throws Exception {
		QCT_webserviceServiceLocator locator = new QCT_webserviceServiceLocator();
		locator.setQCT_webserviceEndpointAddress(QCTEndpoint);
		
		QCTStub = new QCT_webserviceBindingStub();
		
		SessionHeader sh = new SessionHeader();
        sh.setSessionId(sessionId);
        
		QCTStub._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY, QCTEndpoint);
		QCTStub.setHeader(locator.getServiceName().getNamespaceURI(),"SessionHeader", sh);
		
		
	}

	public String[] getEditFields(String objName) throws Exception
	{
		prepareQCTstub ();
		String strObjectApiName = objName;
		String[] results = QCTStub.getEditFields(strObjectApiName);

		return results;
	}
	
	public String[] getReadFields(String objName) throws Exception
	{
		prepareQCTstub ();
		String strObjectApiName = objName;
		String[] results = QCTStub.getReadFields(strObjectApiName);

		return results;
	}
	
	public String[] getPickListValues(String strObjectAPIName, String strFieldName)
 throws Exception
	{
		prepareQCTstub ();

		String[] results = QCTStub.getPicklistValues(strObjectAPIName, strFieldName);

		return results;
	}


	public String[] getRecords(String strQuery) throws Exception
	{
		prepareQCTstub ();

		String[] results = QCTStub.getRecordsAsStrings(strQuery);
		System.out.println ("Number of records:" + results.length);

		return results;

	} 
	

	/* update field xml should look like:
	 * <Message><SObject>Case</SObject><Select>select id, Problem_Code_1__c from case where id='500300000066OJg'</Select><Problem_Code_1__c>555</Problem_Code_1__c></Message>
	 */

	public String updateFieldsReturnResultsAsStrings(String strXML) throws Exception
	{
		prepareQCTstub ();
		
		String result = QCTStub.updateFieldsReturnResultsAsStrings(strXML);

		return result;

	}

	public String insertRecord (String strXML) throws Exception
	{
		prepareQCTstub ();

		String result = QCTStub.insertRecordReturnResultsAsStrings(strXML);

		return result;

	}
	
	
	public String[] updateMultipleRecords (String strXMLupdate) throws Exception
	{
		prepareQCTstub ();

		String[] results = QCTStub.updateMultipleRecordsReturnResultsAsStrings(strXMLupdate);

		return results;

	} 
	
}
