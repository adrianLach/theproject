package de.tp.user.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class UserFilter extends JDialog {
    
    private final JPanel contentPanel = new JPanel();
    public JTextField textField;
    public JTextField textField_1;
    public JButton okButton;
    public JButton cancelButton;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UserFilter dialog = new UserFilter();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create the dialog.
     */
    public UserFilter() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(this.contentPanel, BorderLayout.CENTER);
        this.contentPanel.setLayout(new MigLayout("", "[][][grow]", "[][][]"));
        {
            JLabel lblNewLabel = new JLabel("Login Name");
            this.contentPanel.add(lblNewLabel, "cell 1 1,alignx trailing");
        }
        {
            this.textField = new JTextField();
            this.contentPanel.add(this.textField, "cell 2 1,growx");
            this.textField.setColumns(10);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("Password");
            this.contentPanel.add(lblNewLabel_1, "cell 1 2,alignx trailing");
        }
        {
            this.textField_1 = new JTextField();
            this.contentPanel.add(this.textField_1, "cell 2 2,growx");
            this.textField_1.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
    
}
