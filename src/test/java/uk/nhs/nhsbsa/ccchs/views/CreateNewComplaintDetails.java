package uk.nhs.nhsbsa.ccchs.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewComplaintDetails {
	
	 	@FindBy(id = "c_telephone")
	 	public WebElement Telephone;
	    
	    @FindBy(id = "c_letter")
	    public WebElement Letter;
	    
	    @FindBy(id = "c_email")
	    public WebElement Email;
	    
	    @FindBy(id = "c_socialmedia")
	    public WebElement SocialMedia;
	    
	    @FindBy(name = "priority")
	    public WebElement Priority;
	    
	    @FindBy(id = "reference")
	 	public WebElement Reference;
	     
	 	@FindBy(id = "assignedBy")
	 	public WebElement AssignedBy;
	    
	    @FindBy(id = "assignedByTeam")
	    public WebElement AssignedByTeam;
	    
	    @FindBy(id = "datepicker")
	    public WebElement OpenedDate;
	    
	    @FindBy(id = "summary")
	    public WebElement ComplaintSummary;
	    
	    @FindBy(id = "upheld")
	    public WebElement Upheld;
	    
	    @FindBy(id = "not_upheld")
	    public WebElement Notupheld;
	    
	    @FindBy(id = "select0")
	    public WebElement Outcome;
	    
	    @FindBy(id = "select1")
	    public WebElement SelectAnOption1;

	    @FindBy(id = "select2")
	    public WebElement SelectAnOption2;
	    
	    @FindBy(name = "complaintStatus")
	    public WebElement Status;
	    
	    @FindBy(id = "MI_cat")
	    public WebElement MICat;

	    @FindBy(id = "MI_cat_1")
	    public WebElement MIOpt;
	    
	    @FindBy(id = "SaveComplaint")
	    public WebElement SaveComplaint;
	    
	    @FindBy(xpath = ".//*[@id='form']/form/div[2]/div/button")
	    public WebElement AddNote;
	    
	    
	    
	    
	    public WebElement Telephone() {
	        return Telephone ;
	    }
	    
	    public WebElement Letter() {
	        return Letter ;
	    }
	    
	    public WebElement Email() {
	        return Email ;
	    }
	    
	    public WebElement SocialMedia() {
	        return SocialMedia ;
	    }
	    
	    public WebElement Priority() {
	        return Priority ;
	    }
	    
	    public WebElement Reference() {
	        return Reference ;
	    }
	    
	    public WebElement AssignedBy() {
	        return AssignedBy ;
	    }
	    
	    public WebElement AssignedByTeam() {
	        return AssignedByTeam ;
	    }
	    
	    public WebElement OpenedDate() {
	        return OpenedDate ;
	    }
	    
	    public WebElement ComplaintSummary() {
	        return ComplaintSummary ;
	    }
	    
	    public WebElement Upheld() {
	        return Upheld ;
	    }
	    
	    public WebElement Notupheld() {
	        return Notupheld ;
	    }
	    
	    public WebElement Outcome() {
	        return Outcome ;
	    }
	    
	    public WebElement SelectAnOption1() {
	        return SelectAnOption1 ;
	    }
	    
	    public WebElement SelectAnOption2() {
	        return SelectAnOption2 ;
	    }
	    
	    public WebElement Status() {
	        return Status ;
	    }
	    
	    public WebElement MICat() {
	        return MICat ;
	    }
	    
	    public WebElement MIOpt() {
	        return MIOpt ;
	    }
	    
	    public WebElement SaveComplaint() {
	        return SaveComplaint ;
	    }
	    
	    public WebElement AddNote() {
	        return AddNote ;
	    }
	    
	    

}
