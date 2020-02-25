import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Paris2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Aliaksandr\\Desktop\\AutomationHomeworks-Homework_9\\AutomationHomeworks-Homework_9\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions languageOptions = new ChromeOptions();
        languageOptions.addArguments("--lang=en");
        capabilities.setCapability(ChromeOptions.CAPABILITY, languageOptions);
        WebDriver driver = new ChromeDriver(languageOptions);
        driver.manage().window().maximize();
        driver.get("https://www.booking.com");

        //Change currency for USD
        WebElement currency = driver.findElement(By.xpath("//a[@aria-controls=\"currency_selector_popover\"]"));
        currency.click();
        Thread.sleep(2000);
        WebElement usd = driver.findElement(By.xpath("//a[@data-currency=\"USD\"]"));
        usd.click();
        Thread.sleep(3000);

        //Search for Paris
        WebElement search = driver.findElement(By.xpath("//input[@id='ss']"));
        search.sendKeys("Paris");

        //Calendar +3 days from current date for 7 days booking
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date sevenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusSevenDays = dateFormat.format(sevenDays);

        driver.findElement(By.xpath("//div[@class=\"sb-date-field b-datepicker\"]")).click();
        driver.findElement(By.xpath("//*[@data-date='" + datePlusThreeDays + "']")).click();
        driver.findElement(By.xpath("//*[@data-date='" + datePlusSevenDays + "']")).click();

        //4 adults 2 rooms
        driver.findElement(By.xpath("//label[@id=\"xp__guests__toggle\"]")).click();
        WebElement adults = driver.findElement(By.xpath("(//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"])[1]"));
        WebElement rooms = driver.findElement(By.xpath("(//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button \"])[3]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(adults).build().perform();
        actions.click(rooms).build().perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();

        //Chose most expensive hotels
        WebElement expensiveHotels = driver.findElement(By.xpath("(//a[@data-id='pri-5'])[1]"));
        expensiveHotels.click();
        Thread.sleep(3000);

        //Chose lowest price from most expensive hotels
        WebElement lowestPrice = driver.findElement(By.xpath("//*[@data-category=\"price\"]"));
        lowestPrice.click();
        Thread.sleep(2000);

        //Select room
        WebElement selectRoom = driver.findElement(By.xpath("//a[@data-click-store-id=\"sr-compset-53517\"]"));
        selectRoom.click();
        Thread.sleep(5000);

        //Reserve selection
        WebElement reserveSelection = driver.findElement(By.xpath("//td[@class=\"submitButton\"]//a"));
        reserveSelection.click();




    }
}
