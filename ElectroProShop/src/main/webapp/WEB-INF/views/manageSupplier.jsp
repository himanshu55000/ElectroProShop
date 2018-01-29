<%@include file="header.jsp"%>
<br/><br/>
<div id="supModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body" style="padding:50px;border:10px solid green">
			<form id="frm1" action="updateSupplier" method="post" class="form-inline">
			<input name="id" type="hidden"/>
			<span style="font-size: 20px">Enter Supplier Name : </span>
			<input name="name" class="form-control"/><br/><br/>
			<button type="submit" class="btn btn-success btn-block">add</button>
			</form>
      </div>
     </div>

  </div>
</div>
<div class="container">
	<div class="panel-group">
		<div class="panel panel-primary">
			<div class="panel-heading">
			<div class="row">
			<div class="col-sm-6">
						<span style="font-size: 30px">Supplier Details</span>
			</div>
			<div class="col-sm-6">
			<form action="addSupplier" method="post" class="form-inline">
			<span style="font-size: 20px">Enter Supplier Name : </span><input name="name" class="form-control"/>
			<button type="submit" class="btn btn-success">add</button>
			</form>
			</div>
			</div></div>
			<div class="panel-body table-responsive">
				<table class="table table-hover">
					<tr><th>SupId</th><th>Supplier Name</th><th>Operation</th></tr>
					<c:forEach items="${supList}" var="supplier">
						<tr>
							<td>${supplier.sid}</td><td>${supplier.supplierName}</td>
							<td>
								<button onclick="setModal(${supplier.sid},'${supplier.supplierName}')" class="btn btn-success myBoldFont">Update</button>
								<a href="<c:url value="deleteSupplier?id=${supplier.sid}"/>" class="btn btn-danger myBoldFont">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div><br/><br/>
<script>
var setModal=function(id,name){
	document.forms["frm1"].elements[0].value=id;
	document.forms["frm1"].elements[1].value=name;
	$("#supModal").modal("show");
}
</script>
<%@include file="footer.jsp"%>