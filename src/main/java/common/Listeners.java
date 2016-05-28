package common;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listeners implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(null, e.getActionCommand());


        /*if (e.getSource() == VIPSeatButton){
            JOptionPane.showMessageDialog(null, "1");
        }else if (e.getSource() == frontStallsButton){
            JOptionPane.showMessageDialog(null, "2");
        }*/
    }
}
