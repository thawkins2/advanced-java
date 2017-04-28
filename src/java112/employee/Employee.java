package java112.employee;

/**
 * @author Thomas Hawkins
 * class Employee
 */
public class Employee {
    
    private String employeeId;
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private String department;
    private String roomNumber;
    private String phoneNumber;
    
    /**
     * Constructor for Employee
     */
    public Employee() {
        
    }
    
	/**
	 * Returns the value of employeeId.
	 */
	public String getEmployeeId() {
		return employeeId;
	}


	/**
	 * Sets the value of employeeId.
	 * @param employeeId The value to assign employeeId.
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	/**
	 * Returns the value of firstName.
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * Sets the value of firstName.
	 * @param firstName The value to assign firstName.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * Returns the value of lastName.
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Sets the value of lastName.
	 * @param lastName The value to assign lastName.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Returns the value of socialSecurityNumber.
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}


	/**
	 * Sets the value of socialSecurityNumber.
	 * @param socialSecurityNumber The value to assign socialSecurityNumber.
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}


	/**
	 * Returns the value of department.
	 */
	public String getDepartment() {
		return department;
	}


	/**
	 * Sets the value of department.
	 * @param department The value to assign department.
	 */
	public void setDepartment(String department) {
		this.department = department;
	}


	/**
	 * Returns the value of roomNumber.
	 */
	public String getRoomNumber() {
		return roomNumber;
	}


	/**
	 * Sets the value of roomNumber.
	 * @param roomNumber The value to assign roomNumber.
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	/**
	 * Returns the value of phoneNumber.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * Sets the value of phoneNumber.
	 * @param phoneNumber The value to assign phoneNumber.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Returns formatted string output.
	 */
	public String toString() {
	    return "asdf";
	}
    
}