package pe.promart.www.userinterface;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class HomePageComponents extends PageObject{
	

	public static final Target SEARCH_BAR = Target.the("search bar").locatedBy("//*[@id='i-search']");
	public List<WebElementFacade> getProducts(){
		return findAll(By.xpath("//div[@class='resul js-resultSearch']//div//a"));
	}
	public static final Target ADD_BUTTON = Target.the("add button").locatedBy("//*[@class='js-addtocart gh-btn v2 v3']");
	public static final Target GO_TO_MY_CART_BUTTON = Target.the("go to my cart button").locatedBy("//*[@class='lnk2 gh-btn v2 js-add-product-service']");
	public static final Target GO_TO_BUY = Target.the("go to buy").locatedBy("//*[@id='cart-to-orderform']");
}
