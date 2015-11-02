<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="messages" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home | E-Shopper</title>
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/css/font-awesome.min.css'/>" rel="stylesheet">
<link href="<c:url value='/css/prettyPhoto.css'/>" rel="stylesheet">
<link href="<c:url value='/css/price-range.css'/>" rel="stylesheet">
<link href="<c:url value='/css/animate.css'/>" rel="stylesheet">
<link href="<c:url value='/css/main.css'/>" rel="stylesheet">
<link href="<c:url value='/css/responsive.css'/>" rel="stylesheet">

</head>
<!--/head-->
<body>
	<%@include file="template/masthead.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div id="slider-carousel" class="carousel slide">
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

	<div class="container">
		<div class="row">
			<%-- <div class="col-sm-3">
				<%@include file="template/leftNav.jsp"%>
			</div> --%>

			<div class="col-sm-9 padding-right">

				<div class="category-tab">
					<!--category-tab-->
					<div class="col-sm-12">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#productList">Edit Product</a>
							</li>
						</ul>
					</div>
					<div class="tab-content">
						<form method="POST" action="/testProject/edit">
							<input name="productId" type="hidden"
								value="${product.productId }">
							<table>
								<tr>
									<td><label><fmt:message
												key="display.results.product.name" /> </label>
									</td>
									<td><input name="productName"
										value="${product.productName}" /></td>
								</tr>
								<tr>
									<td><label><fmt:message
												key="add.product.form.usedby" /> </label>
									</td>
									<td><input TYPE="radio" name="gender" VALUE="m"
										${product.gender== 'm'?'checked':''} /> <fmt:message
											key="add.product.form.usedby.male" /> <BR> <input
										TYPE="radio" name="gender" VALUE="f" ${product.gender== 'f'?'checked':''} />
										<fmt:message key="add.product.form.usedby.female" /> <BR>
										<input TYPE="radio" name="gender" VALUE="" ${product.gender== ''?'checked':''} />
										<fmt:message key="add.product.form.usedby.both" /></td>
								</tr>

								<tr>
									<td><label><fmt:message
												key="add.product.form.price" /> </label>
									</td>
									<td><input name="price" value="${product.price}" />
									</td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit"
										value="<fmt:message key="edit.product.form.save" />" />
									</td>
								</tr>
							</table>
						</form>

					</div>
				</div>
				<!--/category-tab-->

			</div>
		</div>
	</div>

	<%@include file="template/footer.jsp"%>

</body>
</html>