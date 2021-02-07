import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class PageObjectTest {

    @BeforeEach
    void openWebSite() {
        open("http://localhost:7777");
    }

    @Test
    void MoneyTransferFirstCardTest() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);
        val dashBoardTransferPage = dashBoardPage.MakeTransferFirst();
        val newDashboardPage = dashBoardTransferPage.TransferFirstCard(DataHelper.getMoneyTransferFirst());
        newDashboardPage.CheckMoneyFirstAfterReplenishment();
        newDashboardPage.CheckMoneySecondAfterRemoval();
        val dashBoardTransferRollBack = dashBoardPage.MakeTransferSecond();
        dashBoardTransferRollBack.TransferSecondCard(DataHelper.getMoneyTransferSecond());


    }

    @Test
    void MoneyTransferSecondCardTest() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);
        val dashBoardTransferPage = dashBoardPage.MakeTransferSecond();
        val newDashboardPage = dashBoardTransferPage.TransferSecondCard(DataHelper.getMoneyTransferSecond());
        newDashboardPage.CheckMoneySecondAfterReplenishment();
        newDashboardPage.CheckMoneyFirstAfterRemoval();
        val dashBoardTransferRollBack = dashBoardPage.MakeTransferFirst();
        dashBoardTransferRollBack.TransferFirstCard(DataHelper.getMoneyTransferFirst());


    }


}
