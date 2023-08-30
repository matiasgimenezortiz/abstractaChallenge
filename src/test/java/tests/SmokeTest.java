package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.HomePage;
import testrunner.BaseTest;

public class SmokeTest extends BaseTest {

    @Test
    public void initialSmokeTest(){
        Reporter.log("Starting initial smoke test", true);

        HomePage homePage = new HomePage(driver);
        validate.assertTrue(homePage.isLoaded());
     }
}
