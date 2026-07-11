import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FeeCalculationTests {
    @Test
    void test01Open() {
        open("https://slqa.ru/cases/fc/v01/index.php");
        sleep(3_000);
        $(By.name("sum")).sendKeys("100");
        $(By.name("submit")).click();
        sleep(10_000);
    }
}
