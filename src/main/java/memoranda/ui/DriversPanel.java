package main.java.memoranda.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;


public class DriversPanel extends JPanel {
	

	JToolBar driversToolBar = new JToolBar();
	JButton addDriver,removeDriver, findDriver;
	
	
	WorkPanel parentPanel = null;
	
	public DriversPanel(WorkPanel _parentPanel){
		try {
			parentPanel = _parentPanel;
			jbInit();
		}catch(Exception ex) {
			new ExceptionDialog(ex);
		}
	}
	
	void jbInit() throws Exception{
		System.out.println("The Driver Panel is Created Here!");
	}

}
