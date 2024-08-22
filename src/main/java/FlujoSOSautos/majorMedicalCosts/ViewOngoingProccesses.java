package FlujoSOSautos.majorMedicalCosts;

import org.openqa.selenium.By;
import utils.BaseActions;

public class ViewOngoingProccesses extends BaseActions {

	private By viewOngoingProccessesTitle = By.xpath("//android.widget.TextView[@text=\"Consulta tus trámites en proceso y finalizados\"]");
	private String policyForDocumentReview = "(//android.widget.TextView[@text=\"Revisión de documentos\"])[%d]/following-sibling::android.widget.TextView[@text=\"chevron_right\"]";
	private By typeTrackingTitle = By.xpath("//android.widget.TextView[@text=\"TIPO DE TRÁMITE\"]");
	private By statusTrackingTitle = By.xpath("//android.widget.TextView[@text=\"ESTATUS DEL TRÁMITE\"]");
	private By responsibleTrackingTitle = By.xpath("//android.widget.TextView[@text=\"RESPONSABLE\"]");
	private By deadlineTrackingTitle = By.xpath("//android.widget.TextView[@text=\"TIEMPO LÍMITE PARA COMPLETAR INFORMACIÓN\"]");
	private By warningMessage = By.xpath("//android.widget.TextView[@text=\"GNP se encuentra realizando el análisis y valoración de la información.\"]");
	private By affectedInsuredTitle = By.xpath("//android.widget.TextView[@text=\"Asegurado afectado\"]");
	private By affectedInsuredName = By.xpath("//android.widget.TextView[@text=\"Asegurado afectado\"]/following-sibling::*[1]");
	private By policyNumberTitle = By.xpath("//android.widget.TextView[@text=\"Número de Póliza\"]");
	private By policyNumber = By.xpath("//android.widget.TextView[@text=\"Número de Póliza\"]/following-sibling::*[1]");
	private By numberTrackingTitle = By.xpath("//android.widget.TextView[@text=\"No. de trámite\"]");
	private By numberTracking = By.xpath("//android.widget.TextView[@text=\"No. de trámite\"]/following-sibling::*[1]");
	private By initialDateOfProcessTitle = By.xpath("//android.widget.TextView[@text=\"Fecha de apertura del trámite\"]");
	private By initialDateOfProcess = By.xpath("//android.widget.TextView[@text=\"Fecha de apertura del trámite\"]");
	
	private By methodOfOpeningTitle = By.xpath("//android.widget.TextView[@text=\"Medio de apertura del trámite\"]");
	private By continueWithTheCaptureBtn = By.xpath("//android.widget.Button[@text=\"Solicitar alta hospitalaria\"]");
	private By footer = By.xpath("//android.view.View[@text=\"Selecciona la página de los resultados\"]");

	public By getLocatorOfPolicyForDocumentReviewByPosition(int position) {
		String locatorString;
		By locator;
		
		locatorString = String.format(policyForDocumentReview, position);
		locator = By.xpath(locatorString);
		return locator;
	}
	
	public void getViewOngoinProccessesTitle() {
		waitForElement(viewOngoingProccessesTitle);
	}
	
	public void tapOnFirstPolicyForDocumentReview(int position) {
		Boolean policyWasFound = false;
		Boolean footerWasFound = false;
		By locator;
	
		locator = getLocatorOfPolicyForDocumentReviewByPosition(position);
		do {
			policyWasFound = waitForElementShort(locator);
			System.out.println(policyWasFound);
			if(!policyWasFound) {
				swipedownparaSegumuentoalsiniestro();
				try {
					footerWasFound = waitForElementShort(footer);
					if(footerWasFound) {
						break;
					}
				}catch (Exception e2) {}
			} else {				
				tapButton(locator);
				forceDelay(3000);
				break;
			}
		} while(true);
		
	}
	
	public void getTypeTrackingTitle() {
		waitForElement(typeTrackingTitle);
	}
	
	public void getStatusTrackingTitle() {
		waitForElement(statusTrackingTitle);
	}

	public void getResponsibleTrackingTitle() {
		waitForElement(responsibleTrackingTitle);
	}
	
	public void getDeadlineTrackingTitle() {
		waitForElement(deadlineTrackingTitle);
	}
	
	public void getWarningMessage() {
		waitForElement(warningMessage);
	}

	public void getAffectedInsuredTitle() {
		String affectedInsured;
		
		waitForElement(affectedInsuredTitle);
		affectedInsured = getText(affectedInsuredName);
		textIsAlphabetical(affectedInsured);
	}

	public void getPolicyNumberTitle() {
		String number;
		
		waitForElement(policyNumberTitle);
		number = getText(policyNumber);
		textIsNumeric(number);
	}
	
	public void getNumberTrackingTitle() {
		String number;
		int expectedLength = 11;
		waitForElement(numberTrackingTitle);
		number = getText(numberTracking);
		if(number.length() != expectedLength) {
			throw new RuntimeException("The text size is different from " + expectedLength + " characters");
		}
	}
	
	public void getIinitialDateOfProcessTitle() {
		String regex = "^\\d{2}/\\d{2}/\\d{2} - \\d{2}:\\d{2} [a|p]\\. m\\.$";
		String dateDisplayed;
		
		waitForElement(initialDateOfProcessTitle);
		dateDisplayed = getText(initialDateOfProcess);
		
		if(!dateDisplayed.matches(regex)) {
			throw new RuntimeException("The date: " + dateDisplayed + "  does not match the expected format: dd/mm/yy - HH:MM (a.m./p.m)");
		}
	}
	
	public void getMethodOfOpeningTitle() {
		waitForElement(methodOfOpeningTitle);
	}
	
	public void tapOnContinueWithTheCaptureBtn() {
		tapButton(continueWithTheCaptureBtn);
	}
}
