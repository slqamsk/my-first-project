import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WindowType;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
public class NewWindowTests {
    @Test
    void test01NewWindow() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/");
        sleep(5_000);
        getWebDriver().manage().window().setSize(new Dimension(1000, 1000));
        getWebDriver().manage().window().setPosition(new Point(0, 0));
        sleep(2_000);

        switchTo().newWindow(WindowType.WINDOW);
        sleep(5_000);
        open("https://demoqa.com/");
        getWebDriver().manage().window().setSize(new Dimension(1000, 1000));
        getWebDriver().manage().window().setPosition(new Point(1020, 0));
        sleep(2_000);

        switchTo().window(0);
        $x("//a[text()='Popups']").click();
        sleep(2_000);
        switchTo().window(1);
        $x("//h5[text()='Elements']/parent::*/parent::*").click();
        sleep(2_000);
        closeWindow();
        sleep(2_000);
        switchTo().window(0);
        closeWindow();
        sleep(2_000);
    }
}
