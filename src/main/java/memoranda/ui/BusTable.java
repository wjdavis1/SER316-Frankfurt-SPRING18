package main.java.memoranda.ui;

import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/*Bus Table. SER316 Frankfurt */
public class BusTable extends JTable {
    
    static Object[] columnNames = {"ID", "Name", "Number Of Seats"};
    static Object[][] data = new Object[][] {
        {1, "East", 23},
        {3, "West", 45}
    };
    JSONArray dataObj = null;
    
    DefaultTableModel tableModel  = null;   
    public BusTable() {
            super();
        initTable();
        this.setShowGrid(false);
        this.setFont(new Font("Dialog",0,11));
        dataObj = new JSONArray();
        initColums();
        initTable();
        loadBuses();
    }

    void initColums() {
            for (int i = 0; i < columnNames.length; i++) {
                TableColumn col = new TableColumn();
                col.setWidth(500);
                col.setHeaderValue(columnNames[i]);
                this.addColumn(col);
        }
    }

    public void tableChanged() {
        initTable();
        initColums();
        updateUI();
    }

    public void initTable() {

    }
    
    private void loadBuses() {
            readFile();
            //System.out.println(dataObj[0]);
    }
    
    // Method to read data file
    private void readFile() {
        String dataStorageFile = "/data/buses/buses.json";
        FileInputStream dataIn = null;
        FileOutputStream dataOut = null;
        File busesFile;
            busesFile = new File(App.class.getResource(dataStorageFile).getFile());
            try {
                dataIn = new FileInputStream(busesFile);
                dataObj = new JSONArray(new JSONTokener(dataIn));
                
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}