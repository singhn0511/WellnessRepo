package wellness;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Feature/Wellness_activeP.feature",
glue= {"wellness"},
plugin= {"pretty","html:target/reports", "junit:target/cucumber.xml", "json:target/cucumber.json"},
tags="@wellness_activeProgram")

public class Testrunner {

}
