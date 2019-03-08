package Presentation;

import Data.Model_User;
import Logic.Controller_User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Camilla
 */
public class CMD_Balance extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String addedbalance = request.getParameter("balance");
        double addedBalance = Double.parseDouble(addedbalance);

        Model_User user = (Model_User) request.getSession().getAttribute("user");
        int userID = user.getUserID();

        Controller_User controller = new Controller_User();
        try {
            controller.updateBalance(userID, addedBalance);
        } catch (SQLException ex) {
            System.out.println("Couldn't map user " + ex);
        }
        response.sendRedirect("/app/customer");
    }
}