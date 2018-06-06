package uk.nhs.nhsbsa.ccchs.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewUserDetails {
	
	 	@FindBy(xpath = ".//*[@id='content']/form/div[2]/h1")
	 	public WebElement Heading;
	    
	    @FindBy(id = "username")
	    public WebElement Username;
	    
	    @FindBy(id = "password")
	    public WebElement Password;
	    
	    @FindBy(id = "u_email")
	    public WebElement EmailAddress;
	    
	    @FindBy(id = "roleAdmin")
	    public WebElement UserRole_Administrator;
	    
	    @FindBy(id = "roleSuper")
	    public WebElement  UserRole_SuperUser;
	     
	    @FindBy(id = "roleStandard")
	    public WebElement  UserRole_Standard;
	    
	    @FindBy(id = "roleManager")
	    public WebElement  UserRole_Manager;
	    
	    @FindBy(id = "enabledtrue")
	    public WebElement AccountEnabled_True;
	     
	    @FindBy(id = "enabledfalse")
	    public WebElement AccountEnabled_False;
	    
	    @FindBy(className = "button")
	    public WebElement SaveUserButton;
	    
	    @FindBy(id = "search")
	    public WebElement SearchButton;
	    
	    
	    
	    public WebElement Heading() {
	        return Heading;
	    }
	    
	    public WebElement Username() {
	        return Username;
	    }
	    
	    public WebElement Password() {
	        return Password;
	    }
	    
	    public WebElement EmailAddress() {
	        return EmailAddress ;
	    }
	    
	    public WebElement UserRole_Administrator() {
	        return UserRole_Administrator ;
	    }
	    
	    public WebElement UserRole_SuperUser() {
	        return UserRole_SuperUser ;
	    }
	    
	    public WebElement UserRole_Standard() {
	        return UserRole_Standard ;
	    }
	    
	    public WebElement UserRole_Manager() {
	        return UserRole_Manager ;
	    }
	    
	    public WebElement AccountEnabled_True() {
	        return AccountEnabled_True ;
	    }
	    
	    public WebElement AccountEnabled_False() {
	        return AccountEnabled_False ;
	    }
	    
	    public WebElement SaveUserButton() {
	        return SaveUserButton ;
	    }
	    
	    public WebElement SearchButton() {
	        return SearchButton ;
	    }

	    
}
