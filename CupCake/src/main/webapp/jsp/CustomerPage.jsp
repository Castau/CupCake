<%-- 
    Document   : CustomerPage
    Created on : 05-03-2019, 10:09:48
    Author     : Camilla
--%>
<%@page import="Data.Model_Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.Model_User"%>
<%
    Model_User user = (Model_User) session.getAttribute("user");

    int userID = user.getUserID();
    String userName = user.getUserName();
    String userEmail = user.getEmail();
    double balance = user.getBalance();
    //ArrayList<Model_Invoice> userInvoices = user.getInvoices();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customer JSP Page</h1>
        <h3>Customer details:</h3>
        <br/>

        <p>Logged in as: <span id="UserName"><%= userName%></span></p>
        <p>UserID: <span id="UserID"><%= userID%></span></p>
        <br/>
        <p>E-mail: <span id="UserEmail"><%= userEmail%></span></p>
        <p>Balance: <span id="UserBalance"><%= balance%>$</span></p>
        <br/>
        <p>Invoices:</p>
        <%
            for (int i = 0; i < user.getInvoices().size(); i++) {
                out.println("<a href='customerinvoice?invoiceid=" + user.getInvoices().get(i).getId_invoice() + "'><p>"
                        + "Invoice ID | " + user.getInvoices().get(i).getId_invoice()
                        + " | Total price | " + user.getInvoices().get(i).getTotalPrice() + "</p></a>");
            }
        %>

    </body>
</html>
