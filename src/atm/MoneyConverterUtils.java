package atm;

public class MoneyConverterUtils {
    static public long convertToBani(double amountRon){
        return (long)(amountRon * 100);
    }

    static public double convertToRon(long amountBani){
        return amountBani/100.0;
    }
}
