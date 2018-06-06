@editcomplaint @regression 
Feature: Edit an existing Complaint functionality

@cipipeline @heruko
  Scenario Outline: Validation BLANK error messages for New Complaint
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
	And I click the button "SaveComplaint"
	Then I send and verify empty message for New Complaint
	And I send and verify empty details Reference for New Complaint
	And I send and verify empty details Assigned By for New Complaint
	And I send and verify empty details Team for New Complaint
	Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page

	Examples:
	|username 	|password	|SearchName	|
	|TESTB		|Password1	|test		|
	


  Scenario Outline: Validation error messages for New Complaint
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
	And I send and verify Reference '<Reference>' for New Complaint
	And I send and verify Assigned By '<AssignedBy>' for New Complaint
	And I send and verify Team '<Team>' for New Complaint
	Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page

	Examples:
	|username 	|password	|SearchName		|Reference		|AssignedBy	|Team		|
	|TESTB		|Password1	|test			|*&^%$			|!&^%$		|(%$&}		|
	|TESTB		|Password1	|test			|466/77			|HR/po		|100		|
	|TESTB		|Password1	|test			|5346(12)		|jones12	|ccs1/10	|
	|TESTB		|Password1	|test			|CEMS-12/ccch	|KEM12		|ccs1@		|
	|TESTB		|Password1	|test			|CEMS.98251		|Ph.115		|ccs.1		|
	|TESTB		|Password1	|test			|CESoprmdDrcKK	|CES.H		|a1			|
	|TESTB		|Password1	|test			|1234567890123	|jonesess	|100		|
	
	
@cipipeline @heruko
  Scenario Outline: Validation Max characters complaint summary error message for New Complaint
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
	And I send and verify Complaint Summary '<ComplaintSummary>' for New Complaint
	Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page

	Examples:
	|username 	|password	|SearchName	|ComplaintSummary																																																																																																		|
	|TESTB		|Password1	|test		|My search lead me to another better approach to solving this problem. I thought why not copy the JDK folder to appropriate and provide that as a -vm parameter to eclipse. both startup time and performance could be drastically improved. Lo and behold! Eclipse runs about 10 times faster on my ubuntu machine. Try it yourself and let me know (If you are having performance issues with Eclipse, that is..-).	|
	
	
@cipipeline @heruko
  Scenario Outline: Validation BLANK error messages for Edit Complaint
	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    And I am redirected to "search result" page
    Then I click the link "customerReference" 
    And I am redirected to "view customer" page
    Then I click the link "cemsReference"
    And I am redirected to "view complaint" page
    Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page	
	And I send and verify empty details Reference for Edit Complaint
	And I send and verify empty details Assigned By for Edit Complaint
	And I send and verify empty details Team for Edit Complaint
	And I send and verify empty details Complaint Summary for Edit Complaint
	Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page

	Examples:
	|username 	|password	|SearchName	|
	|TESTB		|Password1	|test		|
	
	

  Scenario Outline: Edit an existing Complaint for Edit complaint link
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I am redirected to "search result" page
    Then I click the link "customerReference" 
    And I am redirected to "view customer" page
    Then I click the link "cemsReference"
    And I am redirected to "view complaint" page
    Then I click the link "editComplaint"
    Then I am redirected to "edit complaint" page
    And I send and verify Reference '<Reference>' for New Complaint
	And I send and verify Assigned By '<AssignedBy>' for Edit Complaint
	And I send and verify Team '<Team>' for Edit Complaint
	Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page

	Examples:
	|username 	|password	|SearchName		|Reference		|AssignedBy	|Team		|
	|TESTB		|Password1	|test			|*&^%$			|!&^%$		|(%$&}		|
	|TESTB		|Password1	|test			|466/77			|HR/po		|100		|
	|TESTB		|Password1	|test			|5346(12)		|jones12	|ccs1/10	|
	|TESTB		|Password1	|test			|CEMS-12/ccch	|KEM12		|ccs1@		|
	|TESTB		|Password1	|test			|CEMS.98251		|Ph.115		|ccs.1		|
	|TESTB		|Password1	|test			|CESoprmdDrcKK	|CES.H		|a1			|
	|TESTB		|Password1	|test			|1234567890123	|jonesess	|100		|
    
	
@cipipeline @heruko
	Scenario Outline: Validation Max characters complaint summary error message for Edit Complaint Super user
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    And I am redirected to "search result" page
    Then I click the link "customerReference" 
    And I am redirected to "view customer" page
    Then I click the link "cemsReference"
    And I am redirected to "view complaint" page
    Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page	
	#And I check Complaint Summary is editable for Edit Complaint
	And I send and verify Complaint Summary '<ComplaintSummary>' for New Complaint
	Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page

	Examples:
	|username 	|password	|SearchName	|ComplaintSummary																																																																																																		|
	|TESTB		|Password1	|test		|My search lead me to another better approach to solving this problem. I thought why not copy the JDK folder to appropriate and provide that as a -vm parameter to eclipse. both startup time and performance could be drastically improved. Lo and behold! Eclipse runs about 10 times faster on my ubuntu machine. Try it yourself and let me know (If you are having performance issues with Eclipse, that is..-).	|
	


@cipipeline @heruko
	Scenario Outline: Validation Max characters complaint summary error message for Edit Complaint Administrator user
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    And I am redirected to "search result" page
    Then I click the link "customerReference" 
    And I am redirected to "view customer" page
    Then I click the link "cemsReference"
    And I am redirected to "view complaint" page
    Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page	
	And I send and verify Complaint Summary '<ComplaintSummary>' for New Complaint
	Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page

	Examples:
	|username 	|password	|SearchName	|ComplaintSummary																																																																																																		|
	|TESTA		|Password1	|test		|My search lead me to another better approach to solving this problem. I thought why not copy the JDK folder to appropriate and provide that as a -vm parameter to eclipse. both startup time and performance could be drastically improved. Lo and behold! Eclipse runs about 10 times faster on my ubuntu machine. Try it yourself and let me know (If you are having performance issues with Eclipse, that is..-).	|
	

	
@cipipeline @heruko
	Scenario Outline: Validation Max characters complaint summary error message for Edit Complaint Standard user
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Surname" by '<SearchName>'
    And I click the button "Search"
    And I am redirected to "search result" page
    Then I click the link "customerReference" 
    And I am redirected to "view customer" page
    Then I click the link "cemsReference"
    And I am redirected to "view complaint" page
    Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page
	And I check Complaint Summary is editable for Edit Complaint
	Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page

	Examples:
	|username 	|password	|SearchName	|ComplaintSummary																																																																																																		|
	|TESTC		|Password1	|test		|My search lead me to another better approach to solving this problem. I thought why not copy the JDK folder to appropriate and provide that as a -vm parameter to eclipse. both startup time and performance could be drastically improved. Lo and behold! Eclipse runs about 10 times faster on my ubuntu machine. Try it yourself and let me know (If you are having performance issues with Eclipse, that is..-).	|
	

	