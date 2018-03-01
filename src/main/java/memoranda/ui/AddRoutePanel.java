package main.java.memoranda.ui;

/**
 * File Name: AddRoutePanel.java
 * Description: A new JFrame window that allows the user to add Route information
 * Author: James Ortner
 * Date: Feb 21st, 2018
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import main.java.memoranda.RouteImpl;
import main.java.memoranda.RouteCollection;

/**
 * Class: AddRoutePanel
 * Description: SEE ABOVE FILE DESCRIPTION
 */
public class AddRoutePanel extends JFrame {
	
	JLabel destination,routeId, startPoint;
	GridLayout gridLayout = new GridLayout(5,2,8,10);
	GridLayout addInformation =  new GridLayout(2,1,5,5);
	BorderLayout borderLayout = new BorderLayout();
	FlowLayout flowLayout = new FlowLayout();
	JPanel inputPanel, confirmationPanel;
	JTextField destinationEntry, routeIdEntry, startPointEntry;
	JButton add, cancel;
	private RouteCollection routeCollection;
	
	public AddRoutePanel() {
		super("Add Route Information");
		try {
			jbInit();
		}
		catch(Exception exc) {
			System.out.println(exc.getMessage());
		}	
	}
	
	/**
	 * Method: jbInit
	 * Inputs: None
	 * Returns: Void
	 * Description: Following convention from other frame initializers in this program, this
	 * method initializes all of the components for the Frame while also initializing action
	 * listeners for the buttons associated with creating a route.
	 */
	public void jbInit() {
		
		this.setLayout(borderLayout);
		destination = new JLabel("Destination: ", SwingConstants.LEFT);
		routeId = new JLabel("Route ID: ", SwingConstants.LEFT);
		startPoint = new JLabel("Start Point: ", SwingConstants.LEFT);
		
		destinationEntry = new JTextField(10);
		routeIdEntry = new JTextField(10);
		startPointEntry = new JTextField(10);
		
		add = new JButton("Add");
		cancel = new JButton("Cancel");
		
		setSize(400,200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		inputPanel = new JPanel();
		confirmationPanel = new JPanel();
		
		inputPanel.add(destination);
		inputPanel.add(destinationEntry);
		inputPanel.add(routeId);
		inputPanel.add(routeIdEntry);
		inputPanel.add(startPoint);
		inputPanel.add(startPointEntry);
		
		add = new JButton("Create Route");
		cancel = new JButton("Cancel");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addRoute();	
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
		
		confirmationPanel.add(add);
		confirmationPanel.add(cancel);
		inputPanel.setPreferredSize(new Dimension(600,150));;
        inputPanel.setLayout(gridLayout);
        inputPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		add(inputPanel, BorderLayout.CENTER);
		add(confirmationPanel, BorderLayout.SOUTH);
		pack();
        setLocationRelativeTo(null);
		
		setVisible(true);
	}
	/**
	 * Method: addRoute
	 * Description: Adds a route to the route collection stored in a file within the system
	 */
	private void addRoute() {
		RouteImpl newRoute = new RouteImpl(destinationEntry.getText(),routeIdEntry.getText(),
				startPointEntry.getText());
		routeCollection = new RouteCollection("routes.json");
		if(routeCollection.addRoute(newRoute)) {
			JOptionPane.showMessageDialog(this, "Route " + newRoute.getRouteId() + " has been created! ");
			System.out.println("Route Destination: " + newRoute.getDestination());
			System.out.println("Route ID: " + newRoute.getRouteId());
			System.out.println("Start Point: " + newRoute.getStartPoint());
			try {
                routeCollection.saveToFile();
                System.out.println("[DEBUG] Save successfull");
            }catch(IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "Route cannot be added, Route " + newRoute.getRouteId() + " Already Exists");
			destinationEntry.setText(null);
			routeIdEntry.setText(null);
			startPointEntry.setText(null);
		}
		
	}

}
