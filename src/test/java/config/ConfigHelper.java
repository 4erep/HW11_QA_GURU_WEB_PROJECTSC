package config;
import org.aeonbits.owner.ConfigFactory;
import java.nio.charset.StandardCharsets;

public class ConfigHelper {
    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    public static String getLogin() {
        return getAuthConfig().Login();
    }

    public static String getPassword() {
        return getAuthConfig().Password();
    }

    public static String getMFC() {
        return getAuthConfig().MFC();
    }

    public static String getRole() {
        return getAuthConfig().Role();
    }

    public static String getWebBrowser() {
        return getWebConfig().webBrowser();
    }

    public static String getWebBrowserScreenResolution() {
        return getWebConfig().webBrowserScreenResolution();
    }

    public static String getWebRemoteDriver() {
        // https://%s:%s@selenoid.autotests.cloud/wd/hub/
        return String.format(System.getProperty("web.remote.driver"),
                getWebConfig().webRemoteDriverUser(), getWebConfig().webRemoteDriverPassword());
    }

    public static boolean isRemoteWebDriver() {
        return System.getProperty("web.remote.driver") != null;
    }

    public static String getWebVideoStorage() {
        return System.getProperty("video.storage");
    }

    public static boolean isVideoOn() {
        return getWebVideoStorage() != null;
    }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

    private static AuthConfig getAuthConfig() {
        return ConfigFactory.newInstance().create(AuthConfig.class, System.getProperties());
    }
}
