package runners;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

//import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = {"src/test/resources/Features/Edit_company.feature"},
 glue = {"stepDefinition"},//path of the definition/methods file/class stepDefinitions
 format = {"pretty"},
 plugin = {"junit:target/cucumber-reports/cucumber.xml","html:target/cucumber-reports",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
 monochrome= true, //display the output on console in readable format
 tags={"@SmokeTest"},
 dryRun=false
 )
public class TestRunner {
@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	     Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	     Reporter.setSystemInfo("Selenium", "3.14.0");
	     Reporter.setSystemInfo("Maven", "3.x.y");
	     Reporter.setSystemInfo("Java Version", "1.8.0_40");
	}

}