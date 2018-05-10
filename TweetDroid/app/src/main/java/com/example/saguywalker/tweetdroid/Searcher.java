package com.example.saguywalker.tweetdroid;

import android.os.StrictMode;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Searcher {

    private HashMap<String,List<Tweet>> tweets;
    private TwitterFactory factory;
    private Twitter twitter;

    public Searcher(){
        tweets = new HashMap<>();
        ConfigurationBuilder cb;
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(TweetTUI.API_KEY)
                .setOAuthConsumerSecret(TweetTUI.API_SECRET)
                .setOAuthAccessToken(TweetTUI.ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TweetTUI.ACCESS_TOKEN_SECRET);
        factory = new TwitterFactory(cb.build());
        twitter = factory.getInstance();
    }

    public void search(String keyword){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        tweets.put(keyword,new ArrayList<Tweet>());
        try {
            Query query = new Query(keyword);
            query.setCount(100);
            QueryResult result = twitter.search(query);
            for (Status tweet : result.getTweets()) {
                tweets.get(keyword).add(new Tweet(tweet.getUser().getScreenName(),tweet.getText()));
            }
        } catch (Exception e) {
            Log.d("TweetTUI", e.toString());

        }
    }

    public List getTweets(String keyword){
        return tweets.get(keyword);
    }
}
