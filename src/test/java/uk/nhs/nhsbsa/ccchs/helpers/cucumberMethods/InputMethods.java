package uk.nhs.nhsbsa.ccchs.helpers.cucumberMethods;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import uk.nhs.nhsbsa.ccchs.config.env.BaseTest;

public class InputMethods extends SelectElementByType implements BaseTest
{
	//SelectElementByType eleType= new SelectElementByType();
	private WebElement dropdown =null;
	private Select selectList=null;
	
	/** Method to enter text into text field
	 * @param accessType : String : Locator type (id, name, class, xpath, css)
	 * @param text : String : Text value to enter in field
	   @param accessName : String : Locator value
	 */
	public void enterText(String accessType,String text,String accessName)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		driver.findElement(getelementbytype(accessType, accessName)).sendKeys(text);
	}
	
	/** Method to clear text of text field
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void clearText(String accessType, String accessName)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		driver.findElement(getelementbytype(accessType, accessName)).clear();
	}
	
	/** Method to select element from Dropdown by type
	 * @param select_list : Select : Select variable
	 * @param bytype : String : Name of by type
	 * @param option : String : Option to select
	 */
	public void selectelementfromdropdownbytype (Select select_list, String bytype, String option)
	{
		if(bytype.equals("selectByIndex"))
		{
			int index = Integer.parseInt(option);
			select_list.selectByIndex(index-1);
		}
		else if (bytype.equals("value"))
			select_list.selectByValue(option);
		else if (bytype.equals("text"))
			select_list.selectByVisibleText(option);
	}
	
	/** Method to select option from dropdown list
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param by : String : Name of by type
	@param option : String : Option to select
	@param accessName : String : Locator value
	*/
	public void selectOptionFromDropdown(String accessType, String optionBy, String option, String accessName)
	{
		dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);
		
		if(optionBy.equals("selectByIndex"))
			selectList.selectByIndex(Integer.parseInt(option)-1);
		else if (optionBy.equals("value"))
			selectList.selectByValue(option);
		else if (optionBy.equals("text"))
			selectList.selectByVisibleText(option);
	}
	
	//method to select all option from dropdwon list
//	public void select_all_option_from_multiselect_dropdown(String access_type, String access_name)
//	{
//		dropdown = driver.findElement(getelementbytype(access_type, access_name));
//		selectList = new Select(dropdown);
//		
//		//Select all method not present in JAVA
//	}
	
	/** Method to unselect all option from dropdwon list
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void unselectAllOptionFromMultiselectDropdown(String accessType, String accessName)
	{
		dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);
		selectList.deselectAll();
	}
	
	/** Method to unselect option from dropdwon list
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void deselectOptionFromDropdown(String accessType, String optionBy, String option, String accessName) 
	{
		dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		selectList = new Select(dropdown);
		
		if(optionBy.equals("selectByIndex"))
			selectList.deselectByIndex(Integer.parseInt(option)-1);
		else if (optionBy.equals("value"))
			selectList.deselectByValue(option);
		else if (optionBy.equals("text"))
			selectList.deselectByVisibleText(option);
	}
	
	/** Method to check check-box
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void checkCheckbox(String accessType, String accessName)
	{
		WebElement checkbox= wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if (!checkbox.isSelected())
			checkbox.click();
	}
	
	/** Method to uncheck check-box
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void uncheckCheckbox(String accessType, String accessName)
	{
		WebElement checkbox= wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if (checkbox.isSelected())
			checkbox.click();
	}
	
	/** Method to toggle check-box status
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void toggleCheckbox(String accessType, String accessName)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName))).click();
	}
	
	/** Method to select radio button
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	*/
	public void selectRadioButton(String accessType, String accessName)
	{
		WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		if(!radioButton.isSelected())
			radioButton.click();
	}
	
	/** Method to select option from radio button group
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param by : String : Name of by type
	@param option : String : Option to select
	@param accessName : String : Locator value
	 * @param accessName2 
	*/
	public void selectOptionFromRadioButtonGroup(String accessType, String option, String by, String accessName)
	{
		List<WebElement> radioButtonGroup = driver.findElements(getelementbytype(accessType, accessName));
		for(WebElement rb : radioButtonGroup)
		{
			if(by.equals("value"))
			{
				if(rb.getAttribute("value").equals(option) && !rb.isSelected())
					rb.click();
			}
			else if(by.equals("text"))
			{
				if(rb.getText().equals(option) && !rb.isSelected())
					rb.click();
			}
		}
	}
}
