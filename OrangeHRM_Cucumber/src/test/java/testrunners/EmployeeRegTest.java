package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
	features = "FeatureFiles/EmployeeReg.feature",glue = "stepdefinitions",
	dryRun = false,plugin = {"pretty","html:TestReports/EmployeeReg_Report.html"}
)
public class EmployeeRegTest extends AbstractTestNGCucumberTests
{

}
