package volunteer;
import java.util.ArrayList;

public class VolunteerOrganization {
    private String description;
//    private String[] pictures;
//    private double distance;
    private String organizationName;
    private String organizationType;
    private String location; 
    // private ArrayList<Volunteer> volunteerList;
    private int memberCount;

    public VolunteerOrganization(String s, String n, String t, String l, int c) {
        organizationName = s;
        description = n;
        organizationType = t;
        setLocation(l); 
        // volunteerList = new ArrayList<>();
        memberCount = c;
    }

    public void addMember(int count) {
        memberCount += count;
    }

    public void addMember() {
        addMember(1);
    }

    public int getMemberCount() {
        return memberCount;
    }

    // public boolean addMember(Volunteer v) {
    //     if (getMemberCount() >= 20) return false;

    //     volunteerList.add(v);
    //     return true;
    // }

    

    // public int getMemberCount() {
    //     return volunteerList.size();
    // }
    
    public String getOrganizationType() {
    	return organizationType; 
    }
    
    public String getOrganizationName() {
    	return organizationName; 
    }

    public String toString() {
        return "This is the " + organizationName + " organization. Their goal is to "
            + description + ". They have " + getMemberCount() + " members.";
    }

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

   /*  public void showLogo() {

    }*/  
}
