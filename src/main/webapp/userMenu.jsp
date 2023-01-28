<%--
  Created by IntelliJ IDEA.
  User: imcvk
  Date: 27/01/23
  Time: 11:02 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  Object currentUser = session.getAttribute("currentUser");
  if (currentUser != null) {
%>
<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <title>User Menu</title>
  <jsp:include page="navbar.jsp"/>
</head>
<body>
<center>
  <div class="card" style="width: 18rem;">
    <div class="card-body">
      <a href="profile.jsp"><h2>View My Profile</h2></a>
    </div>
  </div>
  <div class="card" style="width: 18rem;">
    <div class="card-body">
      <a href="registration.jsp">Registration of new User</a>
    </div>
  </div>
  <div class="card" style="width: 18rem;">
    <div class="card-body">
      <a href="AllUserServlet">All existing users</a>
    </div>
  </div>
  <div class="card" style="width: 18rem;">
    <div class="card-body">
      <a href="DeleteServlet">Delete My Profile</a>
    </div>
  </div>
</center>
</body>
<%
  } else {
    response.sendRedirect("index.jsp");
  }
%>
</html>
