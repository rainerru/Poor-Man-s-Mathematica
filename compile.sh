#!/bin/bash
cd src
find . -name '*.java' -exec javac -d ../out {} + &
find ../test -name '*.java' -exec javac -d ../out {} + &
cd ..

