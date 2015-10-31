all:
	javac -cp ./lib/stanford-corenlp-3.5.2.jar:./lib/twitter4j-core-4.0.4.jar NLP.java glue.java TweetManager.java
	java -cp ./:./lib/* glue
clean:
	rm *.class