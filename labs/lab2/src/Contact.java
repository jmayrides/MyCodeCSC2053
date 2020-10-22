
public class Contact {

	public String firstName;
	public String lastName;
	public String address;
	public String phoneNumber;

	public Contact (String fn, String ln, String add, String pn) {
		firstName = fn;
		lastName = ln;
		address= add;
		phoneNumber = pn;
	}

	public String getfirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public String getaddress() {
		return address;
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	public void setaddress(String add ) {
		this.address = add;
	}
	public void setphoneNumber(String pNumber) {
		this.phoneNumber= pNumber;
	}

	@Override
	public String toString() {
		String result= firstName +" "+  lastName +" "+  phoneNumber;
		return result;		
	}

	public boolean equals(Object o) {
		Contact otherContact = (Contact) o;
		if(otherContact.getfirstName().equals(getfirstName()) && 
				otherContact.getLastName().equals(getLastName()) && 
				otherContact.getphoneNumber().equals(getphoneNumber())) {
			return true;
		}
		return false;
	}
}