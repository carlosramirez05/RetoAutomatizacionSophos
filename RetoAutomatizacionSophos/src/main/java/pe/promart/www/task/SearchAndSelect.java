package pe.promart.www.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import pe.promart.www.userinterface.HomePageComponents;
import pe.promart.www.utils.WaitUntilClickable;

import static pe.promart.www.userinterface.HomePageComponents.*;;


public class SearchAndSelect implements Task{
	
	private String article;
	private HomePageComponents homePageComponents;
	

	public SearchAndSelect(String article) {
		this.article = article;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(article).into(SEARCH_BAR));
		actor.attemptsTo(Click.on(homePageComponents.getProducts().get(0)),
				Scroll.to(ADD_BUTTON).andAlignToBottom(),
				 Click.on(ADD_BUTTON),
				 Click.on(GO_TO_MY_CART_BUTTON),
				 WaitUntilClickable.element(GO_TO_BUY, 10));
			
	}
	
	public static SearchAndSelect article(String article) {
		return Tasks.instrumented(SearchAndSelect.class, article);
	}

	

}
