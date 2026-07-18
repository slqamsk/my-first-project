import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class XPathExamplesTests {

    @BeforeEach
    void setUp() {
        open("https://slqamsk.github.io/tmp/xPath01.html");
    }

    @Test
    void test01SimpleXPath() {
        $(By.xpath("//h1")).shouldHave(text("Учебная страница для XPat"));
        $x("//h1").shouldHave(exactText("Учебная страница для XPath"));
        $x("//h1").shouldHave(exactText("Учебная страница для XPat"));
    }

    @Test
    void testSpecialParagraph01() {
        $x("//p[@class='special-paragraph']")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Этот параграф особенный - он единственный на странице с таким классом."));

        ElementsCollection infoParagraphs = $$x("//p[@class='info-text']");

        assertEquals(3, infoParagraphs.size());
        infoParagraphs.get(0)
                .should(exactText("Это первый информационный текст."));
        infoParagraphs.get(1)
                .should(exactText("Это второй информационный текст."));
        infoParagraphs.get(2)
                .should(exactText("Это третий информационный текст."));
    }

    @Test
    void testExternalLinks() {
        $x("//a[@class='external-link']")
                .shouldHave(text("Внешняя ссылка (Example)"))
                .shouldHave(attribute("href","https://example.com/"));

        $x("//a[@class='external-link'][2]")
                .shouldHave(text("Внешняя ссылка (Google)"))
                .shouldHave(attribute("href","https://google.com/"));
    }

    @Test
    void testTextSearch() {
        open("https://slqa.ru/cases/xPathSimpleForm/");

        // Так - правильно, т.к. он не выбирает родительский div
        $x("//div[contains(text(),'Москва')]").shouldHave(text("250 единиц"));

        // Так - неправильно, т.к. он вместо нужного элемента возьмёт родительский div
        $x("//div[contains(.,'Москва')]").shouldHave(text("250 единиц"));
    }
}
