/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Model_User;
import Logic.Controller_Invoice;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for handling access to AdminPage
 * 
 * @author Camilla
 */

public class CMD_Admin extends Command {

    /**
     * Handles admincheck, gets allInvoices from the Controller_Invoice 
     * and forwards to AdminPage.jsp
     * 
     * @param request the Http request
     * @param response the Http response
     * @throws ServletException when error occurs while forwarding
     * @throws IOException when error occurs while redirecting
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Model_User user = (Model_User) request.getSession().getAttribute("user");
        if (Model_User.Role.admin != user.getRole()){
            response.sendRedirect("/app/customer");
            return;
        }
        
        Controller_Invoice controller = new Controller_Invoice();
        try {
            request.setAttribute("allInvoices", controller.getAllInvoicesAdmin());
        } catch (SQLException ex) {
            System.out.println("Couldn't map allInvoices " + ex);
        }
        request.getRequestDispatcher("/jsp/AdminPage.jsp").forward(request, response);
        

    }
}

