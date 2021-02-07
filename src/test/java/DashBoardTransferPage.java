import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashBoardTransferPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement buttonAdd = $("[data-test-id=action-transfer]");
    private SelenideElement amount = $("[data-test-id=amount] input");
    private SelenideElement from = $("[data-test-id=from] input");


    public DashBoardTransferPage() {
        heading.shouldBe(visible);
    }

    //пополнение первой карты
    public DashboardPage TransferFirstCard(DataHelper.MoneyTransferFirstCard moneyTransferFirstCard) {
        amount.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.DELETE);
        amount.setValue(moneyTransferFirstCard.getAmountForFirst());
        from.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.DELETE);
        from.setValue(moneyTransferFirstCard.getCardNumberSecond());
        buttonAdd.click();
        return new DashboardPage();
    }

    //пополнение второй карты
    public DashboardPage TransferSecondCard(DataHelper.MoneyTransferSecondCard moneyTransferSecondCard) {
        amount.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.DELETE);
        amount.setValue(moneyTransferSecondCard.getAmountForSecond());
        from.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.DELETE);
        from.setValue(moneyTransferSecondCard.getCardNumberFirst());
        buttonAdd.click();
        return new DashboardPage();
    }
}
