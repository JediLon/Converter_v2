package com.example.converter_v2;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class selectedList extends AppCompatActivity {
    private MainToSelected messageMain;
    private EditText searchListener;

    private JSONObject rates;
    private List<String> selectedCurrencyName = new ArrayList<>();
    private List<String> mainSelectedCurrency = new ArrayList<>();
    private List<CheckBox> allCheckBoxCurrency = new ArrayList<>();
    private LinearLayout panelCurrencyList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_list);
        panelCurrencyList = findViewById(R.id.listCurrency);
        searchListener = findViewById(R.id.searchEditText);
        // We receive and process data for MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             messageMain =  (MainToSelected) extras.getSerializable("Currency" );
            try {
                rates = new JSONObject( messageMain.getRates());
                mainSelectedCurrency = messageMain.getSelectedCurrency();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            // Create already selected currency with checkBox(true)
            for (int i = 0; i < mainSelectedCurrency.size(); i++) {
                CheckBox nextCurrencyCheckBox = new CheckBox(panelCurrencyList.getContext());
                nextCurrencyCheckBox.setText(mainSelectedCurrency.get(i));
                nextCurrencyCheckBox.setChecked(true);
                allCheckBoxCurrency.add(nextCurrencyCheckBox);
                nextCurrencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        System.out.println(rates);
                        String currencyName = compoundButton.getText().toString();

                            if(b){
                                selectedCurrencyName.add(currencyName);
                            }else{
                                selectedCurrencyName.remove(currencyName);
                            }


                    }
                });

                panelCurrencyList.addView(nextCurrencyCheckBox);

                selectedCurrencyName.add(mainSelectedCurrency.get(i));

                rates.remove(mainSelectedCurrency.get(i));


            }

            //Create unselected checkBox(false)
            rates.keys().forEachRemaining(e->{
                CheckBox nextCurrencyCheckBox = new CheckBox(panelCurrencyList.getContext());
                nextCurrencyCheckBox.setText(e);
                panelCurrencyList.addView(nextCurrencyCheckBox);
                allCheckBoxCurrency.add(nextCurrencyCheckBox);
               nextCurrencyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                       String currencyName = compoundButton.getText().toString();
                       if(b){
                           selectedCurrencyName.add(currencyName);
                       }else{
                           selectedCurrencyName.remove(currencyName);
                       }
                   }
               });

            });
            // Create searchListener
            searchListener.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {


                    for (int i = 0; i < allCheckBoxCurrency.size(); i++) {

                        if(!allCheckBoxCurrency.get(i).getText().toString().contains(editable.toString().toUpperCase())){
                            allCheckBoxCurrency.get(i).setVisibility(View.INVISIBLE);
                            allCheckBoxCurrency.get(i).setVisibility(View.GONE);

                        }else {
                            allCheckBoxCurrency.get(i).setVisibility(View.VISIBLE);
                        }
                    }
                    if (editable.toString().equals("")){
                        for (int i = 0; i < allCheckBoxCurrency.size(); i++) {
                            allCheckBoxCurrency.get(i).setVisibility(View.VISIBLE);
                        }
                    }
                }
            });

        }
    }
    private void sendMessage(CurrencySelected message){
       
        Intent data = new Intent();
        data.putExtra("returnToMain", message);
        setResult(RESULT_OK, data);
        finish();
    }

    public void buttonOkOnClick(View view) {
        sendMessage(new CurrencySelected(selectedCurrencyName));

    }


}