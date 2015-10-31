import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TweetManager {

	public static ArrayList<String> getTweets(String topic)
	{
		Twitter twitter = new TwitterFactory().getInstance();
		ArrayList<String> tweetList = new ArrayList<String>();
		int count = 1;
		int MAX_TWEETS = 300;
		try
		{
			Query query = new Query("lang:en AND "+topic);
			QueryResult result;
			do												//Only show the tweets of a single page from the query i.e 15 tweets.
			{
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets)
				{
					tweetList.add(tweet.getText());
					count++;
					if(count>MAX_TWEETS)	break;
				}
			}
			while (((query = result.nextQuery()) != null) && ( count<MAX_TWEETS ));
		}
		catch (TwitterException te)
		{
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
		}
		return tweetList;
	}
}
