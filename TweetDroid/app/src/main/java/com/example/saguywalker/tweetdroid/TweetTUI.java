package com.example.saguywalker.tweetdroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class TweetTUI extends AppCompatActivity {

    public static final String API_KEY = "";
    public static final String API_SECRET = "";
    public static final String ACCESS_TOKEN = "";
    public static final String ACCESS_TOKEN_SECRET = "";

    private EditText mEditText;
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_tui);

        mEditText = findViewById(R.id.editText);
        mTextView = findViewById(R.id.textView);
    }

    public void showSearch(View view) {
        String keyword = mEditText.getText().toString();
        if (!keyword.isEmpty()) {
            int c = 1;
            mTextView.setText("");
            Searcher s = new Searcher();
            s.search(keyword);
            List tweets = s.getTweets(keyword);
            Iterator<Tweet> it = tweets.iterator();
            while(it.hasNext()){
                Tweet tmp = it.next();
                mTextView.append("\n" + c++ + "."+ tmp.getOwner()+" : " + tmp.getMsg()+"\n");
            }
        }

    }
}

