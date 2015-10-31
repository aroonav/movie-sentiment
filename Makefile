all:
#	javac -cp ./lib/ejml-0.23.jar:./lib/stanford-corenlp-3.5.2.jar:./lib/stanford-corenlp-3.5.2-models.jar:./lib/twitter4j-core-4.0.4.jar:./lib/xom.jar NLP.java glue.java TweetManager.java
	javac -cp ./lib/stanford-corenlp-3.5.2.jar:./lib/stanford-corenlp-3.5.2-models.jar:./lib/twitter4j-core-4.0.4.jar NLP.java glue.java TweetManager.java
	java -cp ./:./lib/* glue
clean:
	rm *.class