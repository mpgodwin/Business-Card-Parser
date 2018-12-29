package Business;

import java.io.BufferedReader;  
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class businessCardParser {
	static String line;
	static String name;
	static String emailAddress;
	static String phoneNumber;

	public static void main(String[] args) {
		try {
			System.out.println("Madeleine Godwin, Applicant, Business Card Parser");
			System.out.println("********************************************************************************");
			/* Open the input data file and process its contents */
			BufferedReader br = new BufferedReader(new FileReader("src//Business//Input.txt"));
			while ((line = br.readLine()) != null) {

				getContactInfo(line);

			} // end of while

			System.out.println("Name: " + (name));
			System.out.println("Phone Number: " + (phoneNumber));
			System.out.println("Email Address: " + (emailAddress));
			//System.out.printf("End of File. Thank you for using!");

		} // end of try

		catch (IOException e) {
			System.out.println("ERROR - cannot open file");
		}

	}// main

	public static void getContactInfo(String line)

	{
		//will only allow string with the different phone number patterns and key words to pass
		if (line.toLowerCase().matches("(.*?phone number:.*)|(.*?phone:.*)|(.*?ph:.*)|"
				+ "(.*?tel:.*)|[+]?\\d?[- .]?(\\([0-9]\\d{2}\\)|[0-9]\\d{2})[- .]?\\d{3}[- .]?\\d{4}$")) 
		{
			getPhoneNumber();
		}
		//will only allow strings with an @ symbol to pass
		else if (line.matches("^[\\w\\+]+(\\.[\\w]+)*@" + "[\\w]+(\\.[\\w]+)*(\\.[A-Za-z]{2,})$"))
		{
			getEmailAddress();
		}
		//will only allow strings with two words and only two uppercase letters pass. (eg. John Doe or Software Engineer)
		else if (line.matches("^(?!(.*[A-Z]){3,})[a-zA-Z]+ [a-zA-Z]+$"))
		{
			getName();
		} 
	}

	public static String getName() // returns the full name of the individual (eg. John Smith, Susan Malick)
	{
		//disqualifier words. If string contains any of these words it will not pass. 
		if (!line.matches(".*\\b(Technologies|Engineer|Systems|Developer|Company|INC|Analyst|Computers|Technology)\\b.*")) 
		{
			name=line;
		}
		

		return name;
	}

	public static String getPhoneNumber() // returns the phone number formatted as a sequence of digits
	{
		String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})(?:Tel:)$";
		Pattern pattern = Pattern.compile(regex);
		phoneNumber = line.replaceAll("[^\\d]", "");

		return phoneNumber;
	}

	public static String getEmailAddress() // returns the email address
	{
		emailAddress = line;

		//String domain = emailAddress.substring(emailAddress.lastIndexOf("@")+1);
		return emailAddress;
	}


}// class
