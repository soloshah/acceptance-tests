package uk.nhs.nhsbsa.ccchs.model;

public class CreateNewCustomer {
	
	/* Customer Details */
	public title Title;
	public String OtherTitle;
	public String Name;
	public String Surname;
	public String Dob;
	
	/* Address */
	public String Addr1;
	public String Addr2;
	public String TownCity;
	public String PostCode;

	/* Contact Details */
	public String HomePhone;
	public String MobilePhone;
	public String Email;


	public enum title {
		Mr, Mrs, Miss, Ms, Other, NotSet
	}
	
	public int titlevalue;

}

