<%-- 
    Document   : index
    Created on : 05-03-2019, 12:06:09
    Author     : Shevitar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page='jsp/Header.jsp'></jsp:include>
    <h2>Please login or register to continue</h2>
<jsp:include page='jsp/NavigationBar.jsp'></jsp:include>


<h3>Hello Cupcake!</h3>
<p>Ideas for this page:</p>
<p>What can we offer (cupcakes)</p>
<p>What kind of cupcakes</p>
<p>Images of said cupcakes</p>
<p>"log in to order these gdamn cupcakes</p>

<form action="app/login" method="get">
    <div>
        <label for="username">Username</label>
        <input name="username" id="username" value="admin" style="display: inline-block">
    </div>
    <div>
        <label for="password">Password</label>
        <input name="password" id ="password" value="1234" type="password" style="display: inline-block">
    </div>
    <div>
        <button>Login</button>
    </div>
</form>
<jsp:include page='jsp/Footer.jsp'></jsp:include>