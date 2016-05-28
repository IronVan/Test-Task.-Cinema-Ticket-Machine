package view;

import common.Listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {

    private JPanel panel1;
    private JButton buttonCancel;
    private JButton buttonAddFunds;
    private JButton VIPSeatButton;
    private JButton frontStallsButton;
    private JButton middleStallsButton;
    private JButton backStallsButton;
    private JPanel rootPanel;
    public JLabel labelAddedMoney;

    public MainForm() {
        super("Cinema Ticket Machine");
        createMainForm();
    }

    private void createMainForm() {
        setContentPane(rootPanel);
        pack();
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        labelAddedMoney.setText("Total money: " + AddFundsForm.getSum());

        buttonAddFunds.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddFundsForm();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (AddFundsForm.getSum() == 0) {
                    JOptionPane.showMessageDialog(null, "Thanks for visit");
                } else {
                    JOptionPane.showMessageDialog(null, "Take your money: " + AddFundsForm.getSum());
                    AddFundsForm.setSum(0);
                }
            }
        });

        VIPSeatButton.addActionListener(new Listeners());
        frontStallsButton.addActionListener(new Listeners());
        middleStallsButton.addActionListener(new Listeners());
        backStallsButton.addActionListener(new Listeners());
    }
}
