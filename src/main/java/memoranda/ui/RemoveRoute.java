package main.java.memoranda.ui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import main.java.memoranda.RouteCollection;

import java.io.IOException;

public class RemoveRoute extends JFrame  {
    JLabel routeID;
    JTextField routeIDEntry;
    JButton remove, cancel;
    JPanel removePanel, confirmationPanel;
    BorderLayout borderLayout = new BorderLayout();
    private RouteCollection routeCollection;
    
    public RemoveRoute() {
        super("RemoveRoute");
        try {
            jbInit();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void jbInit() {
        setLayout(borderLayout);
        routeID = new JLabel("Enter Route ID: ", SwingConstants.CENTER);
        
        routeIDEntry = new JTextField(10);
        
        remove = new JButton("Remove");
        cancel = new JButton ("Cancel");
        
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        removePanel = new JPanel();
        removePanel.add(routeID);
        removePanel.add(routeIDEntry);
        
        confirmationPanel = new JPanel();
        
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeRoute();
            }
        });
        
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        confirmationPanel.add(remove);
        confirmationPanel.add(cancel);
        
        removePanel.setPreferredSize(new Dimension(300,150));
        add(removePanel, BorderLayout.CENTER);
        add(confirmationPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void removeRoute() {
        routeCollection = new RouteCollection("routes.json");
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you wish to delete the route?", "Remove Route", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(option == JOptionPane.YES_OPTION) {
            routeCollection.removeRoute(routeIDEntry.getText());
            try {
                routeCollection.saveToFile();
            }catch(IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            JOptionPane.showMessageDialog(this, "Route has been removed");
            dispose();
            
        } else {
            JOptionPane.showMessageDialog(this,"Route Could Not Be Found or Route Is Not In System!");
            routeIDEntry.setText(null);
        }
    }
}
