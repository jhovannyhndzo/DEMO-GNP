package home;

import org.openqa.selenium.By;

import utils.BaseActions;

public class Home extends BaseActions {

	private By welcomeMessage = By.xpath("//*[contains(@content-desc, \"Buena\")]");
	
	public void waitForWelcomeMessage() {
		waitForElement(welcomeMessage);
	}
	
}
