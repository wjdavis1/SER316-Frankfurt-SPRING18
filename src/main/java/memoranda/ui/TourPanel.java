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
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JButton;	 
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import main.java.memoranda.ui.TourTable;
import main.java.memoranda.util.Local;
import main.java.memoranda.TourCollection;
import main.java.memoranda.ui.EditTourPanel;

public class TourPanel extends JPanel {
	
	TourCollection tourCollection = new TourCollection("src/main/resources/data/tours/tours.json");
	JSplitPane horizPane;
	TourTable tourTable = new TourTable();
	
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
		
		ImageIcon add;
		ImageIcon remove;
		ImageIcon edit;
		ImageIcon refresh;
		/*Future Implementation: 
		ImageIcon find;*/
	
		JButton addTour;
		JButton deleteTour;
		JButton editTour;
		JButton refreshTourB;
		JToolBar tourToolbar;
	
		horizPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		horizPane.setRightComponent(tourTable);
		horizPane.setLeftComponent(new JPanel());
		horizPane.setDividerLocation(266);
		
		add = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/todo_new.png"));
		remove = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/todo_remove.png"));
		edit = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/editproject.png"));
        refresh = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/refreshres.png"));
		//Possible Future Implementation: 
        //find = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/help.png"));
        
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
	    
	    refreshTourB = new JButton("Refresh Table", refresh);
        refreshTourB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTourB_actionPerformed(e);
            }
        });
	    
	    //Add Toolbar buttons
        tourToolbar = new JToolBar();
        tourToolbar.setFloatable(false);
		tourToolbar.add(addTour);
		tourToolbar.add(deleteTour);
		tourToolbar.add(editTour);
		tourToolbar.add(refreshTourB);
		
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
		
		EditTourPanel addTourPanel = new EditTourPanel(App.getFrame(), Local.getString(""), tourCollection);
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
		EditTourPanel addTourPanel = new EditTourPanel(App.getFrame(), Local.getString(""), tourCollection);
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
	}
	
	void editTourB_actionPerformed(ActionEvent e) {
		EditTourPanel addTourPanel = new EditTourPanel(App.getFrame(), Local.getString(""), tourCollection);
		Dimension frmSize = App.getFrame().getSize();
		Point loc = App.getFrame().getLocation();
		addTourPanel.tourIDField.setBackground(new Color(195,225,250));
		addTourPanel.routeIDField.setBackground(new Color(195,225,250));
        addTourPanel.driverIDField.setBackground(new Color(195,225,250));
        addTourPanel.busIDField.setBackground(new Color(195,225,250));
		addTourPanel.daySelectorCB.setBackground(new Color(195,225,250));
        addTourPanel.monthSelectorCB.setBackground(new Color(195,225,250));
        addTourPanel.yearSelectorCB.setBackground(new Color(195,225,250));
        addTourPanel.timeSelectorCB.setBackground(new Color(195,225,250));     
		addTourPanel.header.setText(Local.getString("Edit Tour"));
		addTourPanel.setLocation((frmSize.width - addTourPanel.getSize().width) / 2 + loc.x, (frmSize.height - addTourPanel.getSize().height) / 2 + loc.y);
        addTourPanel.setVisible(true);		
	}
	
	void refreshTourB_actionPerformed(ActionEvent e) {
	    TourTable freshTable = new TourTable();
	    horizPane.setRightComponent(freshTable);
	    horizPane.setLeftComponent(new JPanel());
        horizPane.setDividerLocation(266);
    }
	
}
