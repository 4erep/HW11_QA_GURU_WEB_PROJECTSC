package tests;

import com.codeborne.selenide.Condition;
import config.ConfigHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.DriverHelper.getConsoleLogs;

@Tag("web")
@Feature("Orders page content")
public class OrdersPageTests extends TestBase {

    @Test
    @DisplayName("Open Requesters page")
    void enterRequestersPageTest() {
        open("");
        mainPage.login(ConfigHelper.getLogin(), ConfigHelper.getPassword());
        mainPage.chooseMFC(ConfigHelper.getMFC());
        mainPage.chooseRole("Аудитор");
        $(byText("Заявители")).should(visible).click();
        $("#requestersSearch-body").should(Condition.visible);
    }

    @Test
    @DisplayName("Changing role from orders page")
    void changeRoleTest() {
        open("");
        mainPage.login(ConfigHelper.getLogin(), ConfigHelper.getPassword());
        mainPage.chooseMFC(ConfigHelper.getMFC());
        mainPage.chooseRole("Аудитор");
        $("#auth").$(byText("Аудитор")).click();
        $$(".x-form-radio-group .x-form-cb-label").findBy(text("Администратор")).click();
        $$(".x-box-inner .x-btn-inner").get(0).click();
        $("#auth").$(byText("Администратор")).should(visible);
        String consoleLogs = getConsoleLogs();
    }
}
