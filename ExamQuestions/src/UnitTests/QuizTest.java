package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import Quiz.Quiz;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.16.14
 */
public class QuizTest {
	
	private static Quiz m_quiz = null;
	
	@Test
	public void test_Quiz()
	{
		m_quiz = new Quiz();
		assertNotNull(m_quiz);
	}

}
