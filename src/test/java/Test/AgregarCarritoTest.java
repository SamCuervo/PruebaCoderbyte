package Test;

import org.testng.annotations.Test;

import Page.funcionesLoginUsuario;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class AgregarCarritoTest {
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
	  funcionesLoginUsuario.seleccionarCarritos();
	  Thread.sleep(3000);
	  List<WebElement> etiquetasA = driver.findElements(By.xpath("//a[@class='exito-checkout-product-name']"));

	  Assert.assertEquals(etiquetasA.get(0).getText(), "Muñeca Explora y descubre BARBIE");
	  Assert.assertEquals(etiquetasA.get(1).getText(), "Juguete Muñeco Cactus Bailarin Imita La Voz");

  }

}
