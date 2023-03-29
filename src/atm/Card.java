package atm;

public class Card {
    private String cardNr;
    private String cvv;
    private String bankName;
    private String cardPin;
    private Account currentAccount;

    public Card(String cardNr, String cvv, String bankName, String cardPin, Account currentAccount) {
        this.cardNr = cardNr;
        this.cvv = cvv;
        this.bankName = bankName;
        this.cardPin = cardPin;
        this.currentAccount = currentAccount;
    }

    public String getCardNr() {
        return cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardPin() {
        return cardPin;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNr='" + cardNr + '\'' +
                ", cvv='" + cvv + '\'' +
                ", bankName='" + bankName + '\'' +
                ", cardPin='" + cardPin + '\'' +
                ", currentAccount=" + currentAccount +
                '}';
    }
}
