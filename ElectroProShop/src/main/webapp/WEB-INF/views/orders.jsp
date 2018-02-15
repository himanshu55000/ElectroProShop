<%@include file="header.jsp" %>
<style>
td,th,input{font-size: 1.2em;}
.thumbnail{height:250px;}
</style>
<br/><br/><br/>
<div class="container"  style="background: #fff">
<br/>
<div class="list-group-item list-group-item-info">
<center><h2><b>My Orders</b></h2></center></div>
<c:if test="${orderList.size()==0}">
<br/><center><h2><b>Nothing to Show</b></h2></center>
</c:if>
<c:forEach items="${orderList}" var="orderItem">
<br/>
<div style="box-shadow:0 0 10px grey;" class="table-responsive">
<div class="thumbnail col-sm-4">
<a href=""><img src='${e}resources/images/${orderItem.orderImage}' alt="${orderItem.orderProductName}" style="height:100%;"/>
</a></div><div class="col-sm-8">
<table class="table">
<tr><td>
	<h3>${orderItem.orderProductName}</h3>
	</td>
	<td><h3>Order Id : ${orderItem.orderId}</h3></td>
	</tr>
  <tr><td colspan="2"><h4><b>Quantity : ${orderItem.orderQuantity}</b></h4></td></tr>
<tr><td><b>Payment : </b>${orderItem.payMode}</td><td><b>Amount : <i class="fa fa-inr"></i>${orderItem.orderPrice}</b>
  </td></tr>
  <tr><td colspan="2">
  <address>
<b>Address : </b><br> 
${orderItem.shippingAddress.house_locality}, ${orderItem.shippingAddress.city}<br>
${orderItem.shippingAddress.state} - ${orderItem.shippingAddress.pincode}<br>
</address>
  <td></tr>
  </table></div></div>
</c:forEach>
</div><br/>
<%@include file="footer.jsp"%>