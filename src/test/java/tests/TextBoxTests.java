package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {

        open("/text-box");
        $("[id=userName]").setValue("Anna");
        $("[id=userEmail]").setValue("annushka@mail.ru");
        $("[id=currentAddress]").setValue("Moscow, Griboedova, 15, 4");
        $("[id=permanentAddress]").setValue("Moscow, Griboedova, 15, 4");
        $("[id=submit]").click();

        $("#output #name").shouldHave(text("Anna"));
        $("#output #email").shouldHave(text("annushka@mail.ru"));
        $("#output #currentAddress").shouldHave(text("Moscow, Griboedova, 15, 4"));
        $("#output #permanentAddress").shouldHave(text("Moscow, Griboedova, 15, 4"));
    }

}
