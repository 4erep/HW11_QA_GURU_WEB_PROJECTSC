package tests;

import com.codeborne.selenide.Condition;
import config.ConfigHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.DriverHelper.getConsoleLogs;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("web")
@Feature("Main page content")
public class MainPageTests extends TestBase {


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
