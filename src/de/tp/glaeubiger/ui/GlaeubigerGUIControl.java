package de.tp.glaeubiger.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import de.tp.framework.details.DetailViewControl;
import de.tp.framework.sql.Buffer_auftraege;
import de.tp.framework.sql.Filter;
import de.tp.framework.sql.SQL;
import de.tp.framework.tasks.ProcessTask;

public class GlaeubigerGUIControl extends DetailViewControl {
    
    private GlaeubigerTableControl tableControl = new GlaeubigerTableControl();
    private GlaeubigerDetailControl detailControl = new GlaeubigerDetailControl();
    
    private final Filter loadAllFilter = Filter.getFilter().select("*").from("glaeubiger");
    
    private Buffer_auftraege buffer = new Buffer_auftraege(SQL.getDefaultConnection());
    
    public GlaeubigerGUIControl() {
        addContents(tableControl.getGui(), detailControl.getGui());
        tableControl.setBuffer(buffer);
        detailControl.setBuffer(buffer);
        
        this.tableControl.getGui().table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                var table = (JTable) mouseEvent.getSource();
                var point = mouseEvent.getPoint();
                var row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    onTableDoubleClick(row);
                }
            }
        });
        
        this.tableControl.getGui().table.getSelectionModel().addListSelectionListener(e -> {
            try {
                this.buffer.getResultSet().absolute(e.getFirstIndex() + 1);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        
        setNaviButtonVisible(false);
        
        reloadSet();
    }
    
    private void onTableDoubleClick(int row) {
        System.out.println("UserBaseDataControl.onTableDoubleClick()");
        this.switchContentToDetail();
        updateNaviButtons();
        detailControl.setModeEdit();
    }
    
    @Override
    protected void onButtonSwitchContent() {
        super.onButtonSwitchContent();
        if (isContentViewDetail())
            detailControl.setModeEdit();
    }
    
    private void updateNaviButtons() {
        try {
            getGui().btnLast.setEnabled(!buffer.getResultSet().isLast());
            getGui().btnNext.setEnabled(!buffer.getResultSet().isLast());
            
            getGui().btnFirst.setEnabled(!buffer.getResultSet().isFirst());
            getGui().btnPrev.setEnabled(!buffer.getResultSet().isFirst());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void onButtonFirst() {
        try {
            buffer.getResultSet().first();
            updateNaviButtons();
            detailControl.setModeEdit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    protected void onButtonLast() {
        try {
            buffer.getResultSet().last();
            updateNaviButtons();
            detailControl.setModeEdit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    protected void onButtonNext() {
        try {
            buffer.getResultSet().next();
            updateNaviButtons();
            detailControl.setModeEdit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    protected void onButtonPrev() {
        try {
            buffer.getResultSet().previous();
            updateNaviButtons();
            detailControl.setModeEdit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    protected void onButtonNew() {
        switchContentToDetail();
        detailControl.setModeNew();
    }
    
    @Override
    protected void onButtonSave() {
        if (detailControl.isModeEdit()) {
            ResultSet rs = buffer.getResultSet();
            try {
                rs.updateInt(1, Integer.parseInt(detailControl.getGui().tfGlaeubiger.getText()));
                rs.updateString(2, detailControl.getGui().tfBez.getText());
                rs.updateRow();
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
            }
            reloadSet();
            return;
        }
        
        if (detailControl.isModeNew()) {
            ResultSet rs = buffer.getResultSet();
            try {
                rs.moveToInsertRow();
                rs.updateInt(1, Integer.parseInt(detailControl.getGui().tfGlaeubiger.getText()));
                rs.updateString(2, detailControl.getGui().tfBez.getText());
                rs.insertRow();
                rs.moveToCurrentRow();
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
            }
            reloadSet();
            detailControl.setModeEdit();
            return;
        }
    }
    
    @Override
    protected void onButtonUndo() {
        
    }
    
    @Override
    protected void onButtonDelete() {
        ResultSet rs = buffer.getResultSet();
        try {
            rs.deleteRow();
            rs.first();
            detailControl.setModeEdit();
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        reloadSet();
        
    }
    
    @Override
    protected void onButtonControl() {
        
    }
    
    @Override
    protected void onButtonReport() {
        
    }
    
    @Override
    protected boolean canSwitchPage() {
        return false;
    }
    
    private void reloadSet() {
        System.out.println("UserBaseDataControl.reloadSet()");
        
        var processTask = new ProcessTask("Loading", () -> {
            this.buffer.reload(loadAllFilter.getQuery());
        });
        
        processTask.addProcessFinishEvent(() -> {
            this.tableControl.fillData();
            updateNaviButtons();
        });
        
        this.beginTask(processTask);
    }
    
}
