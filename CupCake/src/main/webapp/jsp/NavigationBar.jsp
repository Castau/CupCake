
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

    <nav id="site">
        <a href=".">Home</a>
    </nav>

    <nav id="user">

        <%            if (user == null)
            {
        %>
        <a href="login">Login/Register</a>
        <%
        }
        else
        {
        %>
        <a href="app/customer"><%= username%> |</a>
        <!--<a href="Controller?command=userlogout">Log out</a>-->
        <form id = "logoutform" action="app/logout" method="post">
            <button class ="button" id="logoutbutton" type="submit"/>Log out</button>
        </form>
        <%
            }
        %>

    </nav>

</div>