package com.smeselidis.shoppinglist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    Context context;
    ArrayList<ListItem> listItems;

   public ItemAdapter (Context context, ArrayList<ListItem> listItems){
       this.context = context;
       this.listItems = listItems;
   }


    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listItems.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

            TextView txt_vw_item = convertView.findViewById(R.id.txt_vw_list);
            TextView txt_vw_descript = convertView.findViewById(R.id.txt_vw_descript);

        ListItem listItem_pos = listItems.get(position);
        txt_vw_item.setText(listItem_pos.getName());
        txt_vw_descript.setText(listItem_pos.getDescription());
        return convertView;

    }

    }
