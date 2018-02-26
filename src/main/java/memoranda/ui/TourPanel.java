package main.java.memoranda.ui;
/**
+ * File Name: TourPanel.java
+ * Description: The main panel for the display of tour objects with buttons to add, delete, and edit Tours. 
			Buttons instantiate an AddTourPanel pop-up where the user can input Tour information and contains
			a TourTable for displaying the Tour Collection
+ * Author: Jesse Sabbath
+ * Date: February 22, 2018
+ * 
+ */
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;	 
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JButton;	 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.java.memoranda.TourImpl;
import main.java.memoranda.ui.TourTable;
import main.java.memoranda.util.Local;
import main.java.memoranda.TourCollection;
import main.java.memoranda.ui.AddTourPanel;

import java.util.Vector;


public class TourPanel extends JPanel {
	
	TourCollection tourCollection = new TourCollection("src/main/resources/data/tours/tours.json");
	
	public TourPanel() {
	    try {
	      jbInit();
	    }
	    catch(Exception ex) {
	      new ExceptionDialog(ex);
	    }
	}
		  
	void jbInit() throws Exception {
		
		setLayout(new BorderLayout());
		
		ImageIcon add, remove, find, edit;
		JSplitPane horizPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JButton addTour, deleteTour, editTour;
		JToolBar tourToolbar = new JToolBar();
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JTextArea tourListArea = new JTextArea();
		JTextField input = new JTextField();
		JButton button = new JButton("Save Tour Info");
		//JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		
		DefaultTableModel dtm = new DefaultTableModel(200, 6);	
		dtm.addRow(tourCollection.getTourList());
		
		TourTable tourTable = new TourTable();
		//tourTable.setTableHeader(new JTableHeader());
		tourTable.setModel(dtm);
		tourTable.setRowHeight(20);
		tourTable.setShowVerticalLines(true);
		tourTable.setShowHorizontalLines(true);
		tourTable.setGridColor(Color.GRAY);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(tourTable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		//topPanel.add(scrollPane);
		
		horizPane.setRightComponent(scrollPane);
		horizPane.setLeftComponent(new JPanel());
		horizPane.setDividerLocation(266);
		
		tourToolbar.setFloatable(false);
		
		add = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/todo_new.png"));
		remove = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/todo_remove.png"));
		find = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/help.png"));
		edit = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/editproject.png"));
		
		//addButtonListeners for Add/Remove/Edit
		addTour = new JButton("Add Tour", add);
	    addTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTourB_actionPerformed(e);
            }
        });
	    
		deleteTour = new JButton("Remove Tour", remove);
	    deleteTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	deleteTourB_actionPerformed(e);
            }
        });
	    
		editTour = new JButton("Edit Tour", edit);
	    editTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editTourB_actionPerformed(e);
            }
        });
	    
	    //Add Toolbar buttons
		tourToolbar.add(addTour);
		tourToolbar.add(deleteTour);
		tourToolbar.add(editTour);
		
		//Add Toolbar and Horizontal SplitPane
		add(tourToolbar, BorderLayout.NORTH);
		add(horizPane, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	/**
	 * 
	 * @param e
	 */
	void addTourB_actionPerformed(ActionEvent e) {
		System.out.println("Add Button");
		AddTourPanel addTourPanel = new AddTourPanel(App.getFrame(), Local.getString(""), tourCollection);
		Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        addTourPanel.daySelectorCB.setBackground(Color.WHITE);
        addTourPanel.monthSelectorCB.setBackground(Color.WHITE);
        addTourPanel.yearSelectorCB.setBackground(Color.WHITE);
        addTourPanel.timeSelectorCB.setBackground(Color.WHITE);
        addTourPanel.setLocation((frmSize.width - addTourPanel.getSize().width) / 2 + loc.x, (frmSize.height - addTourPanel.getSize().height) / 2 + loc.y);
        addTourPanel.setVisible(true);
	}
	
	void deleteTourB_actionPerformed(ActionEvent e) {
		AddTourPanel addTourPanel = new AddTourPanel(App.getFrame(), Local.getString(""), tourCollection);
		Dimension frmSize = App.getFrame().getSize();
		Point loc = App.getFrame().getLocation();
		addTourPanel.routeIDField.setEditable(false);
		addTourPanel.driverIDField.setEditable(false);
		addTourPanel.busIDField.setEditable(false);
		addTourPanel.daySelectorCB.setEditable(false);
		addTourPanel.monthSelectorCB.setEditable(false);
		addTourPanel.yearSelectorCB.setEditable(false);
		addTourPanel.timeSelectorCB.setEditable(false);
		addTourPanel.header.setText(Local.getString("Remove Tour"));
		addTourPanel.setLocation((frmSize.width - addTourPanel.getSize().width) / 2 + loc.x, (frmSize.height - addTourPanel.getSize().height) / 2 + loc.y);
        addTourPanel.setVisible(true);
		System.out.println("Delete Button");
	}
	
	void editTourB_actionPerformed(ActionEvent e) {
		AddTourPanel addTourPanel = new AddTourPanel(App.getFrame(), Local.getString(""), tourCollection);
		Dimension frmSize = App.getFrame().getSize();
		Point loc = App.getFrame().getLocation();
		addTourPanel.daySelectorCB.setBackground(Color.WHITE);
        addTourPanel.monthSelectorCB.setBackground(Color.WHITE);
        addTourPanel.yearSelectorCB.setBackground(Color.WHITE);
        addTourPanel.timeSelectorCB.setBackground(Color.WHITE);
        
		addTourPanel.header.setText(Local.getString("Edit Tour"));
		addTourPanel.setLocation((frmSize.width - addTourPanel.getSize().width) / 2 + loc.x, (frmSize.height - addTourPanel.getSize().height) / 2 + loc.y);
        addTourPanel.setVisible(true);
		System.out.println("Edit Button");
	}
}
