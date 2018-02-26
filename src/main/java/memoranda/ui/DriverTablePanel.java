package main.java.memoranda.ui;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.Dimension;

import java.util.HashMap;
import java.util.LinkedHashSet;

import main.java.memoranda.DriverCollection;
import main.java.memoranda.Driver;
import main.java.memoranda.DriverImpl;

public class DriverTablePanel extends JPanel {
	
	private JTable table;
	private HashMap<String,Driver> driverCollection;
	private LinkedHashSet<String> driverIDs;
	private int index = 0;
	
	public DriverTablePanel() {
		super(new GridLayout(1,0));
			
		String[] columnNames = {"Driver ID","First Name", "Last Name", "Phone Number", "Age" };
		driverCollection = DriverCollection.getDrivers();
		
		
		Object[][] data = new Object[driverCollection.keySet().size()][columnNames.length];
		
		for(String driverID : driverCollection.keySet()) {
			Driver driver = driverCollection.get(driverID);
			data[index][0] = driver.getDriverId();
			data[index][1] = driver.getFirstName();
			data[index][2] = driver.getLastName();
			data[index][3] = driver.getPhoneNumber();
			data[index][4] = driver.getAge();
			index++;
		}
		
		table = new JTable(data,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(900,700));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		
		add(scrollPane);
	}
	
}