package br.com.anderson.rhsolution;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RhsolutionApplicationTests {

	@Test
	public void hello() {
		 String driverPath = Paths.get("drivers", "chromedriver").toAbsolutePath().toString();
		
		System.setProperty("Webdriver.chrome.driver", driverPath);
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:80");
		browser.quit();		
	}

}
