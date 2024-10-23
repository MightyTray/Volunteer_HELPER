package volunteer;
import java.util.ArrayList;

public class Volunteer {

	private String name;
	  private double hours;
	
	  //these three variables are kind of useless
	  private String DOB;
	  private String[] awards;
	  private String description;
	  
	  private int ID;
	  public ArrayList<String> organizations;
	  public ArrayList<Double> hoursPerOrganization;
	  
	  public ArrayList<VolunteerOrganization> tempVolOrgArray;
	  
	 
	  public Volunteer(String name, String DOB, String description){
		  setName(name);
		  setDOB(DOB);
		  setDescription(description);
		  setHours(0);
		  
		  setAwards(null);
		  
		  HomePage.IDNumber += 1;
		  setID(HomePage.IDNumber);
		  organizations = new ArrayList<String>();
		  hoursPerOrganization = new ArrayList<Double>();
		  tempVolOrgArray = new ArrayList<VolunteerOrganization>();
		 
	  }



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String[] getAwards() {
		return awards;
	}

	public void setAwards(String[] awards) {
		this.awards = awards;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public void addOrganization(String s) {
		organizations.add(s);
		hoursPerOrganization.add(0.0);
	}
	
	public ArrayList<String> getOrganizations(){
		return organizations;
	}
	
	public void addHours(int index, double hours){
		hoursPerOrganization.set(index, hoursPerOrganization.get(index) + hours );
		this.hours += hours;
		
			
	}

	public ArrayList<String> findOrganizations(String type, ArrayList<VolunteerOrganization> list, String location, int memberCount) {
		tempVolOrgArray.clear();
		VolunteerOrganization tempOrg;
		ArrayList<String> tempList = new ArrayList<String>();
		
		
		
		for(int i = 0; i < list.size(); i++) {
			tempOrg = list.get(i);
			if( tempOrg.getOrganizationType().equals(type) && 
				tempOrg.getMemberCount() >= memberCount && 
				tempOrg.getLocation().equals(location)){
				
					tempVolOrgArray.add(tempOrg);
					tempList.add(tempOrg.getOrganizationName());
				
			}
		}
		
		//System.out.println(tempList);
		return tempList;
  }
	



}
