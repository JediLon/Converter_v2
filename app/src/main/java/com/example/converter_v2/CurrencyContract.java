package com.example.converter_v2;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Map;

public class CurrencyContract extends ActivityResultContract<MainToSelected, CurrencySelected> {



    @Override
    public CurrencySelected parseResult(int i, @Nullable Intent intent) {

        assert intent != null;


        return (CurrencySelected) intent.getSerializableExtra("returnToMain");
    }


    @NotNull
    @Override
    public Intent createIntent(@NotNull Context context, MainToSelected mainToSelected) {
        Intent intent  = new Intent(context, selectedList.class);
        intent.putExtra("Currency",mainToSelected);
        return intent;
    }
}
