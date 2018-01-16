<%@include file="header.jsp" %>
<div class="container-fluid" style="padding:0">
<div class="carousel slide" data-ride="carousel">
	<div class="carousel-inner">
    <div class="item active">
      <img src="${e}resources/images/slide1.jpg" alt="slide1">
    </div>

    <div class="item">
      <img src="${e}resources/images/slide2.jpg" alt="slide2">
    </div>

    <div class="item">
      <img src="${e}resources/images/slide3.jpg" alt="slide3">
    </div>
  </div>
</div>
</div><br/>
<div class="container">
<div class="row">
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="#">
        <img src="${e}resources/images/slide1.jpg" alt="Image 1" style="width:100%">
        <div class="caption">
          <p>Image 1</p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="#">
        <img src="${e}resources/images/slide2.jpg" alt="Image 2" style="width:100%">
        <div class="caption">
          <p>Image 2</p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="#">
        <img src="${e}resources/images/slide3.jpg" alt="Image 3" style="width:100%">
        <div class="caption">
          <p>Image 3</p>
        </div>
      </a>
    </div>
  </div>
</div></div>
<div class="container-fluid text-center">
<span style="font-size:10vw;"><c:out value=" This Is Home"/></span>
</div>

<%@include file="footer.jsp" %>