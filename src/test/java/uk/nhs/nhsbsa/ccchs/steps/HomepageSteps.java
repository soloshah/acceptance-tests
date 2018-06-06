package uk.nhs.nhsbsa.ccchs.steps;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.nhs.nhsbsa.ccchs.DataHelper.DataHelper;
import uk.nhs.nhsbsa.ccchs.config.env.BaseTest;
import uk.nhs.nhsbsa.ccchs.config.env.EnvConfig;
import uk.nhs.nhsbsa.ccchs.config.env.TestBase;
import uk.nhs.nhsbsa.ccchs.helpers.GenericData;
import uk.nhs.nhsbsa.ccchs.model.CreateNewCustomer;
import uk.nhs.nhsbsa.ccchs.model.CreateNewUser;
import uk.nhs.nhsbsa.ccchs.model.EditExistingCustomer;
import uk.nhs.nhsbsa.ccchs.utils.TestLogger;
import uk.nhs.nhsbsa.ccchs.utils.TestUtils;
import uk.nhs.nhsbsa.ccchs.utils.Utilities;
import uk.nhs.nhsbsa.ccchs.views.CreateNewComplaintDetails;
import uk.nhs.nhsbsa.ccchs.views.CreateNewCustomerDetails;
import uk.nhs.nhsbsa.ccchs.views.CreateNewUserDetails;
import uk.nhs.nhsbsa.ccchs.views.EditExistingCustomerDetails;
import uk.nhs.nhsbsa.ccchs.views.LoginPage;
import uk.nhs.nhsbsa.ccchs.viewsmethods.CreateNewCustomer_Methods;
import uk.nhs.nhsbsa.ccchs.viewsmethods.CreateNewUser_Methods;
import uk.nhs.nhsbsa.ccchs.viewsmethods.EditExistingCustomer_Methods;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomepageSteps implements BaseTest {

	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    
    CreateNewCustomerDetails createNewCustomerDetails = PageFactory.initElements(driver, CreateNewCustomerDetails.class);
    CreateNewUserDetails createNewUserDetails = PageFactory.initElements(driver, CreateNewUserDetails.class);
    EditExistingCustomerDetails editExistingCustomerDetails = PageFactory.initElements(driver, EditExistingCustomerDetails.class);
    CreateNewComplaintDetails newComplaint = PageFactory.initElements(driver, CreateNewComplaintDetails.class);
	
    TestBase testBase = new TestBase();
    
    CreateNewCustomer_Methods createNewCustomer_Methods = new CreateNewCustomer_Methods();
    EditExistingCustomer_Methods editExistingCustomer_Methods = new EditExistingCustomer_Methods();
    CreateNewUser_Methods createNewUser_Methods = new CreateNewUser_Methods();

    /* heruko */
    public static String loginPageURL = "https://cemsman.herokuapp.com/login";
    public static String loginerrorURL = "https://cemsman.herokuapp.com/login?error";
    public static String homeURL = "https://cemsman.herokuapp.com/";
    public static String logoutPageURL = "https://cemsman.herokuapp.com/login?logout";
    public static String searchPageURL = "https://cemsman.herokuapp.com/search";
    public static String searchResultPageURL = "https://cemsman.herokuapp.com/searchresults?firstName=test&lastName=&postcode=";
    public static String editComplaintPageURL = "https://cemsman.herokuapp.com/editComplaint";
    public static String viewCustomerPageURL = "https://cemsman.herokuapp.com/viewCustomer";
    public static String createNewCustomerPageURL = "https://cemsman.herokuapp.com/form?Create+New+Customer=Create+New+Customer";
    public static String editExistingCustomerPageURL = "https://cemsman.herokuapp.com/editCustomer";
    public static String activeCasesPageURL = "https://cemsman.herokuapp.com/activecase";
    public static String adminPageURL = "https://cemsman.herokuapp.com/admin";
    public static String viewComplaintPageURL = "https://cemsman.herokuapp.com/viewComplaint";
    public static String resolvedCasesPageURL = "https://cemsman.herokuapp.com/resolvedcase";
    public static String newUserPageURL = "https://cemsman.herokuapp.com/userform";
    public static String editUserPageURL = "https://cemsman.herokuapp.com/editUser";
    public static String redCasesURL = "https://cemsman.herokuapp.com/home?sla=1";
    public static String amberCasesURL = "https://cemsman.herokuapp.com/home?sla=2";
    public static String greenCasesURL = "https://cemsman.herokuapp.com/home?sla=3";

    /* test env ci pipeline*/
    public static String loginPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/login";
    public static String loginerrorURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/login?error";
    public static String homeURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/";
    public static String logoutPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/login?logout";
    public static String searchPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/search";
    public static String searchResultPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/searchresults?firstName=test&lastName=&postcode=";
    public static String editComplaintPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/editComplaint";
    public static String viewCustomerPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/viewCustomer";
    public static String createNewCustomerPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/form?Create+New+Customer=Create+New+Customer";
    public static String editExistingCustomerPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/editCustomer";
    public static String activeCasesPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/activecase";
    public static String adminPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/admin";
    public static String viewComplaintPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/viewComplaint";
    public static String resolvedCasesPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/resolvedcase";
    public static String newUserPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/userform";
    public static String editUserPageURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/editUser";
    public static String redCasesURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/home?sla=1";
    public static String amberCasesURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/home?sla=2";
    public static String greenCasesURL_ci = "https://tst.services.nhsbsa.nhs.uk/compman/home?sla=3";
  	
  	@When("^I click \"(.*)\"$")
    public void click_button(String item) {
  		
  		switch (item){
  	     case "Submit":
  	    	driver.findElement(By.id("submit")).click();
  	        break;
  	     case "Cancel":
  	    	driver.findElement(By.id("cancellink")).click();
  	        break;
  	      case "Cancel Button":
    	    	driver.findElement(By.id("cancelLink")).click();
    	        break;
  	     default: System.out.println("unknown button");
  	    }
       
    }
  	
  	
  	@Then("^I verify the url for login page$")
    public boolean landingPageVerifyUrl(){
        
  		String run_env = EnvConfig.getTestEnvironment();
  		System.out.println("run env: " + run_env);
  		
  		if (run_env == "ci") {
    	String currentUrl = driver.getCurrentUrl();
	 	assertTrue("Failed to show landing page", currentUrl.contains(loginPageURL_ci));
  		}
  		
  		if (run_env == "cloud") {
  	    	String currentUrl = driver.getCurrentUrl();
  		 	assertTrue("Failed to show landing page", currentUrl.contains(loginPageURL));
  	  	}
  		
  		
	 	testBase.Wait(1);	 	
        return true;

    }

  	
//  	@When("^I send search details and click submit$")
//    public void enterSearchDetails() {
//        
//        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
//        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.getSearch());
//        pageSearchDetails.ClickSubmit();
//  	}
//  	
//  	@When("^I send cert num '(.+)' and click submit$")
//    public void sendCertNum(String certNo) {
//        
//        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
//        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.enterCertNum(certNo));
//        pageSearchDetails.ClickSubmit();
//  	}
//  	
//  	
//  	@When("^I send dd ref '(.+)' and click submit$")
//    public void sendDDRef(String ddref) {
//        
//        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
//        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.enterDDRef(ddref));
//        pageSearchDetails.ClickSubmit();
//  	}
//  	
  	
  	
//  	@When("^I send surname '(.+)' and dob '(.+)' and click submit$")
//    public void sendSurnameDOB(String surname, String dob) {
//        
//        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
//        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.enterSurnameAndDOB(surname, dob));
//        pageSearchDetails.ClickSubmit();
//  	}
//  	
//  	
//  	
//  	@When("^I send search with non england postcode details$")
//    public void enterSearchNonEnglandPostcodeDetails() throws InterruptedException {
//        
//        //waitForElement("//*[@id='searchForm']/div[3]/div[2]/input");
//        pageSearchDetails.PopulateSearchCriteria(TelesalesDataHelper.getSearch());
//        
//        //waitForElement("//*[@id='postcodeField']");
//		
//		Search duffPostcodeSearch = TelesalesDataHelper.getSearch();
//        
//        duffPostcodeSearch.Postcode = Utilities.getRandomPostCode(Utilities.PostCodeCountry.Scotland);
//        
//        pageSearchDetails.PopulateSearchCriteria(duffPostcodeSearch);
//        
//        pageSearchDetails.ClickSubmit();
//        
//        Thread.sleep(10);
//        
//  	}
  	
  	
//  	@When("^I click certificate number '(.+)' on search results page$")
//    public void clickCertNumberSearchDetails(String cert_num) {
//       
//  		//pageSearchResults.ClickCertNumber(1);
//  		
//  		driver.findElement(By.partialLinkText(cert_num)).click();
//  		
//  	}
  	
  	
//  	@When("^I verify certificate number '(.+)' on search results page$")
//    public void verifyCertNumberSearchDetails(String certNumber) {
//       
//  		String certNum = driver.findElement(By.partialLinkText(certNumber)).getText();
//  		System.out.println("cert no:" + certNum);
//
//  		assertEquals("Failed to find Certificate Number", certNumber,certNum); 
//  		
//  	}
  	
  	@Then("^I am redirected to \"(.*)\" page with url \"(.*)\"$")
    public void CheckUrl(String link, String urlExpected) 
  	{
  		testBase.Wait(1);
  		String urlActual = null;
  		urlActual = driver.getCurrentUrl();
  		testBase.Wait(1);
  		
  		switch (link){
 	     case "login error":
 	    	testBase.Wait(1);
 	     	Assert.assertEquals(urlExpected, urlActual );
 	        break;
 	     default: System.out.println("unknown URL...");
 	    }
  	
  	}
  	
  	@Then("^I am redirected to \"(.*)\" page$")
    public void CheckPageUrl(String link) 
  	{
  		
	  	String run_env = EnvConfig.getTestEnvironment();
	  		
  		testBase.Wait(1);
  		String urlActual = null;
  		urlActual = driver.getCurrentUrl();
  		testBase.Wait(1);
    	TestLogger.Info("urlActual is: " + urlActual);
  		
  		switch (link){
 	     case "login error":
 	    	testBase.Wait(1);
 	    	if (run_env == "ci") {
 	     	assertTrue("Failed to show login error page", urlActual.contains(loginerrorURL_ci));
 	  		}
 	  		if (run_env == "heruko") {
 	 	     	assertTrue("Failed to show login error page", urlActual.contains(loginerrorURL));
 	 	  	}
 	        break;
 	        
 	     case "active cases":
 	    	testBase.Wait(1);
 	  		if (run_env == "ci") {
 	     	assertTrue("Failed to show active cases page", urlActual.contains(activeCasesPageURL_ci));
 	  		}
 	  		if (run_env == "heruko") {
 	 	     	assertTrue("Failed to show active cases page", urlActual.contains(activeCasesPageURL));
 	 	  	}
 	        break;
 	        
 	     case "resolved cases":
 	    	testBase.Wait(1);
 	  		if (run_env == "ci") {
 	     	assertTrue("Failed to show active cases page", urlActual.contains(resolvedCasesPageURL_ci));
 	  		}
 	  		if (run_env == "heruko") {
 	 	     	assertTrue("Failed to show active cases page", urlActual.contains(resolvedCasesPageURL));
 	 	  	}
 	        break;
 	        
 	     case "red cases":
 	    	testBase.Wait(1);
 	  		if (run_env == "ci") {
 	     	assertTrue("Failed to show active cases page", urlActual.contains(redCasesURL_ci));
 	  		}
 	  		if (run_env == "heruko") {
 	 	     	assertTrue("Failed to show active cases page", urlActual.contains(redCasesURL));
 	 	  	}
 	        break;
 	        
 	     case "amber cases":
 	    	testBase.Wait(1);
 	  		if (run_env == "ci") {
 	     	assertTrue("Failed to show active cases page", urlActual.contains(amberCasesURL_ci));
 	  		}
 	  		if (run_env == "heruko") {
 	 	     	assertTrue("Failed to show active cases page", urlActual.contains(amberCasesURL));
 	 	  	}
 	        break;
 	        
 	     case "green cases":
 	    	testBase.Wait(1);
 	  		if (run_env == "ci") {
 	     	assertTrue("Failed to show active cases page", urlActual.contains(greenCasesURL_ci));
 	  		}
 	  		if (run_env == "heruko") {
 	 	     	assertTrue("Failed to show active cases page", urlActual.contains(greenCasesURL));
 	 	  	}
 	        break;
 	 
 	     case "home":
 	    	testBase.Wait(1);
 	  		if (run_env == "ci") {
 	     	assertTrue("Failed to show search page", urlActual.contains(homeURL_ci));
 	  		}
 	  		if (run_env == "heruko") {
 	 	     	assertTrue("Failed to show search page", urlActual.contains(homeURL));
 	 	  	}
 	        break;
 	        
 	     case "logout":
 	    	testBase.Wait(1);
 	  		if (run_env == "ci") {
 	     	assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL_ci));
 	  		}
 	  		if (run_env == "heruko") {
 	 	     	assertTrue("Failed to show logout page", urlActual.contains(logoutPageURL));
 	 	  	}
 	        break;
 	        
 	    case "search":
 	    	testBase.Wait(1);
 	  		if (run_env == "ci") {
 	     	assertTrue("Failed to show search page", urlActual.contains(searchPageURL_ci));
 	  		}
 	  		if (run_env == "heruko") {
 	 	     	assertTrue("Failed to show search page", urlActual.contains(searchPageURL));
 	 	  	}
 	        break;
 	        
 	   case "edit complaint":
	    	testBase.Wait(1);
	  		if (run_env == "ci") {
	     	assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL_ci));
	  		}
	  		if (run_env == "heruko") {
	 	     	assertTrue("Failed to show edit complaint page", urlActual.contains(editComplaintPageURL));
	 	  	}
	        break;
	        
 	  case "admin":
	    	testBase.Wait(1);
	  		if (run_env == "ci") {
	     	assertTrue("Failed to show admin page", urlActual.contains(adminPageURL_ci));
	  		}
	  		if (run_env == "heruko") {
	 	     	assertTrue("Failed to show admin page", urlActual.contains(adminPageURL));
	 	  	}
	        break;
	        
 	 case "new user":
	    	testBase.Wait(1);
	  		if (run_env == "ci") {
	     	assertTrue("Failed to show new user page", urlActual.contains(newUserPageURL_ci));
	  		}
	  		if (run_env == "heruko") {
	 	     	assertTrue("Failed to show new user page", urlActual.contains(newUserPageURL));
	 	  	}
	        break;
	        
 	case "create new customer":
    	testBase.Wait(1);
  		if (run_env == "ci") {
     	assertTrue("Failed to show create new customer page", urlActual.contains(createNewCustomerPageURL_ci));
  		}
  		if (run_env == "heruko") {
 	     	assertTrue("Failed to show create new customer page", urlActual.contains(createNewCustomerPageURL));
 	  	}
        break;
        
 	case "search result":
    	testBase.Wait(1);
  		if (run_env == "ci") {
     	assertTrue("Failed to show Search Result Page URL", urlActual.contains(searchResultPageURL_ci));
  		}
  		if (run_env == "heruko") {
 	     	assertTrue("Failed to show Search Result Page URL", urlActual.contains(searchResultPageURL));
 	  	}
        break;
        
 	case "view customer":
    	testBase.Wait(1);
  		if (run_env == "ci") {
     	assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL_ci));
  		}
  		if (run_env == "heruko") {
 	     	assertTrue("Failed to show View Customer Page URL", urlActual.contains(viewCustomerPageURL));
 	  	}
        break;
        
        
 	case "edit existing customer":
    	testBase.Wait(1);
  		if (run_env == "ci") {
     	assertTrue("Failed to show edit existing customer page", urlActual.contains(editExistingCustomerPageURL_ci));
  		}
  		if (run_env == "heruko") {
 	     	assertTrue("Failed to show edit existing customer page", urlActual.contains(editExistingCustomerPageURL));
 	  	}
        break;
        
 	case "view complaint":
    	testBase.Wait(1);
  		if (run_env == "ci") {
     	assertTrue("Failed to show edit existing customer page", urlActual.contains(viewComplaintPageURL_ci));
  		}
  		if (run_env == "heruko") {
 	     	assertTrue("Failed to show edit existing customer page", urlActual.contains(viewComplaintPageURL));
 	  	}
        break;
        
 	case "edit user":
    	testBase.Wait(1);
  		if (run_env == "ci") {
     	assertTrue("Failed to show edit user page", urlActual.contains(editUserPageURL_ci));
  		}
  		if (run_env == "heruko") {
 	     	assertTrue("Failed to show edit user page", urlActual.contains(editUserPageURL));
 	  	}
        break;
  

 	     default: System.out.println("unknown URL...");
 	    }
  	
  	}
  	
  	


//  	@Then("^I check that it is correct certificate as '(.+)' on search results page$")
//    public boolean correctCertificate(String cert_number){
//  		testBase.Wait(5);
////  		assertTrue("Failed to find Certificate Number", pageSearchResults_Methods.isCorrectCertificate(cert_number));
//  		testBase.Wait(10);	
//  		
//  		assertTrue("Failed to find Certificate Number", pageSearchResults_Methods.isCorrectCertificate(cert_number)); 
//
//  		
//  		
//        return true;
//        
//    }
  	
