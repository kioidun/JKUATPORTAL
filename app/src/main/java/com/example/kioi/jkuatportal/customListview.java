package com.example.kioi.jkuatportal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customListview extends ArrayAdapter<String> {

    private String [] Lecturers;
    private String [] number;
    private Integer [] pic;
    private Activity context;

    public customListview(Activity context, String [] Lecturers,String [] number,Integer [] pic) {
        super(context, R.layout.listview_layout,Lecturers);

        this.context= context;
        this.Lecturers =Lecturers;
        this.number =number;
        this.pic=pic;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;

        if(r==null){
            LayoutInflater layoutInflater =context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder =new ViewHolder(r);
            r.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) r.getTag();
        }
            viewHolder.user.setImageResource(pic[position]);
            viewHolder.name.setText(Lecturers[position]);
            viewHolder.numbers.setText(number[position]);

        return r;
    }
    class ViewHolder {
        TextView name;
        TextView numbers;
        ImageView user;
        ViewHolder (View v){
            name =(TextView)v.findViewById(R.id.textName);
            numbers=(TextView)v.findViewById(R.id.textNumber);
            user =(ImageView)v.findViewById(R.id.imageView);
        }
    }
}
