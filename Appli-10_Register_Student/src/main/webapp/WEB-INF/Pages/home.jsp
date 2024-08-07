<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/Pages/home.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
  <h1 style="text-align:center">Register Student</h1>
  <div class="div-form">
    <form  action="register" method="post" class="row g-3">
  <div class="col-md-6">
    <label for="inputEmail4" class="form-label">FirstName</label>
    <input type="text" name="firstname" class="form-control" id="inputEmail4">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">LastName</label>
    <input type="text" name="lastname" class="form-control" id="inputPassword4">
  </div>
  <div class="col-12">
    <label for="inputAddress" class="form-label">EnrollNo</label>
    <input type="text" name="enroll" class="form-control" id="inputAddress" placeholder="enrollno">
  </div>
  <div class="col-12">
    <label for="inputAddress2" class="form-label">Email</label>
    <input type="email"  name="email" class="form-control" id="inputAddress2" placeholder="xyz@gmail.com">
  </div>
  <div class="col-md-6">
    <label for="inputCity" class="form-label">Contact</label>
    <input type="text"  name="contact" class="form-control" id="inputCity">
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
  
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Sign in</button>
  </div>
   <a href="./"> <button type="button" class="btn btn-secondary">Back</button></a> 
</form>
</div>
    </body>
</html>