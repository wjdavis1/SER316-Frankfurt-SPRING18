package main.java.memoranda.ui;
/**
+ * File Name: TourTable.java
+ * Description: A table to display the contents of the TourCollection Vector on the Tour Panel
+ * Author: Jesse Sabbath
+ * Date: February 22, 2018
+ * 
+ */
import main.java.memoranda.TourCollection;

import javax.swing.table.AbstractTableModel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.JPanel;

public class TourTable extends JTable {
	
	JTable tourTable; 
	
	public TourTable() {
	    try {
	      jbInit();
	    }
	    catch(Exception ex) {
	      new ExceptionDialog(ex);
	    }
	}
	
	public void jbInit() {
	
		setAutoCreateRowSorter(true);
		this.setTableHeader(new JTableHeader());
	}
	
}
