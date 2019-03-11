/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Cart;
import Data.Model_User;
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

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart != null) {
                cart.clearCart();
            }
            session.invalidate();

            // LOCALHOST PATH
            //response.sendRedirect("/cupcake");
            // DEPLOY PATH
            response.sendRedirect("/");
        }
    }
}
