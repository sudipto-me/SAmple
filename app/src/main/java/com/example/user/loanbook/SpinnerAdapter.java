package com.example.user.loanbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Android on 8/21/2017.
 */

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    public int newid[];
    public String[] newname;
    LayoutInflater inflater;

    public SpinnerAdapter(Context context,int[] id,String[] name){
        this.context = context;
        this.newid = id;
        this.newname = name;
        inflater = (LayoutInflater.from(context));


    }

    @Override
    public int getCount() {
        return newid.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.spinnerview,null);
        TextView id = (TextView)view.findViewById(R.id.tv_spinner_id);
        TextView name = (TextView)view.findViewById(R.id.tv_spinner_name);
        id.setText(String.valueOf(newid[i]));
        name.setText(newname[i]);
        return view;
    }
}
