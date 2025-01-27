package StepDefinition7;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="src/test/java/Resources/",
		glue= {"StepDefinition7"},
		tags="@sanity",
		dryRun=false,
		monochrome=false,
		
		plugin= {"pretty","html:target/HtmlReport/index.html",
				
				"json:target/CucumberReports/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				
		}
		
		
		
		
		
		)







public class TestRunner {

}
