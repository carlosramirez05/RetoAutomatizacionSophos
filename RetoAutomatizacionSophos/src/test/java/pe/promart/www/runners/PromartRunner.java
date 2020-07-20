package pe.promart.www.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features = "src/test/resources/pe/promart/www/features/promart.feature",
				  glue = "pe.promart.www.stepdefinitions.promart",
				  snippets = SnippetType.CAMELCASE)
public class PromartRunner {

}
