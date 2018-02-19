package main.java.memoranda.ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import main.java.memoranda.DriverImpl;


public class AddDriverPanel extends JFrame {
	
	JLabel firstName,lastName, driverAge, driverID, busID;
	GridLayout gridLayout = new GridLayout(5,5,8,10);
	BorderLayout borderLayout = new BorderLayout();
	JPanel inputPanel, confirmationPanel;
	JTextField firstNameEntry, lastNameEntry, driverAgeEntry, driverIDEntry, driverBusID;
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
	
	public void jbInit() {
		
		this.setLayout(borderLayout);
		firstName = new JLabel("First Name: ", SwingConstants.LEFT);
		lastName = new JLabel("Last Name: ", SwingConstants.LEFT);
		driverAge = new JLabel("Age: ", SwingConstants.LEFT);
		driverID = new JLabel("ID: ", SwingConstants.LEFT);
		busID = new JLabel("Bus ID: ", SwingConstants.LEFT);
		
		
		firstNameEntry = new JTextField(10);
		lastNameEntry = new JTextField(10);
		driverAgeEntry = new JTextField(10);
		driverIDEntry = new JTextField(10);
		driverBusID = new JTextField(10);
		
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
		
		
		add = new JButton("Create Driver");
		cancel = new JButton("Cancel");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DriverImpl newDriver = new DriverImpl(firstNameEntry.getText(),lastNameEntry.getText(),
						driverIDEntry.getText(),driverBusID.getText(),Integer.parseInt(driverAgeEntry.getText()));
				System.out.println("Driver Full Name: " + newDriver.getFullName());
				System.out.println("Driver ID: " + newDriver.getDriverId());
				System.out.println("Age: " + newDriver.getAge());
				System.out.println("Bus ID: " + newDriver.getBusID());
				JOptionPane.showMessageDialog(null, "Driver: " + newDriver.getFullName() + "has been created");
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
		add(inputPanel, BorderLayout.NORTH);
		add(confirmationPanel, BorderLayout.SOUTH);
		setVisible(true);

	}

}
