package uk.nhs.nhsbsa.ccchs.model;

public class CreateNewUser {

	public String Username;
	public String Password;
	public String EmailAddress;
	public user_role UserRole;
	public account_enabled AccountEnabled;


	public enum user_role {
		Administrator, SuperUser, Standard, Manager
	}
	
	public enum account_enabled {
		True, False
	}

}

