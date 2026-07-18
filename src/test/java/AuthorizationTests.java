import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTests {
    @Test
    void test01LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
    }
}
