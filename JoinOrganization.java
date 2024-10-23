package volunteer;


import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;



public class JoinOrganization extends JFrame implements ActionListener {

	
	
	//JComboBox<String> Organizations;
	
	JComboBox<String> types; 
	JComboBox<String> location;  
	JComboBox<String> memberCount; 
	
	JComboBox<String> matchedOrganizations;
	
	JButton selectionConditions = new JButton("Submit");
	JButton selectOrganization = new JButton("Submit Organization Choice");
	JButton back = new JButton("Back to Select Conditions");
	
	JPanel panelJoinOrg = new JPanel();
	JPanel panelSelectConditions =  new JPanel();
	
	JTextField title = new JTextField ("Select Organization Conditions");
	JTextArea message = new JTextArea(10,30);
	//types -- Community Service, Environmental, Healthcare,  Youth
	//location --- In-person, Virtual
	//members for now, <500 & >= 500
	
	public JoinOrganization() {
		super("Join an Organization");
		setLayout(new FlowLayout());
		
		
		title.setHorizontalAlignment((int) JTextField.CENTER_ALIGNMENT);
		title.setEditable(false);
		
		
		message.setLineWrap(true);
		message.setEditable(false);
	
		
		
		JLabel labelOne = new JLabel("Types");
		JLabel labelTwo = new JLabel("Location");
		JLabel labelThree = new JLabel("memberCount");
		
		
		types = new JComboBox<String>(new String[] {"Community Service", "Environmental", "Healthcare", "Youth"});
		location = new JComboBox<String>(new String[] {"In-person", "Virtual"});
		memberCount = new JComboBox<String>(new String[] {"0+" ,"200+", "400+", "600+"});
		
		matchedOrganizations = new JComboBox<String>(new String[] {});
		
		
		JPanel completePanel = new JPanel();
		
		

		JPanel panelType = new JPanel();
		JPanel panelLocation = new JPanel();
		JPanel panelMemberCount = new JPanel();
		
		
	
		
		panelType.setLayout(new BoxLayout(panelType, BoxLayout.Y_AXIS));
		panelLocation.setLayout(new BoxLayout(panelLocation, BoxLayout.Y_AXIS));
		panelMemberCount.setLayout(new BoxLayout(panelMemberCount, BoxLayout.Y_AXIS));
		panelJoinOrg.setLayout(new BoxLayout(panelJoinOrg, BoxLayout.Y_AXIS));
		
		completePanel.setLayout(new BoxLayout(completePanel, BoxLayout.Y_AXIS));
	
		
		
		panelType.add(labelOne);
		panelType.add(types);
		
		panelLocation.add(labelTwo);
		panelLocation.add(location);
		
		panelMemberCount.add(labelThree);
		panelMemberCount.add(memberCount);
		
		panelSelectConditions.add(panelType);
		panelSelectConditions.add(panelLocation);
		panelSelectConditions.add(panelMemberCount);
		panelSelectConditions.add(selectionConditions);
		
		
		
		panelJoinOrg.add(matchedOrganizations);
		panelJoinOrg.add(selectOrganization);
		panelJoinOrg.add(message);
		panelJoinOrg.add(back);
		
		
		//action listener & commands for buttons
		selectionConditions.addActionListener(this);
		selectionConditions.setActionCommand("Selected Condtions");
		
		selectOrganization.addActionListener(this);
		selectOrganization.setActionCommand("Selected Organization");
		back.addActionListener(this);
		back.setActionCommand("Back");
		
		matchedOrganizations.addActionListener(this);
		matchedOrganizations.setActionCommand("Organization?");
		
		
		
		completePanel.add(title);
		completePanel.add(panelSelectConditions);
		completePanel.add(panelJoinOrg);
		
		panelJoinOrg.setVisible(false);

		
	    add(completePanel);
		

		
		
		setSize(600, 400);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals(selectionConditions.getActionCommand())) {
			SelectConditions();
		}
		else if(s.equals(selectOrganization.getActionCommand())) {
			SelectOrganization();		
		}
		else if(s.equals(back.getActionCommand())) {
			back();
		}
		else if(s.equals(matchedOrganizations.getActionCommand())) {
			infoOnOrganization();
		}
		else {
			System.out.println("error in buttons in Join Organization page");
		}
		
		
	}
	
	public void SelectConditions() {
		title.setText("Select an Organization");
		panelJoinOrg.setVisible(true);
		panelSelectConditions.setVisible(false);
		
		System.out.println("Select Conditions Button");
	//types, location, memberCount
		String strType = (String) types.getSelectedItem();
		String strLocation = (String) location.getSelectedItem();
		String strMemberCount = (String) memberCount.getSelectedItem();
		
		int count = Integer.parseInt(strMemberCount.substring(0, strMemberCount.length() - 1));
		
		//System.out.println("Type: " + strType + "\nLocation: " + strLocation + "\nMember Count: " + count);
		
		
		
		ArrayList<String> temp =  HomePage.currentUser.findOrganizations(strType, HomePage.volunteerOrgs, strLocation, count);
		
		matchedOrganizations.setModel(new DefaultComboBoxModel<String>(temp.toArray(new String[temp.size()])));


		
	}
	
	
	public void SelectOrganization() {
		System.out.println("Select Organization Button");
		String strOrganization = ((String) matchedOrganizations.getSelectedItem());
		//strOrganization = strOrganization.substring(strOrganization.indexOf(" " ) + 1);
		
		System.out.println(strOrganization);
		
		HomePage.currentUser.addOrganization(strOrganization);
		message.setText("Congrats. You are part of " + strOrganization);
		
	}  
	
	public void infoOnOrganization() {
		
		int i = matchedOrganizations.getSelectedIndex();
		message.setText(HomePage.currentUser.tempVolOrgArray.get(i ).toString());
		
		
		
	}
	
	public void back() {
		System.out.println("Back to Select Organization Conditions");
		title.setText("Select Organization Conditions");
		panelJoinOrg.setVisible(false);
		panelSelectConditions.setVisible(true);
	}
}
