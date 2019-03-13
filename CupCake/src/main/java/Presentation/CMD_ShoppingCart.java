package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for forwarding to the ShoppingCart.jsp 
 * 
 * @author Asger
 */
public class CMD_ShoppingCart extends Command {

    /**
     * Forwards to ShoppingCart.jsp
     * @param request the Http request
     * @param response the Http response
     * @throws ServletException when error occurs while forwarding
     * @throws IOException when error occurs while redirecting
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/jsp/ShoppingCart.jsp").forward(request, response);
        
    }

}
