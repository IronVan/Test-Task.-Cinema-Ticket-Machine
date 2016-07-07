package common.kitchen;


import view.MainForm;

public class MiddleStall implements IPlaces {

    private float price = (float) 7.3;
    private int quantity = 10;
    private String type = "MiddleStall";
    private static final MiddleStall INSTANCE = new MiddleStall();

    private MiddleStall() {
    }

    public static MiddleStall getMiddleStall() {
        return INSTANCE;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void changeQuantity(int quantity) {
        MainForm.getMainForm().labelMiddleStallsQuantity.setText(String.valueOf(quantity));
    }
}
