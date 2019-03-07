<%-- 
    Document   : ShopCheckOut
    Created on : 07-03-2019, 11:20:25
    Author     : Shevitar
--%>


<%@page import="Data.Model_User"%>
<jsp:include page='Header.jsp'></jsp:include>

<%
    Model_User user = (Model_User)request.getSession().getAttribute("user");
    boolean buyPermission = (boolean)request.getSession().getAttribute("buyPermission");
    System.out.println("Do we have the ####ing permission or what? : " + buyPermission);
    String msg = "";
    if (buyPermission)
    {
        msg = "Cupcakes have succesfully been ordered";
    }
    else
    {
        msg = "Not enough credits in account";
    }
    double balance = user.getBalance();
    double finalPrice = (double)request.getSession().getAttribute("finalPrice");
%>
    
<div>
    <h3>Checkout</h3>
    <%
        if (buyPermission)
        {
            user.setBalance(balance - finalPrice);
        }
        //Write the actual code to make the actual changes in the DB
        request.getSession().setAttribute("user", user);
    %>
        
    <p><%=msg%></p>
    </br>
    </br>
    <form action="app/customer" method="get" target="">
        <button type="submit">Return to customer page</button>
    </form> 
</div>

<jsp:include page='Footer.jsp'></jsp:include>