<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@include file="header.jsp" %>
<style>
#proImg{
    height:450px;
}
#proImg img{
    -webkit-transition: all 1s;
    -moz-transition: all 1s;
    -o-transition: all 1s;
    -ms-transition: all 1s;
    transition: all 1s;
    height:72%;
}
#proImg:HOVER img{height:80%;
    -webkit-transition: all 1s;
    -moz-transition: all 1s;
    -o-transition: all 1s;
    -ms-transition: all 1s;
    transition: all 1s;
}
.caption{
bottom: 0;position:absolute;width:98%;
}
.proTitle{color:blue;}
</style>
<div class="container" style="background: #fff">
<br/><br/><br/><div class="col-sm-4 thumbnail" id="proImg">
<img src='<c:url value="/resources/images/${product.imageName}"/>' alt="${product.proName}" />
 <div class="caption">
          <a href="${e}addToCart/${product.proId}" class="btn btn-danger btn-block myBoldFont"><h4><span class="glyphicon glyphicon-shopping-cart"></span> Add To Cart</h4></a>
        </div>
</div>
<div class="col-sm-8">
<div class="panel panel-default">
  <div class="panel-heading proTitle"><h2><b>${product.proName}</b></h2></div>
  <div class="panel-body"><h2><i class="fa fa-inr"></i><b>${product.proPrice}</b></h2>
  <br/>
  <h4><b>Seller : </b>${product.supplier.supplierName}</h4>
  <br/>
  <h4><b>Category : </b>${product.supplier.supplierName}</h4>
  <br/>
  <h4><b>Cash On Delevery : </b>Eligible</h4>
  <br/>
  <h4><b>Ratings : </b><img src="${e}resources/images/rate.png" width="250"/></h4>
  </div>
</div> 
  </div>
  <div class="panel panel-default col-sm-12">
  <div class="panel-heading"><h3>Product Description</h3></div>
  <div class="panel-body">
  <h3><ul>
  <c:forEach items="${fn:split(product.proDesc, ',')}" var="line">
  <li>${line}</li><br/>
  </c:forEach>
  </ul></h3>
  </div>
</div>
 
</div>
<%@include file="footer.jsp"%>