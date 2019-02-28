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
 *
 * @author stein
 */
public abstract class Command {

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public static Command from(HttpServletRequest request){
        Command command;
        String path = request.getPathInfo().substring(1);
        //String path = request.getParameter("path");

        switch (path){
            case "":
                command = new loginCMD();
                break;
            case "shop":
                command = new shopCMD();
                break;
            case "cart": 
                command = new shopCartCMD();
                break;
            case "customer": 
                command = new customerCMD();
                break;
            default: 
                command = new unknownCMD();
        }
        return command;
    }
}