//  	@Then("^I check that it is correct certificate as '(.+)' on certificate details page$")
//    public void correctCertificateDetailsPage(String certNumber){
//        
//  		//assertTrue("Not the correct certificate number", pageCertificateDetails_Methods.isCorrectCertNumber(cert_number));
//  		
//  		String locator = "//*[@id='certNumber']/text()[contains(.,'" + certNumber + "')]/..";
//		 String certNum = driver.findElement(By.xpath(locator)).getText();
//	  	 assertEquals("Failed to find Certificate Number", certNumber,certNum); 
//  		testBase.Wait(1);	
//        
//    }
//  	
//  	
//  	@Then("^I check that it is correct certificate status as '(.+)'$")
//    public void correctCertificateStatus(String cert_status){
//        
//  		//assertTrue("Not the correct certificate status", pageCertificateDetails_Methods.isCorrectCertStatus(cert_status));
//  		testBase.Wait(1);	 	
//  		
//  		 String locator = ".//*[@id='certDetails']/div/div[2]/div[3]/p";
//		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
//		 assertEquals("Not the correct certificate status", driver.findElement(By.xpath(locator)).getText(),cert_status); 
//  		
//        //return true;
//        
//    }
//  	
//  	
//  	@Then("^I check that it is correct ddref as '(.+)'$")
//    public void correctDDRef(String DDRef){
//        
//  		//assertTrue("Not the correct DD reference", pageCertificateDetails_Methods.isCorrectDDRef(DDRef));
//  		testBase.Wait(1);	
//  		
//  		
//  		String locator = "//*[@id='directDebitDetails']/div/div[2]/div[1]/p/text()[contains(.,'" + DDRef + "')]/..";
//		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
//		 assertEquals("Not the correct DD reference", driver.findElement(By.xpath(locator)).getText(),DDRef);
//        
//    }
//  	
//  	@Then("^I check that it is correct due date as '(.+)'$")
//    public void correctDDDueDay(String DDue){
//        
//  		//assertTrue("Not the correct due date", pageCertificateDetails_Methods.isCorrectDDDueDay(DDue));
//  		testBase.Wait(1);	 	
//  		
//  		String locator = "//*[@id='directDebitDetails']/div/div[2]/div[2]/p/text()[contains(.,'" + DDue + "')]/..";
//		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
//		 assertEquals("Not the correct due date", driver.findElement(By.xpath(locator)).getText(),DDue);
//
//        
//    }
//  	
//  	@Then("^I check that it is correct payment type as '(.+)'$")
//    public void correctPaymentType(String paymentType){
//  		
//  		testBase.Wait(2);
//  		String locator = "//*[@id='ppcPayments']/tbody/tr/td[2]/text()[contains(.,'" + paymentType + "')]/..";
//  		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
//		 assertEquals("Failed to find Certificate Status", driver.findElement(By.xpath(locator)).getText(),paymentType);
//		 
//  		//assertTrue("Not the correct Payment type", pageCertificateDetails_Methods.isCorrectPaymentType(paymentType));
//  		testBase.Wait(1);	 	
//
//    }
//  	
//  	@Then("^I check that it is correct payment amount as '(.+)'$")
//    public void correctPaymentAmount(String paymentAmount){
//        
//  		//assertTrue("Not the correct Payment amount", pageCertificateDetails_Methods.isCorrectPaymentAmount(paymentAmount));
//  		
//  		String locator = "//*[@id='ppcPayments']/tbody/tr/td[3]/text()[contains(.,'" + paymentAmount + "')]/..";
// 		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
//		 assertEquals("Not the correct Payment amount", driver.findElement(By.xpath(locator)).getText(),paymentAmount);
//		 
//  		testBase.Wait(1);	 	
//        
//    }
//  	
//  	@Then("^I check that it is correct payment status as '(.+)'$")
//    public void correctPaymentStatus(String paymentStatus){
//        
//  		//assertTrue("Not the correct Payment Status", pageCertificateDetails_Methods.isCorrectPaymentStatus(paymentStatus));
//  		
//  		String locator = "//*[@id='ppcPayments']/tbody/tr/td[4]/text()[contains(.,'" + paymentStatus + "')]/..";
//  		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
//		 assertEquals("Not the correct Payment Status", driver.findElement(By.xpath(locator)).getText(),paymentStatus);
//		 
//  		testBase.Wait(1);	 	
//        
//    }
//  	
//  	@Then("^I check that it is correct cost as '(.+)'$")
//    public void correctCost(String cost){
//        
//  		//assertTrue("Cost is not correct", pageCertificateDetails_Methods.isCorrectCost(cost));
//  		
//  		String locator = "//*[@id='certificateTotalCost']/text()[contains(.,'" + cost + "')]/..";
// 		 TestLogger.Info("Correct Cert Status: " + driver.findElement(By.xpath(locator)).getText());
//		 assertEquals("Cost is not correct", driver.findElement(By.xpath(locator)).getText(),cost);
//  		testBase.Wait(1);	 	
//        
//    }
//  	
//  	@Then("^I check total is empty$")
//    public void totalEmpty(){
//        
//  		//assertTrue("Total is not correct", pageCertificateDetails_Methods.isTotalEmpty());
//  	
//  		String locator = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[3]/div/div[2]/span[1]";
//		 String element = driver.findElement(By.xpath(locator)).getText();
//		 //TestLogger.Info("Q" + element);
//		 Assert.assertTrue("Total is not correct",element.isEmpty());
//  		testBase.Wait(1);	 	
//        
//    }
//  	
//  	@Then("^I check that it is correct outstanding balance as '(.+)'$")
//    public void correctOutstandingBalance(String outstandingBalance){
//        
//  		//assertTrue("Outstanding balance is not correct", pageCertificateDetails_Methods.isCorrectOutstandingBalance(outstandingBalance));
//  		
//  		 String locator = "//*[@id='container']/form/div[1]/div[1]/div[3]/div[3]/div/div[3]/span/text()[contains(.,'" + outstandingBalance + "')]/..";
//  		assertEquals("Outstanding balance is not correct", driver.findElement(By.xpath(locator)).getText(),outstandingBalance);
//  		testBase.Wait(1);	 	
//        
//    }
//  	
//  	@Then("^I check that it is correct total as '(.+)'$")
//    public void correctTotal(String total){
//        
//  		//assertTrue("Surname is not correct", pageCertificateDetails_Methods.isCorrectTotal(total));
//  		
//  		String locator = "//*[@id='container']/form/div[1]/div[1]/div[2]/div[3]/div/div[2]/span[1]/text()[contains(.,'" + total + "')]/..";
//  		assertEquals("correct Total is not correct", driver.findElement(By.xpath(locator)).getText(),total);
//  		testBase.Wait(1);	 	
//        
//    }
//  	
//  	@Then("^I check that it is correct surname as '(.+)'$")
//    public void correctSurname(String surname){
//        
//  		//assertTrue("Surname is not correct", pageCertificateDetails_Methods.isCorrectSurname(surname));
//  		
//  		String locator = "//*[@id='holderSurname']/text()[contains(.,'" + surname + "')]/..";
//  		assertEquals("Surname is not correct", driver.findElement(By.xpath(locator)).getText(),surname);
//  		testBase.Wait(1);	 	
//
//    }
//  	
//  	@Then("^I check that it is correct address line1 as '(.+)'$")
//    public void correctAddressLine1(String addressline1){
//        
//  		//assertTrue("Address line1 is not correct", pageCertificateDetails_Methods.isCorrectAddressLine1(addressline1));
//  		
//  		String locator = "//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div[4]/p/text()[contains(.,'" + addressline1 + "')]/..";
//  		assertEquals("Address line1 is not correct", driver.findElement(By.xpath(locator)).getText(),addressline1);
//  		testBase.Wait(1);	 	
//        
//    }
//  	
//  	@Then("^I check that email is empty$")
//    public void emailEmpty(){
//        
//  		//assertTrue("Email should be blank", pageCertificateDetails_Methods.isEmailEmpty());
//  		
//  		String locator = "//*[@id='contactDetails']/div/div[2]/ng-form/fieldset/div[contains(.,'Email')]/p";
//  		 String element = driver.findElement(By.xpath(locator)).getText();
//  		Assert.assertTrue("Email should be blank",element.isEmpty());
//  		testBase.Wait(1);	 	
// 
//    }
//  	
//  	@Then("^I check that it is correct notes as '(.+)'$")
//    public void correctNotes(String notes){
//        
//  		//assertTrue("There should be no notes", pageCertificateDetails_Methods.isCorrectNotes(notes));
//  		
//  		String locator = "";
//		 
//		 if (notes.contains("No notes available for this certificate case")) {
//			 locator = "//*[@id='container']/form/div[1]/div[2]/div[2]/div[2]/div/text()[contains(.,'" + notes + "')]/..";
//		 } else {
//			 locator = "//*[@id='container']/form/div[1]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td/text()[contains(.,'" + notes + "')]/..";
//		 }
//		 
//		 assertEquals("There should be no notes", driver.findElement(By.xpath(locator)).getText(),notes);
//  		testBase.Wait(1);	 	
//        
//    }
//  	
//  	
//  	@Then("^I check that search error is present as '(.+)'$")
//    public void searchErrorIsPresent(String err_msg){
//        
//  		//assertTrue("Failed to find Certificate Number", pageSearchResults_Methods.CheckSearchErrorIsPresent(err_msg));
//  		
//  		String locator = "//*[@id='container']/form/span/b";
//  		 assertEquals("There should be no notes", driver.findElement(By.xpath(locator)).getText(),err_msg);
//  		testBase.Wait(1);	 	
//        
//    }
//  	
//  	@When("^I should list several entries for this number as '(.+)' and '(.+)'$")
//    public void listCountCertificatesFound(String cert_number, int expectedCount) {
//        
//  		//assertTrue("Failed to find Certificate Number", pageSearchResults_Methods.isCorrectCertificate(cert_number));
//  		testBase.Wait(1);
////        int certCount = pageSearchResults_Methods.countCertificatesFound();
////        assertTrue("Number of entries dont match",certCount == expectedCount);
//        
//        
//        String locator = ".//*[@id='container']/table/tbody/tr";
//		int totalCertificates =  driver.findElements(By.xpath(locator)).size();
//		System.out.println("total cert no:" + totalCertificates);
//		
//		assertTrue("Number of entries dont match",totalCertificates == expectedCount);
//  	
//  	}
  	

  	
  	
