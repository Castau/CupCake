package Data;

/**
 * Fields:
 *
 * BottomID: id of cupcake_bottom.
 *
 * topID: id of cupcake_top.
 *
 * bottomName - name of cupcake_bottom.
 *
 * topName - name of cupcake_top.
 *
 * bottomPrice - price of cupcake_bottom.
 *
 * topPrice - price of cupcake_top.
 *
 * totalPrice - combined price of cupcake_bottom and cupcake_top.
 *
 *
 * @author Camilla
 */
public class Model_CupCake
{

    private int bottomID;
    private int topID;
    private String bottomName;
    private String topName;
    private double bottomPrice;
    private double topPrice;
    private double totalPrice;

    /**
     *
     * Used for (empty) object creation.
     */
    public Model_CupCake()
    {
    }

    /**
     *
     * Java object for a cupcake (top + bottom).
     *
     * Used for handling of objects from backend to frontend and vice-versa.
     *
     * [bottomPrice and topPrice is used to calculate totalPrice.]
     *
     *
     * @param bottomID ID of cupcake_bottom
     * @param topID ID of cupcake_top
     * @param bottomName Name of cupcake_bottom
     * @param topName Name of cupcake_top
     * @param bottomPrice Price of cupcake_bottom
     * @param topPrice Price of cupcake_top
     */
    public Model_CupCake(int bottomID, int topID, String bottomName, String topName, double bottomPrice, double topPrice)
    {
        this.bottomID = bottomID;
        this.topID = topID;
        this.bottomName = bottomName;
        this.topName = topName;
        this.bottomPrice = bottomPrice;
        this.topPrice = topPrice;
        this.totalPrice = bottomPrice + topPrice;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public int getBottomID()
    {
        return bottomID;
    }

    public void setBottomID(int bottomID)
    {
        this.bottomID = bottomID;
    }

    public int getTopID()
    {
        return topID;
    }

    public void setTopID(int topID)
    {
        this.topID = topID;
    }

    public String getBottomName()
    {
        return bottomName;
    }

    public void setBottomName(String bottomName)
    {
        this.bottomName = bottomName;
    }

    public String getTopName()
    {
        return topName;
    }

    public void setTopName(String topName)
    {
        this.topName = topName;
    }

    public double getBottomPrice()
    {
        return bottomPrice;
    }

    public void setBottomPrice(double bottomPrice)
    {
        this.bottomPrice = bottomPrice;
    }

    public double getTopPrice()
    {
        return topPrice;
    }

    public void setTopPrice(double topPrice)
    {
        this.topPrice = topPrice;
    }

    /**
     *
     * Inner class used to display a cupcake_top by itself - no correlation to
     * cupcake_bottom. (Used for index.jsp tables as of writing).
     *
     */
    public static class Cupcake_Top
    {

        private int topID;
        private String topName;
        private double topPrice;

        /**
         *
         * @param topID ID of cupcake_top
         * @param topName Name of cupcake_top
         * @param topPrice Price of cupcake_top
         */
        public Cupcake_Top(int topID, String topName, double topPrice)
        {
            this.topID = topID;
            this.topName = topName;
            this.topPrice = topPrice;
        }

        public int getTopID()
        {
            return topID;
        }

        public void setTopID(int topID)
        {
            this.topID = topID;
        }

        public String getTopName()
        {
            return topName;
        }

        public void setTopName(String topName)
        {
            this.topName = topName;
        }

        public double getTopPrice()
        {
            return topPrice;
        }

        public void setTopPrice(double topPrice)
        {
            this.topPrice = topPrice;
        }
    }

    /**
     *
     * Inner class used to display a cupcake_bottom by itself - no correlation
     * to cupcake_top. (Used for index.jsp tables as of writing).
     *
     */
    public static class Cupcake_Bottom
    {

        private int bottomID;
        private String bottomName;
        private double bottomPrice;

        /**
         *
         * @param bottomID ID of cupcake_bottom.
         * @param bottomName Name of cupcake_bottom.
         * @param bottomPrice Price of cupcake_bottom.
         */
        public Cupcake_Bottom(int bottomID, String bottomName, double bottomPrice)
        {
            this.bottomID = bottomID;
            this.bottomName = bottomName;
            this.bottomPrice = bottomPrice;
        }

        public int getBottomID()
        {
            return bottomID;
        }

        public void setBottomID(int bottomID)
        {
            this.bottomID = bottomID;
        }

        public String getBottomName()
        {
            return bottomName;
        }

        public void setBottomName(String bottomName)
        {
            this.bottomName = bottomName;
        }

        public double getBottomPrice()
        {
            return bottomPrice;
        }

        public void setBottomPrice(double bottomPrice)
        {
            this.bottomPrice = bottomPrice;
        }

    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Model_CupCake other = (Model_CupCake) obj;
        if (this.bottomID != other.bottomID)
        {
            return false;
        }
        if (this.topID != other.topID)
        {
            return false;
        }
        return true;
    }

}
