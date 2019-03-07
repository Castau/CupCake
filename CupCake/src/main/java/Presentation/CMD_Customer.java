/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Model_User;
import Logic.Controller_User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Camilla
 */
public class CMD_Customer extends Command {

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
