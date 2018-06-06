package uk.nhs.nhsbsa.ccchs.model;

public class CreateNewComplaint {
	
	public type Type;
	public String Priority;
	public String AssignedBy;
	public String AssignedByTeam;
	public String ComplaintSummary;
	public String Outcome;
	public String Option1;
	public String Option2;
	public String Status;

	public enum type {
		Telephone, Letter, Email, SocialMedia
	}

}

