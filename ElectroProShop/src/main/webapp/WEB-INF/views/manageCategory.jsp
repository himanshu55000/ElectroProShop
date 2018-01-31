<%@include file="header.jsp"%>
<br/><br/>
<div class="container">
	<div class="panel-group">
		<div class="panel panel-primary">
						<div class="panel-heading text-center">
			<span style="font-size: 30px">Category Details</span>
			</div>
			<div class="panel-body table-responsive">
				<table class="table table-hover">
					<tr><th>Category Id</th><th>Category Name</th><th>Operation</th></tr>
					<c:forEach items="${catList}" var="category">
						<tr>
							<td>${category.cid}</td><td>${category.categoryName}</td>
							<td>
								<button onclick="setModal(${category.cid},'${category.categoryName}')" class="btn btn-success myBoldFont">Update</button>
								<a href="<c:url value="deleteCategory?id=${category.cid}"/>" class="btn btn-danger myBoldFont">Delete</a>
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
	$("#catModal").modal("show");
}
</script>
<%@include file="footer.jsp"%>