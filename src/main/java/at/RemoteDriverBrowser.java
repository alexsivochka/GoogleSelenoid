package at;


import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class RemoteDriverBrowser implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://192.168.56.10:4444/wd/hub").toURL(),
                    SettingsBrowser.getDesiredCapabilities()
            );
            driver.setFileDetector(new LocalFileDetector());
            return driver;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Не удалось подключиться к url");
        }
    }

}

