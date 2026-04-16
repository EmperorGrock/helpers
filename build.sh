#!/bin/bash
javac -d out *.java
jar cf helpers.jar -C out .