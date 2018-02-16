package main.java.memoranda.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddBusPanel extends JPanel {
	private JTextField busIDTextField;
	private JTextField numberOfSeatsTextField;

	/**
	 * Create the panel.
	 */
	public AddBusPanel() {
		setLayout(null);
		
		JLabel busIDLabel = new JLabel("Bus ID: ");
		busIDLabel.setBounds(30, 29, 58, 33);
		busIDLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(busIDLabel);
		
		busIDTextField = new JTextField();
		busIDTextField.setEnabled(false);
		busIDTextField.setEditable(false);
		busIDTextField.setBounds(125, 32, 130, 26);
		add(busIDTextField);
		busIDTextField.setColumns(10);
		
		JButton generateIDButton = new JButton("Generate ID");
		generateIDButton.setBounds(267, 32, 117, 29);
		add(generateIDButton);
		
		JLabel NoOfSeatsLabel = new JLabel("No Of Seats:");
		NoOfSeatsLabel.setBounds(30, 74, 85, 16);
		add(NoOfSeatsLabel);
		
		numberOfSeatsTextField = new JTextField();
		numberOfSeatsTextField.setBounds(125, 70, 130, 26);
		add(numberOfSeatsTextField);
		numberOfSeatsTextField.setColumns(10);
		
		JButton addBusButton = new JButton("Add Bus");
		addBusButton.setBounds(267, 163, 117, 29);
		add(addBusButton);

	}
}
