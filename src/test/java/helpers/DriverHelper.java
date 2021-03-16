package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ConfigHelper;
import config.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {
//
//    static final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    public static void configureDriver() {
//        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
//        Configuration.browser = config.webBrowser();
//        Configuration.browserVersion = System.getProperty("browser", "chrome");
//        Configuration.startMaximized = true;
//        Configuration.baseUrl = config.webUrl();
////        Configuration.baseUrl = "http://demo.sc.smart-consulting.ru/cpgu/";
//        if (config.webRemoteDriverUrl() != null) {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", true);
//            Configuration.browserCapabilities = capabilities;
//            Configuration.remote = config.webRemoteDriverUrl();
//        }


        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
//        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browser = ConfigHelper.getWebBrowser();

        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        if (ConfigHelper.isRemoteWebDriver()) {
            // config for Java + Selenide
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = ConfigHelper.getWebRemoteDriver();

        }
        Configuration.baseUrl = ConfigHelper.getWebUrl();
////        Configuration.baseUrl = "http://demo.sc.smart-consulting.ru/cpgu/";
    }



    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid","");
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}
