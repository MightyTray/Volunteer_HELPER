package volunteer;

import java.awt.FlowLayout;

import javax.swing.*;
//import java.awt.*; 
//import java.awt.event.*;

public class ShowInfo extends JFrame{
	
	JTextField user = new JTextField("");
	JTextArea info = new JTextArea(20, 30);
	
	public ShowInfo() {
		super("User Info");
		setLayout(new FlowLayout());
		
		JPanel completePanel = new JPanel();
		completePanel.setLayout(new BoxLayout(completePanel, BoxLayout.Y_AXIS));
		
		completePanel.add(user);
		completePanel.add(info);
		
		
		add(completePanel);
		setSize(600,400);

	}
	
	
	public void setInfo() {
		Volunteer v = HomePage.currentUser;
		
		user.setText("User: "  +  v.getName() + v.getID());
	
		String s = "Name: " + v.getName() + "\n";
		s += "ID: " + v.getID() + "\n";
		s += "DOB: " + v.getDOB() + "\n";
		s+= "Description: " + v.getDescription() + "\n\n";
		s+= "HOURS PER ORGANIZATION\n\n";
		
		for(int i = 0; i < v.organizations.size(); i++) {
			s+= v.organizations.get(i) + ": --> " + v.hoursPerOrganization.get(i) + "\n";
		}
		
		s += "\n\nTOTAL HOURS: " + v.getHours();
		
		info.setText(s);
	}
}
