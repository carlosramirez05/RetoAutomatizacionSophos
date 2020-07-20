package pe.promart.www.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static pe.promart.www.userinterface.HomePageComponents.GO_TO_BUY;

public class CheckProduct implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		
		return Text.of(GO_TO_BUY).viewedBy(actor).asString();
	}
	
	public static CheckProduct inShoppingCart() {
		return new CheckProduct();
	}
}
