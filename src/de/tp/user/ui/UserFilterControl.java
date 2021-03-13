package de.tp.user.ui;

import java.util.HashMap;

public class UserFilterControl {
    
    private UserFilter gui;
    
    private boolean checkOK = false;
    
    public UserFilterControl() {
        gui = new UserFilter();
    }
    
    public void showGUI() {
        this.gui.cancelButton.addActionListener(e -> this.onButtonCancel());
        this.gui.okButton.addActionListener(e -> this.onButtonOk());
        gui.setTitle("Filter *user*");
        gui.setModal(true);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
    
    public UserFilter getGui() {
        return gui;
    }
    
    public static void main(String[] args) {
        new UserFilterControl().getFilters();
    }
    
    public HashMap<Integer, String> getFilters() {
        HashMap<Integer, String> map = new HashMap<>();
        
        showGUI();
        
        if (checkOK) {
            map.put(0, gui.textField.getText());
            map.put(1, gui.textField_1.getText());
        }
        
        checkOK = false;
        return map;
    }
    
    public void onButtonOk() {
        this.gui.dispose();
        checkOK = true;
    }
    
    public void onButtonCancel() {
        this.gui.dispose();
        checkOK = false;
    }
    
}
