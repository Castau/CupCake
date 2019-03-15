package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for handling all incomming requests
 *
 * @author Camilla
 */
public abstract class Command
{

    /**
     * This is the command from which all other CMD's are called.
     *
     * @param request the Http request
     * @param response the Http response
     * @throws ServletException when error occurs while forwarding
     * @throws IOException when error occurs while redirecting
     */
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    /**
     * Creates the specific command requested from the pathinfo and returns it
     *
     * @param request the Http request
     * @return the comman corresponding to the request pathinfo
     */
    public static Command from(HttpServletRequest request)
    {
        Command command;
        String path = request.getPathInfo().substring(1);

        switch (path)
        {
            case "login":
                command = new CMD_Login();
                break;
            case "shop":
                command = new CMD_Shop();
                break;
            case "cart":
                command = new CMD_ShoppingCart();
                break;
            case "checkout":
                command = new CMD_Checkout();
                break;
            case "customer":
                command = new CMD_Customer();
                break;
            case "customerinvoice":
                command = new CMD_CustomerInvoiceDetails();
                break;
            case "logout":
                command = new CMD_Logout();
                break;
            case "admin":
                command = new CMD_Admin();
                break;
            case "addbalance":
                command = new CMD_Balance();
                break;
            default:
                command = new CMD_Unknown();
                break;
        }
        return command;
    }
}
