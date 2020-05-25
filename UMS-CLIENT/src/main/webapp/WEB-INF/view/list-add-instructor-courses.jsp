<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>

<title>Courses with no Instructor</title>

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

<h2>Courses with no Instructor</h2>

</div>
</div>

<div id="container">
<div id="content">


<!-- ADD HTML TABLE HERE -->

<table>
	<tr>
		<th>Title</th>
		<th>Action</th>
	</tr>
	
	<!-- LOOP OVER EACH AND PRINT INSTRUCTOR -->
	<c:forEach var="tempCourse" items="${addInstructorCourses}">
	
	<!-- Construct add link with CourseID -->
	<c:url var="addLink" value="/instructor/addInstructorCourses">
	
	<c:param name="courseId" value="${tempCourse.id}"/>
	<c:param name="instructorId" value="${instructorId}"/>
	
	</c:url>
	
	<tr>
		<td>${tempCourse.title}</td>
		<td>
			<a href="${addLink}">ADD COURSE</a>
		</td>
	</tr>

	</c:forEach>
	
</table>

</div>
</div>

<div style="clear;both;"> 

<c:url var="backLink" value="/instructor/courses">
	<c:param name="instructorId" value="${instructorId}"/>
	</c:url>
<p>
<a href="${backLink}">BACK TO ${instructor.firstName} ${instructor.lastName}'s COURSES</a>
</p>

</div>

</body>

<footer>
  <p>Developer: Ashique Mohaimin Ornab</p>
  <p><a href="mailto:hege@example.com">amornab@gmail.com</a></p>
</footer> 

</html>