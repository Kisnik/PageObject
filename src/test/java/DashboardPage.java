

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement buttonAddOne = $("[data-test-id = \"92df3f1c-a033-48e6-8390-206f6b1f56c0\"] " +
            ">[data-test-id=action-deposit]");
    private SelenideElement buttonAddTwo = $("[data-test-id = \"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] " +
            "> [data-test-id=action-deposit]");
    private SelenideElement balanceFirst = $("[data-test-id = \"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
    private SelenideElement balanceSecond = $("[data-test-id = \"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

    public DashboardPage() {
        heading.shouldBe(visible);
    }


    //выбор пополнения второй карты
    public DashBoardTransferPage MakeTransferSecond() {
        buttonAddTwo.click();
        return new DashBoardTransferPage();
    }

    //выбор пополнения первой карты
    public DashBoardTransferPage MakeTransferFirst() {
        buttonAddOne.click();
        return new DashBoardTransferPage();
    }

    //проверка баланса первой карты после пополнения
    void CheckMoneyFirstAfterReplenishment() {
      balanceFirst.shouldHave(exactText("**** **** **** 0001, баланс: 10500 р.\n" +
              "Пополнить"));

    }


    //проверка баланса второй карты после пополнения
    void CheckMoneySecondAfterReplenishment() {
      balanceSecond.shouldHave(exactText("**** **** **** 0002, баланс: 10500 р.\n" +
              "Пополнить"));

    }

    //проверка баланса первой карты после снятия
    void CheckMoneyFirstAfterRemoval() {
      balanceFirst.shouldHave(exactText("**** **** **** 0001, баланс: 9500 р.\n" +
              "Пополнить"));

    }

    //проверка баланса второй карты после снятия
    void CheckMoneySecondAfterRemoval() {
      balanceSecond.shouldHave(exactText("**** **** **** 0002, баланс: 9500 р.\n" +
              "Пополнить"));

    }

}
