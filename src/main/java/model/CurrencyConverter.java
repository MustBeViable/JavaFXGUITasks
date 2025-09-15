package model;

public class CurrencyConverter {
    private final double EUR_DOLLAR = 1.17;
    private final double DOLLAR_EUR = 0.85;
    private final double EUR_POUNDS = 1.16;
    private final double POUNDS_EUR = 0.87;
    private final double POUNDS_DOLLAR = 1.17;
    private final double DOLLAR_POUNDS = 1.36;

    public double getEUR_DOLLAR() {
        return EUR_DOLLAR;
    }

    public double getDOLLAR_EUR() {
        return DOLLAR_EUR;
    }

    public double getEUR_POUNDS() {
        return EUR_POUNDS;
    }

    public double getPOUNDS_EUR() {
        return POUNDS_EUR;
    }

    public double getPOUNDS_DOLLAR() {
        return POUNDS_DOLLAR;
    }

    public double getDOLLAR_POUNDS() {
        return DOLLAR_POUNDS;
    }

    public double dollarToEur(double dollar) {
        return dollar * DOLLAR_EUR;
    }

    public double eurToDollar(double eur) {
        return eur * EUR_DOLLAR;
    }

    public double eurToPounds(double eur) {
        return eur * EUR_POUNDS;
    }

    public double poundsToEur(double pounds) {
        return pounds * POUNDS_EUR;
    }

    public double poundsToDollar(double pounds) {
        return pounds * POUNDS_DOLLAR;
    }

    public double dollarToPounds(double dollar) {
        return dollar * DOLLAR_POUNDS;
    }
}
