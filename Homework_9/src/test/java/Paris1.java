import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Paris1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Aliaksandr\\Desktop\\AutomationHomeworks-Homework_9\\AutomationHomeworks-Homework_9\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //Launch Chrome in Incognito mode
//        ChromeOptions optionsIncognito = new ChromeOptions();
//        optionsIncognito.addArguments("incognito");
//        capabilities.setCapability(ChromeOptions.CAPABILITY, optionsIncognito);
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
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();

        //Sorting by lowest price
        WebElement lowestPrice = driver.findElement(By.xpath("//*[@data-category=\"price\"]"));
        lowestPrice.click();

        //Checking cheap hotels exist
        WebElement cheapHotels = driver.findElement(By.xpath("//a[@data-id='pri-1']"));
        String maxPrice = cheapHotels.getAttribute("data-value");
        int maxPricePerDay = Integer.parseInt(maxPrice);
        System.out.println("Cheapest hotels" + " " + cheapHotels.getText());
        cheapHotels.click();

        //Pick top-rated hotel
        WebElement bestScore = driver.findElement(By.xpath("//a[@data-id='review_score-90']"));
        bestScore.click();

        //Check price range !DOESN'T WORK!!
        WebElement hotelPrice = driver.findElement(By.xpath("//div[@class=\"bui-price-display__value prco-inline-block-maker-helper\"]"));
        int pricePerDay = Integer.parseInt(hotelPrice.getText().substring(2).replace("[^0-9]", "")) / 7;
        System.out.println(pricePerDay);
        Assert.assertTrue(maxPricePerDay >= pricePerDay);
    }
}
