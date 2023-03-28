package atm;

import java.io.StringBufferInputStream;
import java.util.Scanner;

public class ATMApp {
    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        Scanner numbers = new Scanner(System.in);
        System.out.print("Enter bank name :" );
        String bankName= text.nextLine();
        System.out.print("Enter fee :" );
        double bankFee = numbers.nextDouble();
        System.out.print("Enter ATM available amount of money in RON :" );
        double amountOfMoneyInRon = numbers.nextDouble();
        ATM bankAtm = new ATM(bankName, bankFee, MoneyConverterUtils.convertToBani(amountOfMoneyInRon));

        System.out.println("Enter card number : ");
        String cardNr = text.nextLine();
        System.out.println("Enter CVV: ");
        String cvv = text.nextLine();
        System.out.println("Enter Bank name: ");
        String cardBankName = text.nextLine();
        System.out.println("Set card PIN :");
        String cardPin = text.nextLine();
        Account currentAccount = new Account("RON");
        Card currentCard= new Card(cardNr, cvv, cardBankName, cardPin,currentAccount);
        bankAtm.insertCard(currentCard);


    }

}
