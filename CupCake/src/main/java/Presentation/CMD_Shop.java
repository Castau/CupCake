/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Cart;
import Data.Mapper_CupCake;
import Data.Model_CupCake;
import Data.Model_User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stein
 */
public class CMD_Shop extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        
        Mapper_CupCake mc = new Mapper_CupCake();
        Model_User user = (Model_User) request.getSession().getAttribute("user");
        Cart cart = null;
        if (request.getSession().getAttribute("cart") == null)
        {
            cart = new Cart(user.getUserID());
        }
        else
        {
            cart = (Cart) request.getSession().getAttribute("cart");
        }
        if (request.getParameter("top") != null)
        {
            int qty = Integer.parseInt(request.getParameter("qty"));
            int top = Integer.parseInt(request.getParameter("top"));
            int bottom = Integer.parseInt(request.getParameter("bottom"));
            Model_CupCake cake = null;
            try {
                cake = mc.getCupCake(top, bottom);
            } catch (SQLException ex) {
                Logger.getLogger(CMD_Shop.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < qty; i++)
            {
                cart.addToCart(cake);
            }
        }
        if (request.getParameter("clear") != null)
        {
            cart.clearCart();
        }
        request.getSession().setAttribute("cart", cart);
        request.getRequestDispatcher("/jsp/ShopPage.jsp").forward(request, response);
    }
}
