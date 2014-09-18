import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import pojos.HealthProfile;
import pojos.Person;


public class HealthProfileReader {
	
	public static Map<Long,Person> database = new HashMap<Long,Person>();
	
	static
    {
    	Person pallino = new Person();
		Person pallo = new Person("Pinco","Pallo");
		HealthProfile hp = new HealthProfile(68.0,1.72);
		Person john = new Person("John","Doe",hp);
		
		HealthProfile pavel_hp = new HealthProfile(76.0,1.86);
		Person pavel = new Person("Pavel","Kucherbaev",pavel_hp);
		
		database.put(pallino.getPersonId(), pallino);
		database.put(pallo.getPersonId(), pallo);
		database.put(john.getPersonId(), john);
		database.put(Long.valueOf(1), pavel);
    }
	/**
	 * The health profile reader gets information from the command line about
	 * weight and height and calculates the BMI of the person based on this 
	 * parameters
	 * 
	 * @param args
	 */
	public static void createPerson(Long personId, String firstname, String lastname, String birthdate){
		Person p = new Person(personId,firstname,lastname, birthdate);
		database.put(p.getPersonId(),p);
	}
	public static void displayHealthProfile(Long personId){
		Person p= database.get(personId);
		if (p!=null) { 
			System.out.println(p.getFirstname()+" "+p.getLastname()+"'s health profile is: "+p.gethProfile().toString());
		}else{
			System.out.println(String.valueOf(personId)+" is not in the database 1");
		}
	}
	public static void updateHealthProfile(Long personId, Double height, Double weight){
		Person p= database.get(personId);
		if (p!=null) { 
			HealthProfile hprofile = p.gethProfile();
			hprofile.setHeight(height);
			hprofile.setWeight(weight);
			
			System.out.println(p.getFirstname()+" "+p.getLastname()+"'s health profile is: "+p.gethProfile().toString());
		}else{
			System.out.println(String.valueOf(personId)+" is not in the database");
		}
	}
	public static void main(String[] args) {
		int argCount = args.length;
		if (argCount == 0) {
			System.out
					.println("I cannot create people out of thing air. Give me at least a name and lastname.");
		} else if (argCount < 2) {
			System.out
					.println("Are you sure you gave me ALL the information I need?");
		} else {
			String method = args[0];
			if (method.equals("createNewPerson")) {
				Long personId = Long.parseLong(args[1]);
				String firstname = args[2];
				String lastname = args[3];
				String birthdate = args[4];
				createPerson(personId, firstname, lastname, birthdate);
			} else if (method.equals("displayHealthProfile")) {
				Long personId = Long.parseLong(args[1]);
				displayHealthProfile(personId);				
			}  else if (method.equals("updateHealthProfile")) {
				Long personId = Long.parseLong(args[1]);
				Double height = Double.parseDouble(args[2]);
				Double weight = Double.parseDouble(args[3]);
				updateHealthProfile(personId, height, weight);
			} else {
				System.out.println("The system did not find the method '"+method+"'");
			}
		}
		// add the case where there are 3 parameters, the third being a string that matches "weight", "height" or "bmi"
	}
	
	//public static void initializeDatabase() {
	//	Person pallino = new Person();
	//	Person pallo = new Person("Pinco","Pallo");
	//	HealthProfile hp = new HealthProfile(68.0,1.72);
	//	Person john = new Person("John","Doe",hp);
	//	
	//	database.put(pallino.getFirstname()+" "+pallino.getLastname(), pallino);
	//	database.put(pallo.getFirstname()+" "+pallo.getLastname(), pallo);
	//	database.put(john.getFirstname()+" "+john.getLastname(), john);
	//}
}