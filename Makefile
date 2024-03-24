all: clean build run

build:
	javac Main.java

run:
	java Main

clean:
	find . -type f -name '*.class' | xargs -r rm
