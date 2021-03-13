package de.tp.framework.details;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.sql.ResultSet;

import javax.swing.JPanel;

import de.tp.framework.tasks.ProcessTask;

public abstract class DetailViewControl {
    
    private DetailView gui;
    
    protected static final String PAGE_CODE_DETAIL = "DETAIL";
    protected static final String PAGE_CODE_TABLE = "TABLE";
    
    protected ResultSet resultSet;
    
    private boolean detailView = false;
    
    public DetailViewControl() {
        this.gui = new DetailView();
        
        this.gui.btnNew.addActionListener(e -> DetailViewControl.this.onButtonNew());
        this.gui.btnSave.addActionListener(e -> DetailViewControl.this.onButtonSave());
        this.gui.btnUndo.addActionListener(e -> DetailViewControl.this.onButtonUndo());
        this.gui.btnDelete.addActionListener(e -> DetailViewControl.this.onButtonDelete());
        this.gui.btnSwitchContent.addActionListener(e -> DetailViewControl.this.onButtonSwitchContent());
        this.gui.btnControl.addActionListener(e -> DetailViewControl.this.onButtonControl());
        
        this.gui.btnFirst.addActionListener(e -> DetailViewControl.this.onButtonFirst());
        this.gui.btnPrev.addActionListener(e -> DetailViewControl.this.onButtonPrev());
        this.gui.btnNext.addActionListener(e -> DetailViewControl.this.onButtonNext());
        this.gui.btnLast.addActionListener(e -> DetailViewControl.this.onButtonLast());
        this.gui.btnReport.addActionListener(e -> DetailViewControl.this.onButtonReport());
    }
    
    protected void addContents(JPanel table, JPanel detail) {
        this.gui.plContent.add(table, DetailViewControl.PAGE_CODE_TABLE);
        this.gui.plContent.add(detail, DetailViewControl.PAGE_CODE_DETAIL);
    }
    
    public DetailView getGui() {
        return this.gui;
    }
    
    protected void switchContentToTable() {
        detailView = false;
        ((CardLayout) this.gui.plContent.getLayout()).show(this.gui.plContent, DetailViewControl.PAGE_CODE_TABLE);
        setNaviButtonVisible(false);
    }
    
    protected void switchContentToDetail() {
        detailView = true;
        ((CardLayout) this.gui.plContent.getLayout()).show(this.gui.plContent, DetailViewControl.PAGE_CODE_DETAIL);
        setNaviButtonVisible(true);
    }
    
    protected void setNaviButtonVisible(boolean vis) {
        gui.btnFirst.setVisible(vis);
        gui.btnPrev.setVisible(vis);
        gui.btnNext.setVisible(vis);
        gui.btnLast.setVisible(vis);
    }
    
    protected void onButtonSwitchContent() {
        this.detailView = !this.detailView;
        if (this.detailView) {
            switchContentToDetail();
        }
        if (!this.detailView) {
            switchContentToTable();
        }
    }
    
    protected final boolean isContentViewTable() {
        return !detailView;
    }
    
    protected final boolean isContentViewDetail() {
        return detailView;
    }
    
    protected final void beginTask(ProcessTask processTask) {
        gui.progressBar.setValue(0);
        gui.progressBar.setVisible(true);
        gui.lblNewLabel.setVisible(true);
        gui.lblNewLabel.setText(processTask.getTaskName());
        
        if (!processTask.isAllowUI())
            setEnabled(gui, false);
        
        processTask.addProcessFinishEvent(new Runnable() {
            
            @Override
            public void run() {
                finishTask();
            }
        });
        new Thread(processTask).start();
    }
    
    protected final void updateTask(String taskStatus) {
        gui.progressBar.setString(taskStatus);
        gui.repaint();
        gui.revalidate();
        gui.doLayout();
    }
    
    protected final void finishTask() {
        gui.progressBar.setVisible(false);
        gui.lblNewLabel.setVisible(false);
        setEnabled(gui, true);
    }
    
    private void setEnabled(Component component, boolean enabled) {
        component.setEnabled(enabled);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                setEnabled(child, enabled);
            }
        }
    }
    
    protected abstract void onButtonFirst();
    
    protected abstract void onButtonLast();
    
    protected abstract void onButtonNext();
    
    protected abstract void onButtonPrev();
    
    protected abstract void onButtonNew();
    
    protected abstract void onButtonSave();
    
    protected abstract void onButtonUndo();
    
    protected abstract void onButtonDelete();
    
    protected abstract void onButtonControl();
    
    protected abstract void onButtonReport();
    
    protected abstract boolean canSwitchPage();
    
}
