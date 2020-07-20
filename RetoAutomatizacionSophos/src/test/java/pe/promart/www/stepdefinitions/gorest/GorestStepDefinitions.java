package pe.promart.www.stepdefinitions.gorest;

import pe.promart.www.model.User;
import pe.promart.www.task.GetInformationOnGorestApi;
import pe.promart.www.task.PostInformationOnGorestApi;
import pe.promart.www.utils.ApiRequest;
import pe.promart.www.utils.CommonFunctions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.screenplay.Actor;
import org.junit.runner.RunWith;

import java.util.Map;

import static pe.promart.www.questions.CheckTheCorrectApiConsume.theCorrectApiConsume;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@RunWith(Cucumber.class)
public class GorestStepDefinitions {

    private Actor apiUser = Actor.named("apiUser");
    private User user = new User();
    private CommonFunctions commonFunctions = new CommonFunctions();

    @When("^an user create a register using his data$")
    public void anUserCreateARegisterUsingHisData(Map<String, String> dataTable) {
        user = commonFunctions.convertMapToUserModel(dataTable);
        apiUser.attemptsTo(
                PostInformationOnGorestApi.withData(new ApiRequest().createAnUserWithGorestApi(user)),
                GetInformationOnGorestApi.ofUser());
    }

    @Then("^the user check the correctly create$")
    public void theUserCheckTheCorrectlyCreate() {
        apiUser.should(seeThat(theCorrectApiConsume(user)));
    }

}
