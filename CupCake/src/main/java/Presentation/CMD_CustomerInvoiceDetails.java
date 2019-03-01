package Presentation;

import Data.Model_Invoice;
import Data.Model_User;
import Logic.Controller_Invoice;
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
public class CMD_CustomerInvoiceDetails extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String invoiceid = request.getParameter("invoiceID");
        int invoiceID = Integer.parseInt(invoiceid);
        
        Controller_User controllerUser = new Controller_User();
        Controller_Invoice controller = new Controller_Invoice();
        Model_Invoice invoice = null;
        Model_User user= null;
        int userID = 0;
        try {
            invoice = controller.getInvoiceWithInvoiceDetails(invoiceID);
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
            for (int i = 0; i < invoice.getInvoiceDetails().size(); i++) {
                out.println("<p>"
                       + "Cake top ID: " + invoice.getInvoiceDetails().get(i).getId_Top()
                       + " price: " + invoice.getInvoiceDetails().get(i).getId_Top()
                       + "<br/>"
                       + "Cake bottom ID " + invoice.getInvoiceDetails().get(i).getId_Bottom() +  "</p>");
            }
            out.println("<br/>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
