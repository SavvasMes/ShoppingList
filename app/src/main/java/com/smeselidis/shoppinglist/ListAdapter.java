package com.smeselidis.shoppinglist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<List> lists;

    public ListAdapter(Context context, ArrayList<List> lists){
        this.context = context;
        this.lists = lists;
    }


    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lists.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView txt_vw_list = convertView.findViewById(R.id.txt_vw_list);
        TextView txtvw_id = convertView.findViewById(R.id.txtvw_id);

        List list_pos = lists.get(position);
        txt_vw_list.setText(list_pos.getName());
        txtvw_id.setText(String.valueOf(list_pos.getId()));
        return convertView;
    }
}
