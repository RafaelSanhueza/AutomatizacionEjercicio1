package pruebas;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.paginaPrincipal;
import utilidades.CapturarEvidencia;

public class Pruebas {
	String url = "https://www.demo.guru99.com/V4/";
	String directorioEvidencias = "..\\ProyectoX\\Evidencia\\";
	String nombreDocumento = "Evidencias de Prueba.docx";
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(description="CP01 - Login", priority = 2)
	public void login() throws IOException, InterruptedException, InvalidFormatException {
		//Escribir título del documento
		CapturarEvidencia.escribirTitutloDocumento(directorioEvidencias + nombreDocumento, "Documento Evidencia Automatización", 20);
		//Captura 1
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla principal - Iniciar Sesión");
		
		paginaPrincipal principal = new paginaPrincipal(driver);
		principal.realizarLogin();
		//Captura 2
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla principal - Login Exitoso");
	}
	
	@Test(description="CP01 - Login Inválido", priority = 1)
	public void ivalidLogin() throws InvalidFormatException, IOException, InterruptedException {
		paginaPrincipal principal1 = new paginaPrincipal(driver);
		principal1.invalidUser();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		principal1.invalidPass();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		principal1.invalidBoth();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	
	@Test(description="CP02 - Obtener Título", priority = 3)
	public void obtenerTitulo () throws Exception {
		String tituloEsperado = "Guru99 Bank Manager HomePage";
		String tituloObtenido = driver.getTitle();
		
		if(!tituloEsperado.equals(tituloObtenido)) {
			throw new Exception(
			"Prueba fallida - Título no coincide. Esperado: " + tituloEsperado + "Obtenido: " + tituloObtenido);
		} else {
			System.out.println("Prueba existosa - Título si coincide.");
		}
	}
	
	@Test(description="CP03 - Formulario", priority = 4)
	public void llenarFormulario() throws IOException, InvalidFormatException, InterruptedException {
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(30));
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("New Customer")));

		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.nuevoCliente();
		
		//Captura 3
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla principal - Formulario");
		
		inicio.llenarFormulario();
		//Captura 4
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla principal - Formulario exitoso");
	}

}
