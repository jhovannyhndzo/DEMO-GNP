package home;

import org.openqa.selenium.By;

import utils.BaseActions;

public class Home extends BaseActions {

	private By welcomeMessage = By.xpath("//*[contains(@content-desc, \"Buena\")]");
	private By Btnmistramites= By.xpath("//*[@content-desc=\"Mis Trámites\"]");
	
	public void waitForWelcomeMessage() {
		waitForElement(welcomeMessage);
	}
	public void tapbtnmistramites() {
		tapButton(Btnmistramites);
	}
}
