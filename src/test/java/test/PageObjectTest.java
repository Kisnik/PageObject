package test;

import helper.DataHelper;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageObjectTest {

    @BeforeEach
    void openWebSite() {
        open("http://localhost:7777");
    }



    @Test
    void moneyTransferFirstCardTest() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);
        int balanceOne = dashBoardPage.getFirstCardBalance();
        int balanceTwo = dashBoardPage.getSecondCardBalance();
        //уравнивание баланса
        if (balanceOne > balanceTwo) {
            val dashBoardTransferPage = dashBoardPage.makeTransferSecond();
            val newDashboardPage = dashBoardTransferPage.transferCard(DataHelper
                    .getMoneyTransfer(String.valueOf((balanceOne-balanceTwo)/2), "5559000000000001"));
        }
        if (balanceOne < balanceTwo) {
            val dashBoardTransferPage = dashBoardPage.makeTransferFirst();
            val newDashboardPage = dashBoardTransferPage.transferCard(DataHelper
                    .getMoneyTransfer(String.valueOf((balanceTwo-balanceOne)/2), "5559000000000002"));
        }
        balanceOne = dashBoardPage.getFirstCardBalance();
        balanceTwo = dashBoardPage.getSecondCardBalance();
        val dashBoardTransferPage = dashBoardPage.makeTransferFirst();
        val newDashboardPage = dashBoardTransferPage.transferCard(DataHelper
                .getMoneyTransfer("500", "5559000000000002"));
        int expectedOne = balanceOne + 500;
        int actualOne = dashBoardPage.getFirstCardBalance();
        assertEquals(expectedOne, actualOne);
        int expectedTwo = balanceTwo - 500;
        int actualTwo = dashBoardPage.getSecondCardBalance();
        assertEquals(expectedTwo, actualTwo);


    }

    @Test
    void moneyTransferSecondCardTest() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);
        int balanceOne = dashBoardPage.getFirstCardBalance();
        int balanceTwo = dashBoardPage.getSecondCardBalance();
        //уравнивание баланса
        if (balanceOne > balanceTwo) {
            val dashBoardTransferPage = dashBoardPage.makeTransferSecond();
            val newDashboardPage = dashBoardTransferPage.transferCard(DataHelper
                    .getMoneyTransfer(String.valueOf((balanceOne-balanceTwo)/2), "5559000000000001"));
        }
        if (balanceOne < balanceTwo) {
            val dashBoardTransferPage = dashBoardPage.makeTransferFirst();
            val newDashboardPage = dashBoardTransferPage.transferCard(DataHelper
                    .getMoneyTransfer(String.valueOf((balanceTwo-balanceOne)/2), "5559000000000002"));
        }
        balanceOne = dashBoardPage.getFirstCardBalance();
        balanceTwo = dashBoardPage.getSecondCardBalance();
        val dashBoardTransferPage = dashBoardPage.makeTransferSecond();
        val newDashboardPage = dashBoardTransferPage.transferCard(DataHelper
                .getMoneyTransfer("600", "5559000000000001"));
        int expectedTwo = balanceTwo + 600;
        int actualTwo = dashBoardPage.getSecondCardBalance();
        assertEquals(expectedTwo, actualTwo);
        int expectedOne = balanceOne - 600;
        int actualOne = dashBoardPage.getFirstCardBalance();
        assertEquals(expectedOne, actualOne);

    }

    @Test
    void moneyTransferMoreThanLimit () {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashBoardPage = verificationPage.validVerify(verificationCode);
        int balanceOne = dashBoardPage.getFirstCardBalance();
        int balanceTwo = dashBoardPage.getSecondCardBalance();
        //уравнивание баланса
        if (balanceOne > balanceTwo) {
            val dashBoardTransferPage = dashBoardPage.makeTransferSecond();
            val newDashboardPage = dashBoardTransferPage.transferCard(DataHelper
                    .getMoneyTransfer(String.valueOf((balanceOne-balanceTwo)/2), "5559000000000001"));
        }
        if (balanceOne < balanceTwo) {
            val dashBoardTransferPage = dashBoardPage.makeTransferFirst();
            val newDashboardPage = dashBoardTransferPage.transferCard(DataHelper
                    .getMoneyTransfer(String.valueOf((balanceTwo-balanceOne)/2), "5559000000000002"));
        }
        balanceOne = dashBoardPage.getFirstCardBalance();
        balanceTwo = dashBoardPage.getSecondCardBalance();
        val dashBoardTransferPage = dashBoardPage.makeTransferFirst();
        val newDashboardPage = dashBoardTransferPage.transferCard(DataHelper
                .getMoneyTransfer(String.valueOf(balanceOne + 500), "5559000000000002"));
        int expectedOne = balanceOne*2;
        int actualOne = dashBoardPage.getFirstCardBalance();
        assertEquals(expectedOne, actualOne);
        int expectedTwo = 0;
        int actualTwo = dashBoardPage.getSecondCardBalance();
        assertEquals(expectedTwo, actualTwo);

    }


}
