package Quiz;

public class Question
{
	
	private String m_questionText = "";
	private String[] m_answers = new String[4];
	private int m_givenAnswer = -1;
	private int m_correctAnswer = -1;
	public Question(String question, String[] answers, int correctAnswer)
	{
		for(int i = 0; i < answers.length; i++)
			m_answers[i] = answers[i];
		m_questionText = question;
		m_correctAnswer = correctAnswer;
	}
	
	public void setGivenAnswer(int givenAnswer)
	{
		m_givenAnswer = givenAnswer;
	}
	
	public boolean isAnswerCorrect()
	{
		if(m_givenAnswer == -1 || m_correctAnswer == -1)
			return false;
		if(m_givenAnswer == m_correctAnswer)
			return true;
		return false;
	}
	
}
