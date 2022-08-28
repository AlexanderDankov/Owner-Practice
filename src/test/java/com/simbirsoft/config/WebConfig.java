package com.simbirsoft.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${env}.properties",
        "classpath:config/credential.properties"
})
public interface WebConfig extends Config {

    @Key("driver.remote")
    boolean isRemote();

    @Key("driver.browser")
    String getBrowser();

    @Key("driver.version")
    String getVersion();

    @Key("driver.size")
    String getSize();

    @Key("remote.url")
    String getRemoteUrl();

    @Key("remote.login")
    String Login();

    @Key("remote.password")
    String Password();
}
