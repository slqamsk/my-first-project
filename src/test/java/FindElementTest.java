import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindElementTest {

    @Test
    void test01() {
        open("https://slqa.ru/cases/cinema/index_only_age.html");
        $(By.tagName("h1")).shouldHave(text("Расчёт стоимости билета в кино"));
        $(By.id("age")).sendKeys("35");
        sleep(10_000);
    }
}
