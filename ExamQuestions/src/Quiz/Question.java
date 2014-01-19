package Quiz;

import Quiz.EventHandling.QuizEventSource;


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
	}
	
	private void shuffleAnswers()
	{
	//TODO funktioniert doch noch nicht-.-"
		String[] tmpAnswer = new String[MAXANSWERS];
		String tmpAnswerText = "";		
		int newCorrectAnswer = randomPosition()%MAXANSWERS;
		tmpAnswer[newCorrectAnswer] = m_answers[m_correctAnswer];
		m_answers[m_correctAnswer] = null;
		
		for(int tmpCount = 0; tmpCount < tmpAnswer.length;)
		{
			int pos = randomPosition() % m_answers.length;
			if(m_answers[pos] == null)
				continue;
			
			if(tmpCount == m_correctAnswer)
			{
				tmpCount++;
				continue;
			}
			
			tmpAnswerText = m_answers[pos];

			int newPos = randomPosition() % 4;
			
			if(tmpAnswer[newPos] != null)
				continue;
			
			tmpAnswer[newPos] = tmpAnswerText;
			m_answers[pos] = null;
			tmpCount++;
		}

		m_correctAnswer = newCorrectAnswer;
		m_answers = tmpAnswer;
	}

	private int randomPosition()
	{
		return (int)(Math.random() *100);
	}		
	
	public boolean isAnswerCorrect(int givenAnswer)
	{
		if(m_correctAnswer == -1)
			return false;
		return givenAnswer == m_correctAnswer;
	}
	
	public void answer(int givenAnswer, QuizEventSource quizSource)
	{		
		quizSource.answerEvent(isAnswerCorrect(givenAnswer));
	}
	
	public String getQuestion()
	{
		return m_questionText;
	}
	
	public String[] getAnswers()
	{
		return m_answers;
	}

}
