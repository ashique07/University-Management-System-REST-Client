<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>

<title>Save Student</title>

<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
		
		<style>.error{color:red}</style>

</head>

<body>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
User: <strong><security:authentication property="principal.username"/></strong>
<br>
<input class="add-button" type="submit" value="Logout"/>
</form:form>

<div id="wrapper">
<div id="header">

<h2>SAVE STUDENT</h2>

</div>
</div>

<div id="container">
<h3>Save Student</h3>

<form:form action="saveStudent" modelAttribute="student" method="POST">

<!-- Need associated FORM DATA's INSTRUCTOR ID (will call student.getId() and then student.setId()) -->
<form:hidden path="id"/>

<table>
	<tbody>

		<tr>
		<td><label>First Name: </label></td>
		<td><form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></td>
		</tr>
	
		<tr>
		<td><label>Last Name: </label></td>
		<td><form:input path="lastName"/></td>
		</tr>
	
		<tr>
		<td><label>Email: </label></td>
		<td><form:input path="email"/><form:errors path="email" cssClass="error"/></td>
		</tr>
	
		<tr>
		<td><label></label></td>
		<td><input class="add-button" type="submit" value="SAVE" class="save"/></td>
		</tr>

	</tbody>

</table>

</form:form>

</div>

<div style="clear;both;"> 

<p>
<a href="${pageContext.request.contextPath}/student/list">BACK TO STUDENT LIST</a>
</p>

</div>

</body>

<footer>
  <p>Developer: Ashique Mohaimin Ornab</p>
  <p><a href="mailto:hege@example.com">amornab@gmail.com</a></p>
</footer> 

</html>