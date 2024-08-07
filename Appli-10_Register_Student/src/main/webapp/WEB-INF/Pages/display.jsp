<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
     <style><%@include file="/WEB-INF/Pages/display.css"%></style>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
  <h1 class="stu-head">Student Details</h1>
     <c:choose>
     <c:when test="${!empty stulist}">
         <table class="table table-hover">
        <thead>
        <tr>
           <th>ID</th>
           <th>FirstName</th>
           <th>LastName</th>
           <th>Enroll</th>
           <th>Email</th>
           <th>Contact</th>
           <th>Course</th>
           <th>Operation</th>
        </tr>
      </thead>
      <tbody>
 <c:forEach var="stu" items="${stulist}">
    <tr>
        <td>${stu.id}</td>
        <td>${stu.firstname}</td>
        <td>${stu.lastname}</td>
        <td>${stu.enroll}</td>
        <td>${stu.email}</td>
        <td>${stu.contact}</td>
        <td>${stu.course}</td>
        <td><a href="edit?id=${stu.id}"><button type="button" class="btn btn-warning">Edit</button></a>
        <a href="delete?id=${stu.id}" onclick="return confirm('Are you sure to delete the record press OK if Yes')">  <button type="button" class="btn btn-danger">Delete</button></a>
        </td>
       </tr>
 </c:forEach>
      </tbody>    
 </table>
     </c:when>
     <c:otherwise>No data found</c:otherwise>
     </c:choose>
     <h2 class="head-last">Register New Student:
      <a href="addstu"><button type="button" class="btn btn-primary">New</button> </a>
    </h2>
</body>
</html>