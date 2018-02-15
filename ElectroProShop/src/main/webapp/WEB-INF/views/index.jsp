<%@include file="header.jsp"%>
<div class="container-fluid" style="padding: 0">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner">
			<div class="item active">
				<img src="${e}resources/images/Slide1.jpg" alt="slide1">
			</div>

			<div class="item">
				<img src="${e}resources/images/Slide2.jpg" alt="slide2">
			</div>

			<div class="item">
				<img src="${e}resources/images/Slide3.jpg" alt="slide3">
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>

	</div>

</div>
<br />
<br />
<br />
<div class="container">
	<div class="col-sm-6">
		<img src="<c:url value="/resources/images/hdd1.jpg"/>"
			style="width: 100%" />
	</div>
	<div class="col-sm-6">
		<img src="<c:url value="/resources/images/hdd2.jpg"/>"
			style="width: 100%" />
	</div>
</div>
<br />
<br />
<br />
<%@include file="footer.jsp"%>