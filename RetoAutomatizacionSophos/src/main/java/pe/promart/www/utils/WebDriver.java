package pe.promart.www.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import net.thucydides.core.webdriver.SerenityWebdriverManager;

public class WebDriver {
	
	public static ChromeDriver driver;
	
	public static ChromeDriver chrome(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/pe/promart/www/files/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.promart.pe/");
        SerenityWebdriverManager.inThisTestThread().setCurrentDriverTo(driver);
        return driver;
    }

}
