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
    
    Model_User user = (Model_User) request.getAttribute("user");
    int userID = user.getUserID();
    Cart cart = new Cart(userID);
    Mapper_CupCake mc = new Mapper_CupCake();
%>


<%!
    public void addCakeToCart(int topID, int bottomID, Cart cart, Mapper_CupCake mc)
    {
        Model_CupCake cake = new Model_CupCake();
        try
        {
            cake = mc.getCupCake(topID, bottomID);
        } catch (SQLException SQLx)
        {
            System.out.println("Failed to fetch cupcake");
        }
        cart.addToCart(cake);
        System.out.println("Cart size: " + cart.getCakes().size());
    }
%>

<jsp:include page='Header.jsp'></jsp:include>

    <div>
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
            <form onsubmit="addCakeToCart()">
                <button>
                    Choose cake
                </button>
            </form>
            <script>
            function addCakeToCart() 
            {
                <%
                    //Model_CupCake cake = new Model_CupCake();
                    //String topID = request.getParameter("top");
                    //System.out.println("topID: " + topID);
                    //String bottomID = request.getParameter("bottom");
                    //try
                    //{
                    //    cake = mc.getCupCake(Integer.parseInt(topID), Integer.parseInt(bottomID)); //fix this
                    //} catch (SQLException SQLx)
                    //{
                    //    System.out.println("Failed to fetch cupcake");
                    //}
                    //cart.addToCart(cake);
                    //System.out.println(cake.getTopID() +" "+ cake.getBottomID());
                    //System.out.println("Cart size: " + cart.getCakes().size());
                %>
            }
            </script>
        <form action="app/cart" method="get" target="">
            <%
                request.setAttribute("cart", cart);
            %>
         <button type="submit">Order cake(s)</button>
        </form>  
    </div>        
<jsp:include page='Footer.jsp'></jsp:include>