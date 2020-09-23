package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.Assert.assertThat;

public class tests_with_video {
    
    @Test
    public void easy_selenide_test_google() {
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
