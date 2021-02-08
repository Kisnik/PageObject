package helper;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    //объект для перевода на первую карту
    @Value
    public static class MoneyTransferFirstCard {
        private String amountForFirst;
        private String cardNumberSecond;

    }

    public static MoneyTransferFirstCard getMoneyTransferFirst() {
        return new MoneyTransferFirstCard("500", "5559000000000002");
    }

    //объект для перевода на вторую карту
    @Value
    public static class MoneyTransferSecondCard {
        private String amountForSecond;
        private String cardNumberFirst;

    }

    public static MoneyTransferSecondCard getMoneyTransferSecond() {
        return new MoneyTransferSecondCard("500", "5559000000000001");
    }

}
