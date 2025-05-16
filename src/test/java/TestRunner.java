import com.epam.reportportal.cucumber.ScenarioReporter;
import com.epam.ta.reportportal.ws.model.FinishExecutionRQ;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



@Log4j2
@CucumberOptions(
        features = {"C:\\Users\\Yan_Trunov\\IdeaProjects\\saucedemo\\src\\test\\resources\\features\\ui", "C:\\Users\\Yan_Trunov\\IdeaProjects\\saucedemo\\src\\test\\resources\\features\\api"},
        glue = {"stepDefinitions"},
        plugin = {"pretty", "json:target/cucumber-reports/cucumber_ui.json",
                "com.epam.reportportal.cucumber.ScenarioReporter",
                "junit:target/cucumber-reports/junit-report.xml",
                "rerun:target/rerun.txt"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    public static String launchUuid;

    @BeforeSuite
    public void beforeSuite() {

            launchUuid = System.getProperty("rp.launch.uuid");
            log.info("Launch UUID: {}", launchUuid);

    }

    @AfterSuite
    public void closeReportPortalRun() {

            ScenarioReporter.getCurrent().getLaunch().finish(new FinishExecutionRQ());
            log.info("Test run finished. Launch UUID: {}", launchUuid);

    }
}