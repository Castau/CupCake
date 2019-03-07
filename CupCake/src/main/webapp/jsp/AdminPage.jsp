<%-- 
    Document   : AdminPage
    Created on : 07-03-2019, 10:41:34
    Author     : Camilla
--%>
<jsp:include page='Header.jsp'></jsp:include>
    <h2>Customer Page</h2>
<jsp:include page='NavigationBar.jsp'></jsp:include>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.Model_Invoice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Model_Invoice> invoices = (ArrayList<Model_Invoice>) request.getAttribute("allInvoices");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <div class="padding">
            <h4>All Invoices for all users:</h4>
            <br/>
            <table class="table">
                <tr>
                    <th>
                        Invoice ID
                    </th>
                    <th>
                        User ID
                    </th>
                    <th>
                        Total price
                    </th>
                    <th>
                        Order details
                    </th>
                </tr>
                <%
                    for (int i = 0; i < invoices.size(); i++) {
                        int invoiceID = invoices.get(i).getId_invoice();
                        int userID = invoices.get(i).getId_user();
                        Double price = invoices.get(i).getTotalPrice();

                        out.print("<tr>");
                        out.print("<td>" + invoiceID + "</td>");
                        out.print("<td>" + userID + "</td>");
                        out.print("<td>" + price + "</td>");
                        out.print("<td> <a href=\"app/customerinvoice?invoiceid=" + invoices.get(i).getId_invoice() + "\">See order details</a> </td>");
                        out.print("</tr>");
                    }
                %>
            </table>
        </div>
    </body>
</html>
