package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JalaPageObjects
{	
	public JalaPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='UserName']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@id='Password']")
	public WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	public WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/header/nav/div/ul/li/a/span")
	public WebElement logOut;
	
	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[2]/a")
	public WebElement employee;
	
	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[2]/ul/li[1]/a")
	public WebElement create;
	
	@FindBy(xpath="//*[@id=\"FirstName\"]")
	public WebElement firstName;

	@FindBy(xpath="//*[@id=\"LastName\"]")
	public WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"EmailId\"]")
	public WebElement emailId;
	
	@FindBy(xpath="//*[@id=\"MobileNo\"]")
	public WebElement mobileNo;
	
	@FindBy(xpath="//*[@id=\"DOB\"]")
	public WebElement datePicker;

	@FindBy(xpath="/html/body/div[4]/div[1]/table/thead/tr[2]/th[2]")
	public WebElement datePicker1;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/table/thead/tr[2]/th[2]")
	public WebElement datePicker2;
	
	@FindBy(xpath="/html/body/div[4]/div[3]/table/thead/tr[2]/th[1]")
	public WebElement dateYearArrow;

	@FindBy(xpath="/html/body/div[4]/div[3]/table/tbody/tr/td/span[2]")
	public WebElement year;



	@FindBy(xpath="/html/body/div[4]/div[2]/table/tbody/tr/td/span[10]")
	public WebElement month;



	@FindBy(xpath="/html/body/div[4]/div[1]/table/tbody/tr[2]/td[7]")
	public WebElement date;


	@FindBy(xpath="//*[@id=\"rdbMale\"]")
	public WebElement gender;

	@FindBy(xpath="//*[@id=\"Address\"]")
	public WebElement address;



	@FindBy(xpath="//*[@id=\"chkSkill_1\"]")
	public WebElement skill;


	@FindBy(xpath="//*[@id=\"chkSkill_3\"]")
	public WebElement skill1;

	@FindBy(xpath="//*[@id=\"frmEmployee\"]/div[2]/button")
	public WebElement saveBtn;


	@FindBy(xpath="//*[@id=\"frmEmployee\"]/div[2]/button")
	public WebElement updateBtn;

	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[2]/ul/li[2]/a")
	public WebElement searchBtn;






	@FindBy(xpath="//*[@id=\"Name\"]")
	public WebElement searchBtnname;
	@FindBy(xpath="//*[@id=\"btnSearch\"]")
	public WebElement searchBtn1;
	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[1]/a")
	public WebElement Homebtn;

	@FindBy(xpath = "/html/body/div[3]/div/section[2]/div/div/div/a")
	  public  WebElement AddEmployee;

	@FindBy(xpath="//*[@id=\"tblEmployee\"]/tbody/tr[1]/td[9]/a[2]")
	public WebElement deleteBtn;


	@FindBy(xpath="/html/body/div[4]/div/div[10]/button[1]")
	public WebElement YesdeleteBtn;



	@FindBy(xpath="//*[@id=\"tblEmployee\"]/tbody/tr[1]/td[9]/a[1]")
	public WebElement editBtn;

	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[3]/a")
	public WebElement moreBtn;


	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[3]/ul/li[1]/a")
	public WebElement multipleTabBtn;

	@FindBy(xpath="//*[@id=\"frmTabs\"]/div/div/div/div/ul/li[1]/a")
	public WebElement TabBtn1;
	@FindBy(xpath="//*[@id=\"frmTabs\"]/div/div/div/div/ul/li[2]/a")
	public WebElement TabBtn2;
	@FindBy(xpath="//*[@id=\"frmTabs\"]/div/div/div/div/ul/li[3]/a")
	public WebElement TabBtn3;


	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[3]/ul/li[2]/a")
	public WebElement menuBtn;


	@FindBy(xpath="//*[@id=\"b1\"]")
	public WebElement menuBtn1 ;
	@FindBy(xpath="//*[@id=\"b2\"]")
	public WebElement menuBtn2 ;
	@FindBy(xpath="//*[@id=\"b3\"]")
	public WebElement menuBtn3 ;
	@FindBy(xpath="//*[@id=\"b4\"]")
	public WebElement menuBtn4 ;




	@FindBy(xpath="//*[@id=\"frmMenu\"]/div/div/div/div/ul/li[2]/a")
	public WebElement SubmenuBtn ;

	@FindBy(xpath="//*[@id=\"tab_2\"]/ul/li[1]/a")
	public WebElement Submenu1Btn ;
	@FindBy(xpath="//*[@id=\"selbtn\"]")
	public WebElement Submenu2Btn ;

	@FindBy(xpath="//*[@id=\"tab_2\"]/ul/li[4]/a")
	public WebElement Submenu3Btn ;
	@FindBy(xpath="//*[@id=\"mysqlbtn\"]")
	public WebElement Submenu4Btn ;



	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[3]/ul/li[3]/a")
	public WebElement AutoCompleteBtn ;







	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[3]/ul/li[4]/a")
	public WebElement CollaspableContentBtn ;


	@FindBy(xpath="//*[@id=\"headingOne\"]/h4/a")
	public WebElement CollaspableContentBtn1 ;
	@FindBy(xpath="//*[@id=\"headingTwo\"]/h4/a")
	public WebElement CollaspableContentBtn2 ;
	@FindBy(xpath="//*[@id=\"headingThree\"]/h4/a")
	public WebElement CollaspableContentBtn3 ;








	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[3]/ul/li[5]/a")
	public WebElement image ;


	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[3]/ul/li[6]/a")
	public WebElement slide ;



	@FindBy(css="body.skin-blue.sidebar-mini:nth-child(2) div.wrapper:nth-child(3) div.content-wrapper section.content:nth-child(3) form.frmSlider div.box-body div.col-xs-12 div.row.margin div.nav-tabs-custom div.tab-content div.tab-pane.active div.form-group.col-md-12 div.slider.slider-horizontal:nth-child(1) div.slider-track:nth-child(1) > div.slider-handle.min-slider-handle.round:nth-child(4)")
	public WebElement slide1 ;



	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[3]/ul/li[7]/a")
	public WebElement toolTip ;


	@FindBy(xpath="//*[@id=\"btnTooltip\"]")
	public WebElement toolTip1 ;

	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[3]/ul/li[8]/a")
	public WebElement Popups ;



	@FindBy(xpath="//*[@id=\"btn-one\"]")
	public WebElement Popups1 ;




	@FindBy(xpath="//*[@id=\"alertBox\"]")
	public WebElement alert ;



	@FindBy(xpath="//*[@id=\"promptBtn\"]")
	public WebElement promtBox ;



	@FindBy(xpath="//*[@id=\"MenusDashboard\"]/li[3]/ul/li[9]/a")
	public WebElement link ;



	@FindBy(xpath="//*[@id=\"tab_1\"]/div/a[3]")
	public WebElement link1 ;
}



