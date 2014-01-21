package Quiz.EventHandling;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.19.14
 */
public class QuizEventSource {
	private ArrayList<EventListener> m_listeners = new ArrayList<EventListener>();
	
	public synchronized void addEventListener(QuizEventListener listener)
	{
		m_listeners.add(listener);
	}
	
	public synchronized void removeEventListener(QuizEventListener listener)
	{
		m_listeners.remove(listener);
	}
		
	public synchronized void answerEvent(boolean correctAnswer)
	{
		AnswerEvent qEvent = new AnswerEvent(correctAnswer);
		Iterator<EventListener> it = m_listeners.iterator();
		while(it.hasNext())
			((QuizEventListener) it.next()).handleQuizEvent(qEvent);
	}
}
