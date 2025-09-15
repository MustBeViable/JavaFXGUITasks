package controller;

import model.Currency;
import model.CurrencyConverter;
import view.CurrencyView;

import java.util.ArrayList;
import java.util.HashMap;

public class CurrencyController {
    private static double currentCovertedMoneyValue;
    private CurrencyConverter conv = new CurrencyConverter();
    private CurrencyView view;
    private ArrayList<Currency> currencies;
    public CurrencyController(CurrencyView view) {
        this.view = view;
        currencies = new ArrayList<>();
        currencies.add(new Currency("euro"));
        currencies.add(new Currency("dollar"));
        currencies.add(new Currency("pound"));

    }

    public void convFromEur() {
        for (Currency c : currencies) {
            if (c.getConvertThis()) {
                c.changeConvertValue();
            }
        }
        for (Currency c : currencies) {
            if (c.getCurrency().equalsIgnoreCase("euro")) {
                c.changeConvertValue();
            }
        }
    }

    public void convFromDol() {
        for (Currency c : currencies) {
            if (c.getConvertThis()) {
                c.changeConvertValue();
            }
        }
        for (Currency c : currencies) {
            if (c.getCurrency().equalsIgnoreCase("dollar")) {
                c.changeConvertValue();
            }
        }
    }

    public void convFromPound() {
        for (Currency c : currencies) {
            if (c.getConvertThis()) {
                c.changeConvertValue();
            }
        }
        for (Currency c : currencies) {
            if (c.getCurrency().equalsIgnoreCase("pound")) {
                c.changeConvertValue();
            }
        }
    }

    public void convertToEur(String input) {
        double money = -1;
        try {
            money =  Double.parseDouble(input);
            currentCovertedMoneyValue = money;
            System.out.println("Onnistu " + money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
            view.showConvertedMoney("", "Input a correct double such as 1.05");
        }
        if(money != -1) {
            for (Currency c : currencies) {
                if (c.getConvertThis()) {
                    switch (c.getCurrency()) {
                        case "dollar":
                            view.showConvertedMoney(String.valueOf(conv.getDOLLAR_EUR()), String.valueOf(conv.dollarToEur(money)));
                            break;
                        case "pound":
                            view.showConvertedMoney(String.valueOf(conv.getPOUNDS_EUR()), String.valueOf(conv.dollarToPounds(money)));
                            break;
                        default:
                            view.showConvertedMoney("", "Something went wrong");
                    }
                }
            }
        }
    }

    public void convertToDollar(String input) {
        double money = -1;
        try {
            money =  Double.parseDouble(input);
            currentCovertedMoneyValue = money;
            System.out.println("Onnistu " + money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
            view.showConvertedMoney("", "Input a correct double such as 1.05");
        }
        if(money != -1) {
            for (Currency c : currencies) {
                if (c.getConvertThis()) {
                    switch (c.getCurrency()) {
                        case "pound":
                            view.showConvertedMoney(String.valueOf(conv.getPOUNDS_DOLLAR()), String.valueOf(conv.poundsToDollar(money)));
                            break;
                        case "euro":
                            view.showConvertedMoney(String.valueOf(conv.getEUR_DOLLAR()), String.valueOf(conv.eurToDollar(money)));
                            break;
                        default:
                            view.showConvertedMoney("", "Something went wrong");
                    }
                }
            }
        }
    }

    public void convertToPound(String input) {
        double money = -1;
        try {
            money =  Double.parseDouble(input);
            currentCovertedMoneyValue = money;
            System.out.println("Onnistu " + money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
            view.showConvertedMoney("", "Input a correct double such as 1.05");
        }
        if(money != -1) {
            for (Currency c : currencies) {
                if (c.getConvertThis()) {
                    switch (c.getCurrency()) {
                        case "dollar":
                            view.showConvertedMoney(String.valueOf(conv.getDOLLAR_POUNDS()), String.valueOf(conv.dollarToPounds(money)));
                            break;
                        case "euro":
                            view.showConvertedMoney(String.valueOf(conv.getEUR_POUNDS()), String.valueOf(conv.dollarToEur(money)));
                            break;
                        default:
                            view.showConvertedMoney("", "Something went wrong");
                    }
                }
            }
        }
    }
}
