<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="messages" />
<html>
<head>
<title><fmt:message key="login.page.title" />
</title>
<link href="<c:url value='/css/style.css'/>" rel='stylesheet'
	type='text/css'>
</head>
<body>
	<div class="logo"></div>
	<div class="login-block">
		<h1><fmt:message key="login.form.title" /></h1>

		<c:if test="${not empty error}">
			<h3>
				Your login attempt was not successful due to <br /> <br />
			</h3>
		</c:if>
		<form name="login" method="post"
			action="/testProject/j_spring_security_check">

			<input type="text" value="" id="j_username" name="j_username" /> <input
				type="password" value="" id="j_password" name="j_password" /> <input
				type="submit" value="<fmt:message key="login.page.submit" />"
				id="loginButton" />

		</form>
	</div>
</body>
</html>