//  	@When("^I click new application$")
//    public void newApplication() {
//        
//        pageSearchResults.ClickNewApplication();
//  	}
//  	
//  	
//  	@When("^I click new application on page certificate details$")
//    public void newApplicationonPageCertificateDetails() {
//        
//  		pageCertificateDetails.ClickNewApplication();
//  	}
  	
    @And ("^I verify that access is denied to User Mgt tab$")
    public void verifyAccessDeniedUserMgtTab() {
    	String bodyText = driver.findElement(By.xpath("html/body/h1")).getText();
    	Assert.assertTrue("Text not found!", bodyText.contains("Access is Denied"));
    	System.out.println("name_message err rmsg........... " + bodyText);
    }
  	
  	@And("^I send customer details by name$")
	public void enterCustomerByNameDetails() {
  		
  		CreateNewCustomer createNewCustomer = DataHelper.getApplicantByName();

  		createNewCustomer_Methods.PopulateCustomerDetails(createNewCustomer);

	}
  	
  	@And("^I send customer details by surname$")
	public void enterCustomerBySurnameDetails() {
  		
  		CreateNewCustomer createNewCustomer = DataHelper.getApplicantBySurname();

  		createNewCustomer_Methods.PopulateCustomerDetails(createNewCustomer);

	}
  	
  	
  	
  	@Then("^I send and verify empty details for customer details$")
	public void EmptyCustomerByCustomerDetails() throws IOException {
  		
  		String msg0 = "Please select a title";
  		 
  		String msg1 = "Please enter a first name" + "\n" + "Must be text only" + "\n" + "Must be between 2 and 30 characters";
  		String msg2 = "Please enter a first name" + "\n" + "Must be between 2 and 30 characters" + "\n" + "Must be text only";
  		String msg3 = "Must be text only" + "\n" + "Must be between 2 and 30 characters" + "\n" + "Please enter a first name";
  		String msg4 = "Must be text only" + "\n" + "Please enter a first name" + "\n" + "Must be between 2 and 30 characters";
  		String msg5 = "Must be between 2 and 30 characters" + "\n" + "Please enter a first name" + "\n" + "Must be text only";
  		String msg6 = "Must be between 2 and 30 characters" + "\n" + "Must be text only" + "\n" + "Please enter a first name";
  		
  		String msg7 = "Please enter a surname" + "\n" + "Must be text only" + "\n" + "Must be between 2 and 30 characters";
  		String msg8 = "Please enter a surname" + "\n" + "Must be between 2 and 30 characters" + "\n" + "Must be text only";
  		String msg9 = "Must be text only" + "\n" + "Must be between 2 and 30 characters" + "\n" + "Please enter a surname";
  		String msg10 = "Must be text only" + "\n" + "Please enter a surname" + "\n" + "Must be between 2 and 30 characters";
  		String msg11 = "Must be between 2 and 30 characters" + "\n" + "Please enter a surname" + "\n" + "Must be text only";
  		String msg12 = "Must be between 2 and 30 characters" + "\n" + "Must be text only" + "\n" + "Please enter a surname";
  		
  		
  		/* Name */
  		createNewCustomerDetails.Name.clear();
  		
  		/* SurName */
     	createNewCustomerDetails.SurName.clear();
     	
     	// click save customer button
     	WebElement element2 = driver.findElement(By.id("savecustomer"));
	    JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	    executor2.executeScript("arguments[0].click()", element2);
  		
  		
  		// title error message
  		WebElement field0 = driver.findElement(By.xpath("  	//*[@id='form']/form/div[3]/div[1]/div[1]/span"));
  		String message0  = field0.getText();
     	System.out.println("title_message err rmsg........... " + message0);
     	assertEquals("Error: Title err msg not correct! ", message0, msg0);
     	
     // first name error message
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[1]/span[1]/div/span"));
  		String message1  = field1.getText();
  		System.out.println("name err rmsg........... " + message1);
  		if (message1.equals(msg1)) {
	 		
  	     	assertEquals("Error: Name err msg not correct! ", message1, msg1);
	 	}
     	else if (message1.equals(msg2)) {
	 		
         	assertEquals("Error: Name err msg not correct! ", message1, msg2);

	 	}
     	else if (message1.equals(msg3)) {
	 		
         	assertEquals("Error: Name err msg not correct! ", message1, msg3);

	 	}
     	else if (message1.equals(msg4)) {
		
     		assertEquals("Error: Name err msg not correct! ", message1, msg4);

     	}
     	else if (message1.equals(msg5)) {
		
     		assertEquals("Error: Name err msg not correct! ", message1, msg5);

     	}
     	else if (message1.equals(msg6)) {
		
     		assertEquals("Error: Name err msg not correct! ", message1, msg6);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Name err rmsg!!");
	 	
	 	}
  		
     	
     	// surname error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[1]/span[2]/div/span"));
  		String message2  = field2.getText();
  		System.out.println("surname_message err rmsg........... " + message2);
  		if (message2.equals(msg7)) {
	 		
  	     	assertEquals("Error: Name err msg not correct! ", message2, msg7);
	 	}
     	else if (message2.equals(msg8)) {
	 		
         	assertEquals("Error: Name err msg not correct! ", message2, msg8);

	 	}
     	else if (message2.equals(msg9)) {
	 		
         	assertEquals("Error: Name err msg not correct! ", message2, msg9);

	 	}
     	else if (message2.equals(msg10)) {
		
     		assertEquals("Error: Name err msg not correct! ", message2, msg10);

     	}
     	else if (message2.equals(msg11)) {
		
     		assertEquals("Error: Name err msg not correct! ", message2, msg11);

     	}
     	else if (message2.equals(msg12)) {
		
     		assertEquals("Error: Name err msg not correct! ", message2, msg12);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Surname err rmsg!!");
	 	
	 	}
     	

	}
  	
  	
  	
  	@Then("^I send and verify empty details for edit customer details$")
	public void EmptyEditCustomerByCustomerDetails() throws IOException {
  		  		
  		String msg1 = "Please enter a first name" + "\n" + "Must be text only" + "\n" + "Must be between 2 and 30 characters";
  		String msg2 = "Please enter a first name" + "\n" + "Must be between 2 and 30 characters" + "\n" + "Must be text only";
  		String msg3 = "Must be text only" + "\n" + "Must be between 2 and 30 characters" + "\n" + "Please enter a first name";
  		String msg4 = "Must be text only" + "\n" + "Please enter a first name" + "\n" + "Must be between 2 and 30 characters";
  		String msg5 = "Must be between 2 and 30 characters" + "Please enter a first name" + "\n" + "Must be text only";
  		String msg6 = "Must be between 2 and 30 characters" + "\n" + "Must be text only" + "\n" + "Please enter a first name";
  		
  		String msg7 = "Please enter a surname" + "\n" + "Must be text only" + "\n" + "Must be between 2 and 30 characters";
  		String msg8 = "Please enter a surname" + "\n" + "Must be between 2 and 30 characters" + "\n" + "Must be text only";
  		String msg9 = "Must be text only" + "\n" + "Must be between 2 and 30 characters" + "\n" + "Please enter a surname";
  		String msg10 = "Must be text only" + "\n" + "Please enter a surname" + "\n" + "Must be between 2 and 30 characters";
  		String msg11 = "Must be between 2 and 30 characters" + "\n" + "Please enter a surname" + "\n" + "Must be text only";
  		String msg12 = "Must be between 2 and 30 characters" + "\n" + "Must be text only" + "\n" + "Please enter a surname";

  		testBase.Wait(5);
  		
  		/* Name */
  		createNewCustomerDetails.Name.clear();
  		
  		/* SurName */
     	createNewCustomerDetails.SurName.clear();
     	
     	// click save customer button
     	WebElement element2 = driver.findElement(By.id("savecustomer"));
	    JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	    executor2.executeScript("arguments[0].click()", element2);

	    testBase.Wait(5);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
  		// first name error message
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[1]/span[1]/div/span"));
  		String message1  = field1.getText();
  		System.out.println("first name err rmsg........... " + message1);
  		testBase.Wait(2);
  		if (message1.equals(msg1)) {
	 		
  	     	assertEquals("Error: Name err msg not correct! ", message1, msg1);
	 	}
     	else if (message1.equals(msg2)) {
	 		
         	assertEquals("Error: Name err msg not correct! ", message1, msg2);

	 	}
     	else if (message1.equals(msg3)) {
	 		
         	assertEquals("Error: Name err msg not correct! ", message1, msg3);

	 	}
     	else if (message1.equals(msg4)) {
		
     		assertEquals("Error: Name err msg not correct! ", message1, msg4);

     	}
     	else if (message1.equals(msg5)) {
		
     		assertEquals("Error: Name err msg not correct! ", message1, msg5);

     	}
     	else if (message1.equals(msg6)) {
		
     		assertEquals("Error: Name err msg not correct! ", message1, msg6);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Name err rmsg!!");
	 	
	 	}
  		
     	
     	// surname error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[1]/span[2]/div/span"));
  		String message2  = field2.getText();
  		System.out.println("surname_message err rmsg........... " + message2);
  		if (message2.equals(msg7)) {
	 		
  	     	assertEquals("Error: Name err msg not correct! ", message2, msg7);
	 	}
     	else if (message2.equals(msg8)) {
	 		
         	assertEquals("Error: Name err msg not correct! ", message2, msg8);

	 	}
     	else if (message2.equals(msg9)) {
	 		
         	assertEquals("Error: Name err msg not correct! ", message2, msg9);

	 	}
     	else if (message2.equals(msg10)) {
		
     		assertEquals("Error: Name err msg not correct! ", message2, msg10);

     	}
     	else if (message2.equals(msg11)) {
		
     		assertEquals("Error: Name err msg not correct! ", message2, msg11);

     	}
     	else if (message2.equals(msg12)) {
		
     		assertEquals("Error: Name err msg not correct! ", message2, msg12);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Surname err rmsg!!");
	 	
	 	}
     	
  	}
  	
  	
  	@Then("^I send and verify error message '(.+)' for customer details$")  
	public void VerifyErrMSgNewCustomerByCustomerDetails(String validationtext)throws IOException {
  		
  		String msg0 = "Must be text only";
  		String msg1 = "Must be between 2 and 30 characters";
  			
  		/* Name */
  		createNewCustomerDetails.Name.clear();
  		createNewCustomerDetails.Name.sendKeys(validationtext);
  		
  		/* SurName */
     	createNewCustomerDetails.SurName.clear();
     	createNewCustomerDetails.SurName.sendKeys(validationtext);
     	
     	/* click save customer button */
  		createNewCustomerDetails.saveNewCustomer.click();
  		
  		// first name error message
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[1]/span[1]/div/span"));
  		String message1  = field1.getText();
  		
  		if (message1.equals(msg0)) {
	 		
  	     	assertEquals("Error: Name err msg not correct! ", message1, msg0);
	 	}
     	else if (message1.equals(msg1)) {
	 		
         	assertEquals("Error: Name err msg not correct! ", message1, msg1);

	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Name err rmsg!!");
	 	
	 	}


     	// surname error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[1]/span[2]/div/span"));
  		String message2  = field2.getText();
  		if (message2.equals(msg0)) {
	 		
  	     	assertEquals("Error: Name err msg not correct! ", message2, msg0);
	 	}
     	else if (message2.equals(msg1)) {
	 		
         	assertEquals("Error: Name err msg not correct! ", message2, msg1);

	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Surname err rmsg!!");
	 	
	 	}
  		
  	}

  	
  	
  	
  	
 	@Then("^I send and verify dob '(.+)' for customer details$")  
	public void VerifyDOBErrMSgNewCustomerByCustomerDetails(String text)throws IOException {
  		
  		String msg0 = "Invalid date of birth format.";
  			
  		/* DOB */
  		createNewCustomerDetails.DOB.clear();
  		createNewCustomerDetails.DOB.sendKeys(text);
  		
     	/* click save customer button */
     	WebElement element1 = driver.findElement(By.id("savecustomer"));
     	JavascriptExecutor executor1 = (JavascriptExecutor)driver;
     	executor1.executeScript("arguments[0].click()", element1);
  		
  		// DOB error message
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[1]/span[3]/div/span"));
  		String message1  = field1.getText();
  		
  		if (message1.equals(msg0)) {
	 		
  	     	assertEquals("Error: DOB err msg not correct! ", message1, msg0);
	 	}
     	else 
     	{
     		throw new IOException("NOT VALID DOB err rmsg!!");
	 	
	 	}

  		
  	}

 	
 	
  	
  	@Then("^I send and verify incorrect details '(.+)' and '(.+)' for customer details$")
	public void IncorrectCustomerByCustomerDetails(String validationtext, String msg) {
  		
  		/* Name */
  		createNewCustomerDetails.Name.clear();
  		createNewCustomerDetails.Name.sendKeys(validationtext);
  		createNewCustomerDetails.saveNewCustomer.click();
  		
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[1]/span[1]/div/span"));
  		String name_message  = field1.getText();
  		
//  	JavascriptExecutor js1 = (JavascriptExecutor) driver;
//     	WebElement field1 = driver.findElement(By.id("c_name"));
//     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
//     	String name_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
     	
     	System.out.println("name_message err rmsg........... " + name_message);
     	
     	assertEquals("Error: Name err msg not correct! ", name_message, "Please match the format requested.");
     	
     	createNewCustomerDetails.Name.clear();
     	createNewCustomerDetails.Name.sendKeys("test" + Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num));
  	    
     	/* SurName */
     	createNewCustomerDetails.SurName.clear();
     	createNewCustomerDetails.SurName.sendKeys(validationtext);
  		createNewCustomerDetails.saveNewCustomer.click();
  		
  		JavascriptExecutor js2 = (JavascriptExecutor) driver;
     	WebElement field2 = driver.findElement(By.id("lastName"));
     	Boolean is_valid2 = (Boolean)js2.executeScript("return arguments[0].checkValidity();", field2);
     	String surname_message = (String)js2.executeScript("return arguments[0].validationMessage;", field2);
     	System.out.println("surname_message err rmsg........... " + surname_message);
     	
     	assertEquals("Error: Surname err msg not correct! ", surname_message, "Please match the format requested.");
     	
     	createNewCustomerDetails.SurName.clear();
     	createNewCustomerDetails.SurName.sendKeys("test" + Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num));
  	    
     	
     	/* DOB */
     	createNewCustomerDetails.DOB.clear();
     	createNewCustomerDetails.DOB.sendKeys(validationtext);
  		createNewCustomerDetails.saveNewCustomer.click();
  		
  		JavascriptExecutor js3 = (JavascriptExecutor) driver;
     	WebElement field3 = driver.findElement(By.id("dob"));
     	Boolean is_valid3 = (Boolean)js3.executeScript("return arguments[0].checkValidity();", field3);
     	String dob_message = (String)js3.executeScript("return arguments[0].validationMessage;", field3);
     	System.out.println("surname_message err rmsg........... " + dob_message);
     	
     	assertEquals("Error: DOB err msg not correct! ", dob_message, "Please match the format requested.");
     	
     	
     	createNewCustomerDetails.DOB.clear();
    	createNewCustomerDetails.DOB.sendKeys("10/11/1988");

	}
  	

  	
  	
  	@Then("^I send and verify Blank details for address details$")
	public void BlankDetailsCustomerByAddressDetails() throws IOException {
  		
  		String addr1_msg1 = "Must be between 2 and 50 characters" + "\n" + "Please enter address line 1";
  		String addr1_msg2 = "Please enter address line 1" + "\n" + "Must be between 2 and 50 characters";
  		
  		String addr2_msg1 = "Please enter a postcode" + "\n" + "Must be between 4 and 8 characters";
  		String addr2_msg2 = "Must be between 4 and 8 characters" + "\n" + "Please enter a postcode";
  		
  		
  		/* Address 1 */
  		createNewCustomerDetails.AddrLine1.clear();
  		
  		/* Address 2 */
     	createNewCustomerDetails.AddrLine2.clear();
     	
  		/* Town */
     	createNewCustomerDetails.TownCity.clear();
     	
  		/* Postcode */
     	createNewCustomerDetails.Postcode.clear();
     	
     	WebElement element1 = driver.findElement(By.id("savecustomer"));
     	JavascriptExecutor executor1 = (JavascriptExecutor)driver;
     	executor1.executeScript("arguments[0].click()", element1);
   	 
  		
  	
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[4]/div/div[1]/div/span"));
  		String message1  = field1.getText();
  		if (message1.equals(addr1_msg1)) {
	 		
  			assertEquals("Error: Address1 err msg not correct! ", message1, addr1_msg1);
	 	}
     	else if (message1.equals(addr1_msg2)) {

         	assertEquals("Error: Address1 err msg not correct! ", message1, addr1_msg2);

	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Address1 err rmsg!!");
	 	
	 	} 
  		
  		
  		
  		WebElement field2 = driver.findElement(By.xpath("//*[@id='form']/form/div[4]/div/div[4]/div/span"));
  		String message2  = field2.getText();
  		if (message2.equals(addr2_msg1)) {
	 		
  			assertEquals("Error: Address1 err msg not correct! ", message2, addr2_msg1);
	 	}
     	else if (message2.equals(addr2_msg2)) {

         	assertEquals("Error: Address1 err msg not correct! ", message2, addr2_msg2);

	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Address2 err rmsg!!");
	 	
	 	}

	}
  	
  	
  	
  	
 	@Then("^I send and verify error message for address1 '(.+)' for address details$")
	public void ErrorMessageCustomerByAddress1Details(String text) throws IOException {
  		
  		String err_msg1 = "Contains an invalid character";
  		String err_msg2 = "Must be between 2 and 50 characters";
  		
  		/* Address 1 */
  		createNewCustomerDetails.AddrLine1.clear();
  		createNewCustomerDetails.AddrLine1.sendKeys(text);
     	
     	WebElement element1 = driver.findElement(By.id("savecustomer"));
     	JavascriptExecutor executor1 = (JavascriptExecutor)driver;
     	executor1.executeScript("arguments[0].click()", element1);
   	 
     	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  	
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[4]/div/div[1]/div/span"));
  		String message1  = field1.getText();
  		System.out.println("AddrLine1 err rmsg........... " + message1);
  		if (message1.equals(err_msg1)) {
	 		
  			assertEquals("Error: Address1 err msg not correct! ", message1, err_msg1);
	 	}
  		else if (message1.equals(err_msg2)) {
	 		
  			assertEquals("Error: Address1 err msg not correct! ", message1, err_msg2);
	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Address1 err rmsg!!");
	 	
	 	}

	}
  	
  	
 	@Then("^I send and verify error message for address2 '(.+)' for address details$")
	public void ErrorMessageCustomerByAddress2Details(String text) throws IOException {
  		
  		String err_msg1 = "Contains an invalid character";
  		String err_msg2 = "Must not exceed 50 characters";
  		
  		/* Address 2 */
  		createNewCustomerDetails.AddrLine2.clear();
  		createNewCustomerDetails.AddrLine2.sendKeys(text);
     	
     	WebElement element1 = driver.findElement(By.id("savecustomer"));
     	JavascriptExecutor executor1 = (JavascriptExecutor)driver;
     	executor1.executeScript("arguments[0].click()", element1);
   	 
     	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  	
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[4]/div/div[2]/div/span"));
  		String message1  = field1.getText();
  		System.out.println("AddrLine2 err rmsg........... " + message1);
  		if (message1.equals(err_msg1)) {
	 		
  			assertEquals("Error: Address2 err msg not correct! ", message1, err_msg1);
	 	}
  		else if (message1.equals(err_msg2)) {
	 		
  			assertEquals("Error: Address2 err msg not correct! ", message1, err_msg2);
	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Address2 err rmsg!!");
	 	
	 	}

	}
  	
 	
 	@Then("^I send and verify error message for town '(.+)' for address details$")
	public void ErrorMessageCustomerByTownDetails(String text) throws IOException {
  		
  		String err_msg1 = "Contains an invalid character";
  		String err_msg2 = "Must not exceed 50 characters";
  		
  		/* TownCity */
  		createNewCustomerDetails.TownCity.clear();
  		createNewCustomerDetails.TownCity.sendKeys(text);
     	
     	WebElement element1 = driver.findElement(By.id("savecustomer"));
     	JavascriptExecutor executor1 = (JavascriptExecutor)driver;
     	executor1.executeScript("arguments[0].click()", element1);
   	 
     	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  	
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[4]/div/div[3]/div/span"));
  		String message1  = field1.getText();
  		System.out.println("TownCity err rmsg........... " + message1);
  		if (message1.equals(err_msg1)) {
	 		
  			assertEquals("Error: TownCity err msg not correct! ", message1, err_msg1);
	 	}
  		else if (message1.equals(err_msg2)) {
	 		
  			assertEquals("Error: TownCity err msg not correct! ", message1, err_msg2);
	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Address1 err rmsg!!");
	 	
	 	}

	}

 	
 	@Then("^I send and verify error message for postcode '(.+)' for address details$")
	public void ErrorMessageCustomerByPostcodeDetails(String text) throws IOException {
  		
  		String err_msg1 = "Must contain only letters and numbers" + "\n" + "Must be between 4 and 8 characters";
  		String err_msg2 = "Must contain only letters and numbers";
  		String err_msg3 = "Must be between 4 and 8 characters";
  		String err_msg4 = "Must be between 4 and 8 characters" + "\n" +  "Must contain only letters and numbers";
  		
  		/* Postcode */
  		createNewCustomerDetails.Postcode.clear();
  		createNewCustomerDetails.Postcode.sendKeys(text);
     	
     	WebElement element1 = driver.findElement(By.id("savecustomer"));
     	JavascriptExecutor executor1 = (JavascriptExecutor)driver;
     	executor1.executeScript("arguments[0].click()", element1);
   	 
     	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  	
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[4]/div/div[4]/div/span"));
  		String message1  = field1.getText();
  		System.out.println("Postcode err rmsg........... " + message1);
  		if (message1.equals(err_msg1)) {
	 		
  			assertEquals("Error: Postcode err msg not correct! ", message1, err_msg1);
	 	}
  		else if (message1.equals(err_msg2)) {
	 		
  			assertEquals("Error: Postcode err msg not correct! ", message1, err_msg2);
	 	}
  		else if (message1.equals(err_msg3)) {
	 		
  			assertEquals("Error: Postcode err msg not correct! ", message1, err_msg3);
	 	}
  		else if (message1.equals(err_msg4)) {
	 		
  			assertEquals("Error: Postcode err msg not correct! ", message1, err_msg4);
	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Postcode err rmsg!!");
	 	
	 	}

	}
  	
