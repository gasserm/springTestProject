<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="messages" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home | E-Shopper</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">

<script type="text/javascript">
	function deleteProduct(prodId) {
		var result = confirm("are you sur to delete this product " + prodId);
		if (result) {
			window.location.href = '/testProject/delete/' + prodId;
		}
	}

	function editProduct(prodId) {
		window.location.href = '/testProject/edit/' + prodId;
	}
</script>
</head>
<!--/head-->
<body>
	<%@include file="template/masthead.jsp"%>

	<section id="slider"><!--slider-->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div id="slider-carousel" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="item active">
							<div class="col-sm-6">
								<h1>
									<span>E</span>-SHOPPER
								</h1>
								<h2>Free E-Commerce Template</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna
									aliqua.</p>
							</div>
						</div>

					</div>

				</div>

			</div>
		</div>
	</div>
	</section>
	<!--/slider-->

	<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<%@include file="template/leftNav.jsp"%>
			</div>

			<div class="col-sm-9 padding-right">

				<div class="category-tab">
					<!--category-tab-->
					<div class="col-sm-12">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#productList" data-toggle="tab">Products</a>
							</li>
						</ul>
					</div>
					<div class="tab-content">
						<div class="tab-pane fade active in" id="#productList">
							<c:forEach items="${products}" var="product">
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="images/home/gallery1.jpg" alt="" />
												<h2>$${product.price}</h2>
												<p>${product.name}</p>
												<p>${product.gender}</p>
												<a href="#"
													onclick="javascript:editProduct('${product.id}')">edit</a>
												| <a href="#"
													onclick="javascript:deleteProduct('${product.id}')">delete</a>
											</div>

										</div>
									</div>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>
				<!--/category-tab-->

			</div>
		</div>
	</div>
	</section>

	<%@include file="template/footer.jsp"%>

</body>
</html>