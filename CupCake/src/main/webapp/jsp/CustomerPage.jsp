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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-6">
                <h3>Customer Page</h3>
                <h4>Customer details:</h4>
                <br/>


                <p>Logged in as: <span id="UserName"><%= userName%></span></p>
                <p>UserID: <span id="UserID"><%= userID%></span></p>
                <p>E-mail: <span id="UserEmail"><%= userEmail%></span></p>
                <p>Balance: <span id="UserBalance"><%= balance%>$</span></p>
            </div>
            <div class="col-md-6">
                <h4>Invoices:</h4>

                <%
                    for (int i = 0; i < userInvoices.size(); i++) {
                        out.println("<a href='app/customerinvoice?invoiceid=" + userInvoices.get(i).getId_invoice() + "'><p>"
                                + "Invoice ID | " + userInvoices.get(i).getId_invoice()
                                + " | Total price | " + userInvoices.get(i).getTotalPrice() + "</p></a>");
                    }
                %>
            </div>
        </div>
    </body>
</html>
