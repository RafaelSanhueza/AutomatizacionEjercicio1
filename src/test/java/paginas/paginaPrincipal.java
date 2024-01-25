package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaPrincipal {

	@FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
	WebElement txtUserID;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	
	public paginaPrincipal (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void realizarLogin() {
		txtUserID.sendKeys("mngr549669");
		txtPassword.sendKeys("ebYrYma");
		btnLogin.click();
	}
	
	public void invalidUser() throws InterruptedException {
		txtUserID.sendKeys("usuario1");
		Thread.sleep(2000);
		txtUserID.sendKeys("ebYrYma");
		btnLogin.click();
	}
	
	public void invalidPass() throws InterruptedException {
		txtUserID.sendKeys("mngr549669");
		Thread.sleep(2000);
		txtUserID.sendKeys("password1");
		btnLogin.click();
	}
	
	public void invalidBoth() throws InterruptedException {
		txtUserID.sendKeys("usuario1");
		Thread.sleep(2000);
		txtUserID.sendKeys("password1");
		btnLogin.click();
	}
}
