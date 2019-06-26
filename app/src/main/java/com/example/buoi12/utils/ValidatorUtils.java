package com.example.buoi12.utils;

import android.widget.EditText;

public class ValidatorUtils {
    public static boolean isEmpty(EditText... editTexts){
        boolean isEmpty = false;
        for (EditText e : editTexts){
            if (e.getText().toString().isEmpty()){
                isEmpty = true;
                e.setError("Input empty");
            }
        }
        return isEmpty;
    }
}
