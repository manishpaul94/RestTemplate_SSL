package com.deloitte.config;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TUConfig {

	
	@Bean
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException,
			CertificateException, MalformedURLException, IOException {
System.out.println("Config file is loading");
		SSLContext sslContext = new SSLContextBuilder()
				.loadTrustMaterial(new URL("file:src/main/resources/BUCKLESE_SHA2.p12"), "12Buck13".toCharArray()).build();
		SSLConnectionSocketFactory sslConFactory = new SSLConnectionSocketFactory(sslContext);

		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConFactory).build();
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		return restTemplate;

	}

}
