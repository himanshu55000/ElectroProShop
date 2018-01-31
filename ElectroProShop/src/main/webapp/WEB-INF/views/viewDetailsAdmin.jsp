<%@include file="header.jsp"%>
<br/><br/>
<div id="catModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body" style="padding:50px;border:10px solid green">
		    <center><h2>Update Category</h2></center><br/>
			<form id="frm1" action="updateCategory" method="post" class="form-inline">
			<input name="id" type="hidden"/>
			<span style="font-size: 20px">Enter Category Name : </span>
			<input name="name" class="form-control"/><br/><br/>
			<button type="submit" class="btn btn-success btn-block">Update</button>
			</form>
      </div>
     </div>

  </div>
</div>
<div id="supModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body" style="padding:50px;border:10px solid green">
			<center><h2>Update Supplier</h2></center><br/>
			<form id="frm2" action="updateSupplier" method="post" class="form-inline">
			<input name="id" type="hidden"/>
			<span style="font-size: 20px">Enter Supplier Name : </span>
			<input name="name" class="form-control"/><br/><br/>
			<button type="submit" class="btn btn-success btn-block">Update</button>
			</form>
      </div>
     </div>

  </div>
</div>

<div class="container">
	<div class="panel-group">
		<div class="panel panel-primary">
			<div class="panel-heading text-center">
						<span style="font-size: 30px">View Details</span>
			</div>
			<div class="panel-body table-responsive">
<ul class="nav nav-tabs nav-justified">
  <li class="active"><a data-toggle="tab" href="#product"><h3>Product</h3></a></li>
  <li><a data-toggle="tab" href="#category"><h3>Category</h3></a></li>
  <li><a data-toggle="tab" href="#supplier"><h3>Supplier</h3></a></li>
</ul>

<div class="tab-content">
  <div id="product" class="tab-pane fade in active">
    <br/>
   <div class="modal-body col-sm-offset-2 col-sm-8" style="border:10px solid green">
		    <center><h2>Product Details</h2></center><br/>
			<h3>Product Details goes here</h3>
      </div>
  </div>
  <div id="category" class="tab-pane fade">
  <br/>
   <div class="modal-body col-sm-offset-1 col-sm-10" style="border:10px solid green">
		    <center><h2>Category Details</h2></center><br/>
				<table class="table table-hover">
					<tr><th>Category Id</th><th>Category Name</th><th>Operation</th></tr>
					<c:forEach items="${catList}" var="category">
						<tr>
							<td>${category.cid}</td><td>${category.categoryName}</td>
							<td>
								<button onclick="setCatModal(${category.cid},'${category.categoryName}')" class="btn btn-success myBoldFont">Update</button>
								<a href="<c:url value="deleteCategory?id=${category.cid}"/>" class="btn btn-danger myBoldFont">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
      </div>
  </div>
  <div id="supplier" class="tab-pane fade">
<br/>
   <div class="modal-body col-sm-offset-1 col-sm-10" style="border:10px solid green">
		    <center><h2>Supplier Details</h2></center><br/>
      <table class="table table-hover">
					<tr><th>SupId</th><th>Supplier Name</th><th>Operation</th></tr>
					<c:forEach items="${supList}" var="supplier">
						<tr>
							<td>${supplier.sid}</td><td>${supplier.supplierName}</td>
							<td>
								<button onclick="setSupModal(${supplier.sid},'${supplier.supplierName}')" class="btn btn-success myBoldFont">Update</button>
								<a href="<c:url value="deleteSupplier?id=${supplier.sid}"/>" class="btn btn-danger myBoldFont">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
      </div>
    </div>
</div>
			</div>
		</div>
	</div>
</div><br/><br/>
<script>
var setCatModal=function(id,name){
	document.forms["frm1"].elements[0].value=id;
	document.forms["frm1"].elements[1].value=name;
	$("#catModal").modal("show");
}
var setSupModal=function(id,name){
	document.forms["frm2"].elements[0].value=id;
	document.forms["frm2"].elements[1].value=name;
	$("#supModal").modal("show");
}
</script>
<%@include file="footer.jsp"%>
