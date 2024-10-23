package volunteer;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class LogIn extends JFrame implements ActionListener {

	
	JLabel fName = new JLabel("Name & ID");
	JTextField inNameAndID = new JTextField(30);
	
	JTextField logInMessage = new JTextField(30);
	
	
	
	JButton submit = new JButton("Submit");
	
	JTextField submitMessage = new JTextField(30);
	
	
	
	JPanel namePanel = new JPanel();
	JPanel IDPanel = new JPanel();
	
			
	JPanel completePanel = new JPanel();
	
	
	
	
	
	
	
	public LogIn() {
		super("Log In");
		 setLayout(new FlowLayout());
		 
		 submit.addActionListener(this);
		
		
		namePanel.add(fName);
		namePanel.add(inNameAndID);
		

		logInMessage.setText("If Name: 'Bob' & Id: '1' Enter: 'Bob1' ");
		submitMessage.setEditable(false);
		

		completePanel.setLayout(new BoxLayout(completePanel, BoxLayout.Y_AXIS));
		
		
		
		completePanel.add(namePanel);
		completePanel.add(IDPanel);
		completePanel.add(logInMessage);
		completePanel.add(submit);
		completePanel.add(submitMessage);
		
		add(completePanel);
		setSize(600,400);
		
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Log In  Button is working");
		
		String s = inNameAndID.getText();
		boolean userFound = false;
		
		for(Volunteer v: HomePage.members.getList()) {
			if(s.equals(v.getName() + v.getID())) {
				HomePage.currentUser = v;
				userFound = true;
				break;
			
			}
		}
		
		if(userFound) {
			submitMessage.setText(HomePage.currentUser.getName() + 
					" with ID number (" + HomePage.currentUser.getID() +
					") has successfully logged in.");
			
			
			HomePage.SignUp.setVisible(false);
			HomePage.LogIn.setVisible(false);
			
			HomePage.LogOut.setVisible(true);
			HomePage.JoinOrgs.setVisible(true);
			HomePage.ShowHours.setVisible(true);
			HomePage.LogHours.setVisible(true);
			
			HomePage.welcome.setText("Welcom to Volunteer Help " + s);
			
			
			
		}else {
			submitMessage.setText("This user doesn't exist. Please try again.");
		}

	}

}
