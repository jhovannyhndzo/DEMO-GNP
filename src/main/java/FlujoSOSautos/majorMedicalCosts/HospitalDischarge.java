package FlujoSOSautos.majorMedicalCosts;

import org.openqa.selenium.By;

import utils.BaseActions;

public class HospitalDischarge extends BaseActions {
	private By message = By.xpath("//android.widget.TextView[@text=\"Confirma que todos los datos ingresados sean correctos, de lo contrario, puedes editarlos.\"]");
	private By insuredTitle = By.xpath("//android.widget.Button[@resource-id=\"mat-expansion-panel-header-0\"]");
	private By insureName = By.xpath("//android.widget.TextView[@text=\"Nombre\"]");
	private By insureNumberPolicy = By.xpath("//android.widget.TextView[@text=\"Número de Póliza\"]");
	private By insuredCode = By.xpath("//android.widget.TextView[@text=\"Código de cliente\"]");
	private By insuredDateOfBirth = By.xpath("//android.widget.TextView[@text=\"Fecha de nacimiento\"]");
	private By insuredGender = By.xpath("//android.widget.TextView[@text=\"Sexo\"]");
	private By contactTitle = By.xpath("//android.widget.Button[@text=\"expand_more Contactos de seguimiento edit\"]");
	private By documentationTitle = By.xpath("//android.widget.Button[@text=\"expand_more Documentación (opcional) edit\"]");
	private By comment = By.xpath("//android.widget.TextView[@text=\"Comentario (opcional)\"]/following-sibling::android.widget.EditText");
	private By sendBtn = By.xpath("//android.widget.Button[@text=\"Enviar\"]");

	private By upload_file_message = By.xpath("//android.widget.TextView[@text=\"Ingresa los siguientes documentos en formato PDF, JPG o JPEG en un tamaño máximo de 10 MB. El total de todos los documentos cargados no debe superar los 30 MB.\"]");
	
	private By hospitalDischargeSuccessfullTitle = By.xpath("//android.widget.TextView[@text=\"Trámite aperturado exitosamente\"]");
	private By hospitalDischargeSuccessfullMessage = By.xpath("//android.widget.TextView[@text=\"Recibimos tu información. En breve tú y tus contactos de seguimiento designados recibirán un correo de confirmación.\"]");
	private By hospitalDischargeSuccessfullFolio = By.xpath("//android.widget.TextView[contains(@text, \"Folio: \")]");
	private By endBtn = By.xpath("//android.widget.Button[@text=\"Finalizar\"]");

	public void getMessage() {
		waitForElement(message);
	}
	
	public void getInsuredTitle() {
		waitForElementShort(insuredTitle);
	}
	
	public void getInsuredName() {
		waitForElementShort(insureName);
	}
	
	public void getInsuredNumberPolicy() {
		waitForElementShort(insureNumberPolicy);
	}
	
	public void getInsuredCode() {
		waitForElementShort(insuredCode);
	}
	
	public void getInsuredDateOfBirth() {
		waitForElementShort(insuredDateOfBirth);
	}
	
	public void getInsuredGender() {
		waitForElementShort(insuredGender);
	}
	
	public void getContactTitle() {
		waitForElementShort(contactTitle);
	}
	
	public void getDocumentationTitle() {
		waitForElementShort(documentationTitle);
	}
	
	public void getComment() {
		waitForElementShort(comment);
	}
	
	public void tapOnSendBtn() {
		tapButton(sendBtn);
	}
	
	public void getSuccessfullTitle() {
		waitForElement(hospitalDischargeSuccessfullTitle);
	}
	
	public void getSuccessfullMessage() {
		waitForElementShort(hospitalDischargeSuccessfullMessage);
	}
	
	public void getSuccessfullFolio() {
		waitForElementShort(hospitalDischargeSuccessfullFolio);
	}
	
	public void tapOnEndBtn() {
		tapButton(endBtn);
	}
	
	public void getUploadFileMessage() {
		waitForElementShort(upload_file_message);
	}
	
}
