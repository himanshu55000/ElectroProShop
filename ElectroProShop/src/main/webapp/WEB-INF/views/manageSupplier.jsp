<%@include file="header.jsp"%>
<br/><br/>
<div class="container">
	<div class="panel-group">
		<div class="panel panel-primary">
						<div class="panel-heading text-center">
			<span style="font-size: 30px">Supplier Details</span>
			</div>
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
<%@include file="footer.jsp"%>