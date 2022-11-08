package com.deloitte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deloitte.pojo.TUPojo;

@Service
public class TUService {

	@Autowired
	private RestTemplate restTemplate;

	public TUPojo invokeTUCall() {

		String xmlString = "<?xml version='1.0' encoding='UTF-8'?>\r\n"
				+ "<creditBureau xmlns=\"http://www.transunion.com/namespace\" xsi:schemaLocation=\"http://www.transunion.com/namespace file:///H:/TUXML/tuxml_v2.25.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n"
				+ "	<document>request</document>\r\n" + "	<version>2.33</version>\r\n"
				+ "	<transactionControl>\r\n" + "		<userRefNumber>TEST1</userRefNumber>\r\n"
				+ "		<subscriber>\r\n" + "			<industryCode>I</industryCode>\r\n"
				+ "			<memberCode>4695427</memberCode>\r\n"
				+ "			<inquirySubscriberPrefixCode>0622</inquirySubscriberPrefixCode>\r\n"
				+ "			<password>PSWD</password>\r\n" + "		</subscriber>\r\n" + "		<options>\r\n"
				+ "			<processingEnvironment>standardTest</processingEnvironment>\r\n"
				+ "			<country>us</country>\r\n" + "			<language>en</language>\r\n"
				+ "			<contractualRelationship>individual</contractualRelationship>\r\n"
				+ "			<pointOfSaleIndicator>none</pointOfSaleIndicator>\r\n" + "		</options>\r\n"
				+ "		<identity>\r\n" + "			<type>vendorUserID</type>\r\n"
				+ "			<value>737FF289-7C89-4B10-A121-193DC83A9852</value>\r\n" + "		</identity>\r\n"
				+ "	</transactionControl>\r\n" + "	<product>\r\n" + "		<code>07955</code>\r\n"
				+ "		<custom>\r\n" + "			<driverRisk>\r\n"
				+ "				<issuanceState>AK</issuanceState>\r\n" + "			</driverRisk>\r\n"
				+ "		</custom>\r\n" + "		<subject>\r\n" + "			<number>1</number>\r\n"
				+ "			<subjectRecord>\r\n" + "				<indicative>\r\n" + "					<name>\r\n"
				+ "						<person>\r\n" + "							<first>ANITA</first>\r\n"
				+ "							<last>PEREZ</last>\r\n" + "						</person>\r\n"
				+ "					</name>\r\n" + "					<address>\r\n"
				+ "						<status>current</status>\r\n" + "						<street>\r\n"
				+ "							<unparsed>33 CENTENNIAL</unparsed>\r\n"
				+ "						</street>\r\n" + "						<location>\r\n"
				+ "							<city>FAIRBANKS</city>\r\n"
				+ "							<state>AK</state>\r\n"
				+ "							<zipCode>99283</zipCode>\r\n" + "						</location>\r\n"
				+ "					</address>\r\n" + "					<dateOfBirth>1980-10-10</dateOfBirth>\r\n"
				+ "					<driversLicense>\r\n" + "						<number>1827445</number>\r\n"
				+ "						<issuanceState>AK</issuanceState>\r\n"
				+ "					</driversLicense>\r\n" + "				</indicative>\r\n"
				+ "				<addOnProduct>\r\n" + "					<code>07956</code>\r\n"
				+ "				</addOnProduct>\r\n" + "				<addOnProduct>\r\n"
				+ "					<code>07958</code>\r\n" + "				</addOnProduct>\r\n"
				+ "			</subjectRecord>\r\n" + "		</subject>\r\n" + "		<permissiblePurpose>\r\n"
				+ "			<code>IN</code>\r\n" + "		</permissiblePurpose>\r\n" + "	</product>\r\n"
				+ "</creditBureau>										\r\n" + "";

//	    //Create a list for the message converters
//	    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//	    //Add the String Message converter
//	    messageConverters.add(new StringHttpMessageConverter());
//	    //Add the message converters to the restTemplate
//	    restTemplate.setMessageConverters(messageConverters);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> request1 = new HttpEntity<String>(xmlString, headers);

		String response = restTemplate.postForObject("https://netaccess-test.transunion.com", request1, String.class);

		System.out.println("response is ************************" + response);

		return null;
	}

}
