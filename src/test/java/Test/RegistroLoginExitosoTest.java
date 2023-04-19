package Test;

import org.testng.annotations.Test;

import Page.funcionesLoginUsuario;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class RegistroLoginExitosoTest {
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
	  funcionesLoginUsuario.loginUsuario();
	// Obtener el elemento span que contiene el saludo
	  WebElement saludo = driver.findElement(By.xpath("//span[@class='exito-login-4-x-greetingsText ml2']"));

	  // Validar que el texto del elemento sea "Hola PRUEBA"
	  String textoEsperado = "Hola PRUEBA";
	  String textoReal = saludo.getText();
	  assertEquals(textoEsperado, textoReal);
  }

}
