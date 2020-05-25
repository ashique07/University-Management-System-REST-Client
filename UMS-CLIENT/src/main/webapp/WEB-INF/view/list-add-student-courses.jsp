<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>

<title>Courses that ${student.firstName} ${student.lastName} didn't take</title>

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

<h2>Courses that ${student.firstName} ${student.lastName} didn't take</h2>

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
	<c:forEach var="tempCourse" items="${addStudentCourses}">
	
	<!-- Construct add link with CourseID -->
	<c:url var="addLink" value="/student/addStudentCourses">
	
	<c:param name="courseId" value="${tempCourse.id}"/>
	<c:param name="studentId" value="${studentId}"/>
	
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

<c:url var="backLink" value="/student/courses">
	<c:param name="studentId" value="${studentId}"/>
	</c:url>
<p>
<a href="${backLink}">BACK TO ${student.firstName} ${student.lastName}'s COURSES</a>
</p>

</div>

</body>

<footer>
  <p>Developer: Ashique Mohaimin Ornab</p>
  <p><a href="mailto:hege@example.com">amornab@gmail.com</a></p>
</footer> 

</html>