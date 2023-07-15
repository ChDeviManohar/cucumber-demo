package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	private static WebDriver driver;
	private static WebDriverWait wait;
	public final static int TIMEOUT = 10;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Step: browser is open");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		//System.setProperty("webdriver.chrome.driver", "D:/Cucumber/cucumber-demo/src/test/java/driver/chromedriver.exe");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		driver.manage().window().maximize();

	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("Step: user is on google search page");
		driver.navigate().to("https://google.com");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		System.out.println("Step: user enters a text in search box");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
	}

	@And("hit enter")
	public void hit_enter() {
		System.out.println("Step: hit enter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user enter into search result")
	public void user_enter_into_search_result() {
		System.out.println("Step: user enter into search result");
		driver.getPageSource().contains("Online Courses");
	}

}
