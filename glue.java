import java.util.ArrayList;

public class glue
{
	public static void main(String[] args)
	{
		String topic = "Zuckerberg";
		ArrayList<String> tweets = TweetManager.getTweets(topic);
		NLP.init();

		int count = 0;
		System.out.println("\n\n************************************************************Tweets************************************************************\n\n");
		for(String tweet : tweets)
		{
			count++;
			System.out.println("Tweet no."+count+"\n"+tweet);
		}
	}
}
