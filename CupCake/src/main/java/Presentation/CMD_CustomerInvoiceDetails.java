package Presentation;

import Data.Model_CupCake;
import Data.Model_Invoice;
import Data.Model_User;
import Logic.Controller_CupCake;
import Logic.Controller_Invoice;
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
public class CMD_CustomerInvoiceDetails extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String invoiceid = request.getParameter("invoiceid");
        int invoiceID = Integer.parseInt(invoiceid);
        
        Controller_User controllerUser = new Controller_User();
        Controller_Invoice controllerInvoice = new Controller_Invoice();
        Controller_CupCake controllerCake = new Controller_CupCake();
        Model_Invoice invoice = null;
        Model_User user = null;
        Model_CupCake cake = null;
        int userID = 0;
        try {
            invoice = controllerInvoice.getInvoiceWithInvoiceDetails(invoiceID);
            userID = invoice.getId_user();
            user = controllerUser.getUser(userID);

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
            out.println("<h1> User Invoice Details </h1>");
            out.println("<br/>");
            for (int i = 0; i < invoice.getInvoiceDetails().size(); i++) 
            {
                int top = invoice.getInvoiceDetails().get(i).getId_Top();
                int bottom = invoice.getInvoiceDetails().get(i).getId_Bottom();
                try
                {
                    cake = controllerCake.getCupCake(top, bottom);
                } catch (SQLException ex)
                {
                    System.out.println("Couldn't fetch cake (CMD_Customer_invoice_details)");
                    Logger.getLogger(CMD_CustomerInvoiceDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                out.println("<p>"
                       + "Cake top name: " + cake.getTopName()
                       + " price: " + cake.getTopPrice()
                       + "<br/>"
                       + "Cake bottom name: " + cake.getBottomName()
                       + " price: " + cake.getBottomPrice()
                       + "<br/>" 
                       + "</p>");
            }
            out.println("<br/>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
