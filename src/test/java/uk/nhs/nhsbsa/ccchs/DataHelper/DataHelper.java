package uk.nhs.nhsbsa.ccchs.DataHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uk.nhs.nhsbsa.ccchs.model.CreateNewComplaint;
import uk.nhs.nhsbsa.ccchs.model.CreateNewCustomer;
import uk.nhs.nhsbsa.ccchs.model.CreateNewUser;
import uk.nhs.nhsbsa.ccchs.model.EditExistingCustomer;
import uk.nhs.nhsbsa.ccchs.model.Search;
import uk.nhs.nhsbsa.ccchs.utils.Utilities;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class DataHelper {
	

//	/**
//	 * returns search object with no previous certificate number or direct debit
//	 * reference
//	 * 
//	 * @return
//	 */
//	public static Search getSearch() {
//
//		Search search = new Search();
//
//		search.CertificateNumber = "";
//		search.DirectDebitReference = "";
//		search.Dob = "";
//		search.Postcode = "";
//		search.Surname = "";
//
//		search.CertificateNumber = "10000000003";
////		search.Surname = Utilities.getRandomAlphaNumeric(10,Utilities.RandomType.Alpha);
//	//	search.Dob = "101080";
////		search.Postcode = Utilities.getRandomPostCode(Utilities.PostCodeCountry.England);
//
//		return search;
//	}
//	
//	
//	
//	
//	
//	public static Search enterCertNum(String certNo) {
//
//		Search search = new Search();
//
//		search.CertificateNumber = "";
//		search.DirectDebitReference = "";
//		search.Dob = "";
//		search.Postcode = "";
//		search.Surname = "";
//
//		search.CertificateNumber = certNo;
////		search.Surname = Utilities.getRandomAlphaNumeric(10,Utilities.RandomType.Alpha);
//	//	search.Dob = "101080";
////		search.Postcode = Utilities.getRandomPostCode(Utilities.PostCodeCountry.England);
//
//		return search;
//	}
//	
//	
//	public static Search enterDDRef(String ddRef) {
//
//		Search search = new Search();
//
//		search.CertificateNumber = "";
//		search.DirectDebitReference = "";
//		search.Dob = "";
//		search.Postcode = "";
//		search.Surname = "";
//
//		search.DirectDebitReference = ddRef;
//
//		return search;
//	}
//	
//	
//	
//	public static Search enterSurnameAndDOB(String surname, String dob) {
//
//		Search search = new Search();
//
//		search.CertificateNumber = "";
//		search.DirectDebitReference = "";
//		search.Dob = "";
//		search.Postcode = "";
//		search.Surname = "";
//
//		search.Dob = dob;
//		search.Surname = surname;
//
//		return search;
//	}
//	
//	
//	
//	/**
//	 * returns search object with a valid previous certificate number
//	 * 
//	 * @return
//	 */
//	public static Search getValidSearchViaCertNumber(String certNumber) {
//
//		Search search = new Search();
//
//		search.CertificateNumber = "";
//		search.DirectDebitReference = "";
//		search.Dob = "";
//		search.Postcode = "";
//		search.Surname = "";
//
//		search.CertificateNumber = certNumber;
//
//		return search;
//	}	
//	
//	/**
//	 * returns search object with a valid previous DD ref number
//	 * 
//	 * @return
//	 */
//	public static Search getValidSearchViaDDref(String ddRef) {
//
//		Search search = new Search();
//
//		search.CertificateNumber = "";
//		search.DirectDebitReference = "";
//		search.Dob = "";
//		search.Postcode = "";
//		search.Surname = "";
//
//		search.DirectDebitReference = ddRef;
//
//		return search;
//	}	
//	
//	/**
//	 * returns search object with a valid previous Surname and Dob
//	 * 
//	 * @return
//	 */
//	public static Search getValidSearchViaSurnameDob(String surname, String dob) {
//
//		Search search = new Search();
//
//		search.CertificateNumber = "";
//		search.DirectDebitReference = "";
//		search.Dob = "";
//		search.Postcode = "";
//		search.Surname = "";
//
//		search.Surname = surname;
//		search.Dob = dob;
//		
//		return search;
//	}		
	
	public static CreateNewCustomer getApplicantByName() {

		CreateNewCustomer createNewCustomer = new CreateNewCustomer();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);
	
		/* Customer Details */
		createNewCustomer.titlevalue = (CreateNewCustomer.title.valueOf("Mr").ordinal()) + 1;
		createNewCustomer.Name = "test" + Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Alpha);
		createNewCustomer.Surname = Utilities.getRandomAlphaNumeric(6, Utilities.RandomType.Alpha);
		createNewCustomer.Dob = Utilities.getPlusMinusOneMonthStartDate(false, false);
		
		return createNewCustomer;
		
	}
	
	
	public static CreateNewCustomer getApplicantBySurname() {

		CreateNewCustomer createNewCustomer = new CreateNewCustomer();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);
	
		/* Customer Details */
		createNewCustomer.titlevalue = (CreateNewCustomer.title.valueOf("Mr").ordinal()) + 1;
		createNewCustomer.Name = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Alpha);
		createNewCustomer.Surname = "test" +  Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Alpha);
		createNewCustomer.Dob = Utilities.getPlusMinusOneMonthStartDate(false, false);
		

		return createNewCustomer;
		
	}
	
	
	public static CreateNewCustomer getApplicantByAddress() {

		CreateNewCustomer createNewCustomer = new CreateNewCustomer();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);
		
		/* Address */
		createNewCustomer.Addr1 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		createNewCustomer.Addr2 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		createNewCustomer.TownCity = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		createNewCustomer.PostCode = Utilities.getRandomPostCode(Utilities.PostCodeCountry.Durham);
			
		return createNewCustomer;
		
	}
	
	public static CreateNewCustomer getApplicantByContactDetails() {

		CreateNewCustomer createNewCustomer = new CreateNewCustomer();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);
		
		/* Contact Details */
		createNewCustomer.HomePhone = "0" + Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Num);
		createNewCustomer.MobilePhone = "0" + Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Num);
		createNewCustomer.Email = "test" + randnum + "@test.com";

		return createNewCustomer;
		
	}
	
	
	public static EditExistingCustomer getUpdatedCustomerDetailsApplicant() {

		EditExistingCustomer editExistingCustomer = new EditExistingCustomer();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);
	
		/* Customer Details */
		editExistingCustomer.titlevalue = (EditExistingCustomer.title.valueOf("Mr").ordinal()) + 1;
		editExistingCustomer.Name = "test" + Utilities.getRandomAlphaNumeric(7, Utilities.RandomType.Alpha);
		editExistingCustomer.Surname = "test" + Utilities.getRandomAlphaNumeric(6, Utilities.RandomType.Alpha);
		editExistingCustomer.Dob = /* Utilities.getPlusMinusOneMonthStartDate(false, false); */ "01/12/1985";

		return editExistingCustomer;
		
	}
	
	
	public static EditExistingCustomer getUpdatedAddressDetailsApplicant() {

		EditExistingCustomer editExistingCustomer = new EditExistingCustomer();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);

		/* Address */
		editExistingCustomer.Addr1 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		editExistingCustomer.Addr2 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		editExistingCustomer.TownCity = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		editExistingCustomer.PostCode = Utilities.getRandomPostCode(Utilities.PostCodeCountry.Durham);


		return editExistingCustomer;
		
	}
		
	
	
	public static EditExistingCustomer getUpdatedContactDetailsApplicant() {

		EditExistingCustomer editExistingCustomer = new EditExistingCustomer();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);
		
		/* Contact Details */
		editExistingCustomer.HomePhone = "0191" + Utilities.getRandomAlphaNumeric(7, Utilities.RandomType.Num);
		editExistingCustomer.MobilePhone = "07" + Utilities.getRandomAlphaNumeric(9, Utilities.RandomType.Num);
		editExistingCustomer.Email = "test" + randnum + "@test.com";

		return editExistingCustomer;
		
	}
	

	
	public static EditExistingCustomer getUpdatedApplicant() {

		EditExistingCustomer editExistingCustomer = new EditExistingCustomer();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);
	
		/* Customer Details */
		editExistingCustomer.Title = EditExistingCustomer.title.Mr;
		editExistingCustomer.Name = Utilities.getRandomAlphaNumeric(7, Utilities.RandomType.Alpha);
		editExistingCustomer.Surname = Utilities.getRandomAlphaNumeric(6, Utilities.RandomType.Alpha);
		editExistingCustomer.Dob = /* Utilities.getPlusMinusOneMonthStartDate(false, false); */ "01/12/1985";
		
		
		/* Address */
		editExistingCustomer.Addr1 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		editExistingCustomer.Addr2 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		editExistingCustomer.TownCity = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		editExistingCustomer.PostCode = Utilities.getRandomPostCode(Utilities.PostCodeCountry.England);
				
		
		/* Contact Details */
		editExistingCustomer.HomePhone = "0191" + Utilities.getRandomAlphaNumeric(7, Utilities.RandomType.Num);
		editExistingCustomer.MobilePhone = "07" + Utilities.getRandomAlphaNumeric(9, Utilities.RandomType.Num);
		editExistingCustomer.Email = "test" + randnum + "@test.com";

		return editExistingCustomer;
		
	}

	
	
	public static CreateNewUser getNewAdministratorUser() {

		CreateNewUser createNewUser = new CreateNewUser();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Alpha);

		createNewUser.Username = randnum;
		createNewUser.Password = "Password1";
		createNewUser.EmailAddress = "test" + randnum + "@test.com";
		
		createNewUser.UserRole = CreateNewUser.user_role.Administrator;
		createNewUser.AccountEnabled = CreateNewUser.account_enabled.True;

		return createNewUser;
		
	}
	
	
	public static CreateNewUser getNewSuperUserUser() {

		CreateNewUser createNewUser = new CreateNewUser();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);

		createNewUser.Username = "tester" + randnum;
		createNewUser.Password = "password";
		createNewUser.EmailAddress = "test" + randnum + "@test.com";
		
		createNewUser.UserRole = CreateNewUser.user_role.SuperUser;
		createNewUser.AccountEnabled = CreateNewUser.account_enabled.True;

		return createNewUser;
		
	}
	
	
	public static CreateNewUser getNewStandardUser() {

		CreateNewUser createNewUser = new CreateNewUser();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);

		createNewUser.Username = "tester" + randnum;
		createNewUser.Password = "password";
		createNewUser.EmailAddress = "test" + randnum + "@test.com";
		
		createNewUser.UserRole = CreateNewUser.user_role.Standard;
		createNewUser.AccountEnabled = CreateNewUser.account_enabled.True;

		return createNewUser;
		
	}
	
	
	public static CreateNewUser getNewManagerUser() {

		CreateNewUser createNewUser = new CreateNewUser();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);

		createNewUser.Username = "tester" + randnum;
		createNewUser.Password = "password";
		createNewUser.EmailAddress = "test" + randnum + "@test.com";
		
		createNewUser.UserRole = CreateNewUser.user_role.Manager;
		createNewUser.AccountEnabled = CreateNewUser.account_enabled.True;

		return createNewUser;
		
	}
	
	
	
	public static String UpdateEmailAddressExistingUser() {

		CreateNewUser createNewUser = new CreateNewUser();
		
		String randnum = Utilities.getRandomAlphaNumeric(5, Utilities.RandomType.Num);

		createNewUser.EmailAddress = "test" + randnum + "@test.com";

		return (createNewUser.EmailAddress);
		
	}
	
	
	public static String UpdateNewPasswordExistingUser() {

		CreateNewUser createNewUser = new CreateNewUser();
	
		createNewUser.Password = "Password2";

		return (createNewUser.Password);
		
	}
	
	public static String UpdateOldPasswordExistingUser() {

		CreateNewUser createNewUser = new CreateNewUser();
	
		createNewUser.Password = "Password1";

		return (createNewUser.Password);
		
	}
	
	
	
	public static String UpdateNewUsernameExistingUser() {

		CreateNewUser createNewUser = new CreateNewUser();

		createNewUser.Username = "TESTE";

		return (createNewUser.Username);
		
	}
	
	
	public static String UpdateOldUsernameExistingUser() {

		CreateNewUser createNewUser = new CreateNewUser();

		createNewUser.Username = "TESTA";

		return (createNewUser.Username);
		
	}
	
	

