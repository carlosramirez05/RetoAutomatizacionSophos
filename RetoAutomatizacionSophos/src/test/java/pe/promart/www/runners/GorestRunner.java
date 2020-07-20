package pe.promart.www.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/pe/promart/www/features/gorest_api.feature",
        glue = {"pe.promart.www.stepdefinitions.gorest"},
        snippets = SnippetType.CAMELCASE
)

public class GorestRunner { }
