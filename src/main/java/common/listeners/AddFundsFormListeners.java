package common.listeners;

import common.kitchen.Machine;
import view.AddFundsForm;
import view.MainForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFundsFormListeners implements ActionListener {

    private AddFundsForm addFundsForm;

    public AddFundsFormListeners(AddFundsForm addFundsForm) {
        this.addFundsForm = addFundsForm;
    }

    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        Machine machine = new Machine();

        if (button == addFundsForm.nextButton) {

            String inputData = addFundsForm.textField.getText();
            if (inputData == null || inputData.equals("")) {
                JOptionPane.showMessageDialog(null, "The machine can accept the following only – 10p(0.1£), 20p(0.2£), 50p(0.5£), £1.00, £2.00, £5, £10 and £20");
                return;
            }

            float addedMoney = Float.parseFloat(inputData);
            if (machine.checkNominals(addedMoney)) {
                AddFundsForm.sum += addedMoney;
                addFundsForm.textField.setText("");
                addFundsForm.totalMoney.setText(String.valueOf(addFundsForm.getSum()));
            } else {
                JOptionPane.showMessageDialog(null, "The machine can accept the following only – 10p(0.1£), 20p(0.2£), 50p(0.5£), £1.00, £2.00, £5, £10 and £20");
                addFundsForm.textField.setText("");
                return;
            }

        } else if (button == addFundsForm.finishButton) {

            MainForm mainForm = MainForm.getMainForm();
            mainForm.labelAddedMoney.setText("Added funds: " + String.valueOf(AddFundsForm.getSum()));
            addFundsForm.dispose();

        } else if (button == addFundsForm.cancelButton) {

            if (addFundsForm.getSum() == 0) {
                JOptionPane.showMessageDialog(null, "Thanks for visit");
            } else {
                JOptionPane.showMessageDialog(null, "Take your money: " + machine.getRemains(AddFundsForm.getSum()));
                addFundsForm.setSum(0);
            }
            addFundsForm.dispose();

        }
    }
}
