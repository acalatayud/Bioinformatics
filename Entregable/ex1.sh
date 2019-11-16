#!/bin/bash

if [ $# -ne 1 ]
  then echo "Input file missing"
else
  java -cp './TP1.jar' -Dexercise=1 -Dinput=$1 -Doutput="exercise1" "ar.edu.itba.bio.Main"
fi
