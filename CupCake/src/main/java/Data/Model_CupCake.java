package Data;

/**
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
     */
    public Model_CupCake()
    {
    }

    /**
     *
     * @param bottomID
     * @param topID
     * @param bottomName
     * @param topName
     * @param bottomPrice
     * @param topPrice
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

    /**
     *
     * @return
     */
    public double getTotalPrice()
    {
        return totalPrice;
    }

    /**
     *
     * @return
     */
    public int getBottomID()
    {
        return bottomID;
    }

    /**
     *
     * @param bottomID
     */
    public void setBottomID(int bottomID)
    {
        this.bottomID = bottomID;
    }

    /**
     *
     * @return
     */
    public int getTopID()
    {
        return topID;
    }

    /**
     *
     * @param topID
     */
    public void setTopID(int topID)
    {
        this.topID = topID;
    }

    /**
     *
     * @return
     */
    public String getBottomName()
    {
        return bottomName;
    }

    /**
     *
     * @param bottomName
     */
    public void setBottomName(String bottomName)
    {
        this.bottomName = bottomName;
    }

    /**
     *
     * @return
     */
    public String getTopName()
    {
        return topName;
    }

    /**
     *
     * @param topName
     */
    public void setTopName(String topName)
    {
        this.topName = topName;
    }

    /**
     *
     * @return
     */
    public double getBottomPrice()
    {
        return bottomPrice;
    }

    /**
     *
     * @param bottomPrice
     */
    public void setBottomPrice(double bottomPrice)
    {
        this.bottomPrice = bottomPrice;
    }

    /**
     *
     * @return
     */
    public double getTopPrice()
    {
        return topPrice;
    }

    /**
     *
     * @param topPrice
     */
    public void setTopPrice(double topPrice)
    {
        this.topPrice = topPrice;
    }

    /**
     *
     */
    public static class Cupcake_Top
    {

        private int topID;
        private String topName;
        private double topPrice;

        /**
         *
         * @param topID
         * @param topName
         * @param topPrice
         */
        public Cupcake_Top(int topID, String topName, double topPrice)
        {
            this.topID = topID;
            this.topName = topName;
            this.topPrice = topPrice;
        }

        /**
         *
         * @return
         */
        public int getTopID()
        {
            return topID;
        }

        /**
         *
         * @param topID
         */
        public void setTopID(int topID)
        {
            this.topID = topID;
        }

        /**
         *
         * @return
         */
        public String getTopName()
        {
            return topName;
        }

        /**
         *
         * @param topName
         */
        public void setTopName(String topName)
        {
            this.topName = topName;
        }

        /**
         *
         * @return
         */
        public double getTopPrice()
        {
            return topPrice;
        }

        /**
         *
         * @param topPrice
         */
        public void setTopPrice(double topPrice)
        {
            this.topPrice = topPrice;
        }
    }

    /**
     *
     */
    public static class Cupcake_Bottom
    {

        private int bottomID;
        private String bottomName;
        private double bottomPrice;

        /**
         *
         * @param bottomID
         * @param bottomName
         * @param bottomPrice
         */
        public Cupcake_Bottom(int bottomID, String bottomName, double bottomPrice)
        {
            this.bottomID = bottomID;
            this.bottomName = bottomName;
            this.bottomPrice = bottomPrice;
        }

        /**
         *
         * @return
         */
        public int getBottomID()
        {
            return bottomID;
        }

        /**
         *
         * @param bottomID
         */
        public void setBottomID(int bottomID)
        {
            this.bottomID = bottomID;
        }

        /**
         *
         * @return
         */
        public String getBottomName()
        {
            return bottomName;
        }

        /**
         *
         * @param bottomName
         */
        public void setBottomName(String bottomName)
        {
            this.bottomName = bottomName;
        }

        /**
         *
         * @return
         */
        public double getBottomPrice()
        {
            return bottomPrice;
        }

        /**
         *
         * @param bottomPrice
         */
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
