package scripts;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import context.TestContext;
import dataProvider.ConfigFileReader;
//import dataProvider.ReadWriteExcel;
import extentReport.ExtentReport;
import objectManager.DriverManager;
import pageObjects.JalaPageObjects;

import utils.Action;
import utils.Logging;
import utils.Utility;

import static java.lang.Thread.sleep;

public class TestCase 
{
	WebDriver driver;
	JalaPageObjects pageObjects;
	TestContext testContext;
	JalaPageObjects PageObjects;
	Action action;
	ExtentReport extentReport;
	SoftAssert softAssert;
	//ReadWriteExcel excel;
	
	@BeforeSuite
	public void beforeSuite() throws IOException
	{
		driver = DriverManager.getDriver();
		driver.get(ConfigFileReader.getUrl());		
		testContext = new TestContext();
		PageObjects = testContext.getPageObjectManager().getPageObjects();
		action = testContext.getActionObject();
		extentReport = testContext.getExtentReport();
		softAssert = new SoftAssert();
		//excel = new ReadWriteExcel();
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterSuite()
	public void afterSuite() throws IOException
	{		
		softAssert.assertAll();
		extentReport.flush();
		driver.quit();
	}
	
	@BeforeMethod()
	public void beforemethod()
	{}

	@AfterMethod()
	public void afterMethod() throws InterruptedException
	{}
	//-------------------------------------------------------------------
	
  @Test(description="TC001-This test verifies the LogIn Functionality", priority=1,enabled=true)
  public void tc_1() throws Exception {
	  Logging.startTestCase("TC001");
		try {


		  extentReport.createTest("TC001-This test verifies the LogIn Functionality");
		  action.sendKeys(PageObjects.userName, "training@jalaacademy.com", "UserName textbox");
		  extentReport.info("UserName Entered");
		  action.sendKeys(PageObjects.password, "jobprogram", "Password textbox");
		  extentReport.info("Password Entered");

		  action.clickLink(PageObjects.btnLogin, "Login link");
		  extentReport.info("SignIn button clicked");


		  extentReport.info("This test case is Completed");

		  extentReport.addScreenshot(driver);
		  Logging.endTestCase();



	  } catch (Exception e) {
		  System.out.println(e.getMessage());
		  extentReport.fail(e.getMessage());
		  Logging.info(e.getMessage());
		  Logging.endTestCase();
	  }
  }
  
//-------------------------------------------------------------------------
  
  @Test(description="TC002-This test create an employee",priority=2,enabled=true)
  public void tc_2() throws Exception
  {
	  Logging.startTestCase("TC002");
	  try
	  {
		  extentReport.createTest("TC002-This test create an employee");
		  action.clickLink(PageObjects.employee, "Employee link");
		  extentReport.info("Employee dropDown is clicked");
		  action.clickLink(PageObjects.create, "Creating Employee link");
		  extentReport.info("In Employee dropDown Create is clicked");

		  action.sendKeys(PageObjects.firstName, "Ashok", "FirstName textbox");
		  extentReport.info("FirstName Entered");

		  action.sendKeys(PageObjects.lastName, "Kumar", "LastName textbox");
		  extentReport.info("LastName Entered");

		  action.sendKeys(PageObjects.emailId, "ashokKumar28@gmail.com", "EmailId textbox");
		  extentReport.info("emailId Entered");


		  action.sendKeys(PageObjects.mobileNo, "9876543211", "Mobile number textbox");
		  extentReport.info("Mobile number");

		  action.clickLink(PageObjects.datePicker, "DatePicker");
		  action.clickLink(PageObjects.datePicker1, "DatePicker1");
		  action.clickLink(PageObjects.datePicker2, "DatePicker2");
		  action.clickLink(PageObjects.dateYearArrow, "Year Arrow");
		  action.clickLink(PageObjects.dateYearArrow, "Year Arrow");
		  action.clickLink(PageObjects.year, "Year Arrow");
		  action.clickLink(PageObjects.month, "Month Arrow");
		  action.clickLink(PageObjects.date, "Date Arrow");
		  extentReport.info("Date of Birth is selected");


		  action.clickLink(PageObjects.gender, "Gender");
		  extentReport.info("Gender is selected");


		  action.sendKeys(PageObjects.address, "Ramoji Nagar , New Delhi", "Address textbox");
		  extentReport.info("Address is Entered");


		  Select drpCountry = new Select(driver.findElement(By.name("CountryId")));
		  drpCountry.selectByVisibleText("India");
		  extentReport.info("Country is Selected");

		  Select drpCity = new Select(driver.findElement(By.name("CityId")));
		          drpCity.selectByVisibleText("Delhi");
		  extentReport.info("City is Selected");


		  action.clickLink(PageObjects.skill, "Skill Checked");
		  extentReport.info("Skill is Selected");

		  action.clickLink(PageObjects.saveBtn, "Employee Created");
		  extentReport.info("Employee Created");


		  extentReport.info("This test case is Completed");

          action.clickLink(PageObjects.Homebtn, "Dashboard");
          extentReport.info("Dashboard is Selected");

		  sleep(2000);

		  extentReport.addScreenshot(driver);




		  Logging.endTestCase();


	  }
	  catch(Exception e)
	  {
		  System.out.println(e.getMessage());
		  extentReport.fail(e.getMessage());
		  Logging.info(e.getMessage());
		  Logging.endTestCase();
	  }
  }
//----------------------------------------------------------------------
	@Test(description="TC003-This test searches for an employee",priority=3,enabled=true)
	public void tc_3() throws Exception
	{
	  Logging.startTestCase("TC003");
		try
		{
			extentReport.createTest("TC003-This test searches for an employee");
			action.clickLink(PageObjects.employee, "Employee link");
			extentReport.info("Employee dropDown is clicked");

			action.clickLink(PageObjects.searchBtn, "Search Button");
			extentReport.info("Employee search button is clicked");

			action.sendKeys(PageObjects.searchBtnname, "Ashok", "Searched Name");
			extentReport.info("Employee search Name is inputted");

			action.clickLink(PageObjects.searchBtn1, "Search Button");
			extentReport.info("Employee search button is clicked");

			extentReport.info("This test case is Completed");

			//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			sleep(2000);

			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}
//------------------------------------------------------------------------------------------
	@Test(description="TC004-This test deletes an employee after searching it",priority=4,enabled=true)
	public void tc_4() throws Exception
	{
		Logging.startTestCase("TC004");
		try
		{
			extentReport.createTest("TC004-This test deletes an employee after searching it");


			action.clickLink(PageObjects.deleteBtn, "Delete");
			action.clickLink(PageObjects.YesdeleteBtn,"Confirm Delete");
			extentReport.info("Delete button is clicked");
			extentReport.info("Search data  is deleted");

			sleep(2000);

			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}
//-------------------------------------------------------------------------------
	@Test(description="TC005-This test edits an employee after searching it",priority=5,enabled=true)
	public void tc_5() throws Exception
	{
		Logging.startTestCase("TC005");
		try
		{
			extentReport.createTest("TC005-This test edits an employee after searching it");

			action.clickLink(PageObjects.Homebtn, "Dashboard");
			extentReport.info("Dashboard is Selected");

			action.clickLink(PageObjects.employee, "Employee link");
			extentReport.info("Employee dropDown is clicked");




			action.clickLink(PageObjects.searchBtn, "Search Button");
			extentReport.info("Employee search button is clicked");

			action.sendKeys(PageObjects.searchBtnname, "Ashok", "Searched Name");
			extentReport.info("Employee search Name is inputted");

			action.clickLink(PageObjects.searchBtn1, "Search Button");
			extentReport.info("Employee search button is clicked");

			action.clickLink(PageObjects.editBtn, "Edit Button");
			extentReport.info("Employee edit button is clicked");

			action.sendKeys(PageObjects.mobileNo, "7777777777", "update mobile no");
			extentReport.info("update Skill");

			action.clickLink(PageObjects.updateBtn, "edit mobile no");
			extentReport.info("edit mobile no");

			sleep(2000);

			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}

//----------------------------------------------------------------------
	@Test(description="TC006-This test Adds an employee",priority=6,enabled=true)
	public void tc_6() throws Exception
	{
		Logging.startTestCase("TC006");
		try
		{
			extentReport.createTest("TC006-This test adds an employee");

            action.clickLink(PageObjects.Homebtn, "Dashboard");
            extentReport.info("Dashboard is Selected");

            action.clickLink(PageObjects.employee, "Employee link");
            extentReport.info("Employee dropDown is clicked");




            action.clickLink(PageObjects.searchBtn, "Search Button");
            extentReport.info("Employee search button is clicked");


			action.clickLink(PageObjects.AddEmployee, "Add Button");
			extentReport.info("Employee add button is clicked");



			action.sendKeys(PageObjects.firstName, "Chandragupta", "FirstName textbox");
			extentReport.info("FirstName Entered");

			action.sendKeys(PageObjects.lastName, "Maurya", "LastName textbox");
			extentReport.info("LastName Entered");

			action.sendKeys(PageObjects.emailId, "cmaurya28@gmail.com", "EmailId textbox");
			extentReport.info("emailId Entered");


			action.sendKeys(PageObjects.mobileNo, "9898989898", "Mobile number textbox");
			extentReport.info("Mobile number");

			action.clickLink(PageObjects.datePicker, "DatePicker");
			action.clickLink(PageObjects.datePicker1, "DatePicker1");
			action.clickLink(PageObjects.datePicker2, "DatePicker2");
			action.clickLink(PageObjects.dateYearArrow, "Year Arrow");
			action.clickLink(PageObjects.dateYearArrow, "Year Arrow");
			action.clickLink(PageObjects.year, "Year Arrow");
			action.clickLink(PageObjects.month, "Month Arrow");
			action.clickLink(PageObjects.date, "Date Arrow");
			extentReport.info("Date of Birth is selected");


			action.clickLink(PageObjects.gender, "Gender");
			extentReport.info("Gender is selected");


			action.sendKeys(PageObjects.address, "kakinada , Surat", "Address textbox");
			extentReport.info("Address is Entered");


			Select drpCountry = new Select(driver.findElement(By.name("CountryId")));
			drpCountry.selectByVisibleText("India");
			extentReport.info("Country is Selected");

			Select drpCity = new Select(driver.findElement(By.name("CityId")));
			drpCity.selectByVisibleText("Surat");
			extentReport.info("City is Selected");


			action.clickLink(PageObjects.skill1, "Skill Checked");
			extentReport.info("Skill is Selected");

			action.clickLink(PageObjects.saveBtn, "Employee Created");
			extentReport.info("Employee Created");


			extentReport.info("This test case is Completed");

			action.clickLink(PageObjects.Homebtn, "Dashboard");
			extentReport.info("Dashboard is Selected");

			sleep(2000);

			extentReport.addScreenshot(driver);




			Logging.endTestCase();


		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}

//----------------------------------------------------------------------------

	@Test(description="TC007-This test clicks on the More tab",priority=7,enabled=true)
	public void tc_7() throws Exception
	{
		Logging.startTestCase("TC007");
		try
		{
			extentReport.createTest("TC007-This test clicks on the More tab");


			action.clickLink(PageObjects.moreBtn, "More Button");

			extentReport.info("clicks on the More tab");
			Logging.info("clicks on More Tab ");

			sleep(2000);

			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}

//------------------------------------------------------------------------------
	@Test(description="TC008-This test clicks checks for multiple tabs",priority=8,enabled=true)
	public void tc_8() throws Exception
	{
		Logging.startTestCase("TC008");
		try
		{
			extentReport.createTest("TC008-This test clicks checks for multiple tabs");
			action.clickLink(PageObjects.multipleTabBtn, "MultipleTab Button");
			extentReport.info("clicks on the MultipleTab tab");


			action.clickLink(PageObjects.TabBtn1, "Tab Button1");
			extentReport.info("clicks on the Tab Button 1");
			Logging.info("Tab 1 clicked");
			extentReport.addScreenshot(driver);
			sleep(1000);


			action.clickLink(PageObjects.TabBtn2, "Tab Button2");
			extentReport.info("clicks on the Tab Button 2");
			 Logging.info("Tab 2 clicked");
			extentReport.addScreenshot(driver);
			sleep(1000);

			action.clickLink(PageObjects.TabBtn3, "Tab Button3");
			extentReport.info("clicks on the Tab Button 3");
			Logging.info("clicks on Tab 3");
			extentReport.addScreenshot(driver);


			sleep(1000);



			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}

//--------------------------------------------------------------------------------------------

	@Test(description="TC009-This test clicks checks for menu tabs",priority=9,enabled=true)
	public void tc_9() throws Exception
	{
		Logging.startTestCase("TC009");
		try
		{
			extentReport.createTest("TC009-This test clicks checks for menu tabs");
			action.clickLink(PageObjects.menuBtn, "Menu Button");
			extentReport.info("clicks on the Menu tab");


			action.clickLink(PageObjects.menuBtn1, "Testing Menu Option");
			extentReport.info("clicks on the Testing Menu Option");
			Logging.info("Testing Menu is clicked");


			extentReport.addScreenshot(driver);
			sleep(1000);
//------------------------------------------------------------------------>


			action.clickLink(PageObjects.menuBtn2, "Testing Java Menu Option");
			extentReport.info("clicks on the Java Menu Option");
			Logging.info("Java Menu Option is clicked");


			extentReport.addScreenshot(driver);
			sleep(1000);
//------------------------------------------------------------------------>


			action.clickLink(PageObjects.menuBtn3, "Testing .Net menu Option");
			extentReport.info("clicks on the .Net menu Option");
			Logging.info(".Net menu Menu Option is clicked");


			extentReport.addScreenshot(driver);
			sleep(1000);

//------------------------------------------------------------------------>


			action.clickLink(PageObjects.menuBtn4, "Testing DataBase menu Option");
			extentReport.info("clicks on the DataBase menu Option");
			Logging.info("DataBase menu Menu Option is clicked");


			extentReport.addScreenshot(driver);
			sleep(1000);

//------------------------------------------------------------------------>


			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}
// -----------------------------------------------------------------

	@Test(description="TC010-This test clicks checks for sub menu tabs",priority=10,enabled=true)
	public void tc_10() throws Exception
	{
		Logging.startTestCase("TC010");
		try
		{
			extentReport.createTest("TC010-This test clicks  checks for sub-menu tabs");
			action.clickLink(PageObjects.menuBtn, "Sub-Menu Button");
			extentReport.info("clicks on the Sub-Menu tab");


			action.clickLink(PageObjects.SubmenuBtn, "Testing Sub-Menu Option");
			extentReport.info("clicks on the Testing Sub-Menu Option");
			Logging.info("Testing Sub-Menu is clicked");


			extentReport.addScreenshot(driver);
			sleep(1000);
//------------------------------------------------------------------------>


			action.clickLink(PageObjects.Submenu1Btn, "Testing Menu Option");
			action.clickLink(PageObjects.Submenu2Btn, "Selenium Menu Option");
			extentReport.info("clicks on the Selenium sub-menu Menu Option");
			Logging.info("Selenium Menu Option is clicked");


			extentReport.addScreenshot(driver);
			sleep(1000);
//------------------------------------------------------------------------>


			action.clickLink(PageObjects.Submenu3Btn, "Testing DataBase menu Option");
			action.clickLink(PageObjects.Submenu4Btn, "Testing MySql menu Option");
			extentReport.info("clicks on the MySql menu Option");
			Logging.info("MySql menu Menu Option is clicked");


			extentReport.addScreenshot(driver);
			sleep(1000);


			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}

	//--------------------------------------------------------------------

	@Test(description="TC011-This test clicks checks for Autocomplete tabs",priority=11,enabled=true)
	public void tc_11() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);;
		Logging.startTestCase("TC011");
		try {
			extentReport.createTest("TC011-This test clicks checks for Autocomplete tabs");
			action.clickLink(PageObjects.AutoCompleteBtn, "AutoComplete Button");
			extentReport.info("clicks on the AutoComplete tab");


			driver.findElement(By.xpath("//*[@id=\"txtSingleAutoComplete\"]")).sendKeys("Ja");
			sleep(5000);
			List<WebElement> searchListAutoComplete = driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]"));
			for (WebElement ele : searchListAutoComplete) {
				String searchTexts = ele.getText();
				System.out.println(searchTexts);
				if (searchTexts.contains("JavaScript")) {
					ele.click();
				}
			}
			extentReport.info("clicks on AutoComplete and selects javascript");
			Logging.info("clicks on AutoComplete and selects javascript");
					extentReport.addScreenshot(driver);
					sleep(1000);


					Logging.endTestCase();

				}
		catch(Exception e)
				{
					System.out.println(e.getMessage());
					extentReport.fail(e.getMessage());
					Logging.info(e.getMessage());
					Logging.endTestCase();
				}
			}



	@Test(description="TC012-This test clicks checks for Autocollaspe tabs",priority=12,enabled=true)
	public void tc_12() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);;
		Logging.startTestCase("TC012");
		try {
			extentReport.createTest("TC012-This test clicks checks for Collaspable Content");
			action.clickLink(PageObjects.CollaspableContentBtn, " Collaspable Content Button");
			extentReport.info("clicks on the Collaspable Content");

			action.clickLink(PageObjects.CollaspableContentBtn1, " Collaspable Content Button");
			extentReport.info("clicks on the Collaspable Content");

			action.clickLink(PageObjects.CollaspableContentBtn2, " Collaspable Content Button");
			extentReport.info("clicks on the Collaspable Content");

			action.clickLink(PageObjects.CollaspableContentBtn3, " Collaspable Content Button");
			extentReport.info("clicks on the Collaspable Content");

			Logging.info("clicks on single collaspepable content");
			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}

	@Test(description="TC013-This test clicks uploads image",priority=13,enabled=true)
	public void tc_13() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);;
		Logging.startTestCase("TC013");
		try {
			extentReport.createTest("TC013-This test uploads image");
			action.clickLink(PageObjects.image, "Image click");
			extentReport.info("clicks on the image button");

			Robot rb=new Robot();
			WebElement img=driver.findElement((By.cssSelector("#file")));
			    img.click();

			// copying File path to Clipboard
			StringSelection strSel = new StringSelection("C:\\Users\\anirban\\Desktop\\download.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);

			// press Contol+V for pasting
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			// release Contol+V for pasting
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			sleep(2000);

			// for pressing and releasing Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"frmImages\"]/div/div/div[1]/div[3]/button")).click();
			sleep(2000);




			Logging.info("Uploading the image on the Image");
			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}



	@Test(description="TC014-This test clicks checks for Slide",priority=14,enabled=true)
	public void tc_14() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);;
		Logging.startTestCase("TC014");
		try {
			extentReport.createTest("TC014-This test clicks checks for Slide");
			action.clickLink(PageObjects.slide, " Slide Button");
			extentReport.info("clicks on the Slide Content");
			Actions action= new Actions(driver);

			action.dragAndDropBy(PageObjects.slide1, 100, 0).perform();

			sleep(2000);


			extentReport.info("clicks on the Slide Button");


			Logging.info("clicks on single Slide content");
			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}


	@Test(description="TC015-This test clicks checks for ToolTips",priority=15,enabled=true)
	public void tc_15() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);;
		Logging.startTestCase("TC015");
		try {
			extentReport.createTest("TC015-This test clicks checks for ToolTips");
			action.clickLink(PageObjects.toolTip, "ToolTips");
			extentReport.info("clicks on the ToolTips");


			action.clickLink(PageObjects.toolTip1, "ToolTips1");
			extentReport.info("clicked on the ToolTips");




			Logging.info("clicks on ToolTip");
			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}

	@Test(description="TC016-This test clicks checks for Popups",priority=16,enabled=true)
	public void tc_16() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);;
		Logging.startTestCase("TC016");
		try {
			extentReport.createTest("TC016-This test clicks checks for Popups");
			action.clickLink(PageObjects.Popups, "Popups");
			extentReport.info("clicks on the Popups");



			action.clickLink(PageObjects.Popups1, "Popups1");
			extentReport.info("clicks on the Popups1");

			String MainWindow=driver.getWindowHandle();
			Set<String> s1=driver.getWindowHandles();
			Iterator<String> i1=s1.iterator();

			while(i1.hasNext())
			{
				String ChildWindow=i1.next();

				if(!MainWindow.equalsIgnoreCase(ChildWindow))
				{

					// Switching to Child window
					driver.switchTo().window(ChildWindow);
					driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
							.sendKeys("Selenium testing");



					// Closing the Child Window.
					driver.close();
				}
			}

			// Switching to Parent window i.e Main Window.
			driver.switchTo().window(MainWindow);




			Logging.info("clicks on Popups");
			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}

	@Test(description="TC017-This test clicks checks for alertBox",priority=17,enabled=true)
	public void tc_17() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);;
		Logging.startTestCase("TC017");
		try {
			extentReport.createTest("TC017-This test clicks checks for alertBox");
			action.clickLink(PageObjects.alert, "alertBox");
			extentReport.info("clicks on the alertBox");

			Alert alert = driver.switchTo().alert();

			// Capturing alert message.
			String alertMessage= driver.switchTo().alert().getText();

			// Displaying alert message
			System.out.println(alertMessage);
			Logging.info(alertMessage);
			Thread.sleep(1000);

			// Accepting alert
			alert.accept();


			Logging.info("clicks on Popups");
			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}

	@Test(description="TC018-This test clicks checks for PromtBox",priority=18,enabled=true)
	public void tc_18() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);;
		Logging.startTestCase("TC018");
		try {
			extentReport.createTest("TC018-This test clicks checks for PromtBox");
			action.clickLink(PageObjects.promtBox, "PromtBox");
			extentReport.info("clicks on the PromtBox");

			Alert alert = driver.switchTo().alert();

			// Capturing alert message.
			String alertMessage= driver.switchTo().alert().getText();

			// Displaying alert message
			System.out.println(alertMessage);
			Logging.info(alertMessage);
			Thread.sleep(1000);

			// Accepting alert
			alert.accept();


			Logging.info("clicked on Prompted Box");
			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}

