package dao;

import java.sql.Date;
import java.sql.Time;

public class Ticket {

    private int id;
    private String type;
    private String date;
    private String time;
    private float payment;
    private int quantity;

    public Ticket(){}

    public Ticket(int id, String type, String date, String time, float payment, int quantity) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.time = time;
        this.payment = payment;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "id = " + id + " Type: " + type + " Date: " + date + " Time: " + time + " Payment: " + payment + " Quantity: " + quantity + "\t\n";
    }
}
