package de.tp.auftraege.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.tp.framework.sql.Buffer_glaeubiger;
import de.tp.glaeubiger.GlaeubigerItem;

public class AuftraegeDetailControl {
    
    private Buffer_glaeubiger buffer;
    
    private AuftraegeDetail gui = new AuftraegeDetail();
    
    private boolean modeEdit = false;
    private boolean modeNew = false;
    
    public AuftraegeDetailControl() {
    }
    
    public int getSelectedGlaeubiger() {
        return ((GlaeubigerItem) gui.glaeubigerComboBox.getSelectedItem()).getId();
    }
    
    public void setBuffer(Buffer_glaeubiger buffer) {
        this.buffer = buffer;
    }
    
    public AuftraegeDetail getGui() {
        return gui;
    }
    
    public boolean isModeEdit() {
        return modeEdit;
    }
    
    public boolean isModeNew() {
        return modeNew;
    }
    
    public void setModeNew() {
        modeNew = true;
        modeEdit = false;
        gui.tfAuftragsnr.setText("");
        gui.tfAuftragsdatum.setText("");
        gui.tfSumme.setText("");
    }
    
    public void setModeEdit() {
        modeNew = false;
        modeEdit = true;
        ResultSet rs = buffer.getResultSet();
        
        try {
            gui.tfAuftragsnr.setText(rs.getString(1));
            gui.tfAuftragsdatum.setText(rs.getString(3));
            gui.tfSumme.setText(rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
