package FlujoSOSautos.majorMedicalCosts;

import org.openqa.selenium.By;

import utils.BaseActions;

public class ContactTracking extends BaseActions {

	private By waitToEditAlert = By.xpath("//android.widget.TextView[contains(@text, \"Favor de esperar\")]");
	private By aceptAlertBtn = By.xpath("//android.widget.Button[@text=\"Aceptar\"]");
	private By returnBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	private By messageNotifications = By.xpath("//android.widget.TextView[@text=\"Recibirás notificaciones en tus datos de contacto previamente guardados. Si lo deseas, también puedes agregar otro contacto de seguimiento.\"]");
	private By myContactsTitle = By.xpath("//android.widget.TextView[@text=\"MIS DATOS DE CONTACTO\"]");
	private By addContactTitle = By.xpath("//android.widget.TextView[@text=\"Agregar otro contacto\"]");
	private By addContactBtn = By.xpath("//android.widget.Button[@text=\"add\"]");
	private By typeContactSelect = By.xpath("//android.widget.TextView[@text=\"Tipo de contacto\"]/following-sibling::android.widget.Spinner");
	private By typeContactPartnerOption = By.xpath("//android.view.View[@text=\"Pareja / Cónyuge\"]");
	private By contactNameInput = By.xpath("//android.widget.TextView[@text=\"Nombre(s)\"]/following-sibling::android.widget.EditText");
	private By contactSurnameInput = By.xpath("//android.widget.TextView[@text=\"Primer Apellido\"]/following-sibling::android.widget.EditText");
	private String contactEmailInput = "(//android.widget.TextView[@text=\"Correo electrónico\"])[%d]/following-sibling::android.widget.EditText";
	private By contactPhoneInput = By.xpath("//android.widget.TextView[@text=\"Teléfono\"]/following-sibling::android.widget.EditText");
	private By continueBtn = By.xpath("//android.widget.Button[@resource-id=\"continuar\"]");
	private By errorNotification = By.xpath("//android.widget.TextView[@text=\"Para continuar con el alta de trámite es necesario que ingreses los datos solicitados.\"]");

	private By errorMessage = By.xpath("//android.view.View[contains(@resource-id, \"mat-error\")]");
	
	public Boolean waitToEditAlertIsDisplayed() {
		return waitForElementShort(waitToEditAlert);
	}
	
	public void tapOnAcceptBtn() {
		tapButton(aceptAlertBtn);
	}
	
	public void returnToTrackingScreen() {
		swipeupnparaSegumuentoalsiniestro();
		swipeupnparaSegumuentoalsiniestro();
		tapButton(returnBtn);
	}
	
	public void getMessageAboutNotifications() {
		waitForElement(messageNotifications);
	}
	
	public void getMyContactsTitle() {
		waitForElement(myContactsTitle);
	}

	public void getAddContactTitle() {
		Boolean titleIsDisplayed = false;
		
		do {
			titleIsDisplayed = waitForElementShort(addContactTitle);
			if (!titleIsDisplayed) {
				swipedownparaSegumuentoalsiniestro();
			} else {
				break;
			}
		}while(true);
	}
	
	public void tapOnAddContactBtn() {
		tapButton(addContactBtn);
	}

	public void selectTypeContact() {
		tapButton(typeContactSelect);
		tapButton(typeContactPartnerOption);
	}
	
	public void writeContactName(String name) {
		setText(contactNameInput, name);
	}
	
	public void writeSurname(String surname) {
		setText(contactSurnameInput, surname);
	}
	
	public void writeEmail(String email) {
		String locatorString;
		By locator;
		
		locatorString = String.format(contactEmailInput, 2);
		locator = By.xpath(locatorString);
		
		if(!waitForElementShort(locator)) {
			swipedownparaSegumuentoalsiniestro();
			locatorString = String.format(contactEmailInput, 1);
			locator = By.xpath(locatorString);
		}
		setText(locator, email);
	}
	
	public void writePhone(String phone) {
		setText(contactPhoneInput, phone);		
	}
	
	public void tapOnContinuebtn() {
		Boolean btnIsDisplayed = false;
		
		do {
			btnIsDisplayed = waitForElementShort(continueBtn);
			if (!btnIsDisplayed) {
				swipedownparaSegumuentoalsiniestro();
			} else {
				break;
			}
		}while(true);
		
		tapButton(continueBtn);
	}
	
	public Boolean errorNotificationIsDisplayed() {
		Boolean notificationIsDisplayed = false;
		
		if(waitForElementShort(errorMessage)) {
			try {
				waitForElement(errorNotification);
				notificationIsDisplayed = true;
			}catch (Exception e) {
				notificationIsDisplayed = false;
			}
		}
		
		return notificationIsDisplayed;
	}
}
