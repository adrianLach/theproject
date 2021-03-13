package de.tp.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame {
    
    private JPanel contentPane;
    public JPanel plStatus;
    public JPanel plContent;
    public JPanel plOutlook;
    public JButton btnNewButton;
    public JProgressBar progressBar;
    public JLabel lblStatusProgress;
    public JLabel lblStatusTaskName;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public MainWindow() {
        setTitle("The Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1009, 616);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(new BorderLayout(0, 0));
        {
            this.plStatus = new JPanel();
            FlowLayout flowLayout = (FlowLayout) this.plStatus.getLayout();
            flowLayout.setAlignment(FlowLayout.RIGHT);
            this.plStatus.setBackground(Color.GRAY);
            this.contentPane.add(this.plStatus, BorderLayout.SOUTH);
            {
                this.lblStatusTaskName = new JLabel("TaskName");
                this.plStatus.add(this.lblStatusTaskName);
            }
            {
                this.lblStatusProgress = new JLabel("Progress");
                this.plStatus.add(this.lblStatusProgress);
            }
            {
                this.progressBar = new JProgressBar();
                this.progressBar.setIndeterminate(true);
                this.plStatus.add(this.progressBar);
            }
        }
        {
            this.plContent = new JPanel();
            this.plContent.setBorder(new LineBorder(new Color(0, 0, 0)));
            this.contentPane.add(this.plContent, BorderLayout.CENTER);
            this.plContent.setLayout(new CardLayout(0, 0));
        }
        {
            this.plOutlook = new JPanel();
            this.plOutlook.setBackground(Color.LIGHT_GRAY);
            this.plOutlook.setMaximumSize(new Dimension(100, 32767));
            this.contentPane.add(this.plOutlook, BorderLayout.WEST);
            GridBagLayout gbl_plOutlook = new GridBagLayout();
            gbl_plOutlook.columnWidths = new int[] { 0, 0 };
            gbl_plOutlook.rowHeights = new int[] { 0, 0, 0 };
            gbl_plOutlook.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
            gbl_plOutlook.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
            this.plOutlook.setLayout(gbl_plOutlook);
        }
    }
}
