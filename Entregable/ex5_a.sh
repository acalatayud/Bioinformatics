#!/bin/bash

if [ $# -ne 1 ]
  then echo "File name missing"
else
  echo "Calculating ORF for sequence and saving in file exercise5.fas ..."
  getorf $1 exercise5.fas
fi
