package com.example.saguywalker.tweetdroid;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetTUI extends AppCompatActivity {

    //twitter api key
    private static final String API_KEY = "";
    private static final String API_SECRET = "";
    private static final String ACCESS_TOKEN = "";
    private static final String ACCESS_TOKEN_SECRET = "";

    private Button mButton;
    private EditText mEditText;
    private TextView mTextView;

    //twitter4j
    public ConfigurationBuilder cb;
    public TwitterFactory factory;
    public static Twitter twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_tui);
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(API_KEY)
                .setOAuthConsumerSecret(API_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        factory = new TwitterFactory(cb.build());
        twitter = factory.getInstance();

        //permission for network
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //point variables to xml id
        mEditText = findViewById(R.id.editText);
        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);
    }

    public void showSearch(View view) {
        String keyword = mEditText.getText().toString();
        if (!keyword.isEmpty()) {
            int c = 1;
            mTextView.setText("");
            try {
                Query query = new Query(keyword);
                query.setCount(100);
                QueryResult result = twitter.search(query);
                for (Status tweet : result.getTweets()) {
                    mTextView.append("\n" + c++ + "."+ tweet.getUser().getScreenName()+" : " + tweet.getText()+"\n");

                }
            } catch (Exception e) {
                Log.d("TweetTUI", e.toString());
                mTextView.setText(e.toString());
            }
        }
    }



}
