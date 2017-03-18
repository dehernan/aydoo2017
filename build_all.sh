#!/bin/bash

for dir in */ ; do
  cd $dir
  mvn clean test
  cd ..
done
