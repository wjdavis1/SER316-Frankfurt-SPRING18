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
	private static HashMap<String,Driver> driverCollection;
	private String[] columnNames = {"Driver ID","First Name", "Last Name", "Phone Number", "Age" };
	private Object[][] data;
	private int index = 0;
	
	public DriverTablePanel() {
		super(new GridLayout(1,0));
		
		refreshElements();
		
		table = new JTable(data,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(1000,700));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		
		add(scrollPane);
	}
	
	/**
	 * Method: refreshElements
	 * Input: None
	 * Return: 2-D Object Array
	 * 
	 * Description: The method refreshes the 2-D object array to get any new elements from the drivers.json
	 * file, and attempts to update the table with new drivers;
	 */
	public Object[][] refreshElements() {
		driverCollection = DriverCollection.getDrivers();
		data = new Object[driverCollection.keySet().size()][columnNames.length];
		
		for(String driverID : driverCollection.keySet()) {
			Driver driver = driverCollection.get(driverID);
			data[index][0] = driver.getDriverId();
			data[index][1] = driver.getFirstName();
			data[index][2] = driver.getLastName();
			data[index][3] = driver.getPhoneNumber();
			data[index][4] = driver.getAge();
			index++;
		}
		
		index = 0;
		
		return data;
	}
	
	/**
	 * Method: refreshTable
	 * Input: None
	 * return: None
	 * Description: Private Method that initializes and refreshes the table once run
	 */
	private void refreshTable() {
		refreshElements();
	}
	
}