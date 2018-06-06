package uk.nhs.nhsbsa.ccchs.viewsmethods;

import org.openqa.selenium.support.PageFactory;
import uk.nhs.nhsbsa.ccchs.config.env.BaseTest;
import uk.nhs.nhsbsa.ccchs.model.CreateNewUser;
import uk.nhs.nhsbsa.ccchs.views.CreateNewUserDetails;



public class CreateNewUser_Methods implements BaseTest {
	
	CreateNewUserDetails createNewUserDetails = PageFactory.initElements(driver, CreateNewUserDetails.class);

	
    public void PopulateCustomerDetails_Administrator (CreateNewUser createNewUser){
            	
    	createNewUserDetails.Username.sendKeys(createNewUser.Username);
    
    	createNewUserDetails.Password.sendKeys(createNewUser.Password);
    
    	createNewUserDetails.EmailAddress.sendKeys(createNewUser.EmailAddress);
    	
    	createNewUserDetails.UserRole_Administrator.click();
    	
    	createNewUserDetails.AccountEnabled_True.click();
    
    }
    
    
    public void PopulateCustomerDetails_SuperUser (CreateNewUser createNewUser){
    	
    	createNewUserDetails.Username.sendKeys(createNewUser.Username);
    
    	createNewUserDetails.Password.sendKeys(createNewUser.Password);
    
    	createNewUserDetails.EmailAddress.sendKeys(createNewUser.EmailAddress);
    	
    	createNewUserDetails.UserRole_SuperUser.click();
    	
    	createNewUserDetails.AccountEnabled_True.click();
    
    }
    
    
    public void PopulateCustomerDetails_Standard (CreateNewUser createNewUser){
    	
    	createNewUserDetails.Username.sendKeys(createNewUser.Username);
    
    	createNewUserDetails.Password.sendKeys(createNewUser.Password);
    
    	createNewUserDetails.EmailAddress.sendKeys(createNewUser.EmailAddress);
    	
    	createNewUserDetails.UserRole_Standard.click();
    	
    	createNewUserDetails.AccountEnabled_True.click();
    
    }
    
    public void PopulateCustomerDetails_Manager (CreateNewUser createNewUser){
    	
    	createNewUserDetails.Username.sendKeys(createNewUser.Username);
    
    	createNewUserDetails.Password.sendKeys(createNewUser.Password);
    
    	createNewUserDetails.EmailAddress.sendKeys(createNewUser.EmailAddress);
    	
    	createNewUserDetails.UserRole_Manager.click();
    	
    	createNewUserDetails.AccountEnabled_True.click();
    
    }
    
    
    
    public void PopulateEmailAddress (String emailAddr){
    
    	createNewUserDetails.EmailAddress.clear();
    	createNewUserDetails.EmailAddress.sendKeys(emailAddr);

    }
    
    
    public void PopulatePassword (String pwd){
        
    	createNewUserDetails.Password.clear();
    	createNewUserDetails.Password.sendKeys(pwd);

    }
     
    
    public void PopulateUsername (String usr){
        
    	createNewUserDetails.Username.clear();
    	createNewUserDetails.Username.sendKeys(usr);

    }
    
    
    public void DisableUsername (){
        
        	createNewUserDetails.AccountEnabled_False.click();

    }
    
    
    public void EnableUsername (){
        
    	createNewUserDetails.AccountEnabled_True.click();

}
	
}
