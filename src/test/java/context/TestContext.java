package context;

import java.io.IOException;


import extentReport.ExtentReport;
import objectManager.DriverManager;
import objectManager.PageObjectManager;
import utils.Action;



public class TestContext 
{
	private PageObjectManager pageObjectManager;
	private Action action;
	private ExtentReport extentReport;

	
	
	public TestContext() throws IOException
	{
		pageObjectManager = new PageObjectManager(DriverManager.getDriver());		
		action = new Action();
		extentReport = new ExtentReport();

	}
	
	//retrun object of pageObjectmanager class
	public PageObjectManager getPageObjectManager()
	{
		return pageObjectManager;
	}
	
	//retun object of Action class
	public Action getActionObject()
	{
		return action;
	}
	
	//return object of extentreport
	public ExtentReport getExtentReport()
	{
		return extentReport;
	}
	

}
