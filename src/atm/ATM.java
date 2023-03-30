package atm;

import java.util.Scanner;

public class ATM {
    private String bankName;
    private double fee;
    private long availableAmountofMoney;
    private Card currentCard;
    int nrOfTries = 3;

    Scanner textScanner = new Scanner(System.in);
    Scanner numbersScanner = new Scanner(System.in);


    public ATM(String bankName, double fee, long availableAmountofMoney) {
        this.bankName = bankName;
        this.fee = fee;
        this.availableAmountofMoney = availableAmountofMoney;
    }

    public void insertCard(Card insertedCard) {
        System.out.println("Welcome to " + bankName + " !");
        String pin;
        do {
            System.out.print("Enter Pin : ");
            pin = textScanner.nextLine();
            nrOfTries--;
            if (!pin.equals(insertedCard.getCardPin()) && nrOfTries == 0) {
                System.out.print("Your card has been blocked");
                return;
            } else if (!pin.equals(insertedCard.getCardPin())) {
                System.out.print("Wrong Pin, try again : ");
                System.out.println("You have " + nrOfTries + " left.Try again:");
            }
        } while (!pin.equals(insertedCard.getCardPin()) && nrOfTries > 0);
        currentCard = insertedCard;
    }

    public void startProcessing() {
        int chosenOption;
        do {
            showMenu();
            System.out.print("Enter the option you want to select: ");
            chosenOption = numbersScanner.nextInt();
            switch (chosenOption) {
                case 1 -> changePin();
                case 2 -> cashWithdraw();
                case 3 -> System.out.println();
                case 4 -> System.out.println();
                case 5 -> System.out.println();
                case 6 -> System.out.println();
                default -> System.out.println("Invalid option. Please enter a valid option");
            }
        }
        while (chosenOption != 6);
    }

    public void showMenu() {
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

    public void changePin() {
        String oldPin;
        do {
            System.out.print("Enter the old PIN:");
            oldPin = textScanner.nextLine();
            if (!oldPin.equals(currentCard.getCardPin())) {
                System.out.println("You entered a wrong PIN,please try again: ");
            }
        } while (!oldPin.equals(currentCard.getCardPin()));
        String newPin = textScanner.nextLine();
        do {
            System.out.print("Enter the new PIN:");
            newPin = textScanner.nextLine();
            if (newPin.length() < 4 || newPin.length() >= 6) {
                System.out.println("Your PIN must be between 4 and 6 digits:");
            }
        } while (newPin.length() < 4 || newPin.length() >= 6);
        currentCard.setCardPin(newPin);
        System.out.println("PIN updated!");
    }

    public void cashWithdraw() {
        showMoneyOptions();
        System.out.println("Choose an option");
        int selectedOption = numbersScanner.nextInt();
        double selectedAmount = moneyOperations(selectedOption);
        if (currentCard.getCurrentAccount().getAvailableAmount() -MoneyConverterUtils.convertToBani(selectedAmount) >= 0){
            long calculatedAmount = currentCard.getCurrentAccount().getAvailableAmount() - MoneyConverterUtils.convertToBani(selectedAmount);
            currentCard.getCurrentAccount().setAvailableAmount(calculatedAmount);
            System.out.println("You have " + MoneyConverterUtils.convertToRon(calculatedAmount) + " RON");
        } else {
            System.out.println("You have insufficient founds");
        }
    }

    public int moneyOperations(int option) {
        int selectedAmount = 0;
        switch (option) {
            case 1:
                selectedAmount = 10;
                break;
            case 2:
                selectedAmount = 50;
                break;
            case 3:
                selectedAmount = 100;
                break;
            case 4:
                selectedAmount = 200;
                break;
            case 5:
                selectedAmount = 500;
                break;
            case 6:
                System.out.print("Please enter the amount you want to withdraw: ");
                selectedAmount = numbersScanner.nextInt();
                break;
            case 7:
                break;
            default:
                System.out.println("Invalid option! ");

        }
        return selectedAmount;
    }

    public void showMoneyOptions() {
        System.out.println("--------------");
        System.out.println("1. 10 RON");
        System.out.println("2. 50 RON");
        System.out.println("3. 100 RON");
        System.out.println("4. 200 RON");
        System.out.println("5. 500 RON");
        System.out.println("6. Other amount");
        System.out.println("7. EXIT");
        System.out.println("--------------");
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
