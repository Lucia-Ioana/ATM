package atm;

public class Bill {
   private String billNr;
   private String receiverName;
   private long requestedAmount;

    public Bill(String billNr, String receiverName, long requestedAmount) {
        this.billNr = billNr;
        this.receiverName = receiverName;
        this.requestedAmount = requestedAmount;
    }

    public String getBillNr() {
        return billNr;
    }

    public void setBillNr(String billNr) {
        this.billNr = billNr;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public long getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(long requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billNr='" + billNr + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", requestedAmount=" +MoneyConverterUtils.convertToRon(requestedAmount) +
                " RON " +
                '}';
    }
}
