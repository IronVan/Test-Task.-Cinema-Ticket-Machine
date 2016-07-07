package view;

import common.listeners.AddFundsFormListeners;

import javax.swing.*;

//Нету обработки на ввод символов в JTextField
public class AddFundsForm extends JFrame {

    private JPanel rootPanel;
    public JButton nextButton;
    public JButton finishButton;
    public JButton cancelButton;
    public JTextField textField;
    public JLabel totalMoney;
    public static float sum;

    public AddFundsForm() {
        super("Add Funds");
        createAddFundsForm();
    }

    public static float getSum() {
        return sum;
    }

    public static void setSum(float sum) {
        AddFundsForm.sum = +sum;
    }

    private void createAddFundsForm() {
        setContentPane(rootPanel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        totalMoney.setText(String.valueOf(getSum()));

        AddFundsFormListeners addFundsFormListeners = new AddFundsFormListeners(this);

        nextButton.addActionListener(addFundsFormListeners);
        cancelButton.addActionListener(addFundsFormListeners);
        finishButton.addActionListener(addFundsFormListeners);

    }
}
