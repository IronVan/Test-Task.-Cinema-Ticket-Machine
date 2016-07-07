package common.kitchen;

public interface IPlaces {
    float getPrice();
    int getQuantity();
    void setQuantity(int quantity);
    void changeQuantity(int quantity);
    String getType();
}
