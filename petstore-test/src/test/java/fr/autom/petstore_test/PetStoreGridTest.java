package fr.autom.petstore_test;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PetStoreGridTest {
	
	WebDriver driver;
  
	@Test
    public void test () throws MalformedURLException{
		
		 String Browser = System.getProperty("Browser");
		 DesiredCapabilities cap = new DesiredCapabilities();
		 cap.setCapability("browserName", Browser);
		 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		 
		
		String animalRecherche = "Reptiles";		
		driver.get("http://localhost:8084/jpetstore/");
		WebElement linkEnter = driver.findElement(By.linkText("Enter the Store"));
		linkEnter.click();
		WebElement iconeReptiles = driver.findElement(By.xpath("//div[@id='SidebarContent']//a[4]"));
		System.out.println("Le titre " + animalRecherche  + " est présent");
		assertTrue(iconeReptiles.isDisplayed());
		iconeReptiles.click();
		WebElement titrePage = driver.findElement(By.cssSelector("h2"));
		System.out.println(titrePage.getText());
		assertTrue(titrePage.getText().equals(animalRecherche));
		driver.close();
        
    }

   
}
