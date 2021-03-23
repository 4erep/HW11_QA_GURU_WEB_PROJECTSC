package Pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public void login(String username, String password) {
        $("#login").click();
        $(byText("Внутренняя авторизация")).should(Condition.visible);
        $(byName("username")).setValue(username);
        $(byName("password")).setValue(password);
        $$(".x-box-inner .x-btn-inner").findBy(text("Вход")).click();
    }

    public void chooseMFC(String MFCname) {
        $$(".x-form-radio-group .x-form-cb-label").findBy(text(MFCname)).click();
        $$(".x-box-inner .x-btn-inner").get(0).click();
    }

    public void chooseRole(String role) {
        $$(".x-form-radio-group .x-form-cb-label").findBy(text(role)).click();
        $$(".x-box-inner .x-btn-inner").get(1).click();
    }

}
