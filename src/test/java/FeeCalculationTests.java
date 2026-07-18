import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FeeCalculationTests {
    @Test
    void test01Open() {
        open("https://slqa.ru/cases/fc/v01/index.php");

        // Первый расчёт
        $(By.name("sum")).setValue("1000");
        $(By.name("submit")).click();
        $(By.name("sum")).shouldBe(exist);
        $(By.name("sum")).shouldBe(visible);

        SelenideElement se = $(By.name("sum"));
        System.out.println("Тег: " + se.getTagName());
        System.out.println("Текст: " + se.getOwnText());
        System.out.println("Значение: " + se.getValue());
        System.out.println("Атрибут type: " + se.getAttribute("type"));
        se.clear();

        // Второй расчёт
        $(By.name("sum")).setValue("200");
        $(By.name("submit")).click();

    }


    @Test
    void test02() {
        SelenideElement sumField = $(By.name("sum"));
        SelenideElement submitButton = $(By.name("submit"));
        ElementsCollection sumFields = $$(By.name("sum"));
        sumField.type("1000");
        submitButton.click();
        submitButton.shouldBe(Condition.interactable).shouldBe(Condition.editable);
        System.out.println("Размер списка с именем 'sum'" + sumFields.size());

    }

    @Test
    void test03() {
        open("https://slqa.ru/cases/fc/v01/index.php");
        sleep(5_000);
        $(By.name("sum")).setValue("2000");
        $(By.name("sum")).pressEnter();
        sleep(5_000);
        $x("//span[@name='com']").shouldHave(exactText("20"));
        sleep(5_000);

        //$(By.name("sum")).setValue("200");
        $x("//input[@name='sum']").setValue("200");
        sleep(10_000);

    }


}
