@user_mgmt @regression
Feature: User Management functionality

@cipipeline @heruko
  Scenario Outline: Create New users as Administrator
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the button "Add New User"
    And I am redirected to "new user" page
    And I send new '<userType>' user details
    And I click the button "logout" 
    And I am redirected to "logout" page
    
 	Examples:
	|username 	|password	|userType		|SearchName	|
	|TESTA		|Password1	|Administrator	|test		|
	|TESTA		|Password1	|Manager		|test		|
	
	
@cipipeline @heruko
  Scenario Outline: Create New user and log in to check it works
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the button "Add New User"
    And I am redirected to "new user" page
    And I create new user and log in
    And I click the button "signin"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page

 	
 	Examples:
	|username 	|password	|userType		|SearchName	|
	|TESTA		|Password1	|Administrator	|test		|
	

@cipipeline @heruko 
  Scenario Outline: Verify Manager user role can't view User Mgt tab 
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    And I verify that access is denied to User Mgt tab
    Then I click the link "Go To Home Page" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|userType		|SearchName	|
	|TESTD		|Password1	|Manager		|test		|



@cipipeline @heruko
  Scenario Outline: Validate BLANK error messages on Create New users
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the button "Add New User"
    And I am redirected to "new user" page
    Then I send and verify blank details for User Management
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName	|
	|TESTA		|Password1	|test		|



  Scenario Outline: Validate error messages on Create New users Username
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I search for "Username" by '<SearchName>'
    Then I click the button "Search"
    Then I click the button "Create New User"
    And I am redirected to "new user" page
    Then I send and verify incorrect details '<text>' for User Management Username
  	Then I click the link "Back"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName	|text					|
	|TESTA		|Password1	|test		|						|
	|TESTA		|Password1	|test		|12345					|
	|TESTA		|Password1	|test		|aa345					|
	|TESTA		|Password1	|test		|12345678				|
	|TESTA		|Password1	|test		|aa345678				|		
	|TESTA		|Password1	|test		|ne						|
	|TESTA		|Password1	|test		|!"£!"					|
	|TESTA		|Password1	|test		|TESTATESTBTESTCTESTD	|



  Scenario Outline: Validate error messages on Create New users Password
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I search for "Username" by '<SearchName>'
    Then I click the button "Search"
    Then I click the button "Create New User"
    And I am redirected to "new user" page
    Then I send and verify incorrect details '<NewPassword>' for User Management Password
  	Then I click the link "Back"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName	|NewPassword			|
	|TESTA		|Password1	|test		|						|
	|TESTA		|Password1	|test		|12345					|
	|TESTA		|Password1	|test		|aa345					|
	|TESTA		|Password1	|test		|12345678				|
	|TESTA		|Password1	|test		|aa345678				|		
	|TESTA		|Password1	|test		|ne						|
	|TESTA		|Password1	|test		|!"£!"					|
	|TESTA		|Password1	|test		|Password12345			|
	|TESTA		|Password1	|test		|TESTATESTBTESTCTESTD	|
	
	

  Scenario Outline: Validate error messages on Create New users Email
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I search for "Username" by '<SearchName>'
    Then I click the button "Search"
    Then I click the button "Create New User"
    And I am redirected to "new user" page
    Then I send and verify incorrect details '<NewEmail>' for User Management Email
  	Then I click the link "Back"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName	|NewEmail		|
	|TESTA		|Password1	|test		|				|	
	|TESTA		|Password1	|test		|v				|	
	|TESTA		|Password1	|test		|v@				|
	|TESTA		|Password1	|test		|v@.			|
	|TESTA		|Password1	|test		|!"@test.com	|
	|TESTA		|Password1	|test		|test@test.com"	|
	|TESTA		|Password1	|test		|t@t.com^&^		|
	
	

  Scenario Outline: Validate error messages on Create New users Account Enabled
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I search for "Username" by '<SearchName>'
    Then I click the button "Search"
    Then I click the button "Create New User"
    And I am redirected to "new user" page
    Then I send and verify incorrect details for User Management Account Enabled
  	Then I click the link "Back"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    
    Examples:
	|username 	|password	|SearchName	|													
	|TESTA		|Password1	|test		|			
	

  Scenario Outline: Edit email address for already created users
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the button "Search"
    Then I click existing user to amend '<userId>'
    And I update existing user '<email>'
	And I click the button "Save User" 
    Then I click the link "Back" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|userId		|email			|
	|TESTA		|Password1	|00005		|Email Address	|
	
	
@cipipeline @heruko
  Scenario Outline: Edit password for already created users
 	Given I open the login page
 	When I enter '<username>' and '<pwd>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the link "edit TESTA user"
    And I am redirected to "edit user" page
    And I update existing user '<newpassword>'
    And I click the button "Save User" 
    Then I am redirected to "admin" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    
    # ********** Again login with new password ***********
    When I enter '<username>' and '<newpwd>'
   	And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the link "edit TESTA user"
    And I am redirected to "edit user" page
    And I update existing user '<oldpassword>'
    And I click the button "Save User" 
    Then I am redirected to "admin" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    
	# *********** Verify changed back **************
	When I enter '<username>' and '<pwd>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    

 	Examples:
	|username 	|pwd			|userId		|oldpassword|newpassword	|newpwd		|
	|TESTA		|Password1		|00005		|Password	|NewPassword	|Password2	|
	
	
