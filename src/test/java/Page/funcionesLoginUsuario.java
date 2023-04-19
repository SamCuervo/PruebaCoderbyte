package Page;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.base;

public class funcionesLoginUsuario extends base {
	public funcionesLoginUsuario(WebDriver driver) {
		super(driver);
	}
	public String URL() {
		String UrlChat = "https://www.exito.com/";
		return (UrlChat);	
	}
	//funcion para Login de usuario
	//localizadores
	By btnCuenta = By.xpath("//div[@class='vtex-menu-2-x-styledLinkContent vtex-menu-2-x-styledLinkContent--header-link flex justify-between nowrap']");
	By btnIngresar = By.xpath("//span[text()='Ingresa con email y contraseña']");
	By txtEmail = By.xpath("//input[@placeholder='Ingresa tu email']");
	By txtContrasena = By.xpath("//input[@type='password']");
	By btnEntrar = By.xpath("//div[@class='vtex-button__label flex items-center justify-center h-100 ph5 ']");
	public void loginUsuario() throws InterruptedException{
		Thread.sleep(3000);
		Wait(btnCuenta);
		click(btnCuenta);
		Thread.sleep(2000);
		Wait(btnIngresar);
		click(btnIngresar);
		Thread.sleep(2000);
		WaitImplicit(txtEmail);
		type("snorlax20000619@gmail.com", txtEmail);
		Thread.sleep(2000);
		WaitImplicit(txtContrasena);
		type("aA20000619", txtContrasena);
		Thread.sleep(2000);
		Wait(btnEntrar);
		clickElement(btnEntrar, 1);;
		Thread.sleep(5000);
	}
	
	//funcion para actualizar el nombre
	//localizadores
	By btnPerfil = By.xpath("//div[@class='exito-login-4-x-greetingsContainer']");
	By btnMenuDesplegable = By.xpath("//div[@class='vtex-menu-2-x-styledLinkContent vtex-menu-2-x-styledLinkContent--login-modal-link flex justify-between nowrap']");
	By btnEditar = By.xpath("//div[@class='vtex-button__label flex items-center justify-center h-100 ph5 ']");
	By txtNombre = By.xpath("//input[@name='firstName']");
	By btnTerminos = By.xpath("//input[@class='exito-profile-form-3-x-acceptTermsInput']");
	By btnGuardar = By.xpath("//div[@class='vtex-button__label flex items-center justify-center h-100 ph5 w-100 border-box ']");
	
	public static String letrarandom() {
	    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	    Random random = new Random();
	    int index = random.nextInt(vowels.length);
	    return String.valueOf(vowels[index]);
	}
	public String editarUsuario() throws InterruptedException{
		Thread.sleep(3000);
		loginUsuario();
		Wait(btnPerfil);
		click(btnPerfil);
		Wait(btnMenuDesplegable);
		clickElement(btnMenuDesplegable, 0);
		Wait(btnEditar);
		click(btnEditar);
		Wait(txtNombre);
		clearInput(txtNombre);
		String letra = letrarandom();
		type(letra, txtNombre);
		Wait(btnTerminos);
		click(btnTerminos);
		Wait(btnGuardar);
		click(btnGuardar);
		Thread.sleep(5000);
		return letra;
	}
	//funcion para seleccionar carritos de juguete
	//Localizadores
		By btnCategoriaJugueteria = By.xpath("//a[@href='/jugueteria/todo']");
		By btnAgregarCarrito = By.xpath("//div[@class='exito-vtex-components-4-x-main']");
		By btnCarritoCompra = By.xpath("//a[@class='exito-header-3-x-minicartLink' ]");
		By btnCantidadProducto = By.xpath("//i[@class='icon icon-plus-sign']");	
		By divCarro = By.xpath("//div[@class='vtex-flex-layout-0-x-flexCol vtex-flex-layout-0-x-flexCol--product-info  ml0 mr0 pl0 pr0      flex flex-column h-100 w-100']");
		By txtSubTituloProducto = By.xpath("//h3[@class='vtex-store-components-3-x-productNameContainer mv0 t-heading-4' ]");
		By txtPrecio = By.xpath("//div[@class='exito-vtex-components-4-x-PricePDP']");
		
		Random random = new Random();
		List<Integer> indicesGenerados = new ArrayList<Integer>(); // lista de índices generados   
		public void seleccionarCarritos() throws InterruptedException {
		    Thread.sleep(1000);
		    Wait(btnCategoriaJugueteria);
		    click(btnCategoriaJugueteria);
		    Thread.sleep(1000);
		    FluentWait(btnAgregarCarrito);
		    
		    int contador = 0;
		    while (contador < 2) { 
		            Thread.sleep(1000);
		            FluentWait(btnAgregarCarrito);
		            clickElement(btnAgregarCarrito, contador);
		            indicesGenerados.add(contador);
		            contador++;
		        
		    }
		    FluentWait(btnCarritoCompra);
		    click(btnCarritoCompra);	    
		    Thread.sleep(3000);
		}
		
		//funcion para usar el buscador
		//lozalizadores
		By txtTelevisor = By.xpath("//input[@placeholder='Buscar en exito.com']");
		By btnVer = By.xpath("//a[@class='vtex-search-2-x-tileListSeeMore']");
		public void filtro() throws InterruptedException{
			Thread.sleep(3000);
			Wait(txtTelevisor);
			click(txtTelevisor);
			type("televisor", txtTelevisor);
			Thread.sleep(3000);
			Wait(btnVer);
			click(btnVer);
			Thread.sleep(6000);
		
		}
		
		//funcion de desloguearse
		//localizadores
		By btnCerrarSesion = By.xpath("//div[@class='exito-login-4-x-logoutContent']");
		public void desloguearse() throws InterruptedException{
			loginUsuario();
			Wait(btnPerfil);
			click(btnPerfil);
			Wait(btnCerrarSesion);
			click(btnCerrarSesion);
			Thread.sleep(6000);
		}
}
