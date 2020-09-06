package com.razorpay.demo1;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {
	
	private String apiKey;

	  private String secretKey;

	  public String getApiKey() {
	    return apiKey;
	  }

	  public String getSecretKey() {
	    return secretKey;
	  }

}
