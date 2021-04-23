package tests;

import allureAnnotations.JiraIssue;
import com.codeborne.selenide.Condition;
import config.AuthConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@JiraIssue("QC3-24")
@Tag("web")
@Feature("Тесты на авторизацию")
public class LoginTests extends TestBase {

    @Test
    @DisplayName("Авторизация по логину и паролю проходит успешно")
    void loginTest() {
        open("");
        mainPage.login(AuthConfigHelper.getLogin(), AuthConfigHelper.getPassword());
        $(byText("Выберите МФЦ")).should(Condition.visible);

    }

    @Test
    @DisplayName("Выбор филиала проходит успешно")
    void chooseMFCTest() {
        open("");
        mainPage.login(AuthConfigHelper.getLogin(), AuthConfigHelper.getPassword());
        mainPage.chooseMFC(AuthConfigHelper.getMFC());
        $(byText("Выберите роль")).should(Condition.visible);
    }

    @Test
    @DisplayName("Выбор роли проходит успешно")
    void chooseRoleTest() {
        open("");
        mainPage.login(AuthConfigHelper.getLogin(), AuthConfigHelper.getPassword());
        mainPage.chooseMFC(AuthConfigHelper.getMFC());
        mainPage.chooseRole("Аудитор");
        $("#auth-info").shouldHave(text("Иванов Петр Степанович"));
    }
}
