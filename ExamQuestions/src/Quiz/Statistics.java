package Quiz;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.19.14
 */
public class Statistics 
{
	int m_questionsTotal = 0;
	int m_questionsCorrect = 0;

	public Statistics() 
	{
	}

	public Object getAmountCorrectAnswers() 
	{
		return m_questionsCorrect;
	}

	public Object getAmountTotalQuestions() 
	{
		return m_questionsTotal;
	}

	public void increaseAmountCorrectAnswer() 
	{
		m_questionsCorrect++;
	}

	public void increaseAmountTotalQuestions() 
	{
		m_questionsTotal++;
	}

	public float getWinLossBalance() 
	{
		if(m_questionsCorrect == m_questionsTotal )
			return 100.f;
		if(m_questionsCorrect == 0)
			return 0.f;
		int result = (int)((float)m_questionsCorrect/m_questionsTotal*100*100);
		return result/100;
	}

	public void resetAll() 
	{
		m_questionsCorrect = 0;
		m_questionsTotal = 0;
	}
	
	public void outputAll()
	{
		System.out.println("Amount of Questions correct answered: "+m_questionsCorrect);
		System.out.println("Total amount of Questions taken: "+m_questionsTotal);
		System.out.println("That's "+getWinLossBalance()+"% in correct");
	}
}
