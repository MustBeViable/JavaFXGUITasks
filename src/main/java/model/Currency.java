package model;

public class Currency {
    private boolean convertThis;
    private String currency;

    public Currency(String currency) {
        this.currency = currency;
        this.convertThis = false;
    }

    public boolean getConvertThis() {
        return this.convertThis;
    }

    public void changeConvertValue() {
        this.convertThis = !this.convertThis;
    }

    public String getCurrency() {
        return this.currency;
    }
}
