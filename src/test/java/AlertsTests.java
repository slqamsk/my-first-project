import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AlertsTests {
    @Test
    void test01SimpleAlert() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/popups/");
        sleep(5_000);
        $("#alert").click();
        sleep(2_000);
        switchTo().alert().accept();
        sleep(2_000);
    }

    @Test
    void test02ConfirmOk() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/popups/");
        sleep(5_000);

        $("#confirm").click();
        Alert alert = switchTo().alert();
        System.out.println(alert.getText());
        sleep(2_000);
        alert.accept();
        sleep(2_000);
    }
    @Test
    void test03ConfirmCancel() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/popups/");
        sleep(5_000);
        $("#confirm").click();
        Alert alert = switchTo().alert();
        System.out.println(alert.getText());
        sleep(2_000);
        alert.dismiss();
        sleep(2_000);
    }

    @Test
    void test04PromptOk() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/popups/");
        //sleep(5_000);

        $("#prompt").click();
        Alert alert = switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Сергей");
        //sleep(2_000);
        alert.accept();
        sleep(4_000);
        //class="wp-block-column is-layout-flow wp-block-column-is-layout-flow"
        $x("//p[@id='promptResult']")
                .shouldBe(exist)
                .shouldHave(text("Nice to meet you, Сергей!"));
    }
    @Test
    void test05PromptCancel() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/popups/");
        $("#prompt").click();
        Alert alert = switchTo().alert();
        System.out.println(alert.getText());
        sleep(2_000);
        alert.dismiss();
        sleep(2_000);
    }

    @Test
    void test05AlertExplicitWait() {
        open("https://demoqa.com/alerts");
        $("#timerAlertButton").click();
        Configuration.timeout = 60_000;
        Alert alert = switchTo().alert();
        Configuration.timeout = 4_000;
        alert.accept();
    }

    @Test
    void test06AlertExplicitWait() {
        open("https://demoqa.com/alerts");
        $("#timerAlertButton").click();
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(6));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }



}
