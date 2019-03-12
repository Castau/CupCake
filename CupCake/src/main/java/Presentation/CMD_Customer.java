/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Model_User;
import Logic.Controller_User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for handling access to Customer Page
 * 
 * @author Camilla
 */
public class CMD_Customer extends Command {

    /**
     * Gets the userobject from session parameters and adds the specific users 
     * invoices to the userobject, then updates the session and request 
     * parameters with the new userobject and forwards to CustomerPage.jsp
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
        int userID = user.getUserID();

        Controller_User controller = new Controller_User();
        try {
            user = controller.getUserWithInvoices(userID);
        } catch (SQLException ex) {
            System.out.println("Couldn't map user " + ex);
        }
        request.setAttribute("user", user);
        request.getSession().setAttribute("user", user);

        request.getRequestDispatcher("/jsp/CustomerPage.jsp").forward(request, response);

    }
}
