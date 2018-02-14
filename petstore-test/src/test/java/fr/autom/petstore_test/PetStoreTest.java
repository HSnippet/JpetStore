package fr.autom.petstore_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PetStoreTest {
	
	WebDriver driver;
  
	@Test
    public void test (){
		
		String Browser = System.getProperty("Browser");
		
		
		if (Browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\tools\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (Browser.equals("Chrome")){
			System.setProperty("webdriver.chromedriver", "C:\\tools\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (Browser.equals("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\tools\\selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} 
		
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
