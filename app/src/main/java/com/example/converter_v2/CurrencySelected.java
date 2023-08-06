package com.example.converter_v2;

import java.io.Serializable;
import java.util.List;

public class CurrencySelected implements Serializable {
    private List<String> name;


    public CurrencySelected( List<String> name) {
        this.name = name;

    }

    public  List<String> getName() {
        return name;
    }



    @Override
    public String toString() {
        return "CurrencySelected{" +
                "name='" + name + '\'' +
                '}';
    }
}
