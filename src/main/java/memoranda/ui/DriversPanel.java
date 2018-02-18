package main.java.memoranda.ui;
/**
 * File Name: DriversPanel.java
 * Description: The main panel for Driver information such as finding a driver, creating a driver,
 * and displaying a list of current drivers.
 * Author: Wesley Davis
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;


public class DriversPanel extends JPanel {
	
	BorderLayout borderLayout = new BorderLayout();
	GridLayout information = new GridLayout(4,2,5,8);
	JPanel driverInformation = new JPanel();
	JPanel driverList = new JPanel();
	JPanel emptyPanel = new JPanel();
	JToolBar driversToolBar = new JToolBar();
	JButton addDriver,removeDriver, findDriver;
	JSplitPane driverInfoPane,driverPane;
	ImageIcon add, remove, find;
	JLabel firstName, lastName, driverID, age,driverImage, first, last, id, driverAge;
	
	// The work panel is the parent panel for Driver and many other
	// panels
	WorkPanel parentPanel = null;
	
	public DriversPanel(WorkPanel _parentPanel){
		try {
			parentPanel = _parentPanel;
			jbInit();
		}catch(Exception ex) {
			new ExceptionDialog(ex);
		}
	}
	
	
	// Initializes the panel with layout and buttons
	void jbInit() throws Exception{
		System.out.println("[DEBUG] Driver Panel has Been Created!");
		
		this.setLayout(borderLayout);
		add = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/todo_new.png"));
		remove = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/todo_remove.png"));
		find = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/help.png"));
		
		addDriver = new JButton("Add Driver", add);
		removeDriver = new JButton("Remove Driver", remove);
		findDriver = new JButton("Find Driver", find);
		
		firstName = new JLabel("First Name: ");
		lastName = new JLabel("Last Name: ");
		driverID = new JLabel("Driver ID: ");
		age = new JLabel("Age: ");
		
		first = new JLabel("John");
		last = new JLabel("Smith");
		id = new JLabel("123456");
		driverAge = new JLabel("32");
		
		first.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		driversToolBar.setFloatable(false);
		driversToolBar.addSeparator(new Dimension(8,24));
		driversToolBar.addSeparator(new Dimension(8,24));
		driversToolBar.add(addDriver);
		driversToolBar.add(removeDriver);
		driversToolBar.addSeparator();
		driversToolBar.add(findDriver);
		

		driverInformation.setLayout(information);
		driverInformation.add(firstName);
		driverInformation.add(first);
		driverInformation.add(lastName);
		driverInformation.add(last);
		driverInformation.add(age);
		driverInformation.add(driverAge);
		driverInformation.add(driverID);
		driverInformation.add(id);
	
		driverList.add(new JLabel("Table of Drivers Goes Here", JLabel.CENTER));
		
		driverInfoPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,driverInformation, emptyPanel);
		driverPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, driverInfoPane,driverList);
		driverPane.setDividerLocation(250);
		driverPane.setOneTouchExpandable(false);
		this.add(driversToolBar, BorderLayout.NORTH);
		this.add(driverPane);
	}

}
