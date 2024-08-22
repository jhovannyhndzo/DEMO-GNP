package home;

import org.openqa.selenium.By;

import utils.BaseActions;

public class Home extends BaseActions {

	private By welcomeMessage = By.xpath("//*[contains(@content-desc, \"Buena\")]");
	private By Btnmistramites= By.xpath("//*[@content-desc=\"Mis Trámites\"]");
	private By myProfileBtn= By.xpath("//android.view.View[@content-desc=\"Mi Perfil\"]");
	
	public void waitForWelcomeMessage() {
		waitForElement(welcomeMessage);
	}
	public void tapbtnmistramites() {
		tapButton(Btnmistramites);
	}
	
	public void waitForMyProfileBtn() {
		waitForElement(myProfileBtn);
	}
}
