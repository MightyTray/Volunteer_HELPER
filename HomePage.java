package volunteer;

import java.awt.*; 
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

//import LogIn;
//import SignUp;
//import VolunteerList;


public class HomePage extends JFrame implements ActionListener
{

	public static VolunteerList members = new VolunteerList();
	public static Volunteer currentUser = null;
	public static int IDNumber = 0;
	public static ArrayList<VolunteerOrganization> volunteerOrgs;
	
	
  /** 
  For home page, we need these buttons:
      volunteer sign up
      volunteer log in
      join organizations
      log hours
      show hours
  */

  SignUp SignUpFrame = new SignUp();
  LogIn LogInFrame = new LogIn();
  JoinOrganization JoinOrgFrame = new JoinOrganization();
  LogHours LogHoursFrame = new LogHours();
  ShowInfo ShowInfoFrame = new ShowInfo();
  
  //the stuff that will show up on the home page
  static JLabel welcome = new JLabel("Welcome to Volunteer Help");
  static JTextField message = new JTextField("");
  
  static JButton SignUp = new JButton("Sign Up");
  static JButton LogIn = new JButton("Log In");
  static JButton JoinOrgs = new JButton("Join Organizations");
  static JButton LogHours = new JButton("Log Hours");
  static JButton ShowHours = new JButton("Show User Info");
  static JButton LogOut = new JButton("Log Out");


  //panels used to make the page looks neat and not clumped together
  JPanel one = new JPanel();


  public HomePage(){

    super("Home");
    setLayout(new FlowLayout());
    
    volunteerOrgs = makeVolunteerOrganizationList();
//    for(VolunteerOrganization v: volunteerOrgs) {
//    	System.out.println(v);
//    }


    //the other frames that spawns when buttons are clicked
    SignUpFrame.setVisible(false);
    LogInFrame.setVisible(false);
    JoinOrgFrame.setVisible(false);
    LogHoursFrame.setVisible(false);
    ShowInfoFrame.setVisible(false);
  
    
    LogIn.setVisible(false);
    LogOut.setVisible(false);
    JoinOrgs.setVisible(false);
    LogHours.setVisible(false);
    ShowHours.setVisible(false);


    //adds action listeners for each button
    SignUp.addActionListener(this);
    LogIn.addActionListener(this);
    JoinOrgs.addActionListener(this);
    LogHours.addActionListener(this);
    ShowHours.addActionListener(this);
    LogOut.addActionListener(this);

    //sets the action commands for each button
    SignUp.setActionCommand("Sign Up");
    LogIn.setActionCommand("Log In");
    JoinOrgs.setActionCommand("Join Orgs");
    LogHours.setActionCommand("Log Hours");
    ShowHours.setActionCommand("Show User Info");
    LogOut.setActionCommand("Log Out");
    
    message.setEditable(false);

//    panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS) );
    
    one.setLayout(new BoxLayout(one, BoxLayout.Y_AXIS));
   
    
    one.add(welcome);
    one.add(SignUp);
    one.add(LogIn);
    one.add(JoinOrgs);
    one.add(LogHours);
    one.add(ShowHours);
    one.add(LogOut);
    one.add(message);
   

   
    add(one);


    setSize(300, 400);
   
    
  }
  
  
  

  public void actionPerformed( ActionEvent evt)  
  {
   String a = evt.getActionCommand();
    if(a.equals("Sign Up")){
      System.out.println("Sign Up");
      SignUpFrame.setVisible(true);
      
    }
    
    else if(a.equals("Log In")){
      System.out.println("Log in");
      LogInFrame.setVisible(true);
    }
    
    else if( a.equals("Join Orgs")){
      System.out.println("JOin Orgs");
      JoinOrgFrame.setVisible(true);
   
    }
    
    else if ( a.equals("Log Hours")){
      System.out.println("Log Hours");
      if(HomePage.currentUser.getOrganizations().size() == 0) {
    	  message.setText("Join an organization first!!");

      }
      else {
    	  message.setText("");
    	  LogHoursFrame.setVisible(true);
	      LogHoursFrame.setOrganization();  
      }
	     
      
    }
    
    else if(a.equals("Show User Info")){
      System.out.println("Show User Info");
      ShowInfoFrame.setInfo();
      ShowInfoFrame.setVisible(true);
    }
    
    else if(a.equals("Log Out")) {
    	currentUser = null;
    	
    	SignUp.setVisible(true);
    	LogIn.setVisible(true);
    	
    	LogOut.setVisible(false);
    	JoinOrgs.setVisible(false);
    	ShowHours.setVisible(false);
    	LogHours.setVisible(false);
    	
    	welcome.setText("Welcome to Volunteer Help");
    	message.setText("");
    	
    	System.out.println("Log Out");
    	
    }
    
    else{
      System.out.println("Error");
    }
  }
  
  
  private ArrayList<VolunteerOrganization> makeVolunteerOrganizationList() {
	  ArrayList<VolunteerOrganization> listOfOrganizations = new ArrayList<VolunteerOrganization>(); 
		Scanner sc = null;
      // String cwd = Path.of("").toAbsolutePath().toString();
      // System.out.println(cwd);
		try {
			sc = new Scanner(new File("src/VolunteerOrganizations.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      sc.nextLine();
		while(sc.hasNextLine()) {
          String line = sc.nextLine();
			String[] org = line.split(","); 
			listOfOrganizations.add(new VolunteerOrganization(org[0], org[1], org[2], org[3], Integer.parseInt(org[4]))); 
		}
		return listOfOrganizations;
  }
  
  
  public static void addVolunteerToList(Volunteer v) {
	  members.add(v);
  }


}

