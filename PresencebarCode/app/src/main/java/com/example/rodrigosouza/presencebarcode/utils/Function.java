package com.example.rodrigosouza.presencebarcode.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.rodrigosouza.presencebarcode.R;

public class Function {

    public static void unrecognizedCode(Context context){
        Toast.makeText(context, context.getText(R.string.unrecognized_code), Toast.LENGTH_SHORT).show();
    }
}
