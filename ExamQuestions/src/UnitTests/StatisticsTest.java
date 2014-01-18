package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import Quiz.Statistics;

public class StatisticsTest {

	private Statistics m_statistics = new Statistics();

	@Test
	public void test_InitVals() 
	{
		assertEquals(0, m_statistics.getAmountCorrectAnswers());
		assertEquals(0, m_statistics.getAmountTotalQuestions());
	}

	@Test
	public void test_AddCorrectAnswer()
	{
		m_statistics.increaseAmountCorrectAnswer();
		assertEquals(1, m_statistics.getAmountCorrectAnswers());
	}
	
	@Test
	public void test_AddQuestion()
	{
		m_statistics.increaseAmountTotalQuestions();
		assertEquals(1, m_statistics.getAmountTotalQuestions());
	}
	
	@Test
	public void test_ResetStatistics()
	{
		m_statistics.resetAll();
		assertEquals(0, m_statistics.getAmountCorrectAnswers());
		assertEquals(0, m_statistics.getAmountTotalQuestions());
	}
	
	@Test
	public void test_WinLossBalance()
	{
		assertTrue(100 == m_statistics.getWinLossBalance());
		m_statistics.increaseAmountTotalQuestions();
		assertTrue(0 == m_statistics.getWinLossBalance());
		m_statistics.increaseAmountTotalQuestions();
		assertTrue(0 == m_statistics.getWinLossBalance());
		m_statistics.increaseAmountCorrectAnswer();
		assertTrue(50 == m_statistics.getWinLossBalance());
		m_statistics.increaseAmountTotalQuestions();
		assertTrue(33 == Math.round(m_statistics.getWinLossBalance()));
		m_statistics.increaseAmountCorrectAnswer();
		assertTrue(66 == Math.round(Math.abs(m_statistics.getWinLossBalance())));
		m_statistics.increaseAmountCorrectAnswer();
		assertTrue(100 == m_statistics.getWinLossBalance());
	}
}
