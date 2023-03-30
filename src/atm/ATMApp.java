package atm;


import java.util.Scanner;

public class ATMApp {
    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        Scanner numbers = new Scanner(System.in);
        System.out.print("Enter bank name : ");
        String bankName = text.nextLine();
        System.out.print("Enter bank fee : ");
        double bankFee = numbers.nextDouble();
        System.out.print("Enter ATM available amount of money in RON : ");
        double amountOfMoneyInRon = numbers.nextDouble();
        ATM bankAtm = new ATM(bankName, bankFee, MoneyConverterUtils.convertToBani(amountOfMoneyInRon));

        System.out.print("Enter card number : ");
        String cardNr = text.nextLine();
        System.out.print("Enter CVV: ");
        String cvv = text.nextLine();
        System.out.print("Enter Bank name of the card: ");
        String cardBankName = text.nextLine();
        System.out.print("Set card PIN : ");
        String cardPin = text.nextLine();
        Account currentAccount = new Account("RON");
        System.out.print("Initial amount of money (multiple of 10 RON) : ");
        int initialAmount = numbers.nextInt();
        currentAccount.setAvailableAmount(MoneyConverterUtils.convertToBani(initialAmount));
        Card currentCard = new Card(cardNr, cvv, cardBankName, cardPin, currentAccount);
        bankAtm.insertCard(currentCard);
        if (bankAtm.getCurrentCard() != null) {
            bankAtm.startProcessing();

        }


    }

}
