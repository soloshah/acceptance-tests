package uk.nhs.nhsbsa.ccchs.steps;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.nhs.nhsbsa.ccchs.config.env.BaseTest;
import uk.nhs.nhsbsa.ccchs.config.env.Browser;
import uk.nhs.nhsbsa.ccchs.config.env.Env;
import uk.nhs.nhsbsa.ccchs.config.env.EnvConfig;
import uk.nhs.nhsbsa.ccchs.config.env.TestUtils;
//import uk.nhs.nhsbsa.ccchs.helper.TelesalesDataHelper;
import uk.nhs.nhsbsa.ccchs.helpers.GenericData;
import uk.nhs.nhsbsa.ccchs.helpers.PostgreSQLExample;
import uk.nhs.nhsbsa.ccchs.utils.Utilities;
import uk.nhs.nhsbsa.ccchs.views.CreateNewCustomerDetails;
import uk.nhs.nhsbsa.ccchs.views.CreateNewUserDetails;
import uk.nhs.nhsbsa.ccchs.views.CustomerSearchDetails;
import uk.nhs.nhsbsa.ccchs.views.EditExistingCustomerDetails;
import uk.nhs.nhsbsa.ccchs.views.CreateNewComplaintDetails;

//import uk.nhs.nhsbsa.ccchs.pages.MainPage;
//import uk.nhs.nhsbsa.ccchs.views.PagePaymentCardDetails;
//import uk.nhs.nhsbsa.ccchs.views.PageSearchDetails;
import java.util.NoSuchElementException;

public class MainPageSteps implements BaseTest
{
	private static final Exception NoSuchElementException = null;

	public Robot robot;
	
	EditExistingCustomerDetails editExistingCustomerDetails = PageFactory.initElements(driver, EditExistingCustomerDetails.class);
	CreateNewComplaintDetails newComplaint = PageFactory.initElements(driver, CreateNewComplaintDetails.class);
	CustomerSearchDetails customerSearchDetails = PageFactory.initElements(driver, CustomerSearchDetails.class);
	CreateNewCustomerDetails createNewCustomerDetails = PageFactory.initElements(driver, CreateNewCustomerDetails.class);
	CreateNewUserDetails createNewUserDetails = PageFactory.initElements(driver, CreateNewUserDetails.class);


	/* heruko */
    public static String homeSlaURL = "http://cemsman.herokuapp.com//home?sla";
    public static String viewComplaintPageURL = "http://cemsman.herokuapp.com/viewComplaint";
    public static String editComplaintPageURL = "http://cemsman.herokuapp.com/editComplaint";
    public static String homeURL = "http://cemsman.herokuapp.com/";
    public static String logoutPageURL = "http://cemsman.herokuapp.com/login?logout";
    public static String viewCustomerPageURL = "http://cemsman.herokuapp.com/viewCustomer";
    

    /* ci pipeline */
    public static String homeSlaURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/home?sla";
    public static String viewComplaintPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/viewComplaint";
    public static String editComplaintPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/editComplaint";
    public static String homeURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/";
    public static String logoutPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/login?logout";
    public static String viewCustomerPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/viewCustomer";

    uk.nhs.nhsbsa.ccchs.config.env.TestBase TestBase;
    
	private PredefinedStepDefinitions predefinedSteps = new PredefinedStepDefinitions();
	
	Utilities utilities = new Utilities();
	
	PostgreSQLExample postgreSQLExample = new PostgreSQLExample();
	
	@Given("^I check db connection by clearing Notes and Complaints$")
    public void checkdbconnection() {
    	
		postgreSQLExample.CheckConnection();
	  	
    }
	
	
	public void TestRobotKeys() throws AWTException {
		
		robot = new Robot();
		
		robot.setAutoDelay(250);
		
		robot.keyPress('s');
		robot.keyPress('h');
		robot.keyPress('a');
		robot.keyPress('h');
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress('p');
		robot.keyPress('w');
		robot.keyPress('d');
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		

	}
	
	
    @Given("^I open the login page$")
    public void openHomepage() throws InterruptedException {
    	
    	String run_env = EnvConfig.getTestEnvironment();
	  	System.out.println("run env: " + run_env);
	  	
	  	switch (run_env){ 
	  	 case "localhost":
	    	 driver.get(GenericData.HOMEPAGE_LINK_LOCALHOST);
	        break;
	     case "sys":
	    	 driver.get(GenericData.HOMEPAGE_LINK_SYS);
	        break;
	    case "heruko":
	    	driver.get(GenericData.HOMEPAGE_LINK_HERUKO);
 	        break;
	    case "ci":
	    	 driver.get(GenericData.HOMEPAGE_LINK_CI);
	    	 System.out.println(driver.getCurrentUrl());
	        break;
	     default: System.out.println("Cannot open home page. Check Env...");
	    }
	  	
    }
    
    @Given("^I get err msg$")
    public void geterrmsg() {
    	
    	String browser = EnvConfig.getBrowser();
    	
    	switch (browser){ 
    	
	     case "chrome":
	     case "chrome_linux":
	    	 JavascriptExecutor js1 = (JavascriptExecutor) driver;
	     	
	     	WebElement field1 = driver.findElement(By.id("c_name"));
	     	
	     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
	     	String message1 = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
	     	
	     	System.out.println("geterrmsg chrome........... " + message1);
	        break;
	    case "firefox":
	    	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    	
	    	WebElement field2 = driver.findElement(By.id("c_name"));
	    	
	    	Boolean is_valid2 = (Boolean)js2.executeScript("return arguments[0].checkValidity();", field2);
	    	String message2 = (String)js2.executeScript("return arguments[0].validationMessage;", field2);
	    	
	    	System.out.println("geterrmsg firefox........... " + message2);
	        break;
	        
	     default: System.out.println("unknown button...");
	    }
    	
    }
    
    
    @Given("^I enter \"(.*)\" and \"(.*)\"$")
    public void enterusernamepassword(String username, String pwd) {
    	
    	driver.findElement(By.id("username")).sendKeys(username);
    	
    	driver.findElement(By.id("password")).sendKeys(pwd);
    	
    }
    
    
    @Given("^I enter '(.+)' and '(.+)'$")
    public void enterusernamepwd(String username, String pwd) {
    	
    	driver.findElement(By.id("username")).sendKeys(username);
    	
    	driver.findElement(By.id("password")).sendKeys(pwd);
    	
    }
    
