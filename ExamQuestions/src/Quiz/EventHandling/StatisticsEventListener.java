package Quiz.EventHandling;

import java.util.EventObject;

import Quiz.Statistics;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.21.14
 */
public class StatisticsEventListener implements StatisticsListener{

	private Statistics m_statistic = null;
	
	public StatisticsEventListener(Statistics statistic) 
	{
		m_statistic = statistic;
	}
	
	@Override
	public void handleQuizEvent(EventObject e) 
	{
		if(e instanceof AnswerEvent == true)
			m_statistic.increaseAmountCorrectAnswer();
	}
}
