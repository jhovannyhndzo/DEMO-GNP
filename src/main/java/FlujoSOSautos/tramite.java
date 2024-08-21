package FlujoSOSautos;

import org.openqa.selenium.By;

import utils.BaseActions;

public class tramite extends BaseActions{
	private By Messagetramite = By.xpath("//*[@content-desc=\"¿Qué tipo de trámite desea hacer?\"]");
	private By Btnseguimiento= By.xpath("//*[contains(@content-desc, \"Seguimiento\")]");


	public void waitForMessagetramite() {
		waitForElement(Messagetramite);
	}
	public void tapBtnSeguimiento() {
		tapButton(Btnseguimiento);
	}
	
}
