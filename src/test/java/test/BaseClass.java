package test;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import javax.sql.rowset.WebRowSet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	Robot robot;
	Actions actions;
	

	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void launchURL(String url) {

		driver.get(url);
		driver.navigate();
		driver.manage().window().maximize();
	}

	public WebElement findLocator(String locator, String value) {

		WebElement element = null;
		switch (locator) {

		case "id":

			element = driver.findElement(By.id(value));
			break;
		case "name":

			element = driver.findElement(By.name(value));
			break;
		case "xpath":

			element = driver.findElement(By.xpath(value));
			break;

		default:
			break;
		}
		return element;

	}

	public void enterText(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void btnLogin(WebElement element) {
		element.click();
	}

	public void createNewUserName(WebElement element, String data, WebElement element2, String data2) {
		element.sendKeys(data);
		element2.sendKeys(data2);
	}

	public void sendTexts(WebElement element, String sendkeys) {
		element.sendKeys(sendkeys);
	}

	public void dropAndDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
	}
	

	public void windowHandle() {
		String w1 = driver.getWindowHandle();
		System.out.println(w1);
		Set<String> w2 = driver.getWindowHandles();
		System.out.println(w2);
		for (String win : w2) {
			if (!(win.equals(w2))) {
				driver.switchTo().window(win);
			}

		}

	}

	public void dragAndDrop(WebElement ele1, WebElement ele2) {
		actions = new Actions(driver);
		actions.dragAndDrop(ele1, ele2).perform();

	}

	public void clear(WebElement ele) {
		ele.clear();
	}

	public void alert(String ele) {
		Alert alert = (Alert) driver.switchTo().window(ele);
		alert.accept();

	}

	public void doubleclick(WebElement ele) {
		actions.doubleClick(ele).perform();

	}

	public void copy() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}

	public void past() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

}
