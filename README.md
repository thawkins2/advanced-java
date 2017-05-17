
## Welcome to my Advanced Java Project

This project consisted of two parts, the Analyzer and a web development portion. All source code management
was done with GitHub.

## Analyzer
Analyzer program takes a text file in from the command line. It them parses the file, analyzes each token,
and creates various reports. Using I/O, a line is read and sorted into an array of tokens. Looping through
the array, each token is passed into the various analyzer report methods and processed accordingly. Java
properties were used for setting the report locations as they are being created.

# Reports
Summary Report - Information about me, the class, date and time the report was run, and total number of tokens processed.
Most of the information for this report was found in the properties file. Only the total number of tokens was calculated as the file was processed. 

Unique Tokens - List of each unqiue token found in the text file. TreeSet<String> was used so there were no duplicate tokens
found within the list and for the natrual sorting.

Big Words - Using a property value, this report contains all tokens that are at least the value or more. This analyzer
also used a TreeSet<String> for no duplicate tokens and the natural sorting.

Token Count - Each token and the number of times it is found within the file. TreeMap was used for this report

Token Size - The distribution of token lengths found within the document and a simple histogram chart displaying
the distribution