//	public static Certificate getCertificate() {
//
//		Certificate cert = new Certificate();
//
//		cert.CertificateDuration = Certificate.certificateDuration.ThreeMonths;
//		cert.CertificateStart = "101016";
//		cert.CertificateNotes = "";
//
//		return cert;
//	}
//
//	public static Certificate getCertificate(String startDate) {
//
//		Certificate cert = new Certificate();
//
//		cert.CertificateDuration = Certificate.certificateDuration.ThreeMonths;
//		cert.CertificateStart = startDate;
//		cert.CertificateNotes = "";
//
//		return cert;
//	}
//	
//	public static Certificate getCertificateTwelveMonths(String startDate) {
//
//		Certificate cert = new Certificate();
//
//		cert.CertificateDuration = Certificate.certificateDuration.TwelveMonths;
//		cert.CertificateStart = startDate;
//		cert.CertificateNotes = "";
//
//		return cert;
//	}
//	
//	
//	public static Certificate getCertificateTwelveMonths() {
//
//		Certificate cert = new Certificate();
//
//		cert.CertificateDuration = Certificate.certificateDuration.TwelveMonths;
//		cert.CertificateStart = "101016";
//		cert.CertificateNotes = "";
//
//		return cert;
//	}
//
//	/**
//	 * returns a random valid account object
//	 * 
//	 * @return
//	 */
//	public static Account getValidAccount() {
//
//		List<Pair<String, String>> accounts = validAccounts();
//
//		Random random = new Random();
//		int index = random.nextInt(accounts.size());
//		Pair<String, String> account = accounts.get(index);
//
//		Account acc = new Account();
//
//		acc.SortCode = account.getKey().toString();
//		acc.AccountNumber = account.getValue().toString();
//		acc.thirdParty = Account.ThirdParty.n;
//		
//		return acc;
//	}
//
//	/**
//	 * Uses LLoyds as the Sort code 
//	 * returns a valid object
//	 * 
//	 * @return
//	 */
//	public static Account getValidLLoydsAccount() {
//
//		List<Pair<String, String>> accounts = validAccounts();
//
//		Random random = new Random();
//		int index = random.nextInt(accounts.size());
//		Pair<String, String> account = accounts.get(index);
//
//		Account acc = new Account();
//
//	    acc.SortCode = "302556";            
//	    acc.AccountNumber = "32029501";		
//		acc.thirdParty = Account.ThirdParty.n;
//		
//		return acc;
//	}
//	
//	/**
//	 * Uses RBS as the Sort code 
//	 * returns a valid object
//	 * 
//	 * @return
//	 */
//	public static Account getValidRBSAccount() {
//
//		List<Pair<String, String>> accounts = validAccounts();
//
//		Random random = new Random();
//		int index = random.nextInt(accounts.size());
//		Pair<String, String> account = accounts.get(index);
//
//		Account acc = new Account();
//
//	    acc.SortCode = "163032";            
//	    acc.AccountNumber = "10050518";
//	    
//		acc.thirdParty = Account.ThirdParty.n;
//		
//		return acc;
//	}
//	
//	/**
//	 * Uses NatWest as the Sort code 
//	 * returns a valid object
//	 * 
//	 * @return
//	 */
//	public static Account getValidNatWestAccount() {
//
//		List<Pair<String, String>> accounts = validAccounts();
//
//		Random random = new Random();
//		int index = random.nextInt(accounts.size());
//		Pair<String, String> account = accounts.get(index);
//
//		Account acc = new Account();
//
//	    acc.SortCode = "604005";            
//        acc.AccountNumber = "24605999";
//        
//		acc.thirdParty = Account.ThirdParty.n;
//		
//		return acc;
//	}
//	
//	/**
//	 * Uses Halifix as the Sort code, but the card does not accept direct credit
//	 * returns a valid object
//	 * 
//	 * @return
//	 */
//	public static Account getDirectCredit() {
//
//		List<Pair<String, String>> accounts = validAccounts();
//
//		Random random = new Random();
//		int index = random.nextInt(accounts.size());
//		Pair<String, String> account = accounts.get(index);
//
//		Account acc = new Account();
//
//	    acc.SortCode = "111545";            
//        acc.AccountNumber = "00000003";
//        
//		acc.thirdParty = Account.ThirdParty.n;
//		
//		return acc;
//	}
//	
//	/**
//	 * returns an object, that contains a valid account code, but no sort code
//	 * 
//	 * @return
//	 */
//	public static Account getNoSortCodeAccount() {
//
//		List<Pair<String, String>> accounts = validAccounts();
//
//		Random random = new Random();
//		int index = random.nextInt(accounts.size());
//		Pair<String, String> account = accounts.get(index);
//
//		Account acc = new Account();
//
//        acc.SortCode = "";            
//        acc.AccountNumber = "32029501";
//        
//		acc.thirdParty = Account.ThirdParty.n;
//		
//		return acc;
//	}	
//	
//	/**
//	 * returns an account object which does not accept direct debits
//	 * 
//	 * @return
//	 */
//	public static Account getAccountDoesNotAcceptDirectDebit() {
//
//		Account acc = new Account();
//
//		acc.AccountNumber = "00707810";
//		acc.SortCode = "090415";
//
//		acc.thirdParty = Account.ThirdParty.n;
//
//		return acc;
//	}
//
//	/**
//	 * returns an account object which contains a valid sort code and account code, but they are not linked together
//	 * 
//	 * @return
//	 */
//	public static Account getNotLinkedAccount() {
//
//		Account acc = new Account();
//
//	    acc.SortCode = "302556";            
//	    acc.AccountNumber = "10050518";
//
//		acc.thirdParty = Account.ThirdParty.n;
//
//		return acc;
//	}
//    
//	/**
//	 * returns an account with an invalid account number
//	 * 
//	 * @return
//	 */
//	public static Account getInvalidAccount() {
//
//		Account acc = new Account();
//
//		acc.AccountNumber = "00707810";
//		acc.SortCode = "300002";
//
//		acc.thirdParty = Account.ThirdParty.n;
//
//		return acc;
//	}
//	
//	/**
//	 * returns an account with an invalid sort code
//	 * 
//	 * @return
//	 */
//	public static Account getInvalidSortCodeAccount() {
//
//		Account acc = new Account();
//
//		acc.AccountNumber = "32029501";
//		acc.SortCode = "123456";
//
//		acc.thirdParty = Account.ThirdParty.n;
//
//		return acc;
//	}	
//	
//	/**
//	 * returns an account with a sort code containing characters
//	 * 
//	 * @return
//	 */
//	public static Account getCharSortCodeAccount() {
//
//		Account acc = new Account();
//
//	    acc.SortCode = "helloo";  //an invalid sort code
//        acc.AccountNumber = "3202555"; //an invalid account code
//		acc.thirdParty = Account.ThirdParty.n;
//
//		return acc;
//	}
//	
//	/**
//	 * returns an account with a sort code containing '-' characters
//	 * 
//	 * @return
//	 */
//	public static Account getPartCompletedSortCodeValidAccount() {
//
//		Account acc = new Account();
//
//	    acc.SortCode = "12-34-";  //an invalid sort code
//        acc.AccountNumber = "3202555"; //an invalid account code
//		acc.thirdParty = Account.ThirdParty.n;
//
//		return acc;
//	}	
//	
//	/**
//	 * returns an account with a Account that contains 8 characters
//	 * 
//	 * @return
//	 */
//	public static Account getAccount8Chars() {
//
//		Account acc = new Account();
//
//		acc.SortCode = "302556";  //a valid sort code
//        acc.AccountNumber = "000222898"; //an invalid account code
//        
//		acc.thirdParty = Account.ThirdParty.n;
//
//		return acc;
//	}		
//
//	/**
//	 * returns an account with a Account that contains 5 characters
//	 * 
//	 * @return
//	 */
//	public static Account getAccount5Chars() {
//
//		Account acc = new Account();
//
//		acc.SortCode = "302556";  //a valid sort code
//        acc.AccountNumber = "22898"; //an invalid account code
//        
//		acc.thirdParty = Account.ThirdParty.n;
//
//		return acc;
//	}
//	
//	/**
//	 * returns an account with a Account that contains all characters
//	 * 
//	 * @return
//	 */
//	public static Account getAccountAllChars() {
//
//		Account acc = new Account();
//
//		acc.SortCode = "302556";  //a valid sort code
//        acc.AccountNumber = "helloo"; //an invalid account code
//        
//		acc.thirdParty = Account.ThirdParty.n;
//
//		return acc;
//	}	
//		
//	/**
//	 * list of valid account numbers and sort codes, update this when you have
//	 * the correct test data from the new provider
//	 * 
//	 * @return
//	 */
//	public static List<Pair<String, String>> validAccounts() {
//
//		// /"F:\Professional Services\E2E Testing\End To End Testing\BP079 DD
//		// Replacement
//		// \MainRelease_Nov15\Dummy Card & Direct Debit Account Nos"
//
//		// note we're using a pair here because a map won't work,
//		// the sort code is the same for each account in the current test data
//		// map requires a unique key:
//
//		List<Pair<String, String>> accounts = new ArrayList<>();
//
//		Pair<String, String> acc1 = new ImmutablePair<String, String>("302556", "32029501");
//		Pair<String, String> acc2 = new ImmutablePair<String, String>("302556", "59946655");
//		Pair<String, String> acc3 = new ImmutablePair<String, String>("302556", "75079226");
//		Pair<String, String> acc4 = new ImmutablePair<String, String>("302556", "53981653");
//		Pair<String, String> acc5 = new ImmutablePair<String, String>("302556", "76099040");
//		Pair<String, String> acc6 = new ImmutablePair<String, String>("302556", "62180249");
//
//		accounts.add(acc1);
//		accounts.add(acc2);
//		accounts.add(acc3);
//		accounts.add(acc4);
//		accounts.add(acc5);
//		accounts.add(acc6);
//
//		return accounts;
//	}
//
}
