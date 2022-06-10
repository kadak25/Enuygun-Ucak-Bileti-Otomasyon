import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class EnuygunApp {

    WebDriver driver;

    String BASE_URL = "https://www.enuygun.com/";

    By planeTicketLocator = By.className("nav-link");
    By whereLocator = By.id("OriginInput");
    By toWhereLocator = By.id("DestinationInput");
    By htmlTag = By.tagName("html");

    By suggestWhereLocator = By.xpath("//input[@aria-activedescendant=\"react-autowhatever-OriginInput-section-0-item-0\"]");
    By suggestToWhereLocator = By.xpath("//input[@aria-activedescendant=\"react-autowhatever-DestinationInput-section-0-item-0\"]");
    By dateLocator = By.id("DepartureDate");
    By deneme = By.xpath("(//div[@class='CalendarMonth_caption CalendarMonth_caption_1'])[2]");
    By nextDateLocator = By.xpath("//div[@aria-label='Move forward to switch to the next month.']//*[name()='svg']");
    By tableDateLocator = By.xpath("(//div[@class='CalendarDay__content'][normalize-space()='1'])[2]");


    public EnuygunApp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    public void moveToPlaneTicket() {
        driver.findElements(planeTicketLocator).get(0).click();

    }

    public void where(String where) {
        driver.findElement(whereLocator).click();
        waitFor(whereLocator);
        driver.findElement(whereLocator).sendKeys(where);
        waitFor(suggestWhereLocator);
        driver.findElement(suggestWhereLocator).sendKeys(Keys.ENTER);
    }

    public void toWhere(String toWhere) {
        driver.findElement(toWhereLocator).click();
        waitFor(toWhereLocator);
        driver.findElement(toWhereLocator).sendKeys(toWhere);
        waitFor(suggestToWhereLocator);
        driver.findElement(suggestToWhereLocator).sendKeys(Keys.ENTER);
    }

    public void date() {
        driver.findElement(dateLocator).click();
        String checkDate = "Eylül 2022";
        String dateDay = "15";
        waitFor(deneme);
        while (true) {
            String Month = driver.findElement(deneme).getText();
            if (Month.equals(checkDate)) {
                break;
            } else {
                driver.findElement(nextDateLocator).click();
            }

            List<WebElement> dt = Collections.singletonList(driver.findElement(tableDateLocator));

            for (WebElement element : dt) {
                String date = element.getText();

                if (date.equals(dateDay)) {
                    element.click();
                    break;
                }
            }
        }

    }

    private void waitFor(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
