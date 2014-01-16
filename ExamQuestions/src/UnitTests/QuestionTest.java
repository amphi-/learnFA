package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import Quiz.Question;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.16.14
 */
public class QuestionTest {
	final private String m_questionText = "Frage";
	final private String[] m_answers = {"true", "false", "false", "false"};
	private static Question m_question = null;
	
	@Test
	public void test_Question()
	{
		m_question = new Question(m_questionText, m_answers, 0);
		assertNotNull(m_question);
	}
		
	@Test
	public void test_correctAnswer()
	{
		assertTrue(m_question.isAnswerCorrect(0));
		assertFalse(m_question.isAnswerCorrect(1));	
	}
	
	@Test
	public void test_givenAnswers()
	{
		for(int i = 0; i < m_answers.length; i++)
		{
			if(i == 0)
				assertTrue(m_answers[i] == "true");
			else
				assertTrue(m_answers[i] == "false");
		}
	}
}
