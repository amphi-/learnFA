package Quiz.EventHandling;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.21.14
 */
public class QuizEventSource {
	private ArrayList<EventListener> m_listeners = new ArrayList<EventListener>();
	
	public synchronized void addEventListener(EventListener listener)
	{
		m_listeners.add(listener);
	}
	
	public synchronized void removeEventListener(EventListener listener)
	{
		m_listeners.remove(listener);
	}
		
	public synchronized void answerEvent(boolean correctAnswer)
	{
		AnswerEvent qEvent = new AnswerEvent(correctAnswer);
		Iterator<EventListener> it = m_listeners.iterator();
		while(it.hasNext())
		{
			Object event = it.next();
			if(event instanceof QuizEventListener)
				((QuizEventListener) event).handleQuizEvent(qEvent);
			if(event instanceof StatisticsListener)
				((StatisticsListener) event).handleQuizEvent(qEvent);
		}
	}
}
