package main.java.memoranda.ui;


 /* Description: A table to display the contents of the TourCollection Vector on the Tour Panel
 * Author: Jesse Sabbath
 * Date: February 22, 2018
 * 
 */
import main.java.memoranda.TourCollection;
import main.java.memoranda.TourImpl;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.java.memoranda.TourCollection;
public class TourTable extends JPanel {
	
	JTable tourTable; 
	TourCollection tourCollection;
	AbstractTableModel model1;
	
	public TourTable() {
	    try {
	    	
	      jbInit();
	    }
	    catch(Exception ex) {
	      new ExceptionDialog(ex);
	    }
	}
	
	public void jbInit() {
		tourCollection = new TourCollection("src/main/resources/data/tours/tours.json");
		
		String[] colNames = {"Tour ID", "Date", "Time", "Route ID", "Driver ID", "Bus ID"};
		Object[][] data = new Object[tourCollection.getTourList().size()][colNames.length];

		for(int i = 0; i < tourCollection.getTourList().size(); i++) {
			TourImpl tempTour = (TourImpl)tourCollection.getTourList().elementAt(i);
				data[i][0] = tempTour.getTourID();
				data[i][1] = tempTour.getTime();
				data[i][2] = tempTour.getDate();
				data[i][3] = tempTour.getRouteID();
				data[i][4] = tempTour.getDriverID();
				data[i][5] = tempTour.getBusID();	
				
		}
	
		JTable tourTable = new JTable(data,colNames);
		tourTable.setShowVerticalLines(true);
		tourTable.setShowHorizontalLines(true);
		tourTable.setGridColor(Color.GRAY);
		tourTable.setAutoCreateRowSorter(true);
		tourTable.setPreferredScrollableViewportSize(new Dimension(900,700));
		tourTable.setFillsViewportHeight(true);
		tourTable.setEnabled(false);
		tourTable.getRowSorter().toggleSortOrder(0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(tourTable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		add(scrollPane);
	
	}
		
}
