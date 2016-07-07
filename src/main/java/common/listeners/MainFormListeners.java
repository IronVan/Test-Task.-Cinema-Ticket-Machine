package common.listeners;

import common.kitchen.*;
import view.AddFundsForm;
import view.MainForm;
import view.TicketForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Без проверки на символы
public class MainFormListeners implements ActionListener {

    MainForm mainForm;

    public MainFormListeners(MainForm mainForm) {
        this.mainForm = mainForm;
    }

    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        Machine machine = new Machine();

        if (button == mainForm.VIPSeatButton) {
            new TicketForm(VIPSeat.getVipSeat());
        } else if (e.getSource() == mainForm.frontStallsButton) {
            new TicketForm(FrontStall.getFrontStall());
        } else if (button == mainForm.middleStallsButton) {
            new TicketForm(MiddleStall.getMiddleStall());
        } else if (button == mainForm.backStallsButton) {
            new TicketForm(BackStall.getBackStall());
        } else if (button == mainForm.buttonAddFunds) {
            new AddFundsForm();
        } else if (button == mainForm.buttonCancel) {
            if (AddFundsForm.getSum() == 0) {
                JOptionPane.showMessageDialog(null, "Thanks for visit");
            } else {
                JOptionPane.showMessageDialog(null, "Take your money: " + machine.getRemains(AddFundsForm.getSum()));
                AddFundsForm.setSum(0);
                mainForm.labelAddedMoney.setText("Added funds: 0");
            }
            System.exit(0);
        }
    }
}
