package main.java.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.java.memoranda.CurrentProject;
import main.java.memoranda.Resource;
import main.java.memoranda.util.AppList;
import main.java.memoranda.util.CurrentStorage;
import main.java.memoranda.util.Local;
import main.java.memoranda.util.MimeType;
import main.java.memoranda.util.MimeTypesList;
import main.java.memoranda.util.Util;

import org.json.*;
import java.io.*;

/*BusesPanel 
 * AUTHOR: TRESOR CYUBAHIRO
 * 
 * */
public class BusesPanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    JToolBar toolBar = new JToolBar();
    JButton newBusB = new JButton();
    BusTable busTable = new BusTable();
    JScrollPane scrollPane = new JScrollPane();
    JButton refreshB = new JButton();
  JPopupMenu busPPMenu = new JPopupMenu();
  JMenuItem ppNewBus = new JMenuItem();
  JMenuItem ppRefresh = new JMenuItem();

    public BusesPanel() {
        try {
            jbInit();
        }
        catch (Exception ex) {
           new ExceptionDialog(ex);
        }
    }
    void jbInit() throws Exception {
        toolBar.setFloatable(false);
        this.setLayout(borderLayout1);
        newBusB.setText(Local.getString("New"));
        newBusB.setEnabled(true);
        newBusB.setMaximumSize(new Dimension(24, 24));
        newBusB.setMinimumSize(new Dimension(24, 24));
        newBusB.setToolTipText(Local.getString("New Bus"));
        newBusB.setRequestFocusEnabled(false);
        newBusB.setPreferredSize(new Dimension(24, 24));
        newBusB.setFocusable(false);
        newBusB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newBusB_actionPerformed(e);
            }
        });
        newBusB.setBorderPainted(false);
        busTable.setMaximumSize(new Dimension(32767, 32767));
        busTable.setRowHeight(24);
        scrollPane.getViewport().setBackground(Color.white);
        toolBar.addSeparator(new Dimension(8, 24));
        toolBar.addSeparator(new Dimension(8, 24));


        PopupListener ppListener = new PopupListener();
        scrollPane.addMouseListener(ppListener);
        refreshB.setBorderPainted(false);
        refreshB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshB_actionPerformed(e);
            }
        });
        refreshB.setFocusable(false);
        refreshB.setPreferredSize(new Dimension(24, 24));
        refreshB.setRequestFocusEnabled(false);
        refreshB.setToolTipText(Local.getString("Refresh"));
        refreshB.setMinimumSize(new Dimension(24, 24));
        refreshB.setMaximumSize(new Dimension(24, 24));
        refreshB.setEnabled(true);
        refreshB.setIcon(
            new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/refreshres.png")));
        busPPMenu.setFont(new java.awt.Font("Dialog", 1, 10));
    ppNewBus.setFont(new java.awt.Font("Dialog", 1, 11));
    ppNewBus.setText(Local.getString("New resource")+"...");
    ppNewBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppNewBus_actionPerformed(e);
            }
        });
    ppNewBus.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/addresource.png")));

    ppRefresh.setFont(new java.awt.Font("Dialog", 1, 11));
    ppRefresh.setText(Local.getString("Refresh"));
    ppRefresh.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ppRefresh_actionPerformed(e);
      }
    });
    ppRefresh.setIcon(new ImageIcon(main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/refreshres.png")));

    toolBar.add(newBusB, null);
        toolBar.addSeparator();
        toolBar.add(refreshB, null);
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.getViewport().add(busTable, null);
        this.add(toolBar, BorderLayout.NORTH);
    busPPMenu.addSeparator();
    busPPMenu.add(ppNewBus);
    busPPMenu.addSeparator();
    busPPMenu.add(ppRefresh);
	
    }

    void newBusB_actionPerformed(ActionEvent e) {
    		AddBusDialog dlg = new AddBusDialog(App.getFrame(), Local.getString("Add New Bus"));
        Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        dlg.setLocation((frmSize.width - dlg.getSize().width) / 2 + loc.x, (frmSize.height - dlg.getSize().height) / 2 + loc.y);
        dlg.setVisible(true);
        if (dlg.CANCELLED)
            return;
    }

    class PopupListener extends MouseAdapter {

                public void mousePressed(MouseEvent e) {
                    
                }

                public void mouseReleased(MouseEvent e) {
                  
                }


    }
    void refreshB_actionPerformed(ActionEvent e) {
    	
    }

  void ppRun_actionPerformed(ActionEvent e) {

  }
  void ppNewBus_actionPerformed(ActionEvent e) {
    newBusB_actionPerformed(e);
  }

  void ppRefresh_actionPerformed(ActionEvent e) {

  }
}