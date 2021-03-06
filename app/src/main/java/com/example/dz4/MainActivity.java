package com.example.dz4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.metrics.LogSessionId;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;

import com.example.dz4.adapter.AdapterBook;
import com.example.dz4.listener.OnItemClickListener;
import com.example.dz4.model.BookModel;
import com.example.dz4.model.data.BookClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterBook adapterBook;
    ArrayList<BookModel> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inItView();
    }

    private void inItView() {
       recyclerView = findViewById(R.id.recycler_view);
       list = BookClient.getBook();
       adapterBook = new AdapterBook(list);
       recyclerView.setAdapter(adapterBook);
       adapterBook.setOnItemClickListener(new OnItemClickListener() {

           @Override
           public void onItemClickListener(BookModel model) {
               Intent intent = new Intent(MainActivity.this,Description.class);
               intent.putExtra("model",model);
               startActivity(intent);

           }
       });
    }
}