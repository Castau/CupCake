<%-- 
    Document   : ShopPage
    Created on : 05-03-2019, 14:48:28
    Author     : Shevitar
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="Data.Model_CupCake"%>
<%@page import="Data.Cart"%>
<%@page import="Data.Model_User"%>
<%@page import="Data.Mapper_CupCake"%>

<%
    //Top names
    String top1 = "Chocolate";
    String top2 = "Blueberry";
    String top3 = "Raspberry";
    String top4 = "Crispy";
    String top5 = "Strawberry";
    String top6 = "Rum/Raisin";
    String top7 = "Orange";
    String top8 = "Lemon";
    String top9 = "Blue cheese";

    //Bottom names
    String bottom1 = "Chocolate";
    String bottom2 = "Vanilla";
    String bottom3 = "Nutmeg";
    String bottom4 = "Pistacio";
    String bottom5 = "Almond";
    
    Cart cart = (Cart)request.getSession().getAttribute("cart");
    double finalPrice = 0;
%>



<jsp:include page='Header.jsp'></jsp:include>

    <div>
        <form>
            <section class="top">
                <label for="top">What type of top would you like?</label>
                <select name="top" id="top">
                    <option value="1"><%=top1%></option>
                    <option value="2"><%=top2%></option>
                    <option value="3"><%=top3%></option>
                    <option value="4"><%=top4%></option>
                    <option value="5"><%=top5%></option>
                    <option value="6"><%=top6%></option>
                    <option value="7"><%=top7%></option>
                    <option value="8"><%=top8%></option>
                    <option value="9"><%=top9%></option>
                </select>
            </section>
            <section class="bottom">
                <label for="bottom">What type of top would you like?</label>
                <select name="bottom" id="bottom">
                    <option value="1"><%=bottom1%></option>
                    <option value="2"><%=bottom2%></option>
                    <option value="3"><%=bottom3%></option>
                    <option value="4"><%=bottom4%></option>
                    <option value="5"><%=bottom5%></option>
                </select>
            </section>
                <button>
                    Add cake to cart
                </button>
                </br>
                </br>
                <p>Shopping cart:</p>
        </form>
            <div>
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
            </br>
            <div>
                <form>
                    <button name="clear" type="submit" value="clear">
                        Empty the cart
                    </button>
                </form>
            </br>
            </div>
        <form action="app/cart" method="get" target="">
            <button type="submit">Order cake(s)</button>
        </form>  
    </div>        
<jsp:include page='Footer.jsp'></jsp:include>