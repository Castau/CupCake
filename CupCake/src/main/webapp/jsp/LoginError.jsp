<%-- 
    Document   : LoginError
    Created on : 09-03-2019, 17:20:52
    Author     : Camilla
--%>

<jsp:include page='Header.jsp'></jsp:include>
    <h2>Welcome - Please log in or register below</h2>
<jsp:include page='NavigationBar.jsp'></jsp:include>

<div class = padding>
    
</div>

<div class=" col-md-8 col-md-offset-2 errormessage">
    <h4 style="text-align: center; ">
        Wrong username or password!      
    </h4>
        
</div>
<div class = padding>
    
</div>
<div id="loginpage" class="padding">
    <div id="login" class=" col-md-6 col-md-offset-3" style="margin-bottom: 20px; min-height: 230px">
        <h3>I have a user</h3>
        <h4>Login</h4>
        <form action="app/login" method="post">
            <input type="text" name="username" value="" placeholder="Username" autofocus required><br>
            <input type="password" name="password" value="" placeholder="Password" required><br>
            <input type="hidden" name="create" value="false">
            <input type="submit" value="Log in" id = "LoginSubmit" class="button">
        </form>
    </div>

    <div id="register" class=" col-md-6 col-md-offset-3" style="min-height: 230px">
        <h3>I need a new user</h3>
        <h4>Register</h4>
        <form action="app/login"  method="post">
            <input type="text" name="username" value="" placeholder="Username" required><br>
            <input type="password" name="password" value="" placeholder="Password" required><br>
            <input type="email" name="email" value="" placeholder="Email" required><br>
            <input type="hidden" name="create" value="true">
            <input type="submit" value="Register User" id = "registerButton" class="button"> 
        </form>
    </div>
</div>

<jsp:include page='Footer.jsp'></jsp:include>
