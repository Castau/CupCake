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
import java.util.logging.Level;
import java.util.logging.Logger;
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

        String userid = request.getParameter("userid");
        int userID = Integer.parseInt(userid);

        Controller_User controller = new Controller_User();
        Model_User user = null;
        try {
            user = controller.getUserWithInvoices(userID);
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Invoices</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> User Info </h1>");
            out.println("<p> Username " + user.getUserName() + " </p>");
            out.println("<p> E-mail " + user.getEmail() + " </p>");
            out.println("<p> Role " + user.getRole() + " </p>");
            out.println("<h1> User Invoices </h1>");
            out.println("<br/>");
            for (int i = 0; i < user.getInvoices().size(); i++) {
                out.println("<a href='customerinvoice?invoiceid=" + user.getInvoices().get(i).getId_invoice() + "'><p>"
                       + "Invoice ID " + user.getInvoices().get(i).getId_invoice() 
                       + " Total price " + user.getInvoices().get(i).getTotalPrice() +  "</p></a>");
            }
            out.println("<br/>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
