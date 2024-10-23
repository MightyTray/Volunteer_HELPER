package volunteer;
import java.util.ArrayList;

public class VolunteerList {
     private static ArrayList<Volunteer> volunteers = new ArrayList<Volunteer>();
     
   
     /**
      * extra methods for the class
      */
  public void add(Volunteer v) {
    	volunteers.add(v);
     }
  
  public int size() {
	  return volunteers.size();
  }
  
  public Volunteer get(int n) {
	  return volunteers.get(n);
  }
  
  public ArrayList<Volunteer> getList() {
	  return volunteers;
  }
  
}
