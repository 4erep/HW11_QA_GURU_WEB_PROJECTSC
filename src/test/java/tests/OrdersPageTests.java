package tests;

import com.codeborne.selenide.Condition;
import config.AuthConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.DriverHelper.getConsoleLogs;

@Tag("web")
@Feature("Страница заявлений")
public class OrdersPageTests extends TestBase {

    @Test
    @DisplayName("Открытие страницы заявителей проходит успешно")
    void enterRequestersPageTest() {
        open("");
        mainPage.login(AuthConfigHelper.getLogin(), AuthConfigHelper.getPassword());
        mainPage.chooseMFC(AuthConfigHelper.getMFC());
        mainPage.chooseRole("Аудитор");
        $(byText("Заявители")).should(visible).click();
        $("#requestersSearch-body").should(Condition.visible);
    }

    @Test
    @DisplayName("Смена роли из страницы заявлений")
    void changeRoleTest() {
        open("");
        mainPage.login(AuthConfigHelper.getLogin(), AuthConfigHelper.getPassword());
        mainPage.chooseMFC(AuthConfigHelper.getMFC());
        mainPage.chooseRole("Аудитор");
        $("#auth").$(byText("Аудитор")).click();
        $$(".x-form-radio-group .x-form-cb-label").findBy(text("Администратор")).click();
        $(".x-box-inner .x-btn-inner").click();
        $("#auth").$(byText("Администратор")).should(visible);
        String consoleLogs = getConsoleLogs();
    }
}
