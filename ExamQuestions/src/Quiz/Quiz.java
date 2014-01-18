package Quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.16.14
 */
public class Quiz 
{
	@SuppressWarnings("unused") //Eigentlich mault nur der JIT-Compiler dass ich das ned nutze...
	private Question m_question = null;
	private String m_questionText = "Wie heise ich?";
	private String[] m_answers = {"Aron", "Felix", "Florian", "Simon"};

	public Quiz()
	{
	}
	
	public void startQuiz()
	{
		Question question = new Question(m_questionText, m_answers, 2);
		System.out.println("Frage: " + question.getQuestion());
		m_answers = question.getAnswers(); //TODO das hier ist nur ne schnelle Lösung gewesen! Muss sauber gestaltet werden!!!
		for(int i = 0; i < m_answers.length; i++)
			System.out.print("["+(i+1)+"] " + m_answers[i] + (i < m_answers.length -1 ? ", " : "\n"));

		System.out.println(question.isAnswerCorrect(getUserValue()));
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
