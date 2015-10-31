import java.io.*;
import java.util.*;
import edu.stanford.nlp.io.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.trees.TreeCoreAnnotations.*;
import edu.stanford.nlp.util.*;

public class StanfordCoreNlpExample
{
	public static void main(String[] args) throws IOException
	{
		PrintWriter xmlOut = new PrintWriter("xmlOutput.xml");
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
//		Annotation annotation = new Annotation("This is a short sentence and the previous phrase is wrong.");
		Annotation annotation = new Annotation("This is a short sentence. And this is another.");
		pipeline.annotate(annotation);
		pipeline.xmlPrint(annotation, xmlOut);
		// An Annotation is a Map and you can get and use the
		// various analyses individually. For instance, this
		// gets the parse tree of the 1st sentence in the text.
		List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
		if (sentences != null && sentences.size() > 0)
		{
			for(int i=0;i<sentences.size();i++)
			{
				PrintWriter out = new PrintWriter(System.out);
				out.println("Parsing of sentence#"+(i+1));
				CoreMap sentence = sentences.get(i);
				Tree tree = sentence.get(TreeAnnotation.class);
				out.println("The first sentence parsed is:");
				tree.pennPrint(out);
			}
		}
	}
}
