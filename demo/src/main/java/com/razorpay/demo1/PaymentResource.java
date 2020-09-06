package com.razorpay.demo1;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PaymentResource {

  private PaymentView paymentview;
  private RazorpayClient client;
  private String apiKey = "rzp_test_l5Gwj0beDtUwmM";
  private String secretKey = "JcJHNgodRRWBVlBPn8GNyuFo";
  private int amount = 500;

  public PaymentResource() {
    try {
      this.client = new RazorpayClient(this.apiKey, this.secretKey);
    } catch (RazorpayException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @GetMapping("/")
  public String index(@ModelAttribute("model") ModelMap model) throws RazorpayException {
    JSONObject options = new JSONObject();
    options.put("amount", amount); // Note: The amount should be in paise.
    options.put("currency", "INR");
    options.put("receipt", "txn_123456");
    options.put("payment_capture", 1);
    Order order = client.Orders.create(options);
    model.addAttribute("orders", Arrays.asList((String)order.get("id")));

    return "index";
  }

  @GetMapping("/order")
  public PaymentView getPaymentForm() throws RazorpayException {
    JSONObject options = new JSONObject();
    options.put("amount", amount); // Note: The amount should be in paise.
    options.put("currency", "INR");
    options.put("receipt", "txn_123456");
    options.put("payment_capture", 1);
    Order order = client.Orders.create(options);
    return new PaymentView(amount, (String) order.get("id"));
  }

//  @RequestMapping(path = "/charge", method = RequestMethod.POST)
//  public ResponseEntity getResponse() {
//	  System.out.println(paymentview.amount);
//	  System.out.println(paymentview.id);
//    return ResponseEntity.ok().build();
//  }

  @PostMapping(value = "/payment/charge",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String charge(Map<String, String> formParams) {
    String paymentId = formParams.get("razorpay_payment_id");
    String razorpaySignature = formParams.get("razorpay_signature");
    String orderId = formParams.get("razorpay_order_id");
    JSONObject options = new JSONObject();

    if (!StringUtils.isEmpty(paymentId) && !StringUtils.isEmpty(razorpaySignature)
        && !StringUtils.isEmpty(orderId)) {
      try {
        options.put("razorpay_payment_id", paymentId);
        options.put("razorpay_order_id", orderId);
        options.put("razorpay_signature", razorpaySignature);
        boolean isEqual = Utils.verifyPaymentSignature(options, this.secretKey);

        if (isEqual) {
          return "redirect:/";
        }
      } catch (RazorpayException e) {
        System.out.println("Exception caused because of " + e.getMessage());
        return "redirect:/";
      }
    }
    return "redirect:/";
  }


}
