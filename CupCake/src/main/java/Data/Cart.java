package Data;

import java.util.ArrayList;

/**
 * A java object containing current line items, until cleared.
 *
 * Fields:
 *
 * cakes - An ArrayList of Cupcakes contained within the cart.
 *
 * UserID - the user who the Cart belongs to.
 *
 * @author Asger
 */
public class Cart
{

    private ArrayList<Model_CupCake> cakes = new ArrayList();
    private int userID;

    /**
     * The cart object is tied to a specific user for later use when updating
     * user records. (Balance, invoice, invoice_details).
     *
     * The user ID is always readily available through session object "user".
     *
     * @param userID User in questions ID
     */
    public Cart(int userID)
    {
        this.userID = userID;
    }

    /**
     *
     *
     * @return returns all the cakes currently in the Cart.
     */
    public ArrayList<Model_CupCake> getCakes()
    {
        return cakes;
    }

    /**
     * Updates the ArrayList of cakes.
     *
     * @param cakes the ArrayList to update to.
     */
    public void setCakes(ArrayList<Model_CupCake> cakes)
    {
        this.cakes = cakes;
    }

    /**
     * The User ID that the Cart-object belongs to.
     *
     * @return Returns the userID of the cart.
     */
    public int getUserID()
    {
        return userID;
    }

    /**
     * Add a specific cupcake to the cakes ArrayList.
     *
     * @param cupcake The cupcake in question.
     */
    public void addToCart(Model_CupCake cupcake)
    {
        cakes.add(cupcake);
    }

    /**
     *
     * In case of an successful order, a request to clear the cart or a session
     * runout, this command can be used to wipe the ArrayLists contents and
     * therefore return a new cart.
     *
     */
    public void clearCart()
    {
        cakes = new ArrayList();
    }

    public void removeSpecific(int cakeNumber) throws IndexOutOfBoundsException
    {
        cakes.remove(cakeNumber);
    }
    
}
