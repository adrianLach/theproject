package de.tp.user.ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class UserDetailsWindow extends JPanel {
    public JLabel lblLoginName;
    public JTextField tfLoginName;
    public JLabel lblNewPassword;
    public JLabel lblNewPassword2;
    public JPasswordField tfNewPassword;
    public JPasswordField tfPassword2;
    public JButton btnChangePassword;
    public JLabel lblOldPassword;
    public JPasswordField tfOldPassword;
    
    /**
     * Create the panel.
     */
    public UserDetailsWindow() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new MigLayout("", "[][][grow][]", "[][][][][][][][]"));
        {
            this.lblLoginName = new JLabel("Login Name");
            add(this.lblLoginName, "cell 1 1,alignx trailing");
        }
        {
            this.tfLoginName = new JTextField();
            this.tfLoginName.setEditable(false);
            add(this.tfLoginName, "cell 2 1,growx");
            this.tfLoginName.setColumns(10);
        }
        {
            this.lblOldPassword = new JLabel("Old Password");
            add(this.lblOldPassword, "cell 1 3,alignx trailing");
        }
        {
            this.tfOldPassword = new JPasswordField();
            add(this.tfOldPassword, "cell 2 3,growx");
        }
        {
            this.lblNewPassword = new JLabel("New Password");
            add(this.lblNewPassword, "cell 1 4,alignx trailing");
        }
        {
            this.tfNewPassword = new JPasswordField();
            add(this.tfNewPassword, "cell 2 4,growx");
        }
        {
            this.lblNewPassword2 = new JLabel("Repeat New Password");
            add(this.lblNewPassword2, "cell 1 5,alignx trailing");
        }
        {
            this.tfPassword2 = new JPasswordField();
            add(this.tfPassword2, "cell 2 5,growx");
        }
        {
            this.btnChangePassword = new JButton("Change Password");
            add(this.btnChangePassword, "cell 2 6,growx");
        }
        
    }
    
}