//  	@Then("^I send and verify error message for address1 '(.+)' for address details$")
//	public void ErrorMessageCustomerByAddress1Details(String text) throws IOException {
//  		
//  		String err_msg1 = "Contains an invalid character";
//  		String err_msg2 = "Must contain only letters and numbers";
//  		
//  		
//  		/* Address 1 */
//  		createNewCustomerDetails.AddrLine1.clear();
//  		createNewCustomerDetails.AddrLine1.sendKeys(text);
//  		
//  		/* Address 2 */
//     	createNewCustomerDetails.AddrLine2.clear();
//  		createNewCustomerDetails.AddrLine2.sendKeys(text);
//     	
//  		/* Town */
//     	createNewCustomerDetails.TownCity.clear();
//  		createNewCustomerDetails.TownCity.sendKeys(text);
//     	
//  		/* Postcode */
//     	createNewCustomerDetails.Postcode.clear();
//  		createNewCustomerDetails.Postcode.sendKeys(text);
//     	
//     	WebElement element1 = driver.findElement(By.id("savecustomer"));
//     	JavascriptExecutor executor1 = (JavascriptExecutor)driver;
//     	executor1.executeScript("arguments[0].click()", element1);
//   	 
//  		
//  	
//  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[4]/div/div[1]/div/span"));
//  		String message1  = field1.getText();
//  		if (message1.equals(err_msg1)) {
//	 		
//  			assertEquals("Error: Address1 err msg not correct! ", message1, addr1_msg1);
//	 	}
//     	else 
//     	{
//     		throw new IOException("NOT VALID Address1 err rmsg!!");
//	 	
//	 	} 
//  		
//  		
//  		
//  		WebElement field2 = driver.findElement(By.xpath("//*[@id='form']/form/div[4]/div/div[4]/div/span"));
//  		String message2  = field2.getText();
//  		if (message2.equals(err_msg2)) {
//	 		
//  			assertEquals("Error: Address1 err msg not correct! ", message2, addr2_msg1);
//	 	}
//     	else if (message2.equals(addr2_msg2)) {
//
//         	assertEquals("Error: Address1 err msg not correct! ", message2, addr2_msg2);
//
//	 	}
//     	else 
//     	{
//     		throw new IOException("NOT VALID Address2 err rmsg!!");
//	 	
//	 	}
//
//	}
  	
  	
  	
  	
  	
  	
  	
  	@Then("^I send and verify incorrect details '(.+)' for address details$")
	public void IncorrectCustomerByAddressDetails(String validationtext) {
  		
  		/* Address 1 */
  		createNewCustomerDetails.AddrLine1.clear();
  		createNewCustomerDetails.AddrLine1.sendKeys(validationtext);
  		createNewCustomerDetails.saveNewCustomer.click();
  		
  		JavascriptExecutor js1 = (JavascriptExecutor) driver;
     	WebElement field1 = driver.findElement(By.id("addressLine1"));
     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
     	String addr1_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
     	System.out.println("addr1_message err rmsg........... " + addr1_message);
     	
     	assertEquals("Error: Address1 err msg not correct! ", addr1_message, "Please match the format requested.");
     	
     	createNewCustomerDetails.AddrLine1.clear();
     	createNewCustomerDetails.AddrLine1.sendKeys(Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha));
  	    
     	
  		/* Address 2 */
     	createNewCustomerDetails.AddrLine2.clear();
  		createNewCustomerDetails.AddrLine2.sendKeys(validationtext);
  		createNewCustomerDetails.saveNewCustomer.click();
  		
  		JavascriptExecutor js2 = (JavascriptExecutor) driver;
     	WebElement field2 = driver.findElement(By.id("addressLine2"));
     	Boolean is_valid2 = (Boolean)js2.executeScript("return arguments[0].checkValidity();", field2);
     	String addr2_message = (String)js2.executeScript("return arguments[0].validationMessage;", field2);
     	System.out.println("addr2_message err rmsg........... " + addr2_message);
     	
     	assertEquals("Error: Address2 err msg not correct! ", addr2_message, "Please match the format requested.");
     	
     	createNewCustomerDetails.AddrLine2.clear();
     	createNewCustomerDetails.AddrLine2.sendKeys(Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha));
  	   
     	
  		/* Town */
     	createNewCustomerDetails.TownCity.clear();
  		createNewCustomerDetails.TownCity.sendKeys(validationtext);
  		createNewCustomerDetails.saveNewCustomer.click();
  		
  		JavascriptExecutor js3 = (JavascriptExecutor) driver;
     	WebElement field3 = driver.findElement(By.id("addressLine3"));
     	Boolean is_valid3 = (Boolean)js3.executeScript("return arguments[0].checkValidity();", field3);
     	String addr3_message = (String)js3.executeScript("return arguments[0].validationMessage;", field3);
     	System.out.println("addr3_message err rmsg........... " + addr3_message);
     	
     	assertEquals("Error: Address3 err msg not correct! ", addr3_message, "Please match the format requested.");
     	
     	createNewCustomerDetails.TownCity.clear();
     	createNewCustomerDetails.TownCity.sendKeys(Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha));

     	
  		/* Postcode */
     	createNewCustomerDetails.Postcode.clear();
  		createNewCustomerDetails.Postcode.sendKeys(validationtext);
  		createNewCustomerDetails.saveNewCustomer.click();
  		
  		JavascriptExecutor js4 = (JavascriptExecutor) driver;
     	WebElement field4 = driver.findElement(By.id("postcode"));
     	Boolean is_valid4 = (Boolean)js4.executeScript("return arguments[0].checkValidity();", field4);
     	String addr4_message = (String)js4.executeScript("return arguments[0].validationMessage;", field4);
     	System.out.println("addr4_message err rmsg........... " + addr4_message);
     	
     	assertEquals("Error: Address4 err msg not correct! ", addr4_message, "Please match the format requested.");
     	
     	createNewCustomerDetails.Postcode.clear();
     	createNewCustomerDetails.Postcode.sendKeys(Utilities.getRandomPostCode(Utilities.PostCodeCountry.Durham));

 
	}
  	
  	
  	
	@Then("^I send and verify blank details for User Management$")
	public void BlankCreateUserUserMgtDetails() throws IOException {
		
  		String err_msg1 = "Must be a 5 letter cypher" + "\n" + "Must be made up of five letters" + "\n" + "Please enter a username";
  		String err_msg2 = "Must be a 5 letter cypher" + "\n" + "Please enter a username" + "\n" + "Must be made up of five letters";
  		String err_msg3 = "Please enter a username" + "\n" + "Must be a 5 letter cypher" + "\n" + "Must be made up of five letters";
  		String err_msg4 = "Please enter a username" + "\n" + "Must be made up of five letters" + "\n" + "Must be a 5 letter cypher";
  		String err_msg5 = "Must be made up of five letters" + "\n" + "Please enter a username" + "\n" + "Must be a 5 letter cypher";
  		String err_msg6 = "Must be made up of five letters" + "\n" + "Must be a 5 letter cypher" + "\n" + "Please enter a username";
  		
  		
  		String err_msg7 = "Must be between 8 and 10 characters" + "\n" + "Please enter a password" + "\n" + "Must contain upper, lower case characters and a number";
  		String err_msg8 = "Must be between 8 and 10 characters" + "\n" + "Must contain upper, lower case characters and a number" + "\n" + "Please enter a password";		
  		String err_msg9 = "Please enter a password" + "\n" + "Must be between 8 and 10 characters" + "\n" + "Must contain upper, lower case characters and a number";
  		String err_msg10 = "Please enter a password" + "\n" + "Must contain upper, lower case characters and a number" + "\n" + "Must be between 8 and 10 characters";  		
  		String err_msg11 = "Must contain upper, lower case characters and a number" + "\n" + "Please enter a password" + "\n" + "Must be between 8 and 10 characters";
  		String err_msg12 = "Must contain upper, lower case characters and a number" + "\n" + "Must be between 8 and 10 characters" + "\n" + "Please enter a password";
  		
  		
  		String err_msg13 = "You must enter an email address";
  		
  		String err_msg14 = "Please select if the account is enabled";
  		

  		/* Username */
  		createNewUserDetails.Username.clear();
  		createNewUserDetails.Username.sendKeys("");
  		
  		/* Password */
		createNewUserDetails.Username.clear();
		createNewUserDetails.Username.sendKeys("");
		
		/* Email */
		createNewUserDetails.Username.clear();
		createNewUserDetails.Username.sendKeys("");
  		

     	/* click save button */
     	WebElement element1 = driver.findElement(By.className("button"));
     	JavascriptExecutor executor1 = (JavascriptExecutor)driver;
     	executor1.executeScript("arguments[0].click()", element1);
   	 
     	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  	
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='submitpage']/div/div/div[2]/form/div[2]/div[1]/div[1]/div/p"));
  		String message1  = field1.getText();
  		System.out.println("Username err rmsg........... " + message1);
  		if (message1.equals(err_msg1)) {
	 		
  			assertEquals("Error: Username err msg not correct! ", message1, err_msg1);
	 	}
  		else if (message1.equals(err_msg2)) {
	 		
  			assertEquals("Error: Username err msg not correct! ", message1, err_msg2);
	 	}
  		else if (message1.equals(err_msg3)) {
	 		
  			assertEquals("Error: Username err msg not correct! ", message1, err_msg3);
	 	}
  		else if (message1.equals(err_msg4)) {
	 		
  			assertEquals("Error: Username err msg not correct! ", message1, err_msg4);
	 	}
  		else if (message1.equals(err_msg5)) {
	 		
  			assertEquals("Error: Username err msg not correct! ", message1, err_msg5);
	 	}
  		else if (message1.equals(err_msg6)) {
	 		
  			assertEquals("Error: Username err msg not correct! ", message1, err_msg6);
	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Username err rmsg!!");
	 	
	 	}

  		
  		
  		
  		WebElement field2 = driver.findElement(By.xpath("//*[@id='submitpage']/div/div/div[2]/form/div[2]/div[1]/div[2]/div/p"));
  		String message2  = field2.getText();
  		System.out.println("Password err rmsg........... " + message2);
  		if (message2.equals(err_msg7)) {
	 		
  			assertEquals("Error: Password err msg not correct! ", message2, err_msg7);
	 	}
  		else if (message2.equals(err_msg8)) {
	 		
  			assertEquals("Error: Password err msg not correct! ", message2, err_msg8);
	 	}
  		else if (message2.equals(err_msg9)) {
	 		
  			assertEquals("Error: Password err msg not correct! ", message2, err_msg9);
	 	}
  		else if (message2.equals(err_msg10)) {
	 		
  			assertEquals("Error: Password err msg not correct! ", message2, err_msg10);
	 	}
  		else if (message2.equals(err_msg11)) {
	 		
  			assertEquals("Error: Password err msg not correct! ", message2, err_msg11);
	 	}
  		else if (message2.equals(err_msg12)) {
	 		
  			assertEquals("Error: Password err msg not correct! ", message2, err_msg12);
	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Password err rmsg!!");
	 	
	 	}
  		
  		
  	
  		WebElement field3 = driver.findElement(By.xpath("//*[@id='submitpage']/div/div/div[2]/form/div[2]/div[1]/div[3]/div/p"));
  		String message3  = field3.getText();
  		System.out.println("Email Address err rmsg........... " + message3);
  		if (message3.equals(err_msg13)) {
	 		
  			assertEquals("Error: Email Address err msg not correct! ", message3, err_msg13);
	 	}
  		else 
     	{
     		throw new IOException("NOT VALID Email Address err rmsg!!");
	 	
	 	}
  		
  		
  		WebElement field4 = driver.findElement(By.xpath("//*[@id='submitpage']/div/div/div[2]/form/div[2]/div[2]/div[2]/div/p"));
  		String message4  = field4.getText();
  		System.out.println("Account Enabled err rmsg........... " + message4);
  		if (message4.equals(err_msg14)) {
	 		
  			assertEquals("Error: Account Enabled err msg not correct! ", message4, err_msg14);
	 	}
  		else 
     	{
     		throw new IOException("NOT VALID Account Enabled err rmsg!!");
	 	
	 	}
  		
