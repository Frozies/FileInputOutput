# FileInputOutput
 This is a json cleaner and a csv cleaner written in java
Finish the subclass CSVCleaner and main.java (submit the .java file (NO REPL))
Files (you will need to change the file paths, Paths, to your .csv or .json locations):

csvCleaner.java
fileCleaner.java
Main.java
SEOExample.csv

(don't need for assignment itself, used in example): entrypoints.json  download 
This is a short assignment so you can work on your projects which part two is due in two weeks

So on Tuesday, with main & FileCleaner, we've already open, read, and re-written a "json" file. With this we will need to now clean-up (serialize) some csv files. Use main.java to open and read the file and print out a clean version (named "clean_seoexample.csv"). While CSVCleaner should:

Inherits the fileCleaner constructor
Have a new Method
public boolean checkIfCommas(string line)
Should check (return true) if line is "all" commas (or at least mostly)
Have an overridden method:
public boolean checkIfComment(string line)
Should return true if its "starts" (excluding whitespace) with "#" (hashtag)
There is no #comment in this file but I will look for the method (scaling is a thing)