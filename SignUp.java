package volunteer;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener
{

  /**
  info to collect
     name
    date of birth
     starting hours
     awards --> For later in showinfo or showhours button
     description???
  */
  
  
  JLabel Name = new JLabel("Name");
  JLabel DOB = new JLabel("Date Of Birth");
  JLabel description = new JLabel("Describe Yourself In a Few Words");
  JButton submit = new JButton("Submit");
  
  JTextField message = new JTextField(40);
 
  
  
  

  JTextField inName = new JTextField(30);
  JTextField inDOB = new JTextField(30);
  JTextField inDescription = new JTextField(30);

  
  
  JPanel fNamePanel = new JPanel();
  JPanel DOBPanel = new JPanel();
  JPanel DescriptionPanel = new JPanel();
  JPanel ButtonPanel = new JPanel();
 
  

  JPanel completePanel = new JPanel();
  
  
  public SignUp(){
    super("Sign Up");
    
    setLayout(new FlowLayout());
    
    submit.addActionListener(this);

    fNamePanel.add(Name);
    fNamePanel.add(inName);

  

    DOBPanel.add(DOB);
    DOBPanel.add(inDOB);



    DescriptionPanel.add(description);
    DescriptionPanel.add(inDescription);
    
    
    ButtonPanel.add(submit);

    
    
    completePanel.add(fNamePanel);
    completePanel.add(DOBPanel);
    completePanel.add(DescriptionPanel);
    completePanel.add(ButtonPanel);
    completePanel.add(message);
    
    message.setEditable(false);
    
    completePanel.setLayout(new BoxLayout(completePanel, BoxLayout.Y_AXIS));
    
    add(completePanel);
    
    setSize(1200,400);
  }

  
  public void actionPerformed( ActionEvent evt)  
  {
   String fName =  inName.getText();
   String DOB = inDOB.getText();
   String description = inDescription.getText();
   
   System.out.println("Sign up button action performed should work");
   
   HomePage.addVolunteerToList(new Volunteer(fName, DOB, description));
   HomePage.currentUser = HomePage.members.get(HomePage.members.size() - 1);
   
   HomePage.welcome.setText("Welcome to Volunteer Help " + (fName + HomePage.currentUser.getID()) );
   
   
   HomePage.SignUp.setVisible(false);
   HomePage.LogIn.setVisible(false);
   
  
   HomePage.JoinOrgs.setVisible(true);
   HomePage.LogHours.setVisible(true);
   HomePage.ShowHours.setVisible(true);
   HomePage.LogOut.setVisible(true);
   
   
   message.setText(fName + " has made an account. Your ID Number is " + HomePage.IDNumber);
  
  }

  
}