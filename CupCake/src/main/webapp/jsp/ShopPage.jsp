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
    
    Model_User user = (Model_User) request.getSession().getAttribute("user");
    int userID = user.getUserID();
    Cart cart = new Cart(userID);
%>

<%!
    public void addToCart(int topID, int bottomID, Cart cart)
    {
        Mapper_CupCake mc = new Mapper_CupCake();
        Model_CupCake cake = new Model_CupCake();
        try
        {
            cake = mc.getCupCake(topID, bottomID);
        } catch (SQLException SQLx)
        {
            System.out.println("Failed to fetch cupcake");
        }
        cart.addToCart(cake);
        System.out.println("" + cart.getCakes().size());
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="cake-chooser-top">
            <label for="top">What type of top would you like?</label>
            <select name="top" id="top">
                <option value="1">Chocolate</option>
                <option value="2">Blueberry</option>
                <option value="3">Raspberry</option>
                <option value="4">Crispy</option>
                <option value="5">Strawberry</option>
                <option value="6">Rum/Raisin</option>
                <option value="7">Orange</option>
                <option value="8">Lemon</option>
                <option value="9">Blue cheese</option>
            </select>
        </section>
        <section class="cake-chooser-bottom">
            <label for="bottom">What type of top would you like?</label>
            <select name="bottom" id="bottom">
                <option value="1">Chocolate</option>
                <option value="2">Vanilla</option>
                <option value="3">Nutmeg</option>
                <option value="4">Pistacio</option>
                <option value="5">Almond</option>
            </select>
        </section>
        <form>
            <button onclick="
                    <%
                            Mapper_CupCake mc = new Mapper_CupCake();
                            Model_CupCake cake = new Model_CupCake();
                            try
                            {
                                cake = mc.getCupCake(1, 1);
                            } catch (SQLException SQLx)
                            {
                                System.out.println("Failed to fetch cupcake");
                            }
                            cart.addToCart(cake);
                            System.out.println("" + cart.getCakes().size());
                    %>
                    ">
                Choose cake
            </button>
        </form>
    </body>
</html>
