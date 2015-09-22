package com.qualcomm.sfclient;


import com.jamesmurty.utils.XMLBuilder;
import com.sforce.soap.partner.sobject.SObject;
//import com.sforce.soap.schemas._class.QCT_webservice.Account;
//import com.sforce.soap.schemas._class.QCT_webservice._case;//
//import com.jamesmurty.utils.XMLBuilder;
//import com.sforce.soap.schemas._class.QCT_webservice._case;
//import com.sforce.soap.schemas._class.QCT_webservice._case;


public class SalesforceClientTest {
	
	final static String enterpriseEndpoint = "https://test.salesforce.com/services/Soap/c/30.0/0DF300000000KNZ";
	final static String QCTEndpoint = "https://cs30.salesforce.com/services/Soap/class/QCT_webservice";
	final static String authEndpoint = "https://test.salesforce.com/services/Soap/u/29.0";
	static SalesforceClient salesforceClient; 


	private static void updateMultipleRecordsTest() {
					
		/*  the following message updates multiple records 
		 *  updated fields updated to the values specified.
		 *  Individual records separated by RecordId
		 *  
		<Message>            
			<SObject>Case</SObject>
		    <Select>select ID, status, subject from Case where ID IN ('500n0000005QJxoAAG','500n0000005QJxtAAG')</Select>
			<XMLlist>$$%^%
			<Message><RecordID>500n0000005QJxoAAG</RecordID><subject>$%^%new subject SSF 1%^%$</subject></Message>::;::<Message><RecordID>500n0000005QJxtAAG</RecordID><subject>$%^%new subject SSF 2%^%$</subject></Message>
			%^%$$</XMLlist>
		</Message>
		 */
		String xtext;
		
		System.out.println ("\n****TESTING updateMultipleRecords ****");
		try
		{
			XMLBuilder rec1 = XMLBuilder.create("Message")
		        .e("RecordID").t("500n0000005QJxoAAG")
		        .up().e("subject").t("$%^%new subject SSF 1%^%$");		
			System.out.println("rec1" + rec1.asString());
		
			XMLBuilder rec2 = XMLBuilder.create("Message")
		        .e("RecordID").t("500n0000005QJxtAAG")
		        .up().e("subject").t("$%^%new subject SSF 2%^%$");
			System.out.println("rec2" + rec2.asString());
		
			String rowsToUpdate = "<XMLlist>$$%^%" + 
					rec1.asString() + 
					"::;::" +
					rec2.asString() +
					"%^%$$</XMLlist>";
		
			System.out.println ("rows to update" + rowsToUpdate);
			
			XMLBuilder selStatement = XMLBuilder.create("Select").t("select ID, status, subject from Case where ID IN ('500n0000005QJxoAAG','500n0000005QJxtAAG')");
			XMLBuilder sobj = XMLBuilder.create("SObject").t("Case");
		
			xtext = "<Message>" + sobj.asString() +
				selStatement.asString() +
				rowsToUpdate + 
				"</Message>";
	
			System.out.println ("full xml" + xtext);	
	

			String[] results = salesforceClient.updateMultipleRecords(xtext);
		
			for (int i=0; i<results.length; i++){
				System.out.println ("updated case #" + results[i]);
			}
		} catch (Exception e) {
			System.out.println ("exception caught" + e);
		}

	}
	public static void main(String[] args) {
		SObject[] acts;
		SObject[] cases;
		SObject[] resultObjs;
		SObject obj;
		String[] results;
		String result;
		String strQuery;

		
		try
		{

			salesforceClient = new SalesforceClient(authEndpoint, enterpriseEndpoint, QCTEndpoint,
					"sheidas@qct.slalom.com.custsb2", "abcd1234");
			System.out.println("\n***logged in, sessionId = " + salesforceClient.getSessionId());
			System.out.println("name: " + salesforceClient.getUserFullName());
			
			System.out.println("\n*** Testing GetEditFields for Account");			
			results = salesforceClient.getEditFields("Account");
			System.out.println ("Number of edit fields: "+ results.length);
			for(int i=0;i<results.length;i++)
			{
				System.out.print( results[i] + "; ");
			}
			System.out.println();
			
			
			System.out.println("\n*** Testing GetReadFields for Case object:");		
			results = salesforceClient.getReadFields("Case");
			System.out.println ("Number of read fields: "+ results.length);

			for(int i=0;i<results.length;i++)
			{
				System.out.print( results[i] + "; ");
			}
			System.out.println();
			

			/****** beginning of the getPicklistValues() test *****/
			System.out.println ("\n****Testing getPicklistValues for Account:AccountSource****");
			results = salesforceClient.getPickListValues("Account", "AccountSource");
			System.out.println ("Number of picklist values: "+ results.length);
			for (int i=0; i<results.length; i++){
				System.out.print ( results[i] + "; ");
			}
			System.out.println();
			
			/****** beginning of the getRecordsAsString test *****/	
			System.out.println ("\n****Testing getRecordsAsStrings****");
			strQuery = "SELECT name FROM Account where Account_Status__c = 'Active'";
			results = salesforceClient.getRecords(strQuery)	;		
			System.out.println ("total number of accounts: " + results.length + ". first two records");
			for (int i=0; i<2; i++){
				System.out.println ("Account # as string" + i + " " + results[i]);
			}			
			
			System.out.println ("\n****Testing updateFields ****");	
			XMLBuilder builder = XMLBuilder.create("Message")
				    .e("SObject").t("Case")                  
			        .up().e("Select").t("select id, Problem_Code_1__c from case where id='500300000066OJg'")
			        .up().e("Problem_Code_1__c").t("666");	
						
			String xtext = builder.asString();

			result = salesforceClient.updateFieldsReturnResultsAsStrings(xtext);
			System.out.println ("updated problem code. Result:" + result);		


			System.out.println ("\n****Testing insertFields ****");	
			builder = XMLBuilder.create("Message")
				    .e("SObject").t("Case")                  
			        .up().e("Select").t("select id, Problem_Code_1__c from case where id='500300000066OJg'")
			        .up().e("Problem_Code_1__c").t("999");	
						
			xtext = builder.asString();
			result = salesforceClient.updateFieldsReturnResultsAsStrings(xtext);
			System.out.println ("Inserted new case. result:" + result);			
			
			
			updateMultipleRecordsTest();
			
			System.out.println("\n*** Logging out");
			salesforceClient.logout();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
