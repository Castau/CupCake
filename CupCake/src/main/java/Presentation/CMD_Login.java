/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Controller_User c = new Controller_User();
        boolean valid = false;
        try
        {
            valid = c.checkPasswordValidity(username, password);
        } 
        catch (SQLException ex)
        {
            System.out.println("Failed to validate password");
            Logger.getLogger(CMD_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (valid)
        {
            HttpSession hs = request.getSession();
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login</h1>");
            out.println("<p><a href=\"/?action=shop\">Log in</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
