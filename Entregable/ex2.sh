#!/bin/bash

if [ $# -ne 1 ]
  then echo "Input file missing"
else
  java -cp './TP1.jar' -Dexercise=2 -Dinput=$1 -Doutput="exercise2" "ar.edu.itba.bio.Main"
fi
