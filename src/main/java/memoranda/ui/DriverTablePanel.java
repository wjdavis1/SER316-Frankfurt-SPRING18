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
    private DriverTableModel newModel;

    public DriverTablePanel() {
        super(new GridLayout(1,0));

        newModel = new DriverTableModel();
        newModel.loadData();
        table = new JTable(newModel);
        table.setPreferredScrollableViewportSize(new Dimension(1000,700));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }
    
    private class DriverTableModel extends AbstractTableModel{
        private HashMap<String,Driver> driverCollection;
        private String[] columnNames = {"Driver ID","First Name", "Last Name", "Phone Number", "Age" };
        private Object[][] data;
        private int index = 0;
        
        public void loadData() {
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
        }
        

        @Override
        public int getRowCount() {
            // TODO Auto-generated method stub
            return data.length;
        }

        @Override
        public int getColumnCount() {
            // TODO Auto-generated method stub
            return columnNames.length;
        }
        
        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            // TODO Auto-generated method stub
            return data[rowIndex][columnIndex];
        }
        
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
    
    public void refreshTable() {
        newModel.fireTableDataChanged();
        table.revalidate();
        table.repaint();
    }
	
}