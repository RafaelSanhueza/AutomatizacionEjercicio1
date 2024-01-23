package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	@FindBy(linkText = "New Customer")
	WebElement btnNewCustomer;
	
	@FindBy(name = "name")
	WebElement txtName;
	
	@FindBy(xpath = "//tbody/tr[5]/td[2]/input[2]")
	WebElement selGender;
	
	@FindBy(css = "#dob")
	WebElement selCalendario;
	
	@FindBy(name = "addr")
	WebElement txtAddress;
	
	@FindBy(name = "city")
	WebElement txtCity;
	
	@FindBy(name = "state")
	WebElement txtState;
	
	@FindBy(name = "pinno")
	WebElement txtPin;
	
	@FindBy(name = "telephoneno")
	WebElement txtMobileNumber;
	
	@FindBy(name = "emailid")
	WebElement txtEmail;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(name = "sub")
	WebElement btnSubmit;
	
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void nuevoCliente() {
		btnNewCustomer.click();
	}
	
	public void llenarFormulario() {
		txtName.sendKeys("Javiera");
		selGender.click();
		selCalendario.sendKeys("25042004");
		txtAddress.sendKeys("Calle falsa 123");
		txtCity.sendKeys("Santiago");
		txtState.sendKeys("Renca");
		txtPin.sendKeys("900000");
		txtMobileNumber.sendKeys("988776611");
		txtEmail.sendKeys("correotest159915@gmail.com");
		txtPassword.sendKeys("pass123ok");
		btnSubmit.click();
	}

}
