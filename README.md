# AvidemuxIDX2FileMaker
This repository contains code written in Java 1.8 and is designed to be used with the program Avidemux 2.6.  

When using loading a video file into Avidemux to edit the program will check to see if there is a IDX2 file next to the video file.  If no IDX2 file exists then Avidemux will attempt to create one before it loads the video you want to edit.

Sometimes Avidemux successfully creates the IDX2 file and all is good.  Other times Avidemux will get hung up on creating the IDX2 file and then crash.

This is were my program comes to the rescue!  This code takes in a directory location (for example, D:\Downloads\Videos) and then creates a IDX2 file for every file in the directory.  Creating the IDX2 files with this program, instead of Avidemux, will stop Avidemux from crashing when it loads a video because it will see that a IDX2 file already exists for the video you want to edit.

For convenience I have included my source code and a JAR distribution that should work on any machine with Java 1.8 or higher.
