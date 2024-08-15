package intro_and_login;

import org.openqa.selenium.By;

import utils.BaseActions;

public class Intro extends BaseActions {

	IntroAndLoginTexts introAndLoginTexts = new IntroAndLoginTexts();
	private By acceptCompatibilityAlertButton = By.xpath("//*[@text = \"Aceptar\"]");
	private By firstIntroMessage = By.xpath("//*[contains(@content-desc, \"Te damos la bienvenida\")]");
	private By secondIntroMessage = By.xpath("//*[contains(@content-desc, \"Trámites en minutos\")]");
	private By thirdIntroMessage = By.xpath("//*[contains(@content-desc, \"Asistencias\")]");
	private By continueButton = By.xpath("//*[@class = \"android.widget.Button\"]");
	
	
	public void acceptCompatibilityAlert() {
		tapButton(acceptCompatibilityAlertButton);
	}
	
	public void checkFirstIntroMessage() {
		checkTextEquals(firstIntroMessage, introAndLoginTexts.getFirstIntroMessage());
	}
	
	public void checkSecondIntroMessage() {
		checkTextEquals(secondIntroMessage, introAndLoginTexts.getSecondIntroMessage());
	}
	
	public void checkThirdIntroMessage() {
		checkTextEquals(thirdIntroMessage, introAndLoginTexts.getThirdIntroMessage());
	}
	
	public void tapContinue() {
		tapButton(continueButton);
	}
	
}
