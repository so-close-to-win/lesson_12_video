package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class testsWithVideo {

    @Test
    void easy_selenide_test_google() {
        step("Открыть гугл", ()-> {
            open("https://www.google.com/");
        });
        step("Выполнить запрос", ()-> {
            $("[name=\"q\"]").setValue("wikipedia").pressEnter();
        });
        step("Проверить ответ", ()-> {
            $("body").shouldHave(text("wikipedia.org"));
        });
    }
}