//		/* User Name */
//		createNewUserDetails.Username.clear();a
//		createNewUserDetails.Username.sendKeys("");
//		createNewUserDetails.SaveUserButton.click();
//  		
//  		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//     	WebElement field1 = driver.findElement(By.id("username"));
//     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
//     	String name_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
//     	System.out.println("username_message err rmsg........... " + name_message);
//     	
//     	if (name_message.equals("Please fill out this field.")) {
//     		
//     		assertEquals("Error: UserName err msg not correct! ", name_message, "Please fill out this field.");
//     	}
//     	else {
//     	assertEquals("Error: UserName err msg not correct! ", name_message, "Please fill in this field.");
//     	
//     	}
//  	
//  	
//	  	/* Password */
//		createNewUserDetails.Username.clear();
//		createNewUserDetails.Username.sendKeys("testy");
//		createNewUserDetails.Password.clear();
//		createNewUserDetails.Password.sendKeys("");
//		createNewUserDetails.SaveUserButton.click();
//			
//		JavascriptExecutor js2 = (JavascriptExecutor) driver;
//	 	WebElement field2 = driver.findElement(By.id("password"));
//	 	Boolean is_valid2 = (Boolean)js2.executeScript("return arguments[0].checkValidity();", field2);
//	 	String pwd_message = (String)js2.executeScript("return arguments[0].validationMessage;", field2);
//	 	System.out.println("password_message err rmsg........... " + pwd_message);
//	 	
//	 	if (pwd_message.equals("Please fill out this field.")) {
//	 		
//	 		assertEquals("Error: Password err msg not correct! ", pwd_message, "Please fill out this field.");
//	 	}
//	 	else {
//	 	assertEquals("Error: Password err msg not correct! ", pwd_message, "Please fill in this field.");
//	 	
//	 	}
//	 	
//
//	 	/* Email */
//		createNewUserDetails.Username.clear();
//		createNewUserDetails.Username.sendKeys("testy");
//		createNewUserDetails.Password.clear();
//		createNewUserDetails.Password.sendKeys("Password1");
//		createNewUserDetails.EmailAddress.clear();
//		createNewUserDetails.EmailAddress.sendKeys("");
//		createNewUserDetails.SaveUserButton.click();
//  		
//  		JavascriptExecutor js3 = (JavascriptExecutor) driver;
//     	WebElement field3 = driver.findElement(By.id("u_email"));
//     	Boolean is_valid3 = (Boolean)js3.executeScript("return arguments[0].checkValidity();", field3);
//     	String email_message = (String)js3.executeScript("return arguments[0].validationMessage;", field3);
//     	System.out.println("email_message err rmsg........... " + email_message);
//     	
//     	if (email_message.equals("Please fill out this field.")) {
//	 		
//	 		assertEquals("Error: Email err msg not correct! ", email_message, "Please fill out this field.");
//	 	}
//	 	else {
//	 	assertEquals("Error: Email err msg not correct! ", email_message, "Please fill in this field.");
//	 	
//	 	}
     	
	}	
	

	
	@Then("^I send and verify incorrect details '(.*)' for User Management Username$")
	public void IncorrectUserMgtDetailsUsername(String validationtext) throws IOException {
  		
		/* User Name */
		createNewUserDetails.Username.clear();
		createNewUserDetails.Username.sendKeys(validationtext);
		createNewUserDetails.SaveUserButton.click();
		
		String name_message = driver.findElement(By.xpath("//*[@id='content']/form/div[3]/div/span[1]/div")).getText();

     	System.out.println("username_message err rmsg........... " + name_message);
     		
     	String msg1 = "Must be made up of five letters";
     	
     	String msg2 = "Must be a 5 letter cypher" + "\n" + "Must be made up of five letters";
     	String msg3 = "Must be made up of five letters" + "\n" + "Must be a 5 letter cypher";
     	
     	String msg4 = "Must be made up of five letters" + "\n" + "Must be a 5 letter cypher" + "\n" + "Please enter a username";
     	String msg5 = "Must be made up of five letters" + "\n" + "Please enter a username" + "\n" + "Must be a 5 letter cypher";
     	String msg6 = "Must be a 5 letter cypher" + "\n" + "Must be made up of five letters" + "\n" + "Please enter a username";
     	String msg7 = "Must be a 5 letter cypher" + "\n" + "Please enter a username" + "\n" + "Must be made up of five letters";   	     	
     	String msg8 = "Please enter a username" + "\n" + "Must be a 5 letter cypher" + "\n" + "Must be made up of five letters";
     	String msg9 = "Please enter a username" + "\n" + "Must be made up of five letters" + "\n" + "Must be a 5 letter cypher";
     	
     	String msg10 = "Must be a 5 letter cypher";
     	
     	if (name_message.equals(msg1)) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", name_message, msg1);
	 	}
     	else if (name_message.equals(msg2)) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", name_message, msg2);

	 	}
     	else if (name_message.equals(msg3)) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", name_message, msg3);
     		
	 	}
     	else if (name_message.equals(msg4)) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", name_message, msg4);
	 	}  
     	else if (name_message.equals(msg5)) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", name_message, msg5);

	 	}
     	else if (name_message.equals(msg6)) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", name_message, msg6);
     		
	 	}
     	else if (name_message.equals(msg7)) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", name_message, msg7);
	 	}   
     	else if (name_message.equals(msg8)) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", name_message, msg8);
     		
	 	}
     	else if (name_message.equals(msg9)) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", name_message, msg9);
	 	}   
     	else if (name_message.equals(msg10)) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", name_message, msg10);
	 	}  
     	else 
     	{
     		throw new IOException("NOT VALID Username err rmsg!!");
	 	
	 	}

	}	
	
	
	
	@Then("^I send and verify incorrect details '(.*)' for User Management Password$")
	public void IncorrectUserMgtDetailsPassword(String validationtext ) throws IOException {
  		
		/* Password */
		createNewUserDetails.Username.clear();
		createNewUserDetails.Username.sendKeys("testy");
		createNewUserDetails.Password.clear();
		createNewUserDetails.Password.sendKeys(validationtext);
		createNewUserDetails.SaveUserButton.click();
		
		String name_message = driver.findElement(By.xpath("//*[@id='content']/form/div[3]/div/span[2]/div/p")).getText();
		
     	System.out.println("Password_message err rmsg........... " + name_message);
     		
     	String msg1 = "Must contain upper, lower case characters and a number";
     	
     	String msg2 = "Must contain upper, lower case characters and a number"  + "\n" + "Must be between 8 and 10 characters";
     	String msg3 = "Must be between 8 and 10 characters" + "\n" + "Must contain upper, lower case characters and a number";
     	
     	String msg4 = "Must be between 8 and 10 characters";
     	
     	String msg5 = "Must be between 8 and 10 characters" + "\n" + "Must contain upper, lower case characters and a number" + "\n" + "Please enter a password";
     	String msg6 = "Must be between 8 and 10 characters" + "\n" + "Please enter a password" + "\n" + "Must contain upper, lower case characters and a number";
     	
     	String msg7 = "Must contain upper, lower case characters and a number" + "\n" + "Must be between 8 and 10 characters" + "\n" + "Please enter a password";
     	String msg8 = "Must contain upper, lower case characters and a number" + "\n" + "Please enter a password" + "\n" + "Must be between 8 and 10 characters";
     	
     	String msg9 = "Please enter a password" + "\n" + "Must contain upper, lower case characters and a number" + "\n" + "Must be between 8 and 10 characters";
     	String msg10 = "Please enter a password" + "\n" + "Must be between 8 and 10 characters" + "\n" + "Must contain upper, lower case characters and a number";
     	

     	
     	if (name_message.equals(msg1)) {
	 		
     		assertEquals("Error: Password err msg not correct! ", name_message, msg1);
	 	}
     	else if (name_message.equals(msg2)) {
	 		
     		assertEquals("Error: Password err msg not correct! ", name_message, msg2);

	 	}
     	else if (name_message.equals(msg3)) {
	 		
     		assertEquals("Error: Password err msg not correct! ", name_message, msg3);
     		
	 	}
     	else if (name_message.equals(msg4)) {
	 		
     		assertEquals("Error: Password err msg not correct! ", name_message, msg4);
	 	}   
     	else if (name_message.equals(msg5)) {
	 		
     		assertEquals("Error: Password err msg not correct! ", name_message, msg5);
	 	} 
     	else if (name_message.equals(msg6)) {
	 		
     		assertEquals("Error: Password err msg not correct! ", name_message, msg6);

	 	}
     	else if (name_message.equals(msg7)) {
	 		
     		assertEquals("Error: Password err msg not correct! ", name_message, msg7);
     		
	 	}
     	else if (name_message.equals(msg8)) {
	 		
     		assertEquals("Error: Password err msg not correct! ", name_message, msg8);
	 	}   
     	else if (name_message.equals(msg9)) {
	 		
     		assertEquals("Error: Password err msg not correct! ", name_message, msg9);
	 	} 
     	else if (name_message.equals(msg10)) {
	 		
     		assertEquals("Error: Password err msg not correct! ", name_message, msg10);
	 	} 
     	else 
     	{
     		throw new IOException("NOT VALID Password err rmsg!!");
	 	
	 	}

	}	
	
	
	@Then("^I send and verify incorrect details '(.*)' for User Management Email$")
	public void IncorrectUserMgtDetailsEmail(String validationtext )throws IOException {
  		
		/* Email */
		createNewUserDetails.Username.clear();
		createNewUserDetails.Username.sendKeys("testy");
		createNewUserDetails.Password.clear();
		createNewUserDetails.Password.sendKeys("Password1");
		createNewUserDetails.EmailAddress.clear();
		createNewUserDetails.EmailAddress.sendKeys(validationtext);
		createNewUserDetails.SaveUserButton.click();
  		
		String name_message = driver.findElement(By.xpath("//*[@id='content']/form/div[3]/div/span[3]/div/p")).getText();
     	System.out.println("Email_message err rmsg........... " + name_message);
     		
     	String msg1 = "You must enter an email address";
     	String msg2 = "Must be a valid email address";
     	
     	if (name_message.equals(msg1)) {
	 		
     		assertEquals("Error: Email err msg not correct! ", name_message, msg1);
	 	}
     	else if (name_message.equals(msg2)) {
	 		
     		assertEquals("Error: Email err msg not correct! ", name_message, msg2);
	 	}
     	else
     	{
     		throw new IOException("NOT VALID Email Address err rmsg!! ");
	 	
	 	}

	}	
	
	

	@Then("^I send and verify details '(.*)' and '(.+)' for User Management Username$")
	public void IncorrectUserMgtDetailsUsername(String validationtext, String text) {
  		
		/* User Name */
		createNewUserDetails.Username.clear();
		createNewUserDetails.Username.sendKeys(validationtext);
		createNewUserDetails.SaveUserButton.click();
  		
  		JavascriptExecutor js1 = (JavascriptExecutor) driver;
     	WebElement field1 = driver.findElement(By.id("username"));
     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
     	String name_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
     	System.out.println("username_message err rmsg........... " + name_message);
     		
     	assertEquals("Error: UserName err msg not correct! ", name_message, text);

	
	}
	
	
	@Then("^I send and verify incorrect details '(.*)' for User Management Pwd$")
	public void IncorrectUserMgtDetailsPwd(String validationtext) {
  		
		/* Password */
		createNewUserDetails.Username.clear();
		createNewUserDetails.Username.sendKeys("testy");
		createNewUserDetails.Password.clear();
		createNewUserDetails.Password.sendKeys(validationtext);
		createNewUserDetails.SaveUserButton.click();
  		
  		JavascriptExecutor js1 = (JavascriptExecutor) driver;
     	WebElement field1 = driver.findElement(By.id("password"));
     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
     	String pwd_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
     	System.out.println("password_message err rmsg........... " + pwd_message);
     	
     	if (pwd_message.equals("Please match the requested format.")) {
	 		
     		assertEquals("Error: UserName err msg not correct! ", pwd_message, "Please match the requested format.");

	 	}
	 	else {
	 		assertEquals("Error: UserName err msg not correct! ", pwd_message, "Please match the format requested.");

	 	
	 	}

	}
	
	@Then("^I send and verify incorrect details '(.*)' and '(.+)' for User Management Password$")
	public void IncorrectUserMgtDetailsPwd(String validationtext, String text) {
  		
		/* Password */
		createNewUserDetails.Username.clear();
		createNewUserDetails.Username.sendKeys("testy");
		createNewUserDetails.Password.clear();
		createNewUserDetails.Password.sendKeys(validationtext);
		createNewUserDetails.SaveUserButton.click();
  		
  		JavascriptExecutor js1 = (JavascriptExecutor) driver;
     	WebElement field1 = driver.findElement(By.id("password"));
     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
     	String pwd_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
     	System.out.println("password_message err rmsg........... " + pwd_message);
     	
     	assertEquals("Error: Password err msg not correct! ", pwd_message, text);
     	
	
	}	
	
	@Then("^I send and verify incorrect details '(.*)' and '(.+)' for Existing User Management Password$")
	public void IncorrectExistingUserMgtDetailsPwd(String validationtext, String text) {
  		
		/* Password */
		createNewUserDetails.Password.clear();
		createNewUserDetails.Password.sendKeys(validationtext);
		createNewUserDetails.SaveUserButton.click();
  		
  		JavascriptExecutor js1 = (JavascriptExecutor) driver;
     	WebElement field1 = driver.findElement(By.id("password"));
     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
     	String pwd_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
     	System.out.println("password_message err rmsg........... " + pwd_message);
     	
     	assertEquals("Error: Password err msg not correct! ", pwd_message, text);
     	
	
	}
	
	
	@Then("^I send and verify details '(.*)' and '(.+)' for User Management Email$")
	public void IncorrectUserMgtDetailsEmail(String validationtext, String text) {
  		
		/* Email */
		createNewUserDetails.Username.clear();
		createNewUserDetails.Username.sendKeys("testy");
		createNewUserDetails.Password.clear();
		createNewUserDetails.Password.sendKeys("Password1");
		createNewUserDetails.EmailAddress.clear();
		createNewUserDetails.EmailAddress.sendKeys(validationtext);
		createNewUserDetails.SaveUserButton.click();
  		
  		JavascriptExecutor js1 = (JavascriptExecutor) driver;
     	WebElement field1 = driver.findElement(By.id("u_email"));
     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
     	String email_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
     	System.out.println("email_message err rmsg........... " + email_message);
     	
     	assertEquals("Error: Email err msg not correct! ", email_message, text);
     	
	
	}	
	
	
	@Then("^I send and verify incorrect details '(.*)' and '(.+)' for Existing User Management Email$")
	public void IncorrectExistingUserMgtDetailsEmail(String validationtext, String text) {
  		
		/* Email */
		createNewUserDetails.EmailAddress.clear();
		createNewUserDetails.EmailAddress.sendKeys(validationtext);
		createNewUserDetails.SaveUserButton.click();
  		
  		JavascriptExecutor js1 = (JavascriptExecutor) driver;
     	WebElement field1 = driver.findElement(By.id("u_email"));
     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
     	String email_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
     	System.out.println("email_message err rmsg........... " + email_message);
     	
     	assertEquals("Error: Email err msg not correct! ", email_message, text);
     	
	
	}	
	
	@Then("^I send and verify incorrect details for User Management Account Enabled$")
	public void IncorrectUserMgtDetailsAccEnabled() {
		
		createNewUserDetails.Username.clear();
		createNewUserDetails.Username.sendKeys("testy");
		createNewUserDetails.Password.clear();
		createNewUserDetails.Password.sendKeys("Password1");
		createNewUserDetails.EmailAddress.clear();
		createNewUserDetails.EmailAddress.sendKeys("test@test.com");
		createNewUserDetails.SaveUserButton.click();
		
		String name_message = driver.findElement(By.xpath("//*[@id='content']/form/div[4]/div/div/p")).getText();
		
     	System.out.println("Enabled_message err rmsg........... " + name_message);
     		
     	String msg1 = "Please select if the account is enabled";
     	
     	if (name_message.equals(msg1)) {
	 		
     		assertEquals("Error: Enabled err msg not correct! ", name_message, msg1);
	 	}
     	else 
     	{
	 		System.out.println("NOT VALID err rmsg!! ");
	 	
	 	}
		
	}
	
	
	
 	@Then("^I send and verify incorrect details '(.+)' for contact details$")
	public void ErrorMessageCustomerByContactDetails(String text) throws IOException {
  		
  		String err_msg1 = "Must be numbers only";
  		String err_msg2 = "Must be a valid email address";
  		String err_msg3 = "Must be less than 12 digits";
  		String err_msg4 = "Must be a valid email address" + "\n" + "Must not exceed 50 characters";
  		String err_msg5 = "Must not exceed 50 characters" + "\n" + "Must be a valid email address";
  		String err_msg6 = "Must not exceed 50 characters";
  		
  		/* Home Phone */
  		createNewCustomerDetails.homePhone.clear();
  		createNewCustomerDetails.homePhone.sendKeys(text);
  		
  		/* Mobile Phone */
  		createNewCustomerDetails.mobilePhone.clear();
  		createNewCustomerDetails.mobilePhone.sendKeys(text);
  		
  		/* Email Address */
  		createNewCustomerDetails.email.clear();
  		createNewCustomerDetails.email.sendKeys(text);
     	
     	WebElement element1 = driver.findElement(By.id("savecustomer"));
     	JavascriptExecutor executor1 = (JavascriptExecutor)driver;
     	executor1.executeScript("arguments[0].click()", element1);
   	 
  	
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[2]/span[1]/div/span"));
  		String message1  = field1.getText();
  		
  		if (message1.equals(err_msg1)) {
	 		
  			assertEquals("Error: Home Phone err msg not correct! ", message1, err_msg1);
	 	}
  		else if (message1.equals(err_msg3)) {
	 		
  			assertEquals("Error: Home Phone err msg not correct! ", message1, err_msg3);
	 	}
  		else if (message1.equals(err_msg1 + "\n" + err_msg3)) {
	 		
  			assertEquals("Error: Home Phone err msg not correct! ", message1, err_msg1 + "\n" + err_msg3);
	 	}
  		else if (message1.equals(err_msg3 + "\n" + err_msg1)) {
	 		
  			assertEquals("Error: Home Phone err msg not correct! ", message1, err_msg3 + "\n" + err_msg1);
	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Home Phone err rmsg!!");
	 	
	 	}
  		
  		
  		WebElement field2 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[2]/span[2]/div/span"));
  		String message2  = field2.getText();
  		
  		if (message2.equals(err_msg1)) {
	 		
  			assertEquals("Error: Mobile Phone err msg not correct! ", message2, err_msg1);
	 	}
  		else if (message2.equals(err_msg3)) {
	 		
  			assertEquals("Error: Mobile Phone err msg not correct! ", message2, err_msg3);
	 	}
  		else if (message2.equals(err_msg1 + "\n" + err_msg3)) {
	 		
  			assertEquals("Error: Mobile Phone err msg not correct! ", message2, err_msg1 + "\n" + err_msg3);
	 	}
  		else if (message2.equals(err_msg3 + "\n" + err_msg1)) {
	 		
  			assertEquals("Error: Home Phone err msg not correct! ", message2, err_msg3 + "\n" + err_msg1);
	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Mobile Phone err rmsg!!");
	 	
	 	}
  		
  		
  		WebElement field3 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div[2]/span[3]/div/span"));
  		String message3  = field3.getText();
  		
  		if (message3.equals(err_msg2)) {
	 		
  			assertEquals("Error: Email Address err msg not correct! ", message3, err_msg2);
	 	}
  		else if (message3.equals(err_msg4)) {
	 		
  			assertEquals("Error: Email Address err msg not correct! ", message3, err_msg4);
	 	}
  		else if (message3.equals(err_msg5)) {
		
		assertEquals("Error: Email Address err msg not correct! ", message3, err_msg5);
  		}
  		else if (message3.equals(err_msg6)) {
  			
  			assertEquals("Error: Email Address err msg not correct! ", message3, err_msg6);
  	  		}
     	else 
     	{
     		throw new IOException("NOT VALID Email Address err rmsg!!");
	 	
	 	}

	}
  
  	
  	
  	@Then("^I send and verify incorrect details '(.+)' and '(.+)' for contact details$")
	public void IncorrectCustomerByContactDetails(String validationtext, String text) {
  		  		
  		/* Home Number */
  		createNewCustomerDetails.homePhone.clear();
  		createNewCustomerDetails.homePhone.sendKeys(validationtext);
  		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//createNewCustomerDetails.saveNewCustomer.click();
		editExistingCustomerDetails.SaveCustomer.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  		
  		JavascriptExecutor js1 = (JavascriptExecutor) driver;
     	WebElement field1 = driver.findElement(By.id("homephone"));
     	Boolean is_valid1 = (Boolean)js1.executeScript("return arguments[0].checkValidity();", field1);
     	String homeNo_message = (String)js1.executeScript("return arguments[0].validationMessage;", field1);
     	System.out.println("Home Number err rmsg........... " + homeNo_message);
     	
     	assertEquals("Error: home No_message err msg not correct! ", homeNo_message, "Please match the format requested.");
  		
  		createNewCustomerDetails.homePhone.clear();
  		createNewCustomerDetails.homePhone.sendKeys("0" + Utilities.getRandomAlphaNumeric(11, Utilities.RandomType.Num));
  		
  		/* Mobile Number*/
  		createNewCustomerDetails.mobilePhone.clear();
  		createNewCustomerDetails.mobilePhone.sendKeys(validationtext);
  		//createNewCustomerDetails.saveNewCustomer.click();
  		editExistingCustomerDetails.SaveCustomer.click();
  		
  		JavascriptExecutor js2 = (JavascriptExecutor) driver;
     	WebElement field2 = driver.findElement(By.id("mobilephone"));
     	Boolean is_valid2 = (Boolean)js2.executeScript("return arguments[0].checkValidity();", field2);
     	String mobileNo_message = (String)js2.executeScript("return arguments[0].validationMessage;", field2);
     	System.out.println("Mobile Number err rmsg........... " + mobileNo_message);
     	
     	assertEquals("Error: Email Address err msg not correct! ", mobileNo_message, "Please match the format requested.");
     	
     	createNewCustomerDetails.mobilePhone.clear();
  		createNewCustomerDetails.mobilePhone.sendKeys("0" + Utilities.getRandomAlphaNumeric(11, Utilities.RandomType.Num));
  		

  		/* Email Address */
  		createNewCustomerDetails.email.clear();
  		createNewCustomerDetails.email.sendKeys(validationtext);
  		createNewCustomerDetails.saveNewCustomer.click();
  		
  		JavascriptExecutor js3 = (JavascriptExecutor) driver;
     	WebElement field3 = driver.findElement(By.id("emailaddress"));
     	Boolean is_valid3 = (Boolean)js3.executeScript("return arguments[0].checkValidity();", field3);
     	String email_message = (String)js3.executeScript("return arguments[0].validationMessage;", field3);
     	System.out.println("name_message err rmsg........... " + email_message);
     	
     	assertEquals("Error: Email Address err msg not correct! ", email_message, text);
     	
     	
	}	
  	
  	
  	@And("^I send address details$")
	public void enterAddressDetails() {
  		
  		CreateNewCustomer createNewCustomer = DataHelper.getApplicantByAddress();

  		createNewCustomer_Methods.PopulateAddressDetails(createNewCustomer);

	}
  	
  	
  	@And("^I send contact details$")
	public void enterContactDetails() {
  		
  		CreateNewCustomer createNewCustomer = DataHelper.getApplicantByContactDetails();

  		createNewCustomer_Methods.PopulateContactDetails(createNewCustomer);

	}
  	
	@And("^I send updated customer details$")
	public void enterUpdatedCustomerDetails() {
  		
		EditExistingCustomer editExistingCustomer = DataHelper.getUpdatedCustomerDetailsApplicant();

		editExistingCustomer_Methods.PopulateCustomerDetails(editExistingCustomer);

	}
  	
  	@And("^I send updated address details$")
	public void enterUpdatedAddressDetails() {
  		
  		EditExistingCustomer editExistingCustomer = DataHelper.getUpdatedAddressDetailsApplicant();

  		editExistingCustomer_Methods.PopulateAddressDetails(editExistingCustomer);

	}
  	
  	
  	@And("^I send updated contact details$")
	public void enterUpdatedContactDetails() {
  		
  		EditExistingCustomer editExistingCustomer = DataHelper.getUpdatedContactDetailsApplicant();

  		editExistingCustomer_Methods.PopulateContactDetails(editExistingCustomer);

	}
  	
  	
  	@And("^I send new Administrator user details$")
	public void enterNewAdministratorUserDetails() {
  		
  		CreateNewUser createNewUser = DataHelper.getNewAdministratorUser();

  		createNewUser_Methods.PopulateCustomerDetails_Administrator(createNewUser);

	}
  	
  	
  	@And("^I send new SuperUser user details$")
	public void enterNewSuperUserUserDetails() {
  		
  		CreateNewUser createNewUser = DataHelper.getNewSuperUserUser();

  		createNewUser_Methods.PopulateCustomerDetails_Administrator(createNewUser);

	}
  	
  	
  	@And("^I send new Standard user details$")
	public void enterNewStandardUserDetails() {
  		
  		CreateNewUser createNewUser = DataHelper.getNewStandardUser();

  		createNewUser_Methods.PopulateCustomerDetails_Administrator(createNewUser);

	}
  	
  	@And("^I create new user and log in$")
	public void createNewUser() {
  		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Alpha);
  		createNewUserDetails.Username.sendKeys(randnum);
  		createNewUserDetails.Password.sendKeys("Password1");
  		createNewUserDetails.EmailAddress.sendKeys("test" + randnum + "@test.com");
  		createNewUserDetails.UserRole_Administrator.click();
  		createNewUserDetails.AccountEnabled_True.click();
  		createNewUserDetails.SaveUserButton.click();
  		
  		/* logout */
  		driver.findElement(By.id("logoutLink")).click();
  		
  		driver.findElement(By.id("username")).sendKeys(randnum);
  		driver.findElement(By.id("password")).sendKeys("Password1");

	}
  	
  	
  	
  	@And("^I send new '(.+)' user details$")
	public String enterNewUserDetails(String userType) {
  		
  		CreateNewUser createNewUser1 = new CreateNewUser();
	try {
	
		switch (userType){ 
	     case "Administrator":
	    	createNewUser1 = DataHelper.getNewAdministratorUser();
	   		createNewUser_Methods.PopulateCustomerDetails_Administrator(createNewUser1);
	        break;
	     case "SuperUser":
	   		createNewUser1 = DataHelper.getNewSuperUserUser();
	  		createNewUser_Methods.PopulateCustomerDetails_SuperUser(createNewUser1);
	        break;
	     case "Standard":
    	 	createNewUser1 = DataHelper.getNewStandardUser();
   			createNewUser_Methods.PopulateCustomerDetails_Standard(createNewUser1);
   			break;
	     case "Manager":
	    	 	createNewUser1 = DataHelper.getNewManagerUser();
	   			createNewUser_Methods.PopulateCustomerDetails_Manager(createNewUser1);
	   			break;
	     default: System.out.println("unknown user selected...");
	    }

	Thread.sleep(2000);
	}
	catch (InterruptedException e)
	{
		
		System.out.println("Error: " + e);
	}

	return createNewUser1.Username;
	
  }
  	
  	
  	
  	
  	
  	@And("^I update existing user '(.+)'$")
	public void UpdateExistingUser(String details) {
  		
	try {
	
		switch (details){ 
		case "Email Address":
	    	String emailAddr = DataHelper.UpdateEmailAddressExistingUser();
	   		createNewUser_Methods.PopulateEmailAddress(emailAddr);
	        break;
	        
		case "Password":
	    	String pwd = DataHelper.UpdateOldPasswordExistingUser();
	   		createNewUser_Methods.PopulatePassword(pwd);
	        break;
	        
		case "NewPassword":
	    	String newpwd = DataHelper.UpdateNewPasswordExistingUser();
	   		createNewUser_Methods.PopulatePassword(newpwd);
	        break;
	        
		case "NewUsername":
	    	String newusr = DataHelper.UpdateNewUsernameExistingUser();
	   		createNewUser_Methods.PopulateUsername(newusr);
	        break;
		
		case "OldUsername":
	    	String oldusr = DataHelper.UpdateOldUsernameExistingUser();
	   		createNewUser_Methods.PopulateUsername(oldusr);
	        break;
	        
		case "DisableUser":
	   		createNewUser_Methods.DisableUsername();
	        break;
	        
		case "EnableUser":
	   		createNewUser_Methods.EnableUsername();
	        break;
		
	     case "Administrator":
	    	CreateNewUser createNewUser1 = DataHelper.getNewAdministratorUser();
	   		createNewUser_Methods.PopulateCustomerDetails_Administrator(createNewUser1);
	        break;
	     case "SuperUser":
	   		CreateNewUser createNewUser2 = DataHelper.getNewSuperUserUser();
	  		createNewUser_Methods.PopulateCustomerDetails_SuperUser(createNewUser2);
	        break;
	     case "Standard":
    	 	CreateNewUser createNewUser3 = DataHelper.getNewSuperUserUser();
   			createNewUser_Methods.PopulateCustomerDetails_Standard(createNewUser3);
   			break;
	     default: System.out.println("unknown user selected...");
	     
	    }

	Thread.sleep(2000);
	}
	catch (InterruptedException e)
	{
		
		System.out.println("Error: " + e);
	}

	
  }
  	
  	
  	
  	
  	@Then("^I send and verify empty message for New Complaint$")
	public void EmptyMessageNewComplaint() throws IOException {
  		
  		String medium = "Information missing/incorrect!";
  		String small = "Please rectify highlighted issues and submit the page again.";
  		
  		// Medium error message
  		WebElement field0 = driver.findElement(By.className("bold-medium"));
  		String medium_message  = field0.getText();
     	System.out.println("Type_message err rmsg........... " + medium_message);
     	assertEquals("Error: Medium err msg not correct! ", medium_message, medium);
     	
     // Small error message
  		WebElement field1 = driver.findElement(By.className("bold-small"));
  		String small_message  = field1.getText();
     	System.out.println("Type_message err rmsg........... " + small_message);
     	assertEquals("Error: Small err msg not correct! ", small_message, small);
     	
  	}
  	

  	@Then("^I send and verify empty details Type for New Complaint$")
	public void EmptyTypeNewComplaint() throws IOException {
  		
  		String msg0 = "Please select a contact method";
  		
  		// Type error message
  		WebElement field0 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div/div[1]/span"));
  		String message0  = field0.getText();
     	System.out.println("Type_message err rmsg........... " + message0);
     	assertEquals("Error: Type err msg not correct! ", message0, msg0);
     	
  	}
  	
  	

  	@Then("^I send and verify empty details Reference for New Complaint$")
	public void EmptyReferenceNewComplaint() throws IOException {
  		 
  		String msg1 = "Must only contain numbers and text" + "\n" + "Please enter a reference" + "\n" + "Must be between 1 and 12 characters";
  		String msg2 = "Must only contain numbers and text" + "\n" + "Must be between 1 and 12 characters" + "\n" + "Please enter a reference";	
  		String msg3 = "Please enter a reference" + "\n" + "Must only contain numbers and text" + "\n" + "Must be between 1 and 12 characters";
  		String msg4 = "Please enter a reference" + "\n" + "Must be between 1 and 12 characters" + "\n" + "Must only contain numbers and text";
  		String msg5 = "Must be between 1 and 12 characters" + "\n" + "Please enter a reference" + "\n" + "Must only contain numbers and text";
  		String msg6 = "Must be between 1 and 12 characters" + "\n" + "Must only contain numbers and text" + "\n" + "Please enter a reference";
     
  		
     	// Reference error message
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='submitpage']/div/form/div[3]/div/div[3]/div/span"));
  		String message1  = field1.getText();
  		System.out.println("Reference err rmsg........... " + message1);
  		if (message1.equals(msg1)) {
	 		
  	     	assertEquals("Error: Reference err msg not correct! ", message1, msg1);
	 	}
     	else if (message1.equals(msg2)) {
	 		
         	assertEquals("Error: Reference err msg not correct! ", message1, msg2);

	 	}
     	else if (message1.equals(msg3)) {
	 		
         	assertEquals("Error: Reference err msg not correct! ", message1, msg3);

	 	}
     	else if (message1.equals(msg4)) {
		
     		assertEquals("Error: Reference err msg not correct! ", message1, msg4);

     	}
     	else if (message1.equals(msg5)) {
		
     		assertEquals("Error: Reference err msg not correct! ", message1, msg5);

     	}
     	else if (message1.equals(msg6)) {
		
     		assertEquals("Error: Reference err msg not correct! ", message1, msg6);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Reference err rmsg!!");
	 	
	 	}
  		
  	}
  	
  	
  	@Then("^I send and verify Reference '(.+)' for New Complaint$")
	public void ReferenceNewComplaintErrorMessage(String ref) throws IOException {
  		 
  		String msg1 = "Must only contain numbers and text" + "\n" + "Please enter a reference" + "\n" + "Must be between 1 and 12 characters";
  		String msg2 = "Must only contain numbers and text" + "\n" + "Must be between 1 and 12 characters" + "\n" + "Please enter a reference";	
  		String msg3 = "Please enter a reference" + "\n" + "Must only contain numbers and text" + "\n" + "Must be between 1 and 12 characters";
  		String msg4 = "Please enter a reference" + "\n" + "Must be between 1 and 12 characters" + "\n" + "Must only contain numbers and text";
  		String msg5 = "Must be between 1 and 12 characters" + "Please enter a reference" + "\n" + "Must only contain numbers and text";
  		String msg6 = "Must be between 1 and 12 characters" + "\n" + "Must only contain numbers and text" + "\n" + "Please enter a reference";
     	
  		String msg7 = "Must only contain numbers and text";
  		
  		String msg8 = "Must be between 1 and 12 characters";
  		
  		/* Reference */
     	newComplaint.Reference.clear();
     	newComplaint.Reference.sendKeys(ref);
     	WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
     	
     	// Reference error message
  		WebElement field1 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div/span[2]/div/span"));
  		String message1  = field1.getText();
  		System.out.println("Reference err rmsg........... " + message1);
  		if (message1.equals(msg1)) {
	 		
  	     	assertEquals("Error: Reference err msg not correct! ", message1, msg1);
	 	}
     	else if (message1.equals(msg2)) {
	 		
         	assertEquals("Error: Reference err msg not correct! ", message1, msg2);

	 	}
     	else if (message1.equals(msg3)) {
	 		
         	assertEquals("Error: Reference err msg not correct! ", message1, msg3);

	 	}
     	else if (message1.equals(msg4)) {
		
     		assertEquals("Error: Reference err msg not correct! ", message1, msg4);

     	}
     	else if (message1.equals(msg5)) {
		
     		assertEquals("Error: Reference err msg not correct! ", message1, msg5);

     	}
     	else if (message1.equals(msg6)) {
		
     		assertEquals("Error: Reference err msg not correct! ", message1, msg6);

     	}
     	else if (message1.equals(msg7)) {
    		
     		assertEquals("Error: Reference err msg not correct! ", message1, msg7);

     	}
     	else if (message1.equals(msg8)) {
    		
     		assertEquals("Error: Reference err msg not correct! ", message1, msg8);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Reference err rmsg!!");
	 	
	 	}
  		
  	}
  	
  	
  	@Then("^I send and verify empty details Assigned By for New Complaint$")
	public void EmptyAssignedByNewComplaintErrorMessage() throws IOException {
  		
  		String msg7 = "Assigned by must be entered" + "\n" + "Assigned by must be 5 characters" + "\n" + "Assigned by must be a 5 letter cypher";
  		String msg8 = "Assigned by must be entered" + "\n" + "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be 5 characters";
  		String msg9 = "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be entered" + "\n" + "Assigned by must be 5 characters";
  		String msg10 = "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be 5 characters" + "\n" + "Assigned by must be entered";	
  		String msg11 = "Assigned by must be 5 characters" + "\n" + "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be entered";
  		String msg12 = "Assigned by must be 5 characters" + "\n" + "Assigned by must be entered" + "\n" + "Assigned by must be a 5 letter cypher";
  		
     	
     	// Assigned By error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='submitpage']/div/form/div[3]/div/div[4]/div[2]/span"));
  		String message2  = field2.getText();
  		System.out.println("Assigned By_message err rmsg........... " + message2);
  		if (message2.equals(msg7)) {
	 		
  	     	assertEquals("Error: Assigned By err msg not correct! ", message2, msg7);
	 	}
     	else if (message2.equals(msg8)) {
	 		
         	assertEquals("Error: Assigned By err msg not correct! ", message2, msg8);

	 	}
     	else if (message2.equals(msg9)) {
	 		
         	assertEquals("Error: Assigned By err msg not correct! ", message2, msg9);

	 	}
     	else if (message2.equals(msg10)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg10);

     	}
     	else if (message2.equals(msg11)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg11);

     	}
     	else if (message2.equals(msg12)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg12);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Assigned By err rmsg!!");
	 	
	 	}
     	

	}
  	
  	
  	
  	@Then("^I send and verify Assigned By '(.+)' for New Complaint$")
	public void AssignedByNewComplaintErrorMessage(String assignedBy) throws IOException {
  		
  		String msg7 = "Assigned by must be entered" + "\n" + "Assigned by must be 5 characters" + "\n" + "Assigned by must be a 5 letter cypher";
  		String msg8 = "Assigned by must be entered" + "\n" + "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be 5 characters";
  		String msg9 = "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be entered" + "\n" + "Assigned by must be 5 characters";
  		String msg10 = "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be 5 characters" + "\n" + "Assigned by must be entered";	
  		String msg11 = "Assigned by must be 5 characters" + "\n" + "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be entered";
  		String msg12 = "Assigned by must be 5 characters" + "\n" + "Assigned by must be entered" + "\n" + "Assigned by must be a 5 letter cypher";
  		
  		String msg13 = "Assigned by must be 5 characters" + "\n" + "Assigned by must be a 5 letter cypher";
  		String msg14 = "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be 5 characters";
  		
  		String msg15 = "Assigned by must be a 5 letter cypher";
  		
  		String msg16 = "Assigned by must be 5 characters";
  		
  		/* Assigned By */
     	newComplaint.AssignedBy.clear();
     	newComplaint.AssignedBy.sendKeys(assignedBy);
     	WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);

     	
     	// Assigned By error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div/div[2]/div[3]/span"));
  		String message2  = field2.getText();
  		System.out.println("Assigned By_message err rmsg........... " + message2);
  		if (message2.equals(msg7)) {
	 		
  	     	assertEquals("Error: Assigned By err msg not correct! ", message2, msg7);
	 	}
     	else if (message2.equals(msg8)) {
	 		
         	assertEquals("Error: Assigned By err msg not correct! ", message2, msg8);

	 	}
     	else if (message2.equals(msg9)) {
	 		
         	assertEquals("Error: Assigned By err msg not correct! ", message2, msg9);

	 	}
     	else if (message2.equals(msg10)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg10);

     	}
     	else if (message2.equals(msg11)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg11);

     	}
     	else if (message2.equals(msg12)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg12);

     	}
     	else if (message2.equals(msg13)) {
    		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg13);

     	}
     	else if (message2.equals(msg14)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg14);

     	}
     	else if (message2.equals(msg15)) {
    		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg15);

     	}
     	else if (message2.equals(msg16)) {
    		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg16);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Assigned By err rmsg!!");
	 	
	 	}
     	

	}
  	
  	
  	
  	@Then("^I send and verify empty details Team for New Complaint$")
	public void EmptyTeamNewComplaint() throws IOException {

  		String msg7 = "Assigned by team must be entered" + "\n" + "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must only contain numbers";
  		String msg8 = "Assigned by team must be entered" + "\n" + "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be 2 numbers";
  		
  		String msg9 = "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be entered";
  		String msg10 = "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must be entered" + "\n" + "Assigned by team must only contain numbers";	
  		
  		String msg11 = "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must be entered";
  		String msg12 = "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be entered" + "\n" + "Assigned by team must be 2 numbers";
  		
  		
  		
		/* Assigned By Team */
	    newComplaint.AssignedByTeam.clear();
	    WebElement element3 = driver.findElement(By.id("SaveComplaint"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click()", element3);
		    
		TestUtils.sleep(3000);
		
     	// Team error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='submitpage']/div/form/div[3]/div/div[4]/div[3]/span"));
  		String message2  = field2.getText();
  		System.out.println("Team_message err rmsg........... " + message2);
  		TestUtils.sleep(3000);
  		
  		if (message2.equals(msg7)) {
	 		
  	     	assertEquals("Error: Team err msg not correct! ", message2, msg7);
	 	}
     	else if (message2.equals(msg8)) {
	 		
         	assertEquals("Error: Team err msg not correct! ", message2, msg8);

	 	}
     	else if (message2.equals(msg9)) {
	 		
         	assertEquals("Error: Team err msg not correct! ", message2, msg9);

	 	}
     	else if (message2.equals(msg10)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg10);

     	}
     	else if (message2.equals(msg11)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg11);

     	}
     	else if (message2.equals(msg12)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg12);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Team err rmsg!!");
	 	
	 	}
     	

	}
  	
  	
  	
  	@Then("^I send and verify Team '(.+)' for New Complaint$")
	public void TeamNewComplaintErrorMessage(String team) throws IOException {
  		
  		String msg7 = "Assigned by team must be entered" + "\n" + "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must only contain numbers";
  		String msg8 = "Assigned by team must be entered" + "\n" + "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be 2 numbers";
  		String msg9 = "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be entered";
  		String msg10 = "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must be entered" + "\n" + "Assigned by team must only contain numbers";	
  		String msg11 = "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must be entered";
  		String msg12 = "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be entered" + "\n" + "Assigned by team must be 2 numbers";
  		
  		String msg13 = "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be 2 numbers";
  		String msg14 = "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must only contain numbers";
  		
  		String msg15 = "Assigned by team must be 2 numbers";
  		
  		String msg16 = "Assigned by team must only contain numbers";
  		
  		/* Assigned By Team */
     	newComplaint.AssignedByTeam.clear();
     	newComplaint.AssignedByTeam.sendKeys(team);
     	WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
  		
  		
     	// Team error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div/div[2]/div[4]/span"));
  		String message2  = field2.getText();
  		System.out.println("Team_message err rmsg........... " + message2);
  		if (message2.equals(msg7)) {
	 		
  	     	assertEquals("Error: Team err msg not correct! ", message2, msg7);
	 	}
     	else if (message2.equals(msg8)) {
	 		
         	assertEquals("Error: Team err msg not correct! ", message2, msg8);

	 	}
     	else if (message2.equals(msg9)) {
	 		
         	assertEquals("Error: Team err msg not correct! ", message2, msg9);

	 	}
     	else if (message2.equals(msg10)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg10);

     	}
     	else if (message2.equals(msg11)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg11);

     	}
     	else if (message2.equals(msg12)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg12);

     	}
     	else if (message2.equals(msg13)) {
    		
     		assertEquals("Error: Team err msg not correct! ", message2, msg13);

     	}
     	else if (message2.equals(msg14)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg14);

     	}
     	else if (message2.equals(msg15)) {
    		
     		assertEquals("Error: Team err msg not correct! ", message2, msg15);

     	}
     	else if (message2.equals(msg16)) {
    		
     		assertEquals("Error: Team err msg not correct! ", message2, msg16);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Team err rmsg!!");
	 	
	 	}
     	

	}
  	
  	

 	@Then("^I send and verify empty details Complaint Summary for New Complaint$")
	public void EmptyComplaintSummaryNewComplaint() throws IOException {
  		
  		String msg0 = "Please enter a summary" + "\n" + "Must be between 1 and 398 characters";
  		String msg1 = "Must be between 1 and 398 characters" + "\n" + "Please enter a summary";
  		
  		
	  	/* Complaint Summary */
	    newComplaint.ComplaintSummary.clear();
	    WebElement element3 = driver.findElement(By.id("SaveComplaint"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click()", element3);
		    
		    
  		// Complaint Summary error message
  		WebElement field0 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div/span[3]/div/span"));
  		String message0  = field0.getText();
     	System.out.println("Complaint Summary_message err rmsg........... " + message0);
     	
     	if (message0.equals(msg0)) {
	 		
     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg0);
	 	}
     	else if (message0.equals(msg1)) {
	 		
     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg1);

	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Complaint Summary err rmsg!!");
	 	
	 	}

     	
  	}
  	
 	
 	
 	
 	
 	
 	@Then("^I check Complaint Summary is editable for Edit Complaint$")
	public void CheckComplaintSummaryEditable() throws IOException {
  	
 		WebElement element = driver.findElement(By.id("summary"));
 		String readonly = element.getAttribute("readonly");
 		Assert.assertNotNull(readonly);
 			
 	}
 	
 	
 	
 	@Then("^I send and verify empty details Complaint Summary for Edit Complaint$")
	public void CheckEmptyComplaintSummaryEditable() throws IOException {
 		
 		String msg0 = "Please enter a summary" + "\n" + "Must be between 1 and 398 characters";
  		String msg1 = "Must be between 1 and 398 characters" + "\n" + "Please enter a summary";
  		
  		
	  	/* Complaint Summary */
	    newComplaint.ComplaintSummary.clear();
	    WebElement element3 = driver.findElement(By.id("SaveComplaint"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click()", element3);
		    
		    
  		// Complaint Summary error message
  		WebElement field0 = driver.findElement(By.xpath("//*[@id='submitpage']/div/form/div[3]/div/div[6]/div/span"));
  		String message0  = field0.getText();
     	System.out.println("Complaint Summary_message err rmsg........... " + message0);
     	
     	if (message0.equals(msg0)) {
	 		
     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg0);
	 	}
     	else if (message0.equals(msg1)) {
	 		
     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg1);

	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Complaint Summary err rmsg!!");
	 	
	 	}
 			
 	}
 	
 	
 	
 	
 	@Then("^I send and verify Complaint Summary '(.+)' for New Complaint$")
	public void ComplaintSummaryNewComplaintErrorMessage(String complaintSummary) throws IOException {
  		
  		String msg0 = "Please enter a summary" + "\n" + "Must be between 1 and 398 characters";
  		String msg1 = "Must be between 1 and 398 characters" + "\n" + "Please enter a summary";
  		
  		String msg2 = "Must be between 1 and 398 characters";
  		
  		/* Complaint Summary */
     	newComplaint.ComplaintSummary.clear();
     	newComplaint.ComplaintSummary.sendKeys(complaintSummary);
     	WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
     	
  		
  		// Complaint Summary error message
  		WebElement field0 = driver.findElement(By.xpath("//*[@id='submitpage']/div/form/div[3]/div/div[6]/div/span"));
  		String message0  = field0.getText();
     	System.out.println("Complaint Summary_message err rmsg........... " + message0);
     	
     	if (message0.equals(msg0)) {
	 		
     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg0);
	 	}
     	else if (message0.equals(msg1)) {
	 		
     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg1);

	 	}
     	else if (message0.equals(msg2)) {
	 		
     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg2);

	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Complaint Summary err rmsg!!");
	 	
	 	}

     	
  	}
 	
 	
  	
 	@Then("^I send and verify empty details Status for New Complaint$")
	public void EmptyStatusNewComplaint() throws IOException {
  		
  		String msg0 = "Status must be selected";
  		
  		// Status error message
  		WebElement field0 = driver.findElement(By.xpath("//*[@id='form']/form/div[4]/div/div/span[2]/div/span"));
  		String message0  = field0.getText();
     	System.out.println("Status_message err rmsg........... " + message0);
     	assertEquals("Error: Status err msg not correct! ", message0, msg0);
     	
  	}
 	
 	
 	
 	@Then("^I send and verify empty details Assigned By for Edit Complaint$")
	public void EmptyAssignedByEditComplaintErrorMessage() throws IOException {
  		
  		String msg7 = "Assigned by must be entered" + "\n" + "Assigned by must be 5 characters" + "\n" + "Assigned by must be a 5 letter cypher";
  		String msg8 = "Assigned by must be entered" + "\n" + "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be 5 characters";
  		String msg9 = "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be entered" + "\n" + "Assigned by must be 5 characters";
  		String msg10 = "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be 5 characters" + "\n" + "Assigned by must be entered";	
  		String msg11 = "Assigned by must be 5 characters" + "\n" + "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be entered";
  		String msg12 = "Assigned by must be 5 characters" + "\n" + "Assigned by must be entered" + "\n" + "Assigned by must be a 5 letter cypher";
  		
  		
		/* Assigned By */
	    newComplaint.AssignedBy.clear();
	    WebElement element3 = driver.findElement(By.id("SaveComplaint"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click()", element3);
     	
     	// Assigned By error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='submitpage']/div/form/div[3]/div/div[4]/div[2]/span"));
  		String message2  = field2.getText();
  		System.out.println("Assigned By_message err rmsg........... " + message2);
  		if (message2.equals(msg7)) {
	 		
  	     	assertEquals("Error: Assigned By err msg not correct! ", message2, msg7);
	 	}
     	else if (message2.equals(msg8)) {
	 		
         	assertEquals("Error: Assigned By err msg not correct! ", message2, msg8);

	 	}
     	else if (message2.equals(msg9)) {
	 		
         	assertEquals("Error: Assigned By err msg not correct! ", message2, msg9);

	 	}
     	else if (message2.equals(msg10)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg10);

     	}
     	else if (message2.equals(msg11)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg11);

     	}
     	else if (message2.equals(msg12)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg12);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Assigned By err rmsg!!");
	 	
	 	}
     	

	}
  	
  	
  	
  	@Then("^I send and verify Assigned By '(.+)' for Edit Complaint$")
	public void AssignedByEditComplaintErrorMessage(String assignedBy) throws IOException {
  		
  		String msg7 = "Assigned by must be entered" + "\n" + "Assigned by must be 5 characters" + "\n" + "Assigned by must be a 5 letter cypher";
  		String msg8 = "Assigned by must be entered" + "\n" + "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be 5 characters";
  		String msg9 = "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be entered" + "\n" + "Assigned by must be 5 characters";
  		String msg10 = "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be 5 characters" + "\n" + "Assigned by must be entered";	
  		String msg11 = "Assigned by must be 5 characters" + "\n" + "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be entered";
  		String msg12 = "Assigned by must be 5 characters" + "\n" + "Assigned by must be entered" + "\n" + "Assigned by must be a 5 letter cypher";
  		
  		String msg13 = "Assigned by must be 5 characters" + "\n" + "Assigned by must be a 5 letter cypher";
  		String msg14 = "Assigned by must be a 5 letter cypher" + "\n" + "Assigned by must be 5 characters";
  		
  		String msg15 = "Assigned by must be a 5 letter cypher";
  		
  		String msg16 = "Assigned by must be 5 characters";
  		
  		/* Assigned By */
     	newComplaint.AssignedBy.clear();
     	newComplaint.AssignedBy.sendKeys(assignedBy);
     	WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);

     	
     	// Assigned By error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div/div/div[3]/span"));
  		String message2  = field2.getText();
  		System.out.println("Assigned By_message err rmsg........... " + message2);
  		if (message2.equals(msg7)) {
	 		
  	     	assertEquals("Error: Assigned By err msg not correct! ", message2, msg7);
	 	}
     	else if (message2.equals(msg8)) {
	 		
         	assertEquals("Error: Assigned By err msg not correct! ", message2, msg8);

	 	}
     	else if (message2.equals(msg9)) {
	 		
         	assertEquals("Error: Assigned By err msg not correct! ", message2, msg9);

	 	}
     	else if (message2.equals(msg10)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg10);

     	}
     	else if (message2.equals(msg11)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg11);

     	}
     	else if (message2.equals(msg12)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg12);

     	}
     	else if (message2.equals(msg13)) {
    		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg13);

     	}
     	else if (message2.equals(msg14)) {
		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg14);

     	}
     	else if (message2.equals(msg15)) {
    		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg15);

     	}
     	else if (message2.equals(msg16)) {
    		
     		assertEquals("Error: Assigned By err msg not correct! ", message2, msg16);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Assigned By err rmsg!!");
	 	
	 	}
     	

	}
  	
  	
  	
  	@Then("^I send and verify empty details Team for Edit Complaint$")
	public void EmptyTeamEditComplaint() throws IOException {
  		
  		String msg7 = "Assigned by team must be entered" + "\n" + "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must only contain numbers";
  		String msg8 = "Assigned by team must be entered" + "\n" + "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be 2 numbers";

  		String msg9 = "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be entered";
  		String msg10 = "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must be entered" + "\n" + "Assigned by team must only contain numbers";	
  		
  		String msg11 = "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must be entered";
  		String msg12 = "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be entered" + "\n" + "Assigned by team must be 2 numbers";
  		
  		
  		/* Assigned By Team */
     	newComplaint.AssignedByTeam.clear();
     	WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
  		
  		
     	// Team error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='submitpage']/div/form/div[3]/div/div[4]/div[3]/span"));
  		String message2  = field2.getText();
  		System.out.println("Team_message err rmsg........... " + message2);
  		if (message2.equals(msg7)) {
	 		
  	     	assertEquals("Error: Team err msg not correct! ", message2, msg7);
	 	}
     	else if (message2.equals(msg8)) {
	 		
         	assertEquals("Error: Team err msg not correct! ", message2, msg8);

	 	}
     	else if (message2.equals(msg9)) {
	 		
         	assertEquals("Error: Team err msg not correct! ", message2, msg9);

	 	}
     	else if (message2.equals(msg10)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg10);

     	}
     	else if (message2.equals(msg11)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg11);

     	}
     	else if (message2.equals(msg12)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg12);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Team err rmsg!!");
	 	
	 	}
     	

	}
  	
  	
  	
  	@Then("^I send and verify Team '(.+)' for Edit Complaint$")
	public void TeamEditComplaintErrorMessage(String team) throws IOException {
  		
  		String msg7 = "Assigned by team must be entered" + "\n" + "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must only contain numbers";
  		String msg8 = "Assigned by team must be entered" + "\n" + "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be 2 numbers";
  		String msg9 = "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be entered";
  		String msg10 = "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must be entered" + "\n" + "Assigned by team must only contain numbers";	
  		String msg11 = "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must be entered";
  		String msg12 = "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be entered" + "\n" + "Assigned by team must be 2 numbers";
  		
  		String msg13 = "Assigned by team must only contain numbers" + "\n" + "Assigned by team must be 2 numbers";
  		String msg14 = "Assigned by team must be 2 numbers" + "\n" + "Assigned by team must only contain numbers";
  		
  		String msg15 = "Assigned by team must be 2 numbers";
  		
  		String msg16 = "Assigned by team must only contain numbers";
  		
  		
  		/* Assigned By Team */
     	newComplaint.AssignedByTeam.clear();
     	newComplaint.AssignedByTeam.sendKeys(team);
     	WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
  		
  		
     	// Team error message
     	WebElement field2 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div/div/div[4]/span"));
  		String message2  = field2.getText();
  		System.out.println("Team_message err rmsg........... " + message2);
  		if (message2.equals(msg7)) {
	 		
  	     	assertEquals("Error: Team err msg not correct! ", message2, msg7);
	 	}
     	else if (message2.equals(msg8)) {
	 		
         	assertEquals("Error: Team err msg not correct! ", message2, msg8);

	 	}
     	else if (message2.equals(msg9)) {
	 		
         	assertEquals("Error: Team err msg not correct! ", message2, msg9);

	 	}
     	else if (message2.equals(msg10)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg10);

     	}
     	else if (message2.equals(msg11)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg11);

     	}
     	else if (message2.equals(msg12)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg12);

     	}
     	else if (message2.equals(msg13)) {
    		
     		assertEquals("Error: Team err msg not correct! ", message2, msg13);

     	}
     	else if (message2.equals(msg14)) {
		
     		assertEquals("Error: Team err msg not correct! ", message2, msg14);

     	}
     	else if (message2.equals(msg15)) {
    		
     		assertEquals("Error: Team err msg not correct! ", message2, msg15);

     	}
     	else if (message2.equals(msg16)) {
    		
     		assertEquals("Error: Team err msg not correct! ", message2, msg16);

     	}
     	else 
     	{
     		throw new IOException("NOT VALID Team err rmsg!!");
	 	
	 	}
     	

	}
 	


