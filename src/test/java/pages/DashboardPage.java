package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item");
    private SelenideElement buttonAddOne = $("[data-test-id = \"92df3f1c-a033-48e6-8390-206f6b1f56c0\"] " +
            ">[data-test-id=action-deposit]");
    private SelenideElement buttonAddTwo = $("[data-test-id = \"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] " +
            "> [data-test-id=action-deposit]");
    private SelenideElement balanceFirst = $("[data-test-id = \"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
    private SelenideElement balanceSecond = $("[data-test-id = \"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    //баланс первой карты
    public int getFirstCardBalance() {
        val text = cards.get(0).text();
        return extractBalance(text);
    }

    //баланс второй карты
    public int getSecondCardBalance() {
        val text = cards.get(1).text();
        return extractBalance(text);
    }



    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public DashboardPage() {
        heading.shouldBe(visible);
    }


    //выбор пополнения второй карты
    public DashBoardTransferPage makeTransferSecond() {
        buttonAddTwo.click();
        return new DashBoardTransferPage();
    }

    //выбор пополнения первой карты
    public DashBoardTransferPage makeTransferFirst() {
        buttonAddOne.click();
        return new DashBoardTransferPage();
    }


}
