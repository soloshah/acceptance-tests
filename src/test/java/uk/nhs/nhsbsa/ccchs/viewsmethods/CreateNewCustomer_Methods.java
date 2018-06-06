package uk.nhs.nhsbsa.ccchs.viewsmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import uk.nhs.nhsbsa.ccchs.config.env.BaseTest;
import uk.nhs.nhsbsa.ccchs.model.CreateNewCustomer;
import uk.nhs.nhsbsa.ccchs.views.CreateNewCustomerDetails;


public class CreateNewCustomer_Methods implements BaseTest {
	
	CreateNewCustomerDetails createNewCustomerDetails = PageFactory.initElements(driver, CreateNewCustomerDetails.class);


//    public void SetApplicantTitle(CreateNewCustomer createNewCustomer){
//    
//    if (null != createNewCustomer.Title)switch (createNewCustomer.Title) {
//        case Other:
//            SetOtherTitle(createNewCustomer.OtherTitle);
//            break;
//        case NotSet:
//            //log this
//            break;
//        default:
//            driver.findElement(By.xpath("//input[@title='" + applicant.Title + "']")).click();
//            break;
//    	}
//    }
//    
//    private void SetOtherTitle(String title){
//    
//    driver.findElement(By.xpath("//input[@value='Other']"))
//            .click();
//    
//    driver.findElement(By.xpath("//select[@name='othertitle']/option[text()='" + title + "']"))
//            .click();
//    }
	
    public void PopulateCustomerDetails(CreateNewCustomer createNewCustomer){
        
    	new Select (createNewCustomerDetails.title()).selectByIndex(createNewCustomer.titlevalue);
    	
    	createNewCustomerDetails.Name.clear();
    	createNewCustomerDetails.Name.sendKeys(createNewCustomer.Name);
    
    	createNewCustomerDetails.SurName.clear();
    	createNewCustomerDetails.SurName.sendKeys(createNewCustomer.Surname);
    
    	createNewCustomerDetails.DOB.clear();
    	createNewCustomerDetails.DOB.sendKeys(createNewCustomer.Dob);
    
    }
    
    
    public void PopulateAddressDetails(CreateNewCustomer createNewCustomer){
    
    	createNewCustomerDetails.AddrLine1.clear();
    	createNewCustomerDetails.AddrLine1.sendKeys(createNewCustomer.Addr1);
    
    	createNewCustomerDetails.AddrLine2.clear();
    	createNewCustomerDetails.AddrLine2.sendKeys(createNewCustomer.Addr2);
    
    	createNewCustomerDetails.TownCity.clear();
    	createNewCustomerDetails.TownCity.sendKeys(createNewCustomer.TownCity);
    
    	createNewCustomerDetails.Postcode.clear();
    	createNewCustomerDetails.Postcode.sendKeys(createNewCustomer.PostCode);
    	
    }
    
    
    public void PopulateContactDetails(CreateNewCustomer createNewCustomer){
        
    	createNewCustomerDetails.homePhone.clear();
    	createNewCustomerDetails.homePhone.sendKeys(createNewCustomer.HomePhone);

    	createNewCustomerDetails.mobilePhone.clear();
    	createNewCustomerDetails.mobilePhone.sendKeys(createNewCustomer.MobilePhone);
    
    	createNewCustomerDetails.email.clear();
    	createNewCustomerDetails.email.sendKeys(createNewCustomer.Email);
    	
    }
        
	
}
