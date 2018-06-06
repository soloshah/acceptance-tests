package uk.nhs.nhsbsa.ccchs.viewsmethods;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import uk.nhs.nhsbsa.ccchs.config.env.BaseTest;
import uk.nhs.nhsbsa.ccchs.model.EditExistingCustomer;
import uk.nhs.nhsbsa.ccchs.views.EditExistingCustomerDetails;


public class EditExistingCustomer_Methods implements BaseTest {
	
	EditExistingCustomerDetails editExistingCustomerDetails = PageFactory.initElements(driver, EditExistingCustomerDetails.class);

	
    public void PopulateCustomerDetails(EditExistingCustomer editExistingCustomer){
        
    	new Select (editExistingCustomerDetails.title()).selectByIndex(editExistingCustomer.titlevalue);
    	
    	editExistingCustomerDetails.Name.clear();
    	editExistingCustomerDetails.Name.sendKeys(editExistingCustomer.Name);
    
    	editExistingCustomerDetails.SurName.clear();
    	editExistingCustomerDetails.SurName.sendKeys(editExistingCustomer.Surname);
    
    	editExistingCustomerDetails.DOB.clear();
    	editExistingCustomerDetails.DOB.sendKeys(editExistingCustomer.Dob);
    
    }
    
    
    public void PopulateAddressDetails(EditExistingCustomer editExistingCustomer){
    
    	editExistingCustomerDetails.AddrLine1.clear();
    	editExistingCustomerDetails.AddrLine1.sendKeys(editExistingCustomer.Addr1);
    
    	editExistingCustomerDetails.AddrLine2.clear();
    	editExistingCustomerDetails.AddrLine2.sendKeys(editExistingCustomer.Addr2);
    
    	editExistingCustomerDetails.TownCity.clear();
    	editExistingCustomerDetails.TownCity.sendKeys(editExistingCustomer.TownCity);
    
    	editExistingCustomerDetails.Postcode.clear();
    	editExistingCustomerDetails.Postcode.sendKeys(editExistingCustomer.PostCode);
    	
    }
    
    
    public void PopulateContactDetails(EditExistingCustomer editExistingCustomer){
        
    	editExistingCustomerDetails.homePhone.clear();
    	editExistingCustomerDetails.homePhone.sendKeys(editExistingCustomer.HomePhone);
    
    	editExistingCustomerDetails.mobilePhone.clear();
    	editExistingCustomerDetails.mobilePhone.sendKeys(editExistingCustomer.MobilePhone);
    
    	editExistingCustomerDetails.email.clear();
    	editExistingCustomerDetails.email.sendKeys(editExistingCustomer.Email);
    	
    }
        
	
}
