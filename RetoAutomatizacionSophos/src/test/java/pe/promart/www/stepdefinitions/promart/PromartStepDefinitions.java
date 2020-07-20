package pe.promart.www.stepdefinitions.promart;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.actors.OnlineCast;
import pe.promart.www.exceptions.ArticleNotFoundException;
import pe.promart.www.questions.CheckProduct;
import pe.promart.www.task.SearchAndSelect;

import static pe.promart.www.utils.WebDriver.chrome;


public class PromartStepDefinitions {
	
	@Before
	public void init() {
		setTheStage(OnlineCast.ofStandardActors());
	}
	
	@Given("^that user needs to enter the promart page$")
	public void thatUserNeedsToEnterThePromartPage() {
		theActorCalled("user");
		theActorInTheSpotlight().can(BrowseTheWeb.with(chrome()));
	    
	}

	@When("^the user search a product (.*)$")
	public void theUserSearchAProduct(String article) {
	   theActorInTheSpotlight().attemptsTo(SearchAndSelect.article(article));;
	}

	@Then("^he should see the article in the shopping cart$")
	public void heShouldSeeTheArticleInTheShoppingCart() {
	    theActorInTheSpotlight().should(seeThat(CheckProduct.inShoppingCart(), equalTo("Finalizar compra")).orComplainWith(ArticleNotFoundException.class, ArticleNotFoundException.ARTICLE_NOT_FOUND));
	}

}
