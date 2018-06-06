package uk.nhs.nhsbsa.ccchs.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	 	@FindBy(className = "heading-medium")
	 	public WebElement Heading;
	    
	    @FindBy(id = "username")
	    public WebElement Id;
	    
	    @FindBy(id = "password")
	    public WebElement Pwd;
	    
	    @FindBy(xpath = "html/body/div/div/p/a")
	    public WebElement ForgottenPassword;
	    
	    @FindBy(id = "login")
	    public WebElement Signin;
	     
	    
	    
	    public WebElement Heading() {
	        return Heading ;
	    }
	    
	    public WebElement Id() {
	        return Id ;
	    }
	    
	    public WebElement Pwd() {
	        return Pwd ;
	    }
	    
	    public WebElement ForgottenPassword() {
	        return ForgottenPassword ;
	    }
	    
	    public WebElement Signin() {
	        return Signin ;
	    }

}
