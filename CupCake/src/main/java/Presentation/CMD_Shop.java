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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
        System.out.println("" + user.getUserName());
        Cart cart = new Cart(user.getUserID());
        
        
        ArrayList<Model_CupCake> cupcakes = new ArrayList();
        try
        {
            cupcakes = mc.getAllCupCakes();
        } catch (SQLException ex)
        {
            Logger.getLogger(CMD_Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            cart.addToCart(mc.getCupCake(1, 1));
        } catch (Exception ex)
        {
            System.out.println("Shit didn't work");
            Logger.getLogger(CMD_Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Shop</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Shop</h1>");
            out.println("<br/>");
            for (int i = 0; i < cupcakes.size(); i++)
            {
                double total = cupcakes.get(i).getTopPrice() + cupcakes.get(i).getBottomPrice();
                out.println("<p>"
                        + "Cake top name: " + cupcakes.get(i).getTopName()
                        + " price: " + cupcakes.get(i).getTopPrice()
                        + "<br/>"
                        + "Cake bottom name: " + cupcakes.get(i).getBottomName()
                        + " price: " + cupcakes.get(i).getBottomPrice()
                        + "<br/>"
                        + "Total price: " + total
                        + "</p>");
                out.println("<br/>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

}
