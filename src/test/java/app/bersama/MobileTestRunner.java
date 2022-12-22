package app.bersama;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;

/**
 * @author regiewby on 16/12/22
 * @project java-cucumber-mobile
 */

@CucumberOptions(features = "src/test/java/app/bersama/features",
        glue = "app.bersama.steps",
        plugin = {
                "pretty",
                "html:reports/cucumber-result/cucumber-reports.html",
                "json:reports/cucumber-result/cucumber-reports.json"
        }, monochrome = true)

public class MobileTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod(alwaysRun = true)
    public void setupDriver() throws MalformedURLException {
        DriverManager.getInstance().setDriver(
                new MobileFactory().launchMobile("ANDROID"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        DriverManager.getInstance().removeDriver();
    }
}
