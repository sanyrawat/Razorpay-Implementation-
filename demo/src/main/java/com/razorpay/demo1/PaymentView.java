package com.razorpay.demo1;



/*import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor*/
public class PaymentView {
	
  int amount=500;
  String id;
  
  public PaymentView(int amount, String id) {
	  
	  this.amount=amount;
	  this.id=id;
  }
  
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}


}
