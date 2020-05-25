<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
	<title>Registration Confirmation</title>
	
	<style>
	footer {
  display: block;
}
</style>
</head>

<body>

	<h2>User registered successfully!</h2>

	<hr>
	
	<a href="${pageContext.request.contextPath}/showMyLoginPage">Login with new user</a>	 
	
</body>

</html>