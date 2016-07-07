package view;

import common.kitchen.IPlaces;
import common.listeners.TicketFormListeners;

import javax.swing.*;

public class TicketForm extends JFrame{
    public JTextField textField;
    public JButton buyButton;
    public JButton cancelButton;
    private JPanel panel;
    public JButton addFundsButton;
    public IPlaces places;

    public TicketForm (IPlaces places){
        super("TicketForm");
        this.places = places;
        createTicketForm();
    }

    private void createTicketForm(){
        setContentPane(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        TicketFormListeners ticketFormListeners = new TicketFormListeners(this);

        buyButton.addActionListener(ticketFormListeners);
        cancelButton.addActionListener(ticketFormListeners);
        addFundsButton.addActionListener(ticketFormListeners);

    }
}
