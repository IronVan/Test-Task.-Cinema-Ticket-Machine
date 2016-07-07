package common.kitchen;

import view.MainForm;

public class FrontStall implements IPlaces {

    private float price = (float) 9.5;
    private int quantity = 10;
    private String type = "FrontStall";
    private static final FrontStall INSTANCE = new FrontStall();

    private FrontStall() {
    }

    public static FrontStall getFrontStall() {
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
        MainForm.getMainForm().labelFrontStallsQuantity.setText(String.valueOf(quantity));
    }
}
