package tests;

import com.codeborne.selenide.Condition;
import config.ConfigHelper;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("web")
@Feature("Main page content")
public class MainPageTests extends TestBase {


    @AllureId("1962")
    @DisplayName("Digit MFC block on main page appear")
    @Test
    void openMainPaigeTest() {
        step("Open main page",
                () -> open(""));
        step("Check \"Digit МФЦ\" block appear",
                () -> $("#page_title").shouldHave(text("Digit МФЦ")));
    }

    @Test
    @DisplayName("Login should be successful")
    void loginTest() {
        open("");
        mainPage.login(ConfigHelper.getLogin(), ConfigHelper.getPassword());
        $(byText("Выберите МФЦ")).should(Condition.visible);

    }
    @Test
    @DisplayName("Choose MFC should be successful")
    void chooseMFCTest() {
        open("");
        mainPage.login(ConfigHelper.getLogin(), ConfigHelper.getPassword());
        mainPage.chooseMFC(ConfigHelper.getMFC());
        $(byText("Выберите роль")).should(Condition.visible);
    }

    @Test
    @DisplayName("Choose Role should be successful")
    void chooseRoleTest() {
        open("");
        mainPage.login(ConfigHelper.getLogin(), ConfigHelper.getPassword());
        mainPage.chooseMFC(ConfigHelper.getMFC());
        mainPage.chooseRole("Аудитор");
        $("#auth-info").shouldHave(text("Иванов Петр Степанович"));
    }

    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        open("");

        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs, not(containsString("SEVERE")));
    }
}