// 	@Then("^I send and verify empty details Complaint Summary for Edit Complaint$")
//	public void EmptyComplaintSummaryEditComplaint() throws IOException {
//  		
//  		String msg0 = "Please enter a summary" + "\n" + "Must be between 1 and 398 characters";
//  		String msg1 = "Must be between 1 and 398 characters" + "\n" + "Please enter a summary";
//  		
//  		// Complaint Summary error message
//  		WebElement field0 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div/span[3]/div/span"));
//  		String message0  = field0.getText();
//     	System.out.println("Complaint Summary_message err rmsg........... " + message0);
//     	
//     	if (message0.equals(msg0)) {
//	 		
//     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg0);
//	 	}
//     	else if (message0.equals(msg1)) {
//	 		
//     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg1);
//
//	 	}
//     	else 
//     	{
//     		throw new IOException("NOT VALID Complaint Summary err rmsg!!");
//	 	
//	 	}
//
//     	
//  	}
  	
 	
 	
 	@Then("^I send and verify Complaint Summary '(.+)' for Edit Complaint$")
	public void ComplaintSummaryEditComplaintErrorMessage(String complaintSummary) throws IOException {
  		
  		String msg0 = "Please enter a summary" + "\n" + "Must be between 1 and 398 characters";
  		String msg1 = "Must be between 1 and 398 characters" + "\n" + "Please enter a summary";
  		
  		String msg2 = "Must be between 1 and 398 characters";
  		
  		/* Complaint Summary */
     	newComplaint.ComplaintSummary.clear();
     	newComplaint.ComplaintSummary.sendKeys(complaintSummary);
     	WebElement element3 = driver.findElement(By.id("SaveComplaint"));
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    executor3.executeScript("arguments[0].click()", element3);
     	
  		
  		// Complaint Summary error message
  		WebElement field0 = driver.findElement(By.xpath("//*[@id='form']/form/div[3]/div/span[3]/div/span"));
  		String message0  = field0.getText();
     	System.out.println("Complaint Summary_message err rmsg........... " + message0);
     	
     	if (message0.equals(msg0)) {
	 		
     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg0);
	 	}
     	else if (message0.equals(msg1)) {
	 		
     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg1);

	 	}
     	else if (message0.equals(msg2)) {
	 		
     		assertEquals("Error: Complaint Summary err msg not correct! ", message0, msg2);

	 	}
     	else 
     	{
     		throw new IOException("NOT VALID Complaint Summary err rmsg!!");
	 	
	 	}

     	
  	}
 	
 	
 	@Then("^I send and verify empty details Reference for Edit Complaint$")
 	public void EmptyReferenceEditComplaint() throws IOException {
 			 
 			String msg1 = "Must only contain numbers and text" + "\n" + "Please enter a reference" + "\n" + "Must be between 1 and 12 characters";
 			String msg2 = "Must only contain numbers and text" + "\n" + "Must be between 1 and 12 characters" + "\n" + "Please enter a reference";	
 			String msg3 = "Please enter a reference" + "\n" + "Must only contain numbers and text" + "\n" + "Must be between 1 and 12 characters";
 			String msg4 = "Please enter a reference" + "\n" + "Must be between 1 and 12 characters" + "\n" + "Must only contain numbers and text";
 			String msg5 = "Must be between 1 and 12 characters" + "\n" + "Please enter a reference" + "\n" + "Must only contain numbers and text";
 			String msg6 = "Must be between 1 and 12 characters" + "\n" + "Must only contain numbers and text" + "\n" + "Please enter a reference";
 	 	
 			
 	  		/* Reference */
 	     	newComplaint.Reference.clear();
 	     	WebElement element3 = driver.findElement(By.id("SaveComplaint"));
 		    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
 		    executor3.executeScript("arguments[0].click()", element3);
 		    
 			
 	 	// Reference error message
 			WebElement field1 = driver.findElement(By.xpath("//*[@id='submitpage']/div/form/div[3]/div/div[3]/div/span"));
 			String message1  = field1.getText();
 			System.out.println("Reference err rmsg........... " + message1);
 			if (message1.equals(msg1)) {
 	 		
 		     	assertEquals("Error: Reference err msg not correct! ", message1, msg1);
 	 	}
 	 	else if (message1.equals(msg2)) {
 	 		
 	     	assertEquals("Error: Reference err msg not correct! ", message1, msg2);

 	 	}
 	 	else if (message1.equals(msg3)) {
 	 		
 	     	assertEquals("Error: Reference err msg not correct! ", message1, msg3);

 	 	}
 	 	else if (message1.equals(msg4)) {
 		
 	 		assertEquals("Error: Reference err msg not correct! ", message1, msg4);

 	 	}
 	 	else if (message1.equals(msg5)) {
 		
 	 		assertEquals("Error: Reference err msg not correct! ", message1, msg5);

 	 	}
 	 	else if (message1.equals(msg6)) {
 		
 	 		assertEquals("Error: Reference err msg not correct! ", message1, msg6);

 	 	}
 	 	else 
 	 	{
 	 		throw new IOException("NOT VALID Reference err rmsg!!");
 	 	
 	 	}
 				
 	}
 		

  	@Then("^I verify New Complaint error message '(.+)' and '(.+)' and '(.+)' and '(.+)' and '(.*)' with '(.+)' '(.+)' '(.+)'$")
	public void NewComplaintErrorMessage(String type, String ref, String assignedBy, String assignedByTeam, String summary, String msg1, String msg2, String msg3) {
  				
  		switch (type){ 
 	    case "Telephone":
 	    	newComplaint.SaveComplaint.click();

 	  		JavascriptExecutor tele_js = (JavascriptExecutor) driver;
 	     	WebElement tele_field = driver.findElement(By.id("c_telephone"));
 	     	Boolean tele_is_valid = (Boolean)tele_js.executeScript("return arguments[0].checkValidity();", tele_field);
 	     	String tele_name_message = (String)tele_js.executeScript("return arguments[0].validationMessage;", tele_field);
 	     	System.out.println("Telephone not selected err rmsg........... " + tele_name_message);
 	     	
 	     	assertEquals("Error: Telephone not selected err msg not correct! ", tele_name_message, msg1);
 	     	newComplaint.Telephone.click();
  	        break;
  	        
 	   case "Letter":
 		   	newComplaint.SaveComplaint.click();

	  		JavascriptExecutor letter_js = (JavascriptExecutor) driver;
	     	WebElement letter_field = driver.findElement(By.id("c_letter"));
	     	Boolean is_valid = (Boolean)letter_js.executeScript("return arguments[0].checkValidity();", letter_field);
	     	String letter_name_message = (String)letter_js.executeScript("return arguments[0].validationMessage;", letter_field);
	     	System.out.println("Letter not selected err rmsg........... " + letter_name_message);
	     	
	     	assertEquals("Error: Letter not selected err msg not correct! ", letter_name_message, msg1);
	     	newComplaint.Letter.click();
 	        break;
 	        
 	  case "Email":
 		  	newComplaint.SaveComplaint.click();

	  		JavascriptExecutor email_js = (JavascriptExecutor) driver;
	     	WebElement email_field = driver.findElement(By.id("c_email"));
	     	Boolean email_is_valid = (Boolean)email_js.executeScript("return arguments[0].checkValidity();", email_field);
	     	String email_name_message = (String)email_js.executeScript("return arguments[0].validationMessage;", email_field);
	     	System.out.println("Email not selected err rmsg........... " + email_name_message);
	     	
	     	assertEquals("Error: Email not selected err msg not correct! ", email_name_message, msg1);
	     	newComplaint.Email.click();
	        break;
	        
 	 case "SocialMedia":
 		 	newComplaint.SaveComplaint.click();

	  		JavascriptExecutor socialmedia_js = (JavascriptExecutor) driver;
	     	WebElement socialmedia_field = driver.findElement(By.id("c_socialmedia"));
	     	Boolean socialmedia_is_valid = (Boolean)socialmedia_js.executeScript("return arguments[0].checkValidity();", socialmedia_field);
	     	String socialmedia_name_message = (String)socialmedia_js.executeScript("return arguments[0].validationMessage;", socialmedia_field);
	     	System.out.println("Telephone not selected err rmsg........... " + socialmedia_name_message);
	     	
	     	assertEquals("Error: SocialMedia not selected err msg not correct! ", socialmedia_name_message, msg1);
	     	newComplaint.SocialMedia.click();
	        break;
	        
 	     default: System.out.println("unknown type selected...");
 	     
 	    } 
     	
     	
     	/* Reference */
     	newComplaint.Reference.clear();
     	newComplaint.Reference.sendKeys(ref);
     	newComplaint.SaveComplaint.click();

  		JavascriptExecutor js2 = (JavascriptExecutor) driver;
     	WebElement field2 = driver.findElement(By.id("reference"));
     	Boolean is_valid2 = (Boolean)js2.executeScript("return arguments[0].checkValidity();", field2);
     	String name_message2 = (String)js2.executeScript("return arguments[0].validationMessage;", field2);
     	System.out.println("Reference not selected err rmsg........... " + name_message2);
     	
     	assertEquals("Error: Reference err msg not correct! ", name_message2, msg2);
     	newComplaint.Reference.clear();
     	newComplaint.Reference.sendKeys("COMP-123-45");
     	
     	
     	/* Assigned By */
     	newComplaint.AssignedBy.clear();
     	newComplaint.AssignedBy.sendKeys(assignedBy);
     	newComplaint.SaveComplaint.click();

  		JavascriptExecutor js3 = (JavascriptExecutor) driver;
     	WebElement field3 = driver.findElement(By.id("assigned_by"));
     	Boolean is_valid3 = (Boolean)js3.executeScript("return arguments[0].checkValidity();", field3);
     	String name_message3 = (String)js3.executeScript("return arguments[0].validationMessage;", field3);
     	System.out.println("Assigned By not selected err rmsg........... " + name_message3);
     	
     	assertEquals("Error: Assigned By err msg not correct! ", name_message3, msg2);
     	newComplaint.AssignedBy.clear();
     	newComplaint.AssignedBy.sendKeys("HR");
     	
     	
     	/* Assigned By Team */
     	newComplaint.AssignedByTeam.clear();
     	newComplaint.AssignedByTeam.sendKeys(assignedByTeam);
     	newComplaint.SaveComplaint.click();

  		JavascriptExecutor js4 = (JavascriptExecutor) driver;
     	WebElement field4 = driver.findElement(By.id("assigned_by_team"));
     	Boolean is_valid4 = (Boolean)js4.executeScript("return arguments[0].checkValidity();", field4);
     	String name_message4 = (String)js4.executeScript("return arguments[0].validationMessage;", field4);
     	System.out.println("Assigned By Team not selected err rmsg........... " + name_message4);
     	
     	assertEquals("Error: Assigned By Team err msg not correct! ", name_message4, msg2);
     	newComplaint.AssignedByTeam.clear();
     	newComplaint.AssignedByTeam.sendKeys("COMMS");
     	
     	
     	/* Complaint Summary */
     	newComplaint.ComplaintSummary.clear();
     	newComplaint.ComplaintSummary.sendKeys(summary);
     	newComplaint.SaveComplaint.click();

  		JavascriptExecutor js5 = (JavascriptExecutor) driver;
     	WebElement field5 = driver.findElement(By.id("summary"));
     	Boolean is_valid5 = (Boolean)js5.executeScript("return arguments[0].checkValidity();", field5);
     	String name_message5 = (String)js5.executeScript("return arguments[0].validationMessage;", field5);
     	System.out.println("Complaint Summary not selected err rmsg........... " + name_message5);
     	
     	assertEquals("Error: Complaint Summary err msg not correct! ", name_message5, msg3);
     	newComplaint.ComplaintSummary.clear();
     	newComplaint.ComplaintSummary.sendKeys("Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters.");
     	
  	
  	}
  	

  	
