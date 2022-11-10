package com.deloitte.service;

import java.io.IOException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deloitte.pojo.TUPojo;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;

@Service
public class TUService {
	private static final Logger logger = LoggerFactory.getLogger(TUService.class);
	@Autowired
	private RestTemplate restTemplate;

	public String invokeTUCall(String TURequest) throws StreamReadException, DatabindException, IOException {

//		String xmlString = hardcodedMethodForRequest(); // not used
		logger.info("Inside Service Class *****");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> request1 = new HttpEntity<String>(TURequest, headers);

		String response = restTemplate.postForObject("https://netaccess-test.transunion.com", request1, String.class);

		logger.info("response is *****:: {}", response);
		TUPojo tuPojo = new TUPojo();
		try {
			JSONObject json = XML.toJSONObject(response);
			JsonNode jsonNode = convertJsonFormat(json);
			ObjectMapper mapper = new ObjectMapper();
			tuPojo = mapper.readValue(new TreeTraversingParser(jsonNode), TUPojo.class);
			logger.info("JSON format of xml response ****** :: {}", tuPojo);

		} catch (JSONException e) {

			logger.error("Error triggered ***** ::{} ", e.getMessage());
		}

		return response;
	}

	static JsonNode convertJsonFormat(JSONObject json) {
		ObjectNode ret = JsonNodeFactory.instance.objectNode();

		@SuppressWarnings("unchecked")
		Iterator<String> iterator = json.keys();
		for (; iterator.hasNext();) {
			String key = iterator.next();
			if (!key.contains(":")) {
				Object value;
				try {
					value = json.get(key);
				} catch (JSONException e) {
					throw new RuntimeException(e);
				}
				if (json.isNull(key))
					ret.putNull(key);
				else if (value instanceof String)
					ret.put(key, (String) value);
				else if (value instanceof Integer)
					ret.put(key, (Integer) value);
				else if (value instanceof Long)
					ret.put(key, (Long) value);
				else if (value instanceof Double)
					ret.put(key, (Double) value);
				else if (value instanceof Boolean)
					ret.put(key, (Boolean) value);
				else if (value instanceof JSONObject)
					ret.put(key, convertJsonFormat((JSONObject) value));
				else if (value instanceof JSONArray)
					ret.put(key, convertJsonFormat((JSONArray) value));
				else
					throw new RuntimeException("not prepared for converting instance of class " + value.getClass());
			}

		}
		return ret;
	}

	static JsonNode convertJsonFormat(JSONArray json) {
		ArrayNode ret = JsonNodeFactory.instance.arrayNode();
		for (int i = 0; i < json.length(); i++) {
			Object value;
			try {
				value = json.get(i);
			} catch (JSONException e) {
				throw new RuntimeException(e);
			}
			if (json.isNull(i))
				ret.addNull();
			else if (value instanceof String)
				ret.add((String) value);
			else if (value instanceof Integer)
				ret.add((Integer) value);
			else if (value instanceof Long)
				ret.add((Long) value);
			else if (value instanceof Double)
				ret.add((Double) value);
			else if (value instanceof Boolean)
				ret.add((Boolean) value);
			else if (value instanceof JSONObject)
				ret.add(convertJsonFormat((JSONObject) value));
			else if (value instanceof JSONArray)
				ret.add(convertJsonFormat((JSONArray) value));
			else
				throw new RuntimeException("not prepared for converting instance of class " + value.getClass());
		}
		return ret;
	}

	private String hardcodedMethodForRequest() {
		String xmlString = "<?xml version='1.0' encoding='UTF-8'?>\r\n"
				+ "<creditBureau xmlns=\"http://www.transunion.com/namespace\" xsi:schemaLocation=\"http://www.transunion.com/namespace file:///H:/TUXML/tuxml_v2.25.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n"
				+ "	<document>request</document>\r\n" + "	<version>2.33</version>\r\n"
				+ "	<transactionControl>\r\n" + "		<userRefNumber>TEST1</userRefNumber>\r\n"
				+ "		<subscriber>\r\n" + "			<industryCode>I</industryCode>\r\n"
				+ "			<memberCode>4695427</memberCode>\r\n"
				+ "			<inquirySubscriberPrefixCode>0622</inquirySubscriberPrefixCode>\r\n"
				+ "			<password>K3M3</password>\r\n" + "		</subscriber>\r\n" + "		<options>\r\n"
				+ "			<processingEnvironment>standardTest</processingEnvironment>\r\n"
				+ "			<country>us</country>\r\n" + "			<language>en</language>\r\n"
				+ "			<contractualRelationship>individual</contractualRelationship>\r\n"
				+ "			<pointOfSaleIndicator>none</pointOfSaleIndicator>\r\n" + "		</options>\r\n"
				+ "		<identity>\r\n" + "			<type>vendorUserID</type>\r\n"
				+ "			<value>737FF289-7C89-4B10-A121-193DC83A9852</value>\r\n" + "		</identity>\r\n"
				+ "	</transactionControl>\r\n" + "	<product>\r\n" + "		<code>07955</code>\r\n"
				+ "		<custom>\r\n" + "			<driverRisk>\r\n"
				+ "				<issuanceState>FL</issuanceState>\r\n" + "			</driverRisk>\r\n"
				+ "		</custom>\r\n" + "		<subject>\r\n" + "			<number>1</number>\r\n"
				+ "			<subjectRecord>\r\n" + "				<indicative>\r\n" + "					<name>\r\n"
				+ "						<person>\r\n" + "							<first>ANITA</first>\r\n"
				+ "							<last>PEREZ</last>\r\n" + "						</person>\r\n"
				+ "					</name>\r\n" + "					<address>\r\n"
				+ "						<status>current</status>\r\n" + "						<street>\r\n"
				+ "							<unparsed>33 CENTENNIAL</unparsed>\r\n"
				+ "						</street>\r\n" + "						<location>\r\n"
				+ "							<city>FAIRBANKS</city>\r\n"
				+ "							<state>FL</state>\r\n"
				+ "							<zipCode>99283</zipCode>\r\n" + "						</location>\r\n"
				+ "					</address>\r\n" + "					<dateOfBirth>1980-10-10</dateOfBirth>\r\n"
				+ "					<driversLicense>\r\n" + "						<number>1827445</number>\r\n"
				+ "						<issuanceState>FL</issuanceState>\r\n"
				+ "					</driversLicense>\r\n" + "				</indicative>\r\n"
				+ "				<addOnProduct>\r\n" + "					<code>07956</code>\r\n"
				+ "				</addOnProduct>\r\n" + "				<addOnProduct>\r\n"
				+ "					<code>07958</code>\r\n" + "				</addOnProduct>\r\n"
				+ "			</subjectRecord>\r\n" + "		</subject>\r\n" + "		<permissiblePurpose>\r\n"
				+ "			<code>IN</code>\r\n" + "		</permissiblePurpose>\r\n" + "	</product>\r\n"
				+ "</creditBureau>										\r\n" + "";
		return xmlString;
	}

}
