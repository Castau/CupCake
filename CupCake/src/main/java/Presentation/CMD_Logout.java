package Presentation;

import Data.Cart;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Runi
 */
public class CMD_Logout extends Command {

    /**
     * Clears session attributes and logs the user out. Then redirects to front page (Index.jsp)
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException servlet exception
     * @throws IOException ioexception
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart != null) {
                cart.clearCart();
            }
            session.invalidate(); //Didn't seem to work for all cases, therefore we made sure to clear cart specifically.

                // LOCALHOST PATH
                //response.sendRedirect("/cupcake");
            // DEPLOY PATH
            response.sendRedirect("/");
        }
    }
}
