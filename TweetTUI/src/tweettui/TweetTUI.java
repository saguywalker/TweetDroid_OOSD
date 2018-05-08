/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author User
 */
public class TweetTUI {

    /**
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws twitter4j.TwitterException {
        Scanner sc = new Scanner(System.in);
        Searcher search = new Searcher();

        System.out.print("Enter keyword: ");
        String keyword = sc.next();
        /*
        search.scanText(keyword, "input.txt");
        System.out.println("Numbers of tweet about \'" + keyword + "\' is " + search.getTweets(keyword).size());
        printTweets(search.getTweets(keyword));*/
        
        search.scanText(keyword);
        printTweets(search.getTweets(keyword));
        
        sc.close();
    }

    public static void printTweets(List<Tweet> t) {
        int c = 1;
        Iterator<Tweet> it = t.iterator();
        {
            while (it.hasNext()) {
                System.out.println(c++ + " " + it.next().getMsg());
            }
        }
    }
}
