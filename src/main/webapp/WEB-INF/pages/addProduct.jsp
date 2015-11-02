<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							<li class="active"><a href="#productList">New Product
									Form</a></li>
						</ul>
					</div>
					<div class="tab-content">
						<form:form method="POST" action="/testProject/add"
							commandName="product">
							<table>
								<tr>
									<td><form:label path="productName">
											<fmt:message key="add.product.form.product" />
										</form:label>
									</td>
									<td><form:input path="productName" />
									</td>
								</tr>
								<tr>
									<td><label><fmt:message
												key="add.product.form.usedby" /> </label>
									</td>
									<td><form:radiobutton path="gender" VALUE="m" /> <fmt:message
											key="add.product.form.usedby.male" /><BR> <form:radiobutton
											path="gender" VALUE="f" /> <fmt:message
											key="add.product.form.usedby.male" /><BR> <form:radiobutton
											path="gender" VALUE="" /> <fmt:message
											key="add.product.form.usedby.both" /></td>
								</tr>
								<tr>
									<td><form:label path="description">
											<fmt:message key="add.product.form.description" />
										</form:label>
									</td>
									<td><form:textarea rows="5" path="description" />
									</td>
								</tr>

								<tr>
									<td><form:label path="category.categoryId">
											<fmt:message key="add.product.form.category" />
										</form:label>
									</td>
									<td><form:select path="category.categoryId">
											<form:options items="${sessionScope.categories}" />
										</form:select></td>
								</tr>

								<tr>
									<td><form:label path="manufacturer.manufacturerId">
											<fmt:message key="add.product.form.manufacturer" />
										</form:label>
									</td>
									<td><form:select path="manufacturer.manufacturerId">
											<form:options items="${sessionScope.manufacturers}" />
										</form:select></td>
								</tr>
								<tr>
									<td><form:label path="price">
											<fmt:message key="add.product.form.price" />
										</form:label>
									</td>
									<td><form:input path="price" />
									</td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit"
										value="<fmt:message key="add.product.form.add" />" />
									</td>
								</tr>
							</table>
						</form:form>

					</div>
				</div>
				<!--/category-tab-->

			</div>
		</div>
	</div>

	<%@include file="template/footer.jsp"%>

</body>
</html>