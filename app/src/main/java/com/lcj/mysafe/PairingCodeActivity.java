package com.lcj.mysafe;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ke on 2016/6/14.
 */
public class PairingCodeActivity extends Activity {
    private EditText editText1, editText2, editText3;
    private Button btn_ok, btn_clear_1, btn_clear_2, btn_clear_3;
    private String oldcode = "123", newcode, checkcode;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pairingcode);
        btn_ok = (Button) findViewById(R.id.button);
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        btn_clear_1 = (Button) findViewById(R.id.button2);
        btn_clear_2 = (Button) findViewById(R.id.button3);
        btn_clear_3 = (Button) findViewById(R.id.button4);
        editText2.setEnabled(false);
        btn_ok.setEnabled(false);
        editText3.setEnabled(false);
        btn_clear_1.setVisibility(View.GONE);
        btn_clear_2.setVisibility(View.GONE);
        btn_clear_3.setVisibility(View.GONE);

        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             btn_clear_3.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkcode = editText3.getText().toString();
                if (checkcode.equals(newcode)) {
                    btn_ok.setEnabled(true);
                    btn_ok.setBackground(getDrawable(R.drawable.ok_button_enable));
                }

            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btn_clear_2.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                newcode = editText2.getText().toString();
            }
        });
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btn_clear_1.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (codejudge()) {
                    editText2.setEnabled(true);
                    editText3.setEnabled(true);

                }

            }
        });

    }


    public boolean codejudge() {
        if (oldcode.equals(editText1.getText().toString())) {
            return true;
        } else {
            return false;
        }

    }

    public void pairingclick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                editText1.setText("");
                break;
            case R.id.button3:
                editText2.setText("");
                break;
            case R.id.button4:
                editText3.setText("");
                break;
            case R.id.back_button:
                //
                break;
            case R.id.ok_button:
                //
                break;


        }
    }


}
