package com.smeselidis.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        final EditText edtx_name = findViewById(R.id.txt_listName);
        Button btn_addList = findViewById(R.id.btn_addlist);

        btn_addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtx_name.getText().toString();

                DataSource dataSource = new DataSource(NewList.this);
                dataSource.open();
                dataSource.insertList(name);
                dataSource.close();
            }
        });
    }
}
