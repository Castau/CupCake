<%-- 
    Document   : Header
    Created on : 05-03-2019, 10:58:14
    Author     : Shevitar
--%>

<%@page import="Data.Model_User"%>

<%
    /*Model_User user = (Model_User) session.getAttribute("user");
    String username = user.getUserName();*/
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/cssglobal.css">
        <link rel="icon" href="images/favicon.png" type="image/png">
        <title>Copenhagen Cupcakes</title>
    </head>
    <body>
        <div>

            <h1>
                <img src="images/cupcake_logo.png" width="25" height="25" alt=""/>
                Copenhagen Cupcakes
                <img src="images/cupcake_logo.png" width="25" height="25" alt=""/>
            </h1>
        </div>
