import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class EkaterinaTests {
    @Test
    void test01(){
        open("https://slqamsk.github.io/cases/pizza/v08/");
        $x("//*[@class='btn add-to-cart-btn'][1]").click();
        sleep(2_000);
        $x("//*[@class='btn add-to-cart-btn'][4]").click();
        sleep(2_000);
    }
}