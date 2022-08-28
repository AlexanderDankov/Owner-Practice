package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import com.simbirsoft.config.WebConfig;
import com.simbirsoft.pages.ProductStorePage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    ProductStorePage storePage = new ProductStorePage();

    @BeforeAll
    static void setup() {
        if (System.getProperty("env") != null) {
            WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

            Configuration.browser = config.getBrowser();
            Configuration.browserVersion = config.getVersion();
            Configuration.browserSize = config.getSize();

            if (config.isRemote()) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
                Configuration.browserCapabilities = capabilities;

                String remoteUrl = config.getRemoteUrl();
                Configuration.remote = format("https://%s:%s@%s/wd/hub/", config.Login(), config.Password(), remoteUrl);
            }
        }
    }
}
