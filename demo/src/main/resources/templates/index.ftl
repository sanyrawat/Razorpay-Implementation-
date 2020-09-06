<html>
<head lang="en">
    <meta charset="utf-8">
</head>
<body>
<#list model["orders"] as order>
<div>
<form action="/payment/charge" method="POST">
    <script
            src="https://checkout.razorpay.com/v1/checkout.js"
            data-key="rzp_test_l5Gwj0beDtUwmM"
            data-amount=${500}
            data-order_id="${order}"
            data-name="Daft Punk"
            data-description="Purchase Description"
            data-image="vk.jpg"
            data-netbanking="true"
            data-description="Tron Legacy"
            data-prefill.name="Harshil Mathur"
            data-prefill.email="harshil@razorpay.com"
            data-prefill.contact="9999999999"
            data-notes.shopping_order_id="22">
    </script>
    <input type="hidden" name="shopping_order_id" value="22">
</form>
</div>
</#list>


</body>
</html>