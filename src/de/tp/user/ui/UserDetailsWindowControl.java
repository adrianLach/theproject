package de.tp.user.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.tp.framework.message.MessageBoxWindowControl;
import de.tp.framework.sql.Buffer;

public class UserDetailsWindowControl {
    
    private UserDetailsWindow gui;
    
    private Buffer buffer;
    
    public UserDetailsWindowControl() {
        this.gui = new UserDetailsWindow();
        this.gui.btnChangePassword.addActionListener(e -> UserDetailsWindowControl.this.onButtonChangePassword());
    }
    
    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }
    
    public void setPanelModeNew() {
        gui.tfOldPassword.setVisible(false);
        gui.lblOldPassword.setVisible(false);
        gui.tfPassword2.setVisible(false);
        gui.lblNewPassword2.setVisible(false);
        gui.btnChangePassword.setVisible(false);
        gui.tfLoginName.setEditable(true);
        gui.tfLoginName.setText("");
    }
    
    public void setPanelModeEdit() {
        gui.tfOldPassword.setVisible(true);
        gui.lblOldPassword.setVisible(true);
        gui.tfPassword2.setVisible(true);
        gui.lblNewPassword2.setVisible(true);
        gui.btnChangePassword.setVisible(true);
        gui.tfLoginName.setEditable(false);
    }
    
    public UserDetailsWindow getGui() {
        return this.gui;
    }
    
    public void initData() {
        ResultSet rs = buffer.getResultSet();
        try {
            gui.tfLoginName.setText(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void showGUI() {
        this.gui.setVisible(true);
    }
    
    private void onButtonChangePassword() {
        
        if (!gui.tfNewPassword.getText().equals(gui.tfPassword2.getText())) {
            new MessageBoxWindowControl("Incorrect Password", "Passwords not matching! Check your spelling!").showGUI();
            return;
        }
        
        new MessageBoxWindowControl("Password changed", "Password changed successfully!").showGUI();
    }
    
}
