import java.util.ArrayList;

public class glue
{
	public static void main(String[] args)
	{
		String topic = "The witch hunter";
		ArrayList<String> tweets = TweetManager.getTweets(topic);
		NLP n = new NLP();

		int count = 0;
		System.out.println("\n\n*********************************************************************************************************************************************");
		System.out.println("									Tweets");
		System.out.println("*********************************************************************************************************************************************\n\n");
		System.out.println("0:Very Negative 1:Negative 2:Neutral 3:Positive 4:Very Positive\n");
		for(String tweet : tweets)
		{
			count++;
			System.out.println("Tweet no."+count+"\n"+tweet +" : " + n.findSentiment(tweet));
		}
	}
}
