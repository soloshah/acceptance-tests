@regression @resolvedcases @cipipeline @heruko
Feature: Create New Complaint for Local Resolution with Active status



  Scenario Outline: Telephone - Create a New Complaint and Change status from Active to Resolved
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
    Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
	Then I click the tab "Case Management" 
    And I click the tab "Active Cases" 
    And I am redirected to "active cases" page
    Then I click the link "active case number"
   	And I am redirected to "view complaint" page
   	Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page
   	Then I change status to '<NewStatus>'
   	And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page    
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary												|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|NewStatus	|
	|TESTA		|Password1	|test			|Telephone	|0 			|CMP003197789	|Dutit		|18		|01/02/2017	|Customer satisfied and would recommend the service		|yes	|1		|1		|1		|1		|2			|2			|Resolved	|
	
	
  Scenario Outline: Letter - Create a New Complaint and Change status from Active to Resolved
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
    Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
	Then I click the tab "Case Management" 
    And I click the tab "Active Cases" 
    And I am redirected to "active cases" page
    Then I click the link "active case number"
   	And I am redirected to "view complaint" page
   	Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page
   	Then I change status to '<NewStatus>'
   	And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary																	|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|NewStatus	|
	|TESTA		|Password1	|test			|Letter		|0 			|CMP81197789 	|Bravo		|38		|01/01/2018	|Customer not happy and may be able to refer the complaint to the manager	|yes	|7		|2		|2		|1		|2			|2			|Resolved	|
	
	
	
  Scenario Outline: Email - Create a New Complaint and Change status from Active to Resolved
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
    Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
	Then I click the tab "Case Management" 
    And I click the tab "Active Cases" 
    And I am redirected to "active cases" page
    Then I click the link "active case number"
   	And I am redirected to "view complaint" page
   	Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page  	
   	Then I change status to '<NewStatus>'
   	And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary																	|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|NewStatus	|
	|TESTA		|Password1	|test			|Email		|0 			|CMP01597789	|Romai		|55		|05/09/2017	|Customer not happy and may be able to refer the complaint to the manager	|yes	|5		|1		|2		|1		|2			|2			|Resolved	|
	
	
	
  Scenario Outline: SocialMedia - Create a New Complaint and Change status from Active to Resolved
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
    Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
	Then I click the tab "Case Management" 
    And I click the tab "Active Cases" 
    And I am redirected to "active cases" page
    Then I click the link "active case number"
   	And I am redirected to "view complaint" page
   	Then I click the link "edit complaint"
   	And I am redirected to "edit complaint" page
   	Then I change status to '<NewStatus>'
   	And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type			|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary																		|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|NewStatus	|
	|TESTA		|Password1	|test			|SocialMedia	|0 			|CMP11597789	|IrKaw		|45		|05/09/2017	|Customer not happy and may be able to refer the complaint to the manager	|yes	|5		|1		|2		|1		|2			|2			|Resolved	|
	