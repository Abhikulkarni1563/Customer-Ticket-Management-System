import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CustomerSupportSystem {
    private static int ticketCounter = 1001;
    private static Map<Integer, String[]> tickets = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Customer Support Ticket System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);
        
        JLabel issueLabel = new JLabel("Issue Category:");
        String[] issues = {"Network Issue", "Billing Problem", "Service Request"};
        JComboBox<String> issueDropdown = new JComboBox<>(issues);
        
        JLabel descLabel = new JLabel("Description:");
        JTextField descField = new JTextField(20);
        
        JButton submitButton = new JButton("Submit Ticket");
        JLabel ticketLabel = new JLabel("Ticket ID: ");
        JTextField ticketField = new JTextField(10);
        JButton checkStatusButton = new JButton("Check Status");
        JLabel statusLabel = new JLabel("Status: ");
        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String issue = (String) issueDropdown.getSelectedItem();
                String desc = descField.getText();
                if (!name.isEmpty() && !desc.isEmpty()) {
                    tickets.put(ticketCounter, new String[]{name, issue, desc, "Pending"});
                    JOptionPane.showMessageDialog(frame, "Ticket Submitted! Your ID: " + ticketCounter);
                    ticketCounter++;
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields!");
                }
            }
        });
        
        checkStatusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int ticketID = Integer.parseInt(ticketField.getText());
                    if (tickets.containsKey(ticketID)) {
                        statusLabel.setText("Status: " + tickets.get(ticketID)[3]);
                    } else {
                        statusLabel.setText("Invalid Ticket ID!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter a valid Ticket ID!");
                }
            }
        });
        
        frame.add(nameLabel); frame.add(nameField);
        frame.add(issueLabel); frame.add(issueDropdown);
        frame.add(descLabel); frame.add(descField);
        frame.add(submitButton);
        frame.add(ticketLabel); frame.add(ticketField);
        frame.add(checkStatusButton);
        frame.add(statusLabel);
        
        frame.setVisible(true);
    }
}
