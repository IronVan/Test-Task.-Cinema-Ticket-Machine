package common.kitchen;

import view.MainForm;

public class VIPSeat implements IPlaces{

    private float price = (float) 12.9;
    private int quantity = 10;
    private String type = "VIPSeat";
    private static final VIPSeat INSTANCE = new VIPSeat();

    private VIPSeat(){}

    public static VIPSeat getVipSeat(){
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
        MainForm.getMainForm().labelVipSeatQuantity.setText(String.valueOf(quantity));
    }
}
