package uk.nhs.nhsbsa.ccchs.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomerDetails {
	
		@FindBy(name = "title")
	 	public WebElement title;
	
	 	@FindBy(id = "titlemr")
	 	public WebElement titleMr;
	    
	    @FindBy(id = "titlemrs")
	    public WebElement titleMrs;
	    
	    @FindBy(id = "titlemiss")
	    public WebElement titleMiss;
	    
	    @FindBy(id = "titlems")
	    public WebElement titleMs;
	    
	    @FindBy(id = "titleother")
	    public WebElement OtherTitle;
	    
	    @FindBy(id = "titledr")
	    public WebElement titleDr;
	    
	    @FindBy(id = "titlerev")
	    public WebElement titleRev;
	    
	    @FindBy(id = "titlesir")
	    public WebElement titleSir;
	    
	    @FindBy(id = "titlesist")
	    public WebElement titleSist;
	    
	    @FindBy(id = "c_name")
	    public WebElement Name;
	    
	    @FindBy(id = "c_surname")
	    public WebElement SurName;
	    
	    @FindBy(id = "dob")
	    public WebElement DOB;
	    
	    @FindBy(id = "c_address1")
	    public WebElement AddrLine1;
	    
	    @FindBy(id = "c_address2")
	    public WebElement AddrLine2;
	   
	    @FindBy(id = "c_county")
	    public WebElement TownCity;
	    
	    @FindBy(id = "c_postcode")
	    public WebElement Postcode;

	    @FindBy(id = "homephone")
	    public WebElement homePhone;
	    
	    @FindBy(id = "mobilephone")
	    public WebElement mobilePhone;
	    
	    @FindBy(id = "emailaddress")
	    public WebElement email;
	    
	    @FindBy(linkText = "Dashboard")
	    public WebElement backDash;
	    
	    @FindBy(id = "savecustomer")
	    public WebElement saveNewCustomer;
	    
	    

	    
	    public WebElement backDash() {
	        return backDash ;
	    }
	    
	    public WebElement saveNewCustomer() {
	        return saveNewCustomer ;
	    }
	    
	    public WebElement title() {
	        return title ;
	    }
	    
	    public WebElement titleMr() {
	        return titleMr ;
	    }
	    
	    public WebElement titleMrs() {
	        return titleMrs ;
	    }
	    
	    public WebElement titleMs() {
	        return titleMs ;
	    }
	    
	    public WebElement titleMiss() {
	        return titleMiss ;
	    }
	    
	    public WebElement OtherTitle() {
	        return OtherTitle ;
	    }
	    
	    public WebElement titleDr() {
	        return titleDr ;
	    }
	    
	    public WebElement titleRev() {
	        return titleRev ;
	    }
	    
	    public WebElement titleSist() {
	        return titleSist ;
	    }
	    
	    public WebElement titleSir() {
	        return titleSir ;
	    }
	    
	    public WebElement Name() {
	        return Name ;
	    }
	    
	    public WebElement SurName() {
	        return SurName ;
	    }
	    
	    public WebElement DOB() {
	        return DOB ;
	    }
	    
	    public WebElement AddrLine1() {
	        return AddrLine1 ;
	    }
	    
	    public WebElement AddrLine2() {
	        return AddrLine2 ;
	    }
	    
	    public WebElement TownCity() {
	        return TownCity ;
	    }
	    
	    public WebElement Postcode() {
	        return Postcode ;
	    }
	    
	    public WebElement homePhone() {
	        return homePhone ;
	    }
	    
	    public WebElement mobilePhone() {
	        return mobilePhone ;
	    }
	    
	    public WebElement email() {
	        return email ;
	    }


}