    @Given("^I click the button \"(.*)\"$")
    public void clickButton(String btnName) throws InterruptedException {
    	
    	try {
    		
    		switch (btnName){ 
     	     case "signin":
     	    	driver.findElement(By.id("signin")).click();
     	        break;
     	     case "logout":
     	    	driver.findElement(By.id("logoutLink")).click();
     	        break;
     	    case "Search":
     	    	WebElement element5 = driver.findElement(By.id("search"));
      	    	 JavascriptExecutor executor5 = (JavascriptExecutor)driver;
      	    	 executor5.executeScript("arguments[0].click()", element5);
     	        break;
     	    case "Create New Customer":
     	    	WebElement element0 = driver.findElement(By.id("CreateNewCustomer"));
   	    	 JavascriptExecutor executor0 = (JavascriptExecutor)driver;
   	    	 executor0.executeScript("arguments[0].click()", element0);
     	        break;
     	    case "SaveCustomer":
     	    	 WebElement element1 = driver.findElement(By.id("savecustomer"));
    	    	 JavascriptExecutor executor1 = (JavascriptExecutor)driver;
    	    	 executor1.executeScript("arguments[0].click()", element1);
     	        break;
     	    case "saveNewCustomer":
     	    	WebElement element2 = driver.findElement(By.id("savecustomer"));
   	    	 JavascriptExecutor executor2 = (JavascriptExecutor)driver;
   	    	 executor2.executeScript("arguments[0].click()", element2);
     	        break;
    	     case "NewComplaint":    	    	 
    	    	 WebElement element = driver.findElement(By.id("NewComplaint"));
    	    	 JavascriptExecutor executor = (JavascriptExecutor)driver;
    	    	 executor.executeScript("arguments[0].click()", element);
    	        break;
    	     case "Add New User":
    	    	 driver.findElement(By.cssSelector("a[href*='/userform']")).click();
    	        break;
    	     case "Save User":
    	    	 WebElement element4 = driver.findElement(By.className("button"));
    	    	 JavascriptExecutor executor4 = (JavascriptExecutor)driver;
    	    	 executor4.executeScript("arguments[0].click()", element4);
    	        break;
    	     case "SaveComplaint":
    	    	 WebElement element3 = driver.findElement(By.id("SaveComplaint"));
       	    	 JavascriptExecutor executor3 = (JavascriptExecutor)driver;
       	    	 executor3.executeScript("arguments[0].click()", element3);
    	        break;
     	     default: System.out.println("unknown button...");
     	    }
    
    		
        Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
    }
    
    
    
//    @Given("^I get date$")
//	public static void CurrentDate() {
//
////    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////    	Calendar c = Calendar.getInstance();
////    	c.setTime(new Date()); // Now use today date.
////    	c.add(Calendar.DATE, -7); // Adding 5 days
////    	String output = sdf.format(c.getTime());
////    	System.out.println(output);
//    	
//    	
//    	
//    	Date date=new Date();
//        Calendar calendar = Calendar.getInstance();
//        date=calendar.getTime(); 
//        SimpleDateFormat s;
//        s=new SimpleDateFormat("dd/MM/yyyy");
//
//        System.out.println(s.format(date));
//
//        int days = 5;
//        for(int i=0;i<days;)
//        {
//            calendar.add(Calendar.DAY_OF_MONTH, 1);
//            //here even sat and sun are added
//            //but at the end it goes to the correct week day.
//            //because i is only increased if it is week day
//            if(calendar.get(Calendar.DAY_OF_WEEK)<=5)
//            {
//                i++;
//            }
//
//        }
//        date=calendar.getTime(); 
//        s=new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println(s.format(date));
//		
//	}
    
    @Given("^I get date$")
    public void add() throws ParseException {
    	
//    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//    	Date date = new Date();
//        System.out.println("Today's Date...." + df.format(date));
//    	
//    	String sourceDate = df.format(date);
//    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//    	Date myDate = format.parse(sourceDate);
//    	myDate = utilities.addDays(myDate, -8);
//    	
//    	
//    	String tomorrow = (String)(format.format(myDate.getTime()));
//        System.out.println("date after n days is " + tomorrow);
//    	
//    	utilities.demo();
    	
        
//        
//        try {   
////        	  DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        	  date = (Date)df.parse(date.toString()); 
//        	  cal=Calendar.getInstance();
//        	  cal.setTime(date);
//        	  }
//        	  catch (ParseException e)
//        	  {
//        	      System.out.println("Exception :"+e);  
//        	  }  
        
        
         // Working code
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	Date date = new Date();
        System.out.println("Today's Date...." + df.format(date));
    	
        Calendar startdate = null;
        
        startdate = utilities.toCalendar(date);
        Calendar endDate = utilities.addWorkDays(startdate, -8); 
        
        
        //Calendar endDate1 = Utilities.CheckIfDateFallsOnBankHoliday(endDate);
        //System.out.println("BH day adjusted " + df.format(endDate1.getTime()));
        
        
        Calendar endDate2 = Utilities.TraverseThroughDatesForNonBankHoliday_AMBER(endDate);
        System.out.println("Non BH day adjusted " + df.format(endDate2.getTime()));
        
        
        
//        System.out.println("Start Date called " + df.format(startdate.getTime()));
//        System.out.println("End Date called " + df.format(endDate.getTime()));
//
//        Calendar newendDate = Utilities.CheckBankHolidayDate(startdate,endDate);
//        System.out.println("Returned End Date " + df.format(newendDate.getTime()));
        
        
//	         String DATE_IN_CONSIDERATION = "06/09/2017";
//	         String DATE_IN_CONSIDERATION1 = "28/08/2017";
//	         String DATE_FORMAT = "dd/MM/yyyy";
	      
	      
//	        try {
//	              DateFormat theDateFormat = new SimpleDateFormat(DATE_FORMAT);
//	              Date date = theDateFormat.parse(DATE_IN_CONSIDERATION);
//	              Calendar cal = Calendar.getInstance();
//	              cal.setTime(date);
//	              utilities.findNextWorkingDay(cal,15);
//
//	              System.out.println(theDateFormat.format(cal.getTime()));                
//	              
//	        } 
//	        catch (ParseException ex) {
//	              ex.printStackTrace();
//	        }
	        
	        
	        
//	        DateFormat theDateFormat = new SimpleDateFormat(DATE_FORMAT);
//	        Date date = theDateFormat.parse(DATE_IN_CONSIDERATION);
//	        Date date1 = theDateFormat.parse(DATE_IN_CONSIDERATION1);
//	        
//	        int a = Utilities.getWorkingDaysBetweenTwoDates(date,date1);
//	        
//	        //int b = Utilities.calculateDuration(date,date1);
//	        
//	        System.out.println("No of days a :"+ a);  
//	        //System.out.println("No of days b :"+ b); 
    	
    }
	
    
    
    @Given("^I read first complaint number from home page$")
    public void ReadComplaintHomePage() {
    	
    	String xpathFirstComplaintNum = "//*[@id='submitpage']/div/table/tbody/tr[1]/td[1]/a/span";
    	
     	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		boolean exists = driver.findElements(By.xpath(xpathFirstComplaintNum)).size() != 0;
		System.out.println("exists.... " + exists);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		 if(exists)
		 {
			 String firstComplaintNum = driver.findElement(By.xpath(xpathFirstComplaintNum)).getText();
			 System.out.println("First read complaint number from home page: " + firstComplaintNum); 	 

		 }
		 else
		 {
			String urlActual = null;
			urlActual = driver.getCurrentUrl();
			System.out.println("CEMS Ref is InVisible");
			
		 }
			
		 
    }
    
    
    
    @Given("^I search not created complaint number from home page$")
    public void SearchNotCreatedComplaintHomePage() {
    	
    	String msg = "No such complaint";
    	
    	customerSearchDetails.SearchTextBox.sendKeys("9999");
		customerSearchDetails.SearchTextBox.sendKeys(Keys.ENTER);
		 
    	String err_msg = customerSearchDetails.SearchTextBox.getAttribute("placeholder");
    	System.out.println("err_msg..... " + err_msg);
    	assertEquals("Failed to show No such complaint", msg, err_msg);
			
    	
    }
    
    
    
	
  	@Then("^I search not created complaint number and get error message as '(.+)' with '(.+)'$")
	public void SearchNotCreatedComplaintErrorMessage(String text, String expected_error_Message) throws InterruptedException
	{
  		String actual_error_message = null;
    	
    	customerSearchDetails.SearchTextBox.sendKeys(text);
		customerSearchDetails.SearchTextBox.sendKeys(Keys.ENTER);
		TestUtils.sleep(2000);
		 
		actual_error_message = customerSearchDetails.SearchTextBox.getAttribute("placeholder");
    	System.out.println("err_msg..... " + actual_error_message);
    	assertEquals("Failed to show No such complaint error message:", expected_error_Message, actual_error_message);

	}
  	
  	
  	
  	
    
    @Given("^I search already created complaint number from home page$")
    public void SearchAlreadyCreatedComplaintHomePage() {
    	
    	String xpathFirstComplaintNum = "//*[@id='submitpage']/div/table/tbody/tr[1]/td[1]/a/span";
    	
     	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		boolean exists = driver.findElements(By.xpath(xpathFirstComplaintNum)).size() != 0;
		System.out.println("exists.... " + exists);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		 if(exists)
		 {
			 String firstComplaintNum = driver.findElement(By.xpath(xpathFirstComplaintNum)).getText();
			 System.out.println("First read complaint number from home page: " + firstComplaintNum); 	 

			 customerSearchDetails.SearchTextBox.sendKeys(firstComplaintNum);
			 customerSearchDetails.SearchTextBox.sendKeys(Keys.ENTER);
			 
			 String urlActual = driver.getCurrentUrl();
  			
  			if (EnvConfig.getTestEnvironment() == "heruko"){
  				
  				assertTrue("Failed to show edit existing customer page", urlActual.contains(viewComplaintPageURL));
  				
  			}
  			if (EnvConfig.getTestEnvironment() == "ci") {
  				
  				assertTrue("Failed to show edit existing customer page", urlActual.contains(viewComplaintPageURL_ci));
  				
  			}
  			
  			/* Click dashboard */
  			WebElement element1 = driver.findElement(By.cssSelector("a[href*='/home']"));
  			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
  			executor1.executeScript("arguments[0].click()", element1);
		 
		 }
		 else
		 {
			String urlActual = null;
			urlActual = driver.getCurrentUrl();
			System.out.println("CEMS Ref is InVisible");
			
			/* Click dashboard tab */
  			WebElement element1 = driver.findElement(By.id("dashboardTab"));
  			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
  			executor1.executeScript("arguments[0].click()", element1);
		 
		 }

    }
    
    
    
    @Given("^I click the tab \"(.*)\"$")
    public void clickTab(String tabName) {
    	
    	try {
    		
    		switch (tabName){ 
     	    case "dashboard":
     	    	 driver.findElement(By.className("dropbtn")).click();
      	        break;
     	   case "search":
     		  driver.findElement(By.cssSelector("a[href*='search']")).click(); 
    	        break;
     	  case "User Management":
     		  driver.findElement(By.id("userManagement")).click();
    	        break;
     	 case "Case Management":
    		  driver.findElement(By.id("caseManagement")).click();
   	        break;
     	  case "Active Cases":
     		  driver.findElement(By.cssSelector("a[href*='activecase']")).click();
    	        break;
     	  case "Resolved Cases":
     		  driver.findElement(By.cssSelector("a[href*='resolvedcase']")).click();
    	        break;
     	  case "Red Cases":
     		  driver.findElement(By.cssSelector("a[href*='/home?sla=1']")).click();
    	        break;
     	  case "Amber Cases":
     		  driver.findElement(By.cssSelector("a[href*='/home?sla=2']")).click();
    	        break;
     	  case "Green Cases":
     		  driver.findElement(By.cssSelector("a[href*='/home?sla=3']")).click();
    	        break;
     	     default: System.out.println("unknown tab...");
     	    }
    		
    		
        Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
    
    }
    
    
    
    @Given("^I input special characters$")
    public void spchar() {
    	
    	String browser = EnvConfig.getBrowser();
    	
    	switch (browser){ 
    	
	     case "chrome":
	     case "chrome_linux":
	    	 JavascriptExecutor js1 = (JavascriptExecutor) driver;
	     	
	     	WebElement field1 = driver.findElement(By.id("c_name"));
	     	
	     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
	     	String message1 = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
	     	
	     	System.out.println("geterrmsg chrome........... " + message1);
	        break;
	    case "firefox":
	    	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    	
	    	WebElement field2 = driver.findElement(By.id("c_name"));
	    	
	    	Boolean is_valid2 = (Boolean)js2.executeScript("return arguments[0].checkValidity();", field2);
	    	String message2 = (String)js2.executeScript("return arguments[0].validationMessage;", field2);
	    	
	    	System.out.println("geterrmsg firefox........... " + message2);
	        break;
	        
	     default: System.out.println("unknown button...");
	    }
    	
    }
    
    
    @Given("^I click search result '(.+)'$")
    public void clickSearchResult(String num) throws InterruptedException {

    	String href = "a[href*='/viewCustomer?personId=" + num + "&person_id=" + num +  "']";
    	
    	try {
    		
    		driver.findElement(By.cssSelector(href)).click();
    		
        Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
    
    }
    
    

    @Given("^I click edit customer '(.+)'$")
    public void clickEditCustomer(String num) throws InterruptedException {

    	String href = "a[href*='/editCustomer?personId=" + num + "']";
    	
    	try {
    		
    		driver.findElement(By.cssSelector(href)).click();
    		
        Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
    }
    
    
    
    @Given("^I click complaint history to amend '(.+)'$")
    public void clickEditComplaintHistory(String num) throws InterruptedException {

    	String href = "a[href*='/editComplaint?complaint_id=" + num + "']";
    	
    	try {
    		
    		driver.findElement(By.cssSelector(href)).click();
    		
        Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
    }
    
    
    @Given("^I click existing user to amend '(.+)'$")
    public void clickEditExistingUser(String num) throws InterruptedException {

    	try {
    		
    		driver.findElement(By.linkText(num)).click();
    		
        Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
    }
    
    
    @Given("^I click the link \"(.*)\"$")
    public void clickLink(String linkName) {
    	
    	try {
    		
    		switch (linkName){ 
     	    case "Back":
     	    	 driver.findElement(By.className("link-back")).click();
      	        break;
    	        
     	  case "Dashboard":
     		 WebElement element = driver.findElement(By.cssSelector("a[href*='/home']"));
     		 JavascriptExecutor executor = (JavascriptExecutor) driver;
     		 executor.executeScript("arguments[0].click()", element);
    	        break;
    	        
     	  case "customerReference":
     		 customerSearchDetails.custref.click();
    	        break;
    	        
     	  case "Go To Home Page":
     		 driver.findElement(By.xpath("html/body/a")).click();
    	        break;
    	        
     	  case "active case number":
     		  driver.findElement(By.xpath("//*[@id='submitpage']/div/div/div[3]/table/tbody/tr[2]/td[1]/a")).click();
    	        break; 
    	        
     	  case "resolved case number":
     		  driver.findElement(By.xpath("//*[@id='submitpage']/div/div/div[3]/table/tbody/tr[2]/td[1]/a")).click();
    	        break;
    	        
     	  case "edit complaint":
     		  driver.findElement(By.xpath("//*[@id='content']/div[4]/div/div/div/h1/span[2]/a")).click();
    	        break; 
    	        
     	 case "edit complaint for Complaint History":
    		  driver.findElement(By.xpath("//*[@id='content']/div[6]/table/tbody/tr[2]/td[6]/a")).click();
   	        break; 
    	        
     	 case "edit complaint by user":
    		  driver.findElement(By.xpath("//*[@id='content']/div[6]/table/tbody/tr[2]/td[6]/a")).click();
   	        break;
    	        
     	 case "viewcomplaint":
    		  driver.findElement(By.xpath("//*[@id='content']/div[4]/div/div/div/h1/span[2]/a")).click();
   	        break; 
    	        
     	  case "slacase":
     	  	
     		  	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
     		 	boolean exists = driver.findElements(By.xpath("//*[@id='submitpage']/div/table/tbody/tr[1]/td[1]/a/span")).size() != 0;
      			System.out.println("exists.... " + exists);
      			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 
     		 if(exists)
     		 {
     			String urlActual = null;
     			urlActual = driver.getCurrentUrl();
     			System.out.println("urlActual....." + urlActual);
     			
     			System.out.println("CEMS Ref is Visible");
     			if (EnvConfig.getTestEnvironment() == "heruko"){
     				
     				assertTrue("Failed to show edit existing customer page", urlActual.contains(homeSlaURL));

     			}
     			if (EnvConfig.getTestEnvironment() == "ci") {
     				
     				assertTrue("Failed to show edit existing customer page", urlActual.contains(homeSlaURL_ci));

     			}
     			
     			/* view complaint*/
     			driver.findElement(By.xpath("//*[@id='submitpage']/div/table/tbody/tr[1]/td[1]/a/span")).click();
     			urlActual = driver.getCurrentUrl();
     			
     			if (EnvConfig.getTestEnvironment() == "heruko"){
     				
     				assertTrue("Failed to show edit existing customer page", urlActual.contains(viewComplaintPageURL));
     				
     			}
     			if (EnvConfig.getTestEnvironment() == "ci") {
     				
     				assertTrue("Failed to show edit existing customer page", urlActual.contains(viewComplaintPageURL_ci));
     				
     			}
     			
     			/* edit complaint*/
     			 driver.findElement(By.xpath("//*[@id='content']/div[4]/div/div/div/h1/span[2]/a")).click();
     			urlActual = driver.getCurrentUrl();

     			if (EnvConfig.getTestEnvironment() == "heruko"){
     				
     				assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL));

     			}
     			if (EnvConfig.getTestEnvironment() == "ci") {
     				
     				assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL_ci));

     			}
     			
     			 WebElement element1 = driver.findElement(By.cssSelector("a[href*='/home']"));
         		 JavascriptExecutor executor1 = (JavascriptExecutor) driver;
         		 executor1.executeScript("arguments[0].click()", element1);
         		 
         		urlActual = driver.getCurrentUrl();
         		if (EnvConfig.getTestEnvironment() == "heruko"){
     				
         			assertTrue("Failed to show search page", urlActual.contains(homeURL));
     			}
     			if (EnvConfig.getTestEnvironment() == "ci") {
     				
     				assertTrue("Failed to show search page", urlActual.contains(homeURL_ci));
     			}

         		 
         		driver.findElement(By.id("logoutLink")).click();
         		
         		urlActual = driver.getCurrentUrl();
         		if (EnvConfig.getTestEnvironment() == "heruko"){
     				
         			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
     			}
     			if (EnvConfig.getTestEnvironment() == "ci") {
     				
     				assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
     			}
         			
     			
     		 }
     		 else
     		 {
     			String urlActual = null;
     			urlActual = driver.getCurrentUrl();
     			System.out.println("CEMS Ref is InVisible");
     			
     			//String a = driver.findElement(By.xpath(".//*[@id='content']/span[2]")).getText();
     			
     			driver.findElement(By.id("logoutLink")).click();
     			
     			urlActual = driver.getCurrentUrl();
     			if (EnvConfig.getTestEnvironment() == "heruko"){
     				
         			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
     			}
     			if (EnvConfig.getTestEnvironment() == "ci") {
     				
     				assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
     			}
     			
     		 }
     			
    	        break;
    	        
     	 case "editCustomer":
     		driver.findElement(By.xpath("//*[@id='content']/div[3]/a")).click();
    	        break;
    	        
    	  case "cemsReference":
    	    	WebElement element1 = driver.findElement(By.xpath("//*[@id='content']/div[6]/table/tbody/tr[2]/td[1]/a/span"));
        		 JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        		 executor1.executeScript("arguments[0].click()", element1);
    	    	break;
    	    	
    	  case "edit complaint number":
  	    	driver.findElement(By.xpath("//*[@id='content']/div[1]/h1/a/span")).click();
  	    	break;
    	    	
    	  case "editComplaint":
       		driver.findElement(By.xpath("//*[@id='content']/div[5]/div/table[1]/tbody/tr/th/span/a")).click();
      	        break; 
    	        
    	  case "complaintNumber":
      	      driver.findElement(By.xpath(".//*[@id='content']/div[1]/h1/a/span")).click();
        	        break;
        	        
       /* TESTA user edit link*/     
    	  case "edit TESTA user": 
      	      driver.findElement(By.cssSelector("a[href*='/editUser?userId=5']")).click();
        	        break;
        	        
      /* TESTE user edit link*/     
    	  case "edit TESTE user": 
      	      driver.findElement(By.cssSelector("a[href*='/editUser?userId=5']")).click();
        	        break;

     	     default: System.out.println("unknown button...");
     	    }
    		
        Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
    }
    
    
    
    
    
    @Then("^I check for sla case and edit complaint number with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
    public void SLAeditComplaintNumber(String type, int priority, String ref, String assignedBy, String assignedByTeam, String summary, String upheld, int status, int MIcat, int MIOpt) {
    		  	
	  	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	 	boolean exists = driver.findElements(By.xpath("//*[@id='submitpage']/div/table/tbody/tr[1]/td[1]/a/span")).size() != 0;
		System.out.println("1st cems ref exists.... " + exists);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	 if(exists)
	 {
		String urlActual = null;
		urlActual = driver.getCurrentUrl();
		System.out.println("urlActual....." + urlActual);
		
		System.out.println("1st CEMS Ref is Visible");
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show sla case page", urlActual.contains("http://cemsman.herokuapp.com/home?sla"));
		
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show sla case page", urlActual.contains("https://tst.services.nhsbsa.nhs.uk/compman/home?sla"));
			
		}
		/* click on cems ref */
		driver.findElement(By.xpath("//*[@id='submitpage']/div/table/tbody/tr[1]/td[1]/a/span")).click();
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show view complaint customer page", urlActual.contains("viewComplaintPageURL"));
		
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show view complaint customer page", urlActual.contains(viewComplaintPageURL_ci));
			
		}
		
		/* click on edit complaint */
		 driver.findElement(By.xpath("//*[@id='content']/div[4]/div/div/div/h1/span[2]/a")).click();
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL));
			
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL_ci));
			
		}

		PopulateComplaint(type, priority, ref, assignedBy, assignedByTeam, summary, upheld, status, MIcat, MIOpt);
		
		WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewComplaintPageURL));
			
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewComplaintPageURL_ci));
			
		}
		
		WebElement element1 = driver.findElement(By.cssSelector("a[href*='/home']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", element1);
		 
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show search page", urlActual.contains(homeURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show search page", urlActual.contains(homeURL_ci));
		}
 
		driver.findElement(By.id("logoutLink")).click();
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		}
		
	 }
	 else
	 {
		String urlActual = null;
		urlActual = driver.getCurrentUrl();
		System.out.println("CEMS Ref is InVisible");
		
		String a = driver.findElement(By.xpath(".//*[@id='content']/span[2]")).getText();
		
		assertEquals("Failed to find Certificate Number", a, "Good job! No issues here.");
		
		driver.findElement(By.xpath(".//*[@id='content']/ul/li[6]/form/a")).click();
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		}
		
	 }
	 
  }
	 

    @Then("^I check for sla case and edit complaint link with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
    public void SLAeditComplaintLink(String type, int priority, String ref, String assignedBy, String assignedByTeam, String summary, String upheld, int status, int MIcat, int MIOpt) {
    		  	
	  	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	 	boolean exists = driver.findElements(By.xpath(".//*[@id='content']/table/tbody/tr[2]/td[1]/a/span")).size() != 0;
		System.out.println("exists.... " + exists);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	 if(exists)
	 {
		String urlActual = null;
		urlActual = driver.getCurrentUrl();
		System.out.println("urlActual....." + urlActual);
		
		System.out.println("CEMS Ref is Visible");
		assertTrue("Failed to show sla case page", urlActual.contains("http://cemsman.herokuapp.com/home?sla"));
		
		/* click on cems ref */
		driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[2]/td[1]/a/span")).click();
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show view complaint customer page", urlActual.contains(viewComplaintPageURL_ci));

		/* click on edit complaint link */
		 driver.findElement(By.xpath("//*[@id='content']/div[5]/div/table[1]/tbody/tr/th/span/a")).click();
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL_ci));
		
		PopulateComplaint(type, priority, ref, assignedBy, assignedByTeam, summary, upheld, status, MIcat, MIOpt);
		
		WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL_ci));
		
		WebElement element1 = driver.findElement(By.cssSelector("a[href*='/home']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", element1);
		 
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show search page", urlActual.contains(homeURL_ci));
 
		driver.findElement(By.xpath(".//*[@id='content']/ul/li[6]/form/a")).click();
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		
	 }
	 else
	 {
		String urlActual = null;
		urlActual = driver.getCurrentUrl();
		System.out.println("CEMS Ref is InVisible");
		
		String a = driver.findElement(By.xpath(".//*[@id='content']/span[2]")).getText();
		
		assertEquals("Failed to find Certificate Number", a, "Good job! No issues here.");
		
		driver.findElement(By.xpath(".//*[@id='content']/ul/li[6]/form/a")).click();
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		
	 }
	 
  }

    
    
    @Then("^I check for active cases and edit complaint number with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
    public void activeCaseseditComplaintNumber(String type, int priority, String ref, String assignedBy, String assignedByTeam, String summary, String upheld, int status, int MIcat, int MIOpt) {
    		  	
	  	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	 	boolean exists = driver.findElements(By.id("dashboardTab")).size() != 0;
		System.out.println("Dashboard Tab Exists....! " + exists);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	 if(exists)
	 {
		String urlActual = null;
				
//		/* click on cems ref */
//		driver.findElement(By.xpath("//*[@id='submitpage']/div/div/div[3]/table/tbody/tr[2]/td[1]/a/span")).click();
//		urlActual = driver.getCurrentUrl(); 
//		if (EnvConfig.getTestEnvironment() == "heruko"){
//			
//			assertTrue("Failed to show view complaint customer page", urlActual.contains(viewComplaintPageURL));
//
//		}
//		if (EnvConfig.getTestEnvironment() == "ci") {
//			
//			assertTrue("Failed to show view complaint customer page", urlActual.contains(viewComplaintPageURL_ci));
//
//		}
//		
//		/* click on edit complaint number */
//		 driver.findElement(By.xpath("//*[@id='content']/div[4]/div/div/div/h1/span[2]/a")).click();
//		urlActual = driver.getCurrentUrl();
//		if (EnvConfig.getTestEnvironment() == "heruko"){
//			
//			assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL));
//			
//		}
//		if (EnvConfig.getTestEnvironment() == "ci") {
//			
//			assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL_ci));
//			
//		}
		
		PopulateComplaint(type, priority, ref, assignedBy, assignedByTeam, summary, upheld, status, MIcat, MIOpt);
		
		WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL));
			
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL_ci));
			
		}
		
		WebElement element1 = driver.findElement(By.cssSelector("a[href*='/home']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", element1);
		 
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show search page", urlActual.contains(homeURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show search page", urlActual.contains(homeURL_ci));
		}
 
		/* click log out */
		driver.findElement(By.id("logoutLink")).click();
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		}
		
		
	 }
	 else
	 {
		String urlActual = null;

		System.out.println("Dashboard Tab does not Exists....!");
		
//		/* click back to dashboard link */
//		driver.findElement(By.className("link-back")).click();
		
		/* click log out */
		driver.findElement(By.xpath("logoutLink")).click();
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		}
		
	 }
	 
  }
    

    
    @Then("^I check dasboard tab for '(.+)' user$")
    public void checkDashoardTabUser(String role) {
    		  	
	  	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	 	boolean exists = driver.findElements(By.id("dashboardTab")).size() != 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		 if(role.equals("admin") && exists)
    	 {
    		 System.out.println("Dashboard tab Exists for Admin role....!");
    			 
    	 } 
    	 else if(role.equals("manager") && exists)
    	 {
    		 System.out.println("Dashboard tab Exists for Manager role....!");
    			 
    	 } 
    	 else if(role.equals("super") && exists)
    	 {
    		 System.out.println("Dashboard tab Exists for Super role....!");
    			 
    	 } 
    	 else if(role.equals("standard") && exists)
    	 {
    		 System.out.println("Dashboard tab Exists for Standard role....!");
    			 
    	 } 
    	 else
    	 {
    		 System.out.println("Dashboard tab....! " + exists);
    		 throw new NoSuchElementException();
    		
    	 }
 
    }
    
    
    @Then("^I check customer search tab for '(.+)' user$")
    public void checkCustomerSearchTabUser(String role) {
    		  	
	  	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	 	boolean exists = driver.findElements(By.id("customerSearch")).size() != 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		 if(role.equals("admin") && exists)
    	 {
    		 System.out.println("Customer Search tab Exists for Admin role....!");
    			 
    	 } 
    	 else if(role.equals("manager") && exists)
    	 {
    		 System.out.println("Customer Search tab Exists for Manager role....!");
    			 
    	 } 
    	 else if(role.equals("super") && exists)
    	 {
    		 System.out.println("Customer Search tab Exists for Super role....!");
    			 
    	 } 
    	 else if(role.equals("standard") && exists)
    	 {
    		 System.out.println("Customer Search tab Exists for Standard role....!");
    			 
    	 } 
    	 else
    	 {
    		 System.out.println("Customer Search tab....! " + exists);
    		 throw new NoSuchElementException();
    		
    	 }
    
    }
    
    
    @Then("^I check case management tab for '(.+)' user$")
    public void checkCaseManagementTabUser(String role) {
    	
    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    	boolean exists = driver.findElements(By.id("caseManagement")).size() != 0;
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	 
    	 if(role.equals("admin") && exists)
    	 {
    		 System.out.println("Case Management tab Exists for Admin role....!");
    			 
    	 } 
    	 else if(role.equals("manager") && exists)
    	 {
    		 System.out.println("Case Management tab Exists for Manager role....!");
    			 
    	 } 
    	 else if(role.equals("super") && exists)
    	 {
    		 System.out.println("Case Management tab Exists for Super role....!");
    			 
    	 } 
    	 else if(role.equals("standard") && exists)
    	 {
    		 System.out.println("Case Management tab Exists for Standard role....!");
    			 
    	 } 
    	 else
    	 {
    		 System.out.println("Case Management tab....! " + exists);
    		 throw new NoSuchElementException();
    		
    	 }
    	 
    }   
    
    
    @Then("^I check user management tab for '(.+)' user$")
    public void checkUserManagementTabUser(String role) {
    	
    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    	boolean exists = driver.findElements(By.id("userManagement")).size() != 0;
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    	 if(role.equals("admin") && exists)
    	 {
    		 System.out.println("User Management tab Exists for Admin role....!");
    			 
    	 } 
    	 else if(role.equals("manager") && exists)
    	 {
    		 System.out.println("User Management tab Exists for Manager role....!");
    			 
    	 } 
    	 else if(role.equals("super") && !exists)
    	 {
    		 System.out.println("User Management tab not Exists for Super role....!");
    			 
    	 } 
    	 else if(role.equals("standard") && !exists)
    	 {
    		 System.out.println("User Management tab not Exists for Standard role....!");
    			 
    	 } 
    	 else
    	 {
    		 System.out.println("User Management tab....! " + exists);
    		 throw new NoSuchElementException();
    		
    	 }
    }  
    
    
    @Then("^I check metrics tab for '(.+)' user$")
    public void checkMetricsTabUser(String role) {
    	
    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    	boolean exists = driver.findElements(By.id("metrics")).size() != 0;
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    	 if(role.equals("admin") && exists)
    	 {
    		 System.out.println("Metrics tab Exists for Admin role....!");
    			 
    	 } 
    	 else if(role.equals("manager") && exists)
    	 {
    		 System.out.println("Metrics tab Exists for Manager role....!");
    			 
    	 } 
    	 else if(role.equals("super") && exists)
    	 {
    		 System.out.println("Metrics tab Exists for Super role....!");
    			 
    	 } 
    	 else if(role.equals("standard") && !exists)
    	 {
    		 System.out.println("Metrics tab not Exists for Standard role....!");
    			 
    	 } 
    	 else
    	 {
    		 System.out.println("Metrics tab....! " + exists);
    		 throw new NoSuchElementException();
    		
    	 }
    	 
    }  
    
    
    @Then("^I check for active cases and edit complaint link with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
    public void activeCaseseditComplaintLink(String type, int priority, String ref, String assignedBy, String assignedByTeam, String summary, String upheld, int status, int MIcat, int MIOpt) {
    		  	
	  	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	 	boolean exists = driver.findElements(By.xpath(".//*[@id='form']/div[2]/table/tbody/tr[3]/td[1]/a/span")).size() != 0;
		System.out.println("CEMS Ref in Active Cases tab Exists....! " + exists);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	 if(exists)
	 {
		String urlActual = null;
				
		/* click on cems ref */
		driver.findElement(By.xpath("//*[@id='form']/div[2]/table/tbody/tr[3]/td[1]/a/span")).click();
		urlActual = driver.getCurrentUrl(); 
		assertTrue("Failed to show view complaint customer page", urlActual.contains(viewComplaintPageURL_ci));

		/* click on complaint link */
		 driver.findElement(By.xpath("//*[@id='content']/div[5]/div/table[1]/tbody/tr/th/span/a")).click();
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL_ci));
		
		PopulateComplaint(type, priority, ref, assignedBy, assignedByTeam, summary, upheld, status, MIcat, MIOpt);
		
		WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL_ci));
		
		WebElement element1 = driver.findElement(By.cssSelector("a[href*='/home']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", element1);
		 
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show search page", urlActual.contains(homeURL_ci));
 
		/* click log out */
		driver.findElement(By.xpath(".//*[@id='content']/ul/li[6]/form/a")).click();
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		
	 }
	 else
	 {
		String urlActual = null;

		System.out.println("CEMS Ref in Active Cases tab does not Exists....!");
		
		/* click back to dashboard link */
		driver.findElement(By.className("link-back")).click();
		
		/* click log out */
		driver.findElement(By.xpath(".//*[@id='content']/ul/li[6]/form/a")).click();
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		
	 }
	 
  }
    
    
    
    @Then("^I check for resolved cases and edit complaint number with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
    public void resolvedCaseseditComplaintNumber(String type, int priority, String ref, String assignedBy, String assignedByTeam, String summary, String upheld, int status, int MIcat, int MIOpt) {
    		  	
	  	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	  	boolean exists = driver.findElements(By.id("dashboardTab")).size() != 0;
		System.out.println("Dashboard Tab Exists....! " + exists);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	 if(exists)
	 {
		String urlActual = null;
				
//		/* click on cems ref */
//		driver.findElement(By.xpath("//*[@id='form']/div[2]/table/tbody/tr[3]/td[1]/a/span")).click();
//		urlActual = driver.getCurrentUrl(); 
//		assertTrue("Failed to show view complaint customer page", urlActual.contains(viewComplaintPageURL_ci));
//
//		/* click on complaint number */
//		 driver.findElement(By.xpath(".//*[@id='content']/div[1]/h1/a/span")).click();
//		urlActual = driver.getCurrentUrl();
//		assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL_ci));
		
		PopulateComplaint(type, priority, ref, assignedBy, assignedByTeam, summary, upheld, status, MIcat, MIOpt);
		
		WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL));
			
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL_ci));
			
		}
		
		WebElement element1 = driver.findElement(By.cssSelector("a[href*='/home']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", element1);
		 
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show search page", urlActual.contains(homeURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show search page", urlActual.contains(homeURL_ci));
		}
 
		/* click log out */
		driver.findElement(By.id("logoutLink")).click();
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		}

		
	 }
	 else
	 {
		String urlActual = null;

		System.out.println("CEMS Ref in Resolved Cases tab does not Exists....!");
		
//		/* click back to dashboard link */
//		driver.findElement(By.className("link-back")).click();
		
		/* click log out */
		driver.findElement(By.id("logoutLink")).click();
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		}
		
	 }
	 
  }
    
    
    
    @Then("^I check for resolved cases and edit complaint link with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
    public void resolvedCaseseditComplaintLink(String type, int priority, String ref, String assignedBy, String assignedByTeam, String summary, String upheld, int status, int MIcat, int MIOpt) throws InterruptedException {
    		  	
    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	  	boolean exists = driver.findElements(By.id("dashboardTab")).size() != 0;
		System.out.println("Dashboard Tab Exists....! " + exists);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	 if(exists)
	 {
		String urlActual = null;
				
		PopulateComplaint(type, priority, ref, assignedBy, assignedByTeam, summary, upheld, status, MIcat, MIOpt);
		
		WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL));
			
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL_ci));
			
		}
		
		TestUtils.sleep(3000);
		
		WebElement element1 = driver.findElement(By.cssSelector("a[href*='/home']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", element1);
		 
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show search page", urlActual.contains(homeURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show search page", urlActual.contains(homeURL_ci));
		}
 
		/* click log out */
		driver.findElement(By.id("logoutLink")).click();
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		}

		
	 }
	 else
	 {
		String urlActual = null;

		System.out.println("CEMS Ref in Resolved Cases tab does not Exists....!");
		
		/* click log out */
		driver.findElement(By.id("logoutLink")).click();
		
		urlActual = driver.getCurrentUrl();
		if (EnvConfig.getTestEnvironment() == "heruko"){
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
		}
		if (EnvConfig.getTestEnvironment() == "ci") {
			
			assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		}
		
	 }
	 
  }
    
    
    
    @Then("^I check for search cases and edit complaint link with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
    public void searchCasesEditComplaintLink(String type, int priority, String ref, String assignedBy, String assignedByTeam, String summary, String upheld, int status, int MIcat, int MIOpt) {
    		  	
	  	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	 	boolean exists = driver.findElements(By.xpath("//*[@id='form']/div[3]/table/tbody/tr[3]/td[1]/a/span")).size() != 0;
		System.out.println("Search CEMS Ref Exists....! " + exists);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	 if(exists)
	 {
		String urlActual = null;
				
		/* click on cems ref */
		driver.findElement(By.xpath("//*[@id='form']/div[3]/table/tbody/tr[3]/td[1]/a/span")).click();
		urlActual = driver.getCurrentUrl(); 
		assertTrue("Failed to show view complaint customer page", urlActual.contains(viewComplaintPageURL_ci));

		/* click on edit complaint link */
		 driver.findElement(By.xpath("//*[@id='content']/div[5]/div/table[1]/tbody/tr/th/span/a")).click();
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL_ci));
		
		PopulateComplaint(type, priority, ref, assignedBy, assignedByTeam, summary, upheld, status, MIcat, MIOpt);
		
		WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL_ci));
		
		WebElement element1 = driver.findElement(By.cssSelector("a[href*='/home']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", element1);
		 
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show search page", urlActual.contains(homeURL_ci));
 
		/* click log out */
		driver.findElement(By.xpath(".//*[@id='content']/ul/li[6]/form/a")).click();
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		
	 }
	 else
	 {
		String urlActual = null;

		System.out.println("Search CEMS Ref does not Exists....!");
		
		/* click back to dashboard link */
		driver.findElement(By.className("link-back")).click();
		
		/* click log out */
		driver.findElement(By.xpath(".//*[@id='content']/ul/li[6]/form/a")).click();
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		
	 }
	 
  }
    
    
    
    @Then("^I check for search cases and complaint number with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
    public void searchCasesComplaintNumber(String type, int priority, String ref, String assignedBy, String assignedByTeam, String summary, String upheld, int status, int MIcat, int MIOpt) {
    		  	
	  	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	 	boolean exists = driver.findElements(By.xpath("//*[@id='form']/div[3]/table/tbody/tr[3]/td[1]/a/span")).size() != 0;
		System.out.println("Search CEMS Ref Exists....! " + exists);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	 if(exists)
	 {
		String urlActual = null;
				
		/* click on cems ref */
		driver.findElement(By.xpath("//*[@id='form']/div[3]/table/tbody/tr[3]/td[1]/a/span")).click();
		urlActual = driver.getCurrentUrl(); 
		assertTrue("Failed to show view complaint customer page", urlActual.contains(viewComplaintPageURL_ci));

		/* click on complaint number */
		 driver.findElement(By.xpath(".//*[@id='content']/div[1]/h1/a/span")).click();
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL_ci));
		
		PopulateComplaint(type, priority, ref, assignedBy, assignedByTeam, summary, upheld, status, MIcat, MIOpt);
		
		WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL_ci));
		
		WebElement element1 = driver.findElement(By.cssSelector("a[href*='/home']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", element1);
		 
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show search page", urlActual.contains(homeURL_ci));
 
		/* click log out */
		driver.findElement(By.xpath(".//*[@id='content']/ul/li[6]/form/a")).click();
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		
	 }
	 else
	 {
		String urlActual = null;

		System.out.println("Search CEMS Ref does not Exists....!");
		
		/* click back to dashboard link */
		driver.findElement(By.className("link-back")).click();
		
		/* click log out */
		driver.findElement(By.xpath(".//*[@id='content']/ul/li[6]/form/a")).click();
		
		urlActual = driver.getCurrentUrl();
		assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
		
	 }
	 
  }
     
    
    @Then("^I enter '(.+)' cert num$")
    public void enterusernamepwd(String certnum) {
    	
    	driver.findElement(By.className("searchCertificateNumber")).sendKeys(certnum);
    	
    }
    
    @Then("^I search for \"(.*)\" by '(.+)'$")
    public void searchfor(String type, String text) throws InterruptedException {
    	
    	
    	try {
    		
    		switch (type){ 
     	    case "Name":
     	    	customerSearchDetails.Name.sendKeys(text);
      	        break;
    	        
     	  case "Surname":
     		 customerSearchDetails.Surname.sendKeys(text);
    	        break;
    	        
     	  case "Postcode":
     		 customerSearchDetails.Postcode.sendKeys(text);
    	        break;
    	        
     	  case "Username":
     		 createNewUserDetails.Username.sendKeys(text);
    	        break;
    	        
     	  case "EmailAddress":
     		 createNewUserDetails.EmailAddress.sendKeys(text);
    	        break;
    	        
     	 case "Search CEMS Number":
     		String cems_ref = driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr[2]/td[1]/a/span")).getText();
     		driver.findElement(By.id("search")).sendKeys(cems_ref +  "\n");
    	        break;
    	        
     	     default: System.out.println("unknown button...");
     	    }
    		
        Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}	
    	
    }
    
    
    
    
	@Then("^I send and verify blank details '(.*)' for login$")
	public void blankLoginDetails(String text) {
		
		driver.findElement(By.id("signin")).click();
		
  		JavascriptExecutor js1 = (JavascriptExecutor) driver;
     	WebElement field1 = driver.findElement(By.id("username"));
     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
     	String username_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
     	System.out.println("username err rmsg........... " + username_message);

     	if (username_message.equals("Please fill in this field.")) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", username_message, "Please fill in this field.");

	 	}
	 	else {
	 		assertEquals("Error: UserName err msg not correct! ", username_message, "This is a required field");

	 	}
	  	
     	
     	
     	driver.findElement(By.id("username")).sendKeys(text);
     	driver.findElement(By.id("signin")).click();
    	
     	JavascriptExecutor js2 = (JavascriptExecutor) driver;
     	WebElement field2 = driver.findElement(By.id("password"));
     	Boolean is_valid2 = (Boolean)js2.executeScript("return arguments[0].checkValidity();", field2);
     	String pwd_message = (String)js2.executeScript("return arguments[0].validationMessage;", field2);
     	System.out.println("username err rmsg........... " + pwd_message);
     	
     	if (pwd_message.equals("Please fill in this field.")) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", pwd_message, "Please fill in this field.");

	 	}
	 	else {
	 		assertEquals("Error: UserName err msg not correct! ", pwd_message, "This is a required field");

	 	
	 	}
     	
	}	

    
	
  	@Then("^I will get error message as '(.+)' with '(.+)'$")
	public void get_error_message(String error_Message, String error_Message_id)
	{
  		String err_msg = null;
  		
  		err_msg = driver.findElement(By.className(error_Message_id)).getText();
  		System.out.println("err_msg ******** " + err_msg );
  		Assert.assertEquals(error_Message, err_msg);

	}
  	
  	
  	
  	 @Then("^I get login error message$")
     public void loginErrorMessage() {
  		 
  		List<WebElement> err = driver.findElements(By.xpath("//*[@id='form-errorMsg']/h3"));
  	    if(err.size() > 0)
  	    {
  	        System.out.println("Found h3 header ... Username or Password is wrong.");
  	    }
  		 
  	 }

  	
  	
  	@Given("^I change status to '(.+)'$")
	public void ChangeStatusActiveResolvedt(String statusType) {
   
		try {
    		
    		switch (statusType){ 
     	    case "Active":
     			new Select (newComplaint.Status()).selectByIndex(1);
      	        break;
      	        
     	   case "Resolved":
     		  new Select (newComplaint.Status()).selectByIndex(2);
     		  break;
     		  
     	     default: System.out.println("unknown status type selected...");
     	     
     	    } 
    			
		 Thread.sleep(2000);
		 
    	}
		
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
		
	}
  	
  	
  	
  	
  	@Given("^I populate RED complaint with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
	public void PopulateRedComplaint(String type, int priority, String ref, String assignedBy, String assignedByTeam, String openeddate, String summary, String upheld, int outcome, int opt1, int opt2, int status, int MIcat, int MIOpt) throws ParseException {
				
		/* RED */
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    Date todaydate = new Date();
	    System.out.println("Today's Date to populate...." + df.format(todaydate));

	    Calendar CurrentDateCal = null;
	    Calendar CurrentDatePlus1Cal = null;
	    Calendar openedDateCal = null;
	    Calendar openedDateTempCal = null;
	    
	    CurrentDateCal = Utilities.toCalendar(todaydate); //CD
	    CurrentDatePlus1Cal = Utilities.addWorkDays(CurrentDateCal, 1);   //CD + 1
	    
	    openedDateTempCal = Utilities.addWorkDays(CurrentDatePlus1Cal, -9); //go back 9 working day
        
        openedDateCal = Utilities.TraverseThroughDatesForNonBankHoliday_RED(openedDateTempCal);
        System.out.println("Non BH day adjusted " + df.format(openedDateCal.getTime()));

		try {
    		
    		switch (type){ 
     	    case "Telephone":
     	    	newComplaint.Telephone.click();
      	        break;
     	   case "Letter":
    	    	newComplaint.Letter.click();
     	        break;
     	  case "Email":
   	    	newComplaint.Email.click();
    	        break;
     	 case "SocialMedia":
  	    	newComplaint.SocialMedia.click();
   	        break;
     	     default: System.out.println("unknown type selected...");
     	    } 
    		
		new Select (newComplaint.Priority()).selectByIndex(priority);
		newComplaint.Reference.clear();
		newComplaint.Reference.sendKeys(ref);
		
		newComplaint.AssignedBy.clear();
		newComplaint.AssignedBy.sendKeys(assignedBy);
		
		newComplaint.AssignedByTeam.clear();
		newComplaint.AssignedByTeam.sendKeys(assignedByTeam);
		
		newComplaint.OpenedDate.clear();
		//newComplaint.OpenedDate.sendKeys(openeddate);
		newComplaint.OpenedDate.sendKeys(df.format(openedDateCal.getTime()));
		
		newComplaint.ComplaintSummary.clear();
		newComplaint.ComplaintSummary.sendKeys(summary);
		
		if ((upheld.equals("yes")) || (upheld.equals("Yes"))) {
			
			newComplaint.Upheld.click();	
		}
		else if ((upheld.equals("no")) || (upheld.equals("No"))) {
			
			newComplaint.Notupheld.click();
			
		}
		else {
			
			System.out.println("Not a valid option for upheld or not upheld.... ");
		}
		
		new Select (newComplaint.Outcome()).selectByIndex(outcome);
		new Select (newComplaint.SelectAnOption1()).selectByIndex(opt1);
		new Select (newComplaint.SelectAnOption2()).selectByIndex(opt2);
		new Select (newComplaint.Status()).selectByIndex(status);
		new Select (newComplaint.SelectAnOption2()).selectByIndex(opt2);
		new Select (newComplaint.Status()).selectByIndex(status);
		new Select (newComplaint.MICat()).selectByIndex(MIcat);
		new Select (newComplaint.MIOpt()).selectByIndex(MIOpt);
		
		 Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
		
	}
  	
  	
	@Given("^I populate AMBER complaint with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
	public void PopulateAmberComplaint(String type, int priority, String ref, String assignedBy, String assignedByTeam, String openeddate, String summary, String upheld, int outcome, int opt1, int opt2, int status, int MIcat, int MIOpt) throws ParseException {
				
		/* AMBER */
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    Date todaydate = new Date();
	    System.out.println("Today's Date to populate...." + df.format(todaydate));

	    Calendar CurrentDateCal = null;
	    Calendar CurrentDatePlus2Cal = null;
	    Calendar openedDateCal = null;
	    Calendar openedDateTempCal = null;
	    
	    CurrentDateCal = Utilities.toCalendar(todaydate); //CD
	    CurrentDatePlus2Cal = Utilities.addWorkDays(CurrentDateCal, 2);   //CD + 2
	    System.out.println("CD + 2: " + df.format(CurrentDatePlus2Cal.getTime()));
	    
	    openedDateTempCal = Utilities.addWorkDays(CurrentDatePlus2Cal, -9); //go back 9 working day
	    System.out.println("openedDateTempCal: " + df.format(openedDateTempCal.getTime()));
	    
        openedDateCal = Utilities.TraverseThroughDatesForNonBankHoliday_AMBER(openedDateTempCal);
        System.out.println("Non BH day adjusted " + df.format(openedDateCal.getTime()));
   
		try {
    		
    		switch (type){ 
     	    case "Telephone":
     	    	newComplaint.Telephone.click();
      	        break;
     	   case "Letter":
    	    	newComplaint.Letter.click();
     	        break;
     	  case "Email":
   	    	newComplaint.Email.click();
    	        break;
     	 case "SocialMedia":
  	    	newComplaint.SocialMedia.click();
   	        break;
     	     default: System.out.println("unknown type selected...");
     	    } 
    		
		new Select (newComplaint.Priority()).selectByIndex(priority);
		
		newComplaint.Reference.clear();
		newComplaint.Reference.sendKeys(ref);
		
		newComplaint.AssignedBy.clear();
		newComplaint.AssignedBy.sendKeys(assignedBy);
		
		newComplaint.AssignedByTeam.clear();
		newComplaint.AssignedByTeam.sendKeys(assignedByTeam);
		
		newComplaint.OpenedDate.clear();
		//newComplaint.OpenedDate.sendKeys(openeddate);
		newComplaint.OpenedDate.sendKeys(df.format(openedDateCal.getTime()));
		
		newComplaint.ComplaintSummary.clear();
		newComplaint.ComplaintSummary.sendKeys(summary);
		
		if ((upheld.equals("yes")) || (upheld.equals("Yes"))) {
			WebElement element0 = newComplaint.Upheld;
  	    	 JavascriptExecutor executor0 = (JavascriptExecutor)driver;
  	    	 executor0.executeScript("arguments[0].click()", element0);
		}
		else if ((upheld.equals("no")) || (upheld.equals("No"))) {
			WebElement element0 = newComplaint.Notupheld;//
  	    	 JavascriptExecutor executor0 = (JavascriptExecutor)driver;
  	    	 executor0.executeScript("arguments[0].click()", element0);
			
		}
		else {
			
			System.out.println("Not a valid option for upheld or not upheld.... ");
		}
		
		new Select (newComplaint.Outcome()).selectByIndex(outcome);
		new Select (newComplaint.SelectAnOption1()).selectByIndex(opt1);
		new Select (newComplaint.SelectAnOption2()).selectByIndex(opt2);
		new Select (newComplaint.Status()).selectByIndex(status);
		new Select (newComplaint.SelectAnOption2()).selectByIndex(opt2);
		new Select (newComplaint.Status()).selectByIndex(status);
		new Select (newComplaint.MICat()).selectByIndex(MIcat);
		new Select (newComplaint.MIOpt()).selectByIndex(MIOpt);
		
		 Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
		
	}
	
	
	
	
	@Given("^I populate GREEN complaint with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
	public void PopulateGreenComplaint(String type, int priority, String ref, String assignedBy, String assignedByTeam, String openeddate, String summary, String upheld, int outcome, int opt1, int opt2, int status, int MIcat, int MIOpt) throws ParseException {
				
		/* GREEN */
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    Date todaydate = new Date();
	    System.out.println("Today's Date to populate...." + df.format(todaydate));

	    Calendar CurrentDateCal = null;
	    Calendar CurrentDatePlus5Cal = null;
	    Calendar openedDateCal = null;
	    Calendar openedDateTempCal = null;
	    
	    CurrentDateCal = Utilities.toCalendar(todaydate); //CD
	    CurrentDatePlus5Cal = Utilities.addWorkDays(CurrentDateCal, 5);   //CD + 5
	    
	    openedDateTempCal = Utilities.addWorkDays(CurrentDatePlus5Cal, -9); //go back 9 working day
        
        openedDateCal = Utilities.TraverseThroughDatesForNonBankHoliday_GREEN(openedDateTempCal);
        System.out.println("Non BH day adjusted " + df.format(openedDateCal.getTime()));

		try {
    		
    		switch (type){ 
     	    case "Telephone":
     	    	newComplaint.Telephone.click();
      	        break;
     	   case "Letter":
    	    	newComplaint.Letter.click();
     	        break;
     	  case "Email":
   	    	newComplaint.Email.click();
    	        break;
     	 case "SocialMedia":
  	    	newComplaint.SocialMedia.click();
   	        break;
     	     default: System.out.println("unknown type selected...");
     	    } 
    		
		new Select (newComplaint.Priority()).selectByIndex(priority);
		newComplaint.Reference.clear();
		newComplaint.Reference.sendKeys(ref);
		
		newComplaint.AssignedBy.clear();
		newComplaint.AssignedBy.sendKeys(assignedBy);
		
		newComplaint.AssignedByTeam.clear();
		newComplaint.AssignedByTeam.sendKeys(assignedByTeam);
		
		newComplaint.OpenedDate.clear();
		//newComplaint.OpenedDate.sendKeys(openeddate);
		newComplaint.OpenedDate.sendKeys(df.format(openedDateCal.getTime()));
		
		newComplaint.ComplaintSummary.clear();
		newComplaint.ComplaintSummary.sendKeys(summary);
	
		if ((upheld.equals("yes")) || (upheld.equals("Yes"))) {
			
			newComplaint.Upheld.click();	
		}
		else if ((upheld.equals("no")) || (upheld.equals("No"))) {
			
			newComplaint.Notupheld.click();
			
		}
		else {
			
			System.out.println("Not a valid option for upheld or not upheld.... ");
		}
		
		new Select (newComplaint.Outcome()).selectByIndex(outcome);
		new Select (newComplaint.SelectAnOption1()).selectByIndex(opt1);
		new Select (newComplaint.SelectAnOption2()).selectByIndex(opt2);
		new Select (newComplaint.Status()).selectByIndex(status);
		new Select (newComplaint.SelectAnOption2()).selectByIndex(opt2);
		new Select (newComplaint.Status()).selectByIndex(status);
		new Select (newComplaint.MICat()).selectByIndex(MIcat);
		new Select (newComplaint.MIOpt()).selectByIndex(MIOpt);
		
		 Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
		
	}
	
	
	
	@Given("^I populate edit complaint with '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.+)'$")
	public void PopulateComplaint(String type, int priority, String ref, String assignedBy, String assignedByTeam, String summary, String upheld, int status, int MIcat, int MIOpt) {
		
		try {
    		
    		switch (type){ 
     	    case "Telephone":
     	    	newComplaint.Telephone.click();
      	        break;
     	   case "Letter":
    	    	newComplaint.Letter.click();
     	        break;
     	  case "Email":
   	    	newComplaint.Email.click();
    	        break;
     	 case "SocialMedia":
  	    	newComplaint.SocialMedia.click();
   	        break;
     	     default: System.out.println("unknown type selected...");
     	    } 
    		
		new Select (newComplaint.Priority()).selectByIndex(priority);
		newComplaint.Reference.clear();
		newComplaint.Reference.sendKeys(ref);
		
		newComplaint.AssignedBy.clear();
		newComplaint.AssignedBy.sendKeys(assignedBy);
		
		newComplaint.AssignedByTeam.clear();
		newComplaint.AssignedByTeam.sendKeys(assignedByTeam);
		
		//newComplaint.ComplaintSummary.clear();
		//newComplaint.ComplaintSummary.sendKeys(summary);

		if ((upheld.equals("yes")) || (upheld.equals("Yes"))) {
			WebElement element0 = newComplaint.Upheld;
 	    	 JavascriptExecutor executor0 = (JavascriptExecutor)driver;
 	    	 executor0.executeScript("arguments[0].click()", element0);
		}
		else if ((upheld.equals("no")) || (upheld.equals("No"))) {
			WebElement element0 = newComplaint.Notupheld;
 	    	 JavascriptExecutor executor0 = (JavascriptExecutor)driver;
 	    	 executor0.executeScript("arguments[0].click()", element0);
			
		}
		else {
			
			System.out.println("Not a valid option for upheld or not upheld.... ");
		}
		
		new Select (newComplaint.Status()).selectByIndex(status);
		new Select (newComplaint.MICat()).selectByIndex(MIcat);
		new Select (newComplaint.MIOpt()).selectByIndex(MIOpt);
		
		 Thread.sleep(2000);
    	}
    	catch (InterruptedException e)
    	{
    		
    		System.out.println("Error: " + e);
    	}
		
	}
  	
    

}
