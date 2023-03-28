package atm;

import java.util.Scanner;

public class ATM {
    private String bankName;
    private double fee;
    private long availableAmountofMoney;
    private Card currentCard;
    Scanner text = new Scanner(System.in);
    Scanner numbers = new Scanner(System.in);
    int nrOfTries = 3;


    public ATM(String bankName, double fee, long availableAmountofMoney) {
        this.bankName = bankName;
        this.fee = fee;
        this.availableAmountofMoney = availableAmountofMoney;
    }



    public void insertCard(Card insertedCard){
        System.out.println("Enter Pin : ");
        String pin;
        do{
            pin = text.nextLine();
            nrOfTries--;
            if(!pin.equals(insertedCard.getCardPin()) && nrOfTries==0){
                System.out.println("Your card has been blocked");
                return;
            }
        }
        while(!pin.equals(insertedCard.getCardPin()) && nrOfTries > 0 );
        currentCard = insertedCard;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public long getAvailableAmountofMoney() {
        return availableAmountofMoney;
    }

    public void setAvailableAmountofMoney(long availableAmountofMoney) {
        this.availableAmountofMoney = availableAmountofMoney;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }


    @Override
    public String toString() {
        return "ATM{" +
                "bankName='" + bankName + '\'' +
                ", fee=" + fee +
                ", availableAmountofMoney=" + availableAmountofMoney +
                ", currentCard=" + currentCard +
                '}';
    }
}
