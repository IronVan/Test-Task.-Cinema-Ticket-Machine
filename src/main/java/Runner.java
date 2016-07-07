import view.MainForm;

import javax.swing.*;

public class Runner {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainForm.getMainForm();
            }
        });
    }
}
