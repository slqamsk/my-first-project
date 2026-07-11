import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FeeCalculationTests {
    @Test
    void test01Open() {
        open("https://ya.ru");
        sleep(3_000);
        $(By.id("text")).sendKeys("100");
        sleep(3_000);
        $(By.id("text")).setValue("200");
        sleep(2_000);
        //$(By.name("submit")).click();
        sleep(10_000);
    }
}
