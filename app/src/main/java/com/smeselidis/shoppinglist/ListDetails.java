package com.smeselidis.shoppinglist;

import android.app.Dialog;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ListDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);

        TextView textView = findViewById(R.id.txtvw_details);

        String lists = getIntent().getExtras().getString("lists");

        Button btn_addItem = findViewById(R.id.btn_addItem);

        btn_addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(ListDetails.this);
                dialog.setContentView(R.layout.dialog);


                final Button btn_save = dialog.findViewById(R.id.btn_save);
                final Button btn_cancel = dialog.findViewById(R.id.btn_cancel);
                final EditText edtxt_item = dialog.findViewById(R.id.edtxt_item);
                final EditText edtxt_des = dialog.findViewById(R.id.edtxt_des);

                btn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                   public void onClick(View v) {



                   }
                });
                dialog.show();

            }
        });



       DataSource dataSource = new DataSource(ListDetails.this);
       dataSource.open();
       List list = dataSource.selectList(lists);
       dataSource.close();

       textView.setText(list.getName());

    }
}
