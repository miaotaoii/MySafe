package com.lcj.mysafe;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ke on 2016/6/15.
 */
public class ChangePasswordActivity extends Activity {
    private Button back_btn;
    private EditText editText1, editText2, editText3;
    private Button btn_ok, btn_clear_1, btn_clear_2, btn_clear_3;
    public String oldpw = "123";
    private String newpw;
    private String checkpw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        btn_ok = (Button) findViewById(R.id.button);
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        btn_clear_1 = (Button) findViewById(R.id.button5);
        btn_clear_2 = (Button) findViewById(R.id.button6);
        btn_clear_3 = (Button) findViewById(R.id.button7);
        btn_clear_1.setVisibility(View.GONE);
        btn_clear_2.setVisibility(View.GONE);
        btn_clear_3.setVisibility(View.GONE);
        editText2.setEnabled(false);
        btn_ok.setEnabled(false);
        editText3.setEnabled(false);
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
                checkpw = editText3.getText().toString();
                if (checkpw.equals(newpw)) {
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
                newpw = editText2.getText().toString();
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
        if (oldpw.equals(editText1.getText().toString())) {
            return true;
        } else {
            return false;
        }

    }

    public void myclick(View v) {
        switch (v.getId()) {
            case R.id.button5:
                editText1.setText("");
                break;
            case R.id.button6:
                editText2.setText("");
                break;
            case R.id.button7:
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
