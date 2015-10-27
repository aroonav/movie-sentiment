all:
	javac -cp /home/roguedragon/programs/sentiment/stanford-corenlp-full-2015-04-20/stanford-corenlp-3.5.2.jar StanfordCoreNlpExample.java
	java -cp /home/roguedragon/programs/sentiment/stanford-corenlp-full-2015-04-20/*:./ StanfordCoreNlpExample
clean:
	rm *.class
	rm *.xml
