package de.tp.user.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JTable;

import de.tp.framework.details.BufferDataTableControl;
import de.tp.framework.details.DetailViewControl;
import de.tp.framework.sql.Buffer_user;
import de.tp.framework.sql.Filter;
import de.tp.framework.sql.SQL;
import de.tp.framework.tasks.ProcessTask;

public class UserBaseDataControl extends DetailViewControl {
    
    private BufferDataTableControl bufferDataTableControl = new BufferDataTableControl();
    private UserDetailsWindowControl detailsWindowControl = new UserDetailsWindowControl();
    
    private Buffer_user buffer = new Buffer_user(SQL.getDefaultConnection());
    
    private final Filter loadAllFilter = Filter.getFilter().select("*").from("user");
    
    public UserBaseDataControl() {
        
        this.bufferDataTableControl.setBuffer(this.buffer);
        this.detailsWindowControl.setBuffer(this.buffer);
        
        this.bufferDataTableControl.getGui().table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                var table = (JTable) mouseEvent.getSource();
                var point = mouseEvent.getPoint();
                var row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    UserBaseDataControl.this.onTableDoubleClick(row);
                }
            }
        });
        
        this.bufferDataTableControl.getGui().table.getSelectionModel().addListSelectionListener(e -> {
            try {
                UserBaseDataControl.this.buffer.getResultSet().absolute(e.getFirstIndex() + 1);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        
        super.addContents(this.bufferDataTableControl.getGui(), this.detailsWindowControl.getGui());
        
        this.reloadSet();
    }
    
    @Override
    protected void onButtonReport() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    protected boolean canSwitchPage() {
        return false;
    }
    
    private void updateNaviButtons() throws SQLException {
        getGui().btnLast.setEnabled(!buffer.getResultSet().isLast());
        getGui().btnNext.setEnabled(!buffer.getResultSet().isLast());
        
        getGui().btnFirst.setEnabled(!buffer.getResultSet().isFirst());
        getGui().btnPrev.setEnabled(!buffer.getResultSet().isFirst());
    }
    
    @Override
    protected void onButtonFirst() {
        System.out.println("UserBaseDataControl.onButtonFirst()");
        try {
            buffer.getResultSet().first();
            updateNaviButtons();
            detailsWindowControl.initData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void onButtonLast() {
        System.out.println("UserBaseDataControl.onButtonLast()");
        try {
            buffer.getResultSet().last();
            updateNaviButtons();
            detailsWindowControl.initData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void onButtonNext() {
        System.out.println("UserBaseDataControl.onButtonNext()");
        try {
            buffer.getResultSet().next();
            updateNaviButtons();
            detailsWindowControl.initData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void onButtonPrev() {
        System.out.println("UserBaseDataControl.onButtonPrev()");
        try {
            buffer.getResultSet().previous();
            updateNaviButtons();
            detailsWindowControl.initData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void onButtonNew() {
        System.out.println("UserBaseDataControl.onButtonNew()");
        this.detailsWindowControl.setPanelModeNew();
        this.switchContentToDetail();
    }
    
    @Override
    protected void onButtonSave() {
        System.out.println("UserBaseDataControl.onButtonSave()");
        this.detailsWindowControl.setPanelModeEdit();
        
        this.reloadSet();
    }
    
    @Override
    protected void onButtonUndo() {
        System.out.println("UserBaseDataControl.onButtonUndo()");
        super.beginTask(new ProcessTask("Process", () -> {
            
            for (var i = 1; i <= 100; i++) {
                UserBaseDataControl.this.updateTask("Step " + i + "/" + 100);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        
    }
    
    @Override
    protected void onButtonDelete() {
        System.out.println("UserBaseDataControl.onButtonDelete()");
    }
    
    @Override
    protected void onButtonControl() {
        System.out.println("UserBaseDataControl.onButtonControl()");
        HashMap<Integer, String> map = new UserFilterControl().getFilters();
    }
    
    private void onTableDoubleClick(int row) {
        System.out.println("UserBaseDataControl.onTableDoubleClick()");
        this.detailsWindowControl.setPanelModeEdit();
        detailsWindowControl.initData();
        this.switchContentToDetail();
        
    }
    
    private int getCurrentRowSelected() {
        System.out.println("UserBaseDataControl.getCurrentRowSelected()");
        System.out.println(this.bufferDataTableControl.getGui().table.getSelectedRow());
        return this.bufferDataTableControl.getGui().table.getSelectedRow();
    }
    
    private void reloadSet() {
        System.out.println("UserBaseDataControl.reloadSet()");
        
        var processTask = new ProcessTask("Loading", () -> {
            UserBaseDataControl.this.buffer.reload(loadAllFilter.getQuery());
        });
        
        processTask.addProcessFinishEvent(() -> {
            UserBaseDataControl.this.bufferDataTableControl.fillData();
        });
        
        this.beginTask(processTask);
    }
    
    @Override
    protected void switchContentToTable() {
        super.switchContentToTable();
        this.reloadSet();
    }
}
