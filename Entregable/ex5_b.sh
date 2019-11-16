#!/bin/bash

if [ $# -ne 1 ]
  then echo "File name missing"
else
  echo "Extracting motifs..."
  sudo prosextract -prositedir="./prosite"
  echo "Domain analysis for sequence and saving in file exercise5_domains.txt ..."
  patmatmotifs $1 exercise5_domains.txt
fi
