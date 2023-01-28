<nav class="navbar navbar-dark bg-dark">
  <h1 style="color: aliceblue">User Management Application</h1>
  <%
    Object u = session.getAttribute("currentUser");
    if (u != null) {
  %>
  <h2>
    <a href="userMenu.jsp">Home</a>
    <label style="color: aliceblue">|</label>
    <a href="LogoutServlet">Logout</a>
  </h2>
  <%}%>
</nav>