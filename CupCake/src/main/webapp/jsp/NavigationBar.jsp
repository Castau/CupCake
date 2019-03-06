
<%@page import="Data.Model_User"%>
<%
    Model_User user = (Model_User) session.getAttribute("user");
    String username = "NULL";
    if (user != null)
    {
        username = user.getUserName().toUpperCase();
    }

%>

<div id="NavBar">

    <div id="leftBar">
        <nav id="home">
            <a href=".">Home</a>
        </nav>
        <!--<%/*if (user != null)
        {*/%>-->
        <nav id ="shop">
            <a href="app/shop">Shop</a>
        </nav>
       <!-- <%/*}*/%>-->
    </div>
    <div id ="rightBar">
        
        <nav id="cart">
            <a href="ShoppingCart.jsp"><img src="images/shoppingcart.png" height="20" width="20" alt="Shopping cart image"/>Shopping cart</a>
        </nav>
        
        <nav id="user">

            <%            if (user == null)
                {
            %>
            <a href="login">Login/Register</a>
            <%
            } else
            {
            %>
            <a href="app/customer"><%= username%></a>
        </nav>
        <nav id="logout">
            <form id = "logoutform" action="app/logout" method="post">
                <button class ="button" id="logoutbutton" type="submit"/>Log out</button>
            </form>
        </nav>
    </div>
    <%
        }
    %>



</div>