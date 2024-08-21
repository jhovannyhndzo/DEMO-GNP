package FlujoSOSautos;

import org.openqa.selenium.By;

import utils.BaseActions;

public class tramites_autos extends BaseActions {
	
	private By Message = By.xpath("//*[contains(@content-desc, \"Qu\")]");
	private By  BtnNtramite= By.xpath("//*[@content-desc=\"Ingresar nuevo trámite\"]");
	private By Btnvertc = By.xpath("//*[@content-desc=\"Ver trámites en curso\"]");

	public void waitForMessage() {
		waitForElement(Message);
	}
	public void tapBtnNtramite() {
		tapButton(BtnNtramite);
	}
	
	public void tapBtnvertc() {
		tapButton(Btnvertc);
	}
}

