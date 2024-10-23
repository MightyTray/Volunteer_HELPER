package volunteer;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LogHours extends JFrame implements ActionListener  {
	
	
	
	JComboBox<String> organization;
	JComboBox<Integer> hours;
	JComboBox<Integer> minutes;
	
	JButton submit = new JButton("Submit");
	JTextArea message = new JTextArea(5, 30);
	
	
	
	
	public LogHours() {
		super("Log Volunteer Hours");
		setLayout(new FlowLayout());
		
		JPanel completePanel = new JPanel();
		
		JPanel selectionPanel = new JPanel();
		JPanel selectOrg = new JPanel();
		JPanel selectHoursandMin = new JPanel();
		
		
		
		JLabel orgLabel = new JLabel("Select Organization");
		JLabel hoursLabel = new JLabel("Select Hours");
		JLabel minutesLabel = new JLabel("Select Minutes");
		
		
		
		Integer[] eachHour = new Integer[24];
		Integer[] eachMinute = new Integer[60];
		
		for(int i = 0; i < 24; i++) {
			eachHour[i] = i;
		}
		for(int i = 0; i < 60; i++) {
			eachMinute[i] = i;
		}
		
		organization = new JComboBox<String>();
		hours = new JComboBox<Integer>(eachHour);
		minutes = new JComboBox<Integer>(eachMinute);
		
		submit.addActionListener(this);
		
		message.setLineWrap(true);
		message.setEditable(false);
		
		
	   completePanel.setLayout(new BoxLayout(completePanel, BoxLayout.Y_AXIS));
	  
	   
	   
	   selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.X_AXIS));
	   
	   selectOrg.setLayout(new BoxLayout(selectOrg, BoxLayout.Y_AXIS));
	   selectHoursandMin.setLayout(new BoxLayout(selectHoursandMin, BoxLayout.Y_AXIS));
	   
	   selectOrg.add(orgLabel);
	   selectOrg.add(organization);
	   
	   
	   selectHoursandMin.add(hoursLabel);
	   selectHoursandMin.add(hours);
	   selectHoursandMin.add(minutesLabel);
	   selectHoursandMin.add(minutes);
	   
	   selectionPanel.add(selectOrg);
	   selectionPanel.add(selectHoursandMin);
	   
	   completePanel.add(selectionPanel);
	   completePanel.add(submit);
	   completePanel.add(message);
	   
	   
	   add(completePanel);
	   setSize(600, 400);
		
		
	}
	
	public void setOrganization() {
		organization.removeAllItems();
		
		int i = 1;
		for(String s:  HomePage.currentUser.organizations) {
			organization.addItem(s);
			i++;
		}
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		int index = organization.getSelectedIndex();
		
		int h = (int) hours.getSelectedItem();
		int m = (int) minutes.getSelectedItem();
		
		double timeVolunteered = (double)h + (double)m/60;
		
		HomePage.currentUser.addHours(index, timeVolunteered);
		
		message.setText("You have volunteered another " + timeVolunteered + " hours at " + ((String)organization.getSelectedItem() ));
		
	}
	
	
}
