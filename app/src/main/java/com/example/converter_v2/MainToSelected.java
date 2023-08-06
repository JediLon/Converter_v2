package com.example.converter_v2;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class MainToSelected implements Serializable {
    private String rates;
    private List<String> selectedCurrency;


    public MainToSelected(String rates, List<String> selectedCurrency) {
        this.rates = rates;
        this.selectedCurrency = selectedCurrency;
    }

    public String getRates() {
        return rates;
    }

    public List<String> getSelectedCurrency() {
        return selectedCurrency;
    }

    @Override
    public String toString() {
        return "MainToSelected{" +
                "rates=" + rates +
                ", lineCurrency=" + selectedCurrency +
                '}';
    }
}
