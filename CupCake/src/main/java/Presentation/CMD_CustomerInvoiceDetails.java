package Presentation;

import Data.Model_CupCake;
import Data.Model_Invoice;
import Data.Model_InvoiceDetails;
import Data.Model_User;
import Logic.Controller_Invoice;
import Logic.Controller_User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Camilla
 */
public class CMD_CustomerInvoiceDetails extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String invoiceid = request.getParameter("invoiceid");
        int invoiceID = Integer.parseInt(invoiceid);

        Controller_User controllerUser = new Controller_User();
        Controller_Invoice controllerInvoice = new Controller_Invoice();
        Model_Invoice invoice = null;
        Model_User user = null;
        int userID = 0;
        try {
            invoice = controllerInvoice.getInvoiceWithInvoiceDetails(invoiceID);
            userID = invoice.getId_user();
            user = controllerUser.getUser(userID);
            request.setAttribute("user", user);
            request.setAttribute("invoice", invoice);
            request.getRequestDispatcher("/jsp/InvoiceDetailsPage.jsp").forward(request, response);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

}
