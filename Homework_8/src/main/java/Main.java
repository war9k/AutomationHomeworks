import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aliaksandr\\Desktop\\AAT\\!Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.booking.com");
        //Ввести Moscow в строке поиска
        WebElement search = driver.findElement(By.xpath("//input[@id='ss']"));
        search.click();
        search.sendKeys("Moscow");

        //Нажимаем кнопку Search
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
        submit.click();
        Thread.sleep(2000);

        //ВВодим даты пребывания
//        Thread.sleep(2000);
//        WebElement checkinDate = driver.findElement(By.xpath("(//div[@class=\"sb-date-field__display\"])[1]"));
//        checkinDate.click();
//
//        WebElement date1 = driver.findElement(By.xpath(".//td[@data-id=\"1582502400000\"]"));
//        date1.click();
//
//        WebElement checkoutDate = driver.findElement(By.xpath("(//div[@class=\"sb-date-field__display\"])[2]"));
//        checkoutDate.click();
//
//        WebElement date2 = driver.findElement(By.xpath("//td[@data-date=\"2020-02-29\"]"));
//        date2.click();

        //Проверка, что недоступных гостинниц нету
        List<WebElement> ne = driver.findElements(By.xpath("//p[contains(text(),\"успели\")]"));
        System.out.println("Количество гостиниц, которые нельзя забронировать на эти даты: " + ne.size());

        //Фильтрация гостиниц по рейтингу
        WebElement starRating = driver.findElement(By.xpath("(//div[@class=\"bui-checkbox__label filter_item css-checkbox\"])[5]"));
        starRating.click();
        Thread.sleep(2000);

        WebElement sortBystars = driver.findElement(By.xpath("(//a[@class=\"hotel_name_link url\"])[1]"));
        sortBystars.click();
        Thread.sleep(3000);

        //Переход на новую вкладку
//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String widow : windowHandles) {
//            driver.switchTo().window(String.valueOf(windowHandles));
//        }
//
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);

        //Проверка на рейтинг
        WebElement ratingCheck = driver.findElement(By.xpath("(//div[@class=\"bui-review-score__badge\"])[1]"));
        double realReview = Double.parseDouble(ratingCheck.getText());
        if (realReview >= 9.0) {
            System.out.println("Hotel rate " + realReview);
            driver.quit();
        }
    }
}
