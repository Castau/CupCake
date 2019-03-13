<%-- 
    Document   : AdminPage
    Created on : 07-03-2019, 10:41:34
    Author     : Camilla
--%>
<jsp:include page='Header.jsp'></jsp:include>
    <h2>Admin Page</h2>
<jsp:include page='NavigationBar.jsp'></jsp:include>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.Model_Invoice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Model_Invoice> invoices = (ArrayList<Model_Invoice>) request.getAttribute("allInvoices");
%>

<div class="padding">

    <h4 class="col-md-offset-5 col-sm-offset-4 col-xs-offset-3">All Invoices for all users:</h4>
    <br/>
    <div class="col-md-5 col-md-offset-3">
        <table class="table  table-hover">
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
                for (int i = 0; i < invoices.size(); i++)
                {
                    int invoiceID = invoices.get(i).getId_invoice();
                    int userID = invoices.get(i).getId_user();
                    Double price = invoices.get(i).getTotalPrice();

                    out.print("<tr>");
                    out.print("<td class=\"col-md-1\">" + invoiceID + "</td>");
                    out.print("<td class=\"col-md-1\">" + userID + "</td>");
                    out.print("<td class=\"col-md-1\">£" + price + "</td>");
                    out.print("<td class=\"col-md-1\"> <a href=\"app/customerinvoice?invoiceid=" + invoices.get(i).getId_invoice() + "\">See order details</a> </td>");
                    out.print("</tr>");
                }
            %>
        </table>
    </div>
</div>
<jsp:include page='Footer.jsp'></jsp:include>
