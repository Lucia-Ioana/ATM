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
        System.out.println("Welcome to " + bankName);
        String pin;
        do{
            System.out.print("Enter Pin : ");
            pin = text.nextLine();
            nrOfTries--;
            if(!pin.equals(insertedCard.getCardPin()) && nrOfTries==0){
                System.out.print("Your card has been blocked");
                return;
            } else if(!pin.equals(insertedCard.getCardPin())){
                System.out.print("Wrong Pin, try again : ");
                System.out.println("You have " + nrOfTries + " left.Try again:");
            }
        }
        while(!pin.equals(insertedCard.getCardPin()) && nrOfTries > 0 );
        currentCard = insertedCard;
    }

    public void startProcessing() {
        int chosenOption;
        do{
            showMenu();
            System.out.print("Enter the option you want to select: ");
            chosenOption = numbers.nextInt();
            switch (chosenOption) {
                case 1 -> System.out.println("");
                case 2 -> System.out.println();
                case 3 -> System.out.println();
                case 4 -> System.out.println();
                case 5 -> System.out.println();
                case 6 -> System.out.println();
                default -> System.out.println("Invalid option. Please enter a valid option");
            }
        }
        while (chosenOption != 6);
    }

    public void showMenu(){
        System.out.println();
        System.out.println("-----MENU----");
        System.out.println("1.Changing PIN");
        System.out.println("2.Cash Withdrawal");
        System.out.println("3.Feed Account");
        System.out.println("4.Check your balance");
        System.out.println("5.Bill payment");
        System.out.println("6.Exit");
        System.out.println();
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
