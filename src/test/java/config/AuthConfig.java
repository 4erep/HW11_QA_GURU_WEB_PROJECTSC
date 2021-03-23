package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/auth.properties"
})
public interface AuthConfig extends Config {
    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("MFC")
    String MFC();

}
