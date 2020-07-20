package pe.promart.www.utils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class WaitUntilClickable implements Interaction {

	private Target element;
	private int seconds;
	
	public WaitUntilClickable(Target element, int seconds) {
		this.element = element;
		this.seconds = seconds;
	}
	@Override
	public <T extends Actor> void performAs(T actor) {
		WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element.resolveFor(actor)));
	}
	
	public static WaitUntilClickable element(Target element, int seconds) {
		return Tasks.instrumented(WaitUntilClickable.class, element, seconds);
	}

}
