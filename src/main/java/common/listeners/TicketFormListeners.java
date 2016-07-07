package common.listeners;

import common.kitchen.Machine;
import view.AddFundsForm;
import view.TicketForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Без проверки на символы и дробные числа
public class TicketFormListeners implements ActionListener {

    private TicketForm ticketForm;
    Machine machine = new Machine();

    public TicketFormListeners(TicketForm ticketForm) {
        this.ticketForm = ticketForm;
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button == ticketForm.cancelButton) {
            ticketForm.dispose();
        } else if (button == ticketForm.buyButton) {

            String text = ticketForm.textField.getText();
            if (text.equals("")){
                JOptionPane.showMessageDialog(null, "Enter number ");
            }else{
                int number = Integer.parseInt(text);
                machine.makePurchase(ticketForm.places, number);
            }

        } else if (button == ticketForm.addFundsButton) {
            new AddFundsForm();
        }
    }
}
