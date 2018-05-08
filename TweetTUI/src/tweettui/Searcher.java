package tweettui;

import java.util.*;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Searcher {

    private AccessFile af; 
    private HashMap<String, List<Tweet>> tweets;
    
    //this instance variable is for searching with input file.
    private HashMap<String, List<Tweet>> allTweets;

    public Searcher() {
        tweets = new HashMap<String, List<Tweet>>();
        allTweets = new HashMap<String, List<Tweet>>();
        af = new AccessFile();
    }

    //searching with input file
    public void scanText(String keyword, String fileName) {
        allTweets.put(keyword, af.readFile(fileName));
        tweets.put(keyword, new ArrayList<Tweet>());
        Iterator<Tweet> it = allTweets.get(keyword).iterator();
        while (it.hasNext()) {
            Tweet tweet = it.next();
            if (tweet.getMsg().toLowerCase().contains(keyword.toLowerCase())) {
                tweets.get(keyword).add(tweet);
            }
        }
        af.writeFile(tweets.get(keyword),"output.txt");
    }

    //searching with twitter4j api
    public void scanText(String keyword) throws TwitterException {
        tweets.put(keyword, new ArrayList<Tweet>());
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("")
                .setOAuthConsumerSecret("")
                .setOAuthAccessToken("")
                .setOAuthAccessTokenSecret("");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        Query query = new Query(keyword);
        QueryResult result;
        do {
            result = twitter.search(query);
            List<Status> tmp = result.getTweets();
            for (Status tweet : tmp) {
                tweets.get(keyword).add(new tweettui.Tweet(tweet.getText(),tweet.getUser().toString()));
            }
        } while ((query = result.nextQuery()) != null);
        af.writeFile(tweets.get(keyword),"output.txt");
    }

    public List<Tweet> getTweets(String keyword) {
        return tweets.get(keyword);
    }

    public List<Tweet> getAllTweets(String keyword) {
        return allTweets.get(keyword);
    }
}
