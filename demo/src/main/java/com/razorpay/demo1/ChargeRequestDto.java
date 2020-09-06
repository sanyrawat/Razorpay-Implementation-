package com.razorpay.demo1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/*import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargeRequestDto {

  @JsonProperty("razorpay_payment_id")
  private String razorpayPaymentId;

  @JsonProperty("razorpay_signature")
  private String razorpaySignature;

  @JsonProperty("razorpay_order_id")
  private String razorpayOrderId;

  public ChargeRequestDto() {}
  
public String getRazorpayPaymentId() {
	return razorpayPaymentId;
}

public void setRazorpayPaymentId(String razorpayPaymentId) {
	this.razorpayPaymentId = razorpayPaymentId;
}

public String getRazorpaySignature() {
	return razorpaySignature;
}

public void setRazorpaySignature(String razorpaySignature) {
	this.razorpaySignature = razorpaySignature;
}

public String getRazorpayOrderId() {
	return razorpayOrderId;
}

public void setRazorpayOrderId(String razorpayOrderId) {
	this.razorpayOrderId = razorpayOrderId;
}
  
  
}
