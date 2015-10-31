import java.util.ArrayList;

public class glue
{
	public static void main(String[] args)
	{
		String topic = "Zuckerberg";
		ArrayList<String> tweets = TweetManager.getTweets(topic);
		NLP.init();
		System.out.println("SIZEEEEEEEEEEEEEEEEeeeeeeeeeeee: "+tweets.size());

		for(String tweet : tweets)
		{
			System.out.println(tweet + " : " + NLP.findSentiment(tweet));
		}
	}
}
