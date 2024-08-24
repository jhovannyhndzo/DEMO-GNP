package app.home.misTramites;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;

import utils.BaseActions;

public class GastosMedicosMayores extends BaseActions {
	private By gastosMedicosMayoresButton = By.xpath("//*[@content-desc = \"Gastos Médicos Mayores\"]");	
	private By queDeseasHacerText = By.xpath("//*[@text = \"¿Qué deseas hacer?\"]");
	private By nuevoTramite = By.xpath("//*[@text = \"Ingresar nuevo trámite\"]");
	private By polizaUnoButton = By.xpath("(//*[@text = \"No. Póliza\"]/parent::android.view.View)[1]");
	private By hospitalizacionButton = By.xpath("//*[contains(@text, \"Ingreso hospitalario\")]");
	private By hospitalizacionSinCarta = By.xpath("//android.widget.RadioButton[contains(@text, \"Ingreso Hospitalario sin carta\")]");
	private By iniciarTramiteButton = By.xpath("//*[@text = \"Iniciar trámite\"]");
	private By nombreDelAseguradoText = By.xpath("//*[@text = \"Nombre del Asegurado\"]");
	private By continuarButton = By.xpath("//*[@text = \"Continuar\"]");
	private By ingresarNombredeHospitalText = By.xpath("//android.widget.EditText");
	private By buscarHospitalButton = By.xpath("//*[@text = \"search\"]");
	private By opcionUnoHospitalButton = By.xpath("//*[@text = \"Hospital\"]");
	private By AlertButtonAceptarYcontinuar = By.xpath("//android.widget.Button[@text=\"Aceptar y continuar\"]");
	private By ButtonAbrirCalendario = By.xpath("//*[@text = \"Open calendar\"]");
	private By diaEnCalendario;
	private By ingresarHora = By.xpath("(//android.widget.EditText)[2]");
	private By ingresarMinutos = By.xpath("(//android.widget.EditText)[3]");
	private By amHoraButton = By.xpath("//android.widget.Button[@text = \"AM\"]");
	private By continuarButtonFH = By.xpath("//*[@text = \"Continuar\"]");
	
	
	//Agregar los xpath de Continuar,continuar, continuar, tagCerrar o sroll, enviar
	
	public void tapGastosMedicosMayores() {
		tapButton (gastosMedicosMayoresButton);
	}
	
	public void waitForTextQueDeseasHacer() {
		waitForElement(queDeseasHacerText);
	}
	
	public void tapnuevoTramite() {
		
        int attempts = 0;
        final int maxAttempts = 5; // Número máximo de intentos

        while (attempts < maxAttempts) {
            try {
                // Espera hasta que el elemento sea visible antes de intentar hacer clic
                if (attempts > 0) {
                	waitForElementShort(nuevoTramite);
                }

                // Realiza el clic en el botón
                tapButton (nuevoTramite);
                attempts++;
            } catch (NoSuchElementException e) {
                // Si el botón no está disponible después de los intentos, salir del bucle
                break;
            }
        }
		
	}
	
	//Agregar espera de TextElement "Selecciona la poliza a la que deseas asociar el trámite"
	
	
	public void tapSeleccionarPoliza() {
		tapButton (polizaUnoButton);
	}
	
	public void tapIngresoHospitalario() {
		tapButton (hospitalizacionButton);
	}
	
	public void tapIngresoSinCarta() {
		tapButton (hospitalizacionSinCarta);
	}
	
	public void tapIniciarTramiteButton() {
		tapButton (iniciarTramiteButton);
	}
	
	public void waitForTextNombreDelAsegurado() {
		waitForElement(nombreDelAseguradoText);
	}
	
	public void tapContinuarButton() {
		tapButton (continuarButton);
	}
	
	public void ingresarNombreDeHospital() {
		tapButton(ingresarNombredeHospitalText);
		setText(ingresarNombredeHospitalText, "Hos");
		hideKeyboard();
	}
	
	public void tapBuscarHospitalButton() {
		tapButton (buscarHospitalButton);
	}
	
	public void tapSeleccionarHospitalUno() {
		tapButton (opcionUnoHospitalButton);
	}
	
	//Agregar Método del Botón Continuar
	
	public void tapAceptarYcontinuarAlerta() {
		tapButton (AlertButtonAceptarYcontinuar);
	}
	
	//Como opcional puedo agregar la espera del texto "Selecciona la fecha y hora"
	
	public void tapAbrirCalendario() { //revisar funcionamiento de método
		tapButton (ButtonAbrirCalendario);
		forceDelay(800);
		LocalDate hoy = LocalDate.now(); 
		LocalDate diaPrevio = hoy.minusDays(1);
        int diaDelMes = diaPrevio.getDayOfMonth();
        diaEnCalendario = By.xpath("//*[contains(@text, \"" + diaDelMes + " de\")]");
		driver.findElement(diaEnCalendario).click();	//driver public?	
	}
	
	public void ingresarHora() {
		tapButton(ingresarHora);
		clearCampo(ingresarHora);
		setText(ingresarHora, "08");
		hideKeyboard();
		tapButton(ingresarMinutos);
		clearCampo(ingresarMinutos);
		setText(ingresarMinutos, "45");
		hideKeyboard();
		tapButton(amHoraButton);
	}
	
	
}
