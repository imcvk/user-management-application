<%@ page import="model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <title>Login</title>
  <jsp:include page="navbar.jsp"/>
</head>
<%
  Object currentUser = session.getAttribute("currentUser");
  if (currentUser == null) {
%>
<body>
<div class="container h-100">
  <div class="row h-100 justify-content-center align-items-center">
    <form action="LoginServlet" method="post">
      <h1 class="text-center">Login</h1>
      <div class="form-group">
        <label for="userid">Userid</label>
        <input type="text" class="form-control" id="userid" aria-describedby="userid" name="userid">
        <small class="form-text text-muted">We'll never share your email with anyone else.</small>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password">
      </div>
      <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="rememberMe" required>
        <label class="form-check-label" for="rememberMe">Remember me</label>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
      <button type="reset" class="btn btn-primary">Reset</button>
    </form>
  </div>
  <div>
    <%
      Object error = request.getAttribute("errorMsg");
      if (error != null) {
    %>
    <h2><%=error%>
    </h2>
    <%}%>
  </div>
</div>
</body>
<%
  } else {
    RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
    dispatcher.forward(request, response);
  }
%>
</html>