	@Test(description="TC019-This test clicks checks for Links",priority=19,enabled=true)
	public void tc_19() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);;
		Logging.startTestCase("TC019");
		try {
			extentReport.createTest("TC019-This test clicks checks for Links");
			action.clickLink(PageObjects.link, "Link");
			action.clickLink(PageObjects.link1, "Link2");
			extentReport.info("clicks on the Link");
			sleep(2000);



			Logging.info("clicked on Link");
			extentReport.addScreenshot(driver);

			Logging.endTestCase();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			extentReport.fail(e.getMessage());
			Logging.info(e.getMessage());
			Logging.endTestCase();
		}
	}






 @Test(description="TC020-This test verify logout functionality",priority=20,enabled=true)
  public void tc_20() throws Exception
  {

	  try
	  {
		  extentReport.createTest("TC020-This test verify logout functionality");
		  action.clickLink(PageObjects.logOut, "Logout link");
		  extentReport.info("Logout button clicked");

		   extentReport.info("This test case is Completed");
		  extentReport.addScreenshot(driver);
		  Logging.endTestCase();

	  }
	  catch(Exception e)
	  {
		  System.out.println(e.getMessage());
		  extentReport.fail(e.getMessage());
		  Logging.info(e.getMessage());
		  Logging.endTestCase();
	  }
  }






}
