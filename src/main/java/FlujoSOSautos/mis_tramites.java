package FlujoSOSautos;

import org.openqa.selenium.By;

import utils.BaseActions;

public class mis_tramites extends BaseActions {
	private By  BtnAutos= By.xpath("//*[@content-desc=\"Autos\"]");
	private By majorMedicalCostsBtn = By.xpath("//android.widget.ImageView[@content-desc=\"Gastos Médicos Mayores\"]");
	

	public void  tapbtnAutos() {
		tapButton(BtnAutos);
	}

	public void  tapOnMajorMedicalCostsBtn() {
		tapButton(majorMedicalCostsBtn);
	}
}

