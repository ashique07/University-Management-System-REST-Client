<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>

<title>Student ${student.firstName} ${student.lastName}'s Courses</title>

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

<h2>Student ${student.firstName} ${student.lastName}'s Courses</h2>

</div>
</div>

<div id="container">
<div id="content">

<security:authorize access = "hasRole('STUDENT_ADVISER')">
<!-- PUT BUTTON: ADD COURSES -->
<c:url var="addCoursesLink" value="/student/listAddStudentCourses">
	<c:param name="studentId" value="${studentId}"/>
</c:url>
<a href="${addCoursesLink}">ADD COURSES</a>
</security:authorize>


<!-- ADD HTML TABLE HERE -->

<table>
	<tr>
		<th>Title</th>
		<security:authorize access = "hasRole('STUDENT_ADVISER')">
		<th>Action</th>
		</security:authorize>
	</tr>
	
	<!-- LOOP OVER EACH AND PRINT INSTRUCTOR -->
	<c:forEach var="tempCourse" items="${studentCourses}">
	
	<!-- Construct delete link with CourseID -->
	<c:url var="deleteLink" value="/student/deleteStudentCourse">
	
	<c:param name="courseId" value="${tempCourse.id}"/>
	<c:param name="studentId" value="${studentId}"/>
	
	</c:url>
	
	<tr>
		<td>${tempCourse.title}</td>
		<security:authorize access = "hasRole('STUDENT_ADVISER')">
		<td>
			
			<a href="${deleteLink}"
			onClick="if(!(confirm('Are you sure you want to delete the student's course ?')))return false">DELETE</a>
			
		</td>
		</security:authorize>
	</tr>

	</c:forEach>
	
</table>

</div>
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