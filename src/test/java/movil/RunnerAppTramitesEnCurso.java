package movil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FlujoSOSautos.mis_tramites;
import FlujoSOSautos.majorMedicalCosts.ContactTracking;
import FlujoSOSautos.majorMedicalCosts.HospitalDischarge;
import FlujoSOSautos.majorMedicalCosts.MajorMedicalCostsMainScreen;
import FlujoSOSautos.majorMedicalCosts.ViewOngoingProccesses;
import home.Home;
import intro_and_login.Intro;
import intro_and_login.Login;
import utils.BaseActions;

public class RunnerAppTramitesEnCurso extends BaseActions{

	Intro intro = new Intro();
	Login login = new Login();
	Home home = new Home();
	mis_tramites mt =new mis_tramites();
	MajorMedicalCostsMainScreen majorMedicalCostsMainScreen = new MajorMedicalCostsMainScreen(); 
	ViewOngoingProccesses viewOngoingProccesses = new ViewOngoingProccesses();
	ContactTracking contactTracking = new ContactTracking();
	HospitalDischarge hospitalDischarge = new HospitalDischarge();
	
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
	@DataProvider(name = "newContact")
	public Object[][] getNewContactData() {
		return new Object[][] {
			{"Nombre Prueba", "Apellido Prueba", "email@gmail.com", "7751112233"}
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
		home.waitForMyProfileBtn();
		
	}

	@Test (priority = 2)
	public void view_ongoing_processes () {
		Boolean alertIsDisplayed;
		int positionPolicy = 1;

		home.tapbtnmistramites();
		mt.tapOnMajorMedicalCostsBtn();
		majorMedicalCostsMainScreen.getMajorMedicalCostsTitle();
		majorMedicalCostsMainScreen.tapOnViewOngoingProccessesBtn();
		viewOngoingProccesses.getViewOngoinProccessesTitle();
		viewOngoingProccesses.tapOnFirstPolicyForDocumentReview(positionPolicy);
		do {
			viewOngoingProccesses.getTypeTrackingTitle();
			viewOngoingProccesses.getStatusTrackingTitle();
			viewOngoingProccesses.getResponsibleTrackingTitle();
			swipedownparaSegumuentoalsiniestro();
			viewOngoingProccesses.getWarningMessage();
			viewOngoingProccesses.getAffectedInsuredTitle();
			viewOngoingProccesses.getPolicyNumberTitle();
			viewOngoingProccesses.getMethodOfOpeningTitle();
			swipedownparaSegumuentoalsiniestro();
			viewOngoingProccesses.tapOnContinueWithTheCaptureBtn();
			alertIsDisplayed = contactTracking.waitToEditAlertIsDisplayed();
			if (alertIsDisplayed) {
				contactTracking.tapOnAcceptBtn();
				contactTracking.returnToTrackingScreen();
				viewOngoingProccesses.getViewOngoinProccessesTitle();
				positionPolicy += 1;
				viewOngoingProccesses.tapOnFirstPolicyForDocumentReview(positionPolicy);
			} else {
				break;
			}
		} while(true);
		contactTracking.getMessageAboutNotifications();
		contactTracking.getMyContactsTitle();
		swipedownparaSegumuentoalsiniestro();
	}
	
	@Test (priority = 3, dataProvider = "newContact")
	public void add_a_new_contact(String name, String surname, String email, String phone) {
		Boolean errorFound;
		
		contactTracking.getAddContactTitle();
		contactTracking.tapOnAddContactBtn();
		forceDelay(750);
		swipedownparaSegumuentoalsiniestro();
		forceDelay(1000);
		contactTracking.selectTypeContact();
		contactTracking.writeContactName(name);
		contactTracking.writeSurname(surname);
		contactTracking.writeEmail(email);
		contactTracking.writePhone(phone);
		errorFound = contactTracking.errorNotificationIsDisplayed();
		
		if(!errorFound) {
			contactTracking.tapOnContinuebtn();
		}
		
	}
	
	@Test (priority = 4)
	public void Upload_file() {
		hospitalDischarge.getUploadFileMessage();
		contactTracking.tapOnContinuebtn();
	}
	@Test (priority = 5)
	public void end_hospital_discharge() {
		hospitalDischarge.getMessage();
		hospitalDischarge.getInsuredTitle();
		hospitalDischarge.getInsuredName();
		hospitalDischarge.getInsuredNumberPolicy();
		hospitalDischarge.getInsuredCode();
		hospitalDischarge.getInsuredDateOfBirth();
		hospitalDischarge.getInsuredGender();
		hospitalDischarge.getContactTitle();
		swipedownparaSegumuentoalsiniestro();
		hospitalDischarge.getDocumentationTitle();
		hospitalDischarge.getComment();
		hospitalDischarge.tapOnSendBtn();
		forceDelay(3000);
		hospitalDischarge.getSuccessfullTitle();
		hospitalDischarge.getSuccessfullMessage();
		hospitalDischarge.getSuccessfullFolio();
		hospitalDischarge.tapOnEndBtn();
		forceDelay(3000);
		majorMedicalCostsMainScreen.getMajorMedicalCostsTitle();
	}
}
