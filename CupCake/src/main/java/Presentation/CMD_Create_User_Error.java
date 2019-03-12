/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for forwarding to the CreateError.jsp page when the user enters wrong
 * information in the creation of their user.
 * 
 * @author Camilla
 */

public class CMD_Create_User_Error extends Command
{

    /**
     * Forwards to CreateError.jsp
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
        request.getRequestDispatcher("/jsp/CreateError.jsp").forward(request, response);
    }

}
