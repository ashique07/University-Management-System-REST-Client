<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>

<title>All Instructors</title>

<style>
#container{
background-color: #FAF0E6;
width: 100vw;
height: 100vh;
display: grid;
grid-template-areas:
"header header header"
"content1 content2 content3";
grid-template-rows: auto auto;
grid-template-columns: auto auto auto;
grid-gap: 10px;
font-family:Verdana, Arial, Helvetica, sans-serif;
}

#header{
grid-area: header;
background-color: #483D8B;
color: #FFFFFF;
border-color: black;
border-width: 5px;
border-style: solid;
border-radius: 10px;
}

#content1{
grid-area: content1;
background-color: #B0C4DE;
border-color: black;
border-width: 5px;
border-style: solid;
border-radius: 10px;
text-align: center;
font-size: 30px;

}

#content2{
grid-area: content2;
background-color: #B0C4DE;
border-color: black;
border-width: 5px;
border-style: solid;
border-radius: 10px;
text-align: center;
font-size: 30px;
}

#content3{
grid-area: content3;
background-color: #B0C4DE;
border-color: black;
border-width: 5px;
border-style: solid;
border-radius: 10px;
text-align: center;
font-size: 30px;

}

a:hover{
color:white;
}

footer {
  display: block;
}

</style>

</head>

<body>

<div id="container">
<div id="header">

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
User: <strong><security:authentication property="principal.username"/></strong>
<input type="submit" value="Logout ?"/>
</form:form>

<h2>Welcome back <security:authentication property="principal.username"/> 
! Your role is: <security:authentication property="principal.authorities"/></h2>


<h2>University Management System using Spring MVC and Hibernate - REST CLIENT (Front-End)</h2>
<h2>Designed and developed by ASHIQUE MOHAIMIN ORNAB</h2>

<hr>

<p>Technologies used: </p>
<ul>
<li>Programming Languages : JAVA, HTML, CSS, JSP, JSTL</li>
<li>Spring Core : Inversion of Control and Dependency Injection using Java Configuration</li>
<li>Spring Web MVC : Models, Views, Controllers, Services, Data Access Objects, Request Param and Request Mapping, Form Tags and Data Binding, Built-in Validation Rules </li>
<li>Spring Security : Authorization, Authentication and Restrict Access Based on Roles</li>
<li>Hibernate CRUD and Hibernate Mappings : @OneToMany and @ManyToMany (Only used in REST API)</li>
<li>Spring REST (Only used in REST API)</li>
<li>MySQL Database (Only used in REST API)</li>
<li>Data Binding - Jackson </li>
<li>Project Management Tool - Maven</li>
<li>Cloud computing platform - Amazon Web Services</li>
</ul>

</div>

<div id="content1">
<a href = "${pageContext.request.contextPath}/instructor/list">
INSTRUCTORS
</a>
</div>

<div id="content2">
<a href = "${pageContext.request.contextPath}/course/list">COURSES</a>
</div>

<div id="content3">
<a href = "${pageContext.request.contextPath}/student/list">STUDENTS</a>
</div>

</div>

</body>

<footer>
  <p>Developer: Ashique Mohaimin Ornab</p>
  <p><a href="mailto:hege@example.com">amornab@gmail.com</a></p>
</footer> 

</html>