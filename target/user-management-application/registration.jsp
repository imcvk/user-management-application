<%--
  Created by IntelliJ IDEA.
  User: imcvk
  Date: 25/01/23
  Time: 10:25 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <title>Registration</title>
  <style>
      .input-field {
          width: 80%; /* you can adjust the width value to your desired size */
      }
  </style>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container h-100">
  <div class="row h-100 align-items-center justify-content-center">
    <form action="RegistrationServlet" method="post">
      <h1 class="text-center">Registration</h1>
      <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="name">
      </div>
      <div class="form-group">
        <label for="email">Email address</label>
        <input type="email" class="form-control" id="email" name="email">
      </div>
      <div class="form-group">
        <label for="phoneNumber">Phone Number</label>
        <input name="phoneNumber" type="tel" class="form-control" id="phoneNumber" maxlength="10">
      </div>
      <div class="form-group">
        <label for="address">Address</label>
        <input name="address" type="text" class="form-control" id="address">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input name="password" type="password" class="form-control" id="password">
      </div>
      <div class="form-group">
        <label for="passwordConfirm">Confirm Password</label>
        <input name="passwordConfirm" type="password" class="form-control" id="passwordConfirm">
      </div>
      <div class="form-group">
        <label for="birthday">Birthday</label>
        <input name="birthday" type="date" class="form-control" id="birthday">
      </div>
      <div class="form-group">
        <label for="gender">Gender</label>
        <select name="gender" class="form-control" id="gender">
          <option>Male</option>
          <option>Female</option>
          <option>Other</option>
        </select>
      </div>
      <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="terms" required>
        <label class="form-check-label" for="terms">I agree to the terms and conditions</label>
      </div>
      <button type="submit" class="btn btn-primary">Register</button>
      <button type="reset" class="btn btn-primary">Reset</button>
    </form>
  </div>
</div>
</body>
</html>
