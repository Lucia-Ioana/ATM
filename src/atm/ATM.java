package atm;

import org.w3c.dom.ls.LSOutput;

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
                case 3 -> cashDeposit();
                case 4 -> showCurrentBalance();
                case 5 -> payBill();
                case 6 -> exitCard();
                default -> System.out.println("Invalid option. Please enter a valid option");
            }
        }

        while (chosenOption != 6 );
    }

    public void showMenu() {
        System.out.println();
        System.out.println("-----MENU----");
        System.out.println("1.Changing PIN");
        System.out.println("2.Cash Withdrawal");
        System.out.println("3.Feed Account");
        System.out.println("4.Balance");
        System.out.println("5.Pay Bill");
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
        System.out.print("Choose an option: ");
        int selectedOption = numbersScanner.nextInt();
        double selectedAmount = moneyOperations(selectedOption);
        if (selectedAmount == 0) {
            return;
        }
        double selectedAmountWithFee = selectedAmount;
        if (!bankName.equalsIgnoreCase(currentCard.getBankName())) {
            selectedAmountWithFee = selectedAmount + selectedAmount * (fee / 100);
        }
        if (availableAmountofMoney < MoneyConverterUtils.convertToBani(selectedAmount)) {
            System.out.println("ATM doesn't have enough funds");
        } else if (currentCard.getCurrentAccount().getAvailableAmount() >= MoneyConverterUtils.convertToBani(selectedAmountWithFee)) {
            long calculatedAmount = currentCard.getCurrentAccount().getAvailableAmount() - MoneyConverterUtils.convertToBani(selectedAmountWithFee);
            currentCard.getCurrentAccount().setAvailableAmount(calculatedAmount);
            System.out.println("You have " + MoneyConverterUtils.convertToRon(calculatedAmount) + " RON");
        } else {
            System.out.println("You have insufficient funds");
        }
    }

    public void cashDeposit() {
        showMoneyOptions();
        System.out.print("Choose an option: ");
        int selectedOption = numbersScanner.nextInt();
        int selectedAmount = moneyOperations(selectedOption);
        if (selectedOption == 0) {
            return;
        }
        long newAvailableAmount = currentCard.getCurrentAccount().getAvailableAmount() + MoneyConverterUtils.convertToBani(selectedAmount);
        currentCard.getCurrentAccount().setAvailableAmount(newAvailableAmount);
        System.out.println("Your current balance is " + MoneyConverterUtils.convertToRon(newAvailableAmount) + " RON");
    }

    public void showCurrentBalance() {
        double currentBalance = MoneyConverterUtils.convertToRon(currentCard.getCurrentAccount().getAvailableAmount());
        System.out.println("You have " + currentBalance + " RON");
    }

    public void  payBill(){
        System.out.print("Enter bill number: ");
        String billNr = textScanner.nextLine();
        System.out.print("Enter receiver name: ");
        String receiverName = textScanner.nextLine();
        System.out.print("Enter the amount requested: ");
        double amountRequested = numbersScanner.nextDouble();
        Bill currentBill = new Bill(billNr, receiverName, MoneyConverterUtils.convertToBani(amountRequested));
        if(currentCard.getCurrentAccount().getAvailableAmount() >= currentBill.getRequestedAmount()){
           long newBalance = currentCard.getCurrentAccount().getAvailableAmount() - currentBill.getRequestedAmount();
           currentCard.getCurrentAccount().setAvailableAmount(newBalance);
            System.out.println("You successfully paid  the " + currentBill + " !");
            System.out.println("New balance is: " + MoneyConverterUtils.convertToRon(newBalance) + " RON");
        } else {
            System.out.println("Insufficient funds to pay the bill. Please withdraw first!");
        }
    }
    public void exitCard() {
        System.out.println("thank you for choosing us!.  Bye bye");
        currentCard = null;
    }

    public int moneyOperations(int option) {
        int selectedAmount = 0;
        switch (option) {
            case 1 -> selectedAmount = 10;
            case 2 -> selectedAmount = 50;
            case 3 -> selectedAmount = 100;
            case 4 -> selectedAmount = 200;
            case 5 -> selectedAmount = 500;
            case 6 -> {
                System.out.print("Please enter the amount you want to withdraw: ");
                selectedAmount = numbersScanner.nextInt();
            }
            case 7 -> selectedAmount = 0;
            default -> System.out.println("Invalid option! ");
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
