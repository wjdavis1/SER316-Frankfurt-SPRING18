package main.java.memoranda.ui;

/** Description: A table to display the contents of the RouteCollection Hashmap on the Route Panel
* @author: James Ortner
* Date: February 28, 2018
* 
*/
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.Dimension;

import java.util.HashMap;

import main.java.memoranda.RouteCollection;
import main.java.memoranda.Route;

public class RouteTable extends JPanel {

    private JTable table;
    private HashMap<String,Route> routeCollection;
    private String[] columnNames = {"Destination","Route ID", "Start Point"};
    private Object[][] data;
    private int index = 0;
    

    public RouteTable() {
        super(new GridLayout(1,0));
        
        routeCollection = RouteCollection.getRoutes();
        data = new Object[routeCollection.keySet().size()][columnNames.length];
        
        for(String routeId : routeCollection.keySet()) {
            Route route = routeCollection.get(routeId);
            data[index][0] = route.getDestination();
            data[index][1] = route.getRouteId();
            data[index][2] = route.getStartPoint();
            index++;
        }

        index = 0;

        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(1000,700));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }  
}