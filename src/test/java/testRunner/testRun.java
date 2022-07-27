package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utilities.CucumberReporting;

@RunWith(Cucumber.class)

@CucumberOptions
        (
        // features={".//Feature/Desktops.feature",".//Feature/Laptop&Notebooks.feature",.//Feature/RetailPage.feature},
                // features ="@target/rerun.txt",
         features={".//Feature/Desktops.feature",".//Feature/HomePage.feature"},
         glue="stepDefinitions",
                dryRun = false,
               // tags="@scrw"
                plugin = {"pretty",
               "html:target/site/cucumber-pretty",
                "json:cucumber.json",
                "rerun:target/rerun.txt"},
                publish = true

        )

public class testRun {
        @AfterClass
public static void generateReport() {
CucumberReporting.reportConfig();
}

}
