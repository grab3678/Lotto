package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poem_list);

        ArrayList<String> list = new ArrayList<>();
        //더미데이터 만들기
        for (int i = 0; i < 200; i++) {
            list.add(String.format("TEXT %d", i));
        }
        Button btBack = findViewById(R.id.btBack);
        TextView tv1 = findViewById(R.id.poemItem);

        //recyclerView 에 layoutManager 객체 지정
        RecyclerView rc1 = findViewById(R.id.rc1);
        rc1.setLayoutManager(new LinearLayoutManager(this));

        //recyclerView 에 ListAdapter 객체 지정.
        ListAdapter adapter = new ListAdapter(list);
        rc1.setAdapter(adapter);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });//btBack end
        adapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("tvData",list.get(position));
                startActivity(intent);
            }
        });//item click event end
    }
}