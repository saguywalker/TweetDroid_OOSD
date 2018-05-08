package tweettui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetTUI {

    public static void main(String[] args) throws twitter4j.TwitterException {
        Scanner sc = new Scanner(System.in);
        Searcher search = new Searcher();

        System.out.print("Enter keyword: ");
        String keyword = sc.next();
        
        search.scanText(keyword);
        printTweets(search.getTweets(keyword));
        
        sc.close();
    }

    public static void printTweets(List<Tweet> t) {
        System.out.println("Total tweets = " + t.size());
        int c = 1;
        Iterator<Tweet> it = t.iterator();
        {
            while (it.hasNext()) {
                Tweet tmp = it.next();
                System.out.println(c++ + "." + tmp.getOwner() + ": " + tmp.getMsg());
            }
        }
    }
}
