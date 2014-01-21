package Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.19.14
 */
public class Funktions {
	
	public static String validConsoleInput()
	{
		BufferedReader lineIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput = ""; 
		try
		{
			userInput = lineIn.readLine();
		}
		catch(IOException e)
		{
			System.out.println("Konsolenfehler");
		}

		return userInput;
	}

	public static int getUserValue()
	{
		int userAnswer = -1;
		while(userAnswer == -1)
		{
			try
			{
				userAnswer = Integer.parseInt(validConsoleInput());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Geben sie eine Zahl wischen 1 und 4 ein!");
			}
		}
		return userAnswer-1;
	}

	public static int randomPosition()
	{
		return (int)(Math.random() *100);
	}		
	
}
