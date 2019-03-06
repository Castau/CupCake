package Data;

/**
 * @author Camilla
 */
public class Model_CupCake {
    private int bottomID;
    private int topID;
    private String bottomName;
    private String topName;
    private double bottomPrice;
    private double topPrice;
    private double totalPrice;

    public Model_CupCake() {
    }

    public Model_CupCake(int bottomID, int topID, String bottomName, String topName, double bottomPrice, double topPrice) {
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
    
    public int getBottomID() {
        return bottomID;
    }

    public void setBottomID(int bottomID) {
        this.bottomID = bottomID;
    }

    public int getTopID() {
        return topID;
    }

    public void setTopID(int topID) {
        this.topID = topID;
    }

    public String getBottomName() {
        return bottomName;
    }

    public void setBottomName(String bottomName) {
        this.bottomName = bottomName;
    }

    public String getTopName() {
        return topName;
    }

    public void setTopName(String topName) {
        this.topName = topName;
    }

    public double getBottomPrice() {
        return bottomPrice;
    }

    public void setBottomPrice(double bottomPrice) {
        this.bottomPrice = bottomPrice;
    }

    public double getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(double topPrice) {
        this.topPrice = topPrice;
    }
    
}
