package FlujoSOSautos.majorMedicalCosts;


import org.openqa.selenium.By;

import utils.BaseActions;

public class MajorMedicalCostsMainScreen extends BaseActions {

	private By majorMedicalCostsTitle = By.xpath("//android.widget.TextView[@text=\"Gastos Médicos Mayores\"]/following-sibling::android.widget.TextView[@text=\"¿Qué deseas hacer?\"]");
	private By viewOngoingProccessesBtn = By.xpath("//*[@text=\"Ver trámites en curso\"]");
	
	public void getMajorMedicalCostsTitle() {
		waitForElement(majorMedicalCostsTitle);
	}
	
	public void tapOnViewOngoingProccessesBtn() {
		forceDelay(6000);
		tapButton(viewOngoingProccessesBtn);
	}
}
