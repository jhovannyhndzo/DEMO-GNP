package FlujoSOSautos;

import org.openqa.selenium.By;

import utils.BaseActions;

public class Seguimientoalsiniestro extends BaseActions{
	
	private By Spinner =By.xpath("//android.widget.ImageView");

	
	private By Contratante= By.xpath("//android.widget.TextView[@text=\"ENRIQUE BENITEZ ORTIZ\"]");
	private By nopoliza= By.xpath("//android.widget.TextView[@text=\"00001416533428\"]");
	private By Ssiniestro = By.xpath("//android.widget.TextView[@text=\"Siniestro Registrado\"]");
	private By Nsiniestro = By.xpath("//android.widget.TextView[@text=\"0007862303\"]");
	private By Nserie = By.xpath("//android.widget.TextView[@text=\"XCVYGYMN938330021\"]");
	private By Marca = By.xpath("//android.widget.TextView[@text=\"CADILLAC\"]");
	private By Vehiculo = By.xpath("//android.widget.TextView[@text=\"--\"]");
	private By Modelo = By.xpath("//android.widget.TextView[@text=\"2022\"]");
	
	private By Placas = By.xpath("//android.widget.TextView[@text=\"VUY0021\"]");
	private By Color = By.xpath("//android.widget.TextView[@text=\"--\"]");
	private By TSiniestro = By.xpath("//android.widget.TextView[@text=\"Colisión\"]");
	private By AutoA = By.xpath("//android.widget.TextView[@text=\"Si\"]");
	private By FHRep = By.xpath("//android.widget.TextView[@text=\"19 agosto 2024 15:53 hrs\"]");
	private By Noconductor = By.xpath("//android.widget.TextView[@text=\"Enrique Benitez Ortiz\"]");
	private By Estado = By.xpath("//android.widget.TextView[@text=\"Mexico\"]");
	private By Municipio = By.xpath("//android.widget.TextView[@text=\"Texcoco\"]");
	
	private By Regresar= By.xpath("//android.widget.ImageButton[@content-desc=\"Navegar hacia arriba\"]");
	private By regresar= By.xpath("//android.widget.Button");
	
	
	
   public void waitSpinner() {
	   waitForElementDissapears(Spinner);
	   
   }


	public void GetContratante() {
		getText(Contratante);
		getText(nopoliza);
		getText(Ssiniestro);
		getText(Nsiniestro);
		getText(Nserie);
		getText(Marca);
		getText(Vehiculo);
	    getText(Modelo);
	
	}
	
	public void Getcontratantedatos() {
		getText(Placas);
		getText(Color);
		getText(TSiniestro);
		getText(AutoA);
		getText(FHRep); }
	
	public void Getcontratanedatoss(){
		getText(Noconductor);
		getText(Estado);
	    getText(Municipio);
	}
	
	public void tapregresar (){
		tapButton(Regresar);
		
	}
	public void tapRegresar (){
		tapButton(regresar);
	}
	
	
	}
	



