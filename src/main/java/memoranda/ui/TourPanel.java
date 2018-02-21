package main.java.memoranda.ui;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;	 
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog;
import main.java.memoranda.TourImpl;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JButton;	 
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TourPanel extends JPanel {
	
	public TourPanel() {
		
		//this.setLayout(new BorderLayout());
		this.setLayout(new FlowLayout());
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(200,35));
		JTextArea tourListArea = new JTextArea();
		tourListArea.setText("Tour Info Goes Here");
		tourListArea.setPreferredSize(new Dimension(400,30));
		tourListArea.setBorder(getBorder());
		JButton button = new JButton("Save Tour Info");
		
		topPanel.add(tourListArea);
		bottomPanel.add(input);
		bottomPanel.add(button);
		
		this.add(topPanel);
		this.add(bottomPanel);
		

		
		
		
	}
}
