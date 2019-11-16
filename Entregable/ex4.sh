#!/bin/bash

if [ $# -ne 2 ]
  then echo "Input file missing or pattern"
else
  java -cp './TP1.jar' -Dexercise=4 -Dinput=$1 -Doutput="exercise4" -Dpattern=$2 "ar.edu.itba.bio.Main"
fi
