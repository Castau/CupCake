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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" type="text/css" href="../css/cssHeader.css">--> <!--Already defined in index.jsp-->
        <title>CupCake</title>
    </head>
    <body>
        <div id="header">
            <h1 id="headerh1">Welcome to the CupCake Website!</h1>
            <!--<p id="head"> Logged in as: </p>
            <%/*= username*/%>-->
        </div>
