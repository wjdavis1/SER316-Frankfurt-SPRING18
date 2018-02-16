package main.java.memoranda.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;


public class DriversPanel extends JPanel {
	
	BorderLayout bLayout1 = new BorderLayout();
	Border border1;
	JSplitPane sPane = new JSplitPane();
	
	WorkPanel parentPanel = null;
	
	public DriversPanel(WorkPanel _parentPanel){
		try {
			parentPanel = _parentPanel;
		}catch(Exception ex) {
			new ExceptionDialog(ex);
		}
	}
	
	void jbInit() throws Exception{
		System.out.println("The Driver Panel is Created Here!");
	}

}
