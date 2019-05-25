package com.example.alaa.Tools.TextWatcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MultiTextWatcher {

    private TextWatcherWithInstance instance;


    public MultiTextWatcher setCallBack(TextWatcherWithInstance callBack) {
        this.instance = callBack;
        return this;
    }



    public MultiTextWatcher registerEditText(final EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                instance.afterTextChanged(editText , editable );
            }
        });

        return this;
    }
}
