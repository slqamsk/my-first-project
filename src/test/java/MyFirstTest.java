import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MyFirstTest {
    @Test
    void test01Open() {
        open("https://slqamsk.github.io");
    }
}
