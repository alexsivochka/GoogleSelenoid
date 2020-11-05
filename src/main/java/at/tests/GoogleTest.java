package at.tests;

import at.SetUpAndTearDown;
import at.SimpleConfig;
import com.codeborne.selenide.Condition;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GoogleTest extends SetUpAndTearDown {

    private final SimpleConfig config = ConfigFactory.create(SimpleConfig.class);

    @Test(alwaysRun = true, description = "Простой гугл тест")
    public void googleTest() {
        open(config.baseUrl());
        sleep(8000);
        $("input[name='q']").shouldBe(visible, enabled).setValue("selenide").pressEnter();
        sleep(8000);
        String firstLinkText = $("div.rc a h3").shouldBe(visible).getText();
        assertThat(firstLinkText).isEqualToIgnoringCase("Selenide: лаконичные и стабильные UI тесты на Java");
    }

}
