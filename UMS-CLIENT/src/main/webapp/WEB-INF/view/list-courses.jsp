<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>

<title>All Courses</title>

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

<h2>All Courses</h2>

</div>
</div>

<div id="container">
<div id="content">

<security:authorize access = "hasRole('ADMIN')">
<!-- PUT BUTTON: ADD INSTRUCTOR -->
<input type="button" value="Add Course" onClick="window.location.href='showFormForAdd'; return false;"
class = "add-button" />
</security:authorize>

<!-- ADD HTML TABLE HERE -->

<table>
	<tr>
		<th>Title</th>
		<th>Instructor</th>
		<th>Action</th>
	</tr>
	
	<!-- LOOP OVER EACH AND PRINT INSTRUCTOR -->
	<c:forEach var="tempCourse" items="${courses}">
	
	<!-- Construct update link with CourseID -->
	<c:url var="updateLink" value="/course/showFormForUpdate">
	
	<c:param name="courseId" value="${tempCourse.id}"/>
	
	</c:url>
	
	<!-- Construct delete link with CourseID -->
	<c:url var="deleteLink" value="/course/delete">
	
	<c:param name="courseId" value="${tempCourse.id}"/>
	
	</c:url>
	
	<!-- Construct show students list with CourseID -->
	<c:url var="showStudentsLink" value="/course/showStudents">
	<c:param name="courseId" value="${tempCourse.id}"/>
	</c:url>
	
	<tr>
		<td>${tempCourse.title}</td>
		<td>${tempCourse.instructor.firstName} ${tempCourse.instructor.lastName}</td>
		<td>
			<security:authorize access = "hasRole('ADMIN')">
			<a href="${updateLink}">UPDATE</a>
			|
			<a href="${deleteLink}"
			onClick="if(!(confirm('Are you sure you want to delete ?')))return false">DELETE</a>
			|
			</security:authorize>
			<a href="${showStudentsLink}">SHOW STUDENTS</a>
		</td>
	</tr>

	</c:forEach>
	
</table>

</div>
</div>

<p>
<a href="${pageContext.request.contextPath}/home/menu">BACK TO HOME MENU</a>
</p>

</body>

<footer>
  <p>Developer: Ashique Mohaimin Ornab</p>
  <p><a href="mailto:hege@example.com">amornab@gmail.com</a></p>
</footer> 

</html>