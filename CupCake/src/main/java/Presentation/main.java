/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Model_CupCake;

/**
 *
 * @author Shevitar
 */
public class main
{
    public static void main(String[] args)
    {
        Model_CupCake cake1 = new Model_CupCake(1, 1, "Choco", "Choco", 5, 5);
        Model_CupCake cake2 = new Model_CupCake(1, 1, "Choco", "Choco", 5, 5);
        boolean equal = cake1.equals(cake2);
        System.out.println("cake1 is equal to cake2: " + equal);
    }
}
