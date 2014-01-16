package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import Quiz.Question;

public class QuestionTest {
	final private String m_questionText = "Frage";
	final private String[] answers = {"true", "false", "false", "false"};
	private static Question m_question = null;
	
	@Test
	public void test_Question()
	{
		m_question = new Question(m_questionText, answers, 0);
		assertNotNull(m_question);
	}
		
	@Test
	public void test_correctAnswer()
	{
		m_question.setGivenAnswer(0);
		assertTrue(m_question.isAnswerCorrect());
		m_question.setGivenAnswer(1);
		assertFalse(m_question.isAnswerCorrect());	
	}
	
	
}
