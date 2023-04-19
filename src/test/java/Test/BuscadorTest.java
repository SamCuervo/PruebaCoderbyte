package Test;

import org.testng.annotations.Test;

import Page.funcionesLoginUsuario;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class BuscadorTest {
	private WebDriver driver;
	funcionesLoginUsuario funcionesLoginUsuario;
	
	
	@BeforeClass
	  public void beforeClass() {
		
		funcionesLoginUsuario =  new funcionesLoginUsuario(driver);
		driver = funcionesLoginUsuario.chromeDriverConnection();
		funcionesLoginUsuario.visit(funcionesLoginUsuario.URL());
			
	  }
	  
	
	@AfterClass
	  public void afterClass() {
		  driver.quit();
		  
	  }
	
  @Test
  public void test() throws InterruptedException {
	  funcionesLoginUsuario.filtro();
	  WebElement link = driver.findElement(By.xpath("//span[@class = 'vtex-breadcrumb-1-x-arrow vtex-breadcrumb-1-x-arrow--1 ph2 c-muted-2']"));
	  String linkText = link.getText();
	  Assert.assertTrue(linkText.contains("televisor"));
	  Thread.sleep(3000);
	  
  }

}
