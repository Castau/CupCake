<%-- 
    Document   : CustomerPage
    Created on : 05-03-2019, 10:09:48
    Author     : Camilla
--%>
<jsp:include page='Footer.jsp'></jsp:include>
<jsp:include page='Header.jsp'></jsp:include>
<jsp:include page='NavigationBar.jsp'></jsp:include>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.Model_Invoice"%>
<%@page import="Data.Model_User"%>
<%
    Model_User user = (Model_User) request.getAttribute("user");

    int userID = user.getUserID();
    String userName = user.getUserName();
    String userEmail = user.getEmail();
    double balance = user.getBalance();
    ArrayList<Model_Invoice> userInvoices = user.getInvoices();

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/cssHeader.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
    </head>
    <body>
        <h2>Customer Page</h2>
        <h3>Customer details:</h3>
        <br/>

        <p>Logged in as: <span id="UserName"><%= userName%></span></p>
        <p>UserID: <span id="UserID"><%= userID%></span></p>
        <p>E-mail: <span id="UserEmail"><%= userEmail%></span></p>
        <p>Balance: <span id="UserBalance"><%= balance%>$</span></p>
        <br/>
        <p>Invoices:</p>

        <%
            for (int i = 0; i < userInvoices.size(); i++) {
                out.println("<a href='customerinvoice?invoiceid=" + userInvoices.get(i).getId_invoice() + "'><p>"
                        + "Invoice ID | " + userInvoices.get(i).getId_invoice()
                        + " | Total price | " + userInvoices.get(i).getTotalPrice() + "</p></a>");
            }
        %>
    </body>
</html>
