package intro_and_login;

import org.openqa.selenium.By;

import utils.BaseActions;

public class Login extends BaseActions {

	private By emailInput = By.xpath("//*[@text = \"Correo electrónico\"]");
	private By passwordInput = By.xpath("//*[@text = \"Contraseña\"]");
	private By welcomeLabel = By.xpath("//*[@content-desc = \"¡Bienvenido(a)!\"]");
	private By loginButton = By.xpath("//*[@content-desc = \"Iniciar sesión\"]");
	private By openSessionLabel = By.xpath("//*[contains(@content-desc, \"Tienes una sesión\")]");
	private By confirmCloseSessionButton = By.xpath("//*[@content-desc = \"Sí\"]");
	
	public void enterEmail(String email) {
		tapButton(emailInput);
		setText(emailInput, email);
		//hideKeyboard();
	}
	
	public void waitForWelcomeMessages() {
		waitForElement(welcomeLabel);
	}
	
	public void tapPassword() {
		tapButton(passwordInput);
	}
	
	public void enterPassword(String password) {
		tapButton(passwordInput);
		setText(passwordInput, password);
	}
	
	public void tapLogin() {
		tapButton(loginButton);
	}
	
	public void closeOtherSession() {
		if(waitForElementShort(openSessionLabel))
			tapButton(confirmCloseSessionButton);
	}
	
}
