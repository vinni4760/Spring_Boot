<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/Pages/editform.css"%></style>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
  <h1 style="text-align:center">Edit Student</h1>
  
  <div class="div-form">
    <form:form action="update" method="post" modelAttribute="student" class="row g-3">
    <div class="col-md-6">
    <label for="inputEmail4" class="form-label">Student ID</label>
    <form:input path="id" readonly="true" class="form-control" id="inputEmail4"/>
  </div>
  <div class="col-md-6">
    <label for="inputEmail4" class="form-label">FirstName</label>
    <form:input path="firstname" class="form-control" id="inputEmail4"/>
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">LastName</label>
    <form:input  path="lastname" class="form-control" id="inputPassword4"/>
  </div>
  <div class="col-12">
    <label for="inputAddress" class="form-label">EnrollNo</label>
    <form:input path="enroll" class="form-control" id="inputAddress" placeholder="0828CS21100"/>
  </div>
  <div class="col-12">
    <label for="inputAddress2" class="form-label">Email</label>
    <form:input path="email" class="form-control" id="inputAddress2" placeholder="xyz@gmail.com"/>
  </div>
  <div class="col-md-6">
    <label for="inputCity" class="form-label">Contact</label>
    <form:input path="contact" class="form-control" id="inputCity"/>
  </div>
  <div class="col-md-4">
    <label for="inputState" class="form-label">Course</label>
     <select id="inputState" name="course" class="form-select">
      <option selected>Choose...</option>
      <option>B Tech</option>
      <option>M Tech</option>
      <option>BCA</option>
      <option>MCA</option>
    </select>
     </div>
  
  <div class="col-12" id="update">
    <button type="submit" class="btn btn-primary">Update</button>
  </div>
  <div class="col-12" id="cancel">
   <a href="./"> <button type="button" class="btn btn-secondary">Cancel</button></a>
   </div>
</form:form>
</div>
    </body>

</html>