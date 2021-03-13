package de.tp.framework.message;

public class MessageBoxWindowControl {
    
    private MessageBoxWindow gui;
    private String title;
    private String text;
    
    public MessageBoxWindowControl(String title, String text) {
        this.title = title;
        this.text = text;
    }
    
    public void showGUI() {
        this.gui = new MessageBoxWindow();
        this.gui.cancelButton.addActionListener(e -> MessageBoxWindowControl.this.onButtonCancel());
        this.gui.okButton.addActionListener(e -> MessageBoxWindowControl.this.onButtonOk());
        this.gui.textPane.setText(text);
        this.gui.setTitle(title);
        this.gui.setModal(true);
        this.gui.setVisible(true);
    }
    
    public void onButtonOk() {
        this.gui.dispose();
    }
    
    public void onButtonCancel() {
        this.gui.dispose();
    }
    
}
