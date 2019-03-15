<%-- 
    Document   : ShopPage
    Created on : 05-03-2019, 14:48:28
    Author     : Asger
--%>
<jsp:include page='Header.jsp'></jsp:include>
    <h2>Shop</h2>
<jsp:include page='NavigationBar.jsp'></jsp:include>
<%@page import="java.sql.SQLException"%>
<%@page import="Data.Model_CupCake"%>
<%@page import="Data.Cart"%>
<%@page import="Data.Model_User"%>
<%@page import="Data.Mapper_CupCake"%>

<%
    Model_User user = (Model_User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/");
        return;
    }

    //Top names
    String top1 = "Chocolate £5";
    String top2 = "Blueberry £5";
    String top3 = "Raspberry £5";
    String top4 = "Crispy £6";
    String top5 = "Strawberry £6";
    String top6 = "Rum/Raisin £7";
    String top7 = "Orange £8";
    String top8 = "Lemon £8";
    String top9 = "Blue cheese £9";

    //Bottom names
    String bottom1 = "Chocolate £5";
    String bottom2 = "Vanilla £5";
    String bottom3 = "Nutmeg £5";
    String bottom4 = "Pistacio £6";
    String bottom5 = "Almond £7";

    Cart cart = (Cart) request.getSession().getAttribute("cart");
    double finalPrice = 0;
    String finalPriceTag = "";
%>

<div class="row antimargin">
    <div class="col-md-6 padding">
        <h4>CupCake Shop</h4>
        <br/>
        <form>
            <section class="top">
                <label for="top">What type of top would you like?  </label>
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
                <label for="bottom">What type of bottom would you like?</label>
                <select name="bottom" id="bottom">
                    <option value="1"><%=bottom1%></option>
                    <option value="2"><%=bottom2%></option>
                    <option value="3"><%=bottom3%></option>
                    <option value="4"><%=bottom4%></option>
                    <option value="5"><%=bottom5%></option>
                </select>
            </section>
            <br/>
            <p>
                Amount of cakes:
            </p>

            <input class="form-control" style="max-width: 80px; margin-bottom: 5px" type="number" name="qty" value="1" placeholder="x" required min="1" max="100">
            <button>
                Add cake(s) to cart
            </button>
            </br>
            </br>
        </form>
    </div>

    <div class="col-md-6 padding">
        <h4>Shopping cart:</h4>
        <br/>
        <table class="table table-striped">
            <tr>
                <th>CupCake top</th>
                <th>CupCake bottom</th>
                <th>Total cake price</th>
                <th></th>
            </tr>
            <%
                for (int i = 0; i < cart.getCakes().size(); i++) {%>
            <tr>
                <td>
                    <%= cart.getCakes().get(i).getTopName()%>
                </td>
                <td>
                    <%= cart.getCakes().get(i).getBottomName()%>
                </td>
                <td>
                    <%= "£" + cart.getCakes().get(i).getTotalPrice()%>
                    <% finalPrice = finalPrice + cart.getCakes().get(i).getTotalPrice();%>
                </td>
                <td>
                    <form>
                        <button name="remove" type="submit" value="<%=i%>">
                            Remove
                        </button>
                    </form>
                </td>
                <%if (i == cart.getCakes().size() - 1) {
                        finalPriceTag = "£" + finalPrice;
                        session.setAttribute("finalPrice", finalPrice);
                    }
                %>
                <% }%>
            </tr>
        </table> 
        <div style="float: right; margin-right: 75px">
            <h4>Total price</h4>
            <%=finalPriceTag%>
        </div>

        </br>

        <form>
            <br/>
            <button name="clear" type="submit" value="clear">
                Empty the cart
            </button>
        </form>
        </br>

        <form action="app/cart" method="get" target="">
            <button type="submit">Order cake(s)</button>
        </form>  
    </div>
</div>


<jsp:include page='Footer.jsp'></jsp:include>