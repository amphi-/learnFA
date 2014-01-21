package Quiz;

import java.util.EventListener;
import Quiz.EventHandling.QuizEventSource;
import Utility.Funktions;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.19.14
 */
public class Question
{
	private String m_questionText = "";
	private String[] m_answers = new String[0];
	private int m_correctAnswer = -1;
	private final int MAXANSWERS = 4;
	private QuizEventSource m_eventSource = null;
	
	/**
	 * Creates a new Question with it's answers. Also shuffles the order of answers.
	 * 
	 * @param question - The Question
	 * @param answers  - Possible answers - only the first 4 would be taken
	 * @param correctAnswer - the id of the correct answer
	*/
	public Question(String question, String[] answers, int correctAnswer)
	{
		m_answers = answers;
		m_questionText = question;
		m_correctAnswer = correctAnswer;
		shuffleAnswers();
		m_eventSource = new QuizEventSource();
	}
	
	private void shuffleAnswers()
	{
		String[] tmpAnswer = new String[MAXANSWERS];
		int newCorrectAnswer = Funktions.randomPosition()%MAXANSWERS;
		tmpAnswer[newCorrectAnswer] = m_answers[m_correctAnswer];
		m_answers[m_correctAnswer] = null;
		m_correctAnswer = newCorrectAnswer;

		for(int tmpCount = 1; tmpCount < tmpAnswer.length;)
		{
			int pos = Funktions.randomPosition() % m_answers.length;
			while(m_answers[pos] == null)
				pos = Funktions.randomPosition() % m_answers.length;
			
			int newPos = Funktions.randomPosition() % tmpAnswer.length;
			while(tmpAnswer[newPos] != null)
				newPos = Funktions.randomPosition() % 4;
							
			tmpAnswer[newPos] = m_answers[pos];;
			m_answers[pos] = null;
			tmpCount++;
		}
		m_answers = tmpAnswer;
	}

	
	public boolean isAnswerCorrect(int givenAnswer)
	{
		if(m_correctAnswer == -1)
			return false;
		return givenAnswer == m_correctAnswer;
	}
	
	public void answer()
	{		
		int givenAnswer = Funktions.getUserValue();
		m_eventSource.answerEvent(isAnswerCorrect(givenAnswer));
	}
	
	public String getQuestion()
	{
		return m_questionText;
	}
	
	public String[] getAnswers()
	{
		return m_answers;
	}

	public void addEventListener(EventListener listener)
	{
		m_eventSource.addEventListener(listener);
	}
}
