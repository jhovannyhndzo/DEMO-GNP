package FlujoSOSautos;

import org.openqa.selenium.By;

import utils.BaseActions;

public class mis_tramites extends BaseActions {
	private By  BtnAutos= By.xpath("//*[@content-desc=\"Autos\"]");


	public void  tapbtnAutos() {
		tapButton(BtnAutos);
	}
}

