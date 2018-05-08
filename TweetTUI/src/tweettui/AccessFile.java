package tweettui;

import java.util.*;
import java.io.*;

public class AccessFile {
  public List<Tweet> readFile(String fileName) {
    List<Tweet> allTweets = new ArrayList<Tweet>();
    try {
      FileReader input = new FileReader(fileName);
      BufferedReader bf = new BufferedReader(input);  
      String line = bf.readLine();
      while (line != null) {
        Tweet t = new Tweet(line);
        allTweets.add(t);
        line = bf.readLine();
      }
    } catch (IOException e) {
      System.out.println("Error! file not found.");
    }
    return allTweets;
  }
  
  public void writeFile(List<Tweet> tweets,String fileName){
    try{
      PrintWriter p = new PrintWriter(fileName);
      Iterator<Tweet> it = tweets.iterator();
      while (it.hasNext()) {
        Tweet tweet = it.next();
        p.println(tweet.getMsg());
        p.flush();
      }
    }catch(IOException e){
      System.out.println("Error! with IO");
    }
  }
}
