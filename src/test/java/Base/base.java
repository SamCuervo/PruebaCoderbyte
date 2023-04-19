package Base;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	private WebDriver driver = null;
	
	//constructor encargado de generar todas las instancias controladas por web driver para crear las funciones
		public base(WebDriver driver) {
			this.driver = driver;
		}
		public WebDriver chromeDriverConnection() {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--enable-automation");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-infobars");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.addArguments("--disable-browser-side-navigation");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--ignore-certificate-errors");
			//chromeOptions.addArguments("--disable-web-security");
			chromeOptions.addArguments("--allow-running-insecure-content");
			chromeOptions.addArguments("--test-type");
			chromeOptions.addArguments("--allow-file-access-from-files");
			chromeOptions.addArguments("--allow-insecure-localhost");
			chromeOptions.addArguments("--allow-running-insecure-content");
			chromeOptions.addArguments("--remote-allow-origins=*");
			//chromeOptions.addArguments("--headless", "--window-size=1920,1200");
			driver = new ChromeDriver(chromeOptions);
			return driver;
		}
		public WebElement findElement(By locator) {
			return driver.findElement(locator);
		}
		
		public List<WebElement> findElements(By locator){
			return driver.findElements(locator);
		}
		
		public String getText(WebElement element) {
			return element.getText();
		}
		
		public String getText(By locator) {
			return driver.findElement(locator).getText();
		}
		
		public void type(String inputText, By locator) {
			driver.findElement(locator).sendKeys(inputText);
		}
		
		public void click(By locator) {
			driver.findElement(locator).click();
		}
		public void clicksElement(By locator, int NumArray, int numClicks) {
			List<WebElement> fileInput = findElements(locator);
			 for (int i = 0; i < numClicks; i++) {
				 fileInput.get(NumArray).click();
			    }
			
		}

		
		public Boolean isDisplayed(By locator) {
			try {
				return driver.findElement(locator).isDisplayed();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				return false;
			}
		}
		
		public void clearInput(By locator) {
	        WebElement inputElement = driver.findElement(locator);
	        inputElement.clear();
	    }
		
		public void Location(By locator) {
			WebElement location = driver.findElement(locator);
			Actions actions = new Actions(driver);
			//actions.moveToElement(location).perform();
			actions.moveToElement(location).build().perform();
		}
		
		//Esperas explicitas
		public void Wait(By locator) {
			new WebDriverWait(driver, Duration.ofSeconds(20))
					.until(ExpectedConditions.elementToBeClickable(locator));
		}
		
		//Esperas implicitas
		public void WaitImplicit(By locator) {
			new WebDriverWait(driver, Duration.ofSeconds(50)).until(driver -> driver.findElement(locator));
		}
		//Esperas implicitas
			public void WaitVisivility(By locator) {
				new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.invisibilityOfElementLocated(locator));
			}
		
		public void FluentWait(By locator) {
			org.openqa.selenium.support.ui.Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(
					driver).withTimeout(Duration.ofSeconds(80)).pollingEvery(Duration.ofSeconds(10))
							.ignoring(NoSuchElementException.class);
			wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
				}
			});
		}
		
		public int CountElement(By locator) {
			return driver.findElements(locator).size();
			
		}
		
		
		public void visit(String url) {
			driver.get(url);
		}
		
		public void Select(By locator, String indicador) {
			WebElement selectElement = driver.findElement(locator);
			Select selectObject = new Select(selectElement);
			selectObject.selectByVisibleText(indicador);
		}
		
		public void SelectDropdown(By locator1, By locator2) {
			WebElement dropdown = driver.findElement(locator2);
			dropdown.findElement(locator2).click();
		}
		
		public void clickElement(By locator, int NumArray) {
			List<WebElement> fileInput = findElements(locator);
			fileInput.get(NumArray).click();
		}
		public String textElement(By locator, int NumArray) {
			List<WebElement> fileInput = findElements(locator);
			return fileInput.get(NumArray).getText();
		}
		
		public void ScrollUp() {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_UP).build().perform();
		}
		
		public void ScrollDown() {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
		}
		
		public void Handle(String NameWindow) {
			WebDriver popup = null;
			Set<String> windowIterator = driver.getWindowHandles();
			Iterator<String> i = windowIterator.iterator();
			while (i.hasNext()) {
				String windowHandle = i.next();
				popup = driver.switchTo().window(windowHandle);
				if (popup.getTitle().equals(NameWindow)) {
					break;
				}
			}
		}
		
		public void Refresh() {
			driver.navigate().refresh();
		}
		
		public void ScrollActionJSDown(int x, int y) {
			JavascriptExecutor jsEngine;
			jsEngine = (JavascriptExecutor) driver;
			
			String jsCommand;
			jsCommand = String.format("window.scrollBy(%d, %d)", x, y);
			
			jsEngine.executeScript(jsCommand);
			
		}
}
