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
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Dialog;
import javax.swing.ImageIcon;
import main.java.memoranda.TourImpl;
import main.java.memoranda.ui.TourTable;
import main.java.memoranda.util.Local;
import main.java.memoranda.TourCollection;
import main.java.memoranda.ui.AddTourPanel;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JButton;	 
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TourPanel extends JPanel {
	
	
	public TourPanel() {
	    try {
	      jbInit();
	    }
	    catch(Exception ex) {
	      new ExceptionDialog(ex);
	    }
	}
		  
	void jbInit() throws Exception {
		ImageIcon add, remove, find, edit;
		JSplitPane horizPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JButton addTour, deleteTour, editTour;
		JToolBar tourToolbar = new JToolBar();
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JTextArea tourListArea = new JTextArea();
		JTextField input = new JTextField();
		JButton button = new JButton("Save Tour Info");
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JScrollPane scrollPane;
		
		TourTable tourTable = new TourTable();
		tourTable.setRowHeight(20);
		
		TourCollection tourList = new TourCollection("src/main/resources/data/tours/tours.json");
	
		setLayout(new BorderLayout());
		
	
		tourTable.setShowVerticalLines(true);
		tourTable.setShowHorizontalLines(true);
		tourTable.setGridColor(Color.black);
		tourTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		/*bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(tourTable, BorderLayout.CENTER);
		bottomPanel.setVisible(true);*/
		
		scrollPane = new JScrollPane(tourTable);
		scrollPane.setViewportView(tourTable);
		
		horizPane.setRightComponent(scrollPane);
		horizPane.setLeftComponent(new JPanel());
		horizPane.setDividerLocation(254);
		
		

		tourToolbar.setFloatable(false);
		
		add = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/todo_new.png"));
		remove = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/todo_remove.png"));
		find = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/help.png"));
		edit = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/editproject.png"));
		
		addTour = new JButton("Add Tour", add);
	    addTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTourB_actionPerformed(e);
            }
        });
	    
		deleteTour = new JButton("Delete Tour", remove);
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
	    
		tourToolbar.add(addTour);
		tourToolbar.add(deleteTour);
		tourToolbar.add(editTour);
		
		add(tourToolbar, BorderLayout.NORTH);
		add(horizPane, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	void addTourB_actionPerformed(ActionEvent e) {
		System.out.println("Add Button");
		AddTourPanel addTourPanel = new AddTourPanel(App.getFrame(), Local.getString(""));
		Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        addTourPanel.setLocation((frmSize.width - addTourPanel.getSize().width) / 2 + loc.x, (frmSize.height - addTourPanel.getSize().height) / 2 + loc.y);
        addTourPanel.setVisible(true);
	}
	
	void deleteTourB_actionPerformed(ActionEvent e) {
		
		System.out.println("Delete Button");
	}
	
	void editTourB_actionPerformed(ActionEvent e) {
		System.out.println("Edit Button");
	}
}
