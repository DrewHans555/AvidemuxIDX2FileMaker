# AvidemuxIDX2FileMaker
This repository contains code written in Java 1.8 and is designed to be used with Avidemux 2.6. 

When loading a video file Avidemux looks for an IDX2 index file to reference. If there is no IDX2 file then Avidemux will attempt to create one. In my experience using Avidemux 2.6, there is a 50% chance that the program will crash during this process. So, to get around this issue, I decided to write my own program to create the IDX2 files. 

JavaAvidemuxIDX2FileMaker takes in a directory path (for example, D:\Downloads\Videos) and then creates an IDX2 file for every file in the directory. You can download the JAR distribution or build the project yourself using my source code.

### Prerequisites
* Java 1.8 or higher

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
