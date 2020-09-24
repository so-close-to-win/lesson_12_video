package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.CustomDriver;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.AttachmentsHelper.*;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class TestBase {
    @BeforeAll
    @Step("Tests setup")
    public static void beforeall() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = CustomDriver.class.getName();
    }

    @AfterEach
    @Step("Attachments")
    public void afterEach(){
        attachScreenshot("Last Screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getBrowserConsoleLogs());

        attachVideo();

        closeWebDriver();
    }

    public static String getBrowserConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}
