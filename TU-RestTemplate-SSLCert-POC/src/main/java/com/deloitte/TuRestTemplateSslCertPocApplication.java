package com.deloitte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TuRestTemplateSslCertPocApplication {

	public static void main(String[] args) {
//		System.setProperty("javax.net.ssl.trustStore","C:\\Users\\manipaul\\Downloads\\TU Info\\BUCKLESE_SHA2.p12");
//        System.setProperty("javax.net.ssl.trustStorePassword","12Buck13");
		SpringApplication.run(TuRestTemplateSslCertPocApplication.class, args);
	}

}
