<%@include file="header.jsp"%>
<div class="container">
<br/><center>
<div class="col-sm-offset-3 col-sm-6" style="box-shadow:0 0 10px grey;padding:16px;margin-bottom:25px;">
<img src="<c:url value="/resources/images/ordersuccess.png"/>" height=200 width=200/>
<h1><b>Order Placed Successfully</b></h1><br/>
<i><h2>Thank You For Choosing us</h2></i> <br/>
<div class="col-sm-5">
<a href="${e}" class="btn btn-success btn-block">Continue Shopping....</a>
</div>
<div class="col-sm-offset-2 col-sm-5">
<a href="${e}user/myOrders" class="btn btn-success btn-block">View Orders</a>
</div>
</div>
</center>
</div>
<%@include file="footer.jsp"%>
