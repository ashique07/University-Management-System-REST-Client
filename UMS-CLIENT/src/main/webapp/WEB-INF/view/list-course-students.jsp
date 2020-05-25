<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>

<title>Students in ${course.title} course</title>

<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
User: <strong><security:authentication property="principal.username"/></strong>
<br>
<input class="add-button" type="submit" value="Logout"/>
</form:form>

<div id="wrapper">
<div id="header">

<h2>Students in ${course.title} course</h2>

</div>
</div>

<div id="container">
<div id="content">

<!-- ADD HTML TABLE HERE -->

<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
	</tr>
	
	<!-- LOOP OVER EACH AND PRINT INSTRUCTOR -->
	<c:forEach var="tempStudent" items="${students}">
	
	<tr>
		<td>${tempStudent.firstName}</td>
		<td>${tempStudent.lastName}</td>
		<td>${tempStudent.email}</td>
		
	</tr>

	</c:forEach>
	
</table>

</div>
</div>

<div style="clear;both;"> 

<p>
<a href="${pageContext.request.contextPath}/course/list">BACK TO ALL COURSES</a>
</p>

</div>

</body>

<footer>
  <p>Developer: Ashique Mohaimin Ornab</p>
  <p><a href="mailto:hege@example.com">amornab@gmail.com</a></p>
</footer> 

</html>