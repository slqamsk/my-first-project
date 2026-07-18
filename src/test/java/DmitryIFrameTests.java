import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DmitryIFrameTests {


    @Test
    void switchToFrameTest() {
        open("https://demoqa.com/frames");

        for (int i = 1; i < 3; i++) {
            String frame = "frame" + i;
            String frameLocator = "iframe[id='" + frame + "']";
            switchTo().frame($("iframe[id='"+frame+"']"));
            System.out.println("Фрейм " + i + " обнаружен");
            $("h1").shouldHave(text("This is a sample page"));
            switchTo().defaultContent();
        }


        for (int i = 1; i == $$("frame").size(); i++) {
            String frame = "frame" + i;
            switchTo().frame($("iframe[id='"+frame+"']"));
            System.out.println("Фрейм " + i + " обнаружен");
            $("h1").shouldHave(text("This is a sample page"));
            switchTo().defaultContent();
        }

    }
}