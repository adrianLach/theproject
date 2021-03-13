package de.tp.glaeubiger.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class GlaeubigerDetail extends JPanel {
    public JLabel lblGlaeubiger;
    public JLabel lblBez;
    public JTextField tfGlaeubiger;
    public JTextField tfBez;
    
    /**
     * Create the panel.
     */
    public GlaeubigerDetail() {
        setLayout(new MigLayout("", "[][][grow]", "[][][]"));
        {
            this.lblGlaeubiger = new JLabel("Gl\u00E4ubiger");
            add(this.lblGlaeubiger, "cell 1 1,alignx trailing");
        }
        {
            this.tfGlaeubiger = new JTextField();
            add(this.tfGlaeubiger, "cell 2 1,growx");
            this.tfGlaeubiger.setColumns(10);
        }
        {
            this.lblBez = new JLabel("Bezeichnung");
            add(this.lblBez, "cell 1 2,alignx trailing");
        }
        {
            this.tfBez = new JTextField();
            add(this.tfBez, "cell 2 2,growx");
            this.tfBez.setColumns(10);
        }
        
    }
    
}
