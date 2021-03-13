package de.tp.main;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.tp.auftraege.ui.AuftraegeGUIControl;
import de.tp.glaeubiger.ui.GlaeubigerGUIControl;

public class MainWindowControl {
    
    private MainWindow gui;
    
    public void showGUI() {
        this.gui = new MainWindow();
        this.gui.setLocationRelativeTo(null);
        
        addOutlookItem("Gläubiger", new GlaeubigerGUIControl().getGui());
        addOutlookItem("Aufträge", new AuftraegeGUIControl().getGui());
        
        this.gui.setVisible(true);
    }
    
    public void addOutlookItem(String name, JPanel content) {
        var btn = new JButton(name);
        this.gui.plContent.add(content, name);
        btn.addActionListener(e -> {
            var cl = (CardLayout) MainWindowControl.this.gui.plContent.getLayout();
            cl.show(MainWindowControl.this.gui.plContent, name);
        });
        
        var gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = this.gui.plOutlook.getComponentCount();
        
        this.gui.plOutlook.add(btn, gbc);
    }
    
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        new MainWindowControl().showGUI();
    }
    
}
