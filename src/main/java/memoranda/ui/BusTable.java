package main.java.memoranda.ui;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.json.JSONObject;
import org.json.JSONTokener;

import main.java.memoranda.BusImpl;



/*Bus Table. SER316 Frankfurt 
 * AUTHOR: TRESOR CYUBAHIRO
 * SER 316
 * */
public class BusTable extends JTable {
    
    static Object[] columnNames = {"ID", "Name", "Number Of Seats"};
    Vector<BusImpl> busesList;
    JSONObject dataObj = null;
    
    DefaultTableModel tableModel  = null;   
    
    public BusTable() {
        super();
        this.setShowGrid(false);
        this.setFont(new Font("Dialog",0,11));
        dataObj = new JSONObject();
        loadBuses();
        tableModel = new DefaultTableModel();
        this.setModel(tableModel);
        initColums();
        initTable();
    }

    	// Method to add titles to table
    void initColums() {
            for (int i = 0; i < columnNames.length; i++) {
                TableColumn col = new TableColumn();
                col.setWidth(500);
                col.setHeaderValue(columnNames[i]);
                this.addColumn(col);
        }
    }

    	// Method to repopulate table
    public void tableChanged() {
        initTable();
        initColums();
        updateUI();
    }

    	// Method to initialize table with data
    public void initTable() {
    		
    }

    // Method to load all current added buses
    private void loadBuses() {
            readFile();

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
                dataObj = new JSONObject(new JSONTokener(dataIn));
                
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}