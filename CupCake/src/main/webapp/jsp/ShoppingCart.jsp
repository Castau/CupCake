<%-- 
    Document   : ShoppingCart
    Created on : 05-03-2019, 22:59:32
    Author     : Asger
--%>
<jsp:include page='Header.jsp'></jsp:include>
    <h2>Shopping Cart</h2>
<jsp:include page='NavigationBar.jsp'></jsp:include>
<%@page import="Data.Model_User"%>
<%@page import="Data.Cart"%>
<%@page import="Data.Model_CupCake"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    Model_User user = (Model_User) request.getSession().getAttribute("user");
    double cash = user.getBalance();
    String username = user.getUserName();
    double finalPrice = 0;
    boolean enoughCash = false;
%>

<div class="padding">
    <div>
        <h4>Your shopping cart items</h4>
        <p>User: <%= username%></p>
        <p>Balance: £<%= cash%></p>
        <br/>
        <table class="table">
            <tr>
                <th>CupCake top</th>
                <th>CupCake bottom</th>
                <th>Total cake price</th>
                <th>Final price</th>
            </tr>
            <%
                for (int i = 0; i < cart.getCakes().size(); i++)
                {%>
            <tr>
                <td>
                    <%= cart.getCakes().get(i).getTopName()%>
                </td>
                <td>
                    <%= cart.getCakes().get(i).getBottomName()%>
                </td>
                <td>
                    <%= "£" + cart.getCakes().get(i).getTotalPrice()%>
                    <% finalPrice = finalPrice + cart.getCakes().get(i).getTotalPrice(); %>
                </td>
                <% }%>
                <td>
                    <%= "£" + finalPrice%>
                </td>
            </tr>
        </table> 
    </div>
    <div>
        <%
            if (cash < finalPrice)
            {
                enoughCash = false;
            } else
            {
                enoughCash = true;
            }
            request.getSession().setAttribute("finalPrice", finalPrice);
            request.getSession().setAttribute("buyPermission", enoughCash);
        %>
        </br>
        <form action="app/checkout" method="get" target="">
            <button type="submit"> 
                Buy cupcake(s) </button>
        </form>
    </div>
</div>
<jsp:include page='Footer.jsp'></jsp:include>