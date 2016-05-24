package marketsss;

public class Employee {
	private String name;
	private String personID;
	private String password;
	
	public Employee(String name, String personID, String password ) {
		this.name = name;
		this.personID = personID;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getPersonID() {
		return personID;
	}

	public String getPassword() {
		return password;
	}

	
}