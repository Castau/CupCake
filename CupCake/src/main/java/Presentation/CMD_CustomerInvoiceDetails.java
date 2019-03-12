package Presentation;

import Data.Model_Invoice;
import Data.Model_User;
import Logic.Controller_Invoice;
import Logic.Controller_User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for handling access to the Invoice Details page
 * 
 * @author Camilla
 */
public class CMD_CustomerInvoiceDetails extends Command {

    /**
     * Gets the specifik invoice id from the request parameters and gets the 
     * invoicedetails and userinfo from the Controller_Invoice and the
     * Controller_User, then updates the request before forwarding to
     * the InvoiceDetailsPage.jsp page.
     * 
     * @param request the Http request
     * @param response the Http response
     * @throws ServletException when error occurs while forwarding
     * @throws IOException when error occurs while redirecting
     */
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

            Model_User sessionUser = (Model_User) request.getSession().getAttribute("user");
            if (invoice.getId_user() != sessionUser.getUserID()) {
                if (Model_User.Role.admin != sessionUser.getRole()) {
                    response.sendRedirect("/cupcake/app/customer");
                    return;
                }
            }
            request.setAttribute("user", user);
            request.setAttribute("invoice", invoice);
            request.getRequestDispatcher("/jsp/InvoiceDetailsPage.jsp").forward(request, response);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

}
