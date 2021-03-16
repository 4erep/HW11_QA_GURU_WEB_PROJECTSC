package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/auth.properties"
})
public interface AuthConfig extends Config {
    @Key("Login")
    String Login();

    @Key("Password")
    String Password();

    @Key("MFC")
    String MFC();

    @Key("Role")
    String Role();
}
