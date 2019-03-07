/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.Controller_Invoice;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Camilla
 */

public class CMD_Admin extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Controller_Invoice controller = new Controller_Invoice();
        try {
            request.setAttribute("allInvoices", controller.getAllInvoicesAdmin());
        } catch (SQLException ex) {
            System.out.println("Couldn't map allInvoices " + ex);
        }
        request.getRequestDispatcher("/jsp/AdminPage.jsp").forward(request, response);
        

    }
}

