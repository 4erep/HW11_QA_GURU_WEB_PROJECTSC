package config;

import org.aeonbits.owner.ConfigFactory;


public class AuthConfigHelper {
    public static String getLogin() {
        return getAuthConfig().login();
    }

    public static String getPassword() {
        return getAuthConfig().password();
    }

    public static String getMFC() {
        return getAuthConfig().MFC();
    }

    private static AuthConfig getAuthConfig() {
        return ConfigFactory.newInstance().create(AuthConfig.class, System.getProperties());
    }
}
