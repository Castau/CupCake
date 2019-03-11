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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author runin
 */
public class CMD_Login extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email"); //Only included if we wish to create a new user
        boolean create = Boolean.valueOf(request.getParameter("create")); //If we want to create a new user or not. Hidden input form from Login.jsp

        
        if (create) //Register new user
        {
            registerUser(username, password, email, request, response);
        }
        else //Log in user
        {
            loginUser(username, password, request, response);

        }
    }

    private void registerUser(String username, String password, String email, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        try
        {
            Mapper_User mu = new Mapper_User();
            Model_User user = null;
            user = mu.createUser(username, password, email);
            if (user == null) //COULD NOT CREATE USER
            {
                session.invalidate();
                request.getRequestDispatcher("/app/createusererror").forward(request, response);
            }
            else //user created succesfully
            {
                session.setAttribute("user", user);
                response.sendRedirect("customer");
            }
        }
        catch (SQLException ex)
        {
            session.invalidate();
            request.getRequestDispatcher("/app/createusererror").forward(request, response);
            Logger.getLogger(CMD_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loginUser(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        Controller_User cu = new Controller_User();
        Boolean valid = null;
        try
        {
            valid = cu.checkPasswordValidity(username, password); //validate user
            //System.out.println(valid);
        }
        catch (SQLException ex)
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
                session.setAttribute("user", user);
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to create new user - check connection. (Error#1337)");
                Logger.getLogger(CMD_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("customer").forward(request, response);
        }

        if (!valid || valid == null) //Invalid user or something went wrong
        {
            session.invalidate();
            request.getRequestDispatcher("/app/unknownlogin").forward(request, response);
        }
    }
}
