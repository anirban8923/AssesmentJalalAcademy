package objectManager;

import org.openqa.selenium.WebDriver;

import pageObjects.JalaPageObjects;


public class PageObjectManager 
{	
	private WebDriver driver;
	private JalaPageObjects PageObjects;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}

	public JalaPageObjects getPageObjects()
	{

		return (PageObjects==null) ? PageObjects = new JalaPageObjects(driver): PageObjects;
	}
}
