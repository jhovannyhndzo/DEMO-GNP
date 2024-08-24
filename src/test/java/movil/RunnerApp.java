package movil;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FlujoSOSautos.Autos;
import FlujoSOSautos.Nuevotramite;
import FlujoSOSautos.Seguimientoalsiniestro;
import FlujoSOSautos.mis_tramites;
import FlujoSOSautos.tramite;
import FlujoSOSautos.tramites_autos;
import app.home.misTramites.GastosMedicosMayores;
import home.Home;
import intro_and_login.Intro;
import intro_and_login.Login;
import utils.BaseActions;

public class RunnerApp extends BaseActions {

	Intro intro = new Intro();
	Login login = new Login();
	Home home = new Home();
	GastosMedicosMayores gastos = new GastosMedicosMayores();
	
	mis_tramites mt =new mis_tramites();
	tramites_autos ta =new tramites_autos();
	Nuevotramite nt=new Nuevotramite();
	tramite t=new tramite();
	Autos a= new Autos();
	Seguimientoalsiniestro sas = new Seguimientoalsiniestro();
	
	@BeforeClass
	public void setUp() {
		setUpDriver();
	}
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		return new Object[][] {
			{"octaviob@gazetecizgi.com", "Automate2023#"}
		};
	}
	
	@Test (priority = 1, dataProvider = "loginData")
	public void login(String email, String password) {
		//intro.acceptCompatibilityAlert();
		intro.checkFirstIntroMessage();
		swipeLeft();
		intro.checkSecondIntroMessage();
		swipeLeft();
		intro.checkThirdIntroMessage();
		intro.tapContinue();
		login.enterEmail(email);
		login.tapPassword();
		login.waitForWelcomeMessages();
		login.enterPassword(password);
		login.tapLogin();
		login.closeOtherSession();
		home.waitForWelcomeMessage();
		//Flujo MisTrámites-Pau
		home.tapbtnmistramites();
		gastos.tapGastosMedicosMayores();
		gastos.waitForTextQueDeseasHacer();
		gastos.tapnuevoTramite();
		swipeDown();
		swipeUp();
		gastos.tapSeleccionarPoliza();
		gastos.tapIngresoHospitalario();
		gastos.tapIngresoSinCarta();
		gastos.tapIniciarTramiteButton();
		gastos.waitForTextNombreDelAsegurado();
		gastos.tapContinuarButton();
		gastos.ingresarNombreDeHospital();
		gastos.tapBuscarHospitalButton();
		gastos.tapSeleccionarHospitalUno();
		gastos.tapAceptarYcontinuarAlerta();
		gastos.tapAbrirCalendario();
		gastos.ingresarHora();
		//Fin de flujoPau
		home.tapbtnmistramites();
		mt.tapbtnAutos();
		ta.waitForMessage();
		ta.tapBtnNtramite();
		nt.waitForMessage();
		nt.tapBtnNtramite();
		t.waitForMessagetramite();
		t.tapBtnSeguimiento();
		a.waitForMessageconsulta();
		a.tapBtnpoliza();  
		forceDelay(30000);
	
		//sas.waitForMessageSeguimiento();
		sas.GetContratante();
		swipedownparaSegumuentoalsiniestro();
		sas.Getcontratantedatos();
		swipedownparaSegumuentoalsiniestro();
		sas.Getcontratanedatoss();
		swipeupnparaSegumuentoalsiniestro();
		swipeupnparaSegumuentoalsiniestro();
		sas.tapregresar();
		sas.tapRegresar();
		sas.tapRegresar();
		sas.tapRegresar();
		sas.tapRegresar();
		sas.tapRegresar();
		
		
		
	}
		
	@Test (priority = 10)
	public void validateAllTexts() {
		assertAllTexts();
	}
	
	@AfterClass (alwaysRun = true)
	public void tearDown() {
		tearDownDriver();
	}
	
}
