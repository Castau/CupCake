
<%@page import="Data.Model_User"%>
<%
    Model_User user = (Model_User) session.getAttribute("user");
%>

<div id="NavBar">

    <nav id="site">
        <a href=".">Home</a>
    </nav>

    <nav id="user">

        <%
            if (user == null)
            {
        %>
        <a href="login">Login/Register</a>
        <%
        }
        else
        {
        %>
        <a href="app/CustomerPage.jsp"><%= user.getUserName()%></a>
        <!--<a href="Controller?command=userlogout">Log out</a>-->
        <form action="app/logout" method="post">
            <button type="submit"/>Log out</button>
        </form>
        <%
            }
        %>

    </nav>

</div>