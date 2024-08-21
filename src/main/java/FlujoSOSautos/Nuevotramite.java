package FlujoSOSautos;

import org.openqa.selenium.By;

import utils.BaseActions;

public class Nuevotramite extends BaseActions {

	private By Message = By.xpath("//*[contains(@content-desc, \"Seleccione\")]");
	private By  Nopoliza= By.xpath("//android.view.View[contains(@content-desc,\"No. Póliza: 00001416533428\")]");

	


	public void waitForMessage() {
		waitForElement(Message);
	}
	public void tapBtnNtramite() {
		tapButton(Nopoliza);
	}
	
	
}
