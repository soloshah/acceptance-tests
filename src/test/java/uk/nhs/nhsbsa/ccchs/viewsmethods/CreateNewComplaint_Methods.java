package uk.nhs.nhsbsa.ccchs.viewsmethods;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import uk.nhs.nhsbsa.ccchs.config.env.BaseTest;
import uk.nhs.nhsbsa.ccchs.model.CreateNewComplaint;
import uk.nhs.nhsbsa.ccchs.views.CreateNewComplaintDetails;


public class CreateNewComplaint_Methods implements BaseTest {
	
	CreateNewComplaintDetails createNewComplaintDetails = PageFactory.initElements(driver, CreateNewComplaintDetails.class);

	
    public void PopulateNewComplaint(CreateNewComplaint createNewComplaint){
        
    	createNewComplaintDetails.Telephone.click();
    	
		new Select (createNewComplaintDetails.Priority()).selectByIndex(1);
		
		createNewComplaintDetails.AssignedBy.sendKeys(createNewComplaint.AssignedBy);
		
		createNewComplaintDetails.AssignedByTeam.sendKeys(createNewComplaint.AssignedByTeam);
		
		createNewComplaintDetails.ComplaintSummary.sendKeys(createNewComplaint.ComplaintSummary);
		
		new Select (createNewComplaintDetails.Outcome()).selectByIndex(1);
		
		new Select (createNewComplaintDetails.SelectAnOption1()).selectByIndex(1);
		
		new Select (createNewComplaintDetails.SelectAnOption2()).selectByIndex(1);
		
		new Select (createNewComplaintDetails.Status()).selectByIndex(1);
    
    }        
	
}
