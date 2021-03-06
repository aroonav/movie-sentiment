import java.util.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class NLP
{
	Properties props;
	StanfordCoreNLP pipeline;

	public NLP()
	{
		props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
		pipeline = new StanfordCoreNLP(props);
	}

	public int findSentiment(String tweet)
	{
		int mainSentiment = 0;
		if (tweet != null && tweet.length() > 0)
		{
			int longest = 0;
			try
			{
				Annotation annotation = pipeline.process(tweet);
				for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class))
				{
					Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
					int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
					String partText = sentence.toString();
					if (partText.length() > longest)
					{
						mainSentiment = sentiment;
						longest = partText.length();
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(" :(  Exception caught  :) ");
			}
		}
		return mainSentiment;
	}
}