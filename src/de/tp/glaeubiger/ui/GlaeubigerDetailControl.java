package de.tp.glaeubiger.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.tp.framework.sql.Buffer_auftraege;

public class GlaeubigerDetailControl {
    
    private Buffer_auftraege buffer;
    
    private GlaeubigerDetail gui = new GlaeubigerDetail();
    
    private boolean modeEdit = false;
    private boolean modeNew = false;
    
    public GlaeubigerDetailControl() {
    }
    
    public void setBuffer(Buffer_auftraege buffer) {
        this.buffer = buffer;
    }
    
    public GlaeubigerDetail getGui() {
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
        gui.tfGlaeubiger.setEditable(true);
        gui.tfGlaeubiger.setText("");
        gui.tfBez.setText("");
    }
    
    public void setModeEdit() {
        modeNew = false;
        modeEdit = true;
        gui.tfGlaeubiger.setEditable(false);
        ResultSet rs = buffer.getResultSet();
        
        try {
            gui.tfGlaeubiger.setText(rs.getString(1));
            gui.tfBez.setText(rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
