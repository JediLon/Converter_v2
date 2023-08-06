package com.example.converter_v2;

import android.text.Editable;
import android.text.InputType;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.*;
import android.widget.*;


import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private LinearLayout addPanelCurrency;
    private JSONObject responseJSON = new JSONObject();
    private JSONObject rates = new JSONObject();
    private int startingCurrencyLine = 1;
    private List<String> currencyName = new ArrayList<>();
    private List<String>  delCurrencyNameTextsView = new ArrayList<>();
    private List<TextView>  currencySumEditTexts = new ArrayList<>();
    private List<Button> currencyButton = new ArrayList<>();
    private List<LinearLayout>  layoutCurrency = new ArrayList<>();

    private MainToSelected sendData ;
    private ActivityResultLauncher<MainToSelected> activityResultLaunchers ;
    private String mainCurrency ="USD";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Locale locale = Locale.getDefault();
        setContentView(R.layout.activity_main);

        //Menu
        registerForContextMenu(findViewById(R.id.addCurrency));





        try {
            rates.put("AED", 3.672075);
            rates.put("AFN", 87.999996);
            rates.put("ALL", 101.6);
            rates.put("AMD", 386.38);
            rates.put("ANG", 1.803731);
            rates.put("AOA", 510);
            rates.put("ARS", 227.770132);
            rates.put("AUD", 1.5058);
            rates.put("AWG", 1.8);
            rates.put("AZN", 1.7);
            rates.put("BAM", 1.794847);
            rates.put("BBD", 2);
            rates.put("BDT", 107.472424);
            rates.put("BGN", 1.802385);
            rates.put("BHD", 0.376952);
            rates.put("BIF", 2082.284762);
            rates.put("BMD", 1);
            rates.put("BND", 1.328456);
            rates.put("BOB", 6.916109);
            rates.put("BRL", 4.9209);
            rates.put("BSD", 1);
            rates.put("BTC", 0.000037353581);
            rates.put("BTN", 82.258186);
            rates.put("BWP", 13.44217);
            rates.put("BYN", 2.526166);
            rates.put("BZD", 2.017382);
            rates.put("CAD", 1.36365);
            rates.put("CDF", 2045);
            rates.put("CHF", 0.8987);
            rates.put("CLF", 0.028476);
            rates.put("CLP", 785.75);
            rates.put("CNH", 6.95567);
            rates.put("CNY", 6.9582);
            rates.put("COP", 4586.558354);
            rates.put("CRC", 535.595179);
            rates.put("CUC", 1);
            rates.put("CUP", 25.75);
            rates.put("CVE", 101.47);
            rates.put("CZK", 21.7513);
            rates.put("DJF", 177.827972);
            rates.put("DKK", 6.8629);
            rates.put("DOP", 54.45);
            rates.put("DZD", 135.914403);
            rates.put("EGP", 30.765786);
            rates.put("ERN", 15);
            rates.put("ETB", 54.21);
            rates.put("EUR", 0.914955);
            rates.put("FJD", 2.2218);
            rates.put("FKP", 0.803342);
            rates.put("GBP", 0.803342);
            rates.put("GEL", 2.575);
            rates.put("GGP", 0.803342);
            rates.put("GHS", 11.75);
            rates.put("GIP", 0.803342);
            rates.put("GMD", 59.85);
            rates.put("GNF", 8650);
            rates.put("GTQ", 7.80632);
            rates.put("GYD", 211.677418);
            rates.put("HKD", 7.84745);
            rates.put("HNL", 24.68);
            rates.put("HRK", 6.94434);
            rates.put("HTG", 145.627379);
            rates.put("HUF", 341.49);
            rates.put("IDR", 14844.45);
            rates.put("ILS", 3.67375);
            rates.put("IMP", 0.803342);
            rates.put("INR", 82.2563);
            rates.put("IQD", 1310);
            rates.put("IRR", 42250);
            rates.put("ISK", 138.73);
            rates.put("JEP", 0.803342);
            rates.put("JMD", 154.511049);
            rates.put("JOD", 0.7094);
            rates.put("JPY", 135.745);
            rates.put("KES", 137);
            rates.put("KGS", 87.3);
            rates.put("KHR", 4115);
            rates.put("KMF", 451.149989);
            rates.put("KPW", 900);
            rates.put("KRW", 1342.5613);
            rates.put("KWD", 0.30695);
            rates.put("KYD", 0.834136);
            rates.put("KZT", 444.632497);
            rates.put("LAK", 17565.5);
            rates.put("LBP", 15115);
            rates.put("LKR", 313.763284);
            rates.put("LRD", 166.74998);
            rates.put("LSL", 19.17);
            rates.put("LYD", 4.76);
            rates.put("MAD", 10.0975);
            rates.put("MDL", 17.762084);
            rates.put("MGA", 4400);
            rates.put("MKD", 56.402306);
            rates.put("MMK", 2101.821654);
            rates.put("MNT", 3519);
            rates.put("MOP", 8.084321);
            rates.put("MRU", 34.46);
            rates.put("MUR", 45.339999);
            rates.put("MVR", 15.36);
            rates.put("MWK", 1028);
            rates.put("MXN", 17.5985);
            rates.put("MYR", 4.4625);
            rates.put("MZN", 63.850001);
            rates.put("NAD", 19.34);
            rates.put("NGN", 462.5);
            rates.put("NIO", 36.525);
            rates.put("NOK", 10.688673);
            rates.put("NPR", 131.608069);
            rates.put("NZD", 1.611344);
            rates.put("OMR", 0.384968);
            rates.put("PAB", 1);
            rates.put("PEN", 3.65);
            rates.put("PGK", 3.525);
            rates.put("PHP", 55.899997);
            rates.put("PKR", 295.65);
            rates.put("PLN", 4.165372);
            rates.put("PYG", 7195.780992);
            rates.put("QAR", 3.641);
            rates.put("RON", 4.5437);
            rates.put("RSD", 108.09);
            rates.put("RUB", 77.33952);
            rates.put("RWF", 1119.5);
            rates.put("SAR", 3.750138);
            rates.put("SBD", 8.334311);
            rates.put("SCR", 13.93707);
            rates.put("SDG", 600);
            rates.put("SEK", 10.4286);
            rates.put("SGD", 1.338791);
            rates.put("SHP", 0.803342);
            rates.put("SLL", 17665);
            rates.put("SOS", 569);
            rates.put("SRD", 37.1115);
            rates.put("SSP", 130.26);
            rates.put("STD", 22823.990504);
            rates.put("STN", 22.7);
            rates.put("SVC", 8.75674);
            rates.put("SYP", 2512.53);
            rates.put("SZL", 19.17);
            rates.put("THB", 33.83);
            rates.put("TJS", 10.943814);
            rates.put("TMT", 3.51);
            rates.put("TND", 3.045);
            rates.put("TOP", 2.348432);
            rates.put("TRY", 19.5885);
            rates.put("TTD", 6.793132);
            rates.put("TWD", 30.8057);
            rates.put("TZS", 2357);
            rates.put("UAH", 36.96273);
            rates.put("UGX", 3725.124431);
            rates.put("USD", 1);
            rates.put("UYU", 38.992809);
            rates.put("UZS", 11465);
            rates.put("VES", 25.147676);
            rates.put("VND", 23460.413462);
            rates.put("VUV", 118.979);
            rates.put("WST", 2.72551);
            rates.put("XAF", 600.171108);
            rates.put("XAG", 0.04171012);
            rates.put("XAU", 0.00049725);
            rates.put("XCD", 2.70255);
            rates.put("XDR", 0.741811);
            rates.put("XOF", 600.171108);
            rates.put("XPD", 0.00066464);
            rates.put("XPF", 109.183169);
            rates.put("XPT", 0.00094841);
            rates.put("YER", 250.350066);
            rates.put("ZAR", 19.3148);
            rates.put("ZMW", 18.340171);
            rates.put("ZWL", 322);
            responseJSON.put("disclaimer", "Usage subject to terms: https://openexchangerates.org/terms");
            responseJSON.put("license", "https://openexchangerates.org/license");
            responseJSON.put("timestamp", 1683928803);
            responseJSON.put("base", "USD");
            responseJSON.put("rates", rates);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        addPanelCurrency = findViewById(R.id.currencyPanel);
        // Check the main screen. If the currencies are less than the starting ones, then add up to the required amount
        while (addPanelCurrency.getChildCount() < startingCurrencyLine) {
            createLineCurrency(mainCurrency);
        }

        activityResultLaunchers =  registerForActivityResult(new CurrencyContract(),
                new ActivityResultCallback<CurrencySelected>() {
                    @Override
                    public void onActivityResult(CurrencySelected result) {

                        if (result!= null) {

                            List<String> SelectCurrencyName = result.getName();
                            delCurrencyNameTextsView = new ArrayList<>(currencyName);
                            delCurrencyNameTextsView.removeAll(SelectCurrencyName);
                            SelectCurrencyName.removeAll(currencyName);
                            // Removing a deselected selection currency
                            for (int i = 0; i < delCurrencyNameTextsView.size() ; i++) {
                                for (int j = 0; j < currencyName.size(); j++) {
                                    if(delCurrencyNameTextsView.get(i).equals(mainCurrency))continue;
                                    if(delCurrencyNameTextsView.get(i).equals(currencyName.get(j))){
                                        addPanelCurrency.removeView(layoutCurrency.get(j));
                                        currencyName.remove(j);
                                        currencySumEditTexts.remove(j);
                                        layoutCurrency.remove(j);

                                    }
                                }
                            }

                            // Create selected currency
                            for (int i = 0; i < SelectCurrencyName.size(); i++) {
                                createLineCurrency(SelectCurrencyName.get(i));
                            }

                        }
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mainCurrency:
                Toast.makeText(this, "Click 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem2:
                Toast.makeText(this, "Click 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem4:
                Toast.makeText(this, "Click 3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mainCurrency:

                Toast.makeText(this, "Click 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem2:
                Toast.makeText(this, "Click 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem4:
                Toast.makeText(this, "Click 3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addLineCurrency(View view) {
        sendData = new MainToSelected(rates.toString(), currencyName);
        activityResultLaunchers.launch(sendData);
        sendData = null;

    }

    public void createLineCurrency(  String nameCurrency) {
        // Create new Currency


        // Create elements Currency line
        TextView nextCurrency = new TextView(addPanelCurrency.getContext());
        LinearLayout l1 = new LinearLayout(nextCurrency.getContext());
        l1.setOrientation(LinearLayout.HORIZONTAL);
        /**
         * LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
         *     LayoutParams.MATCH_PARENT,
         *     LayoutParams.MATCH_PARENT,
         *     1.0f
         * );
         * YOUR_VIEW.setLayoutParams(param);
         * https://squoosh.app/
         *
         * etmsg.setText("Updated Text From another Activity");
         * int position = etmsg.length();
         * Editable etext = etmsg.getText();
         * Selection.setSelection(etext, position);
         */
        Button nextCurrencyButton = new Button(l1.getContext());

        nextCurrencyButton.setText(nameCurrency);

        EditText nextCurrencySum = new EditText(l1.getContext());

        // ????


        nextCurrencySum.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);


        nextCurrencySum.setGravity(Gravity.END);


        // Calculate rates relative to USD
        Double rateToUSD;
        try {
            rateToUSD = (Double.parseDouble(rates.get(nextCurrencyButton.getText().toString()).toString()));
            if(currencySumEditTexts.size() > 0 ){
                rateToUSD = (Double.parseDouble(rates.get(nextCurrencyButton.getText().toString()).toString()))*
                        Double.parseDouble(currencySumEditTexts.get(0).getText().toString());
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        nextCurrencySum.setText(String.format("%.2f",rateToUSD));
        nextCurrencySum.setSelection(nextCurrencySum.getText().length());
        nextCurrencySum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextCurrencySum.setSelection(nextCurrencySum.getText().length());
            }
        });
        nextCurrencySum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                double sumInput;
                if(charSequence.length() == 0){
                    sumInput = 0d;
                    nextCurrencySum.setText("0");
                    nextCurrencySum.setSelection(nextCurrencySum.getText().length());
                }else {
                    sumInput = Double.parseDouble(charSequence.toString());
                }
                if(nextCurrencySum.hasFocus()) {
                    for (int j = 0; j < currencySumEditTexts.size(); j++) {
                        if (nextCurrencyButton.getText().toString().equals(currencyName.get(j)) ) continue;
                        try {
                            Double sum = (Double.parseDouble(rates.get(currencyName.get(j).toString()).toString()) /(Double.parseDouble(rates.get(nextCurrencyButton.getText().toString()).toString()))) * sumInput;

                            currencySumEditTexts.get(j).setText(String.format("%.2f", sum) );
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {



            }
        });

        l1.addView(nextCurrencyButton);

        l1.addView(nextCurrencySum);
        addPanelCurrency.addView(l1);




        nextCurrencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
        // RegisterActivityResult for currency line
        currencyButton.add(nextCurrencyButton);
        currencyName.add(nextCurrencyButton.getText().toString());
        currencySumEditTexts.add(nextCurrencySum);
        layoutCurrency.add(l1);
    }
}