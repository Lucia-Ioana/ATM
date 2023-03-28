package atm;

public class Account {
   private String currency;
   private long availableAmount;

    public Account(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Account(String currency, long availableAmount) {
        this.currency = currency;
        this.availableAmount = availableAmount;
    }
}
