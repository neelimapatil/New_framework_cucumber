package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;
import junit.framework.Assert;
import utils.Config;
import utils.HTMLReportGenerator;
import utils.Screenshot;

public class LoginPage {
		 
		 WebDriver driver;
	
	public LoginPage(WebDriver driver){
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
		
		 }
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']") 
	private WebElement txtbx_UserName;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']") 
	private WebElement txtbx_Password;
	@FindBy(how = How.XPATH, using = "//*[.='Login']") 
	private WebElement btn_Login;
	@FindBy(how = How.XPATH, using = "//div[@id='error']") 
	private WebElement lbl_LoginError;

	public void doUserLoginByRole(String strUserName, String strPassword,String strRole)
	{
		try
		{
		Thread.sleep(2000);
		txtbx_UserName.sendKeys(strUserName);
		Thread.sleep(2000);
		txtbx_Password.sendKeys(strPassword);
		Thread.sleep(4000);
		btn_Login.click();
		Config.strOp= "Status:=PASS,Method:=doUserLoginByRole,Parmeters:=strUserName"+strUserName+",strPassword"+strPassword+",strRole"+strRole+",Note:Able to login to the application";
		Config.logger.info(Config.strOp);
		Screenshot.CaptureScreenshot(Config.strScreenShotFolderPath, "doUserLoginByRole",this.driver);
		HTMLReportGenerator.StepDetails("PASS", "doUserLoginByRole", "Successfully Able to login to the application", Config.strScreenShotFileName);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			Config.strOp= "Status:=FAIL,Method:=doUserLoginByRole,Parmeters:=strUserName"+strUserName+",strPassword"+strPassword+",strRole"+strRole+",Note:Unable to login to the application";
			Config.logger.info(Config.strOp);
			Screenshot.CaptureScreenshot(Config.strScreenShotFolderPath, "doUserLoginByRole",this.driver);
			HTMLReportGenerator.StepDetails("FAIL", "doUserLoginByRole", "Unable to login to the application", Config.strScreenShotFileName);
		}
	}
		
		public void verifyLoginErrorMessage(String strErrorMessage) {
			// TODO Auto-generated method stub
			Assert.assertEquals(strErrorMessage, lbl_LoginError.getText());
		}
		public void navigateToLoginPage(String strUrl)
		{
			driver.get(strUrl);
			Config.strOp= "Status:=PASS,Method:=navigateToLoginPage,Parmeters:=strUrl"+strUrl+",Note:User is on login page";
			Config.logger.info(Config.strOp);
			Screenshot.CaptureScreenshot(Config.strScreenShotFolderPath, "navigateToLoginPage",this.driver);
			HTMLReportGenerator.StepDetails("PASS", "navigateToLoginPage", "User is on login page", Config.strScreenShotFileName);
		}

}
