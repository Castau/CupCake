package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for forwarding to the LoginError.jsp page when the user enters wrong
 * information while loggin in.
 * 
 * @author Camilla
 */

public class CMD_Unknown_Login extends Command
{

    /**
     * Forwards to LoginError.jsp
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
        request.getRequestDispatcher("/jsp/LoginError.jsp").forward(request, response);
    }

}
