import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ElenaTests {

    @Test
    public void test01LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username"))
                .shouldBe(visible)
                .setValue("standard_user");
        $(By.id("password")).shouldBe(visible).setValue("stand_pass1");
        $(By.tagName("button")).click();
    }
    @Test
    public void test02LoginWrongPassword() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).shouldBe(visible).setValue("standard_user");
        $(By.id("password")).shouldBe(visible).setValue("321");
        $(By.tagName("button")).click();
    }
}