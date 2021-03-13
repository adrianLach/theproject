package de.tp.auftraege.ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.tp.glaeubiger.comp.GlaeubigerComboBox;
import net.miginfocom.swing.MigLayout;

public class AuftraegeDetail extends JPanel {
    public JLabel lblAuftrag;
    public JLabel lblGlaeubiger;
    public JTextField tfAuftragsnr;
    public JLabel lblDatum;
    public JTextField tfAuftragsdatum;
    public JLabel lblSumme;
    public JTextField tfSumme;
    public GlaeubigerComboBox glaeubigerComboBox;
    public JButton btnNewButton;
    
    /**
     * Create the panel.
     */
    public AuftraegeDetail() {
        setLayout(new MigLayout("", "[][][grow]", "[][][][][]"));
        {
            this.lblAuftrag = new JLabel("Auftrags Nr.");
            add(this.lblAuftrag, "cell 1 1,alignx trailing");
        }
        {
            this.tfAuftragsnr = new JTextField();
            add(this.tfAuftragsnr, "cell 2 1,growx");
            this.tfAuftragsnr.setColumns(10);
        }
        {
            this.lblGlaeubiger = new JLabel("Gl\u00E4ubiger");
            add(this.lblGlaeubiger, "cell 1 2,alignx trailing");
        }
        {
            this.glaeubigerComboBox = new GlaeubigerComboBox();
            add(this.glaeubigerComboBox, "cell 2 2,growx");
        }
        {
            this.lblDatum = new JLabel("Auftragsdatum");
            add(this.lblDatum, "cell 1 3,alignx trailing");
        }
        {
            this.tfAuftragsdatum = new JTextField();
            add(this.tfAuftragsdatum, "flowx,cell 2 3,growx");
            this.tfAuftragsdatum.setColumns(10);
        }
        {
            this.lblSumme = new JLabel("Summe");
            add(this.lblSumme, "cell 1 4,alignx trailing");
        }
        {
            this.tfSumme = new JTextField();
            add(this.tfSumme, "cell 2 4,growx");
            this.tfSumme.setColumns(10);
        }
        {
            this.btnNewButton = new JButton("New button");
            add(this.btnNewButton, "cell 2 3");
        }
        
    }
    
}
