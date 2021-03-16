package tests;

import com.codeborne.selenide.Condition;
import config.ConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
@Feature("Main page content")
public class MainPageTests extends TestBase {


    @Test
    void loginTest() {
        open("");
        mainPage.login(ConfigHelper.getLogin(), ConfigHelper.getPassword());
        $(byText("Выберите МФЦ")).should(Condition.visible);

    }
    @Test
    void chooseMFCTest() {
        open("");
        mainPage.login(ConfigHelper.getLogin(), ConfigHelper.getPassword());
        mainPage.chooseMFC(ConfigHelper.getMFC());
        $(byText("Выберите роль")).should(Condition.visible);
    }

    @Test
    void chooseRoleTest() {
        open("");
        mainPage.login(ConfigHelper.getLogin(), ConfigHelper.getPassword());
        mainPage.chooseMFC(ConfigHelper.getMFC());
        mainPage.chooseRole("Аудитор");
        $("#auth-info").shouldHave(text("Иванов Петр Степанович"));
    }

    @Test
    void changeRoleTest() {
        open("");
        mainPage.login(ConfigHelper.getLogin(), ConfigHelper.getPassword());
        mainPage.chooseMFC(ConfigHelper.getMFC());
        mainPage.chooseRole("Аудитор");
        $("#auth").$(byText("Аудитор")).click();
        $$(".x-form-radio-group .x-form-cb-label").findBy(text("Администратор")).click();
        $$(".x-box-inner .x-btn-inner").get(0).click();

    }


}
