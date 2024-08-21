package FlujoSOSautos;

import org.openqa.selenium.By;

import utils.BaseActions;

public class Autos extends BaseActions{
	private By Messageconsulta = By.xpath("//*[contains(@content-desc,\"Consulta tus\")]");
	private By Btnpoliza= By.xpath("//*[contains(@content-desc, \"FECHA\")]");


	public void waitForMessageconsulta() {
		waitForElement(Messageconsulta);
	}
	public void tapBtnpoliza() {
		tapButton(Btnpoliza);
	}
	
}
