package utils;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseActions {

	static AndroidDriver<MobileElement> driver;
	static WebDriverWait driverWait;
	static WebDriverWait driverWaitShort;
	static SoftAssert softassert = new SoftAssert();
	
	public void setUpDriver() {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.UDID, "XOTCXO7DJNUGEYS4");
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "XOTCXO7DJNUGEYS4");
		ds.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		ds.setCapability("unicodeKeyboard", true); // Deshabilitar teclado
		ds.setCapability("autoGrantPermissions", true); // Otorgar permisos
		ds.setCapability("appPackage", "com.gnp");
		ds.setCapability("appActivity", "com.gnp.MainActivity");
				
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723"), ds);
			driverWait = new WebDriverWait(driver, 30);
			driverWaitShort = new WebDriverWait(driver, 3);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Hubo un problema al iniciar el driver...");
		}			
	}
	
	public void tearDownDriver() {
		System.out.println("Fin de la ejecución");
		forceDelay(3000);
		driver.quit();
	}

	public void tapButton(By element) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(element));
		driver.findElement(element).click();
		System.out.println("Click a botón: " + element);
	}
	
	public void setText(By element, String text) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(element));
		driver.findElement(element).sendKeys(text);
		System.out.println("Texto enviado: " + text + " a elemento: " + element);
	}
	
	public void waitForElement(By element) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(element));
		System.out.println("El elemento es visible: " + element);
	}
	
	public boolean waitForElementShort(By element) {
		try {
			driverWaitShort.until(ExpectedConditions.presenceOfElementLocated(element));
			System.out.println("El elemento es visible: " + element);
			return true;
		} catch(Exception e) {
			System.out.println("No se mostró el elemento");
			return false;
		}
	}
	
	public void hideKeyboard() {
		driver.hideKeyboard();
	}
	
	public String getText(By element) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(element));
		String text = driver.findElement(element).getText();
		System.out.println("El texto obtenido es: " + text);
		return text;
	}
	
	public String getTextByContentDescription(By element) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(element));
		String text = driver.findElement(element).getAttribute("content-desc");
		System.out.println("El texto obtenido es: " + text);
		return text;
	}
	
	public void checkTextEquals(By element, String textExpected) {
		
		String elementText = getTextByContentDescription(element).replaceAll("\\r?\\n", " ");
		elementText = elementText.replaceAll("  ", "");
		
		if(elementText.equals(textExpected)) {
			System.out.println("Los textos son iguales");
		} else {
			softassert.assertEquals(elementText, textExpected);
		}
	}
	
	public void swipeLeft() {
		Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.85);
        int endX = (int) (size.width * 0.15);
        int startY = size.height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, startY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
        System.out.println("SwipeLeft");
	}
	
	public void swipeRight() {
		Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.15);
        int endX = (int) (size.width * 0.85);
        int startY = size.height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, startY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
        System.out.println("Swiperight");
	}
	
	public void swipedownparaSegumuentoalsiniestro() {
		Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width / 2);
        int endX = startX;
        int startY = (int) (size.height /2+200);
        int endY= (int )((size.height/2)-650);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
        System.out.println("SwipeDown");
	}
	
	public void swipeupnparaSegumuentoalsiniestro() {
		Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width / 2);
        int endX = startX;
        int startY = (int) (size.height /2-200);
        int endY= (int )((size.height/2)+650);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
        System.out.println("SwipeDown");
	}

	
	public void forceDelay(int time) {
		try {
			Thread.sleep(time);
		}catch(Exception e) {
			
		}
	}
	
	public void assertAllTexts() {
		softassert.assertAll();
	}
	
	public void waitForElementDissapears(By element) {
		do {
			try {
				driver.findElement(element);
				System.out.println("Aún no desaparece el elemento: " + element);
			}catch(Exception e) {
				System.out.println("Desapareció el elemento " + element);
				break;
			}
			forceDelay(500);
		} while(true);
	}
	
	public void textIsAlphabetical(String text) {
		Boolean isAlphabetical;
		String regex = "^[A-Za-záéíóúüñÑ]+( [A-Za-záéíóúüñÑ]+)*$";
		
		isAlphabetical = text.matches(regex);
		if(!isAlphabetical) {
			throw new RuntimeException("Text is not alphabetical: " + text);
		}
	}

	public void textIsNumeric(String text) {
		Boolean isNumeric;
		String regex = "^\\d{14}$";
		
		isNumeric = text.matches(regex);
		if(!isNumeric) {
			throw new RuntimeException("Text is not numeric: " + text);
		}
	}
	
}
