#!/bin/bash

if [ $# -ne 1 ]
  then echo "Input file missing"
else
  java -cp './TP1.jar' -Dexercise=4 -Dinput=$1 -Doutput="exercise4" -Dpattern=$2 "ar.edu.itba.bio.Main"
fi
