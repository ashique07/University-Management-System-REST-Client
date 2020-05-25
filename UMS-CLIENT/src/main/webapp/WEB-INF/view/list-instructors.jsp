<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>

<html>

<head>

<title>All Instructors</title>

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

<h2>All Instructors</h2>

</div>
</div>

<div id="container">
<div id="content">

<security:authorize access = "hasRole('ADMIN')">
<!-- PUT BUTTON: ADD INSTRUCTOR -->
<input type="button" value="Add Instructor" onClick="window.location.href='showFormForAdd'; return false;"
class = "add-button" />
</security:authorize>

<!-- ADD HTML TABLE HERE -->

<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Action</th>
	</tr>
	
	<!-- LOOP OVER EACH AND PRINT INSTRUCTOR -->
	<c:forEach var="tempInstructor" items="${instructors}">
	
	<!-- Construct update link with InstructorID -->
	<c:url var="updateLink" value="/instructor/showFormForUpdate">
	
	<c:param name="instructorId" value="${tempInstructor.id}"/>
	
	</c:url>
	
	<!-- Construct delete link with InstructorID -->
	<c:url var="deleteLink" value="/instructor/delete">
	
	<c:param name="instructorId" value="${tempInstructor.id}"/>
	
	</c:url>
	
	<!-- Construct COURSES link with InstructorID -->
	<c:url var="coursesLink" value="/instructor/courses">
	
	<c:param name="instructorId" value="${tempInstructor.id}"/>
	
	</c:url>
	
	
	<tr>
		<td>${tempInstructor.firstName}</td>
		<td>${tempInstructor.lastName}</td>
		<td>${tempInstructor.email}</td>
		<td>
			<security:authorize access = "hasRole('ADMIN')">
			<a href="${updateLink}">UPDATE</a>
			|
			<a href="${deleteLink}"
			onClick="if(!(confirm('Are you sure you want to delete ?')))return false">DELETE</a>
			|
			</security:authorize>
			<a href="${coursesLink}">SHOW COURSES</a>
		</td>
	</tr>

	</c:forEach>
	
</table>

</div>
</div>

<div style="clear;both;"> 

<p>
<a href="${pageContext.request.contextPath}/home/menu">BACK TO HOME MENU</a>
</p>

</div>


</body>

<footer>
  <p>Developer: Ashique Mohaimin Ornab</p>
  <p><a href="mailto:hege@example.com">amornab@gmail.com</a></p>
</footer> 


</html>