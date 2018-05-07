package com.example.kioi.jkuatportal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class ChatListAdapter extends BaseAdapter{
    //code that acts as a bridge between the chat message from firebase and the listView that needs to display the message
    private Activity mActivity;
    private DatabaseReference mDatabaseReference;
    private String mDisplayName;
    //database snapshot is a type used by firebase for passing data back to the app. every time we read from the database we receive our data inform of a snapshot
    private ArrayList<DataSnapshot> mSnapshotList;
    private ChildEventListener mListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            mSnapshotList.add(dataSnapshot);
            notifyDataSetChanged();
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    public ChatListAdapter(Activity activity,DatabaseReference ref,String name){
        mActivity= activity;
        mDisplayName=name;
        mDatabaseReference=ref.child("messages");
        mDatabaseReference.addChildEventListener(mListener);

        mSnapshotList=new ArrayList<>();
    }

    //hold all the views in a single chatrow
    //in a Inner class
    static class ViewHolder{
        TextView authorName;
        TextView body;
        LinearLayout.LayoutParams params;
    }


    @Override
    public int getCount() {
        return mSnapshotList.size();
    }

    @Override
    public InstantMessage getItem(int position) {
        DataSnapshot snapshot = mSnapshotList.get(position);
        return snapshot.getValue(InstantMessage.class);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
   //changing the number of views. if one view disappears the other one appears
    //converView represents a list Item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.chat_msg_row,parent,false);
            final  ViewHolder holder =new ViewHolder();
            holder.authorName =(TextView)convertView.findViewById(R.id.author);
            holder.body=(TextView)convertView.findViewById(R.id.message);
            holder.params=(LinearLayout.LayoutParams)holder.authorName.getLayoutParams();
            //reusing
            convertView.setTag(holder);

        }
        final InstantMessage message =getItem(position);
        final ViewHolder holder = (ViewHolder)convertView.getTag();

      // boolean isMe= message.getAuthor().equals(mDisplayName);
      //  setChatRowAppearance(isMe,holder);

        String author =message.getAuthor();
        holder.authorName.setText(author);

        String msg =message.getAuthor();
        holder.body.setText(msg);

        return convertView;
    }


   //stop checking for new events in the database. to freeup resources when we dont need them anymore
    //method that removes the firebase eventListener

    public void CleanUp(){
        mDatabaseReference.removeEventListener(mListener);
    }



}
