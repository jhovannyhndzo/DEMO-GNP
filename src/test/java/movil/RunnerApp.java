package movil;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import home.Home;
import intro_and_login.Intro;
import intro_and_login.Login;
import utils.BaseActions;

public class RunnerApp extends BaseActions {

	Intro intro = new Intro();
	Login login = new Login();
	Home home = new Home();
	
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
		intro.acceptCompatibilityAlert();
		intro.checkFirstIntroMessage();
		swipeLeft();
		intro.checkSecondIntroMessage();
		swipeLeft();
		intro.checkThirdIntroMessage();
		intro.tapContinue();
		login.enterEmail(email);
		login.tapPassword();
		login.waitForWelcomeMessage();
		login.enterPassword(password);
		login.tapLogin();
		login.closeOtherSession();
		home.waitForWelcomeMessage();
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
