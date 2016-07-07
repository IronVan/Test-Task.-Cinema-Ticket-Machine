package common.kitchen;

import common.kitchen.IPlaces;
import view.MainForm;

public class BackStall implements IPlaces {

    private float price = (float) 6.7;
    private int quantity = 10;
    private String type = "BackStall";
    private static final BackStall INSTANCE = new BackStall();

    private BackStall() {
    }

    public static BackStall getBackStall() {
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
        MainForm.getMainForm().labelBackStallsQuantity.setText(String.valueOf(quantity));
    }
}
