#!/bin/bash        
echo "compiling..."  
javac -d bin src/comp20010_tutorial_1/*.java
cd bin 
echo "building jar"
jar cfe ScoreBoard.jar comp20010_tutorial_1.ScoreBoard comp20010_tutorial_1/*.class
mv ScoreBoard.jar ..
echo "run: 'java -jar ScoreBoard.jar' to run"

