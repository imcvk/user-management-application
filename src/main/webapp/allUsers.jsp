<%@ page import="java.util.ArrayList" %>
<%@ page import="model.User" %>
<%@ page import="dao.UserDAO" %><%--
  Created by IntelliJ IDEA.
  User: imcvk
  Date: 25/01/23
  Time: 11:06 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <title>All Users</title>
  <jsp:include page="navbar.jsp"/>
</head>
<body>
<div class="container h-100">
  <div class="row h-100 align-items-center justify-content-center">
    <table class="table">
      <thead>
      <tr>
        <th scope="col">Name</th>
        <th scope="col">User ID</th>
        <th scope="col">Email Address</th>
        <th scope="col">Phone Number</th>
        <th scope="col">Address</th>
        <th scope="col">DOB</th>
        <th scope="col">Gender</th>
      </tr>
      </thead>
      <tbody>
      <%
        ArrayList<User> users = UserDAO.getAllUsers();
        for (User u : users) {
      %>
      <tr>
        <td><%=u.getName()%>
        </td>
        <td><%=u.getUserid()%>
        </td>
        <td><%=u.getEmailAddress()%>
        </td>
        <td><%=u.getPhoneNumber()%>
        </td>
        <td><%=u.getAddress()%>
        </td>
        <td><%=u.getDOB()%>
        </td>
        <td><%=u.getGender()%>
        </td>
        <td>
          <a href="edit?id=<c:out value='${user.id}' />">Edit</a><label>|</label>
          <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
        </td>
      </tr>
      <%}%>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
