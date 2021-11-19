package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button bt, btSug;
    TextView[] tvNum = new TextView[6];
    Integer[] tvID = {R.id.num1, R.id.num2, R.id.num3, R.id.num4, R.id.num5, R.id.num6,};
    EditText edt;
    Integer[] lotto = new Integer[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = findViewById(R.id.bt);
        btSug = findViewById(R.id.btSug);
        edt = findViewById(R.id.edtPoem);
        Intent intent = getIntent();
        String tvData = intent.getStringExtra("tvData");

        edt.setText(tvData);

        for (int i = 0; i < tvID.length; i++) {
            tvNum[i] = findViewById(tvID[i]);
        }
        for (int i = 0; i < tvID.length; i++) {
            final int index = i;

            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edt.getText().toString().equals("") || edt.getText().toString() == null) {
                        for (int index = 0; index < tvID.length; index++) {
                            for (int o = 0; o < tvID.length; o++) {
                                int randomNum = (int) (Math.random() * 45) + 1;
                                lotto[o] = randomNum;
                                for (int j = 0; j < o; j++) {
                                    if (lotto[o] == lotto[j]) {
                                    }
                                }
                            }
                            tvNum[index].setText(lotto[index].toString());
                        }
                        Toast.makeText(getApplicationContext(), "입력된 값이 없어서 랜덤 값 출력", Toast.LENGTH_SHORT).show();
                    }//edt null value end.
                    else {
                        int poemInt = edt.getText().toString().length();
                        Random rnd = new Random();
                        rnd.setSeed(poemInt + System.currentTimeMillis());
                        for (int index = 0; index < tvID.length; index++) {
                            for (int o = 0; o < tvID.length; o++) {
                                int randomNum = (int) (Math.random() * 45) + 1;
                                lotto[o] = randomNum;
                                for (int j = 0; j < o; j++) {
                                    if (lotto[o] == lotto[j]) {
                                    }
                                }
                            }
                            tvNum[index].setText(lotto[index].toString());
                        }
                        Toast.makeText(getApplicationContext(), "해당 글귀와 현재 시간을 더해 숫자 생성", Toast.LENGTH_SHORT).show();
                    }
                }
            });// 숫자생성 버튼 끝
            btSug.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(),ItemActivity.class);
                    startActivity(i);
                }
            });
        }
    }
}