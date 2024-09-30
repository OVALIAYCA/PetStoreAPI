package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefs",
        plugin = {"pretty",
                "html:target/Cucumber-JVM-Reports/cucumber-reports/report.html",
                "junit:target/Cucumber-JVM-Reports/cucumber-reports/cucumber.xml",
                "json:target/cucumber-reports/Cucumber.json",
                "json:target/json-report/cucumber.json",},
        tags = "@UserOperations"
        //tags = "@PutandUpdatePOJO"
)
public class RunCucumberTest {
    @AfterClass
    public static void writeReportPath() {
        String reportPath = System.getProperty("user.dir") + "/target/Cucumber-JVM-Reports/cucumber-reports/report.html";
        System.out.println("Cucumber Report: file://" + reportPath);
        // Open the report in the default browser
        try {
            File reportFile = new File(reportPath);
            if (reportFile.exists()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            } else {
                System.err.println("Report file does not exist: " + reportPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
