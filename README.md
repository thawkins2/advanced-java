
# Welcome to my Advanced Java Project

This project consisted of two parts, the Analyzer program and applet development with Java EE and Tomcat. All source code management
was done with GitHub.


## Analyzer
Analyzer program takes a text file in from the command line. It them parses the file, analyzes each token,
and creates various reports. Using I/O, a line is read and sorted into an array of tokens. Looping through
the array, each token is passed into the various analyzer report methods and processed accordingly. Java
properties were used for setting the report locations as they are being created.

### Directory Structure
src/java112/analyzer - Analyzer java files

output/ - Analyzer reports and keyword text file

config/ - Properties file

### Reports
Summary Report - Information about me, the class, date and time the report was run, and total number of tokens processed.
Most of the information for this report was found in the properties file. Only the total number of tokens was calculated as the file was processed. 

Unique Tokens - List of each unqiue token found in the text file. TreeSet\<String> was used so there were no duplicate tokens
found within the list and for the natrual sorting.

Big Words - Using a property value, this report contains all tokens that are at least the value or more in length. This
analyzer also used a TreeSet\<String> for no duplicate tokens and the natural sorting.

Token Count - Each token and the number of times it is found within the file. TreeMap\<String, Integer> was used for this
report. The string being the token, and the interger being the number of times it was found. As each token was passed
into the class method, the map was searched for a key that matched the token. If not found, the map was updated with the
new token. If the token was found, the value for the map key matching the token was incremented.

Token Size - The distribution of token lengths found within the document and a simple histogram chart displaying the
distribution. A TreeMap\<Integer, Integer>, was used for storing each token length and the number of times it was found.
As each token was passed in, the length of said token was compared to the TreeMap keys. Similar to the token count, that
specific token length was either added to the map or incremented. Using the TreeMap, after the whole file had been
processed, the histogram report started processing. The histrogram report is dynamic, as each token size is always 
represented by at least one asterisk, but the the most common doesn't exceed a line length of 80 character.

Keyword Locations - Report took keywords from a separate file and added those tokens to a map as keys. The key values
were a list that would show where the keywords were found. The properties file contained this text files location. This
file contained tokens and was parsed similar to the main text file. Using a TreeMap\<String,List\<Integer>>, each
keyword was stored as a key and a counter would increment with each token passed into the analyzer. When a token passed
in matched a map key, the counter value would be added to that key's list value.


## Jave EE with Tomcat
This portion of the project was to introduce us to web development with Java EE, using Tomcat as our web server. The
Model-view-controller architecture was also introduced and used for development. Project 2 and project 3 started with
basic use of javabeans, servlets, and jsp to introduce us to HttpServlet request and response. In project 4 we create an
applet to add an employee or search a databse of employees. We used JDBC for our database needs. Lastly we added our
analyzer program to our web app. The text file is uploaded and the name and location for the file is stores in the
session as attributes. Allowing the analyzer app to use the session to find the text file for processing. Each report is
viewable in a web page. Due to time contraints and limitations of our environment, my uploaded text file is stored on
linux's local temp file.  

### Directory Structure
src/java112/employee - Contains our employee object, search object, and the employee directory.

public_html/ - Contains all our jsp files with all partials found in the jsp folder.

src/java112/project4 - Servlets for grabbing form data, calling the correct class methods, and forwarding/redirecting.

### Employee
Employee - Used to create the employee object for the applet.

Search - Search object used to return the list of employees returned from a query and if employees were found or not.

EmployeeDirectory - Takes in the search term and search type from the web form. Uses these to search the database for
employees based on what was sent by the form. Returns a search object with the search results. There is also a method
for adding a new employee and returns a success or error message to be displayed.

### Project 4
Various servlets used for processing and routing. Some such as UploadFile are used solely for forwarding to the appropriate page. Servlets like SearchResults grab ServletContext attributes used for acessing the Employee classes, get form attributes, and then call the correct methods for processing.
