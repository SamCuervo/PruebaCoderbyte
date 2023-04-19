package Test;

import org.testng.annotations.Test;

import Page.funcionesLoginUsuario;

import org.testng.annotations.BeforeClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class DesloguearseTest {
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
	  funcionesLoginUsuario.desloguearse();

	  WebElement miCuenta = driver.findElement(By.xpath("//span[@class='vtex-menu-2-x-styledLink vtex-menu-2-x-styledLink--header-link no-underline pointer t-body c-on-base pointer']"));
	  String texto = miCuenta.getText();
	  Assert.assertEquals("Mi cuenta", texto);
  }

}
