import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FindElementV2Test {

    @Test
    void test01() {
        Selenide.open("");

        open("https://slqa.ru/cases/cinema/index_only_age.html");
        $(By.tagName("h1")).shouldHave(text("Расчёт стоимости билета в кино"));
        $(By.id("age")).sendKeys("35");
        sleep(10_000);
    }

    @Test
    void test02() {
        open("https://www.saucedemo.com/");
        sleep(4_000);
        $(By.id("user-name")).sendKeys("Sergey");
        sleep(1_000);
        $(By.id("password")).sendKeys("lsadkfgjop2i43");
        sleep(4_000);
        $(By.id("login-button")).shouldBe(visible);
        $(By.id("login-button")).click();
        sleep(5_000);
    }
}
