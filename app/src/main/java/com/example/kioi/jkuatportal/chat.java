package com.example.kioi.jkuatportal;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class chat extends AppCompatActivity {

    private ImageButton mSendButton;
    private EditText mInputText;
    private ListView mChatListView;
    private DatabaseReference mDatabaseReference;
    private String mDisplayName;
    private ChatListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        setupDisplayName();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mInputText=(EditText)findViewById(R.id.messageInput);
        mSendButton=(ImageButton)findViewById(R.id.sendButton);
        mChatListView=(ListView)findViewById(R.id.chat_list_view);

        //send the message when the"enter "button is pressed
        mInputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                sendMessage();
                return true;

            }
        });

        //add on onclicklistener to the sendButton to the sendButton to send a message
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }
    private void setupDisplayName(){
        SharedPreferences prefs =getSharedPreferences(RegisterActivity.CHAT_PREFS,MODE_PRIVATE);

        mDisplayName=prefs.getString(RegisterActivity.DISPLAY_NAME_KEY,null);

        if (mDisplayName==null)mDisplayName="anonymous";


    }
    private void sendMessage() {

        //  Grab the text the user typed in and push the message to Firebase
        Log.d("JKUATPORTAL","I sent something");
        String input =mInputText.getText().toString();
        if(!input.equals("")){
            InstantMessage chat =new InstantMessage(input,mDisplayName);
            //save message to the cloud
            // all our chat messages are to be stored in a place called messages
            //we use the push message to get the reference to the child location
            //we call setValue to write data in our chat object to the database
            mDatabaseReference.child("messages").push().setValue(chat);
            mInputText.setText("");
        }

    }

    // setting the adapter
   @Override
    public void onStart(){
        super.onStart();
        mAdapter = new ChatListAdapter(this,mDatabaseReference,mDisplayName);
        mChatListView.setAdapter(mAdapter);
    }
    @Override
    public void onStop(){
        super.onStop();

        //remove the firebase event listener on the adapter
        mAdapter.CleanUp();
    }
}
