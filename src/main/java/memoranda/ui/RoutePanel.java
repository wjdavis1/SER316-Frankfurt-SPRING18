package main.java.memoranda.ui;
/**
 * File Name: RoutePanel.java
 * Description: The main panel for Route information such as finding a route, creating a route,
 * and displaying a list of current routes.
 * Author: James Ortner
 * Date: Feb 21st, 2018
 * 
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * 
 * Class: RoutePanel
 * Description: SEE FILE DESCRIPTION ABOVE
 *
 */
public class RoutePanel extends JPanel {
	
	BorderLayout borderLayout = new BorderLayout();
	GridLayout information = new GridLayout(5,2,5,8);
	JPanel routeInformation = new JPanel();
	JPanel routeList = new JPanel();
	JPanel emptyPanel = new JPanel();
	JToolBar routeToolBar = new JToolBar();
	JButton addRoute,removeRoute, findRoute,editRoute,refreshList;
	JSplitPane routeInfoPane,routePane;
	ImageIcon add, remove, find, edit, refresh;
	JLabel destination, routeId, startPoint, destinationText, routeIdText, startPointText;
	AddRoutePanel newRoute;
	RouteTablePanel newTable;
	RemoveRoute deleteRoute;
	EditRoutePanel editRouteInformation;
	
	// The work panel is the parent panel for Route and many other
	// panels
	WorkPanel parentPanel = null;
	
	public RoutePanel(WorkPanel _parentPanel){
		try {
			parentPanel = _parentPanel;
			jbInit();
		}catch(Exception ex) {
			new ExceptionDialog(ex);
		}
	}
	
	
	/**
	 * Method: jbInit
	 * Input: None
	 * Return: Void
	 * @throws Exception
	 * @description Following naming convention found across the program contain this method to instantiate
	 * the panel 
	 */
	void jbInit() throws Exception{
		System.out.println("[DEBUG] Route Panel has Been Created!");
		
		this.setLayout(borderLayout);
		add = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/todo_new.png"));
		remove = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/todo_remove.png"));
		find = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/help.png"));
		edit = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/editproject.png"));
		refresh = new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/refreshres.png"));
		
		addRoute = new JButton("Add Route", add);
		removeRoute = new JButton("Remove Route", remove);
		findRoute = new JButton("Find Route", find);
		editRoute = new JButton("Edit Route Information", edit);
		refreshList = new JButton("Refresh Route List", refresh);
		
		destination = new JLabel("Destination: ");
		routeId = new JLabel("Route ID: ");
		startPoint = new JLabel("Start Point: ");
		
		destinationText = new JLabel("ASU PolyTechnic");
		routeIdText = new JLabel("001");
		startPointText = new JLabel("ASU Tempe");
		
		destinationText.setHorizontalTextPosition(SwingConstants.RIGHT);

		addRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newRoutePanel();
			}
		});
		
		refreshList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        
        removeRoute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove();
            }
        });
        
        editRoute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                edit();
            }
        });
		
		routeToolBar.setFloatable(false);
		routeToolBar.addSeparator(new Dimension(8,24));
		routeToolBar.addSeparator(new Dimension(8,24));
		routeToolBar.add(addRoute);
		routeToolBar.add(removeRoute);
		routeToolBar.add(editRoute);
		routeToolBar.addSeparator();
		routeToolBar.add(findRoute);

		routeToolBar.setLayout(information);
		routeToolBar.add(destination);
		routeToolBar.add(destinationText);
		routeToolBar.add(routeId);
		routeToolBar.add(routeIdText);
		routeToolBar.add(startPoint);
		routeToolBar.add(startPointText);
	
		routeList.add(new JLabel("Table of Routes Goes Here", JLabel.CENTER));
		
		routeInfoPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,routeInformation, emptyPanel);
		routePane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, routeInfoPane,routeList);
		routePane.setDividerLocation(250);
		routePane.setOneTouchExpandable(false);
		this.add(routeToolBar, BorderLayout.NORTH);
		this.add(routePane);
	}
	/**
	 * Method: newRoutePanel
	 * Input: None
	 * Return: Void
	 * Description: Creates a new Add Route Panel when the add route button is pressed
	 */
	private void newRoutePanel() {
		newRoute = new AddRoutePanel();
	}
	
	/**
     * Method: remove
     * Input: none
     * Return: void/none
     * 
     * Description: Creates a new RemoveRoute JFrame that accepts user input in the form
     * of the RouteId and removes from there.
     */
    private void remove() {
        deleteRoute = new RemoveRoute();
    }
    /**
     * Method: edit
     * Input: None
     * Return: none
     * 
     * Description: Crates a new EditRoutePanel that allows the user to edit information
     * on a route by routeId.
     */
    private void edit() {
        editRouteInformation = new EditRoutePanel();
    }
    
    private void refreshTable() {
        newTable.refreshTable();
        newTable.revalidate();
        newTable.repaint();
    }

}