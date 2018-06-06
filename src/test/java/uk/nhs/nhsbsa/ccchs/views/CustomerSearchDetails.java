package uk.nhs.nhsbsa.ccchs.views;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerSearchDetails {
	
	 	@FindBy(id = "firstName")
	 	public WebElement Name;
	    
	    @FindBy(id = "lastName")
	    public WebElement Surname;
	    
	    @FindBy(id = "postCode")
	    public WebElement Postcode;
	    
	    @FindBy(id = "search")
	    public WebElement SearchBtn;
	    
	    @FindBy(name = "complaintId")
	    public WebElement SearchTextBox;
	    
	    @FindBy(className = "link-back")
	    public WebElement Back;
	     
	 	@FindBy(id = "CreateNewCustomer")
	 	public WebElement CreateNewCustomer;
	    
	 	/* first element for the cust ref*/
	 	@FindBy(xpath = "//*[@id='submitpage']/div/table/tbody/tr[1]/td[1]/a")
	 	public WebElement custref;
	    
	    
	    
	    public WebElement custref() {
	        return custref ;
	    }
	    
	    public WebElement Name() {
	        return Name ;
	    }
	    
	    public WebElement Surname() {
	    	
	    	
	    	
	        return Surname ;
	    }
	    
	    public WebElement Postcode() {
	        return Postcode ;
	    }
	    
	    public WebElement SearchBtn() {
	        return SearchBtn ;
	    }
	    
	    public WebElement SearchTextBox() {
	        return SearchTextBox ;
	    }
	    
	    public WebElement Back() {
	        return Back ;
	    }
	    
	    public WebElement CreateNewCustomer() {
	        return CreateNewCustomer ;
	    }
	    

	    

}
