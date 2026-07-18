import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class WaitsTest {
    @Test
    void test01SimpleWaitTest() {
        open("https://slqa.ru/cases/WaitsSimpleForm/");
        $x("//input[@id='duration_time']").setValue("10");
        $x("//button[@id='show_element']").click();
        Configuration.timeout = 12_000;
        $x("//div[@id='dynamic_content']").shouldHave(text("за 10000 миллисекунд."));
    }

    @Test
    void test02SimpleWaitsTest() {
        open("https://slqa.ru/cases/WaitsSimpleForm/");
        $("#duration_time").setValue("1");
        $("#show_element").click();

        $("#dynamic_content")
                .shouldHave(
                        text("за 1000 миллисекунд."),
                        Duration.ofSeconds(180)
                );
        //$("#wrong_id").shouldBe(exist);
    }
















}
