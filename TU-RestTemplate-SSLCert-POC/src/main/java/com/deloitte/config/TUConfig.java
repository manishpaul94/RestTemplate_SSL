package com.deloitte.config;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import com.deloitte.service.TUService;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

@Configuration
public class TUConfig {
	private static final Logger logger = LoggerFactory.getLogger(TUConfig.class);
	@Value("${trust-store}")
	private String trustStore;

	@Value("${trust-store-password}")
	private String trustStorePassword;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder)
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, CertificateException,
			MalformedURLException, IOException, UnrecoverableKeyException {

		logger.info("Config file is loading*****");
		/*
		 * SSLContext sslContext = new SSLContextBuilder()
		 * .loadTrustMaterial(ResourceUtils.getFile("classpath:BUCKLESE_SHA2.p12"),
		 * "12Buck13".toCharArray()).build(); SSLConnectionSocketFactory sslConFactory =
		 * new SSLConnectionSocketFactory(sslContext);
		 * 
		 * CloseableHttpClient httpClient =
		 * HttpClients.custom().setSSLSocketFactory(sslConFactory).build();
		 * ClientHttpRequestFactory requestFactory = new
		 * HttpComponentsClientHttpRequestFactory(httpClient); RestTemplate restTemplate
		 * = new RestTemplate(requestFactory);
		 * 
		 * return restTemplate;
		 */
		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

		final SSLContext sslContext;
		try {
			sslContext = SSLContextBuilder.create()
					.loadKeyMaterial(keyStore(trustStore, trustStorePassword.toCharArray()),
							trustStorePassword.toCharArray())
					.loadTrustMaterial(null, acceptingTrustStrategy)
//					.setProtocol("TLSv1.2")
					.build();
		} catch (Exception e) {
			throw new IllegalStateException("Failed to setup client SSL context", e);
		} finally {
			// it's good security practice to zero out passwords, which is why they're
			// char[]
			Arrays.fill(trustStorePassword.toCharArray(), (char) 0);
		}

		final HttpClient httpClient = HttpClientBuilder.create().setSSLContext(sslContext).build();

		/*
		 * final ClientHttpRequestFactory requestFactory = new
		 * HttpComponentsClientHttpRequestFactory(httpClient);
		 */

		return builder.requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient)).build();
//		ignoreCertificates();
//		return new RestTemplate();

	}

	private KeyStore keyStore(String file, char[] password) throws Exception {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		File key = ResourceUtils.getFile(file);
		try (InputStream in = new FileInputStream(key)) {
			keyStore.load(in, password);
		}
		return keyStore;
	}

	/*
	 * private void ignoreCertificates() { TrustManager[] trustAllCerts = new
	 * TrustManager[]{new X509TrustManager() {
	 * 
	 * @Override public X509Certificate[] getAcceptedIssuers() { return null; }
	 * 
	 * @Override public void checkClientTrusted(X509Certificate[] certs, String
	 * authType) { }
	 * 
	 * @Override public void checkServerTrusted(X509Certificate[] certs, String
	 * authType) { } }};
	 * 
	 * try { SSLContext sc = SSLContext.getInstance("TLS"); sc.init(null,
	 * trustAllCerts, new SecureRandom());
	 * HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory()); } catch
	 * (Exception e) {
	 * 
	 * 
	 * } }
	 */

}
