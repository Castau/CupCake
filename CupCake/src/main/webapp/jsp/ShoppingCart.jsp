<%-- 
    Document   : ShoppingCart
    Created on : 05-03-2019, 22:59:32
    Author     : Shevitar
--%>

<%@page import="Data.Model_User"%>
<%@page import="Data.Cart"%>
<%@page import="Data.Model_CupCake"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    Model_User user = (Model_User) request.getSession().getAttribute("user");
    System.out.println("Username from ShoppingCartPage: " + user.getUserName());
    double cash = user.getBalance();
    String username = user.getUserName();
    double finalPrice = 0;
    boolean enoughCash = false;
%>

<jsp:include page='Header.jsp'></jsp:include>

<div>
    <div>
        <h3>Your shopping cart items</h3>
        <p>User: <%= username %></p>
        <p>Balance: <%= cash %></p>
        <table style="width:50%">
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
                    <%= cart.getCakes().get(i).getTotalPrice()%>
                    <% finalPrice = finalPrice + cart.getCakes().get(i).getTotalPrice(); %>
                </td>
                <% }%>
                <td>
                    <%= finalPrice%>
                </td>
            </tr>
        </table> 
    </div>
        <div>
            </br>
            <form action="app/checkout" method="get" target="">
                <button name="buyPermission" type="submit" value="<%
                            if (cash < finalPrice)
                            {
                                enoughCash = false;
                            }
                            else
                            {
                                enoughCash = true;
                            }
                        %><%= enoughCash %>"> 
                    Buy cupcakes </button>
            </form>
        </div>
</div>
<jsp:include page='Footer.jsp'></jsp:include>