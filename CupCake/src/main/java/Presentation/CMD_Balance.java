package Presentation;

import Data.Model_User;
import Logic.Controller_User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for handling userBalance, the application currency
 *
 * @author Camilla
 */
public class CMD_Balance extends Command
{

    /**
     * Passing information from the frontend along to the Controller_User when
     * the user buys more currency.
     *
     * @param request the Http request
     * @param response the Http response
     * @throws ServletException when error occurs while forwarding
     * @throws IOException when error occurs while redirecting
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        String addedbalance = request.getParameter("balance");
        double addedBalance = Math.abs(Double.parseDouble(addedbalance));//If user tries to remove credits - the amount will be added instead
        
        Model_User user = (Model_User) request.getSession().getAttribute("user");
        int userID = user.getUserID();

        Controller_User controller = new Controller_User();
        try
        {
            controller.updateBalance(userID, addedBalance);
        } catch (SQLException ex)
        {
            System.out.println("Couldn't map user " + ex);
        }
        response.sendRedirect("/app/customer");
    }
}