@cipipeline @heruko
  Scenario Outline: Edit username for already created users
 	Given I open the login page
 	When I enter '<username>' and '<pwd>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the link "edit TESTA user"
    And I am redirected to "edit user" page
    And I update existing user '<New_usernameType>'
    And I update existing user '<oldpassword>'
    And I click the button "Save User" 
    Then I am redirected to "admin" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    
     # ******* Again login with new username ********
    When I enter '<new_username>' and '<pwd>'
    And I click the button "signin" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the link "edit TESTE user"
    And I am redirected to "edit user" page
    And I update existing user '<Old_usernameType>'
    And I update existing user '<oldpassword>'
    And I click the button "Save User" 
    And I am redirected to "admin" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    
    # *********** Verify changed back **************
	When I enter '<username>' and '<pwd>'
    And I click the button "signin" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    
 	
 	Examples:
	|username 	|pwd			|userId		|New_usernameType	|new_username	|Old_usernameType	|oldpassword|
	|TESTA		|Password1		|00005		|NewUsername		|TESTE			|OldUsername		|Password	|
	
	

  Scenario Outline: Verify username can be disabled
 	Given I open the login page
 	When I enter '<username>' and '<pwd>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the button "Search"
    Then I click existing user to amend '<userId>'
    And I update existing user '<DisableUser>'
    And I update existing user '<oldpassword>'
    And I click the button "Save User" 
    Then I click the link "Back" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    
     # ******* Attempt login with disabled username ********
    When I enter '<new_username>' and '<newpwd>'
    And I click the button "login" 
    Then I will get error message as '<error_msg>' with '<error_msg_id>' 
	And I am redirected to "login error" page
    
    # *********** Re-enable user **************
   	When I enter '<username>' and '<pwd>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the button "Search"
    Then I click existing user to amend '<userId>'
    And I update existing user '<EnableUser>'
    And I update existing user '<oldpassword>'
    And I click the button "Save User" 
    Then I click the link "Back" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    
    # *********** Verify re-enabled **************
	When I enter '<new_username>' and '<newpwd>'
    And I click the button "login" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
    
 	
 	Examples:
	|username 	|pwd		|userId		|DisableUser	|oldpassword	|new_username	|newpwd		|EnableUser	|error_msg 											|error_msg_id	|
	|TESTA		|Password1	|00006		|DisableUser	|Password		|TESTB			|Password1	|EnableUser	|Username or Password is wrong. Please check again	|error-message	|		

	

  Scenario Outline: Validate error messages on Existing users Username
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the button "Search"
    Then I click existing user to amend '<userId>'
    Then I send and verify incorrect details '<NewUsername>' for User Management Username
  	Then I click the link "Back"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|userId	|NewUsername			|
	|TESTA		|Password1	|00005	|						|
	|TESTA		|Password1	|00005	|12345					|
	|TESTA		|Password1	|00005	|aa345					|
	|TESTA		|Password1	|00005	|12345678				|
	|TESTA		|Password1	|00005	|aa345678				|		
	|TESTA		|Password1	|00005	|ne						|
	|TESTA		|Password1	|00005	|!"£!"					|
	|TESTA		|Password1	|00005	|TESTATESTBTESTCTESTD	|
	
	

  Scenario Outline: Validate error messages on Existing users Password
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the button "Search"
    Then I click existing user to amend '<userId>'
    Then I send and verify incorrect details '<NewPassword>' for User Management Password
  	Then I click the link "Back"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|userId		|NewPassword			|
	|TESTA		|Password1	|00005		|						|
	|TESTA		|Password1	|00005		|ne1do1do				|
	|TESTA		|Password1	|00005		|12345					|
	|TESTA		|Password1	|00005		|aa345					|
	|TESTA		|Password1	|00005		|12345678				|
	|TESTA		|Password1	|00005		|aa345678				|		
	|TESTA		|Password1	|00005		|ne						|
	|TESTA		|Password1	|00005		|!"£!"					|
	|TESTA		|Password1	|00005		|Password12345			|
	|TESTA		|Password1	|00005		|TESTATESTBTESTCTESTD	|
	


  Scenario Outline: Validate error messages on Create New users Email
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "User Management" 
    And I am redirected to "admin" page
    Then I click the button "Search"
    Then I click existing user to amend '<userId>'
    Then I send and verify incorrect details '<NewEmail>' for User Management Email
    Then I click the link "Back"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:	
	|username 	|password	|userId	|NewEmail		|
	|TESTA		|Password1	|00005	|				|	
	|TESTA		|Password1	|00005	|v				|	
	|TESTA		|Password1	|00005	|v@				|
	|TESTA		|Password1	|00005	|v@.			|
	|TESTA		|Password1	|00005	|!"@test.com	|
	|TESTA		|Password1	|00005	|test@test.com"	|
	|TESTA		|Password1	|00005	|t@t.com^&^		|
	