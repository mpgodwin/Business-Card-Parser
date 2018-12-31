# Business-Card-Parser
 ## How to run:
Files Provided: Input.txt  and  businessCardParser.java 
This project was made using Eclipse. 

Prerequisites: You will need JDK and Eclipse or some other software that can run java files. You will also need to download this files and extract them from the zip file.
Eclipse- https://www.eclipse.org/downloads/packages/release/2018-12/r
JDK: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Installing:

You should be able to take the project and drop it into your Eclipse workspace. From there you will neesd to double check the file path of the input file, which should be in the same package as the businessCardParser.java file.



## Description:
This program parses the results of the optical character recognition (OCR) component in order to extract the name, phone number, and email address from the processed business card image that is provided. 


## Future Project Plans/Ideas:
 Name: In the future, I would like to redo the getName function by parsing the name through the Apache OpenNLP Library.
 https://opennlp.apache.org/
 
Phone Number: For the phone number, I would like to also redo that function by using the libphonenumber, which is a library used for parsing phone numbers.
https://github.com/googlei18n/libphonenumber
 
Email Address: For the email address, I would like to do more research on the validatiion process.
 
 
 
 
## Program Flaws:
Name:
There are several known program flaws when it comes to determining if a string is actually a persons name. As of now, the program determines if a string is a persons name by determing if that string contains only two words and two capital letters. The first flaw with this would mean an input string with a first, middle, and last name would be eliminated even if that string was actually the correct name. The next flaw is that many names contain more than two capital letters and include apostrophes. The other main flaw when it comes to determining a persons name is using disqualifier key words. If these key words are in the name being questioned, then the next line will be called by the program. There are only six key words right now, which means there could potentially mean a company name or job title can pass through the paramaters stated above as a persons name when in fact that is false. 

Phone Number: 
The flaw associated with the number is very simple. It only supports phone numbers from the United States at this time. 







