package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("web")
@Feature("Главная страница")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Панель МФЦ на главной странице отображается")
    void openMainPaigeTest() {
        open("");
        $("#page_title").shouldHave(text("Digit МФЦ"));
    }

    @Test
    @DisplayName("В консоли нет ошибок")
    void consoleLogShouldNotHaveErrors() {
        open("");
        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs, not(containsString("SEVERE")));
    }
}
