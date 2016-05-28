package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFundsForm extends JFrame {

    private JPanel rootPanel;
    private JButton nextButton;
    private JButton finishButton;
    private JButton cancelButton;
    private JTextField textField;
    private JLabel totalMoney;
    private static double sum;

    public AddFundsForm() {
        super("Add Funds");
        setContentPane(rootPanel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        totalMoney.setText(String.valueOf(getSum()));

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String inputData = textField.getText();
                if (inputData == null || inputData.equals("")) {
                    JOptionPane.showMessageDialog(null, "The machine can accept the following only – 10p(0.1£), 20p(0.2£), 50p(0.5£), £1.00, £2.00, £5, £10 and £20");
                    return;
                }

                double addedMoney = Double.parseDouble(inputData);
                if (addedMoney == 0) {
                    JOptionPane.showMessageDialog(null, "The machine can accept the following only – 10p(0.1£), 20p(0.2£), 50p(0.5£), £1.00, £2.00, £5, £10 and £20");
                    textField.setText("");
                    return;
                }

                if (addedMoney == 0.1 || addedMoney == 0.2 || addedMoney == 0.5 || addedMoney == 1 || addedMoney == 2
                        || addedMoney == 5 || addedMoney == 10 || addedMoney == 20) {
                    sum += addedMoney;
                    //setSum(addedMoney);
                    //MainForm mainForm = new MainForm().setAddedMoney(String.valueOf(addedMoney));
                    textField.setText("");
                    totalMoney.setText(String.valueOf(sum));
                } else {
                    JOptionPane.showMessageDialog(null, "The machine can accept the following only – 10p(0.1£), 20p(0.2£), 50p(0.5£), £1.00, £2.00, £5, £10 and £20");
                    textField.setText("");
                    return;
                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (getSum() == 0) {
                    JOptionPane.showMessageDialog(null, "Thanks for visit");
                } else {
                    JOptionPane.showMessageDialog(null, "Take your money: " + getSum());
                    setSum(0);
                }
                dispose();
            }
        });

        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //дописать передачу параметров на главную форму
                dispose();
            }
        });
    }

    public static double getSum() {
        return sum;
    }

    public static void setSum(double sum) {
        AddFundsForm.sum = +sum;
    }
}
