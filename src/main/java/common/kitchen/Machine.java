package common.kitchen;

import dao.Ticket;
import dao.TicketJdbcLogger;
import view.AddFundsForm;
import view.MainForm;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Machine {

    float[] nominals = {20, 10, 5, 2, 1, 0.5f, 0.2f, 0.1f};
    ArrayList remains = new ArrayList();
    MainForm mainForm = MainForm.getMainForm();
    TicketJdbcLogger ticketJdbcLogger = new TicketJdbcLogger();

    Date now = new Date();
    DateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
    DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
    String nowTime = formatterTime.format(now);
    String nowDate = formatterDate.format(now);

    //Алгоритм выдачи сдачи. Немного кривоват.
    public ArrayList getRemains(float sum) {

        for (int i = 0; i < nominals.length; i++) {
            if (sum > nominals[i]) {
                while (sum >= nominals[i]) {
                    sum -= nominals[i];
                    remains.add(nominals[i]);
                }
                if (sum < 0.1 && sum != 0) {
                    remains.add(0.1);
                }
            }
        }
        return remains;
    }

    //Проверка на правильность номинала
    public boolean checkNominals(float nominal) {

        for (int i = 0; i < nominals.length; i++) {
            if (nominal == nominals[i]) {
                return true;
            }
        }
        return false;
    }

    //Покупка билетов
    public void makePurchase(IPlaces places, int ticketsQuantity) {
        float summa = places.getPrice() * ticketsQuantity;
        float remains = AddFundsForm.getSum() - summa;

        if (ticketsQuantity > places.getQuantity()) {
            JOptionPane.showMessageDialog(null, "We have no enough tickets!");
            return;
        }

        if (remains >= 0) {
            int tickets = places.getQuantity() - ticketsQuantity;
            places.setQuantity(tickets);
            places.changeQuantity(tickets);
            AddFundsForm.sum = 0;

            Ticket ticket = new Ticket();
            ticket.setType(places.getType());
            ticket.setDate(nowDate);
            ticket.setTime(nowTime);
            ticket.setPayment(summa);
            ticket.setQuantity(ticketsQuantity);

            ticketJdbcLogger.addTicket(ticket);
            ticketJdbcLogger.close();

            mainForm.labelAddedMoney.setText("Added funds: 0");
            JOptionPane.showMessageDialog(null, "Take your tickets! Your remains - " + getRemains(remains));
        } else {
            JOptionPane.showMessageDialog(null, "You don't have enough money! Please, press 'Add Funds' ");
        }
    }
}
