package Test;

import org.testng.annotations.Test;

import Page.funcionesLoginUsuario;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class EdicionPerfilTest {
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
	  String letra = funcionesLoginUsuario.editarUsuario();
	// Obtener el elemento span que contiene el saludo
	 List<WebElement> nombre = driver.findElements(By.xpath("//div[@class='light c-on-disabled vtex-my-account-1-x-dataEntryChildren']"));
	 WebElement primerElemento = nombre.get(0);
	 String textoReal = primerElemento.getText();

	 String textoEsperado = "PRUEBA"+letra;
	 assertEquals(textoEsperado, textoReal);
  }


}
