import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SimplePangeaTest {
    @Test
    void PangeaTest01(){
        Configuration.browser = "chrome";
        open("https://www.pangea-center.ru/");
        getWebDriver().manage().window().maximize();
        $("body").shouldHave(text("АКЦИИ"))
                .shouldBe(visible);
        $("body").shouldHave(text("9 450 руб"));
        $("body").shouldHave(text("УЗИ чекап"));
        sleep(2000);
    }
    @Test
    void PangeaTest02(){
        Configuration.browser = "chrome";
        open("https://www.pangea-center.ru/");
        getWebDriver().manage().window().maximize();
        sleep(2_000);
        open("https://www.pangea-center.ru/vrachi/oftalmolog");
        sleep(2_000);
        open("https://www.pangea-center.ru/programms/dispancerization");
        sleep(2_000);
        back();
        sleep(2_000);
        back();
        sleep(2_000);
        forward();
        sleep(2_000);
    }
    @Test
    void PangeaTest03 () {
        open("https://www.pangea-center.ru/");
        getWebDriver().manage().window().maximize();
        $(".menutitle").click();
        sleep(2_000);
        $("body").shouldHave(text("Прейскурант"));
        sleep(5_000);
    }
}