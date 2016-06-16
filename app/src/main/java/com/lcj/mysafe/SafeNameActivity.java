package com.lcj.mysafe;

import android.app.Activity;
import android.os.Bundle;
import android.preference.TwoStatePreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ke on 2016/6/15.
 */
public class SafeNameActivity extends Activity {
    private Button btn_back, btn_ok, btn_clear;
    private TextView textView;
    private EditText editText;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_safe_name);
        btn_back = (Button) findViewById(R.id.back_button);
        btn_ok = (Button) findViewById(R.id.ok_button);
        btn_clear = (Button) findViewById(R.id.button8);
        btn_clear.setVisibility(View.GONE);
        textView = (TextView) findViewById(R.id.text);
        editText = (EditText) findViewById(R.id.editText);
        btn_ok.setEnabled(false);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(editText.getText());
                btn_clear.setVisibility(View.VISIBLE);
                btn_ok.setEnabled(true);
                btn_ok.setBackground(getDrawable(R.drawable.ok_button_enable));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                //
                break;
            case R.id.button8:
                editText.setText("");
                break;
            case R.id.ok_button:
                textView.setText(editText.getText());
                name = editText.getText().toString();
                break;
        }

    }
}
