package com.example.emine.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MyFristApp extends AppCompatActivity {

        TextView tvInfo;
        EditText etInput;
        Button bControl;
        int rand;
        boolean finish = false;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            tvInfo = (TextView)findViewById(R.id.textView);
            etInput = (EditText)findViewById(R.id.editText);
            bControl = (Button)findViewById(R.id.button);
            rand =  (int)(Math.random()*100);

        }
        public void onClick(View v) {
            if (etInput.getText().length() != 0) {
                if (!finish) {
                    int input = Integer.parseInt(etInput.getText().toString());
                    if (input > 0 && input <= 100) {
                        if (input > rand) {
                            tvInfo.setText(getResources().getString(R.string.ahead));
                        }
                        if (input < rand) {
                            tvInfo.setText(getResources().getString(R.string.behind));
                        }
                        if (input == rand) {
                            tvInfo.setText(getResources().getString(R.string.hit));
                            bControl.setText(getResources().getString(R.string.play_more));
                            finish = true;
                        }
                    } else {
                        if (input <= 0) {
                            Toast.makeText(
                                    MyFristApp.this, "Вводимое число меньше нуля!",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                        if (input > 100) {
                            Toast.makeText(
                                    MyFristApp.this, "Вводимое число больша 100!",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                } else {
                    rand = (int) (Math.random() * 100);
                    tvInfo.setText(getResources().getString(R.string.try_to_guess));
                    bControl.setText(getResources().getString(R.string.input_value));
                    finish = false;
                }
                etInput.setText("");
            } else {
                Toast.makeText(
                        MyFristApp.this, "Поле пустое!",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
