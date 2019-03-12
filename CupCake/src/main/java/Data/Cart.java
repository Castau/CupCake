/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author Shevitar
 */
public class Cart
{
    private ArrayList<Model_CupCake> cakes = new ArrayList();
    private int userID;

    /**
     *
     * @param userID
     */
    public Cart(int userID)
    {
        this.userID = userID;
    }

    /**
     *
     * @return
     */
    public ArrayList<Model_CupCake> getCakes()
    {
        return cakes;
    }

    /**
     *
     * @param cakes
     */
    public void setCakes(ArrayList<Model_CupCake> cakes)
    {
        this.cakes = cakes;
    }

    /**
     *
     * @return
     */
    public int getUserID()
    {
        return userID;
    }

    /**
     *
     * @param cupcake
     */
    public void addToCart(Model_CupCake cupcake)
    {
        cakes.add(cupcake);
    }
    
    /**
     *
     */
    public void clearCart()
    {
        cakes = new ArrayList();
    }
    
}
