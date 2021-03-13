package de.tp.framework.comp;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class DatePicker extends Box {
    
    public JButton btnNewButton;
    public JTextField textField;
    
    public DatePicker(int axis) {
        super(BoxLayout.X_AXIS);
        
        {
            this.textField = new JTextField();
            this.add(this.textField);
            this.textField.setColumns(10);
        }
        {
            this.btnNewButton = new JButton("");
            this.btnNewButton.setPreferredSize(new Dimension(32, 32));
            this.btnNewButton.setIcon(new ImageIcon(DatePicker.class.getResource("/rcs/p32/calendar.png")));
            this.add(this.btnNewButton);
        }
    }
    
}
