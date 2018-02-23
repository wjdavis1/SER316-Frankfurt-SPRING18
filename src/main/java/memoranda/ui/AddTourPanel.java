package main.java.memoranda.ui;
/**
+ * File Name: AddTourPanel.java
+ * Description: A pop-up dialog where users can add new Tours to the TourCollection Vector
+ * Author: Jesse Sabbath
+ * Date: February 22, 2018
+ * 
+ */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;

import main.java.memoranda.util.Local;

public class AddTourPanel extends JDialog {
	
	JLabel header = new JLabel();
    JPanel dialogTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel areaPanel = new JPanel(new GridBagLayout());
    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 15));
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JButton okB = new JButton();
    JButton cancelB = new JButton();
    GridBagConstraints gbc;
    JTextField tourIDField = new JTextField(8);
    JTextField routeIDField = new JTextField(8);
    JTextField driverIDField = new JTextField(8);
    JTextField busIDField = new JTextField(8);
    JLabel tourIDLabel = new JLabel("Tour ID: ");
    JLabel routeIDLabel = new JLabel("Route ID: ");
    JLabel driverIDLabel = new JLabel("Driver ID: ");
    JLabel busIDLabel = new JLabel("Bus ID: ");
    JLabel timeLabel = new JLabel("Time: ");
    JLabel dayLabel = new JLabel("Day: ");
    JLabel monthLabel = new JLabel("Month: ");
    JLabel yearLabel = new JLabel("Year: ");
    JComboBox timeSelectorCB = new JComboBox();
    JComboBox daySelectorCB = new JComboBox();
    JComboBox monthSelectorCB = new JComboBox();
    JComboBox yearSelectorCB = new JComboBox();
    
    public boolean CANCELLED = true;

    public AddTourPanel(Frame frame, String title) {
        super(frame, title, true);
        try {
            jbInit();
            pack();
        }
        catch (Exception ex) {
            new ExceptionDialog(ex);
            ex.printStackTrace();
        }
    }

	/**
	 * setup user interface and init dialog
	 */
	 
    void jbInit() throws Exception {
    	
    	//set up main AddTourPanel and header
		this.setResizable(false);
        dialogTitlePanel.setBackground(Color.WHITE);
        dialogTitlePanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        header.setFont(new java.awt.Font("Dialog", 0, 20));
        header.setForeground(new Color(0, 0, 124));
        header.setText(Local.getString("Add Tour"));
        header.setIcon(new ImageIcon(main.java.memoranda.ui.AddResourceDialog.class.getResource(
            "/ui/icons/resource48.png")));
        dialogTitlePanel.add(header);
        this.getContentPane().add(dialogTitlePanel, BorderLayout.NORTH);
        timeSelectorCB.setBackground(Color.WHITE);
        timeSelectorCB.setSize(new Dimension(10,15));
        
        //Add tourID components
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(tourIDLabel, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(tourIDField, gbc);
        
        //add routeID components
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 2; gbc.gridy = 0;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(routeIDLabel, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 3; gbc.gridy = 0;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(routeIDField, gbc);
        
        //add driveID components
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(driverIDLabel, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(driverIDField, gbc);

        //add busID components
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 2; gbc.gridy = 1;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(busIDLabel, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 3; gbc.gridy = 1;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(busIDField, gbc);
        
        areaPanel.add(new JSeparator(JSeparator.CENTER));
             
        //add date components
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(dayLabel, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(daySelectorCB, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(monthLabel, gbc);
  
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(monthSelectorCB, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(yearLabel, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(yearSelectorCB, gbc);
        
        //add time components
        gbc = new GridBagConstraints();
        gbc.gridwidth = 3;
        gbc.gridx = 2; gbc.gridy = 5;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(timeLabel, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridwidth = 3;
        gbc.gridx = 3; gbc.gridy = 5;
        gbc.insets = new Insets(10, 15, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(timeSelectorCB, gbc);
      
        /*
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.insets = new Insets(5, 20, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        areaPanel.add(jLabel1, gbc);
        pathField.setMinimumSize(new Dimension(4, 24));
        pathField.setPreferredSize(new Dimension(250, 24));
        pathField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(CaretEvent e) {
                pathField_caretUpdate(e);
            }
        });*/
        
       
        this.getContentPane().add(areaPanel, BorderLayout.CENTER);
        
        okB.setEnabled(true);
        okB.setMaximumSize(new Dimension(100, 26));
        okB.setMinimumSize(new Dimension(100, 26));
        okB.setPreferredSize(new Dimension(100, 26));
        okB.setText(Local.getString("Ok"));
        okB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okB_actionPerformed(e);
            }
        });
        this.getRootPane().setDefaultButton(okB);
        cancelB.setMaximumSize(new Dimension(100, 26));
        cancelB.setMinimumSize(new Dimension(100, 26));
        cancelB.setPreferredSize(new Dimension(100, 26));
        cancelB.setText(Local.getString("Cancel"));
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelB_actionPerformed(e);
            }
        });
        
        //add button components
        buttonsPanel.setLayout(new FlowLayout());
	    buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); 
	    buttonsPanel.add(okB);
        buttonsPanel.add(cancelB);
        
		//enableFields();
        this.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
    }

	/**
	 * set CANCELLED variable to false so we can know the user 
	 * pressed the ok buton and close this dialog.
	 */
	 
    void okB_actionPerformed(ActionEvent e) {
        CANCELLED = false;
		this.dispose();
    }

	/**
	 * close the dialog window
	 */
	 
    void cancelB_actionPerformed(ActionEvent e) {
        this.dispose();
    }

	
}