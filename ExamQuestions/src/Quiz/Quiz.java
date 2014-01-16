package Quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Quiz 
{
	private Question m_question = null;
	
	private String m_questionText = "Wie heise ich?";
	private String[] m_answers = {"Aron", "Felix", "Florian", "Simon"};
	public Quiz()
	{
	}
	
	public void startQuiz()
	{
		Question question = new Question(m_questionText, m_answers, 2);
		System.out.println("Frage: " + m_questionText);
		for(int i = 0; i < m_answers.length; i++)
			System.out.print("["+(i+1)+"] " + m_answers[i] + (i < m_answers.length -1 ? ", " : "\n"));

		question.setGivenAnswer(getUserValue());
		System.out.println(question.isAnswerCorrect());
	}
	
	public int getUserValue()
	{
		BufferedReader lineIn = new BufferedReader(new InputStreamReader(System.in));
		int userAnswer = -1;
		String userInput = ""; 
		while(userAnswer == -1)
		{
			try
			{
				userInput = lineIn.readLine();
			}
			catch(IOException e)
			{
				System.out.println("Konsolenfehler");
			}
			
			try
			{
				userAnswer = Integer.parseInt(userInput);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Geben sie eine Zahl wischen 1 und 4 ein!");
			}
		}
		return userAnswer-1;
	}
}
