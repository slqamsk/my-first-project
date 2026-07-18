import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
public class PizzeriaTests {
    @Test
    void test01AddPizzas() {
        open("https://slqamsk.github.io/cases/pizza/v08/");
        $x("//h3[contains(.,'Маргарита')]/../button")
                .shouldBe(exist)
                .shouldBe(visible)
                .click();
        $x("//h3[contains(.,'Четыре сыра')]/../button").click();
    }
}