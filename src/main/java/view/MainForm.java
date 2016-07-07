package view;

import common.kitchen.BackStall;
import common.kitchen.FrontStall;
import common.kitchen.MiddleStall;
import common.kitchen.VIPSeat;
import common.listeners.MainFormListeners;

import javax.swing.*;

public class MainForm extends JFrame {

    private JPanel panel1; //don't need
    public JButton buttonCancel;
    public JButton buttonAddFunds;
    public JButton VIPSeatButton;
    public JButton frontStallsButton;
    public JButton middleStallsButton;
    public JButton backStallsButton;
    public JPanel rootPanel;
    public JLabel labelAddedMoney;
    public JLabel labelVipSeatQuantity;
    public JLabel labelFrontStallsQuantity;
    public JLabel labelMiddleStallsQuantity;
    public JLabel labelBackStallsQuantity;

    private MainForm() {
        super("Cinema Ticket Machine");
        createMainForm();
    }

    private static MainForm mainForm;

    public static MainForm getMainForm() {

        if (mainForm == null) {
            mainForm = new MainForm();
            return mainForm;
        }
        return mainForm;
    }

    private void createMainForm() {
        setContentPane(rootPanel);
        pack();
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        labelAddedMoney.setText("Added funds: " + AddFundsForm.getSum());

        labelVipSeatQuantity.setText(String.valueOf(VIPSeat.getVipSeat().getQuantity()));
        labelMiddleStallsQuantity.setText(String.valueOf(MiddleStall.getMiddleStall().getQuantity()));
        labelFrontStallsQuantity.setText(String.valueOf(FrontStall.getFrontStall().getQuantity()));
        labelBackStallsQuantity.setText(String.valueOf(BackStall.getBackStall().getQuantity()));

        MainFormListeners mainFormListeners = new MainFormListeners(this);

        buttonAddFunds.addActionListener(mainFormListeners);
        buttonCancel.addActionListener(mainFormListeners);
        VIPSeatButton.addActionListener(mainFormListeners);
        frontStallsButton.addActionListener(mainFormListeners);
        middleStallsButton.addActionListener(mainFormListeners);
        backStallsButton.addActionListener(mainFormListeners);
    }
}
