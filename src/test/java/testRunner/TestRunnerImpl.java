package testRunner;

import  io.cucumber.junit.platform.engine.Constants;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;



@Suite
//@IncludeEngines("cucumber")
@SelectDirectories("src/test/resources/features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "steps")
@ConfigurationParameter(key=Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/Cucumber.html, json:target/cucumber-reports/Cucumber.json, junit:target/cucumber-reports/Cucumber.xml")
@ConfigurationParameter(key=Constants.FILTER_TAGS_PROPERTY_NAME, value = "@CucumberDemos")
public class TestRunnerImpl {

}
