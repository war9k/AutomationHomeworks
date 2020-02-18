import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/JAVA/JavaAutomationHomeworks/Homework_8/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("http://www.booking.com");
        //Ввести Moscow в строке поиска
        WebElement search = driver.findElement(By.xpath("//input[@id='ss']"));
        search.click();
        search.sendKeys("Moscow");

        //Нажимаем кнопку Search
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
        submit.click();

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
        WebElement starRating = driver.findElement(By.xpath("//a[contains(text(), \"Количество звезд и цена\")]"));
        starRating.click();

        WebElement sortBystars = driver.findElement(By.xpath("//a[contains(text(), \"количество звезд [5→1]\")]"));
        sortBystars.click();

        //Проверка на рейтинг
        WebElement ratingCheck = driver.findElement(By.xpath("(//div[text()=10])[3]"));
        int realReview = Integer.parseInt(ratingCheck.getText());
        if (realReview >= 9) {
            System.out.println("Рейтинг отеля " + realReview);
        }
    }
}
