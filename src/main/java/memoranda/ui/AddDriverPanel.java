
package main.java.memoranda.ui;

/**
 * File Name: AddDriverPanel.java
 * Description: A new JFrame window that allows the user to add Driver information
 * Author: Wesley Davis
 * Date: Feb 18th, 2018
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import main.java.memoranda.DriverImpl;
import main.java.memoranda.DriverCollection;

/**
 * Class: AddDriverPanel
 * Description: SEE ABOVE FILE DESCRIPTION
 */
public class AddDriverPanel extends JFrame {
	
	JLabel firstName,lastName, driverAge, driverID, busID, phoneNumber;
	GridLayout gridLayout = new GridLayout(6,6,8,10);
	BorderLayout borderLayout = new BorderLayout();
	JPanel inputPanel, confirmationPanel;
	JTextField firstNameEntry, lastNameEntry, driverAgeEntry, driverIDEntry, driverBusID, driverPhone;
	JButton add, cancel;
	
	public AddDriverPanel() {
		super("Add Driver Information");
		try {
			jbInit();
			pack();
		}catch(Exception exc) {
			System.out.println(exc.getMessage());
		}
		
	}
	
	
	/**
	 * Method: jbInit
	 * Inputs: None
	 * Returns: Void
	 * Description: Following convention from other frame initializers in this program, this
	 * method initializes all of the components for the Frame while also initializing action
	 * listeners for the buttons associated with creating a driver.
	 */
	public void jbInit() {
		
		this.setLayout(borderLayout);
		firstName = new JLabel("First Name: ", SwingConstants.LEFT);
		lastName = new JLabel("Last Name: ", SwingConstants.LEFT);
		driverAge = new JLabel("Age: ", SwingConstants.LEFT);
		driverID = new JLabel("ID: ", SwingConstants.LEFT);
		busID = new JLabel("Bus ID: ", SwingConstants.LEFT);
		phoneNumber = new JLabel("Phone #: ", SwingConstants.LEFT);
		
		firstNameEntry = new JTextField(10);
		lastNameEntry = new JTextField(10);
		driverAgeEntry = new JTextField(10);
		driverIDEntry = new JTextField(10);
		driverBusID = new JTextField(10);
		driverPhone = new JTextField(10);
		
		add = new JButton("Add");
		cancel = new JButton("Cancel");
		
		setSize(200,200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		inputPanel = new JPanel();
		confirmationPanel = new JPanel();
		
		inputPanel.add(firstName);
		inputPanel.add(firstNameEntry);
		inputPanel.add(lastName);
		inputPanel.add(lastNameEntry);
		inputPanel.add(driverAge);
		inputPanel.add(driverAgeEntry);
		inputPanel.add(driverID);
		inputPanel.add(driverIDEntry);
		inputPanel.add(busID);
		inputPanel.add(driverBusID);
		inputPanel.add(phoneNumber);
		inputPanel.add(driverPhone);
		
		
		add = new JButton("Create Driver");
		cancel = new JButton("Cancel");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addDriver();
				dispose();
				
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
		
		confirmationPanel.add(add);
		confirmationPanel.add(cancel);
		add(inputPanel, BorderLayout.CENTER);
		add(confirmationPanel, BorderLayout.SOUTH);
		
		setVisible(true);

	}
	/**
	 * Method: addDriver
	 * Description: Adds a driver to the driver collection stored in a file within the system
	 */
	private void addDriver() {
		DriverImpl newDriver = new DriverImpl(firstNameEntry.getText(),lastNameEntry.getText(),
				driverIDEntry.getText(),driverBusID.getText(),Integer.parseInt(driverAgeEntry.getText()),driverPhone.getText());
		DriverCollection driverCollection = new DriverCollection("drivers.json");
		if(driverCollection.addDriver(newDriver)) {
			JOptionPane.showMessageDialog(this, "Driver: " + newDriver.getFullName() + " has been created! ");
			System.out.println("Driver Full Name: " + newDriver.getFullName());
			System.out.println("Driver ID: " + newDriver.getDriverId());
			System.out.println("Age: " + newDriver.getAge());
			System.out.println("Bus ID: " + newDriver.getBusID());
			System.out.println("Phone #: " +  newDriver.getPhoneNumber());
		}else {
			JOptionPane.showMessageDialog(this, "Driver cannot be added, Driver Already Exists");
		}
		
	}

}
