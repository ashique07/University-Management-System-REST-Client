<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>

<title>Save Course</title>

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

<h2>SAVE FORM</h2>

</div>
</div>

<div id="container">
<h3>Save Course</h3>

<form:form action="saveCourse" modelAttribute="course" method="POST">

<!-- Need associated FORM DATA's COURSE ID (will call course.getId() and then course.setId()) -->
<form:hidden path="id"/>

<table>
	<tbody>

		<tr>
		<td><label>Course Title: </label></td>
		<td><form:input path="title"/></td>
		<form:errors path="title" cssClass="error"/>
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
<a href="${pageContext.request.contextPath}/course/list">BACK TO COURSE LIST</a>
</p>
</div>

</body>

<footer>
  <p>Developer: Ashique Mohaimin Ornab</p>
  <p><a href="mailto:hege@example.com">amornab@gmail.com</a></p>
</footer> 

</html>