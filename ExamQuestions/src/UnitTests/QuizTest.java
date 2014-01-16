package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import Quiz.Quiz;


public class QuizTest {
	
	private static Quiz m_quiz = null;
	
	@Test
	public void test_Quiz()
	{
		m_quiz = new Quiz();
		assertNotNull(m_quiz);
	}

}
