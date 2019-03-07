package com.smeselidis.shoppinglist;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ListDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);

        TextView textView = findViewById(R.id.txtvw_details);

        String lists = getIntent().getExtras().getString("lists");

        Log.d("ERRORR", lists);



       DataSource dataSource = new DataSource(ListDetails.this);
       dataSource.open();
       List list = dataSource.selectList(lists);
       dataSource.close();

       textView.setText(list.getName());

    }
}
