// classes are grouped together in 'packages'
// Classes in the same pakage already see each other. 
// If a class is in another package, in other to see it, you need to import it
package pojos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

// This is a typical Java Class. 
public class Person {

	// As with any other object oriented language, classes have attributes (i.e. the properties of the class). 
	// Each attribute is in turn of another class
	private String firstname;	// this is an attribute of the class String, and it is 'private'
								// private attributes are only accesible inside the object
	private String lastname;	// this is an attribute of the class String
	private HealthProfile hProfile;	// this is an attribute of the class HealthProfile 
	private String birthday; // this is birthday
	private Long personId;
	// constructors in java are used to create an object of the class 
	// (a java program basically plays with objects of different classes)
	// this constructor creates a Person object with a particular firstname, lastname and health profile
	public Person(String fname, String lname, HealthProfile hp, String bday) {
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthday(bday);
		
		this.hProfile=hp;
	}
	public Person(String fname, String lname, String bday) {
		this.setPersonId(randInt(1,9999));
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthday(bday);
	}
	public Person(Long personId, String fname, String lname, String bday) {
		this.setPersonId(personId);
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthday(bday);
	}
	public Person(String fname, String lname, HealthProfile hp) {
		this.setPersonId(randInt(1,9999));
		this.setFirstname(fname);
		this.setLastname(lname);
		
		this.hProfile=hp;
	}
	public Person(String fname, String lname) {
		this.setPersonId(randInt(1,9999));
		this.setFirstname(fname);
		this.setLastname(lname);
		this.hProfile=new HealthProfile();
	}
	public Person() {
		this.setPersonId(randInt(1,9999));
		this.firstname="Pinco";
		this.lastname="Pallino";
		this.hProfile=new HealthProfile();
	}
	
	public static Long randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    return Long.valueOf(rand.nextInt((max - min) + 1) + min);
	}
	// classes have methods, which are basically pieces of programs that can be executed on objects of the class
	// this dummy class, has only 'accesor' methods (i.e. methods to access its properties, which are all private)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public Long getPersonId() {
		return personId;
	}
	public String getBirthday() {
		//String formattedDate = new SimpleDateFormat("dd/MM/yyyy, Ka").format(date));
		return birthday;
		
	}
	public void setPersonId(Long id) {
		this.personId = id;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String randomBirthday(){
		/*long offset = Timestamp.valueOf("1950-01-01 00:00:00").getTime();
		long end = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
		long diff = end - offset + 1;
		Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
		*/
		return "123";
	}
	public HealthProfile gethProfile() {
		return hProfile;
	}
	public void sethProfile(HealthProfile hProfile) {
		this.hProfile = hProfile;
	}
}
