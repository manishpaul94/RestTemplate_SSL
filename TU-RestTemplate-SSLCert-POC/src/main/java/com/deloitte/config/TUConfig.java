package com.deloitte.config;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TUConfig {
	
//
//    @Bean
//    RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder
//               .requestFactory(() -> validateSSL())
//                .build();
//    }
//    
//
//    private HttpComponentsClientHttpRequestFactory validateSSL(){
//        String location = "C:\\Users\\manipaul\\Downloads\\TU Info\\BUCKLESE_SHA2.p12";
//        String pass = "12Buck13";
//        SSLContext sslContext = null;
//        try {
//        	sslContext = SSLContext.getInstance("TLSv1.2");
//		} catch (NoSuchAlgorithmException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        try{
//            sslContext = SSLContextBuilder
//                    .create()
//                    .loadTrustMaterial(ResourceUtils.getFile(location), pass.toCharArray())
//                    .build();
//           
//            
//        }catch (Exception e){
//System.out.println("message is : " + e.getMessage());
//        }
//        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext,new LocalHostnameVerifier());
//        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//
//        return requestFactory;
//    }
//
//    private class LocalHostnameVerifier implements HostnameVerifier {
//        @Override
//        public boolean verify(String s, SSLSession sslSession) {
//            return "localhost".equalsIgnoreCase(s) || "127.0.0.1".equals(s);
//        }
//    }
	
	@Bean
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException,
			CertificateException, MalformedURLException, IOException {

		SSLContext sslContext = new SSLContextBuilder()
				.loadTrustMaterial(new URL("file:src/main/resources/BUCKLESE_SHA2.p12"), "12Buck13".toCharArray()).build();
		SSLConnectionSocketFactory sslConFactory = new SSLConnectionSocketFactory(sslContext);

		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConFactory).build();
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		return restTemplate;

	}

}
