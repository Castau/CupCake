/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Mapper_User;
import Data.Model_User;
import Logic.Controller_User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stein
 */
public class CMD_Login extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //cupcake/login?username=admin&password=1234&email=admin@admin.dk&create=true
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        //if (!request.getParameter("email").isEmpty());
        boolean create = Boolean.valueOf(request.getParameter("create")); //If we want to create a new user or not.

        if (create) //create new user
        {
            try
            {
                Mapper_User mu = new Mapper_User();
                boolean success = mu.createUser(username, password, email);

                try (PrintWriter out = response.getWriter())
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Login</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>User created: " + success + "</h1>");
                    if (success == false)
                    {
                        out.println("<a href=\"/cupcake/login/\"><h2 style =\"color:red\">FAIL! Start over</h2></a>");
                        request.getSession().invalidate();
                    }
                    out.println("<h3>Username: " + username + "</h3>");
                    out.println("<h3>Password: " + password + "</h3>");
                    if (success)
                    {
                        out.println("<form action=/cupcake/login>");
                        out.println("<p>Log in with your new user</p>");
                        out.println("<input type=\"submit\" value = \"Log in/Continue\"/>");
                        out.println("</form>");
                    }
                    out.println("</body>");
                    out.println("</html>");
                }

            } catch (SQLException ex)
            {
                Logger.getLogger(CMD_Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else
        {

            Controller_User c = new Controller_User();
            Boolean valid = null;
            try
            {
                valid = c.checkPasswordValidity(username, password);
                System.out.println(valid);
            } catch (SQLException ex)
            {
                System.out.println("Failed to validate password");
                Logger.getLogger(CMD_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (valid) //user exists
            {
                try
                {
                    Mapper_User mu = new Mapper_User();
                    Model_User user = mu.getUserByName(username);
                    HttpSession session = request.getSession();
                    session.setAttribute("userid", user.getUserID());
                    session.setAttribute("user", user);
                    session.setAttribute("username", user.getUserName());
                    session.setAttribute("email", user.getEmail());
                    session.setAttribute("balance", user.getBalance());
                    session.setAttribute("role", user.getRole());
                } catch (SQLException ex)
                {
                    System.out.println("Failed to create new user - check connection. (Error#1337)");
                    Logger.getLogger(CMD_Login.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (!valid)
            {
                //Create user instead?
                //Discuss: Do we have multiple forms on the login page
                //One for login, one for registration? 
                //Task 3.3 specifically asks for an extra parameter
            }

            try (PrintWriter out = response.getWriter())
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>User validity: " + valid + "</h1>");
                if (valid)
                {
                    out.println("<h2 style=\"color:green\">successfully logged in</h1>");
                }
                if (valid == false)
                {
                    out.println("<a href=\"/cupcake\"><h2 style =\"color:red\">FAIL! Start over</h2></a>");
                    request.getSession().invalidate();
                }
                out.println("<h3>Username: " + username + "</h3>");
                out.println("<h3>Password: " + password + "</h3>");
                if (valid)
                {
                    out.println("<form action=/cupcake/app/shop>");
                    out.println("<input type=\"submit\" value = \"Log in/Continue\"/>");
                    out.println("</form>");
                }
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
