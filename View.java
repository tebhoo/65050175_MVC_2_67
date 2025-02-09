import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class View extends JFrame {
    private JTextField suitIdField = new JTextField(6);
    private JButton checkButton = new JButton("Check Suit");
    private JButton repairButton = new JButton("Repair Suit");
    private JLabel suitInfo = new JLabel("");
    private JLabel resultLabel = new JLabel("Enter a suit ID to check.");
    private JLabel repairCountLabel = new JLabel("");

    public View() {
        setTitle("Superhero Suit Check");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Suit ID: "));
        add(suitIdField);
        add(checkButton);
        add(repairButton);
        add(suitInfo);
        add(resultLabel);
        add(repairCountLabel);

        repairButton.setEnabled(false);
        setVisible(true);
    }

    public String getSuitIdInput() {
        return suitIdField.getText();
    }

    public void setSuitInfo(String text) {
        suitInfo.setText(text);
    }

    public void setResultText(String text) {
        resultLabel.setText(text);
    }

    public void setRepairCountText(String text) {
        repairCountLabel.setText(text);
    }

    public void enableRepairButton(boolean enable) {
        repairButton.setEnabled(enable);
    }

    public void addCheckListener(ActionListener listener) {
        checkButton.addActionListener(listener);
    }

    public void addRepairListener(ActionListener listener) {
        repairButton.addActionListener(listener);
    }
}
