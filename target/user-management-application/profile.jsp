<%@ page import="model.User" %>
<%@ page import="dao.UserDAO" %><%--
  Created by IntelliJ IDEA.
  User: imcvk
  Date: 25/01/23
  Time: 10:52 am
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <title>User Details</title>
  <jsp:include page="navbar.jsp"/>
</head>
<body>
<%
  Object o = session.getAttribute("currentUser");
  if (o != null) {
    User u = (User) o;
    String date = UserDAO.toSqlDateFromUtilDate(u.getDOB()).toString();
    System.out.println(date);
    request.setAttribute("currentUser", u);
%>
<div class="container h-100">
  <div class="row h-100 align-items-center justify-content-center">
    <form action="UpdateServlet" method="post">
      <h1 class="text-center">User Details</h1>
      <div class="form-group">
        <label for="userid">Userid</label>
        <input type="text" class="form-control" name="userid" id="userid" value=<%=u.getUserid()%> readonly>
      </div>
      <div class="form-group" hidden>
        <label for="password">Password</label>
        <input type="text" class="form-control" id="password" name="password" value=<%=u.getPassword()%> readonly>
      </div>
      <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" name="name" id="name" value=<%=u.getName()%> disabled>
      </div>
      <div class="form-group">
        <label for="email">Email address</label>
        <input type="email" class="form-control" id="email" name="email" value="<%=u.getEmailAddress()%>" disabled>
      </div>
      <div class="form-group">
        <label for="phoneNumber">Phone Number</label>
        <input name="phoneNumber" type="tel" class="form-control" id="phoneNumber" maxlength="10"
               value="<%=u.getPhoneNumber()%>" disabled>
      </div>
      <div class="form-group">
        <label for="address">Address</label>
        <input name="address" type="text" class="form-control" id="address" value="<%=u.getAddress()%>" disabled>
      </div>
      <div class="form-group">
        <label for="birthday">Birthday</label>
        <input type="date" class="form-control" id="birthday" name="birthday" value="<%=date%>" disabled>
      </div>
      <div class="form-group">
        <label for="gender">Gender</label>
        <select class="form-control" id="gender" name="gender" disabled>
          <%
            if (u.getGender().equals("Male")) {
          %>
          <option value="Male" selected>Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
          <%}%>
          <%
            if (u.getGender().equals("Female")) {
          %>
          <option value="Male">Male</option>
          <option value="Female" selected>Female</option>
          <option value="Other">Other</option>
          <%}%>
          <%
            if (u.getGender().equals("Other")) {
          %>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          <option value="Other" selected>Other</option>
          <%}%>
        </select>
      </div>
      <button type="button" class="btn btn-primary" onclick="enableFields()">Edit</button>
      <button type="button" class="btn btn-primary" onclick="disableFields()">Cancel</button>
      <button disabled type="submit" id="saveBtn" class="btn btn-primary">Save</button>
    </form>
  </div>
  <div>
    <%
      Object updateMsg = request.getAttribute("updateMsg");
      Object errorMsg = request.getAttribute("errorMsg");
      if (updateMsg != null) {
    %>
    <h3><%=updateMsg.toString()%>
    </h3><%
    }
    if (errorMsg != null) {
  %>
    <h3><%=errorMsg.toString()%>
        <%}%>
  </div>
</div>
<script>
    function enableFields() {
        document.getElementById("name").disabled = false;
        document.getElementById("email").disabled = false;
        document.getElementById("birthday").disabled = false;
        document.getElementById("gender").disabled = false;
        document.getElementById("phoneNumber").disabled = false;
        document.getElementById("address").disabled = false;
        document.getElementById("saveBtn").disabled = false;
        document.getElementById("deleteProfile").disabled = false;
    }

    function disableFields() {
        document.getElementById("name").disabled = true;
        document.getElementById("email").disabled = true;
        document.getElementById("birthday").disabled = true;
        document.getElementById("gender").disabled = true;
        document.getElementById("phoneNumber").disabled = true;
        document.getElementById("address").disabled = true;
        document.getElementById("deleteProfile").disabled = true;
    }
</script>
<%
  } else {
    request.setAttribute("errorMsg", "Please login again...");
    request.getRequestDispatcher("index.jsp").forward(request, response);
  }
%>
</body>
</html>
