[![Build Status](https://travis-ci.org/amithnair91/DownloadManager.svg?branch=master)](https://travis-ci.org/amithnair91/DownloadManager)

# DownloadManager

A Download Manager that can download files over HTTP. This Library supports pausing and resuming a file as well.

In order to buid the project use the following command:

./gradlew createJar
 OR 
 make -f MakeFile.txt compile
 
 
 
 After building you can use the jar can be found at build/libs/DownloadManager-all-1.0.jar
 
 To download any file use the following command line argument:
 
 java -jar 'build/libs/DownloadManager-all-1.0.jar' <url>  <location>
 
 example:  java -jar 'build/libs/DownloadManager-all-1.0.jar' http://dynamodb-local.s3-website-us-west-2.amazonaws.com/dynamodb_local_2016-05-17.zip ./Download
 
 OR
 make -f MakeFile.txt <url>  <location>

