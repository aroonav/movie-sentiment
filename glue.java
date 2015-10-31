import java.util.ArrayList;

public class glue
{
	public static void main(String[] args)
	{
		String topic = "The witch hunter";
		ArrayList<String> tweets = TweetManager.getTweets(topic);
		NLP n = new NLP();

		int count = 0;
		System.out.println("\n\n************************************************************Tweets************************************************************\n\n");
		for(String tweet : tweets)
		{
			count++;
			System.out.print("Tweet no."+count+"\n"+tweet +" : ");
			System.out.println( n.findSentiment(tweet) );
//			n.findSentiment(tweet);
		}
	}
}
