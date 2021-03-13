package de.tp.framework.details;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class DetailView extends JPanel {
    
    public JPanel panel;
    public JPanel panel_1;
    public JPanel panel_2;
    public JPanel panel_3;
    public JProgressBar progressBar;
    public JLabel lblNewLabel;
    public JButton btnFirst;
    public JButton btnPrev;
    public JPanel plContent;
    public JButton btnNext;
    public JButton btnLast;
    public JButton btnNew;
    public JButton btnSave;
    public JButton btnUndo;
    public JButton btnDelete;
    public JButton btnSwitchContent;
    public JButton btnControl;
    public BufferDataTable bufferDataTable;
    public JButton btnReport;
    
    /**
     * Create the panel.
     */
    public DetailView() {
        setLayout(new BorderLayout(0, 0));
        {
            this.panel = new JPanel();
            this.panel.setBackground(Color.LIGHT_GRAY);
            add(this.panel, BorderLayout.SOUTH);
            this.panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
            {
                this.lblNewLabel = new JLabel("New label");
                this.lblNewLabel.setVisible(false);
                this.panel.add(this.lblNewLabel);
            }
            {
                this.progressBar = new JProgressBar();
                this.progressBar.setVisible(false);
                this.progressBar.setString("working...");
                this.progressBar.setStringPainted(true);
                this.progressBar.setIndeterminate(true);
                this.panel.add(this.progressBar);
            }
        }
        {
            this.panel_1 = new JPanel();
            this.panel_1.setBackground(Color.GRAY);
            FlowLayout flowLayout = (FlowLayout) this.panel_1.getLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
            add(this.panel_1, BorderLayout.NORTH);
            {
                this.btnNew = new JButton("");
                this.btnNew.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/new.png")));
                this.btnNew.setSize(new Dimension(32, 32));
                this.btnNew.setPreferredSize(new Dimension(32, 32));
                this.btnNew.setMinimumSize(new Dimension(32, 32));
                this.btnNew.setMaximumSize(new Dimension(32, 32));
                this.btnNew.setActionCommand("");
                this.panel_1.add(this.btnNew);
            }
            {
                this.btnSave = new JButton("");
                this.btnSave.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/save.png")));
                this.btnSave.setSize(new Dimension(32, 32));
                this.btnSave.setPreferredSize(new Dimension(32, 32));
                this.btnSave.setMinimumSize(new Dimension(32, 32));
                this.btnSave.setMaximumSize(new Dimension(32, 32));
                this.btnSave.setActionCommand("");
                this.panel_1.add(this.btnSave);
            }
            {
                this.btnUndo = new JButton("");
                this.btnUndo.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/undo.png")));
                this.btnUndo.setSize(new Dimension(32, 32));
                this.btnUndo.setPreferredSize(new Dimension(32, 32));
                this.btnUndo.setMinimumSize(new Dimension(32, 32));
                this.btnUndo.setMaximumSize(new Dimension(32, 32));
                this.btnUndo.setActionCommand("");
                this.panel_1.add(this.btnUndo);
            }
            {
                this.btnDelete = new JButton("");
                this.btnDelete.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/bin.png")));
                this.btnDelete.setSize(new Dimension(32, 32));
                this.btnDelete.setPreferredSize(new Dimension(32, 32));
                this.btnDelete.setMinimumSize(new Dimension(32, 32));
                this.btnDelete.setMaximumSize(new Dimension(32, 32));
                this.btnDelete.setActionCommand("");
                this.panel_1.add(this.btnDelete);
            }
            {
                this.btnSwitchContent = new JButton("");
                this.btnSwitchContent.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/list.png")));
                this.btnSwitchContent.setSize(new Dimension(32, 32));
                this.btnSwitchContent.setPreferredSize(new Dimension(32, 32));
                this.btnSwitchContent.setMinimumSize(new Dimension(32, 32));
                this.btnSwitchContent.setMaximumSize(new Dimension(32, 32));
                this.btnSwitchContent.setActionCommand("");
                this.panel_1.add(this.btnSwitchContent);
            }
            {
                this.btnControl = new JButton("");
                this.btnControl.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/control.png")));
                this.btnControl.setSize(new Dimension(32, 32));
                this.btnControl.setPreferredSize(new Dimension(32, 32));
                this.btnControl.setMinimumSize(new Dimension(32, 32));
                this.btnControl.setMaximumSize(new Dimension(32, 32));
                this.btnControl.setActionCommand("");
                this.panel_1.add(this.btnControl);
            }
            {
                this.btnReport = new JButton("");
                this.btnReport.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/printer.png")));
                this.btnReport.setSize(new Dimension(32, 32));
                this.btnReport.setPreferredSize(new Dimension(32, 32));
                this.btnReport.setMinimumSize(new Dimension(32, 32));
                this.btnReport.setMaximumSize(new Dimension(32, 32));
                this.btnReport.setActionCommand("");
                this.panel_1.add(this.btnReport);
            }
        }
        {
            this.panel_2 = new JPanel();
            add(this.panel_2, BorderLayout.CENTER);
            this.panel_2.setLayout(new BorderLayout(0, 0));
            {
                this.panel_3 = new JPanel();
                this.panel_3.setBackground(Color.GRAY);
                this.panel_2.add(this.panel_3, BorderLayout.SOUTH);
                this.panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
                {
                    this.btnFirst = new JButton("");
                    this.btnFirst.setSize(new Dimension(32, 32));
                    this.btnFirst.setDefaultCapable(false);
                    this.btnFirst.setMaximumSize(new Dimension(32, 32));
                    this.btnFirst.setMinimumSize(new Dimension(32, 32));
                    this.btnFirst.setPreferredSize(new Dimension(32, 32));
                    this.btnFirst.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/first.png")));
                    this.panel_3.add(this.btnFirst);
                }
                {
                    this.btnPrev = new JButton("");
                    this.btnPrev.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/prev.png")));
                    this.btnPrev.setMinimumSize(new Dimension(32, 32));
                    this.btnPrev.setMaximumSize(new Dimension(32, 32));
                    this.btnPrev.setSize(new Dimension(32, 32));
                    this.btnPrev.setPreferredSize(new Dimension(32, 32));
                    this.btnPrev.setActionCommand("");
                    this.panel_3.add(this.btnPrev);
                }
                {
                    this.btnNext = new JButton("");
                    this.btnNext.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/next.png")));
                    this.btnNext.setSize(new Dimension(32, 32));
                    this.btnNext.setPreferredSize(new Dimension(32, 32));
                    this.btnNext.setMinimumSize(new Dimension(32, 32));
                    this.btnNext.setMaximumSize(new Dimension(32, 32));
                    this.btnNext.setActionCommand("");
                    this.panel_3.add(this.btnNext);
                }
                {
                    this.btnLast = new JButton("");
                    this.btnLast.setIcon(new ImageIcon(DetailView.class.getResource("/rcs/p32/last.png")));
                    this.btnLast.setSize(new Dimension(32, 32));
                    this.btnLast.setPreferredSize(new Dimension(32, 32));
                    this.btnLast.setMinimumSize(new Dimension(32, 32));
                    this.btnLast.setMaximumSize(new Dimension(32, 32));
                    this.btnLast.setActionCommand("");
                    this.panel_3.add(this.btnLast);
                }
            }
            {
                this.plContent = new JPanel();
                this.panel_2.add(this.plContent, BorderLayout.CENTER);
                this.plContent.setLayout(new CardLayout(0, 0));
            }
        }
        
    }
    
}
