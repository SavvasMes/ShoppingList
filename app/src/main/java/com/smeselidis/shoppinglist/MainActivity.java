package com.smeselidis.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_newList = findViewById(R.id.btn_newList);
        lv_list = findViewById(R.id.lv_list);



        btn_newList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewList.class);
                startActivity(intent);
            }
        });

        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txt_vw_list = view.findViewById(R.id.txtvw_id);

                Intent intent = new Intent(MainActivity.this, ListDetails.class);
                intent.putExtra("lists", txt_vw_list.getText().toString());
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataSource dataSource = new DataSource(MainActivity.this);
        dataSource.open();

        ArrayList<List> lists = dataSource.selectLists();
        ListAdapter adapter = new ListAdapter(MainActivity.this, lists);
        lv_list.setAdapter(adapter);
        dataSource.close();

    }
}