//  	@And("^I send applicant details with title others as '(.+)'$")
//	public void enterApplicantDetailsForTitleOthers(String otherTitle) {
//  		
//  		Applicant app = TelesalesDataHelper.getApplicant();
//  		
//  		 app.Title = Applicant.title.Other;
//         app.OtherTitle = otherTitle;
//
//  		pageApplicantDetails_Methods.PopulateAddressDetails(app);
//
//  		pageApplicantDetails_Methods.PopulatePersonalDetails(app);
//	}
//  	
//  	
//  	@And("^I set Direct Debit as payment type$")
//	public void DirectDebitPaymentType() {
//  		
//  		pageApplicantDetails_Methods.SetPaymentType(Applicant.paymentType.DirectDebit);
//	}
//  	
//  	@And("^I set Credit Debit card as payment type$")
//	public void creditDebitCardPaymentType() {
//  		
//  		pageApplicantDetails_Methods.SetPaymentType(Applicant.paymentType.CreditDebitCard);
//	}
//  	
//  	@And("^I set Cheque as payment type$")
//	public void ChequePaymentType() {
//  		
//  		pageApplicantDetails_Methods.SetPaymentType(Applicant.paymentType.Cheque);
//	}
//  	
//  	
//  	@Then("^I click applicant details submit$")
//	public void ApplicantDetailsSubmit() {
//  		
//  		telesalesBasePage.ClickSubmit();  
//	}
//  	
//  	
//  	@Then("^I click applicant details Natwest Account submit$")
//	public void ApplicantDetailsNatwestAccountSubmit() {
//  		
//  		Account acc = TelesalesDataHelper.getValidNatWestAccount();
//  		
//  		telesalesBasePage.ClickSubmit();  
//	}
//  	
//  	
//  	@Then("^I click applicant details Valid Account submit$")
//	public void ApplicantDetailsValidAccountSubmit() {
//  		
//  		Account acc = TelesalesDataHelper.getValidAccount();
//  		
//  		telesalesBasePage.ClickSubmit();  
//	}
//  	
//  	
//  	@Then("^I click applicant details LLoyds Account submit$")
//	public void ApplicantDetailsLLoydsAccountSubmit() {
//  		
//  		Account acc = TelesalesDataHelper.getValidLLoydsAccount();
//  		
//  		telesalesBasePage.ClickSubmit();  
//	}
//  	
//  	
//  	@Then("^I click applicant details Halifax Account submit$")
//	public void ApplicantDetailsHalifaxAccountSubmit() {
//  		
//  		Account acc = TelesalesDataHelper.getDirectCredit();
//  		
//  		telesalesBasePage.ClickSubmit();  
//	}
//  	
//  	
//  	
//  	@Then("^I click applicant details RBS Account submit$")
//	public void ApplicantDetailsRBSAccountSubmit() {
//  		
//  		Account acc = TelesalesDataHelper.getValidRBSAccount();
//  		
//  		telesalesBasePage.ClickSubmit();  
//	}
//  	
//  	
//  	@And("^I send LLoyds account details$")
//    public void enterLLoydsAccountDetails() {
//  		
//  		Account acc = TelesalesDataHelper.getValidLLoydsAccount();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
//  	
//  	
// 	@And("^I send valid account details$")
//    public void enterValidAccountDetails() {
//  		
//  		Account acc = TelesalesDataHelper.getValidAccount();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
//  	
//  	
// 	@And("^I send RBS account details$")
//    public void enterRBSAccountDetails() {
//  		
//  		Account acc = TelesalesDataHelper.getValidRBSAccount();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
//  	
//  	
// 	@And("^I send Natwest account details$")
//    public void enterNatwestAccountDetails() {
//  		
//  		Account acc = TelesalesDataHelper.getValidNatWestAccount();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
//  	
// 	
// 	@And("^I send Halifax account details$")
//    public void enterHalifaxAccountDetails() {
//  		
//  		Account acc = TelesalesDataHelper.getDirectCredit();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
//  	
//  	
// 
// 	@And("^I send no sort code account details$")
//    public void enterNoSortCodeAccountDetails() {
//  		
//  		Account acc = TelesalesDataHelper.getNoSortCodeAccount();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
// 	
// 	
// 	@And("^I clear account details$")
//    public void clearAccountDetails() {
//        
//  		pageDirectDebitDetails.ClearAccountDetails();
//  	}
// 	
// 	
// 	@And("^I send invalid account details$")
//    public void enterInvalidAccountDetails() {
//  		
//  		Account acc = TelesalesDataHelper.getInvalidSortCodeAccount();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
// 	
// 	
// 	@And("^I send part char sort code account details$")
//    public void enterCharSortCodeAccount() {
//  		
//  		Account acc = TelesalesDataHelper.getCharSortCodeAccount();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
// 	
// 	
// 	@And("^I send account eight characters details$")
//    public void enterAccount8Chars() {
//  		
//  		Account acc = TelesalesDataHelper.getAccount8Chars();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
// 	
// 	
// 	@And("^I send account five characters details$")
//    public void enterAccount5Chars() {
//  		
//  		Account acc = TelesalesDataHelper.getAccount5Chars();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
// 	
// 	
// 	@And("^I send account all characters details$")
//    public void enterAccountAllChars() {
//  		
//  		Account acc = TelesalesDataHelper.getAccountAllChars();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
// 	
// 	
// 	@And("^I send account does not accept direct debit$")
//    public void enterAccountDoesNotAcceptDirectDebit() {
//  		
//  		Account acc = TelesalesDataHelper.getAccountDoesNotAcceptDirectDebit();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
// 	
// 	
// 	@And("^I send account as not linked account details$")
//    public void enterNotLinkedAccount() {
//  		
//  		Account acc = TelesalesDataHelper.getNotLinkedAccount();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
// 	
// 	
//
// 	@And("^I send part completed sort code valid account details$")
//    public void enterPartCompletedSortCodeValidAccount() {
//  		
//  		Account acc = TelesalesDataHelper.getPartCompletedSortCodeValidAccount();
//        
//  		pageDirectDebitDetails_Methods.SendAccountDetails(acc);
//  	}
// 	
//  	
//  	@And("^I send account holder name$")
//    public void enterAccountHolderName() {
//  		
//  		Applicant app = TelesalesDataHelper.getApplicant();
//        
//  		pageDirectDebitDetails_Methods.SendAccountHolderName(app);
//  	}
//  	
//  	
//  	@And("^I send certificate start date$")
//    public void setCertificateStartDatePlusMinusOneMonth() {
//  		
//  		Certificate cert = TelesalesDataHelper.getCertificate();
//        cert.CertificateStart = Utilities.getPlusMinusOneMonthStartDate(false, true);
//        
//  		pageDirectDebitDetails.SendCertificateStartDate(cert);
//  	}
// 
//  
//  	@And("^I send certificate start date as current date$")
//    public void setCertificateStartCurrentDate() {
//  		
//  		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
//    	 
//    	 //get current date time with Date()
//    	 Date date = new Date();
//    	 
//    	 // Now format the date
//    	 String date1= dateFormat.format(date);
//    	 
//  		
//  		Certificate cert = TelesalesDataHelper.getCertificate(date1);
//        cert.CertificateStart = Utilities.getCurrentDateStartDate(true);
//        
//  		pageDirectDebitDetails.SendCertificateStartDate(cert);
//  	}
//  	
//  	
//  	@And("^I send certificate start date for twelve months$")
//    public void setTweleveMonthsCertificateStartDatePlusMinusOneMonth() {
//  		
//  		Certificate cert = TelesalesDataHelper.getCertificateTwelveMonths();
//        cert.CertificateStart = Utilities.getPlusMinusOneMonthStartDate(false, true);
//        
//  		pageDirectDebitDetails.SendCertificateStartDate(cert);
//  	}
//  	
//  	@And("^I send certificate current start date for twelve months$")
//    public void setTweleveMonthsCertificateStartCurrentDate() {
//  		
//  		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
//   	 
//	   	//get current date time with Date()
//	   	Date date = new Date();
//	   	 
//	   	// Now format the date
//	   	String date1= dateFormat.format(date);
//  		
//  		Certificate cert = TelesalesDataHelper.getCertificateTwelveMonths(date1);
//        cert.CertificateStart = Utilities.getCurrentDateStartDate(true);
//        
//  		pageDirectDebitDetails.SendCertificateStartDate(cert);
//  	}
//  	
//  	
//  	
//  	@And("^I send certificate duration for three months$")
//    public void setCertificateDurationThreeMonths() {
//  		
//  		Certificate cert = TelesalesDataHelper.getCertificate();
//        cert.CertificateDuration = Certificate.certificateDuration.ThreeMonths;
//        
//        pageCertificateDetails.SetCertificateDuration(cert);
//       
//  	}
//  	
//  	@And("^I send certificate duration for twelve months$")
//    public void setCertificateDurationTweleveMonths() {
//  		
//  		Certificate cert = TelesalesDataHelper.getCertificate();
//        cert.CertificateDuration = Certificate.certificateDuration.TwelveMonths;
//        
//        pageCertificateDetails.SetCertificateDuration(cert);
//       
//  	}
//  	
//  	
//  	@And("^I send certificate duration as current date$")
//    public void setCertificateDurationCurrentDateThreeMonths() {
//  		
//  		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
//    	 
//    	 //get current date time with Date()
//    	 Date date = new Date();
//    	 
//    	 // Now format the date
//    	 String date1= dateFormat.format(date);
//    	 
//  		
//  		Certificate cert = TelesalesDataHelper.getCertificate(date1);
//        cert.CertificateDuration = Certificate.certificateDuration.ThreeMonths;
//       
//  	}
//  	
//  	
//  	@And("^I click card payment call button$")
//    public void clickCardPaymentCallButton() {
//        
//  		pageCheckDetails.ClickCardPaymentCall();
//  	}
//  	
//  	
//  	@And("^I click back button for payment card details$")
//    public void clickCardPaymentBackButton() {
//        
//  		pagePaymentCardDetails.ClickBack();
//  	}
//  	
//  	
//  	@And("^I wait for page to load$")
//    public void waitForElementDirectDebitDetails() {
//        
//  		pageDirectDebitDetails_Methods.waitForElement();
//  	}
//  	
//  	
//  	@And("^I check correct bank name as \"(.*)\"$")
//    public void checkCorrectBankName(String bankNameText) {
//        
//  		pageDirectDebitDetails_Methods.isCorrectBankName(bankNameText);
//  	}
//  	
//  	
//  	@And("^I check correct bank address as \"(.*)\"$")
//    public void checkCorrectBankAddress(String bankAddressText) {
//        
//  		pageDirectDebitDetails_Methods.isCorrectBankAddress(bankAddressText);
//  	}
//  	
//  	
//  	@Then("^I click submit for direct debit details$")
//	public void SubmitDirectDebitDetails() {
//  		
//  		pageDirectDebitDetails.SubmitDirectDebitDetails();  
//	}
//  	
//  	@Then("^I click submit for credit debit details$")
//	public void SubmitCreditDebitDetails() {
//  		
//  		pageDirectDebitDetails.SubmitDirectDebitDetails();  
//	}
//  	
//  	@Then("^I click submit for certificate details$")
//	public void SubmitCertificateDetails() {
//  		
//  		pageDirectDebitDetails.SubmitDirectDebitDetails();  
//	}
//  	
//  	
//  	@Then("^I check correct sort code as '(.+)'$")
//	public void checkCorrectSortCode(String sortCode) {
//  		
//  		assertTrue("Sort Code does not match on the direct debit confirmation screen", pageDirectDebitConfirmation_Methods.isCorrectSortCode(sortCode)); 
//	}
//  	
//  	
//  	@Then("^I check correct account number as '(.+)'$")
//	public void checkCorrectAccountCode(String accountNumber) {
//  		
//  		assertTrue("Account Number does not match on the direct debit confirmation screen", pageDirectDebitConfirmation_Methods.isCorrectAccountCode(accountNumber)); 
//	}
//  	
//  	
//  	
//  	@Then("^I check server error '(.+)'$")
//	public void checkServerError(String serverError) {
//  		
//  		assertTrue("Sort code should have been left blank", pageDirectDebitDetails_Methods.isServerError(serverError));
//	}
//  	
//  	
//  	
//  	@Then("^I check account error as Sort Code not recognised$")
//	public void checkSortCodeNotRecognised() {
//  		
//  		//assertTrue("Sort code should have been left blank", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.SortCodeNotRecognised));
//	}
//  	
//  	
//  	@Then("^I check account error as Sort Code not number$")
//	public void checkSortCodeNotNumber() {
//  		
//  		//assertTrue("Sort code should have been invalid", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.SortCodeNotNumbers));
//	}
//  	
//  	
//  	@Then("^I check account error as invalid account number$")
//	public void checkInvalidAccountNumber() {
//  		
//  		//assertTrue("Account code should have been more than 8 characters", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.InvalidAccountNumber));
//	}
//  	
//  	
//  	@Then("^I check account error as not linked and invalid account$")
//	public void checkNotLinkedAndInvalidAccount() {
//  		
//  		//assertTrue("Sort Code/Account should have been valid, but not linked together", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.InvalidAccountNumber));
//	}
//  	
//  	
//  	@Then("^I check account error as account number short$")
//	public void checkAccountNumberShort() {
//  		
//  		//assertTrue("Account Number should have been leff than 8 characters", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.AccountNumberShort));
//	}
//  	
//  	
//  	@Then("^I check account error as account number not numeric$")
//	public void checkAccountNumberNotNumeric() {
//  		
//  		//assertTrue("Account code should have been all characters", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.AccountNumberNotNumeric));
//	}
//  	
//  	
//  	@Then("^I check account error as non DD account$")
//	public void checkAccountDoesNotAcceptDirectDebits() {
//  		
//  		//assertTrue("This should have been a non DD account", pageDirectDebitDetails.IsAccountErrorPresent(AccountError.AccountDoesNotAcceptDirectDebits));
//	}
//  	
//  	
//  	@When("^I click cancel button$")
//    public void cancelButton() {
//        
//  		telesalesBasePage.ButtonCancel.click(); 
//  	}
//  	
//  	@When("^I click back button$")
//    public void backButton() {
//        
//  		telesalesBasePage.ClickBack(); 
//  	}
//  	
//  	@And("^I click submit button for page Direct Debit details$")
//    public void submitDirectDebitDetailsButton() {
//        
//  		pageDirectDebitDetails.ClickSubmit(); 
//  	}
//  	
//  	@And("^I click submit button for page Direct Debit confirmation$")
//    public void submitDirectDebitConfirmationButton() {
//        
//  		pageDirectDebitConfirmation.ClickSubmit(); 
//  	}
//  	
//  	@And("^I get new certificate number$")
//    public void getNewCertificateNumber() {
//        
//  		//String certNumber = pageConfirmDirectDebit.getCertificateNumber();
//  		
//  		String locator = "//*[@id='container']/form/table/tbody/tr[4]/td[2]/span";	 	
//	 	String CertificateNumber = driver.findElement(By.xpath(locator)).getText();
//    	TestLogger.Info("New certificate number is: " + CertificateNumber);
//    	//assertTrue("Failed to get a certificate", pageConfirmDirectDebit_Methods.isCertificateIssued("Certificate Number"));
//    	
//  	}
//  	
//  	@When("^I click Edit button for due date$")
//    public void editButton() {
//        
//  		pageCertificateDetails.ButtonEditDD.click();
//  	}
//  	
//  	
//  	@When("^I edit direct debit due date by '(.+)' days$")
//    public void editDueDateDetails(int days) {
//        
//  		int existingDueDate = pageEditDirectDebitDetails.getDueDay() + days;
//        pageEditDirectDebitDetails.setDueDay(Integer.toString(existingDueDate));
//        
//  	}
//  	
//  	@When("^I verify Edit button error present$")
//    public void checkDueDayErrorPresent() {
//  		testBase.Wait(2);
//  		 assertTrue("Setting due date to less than 12 days should be not allowed", pageEditDirectDebitDetails_Methods.isDueDayErrorPresent());
//  	}
//  	
//  	
}