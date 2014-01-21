package Quiz.EventHandling;

import java.util.EventListener;
import java.util.EventObject;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.21.14
 */
public interface StatisticsListener extends EventListener{
	public void handleQuizEvent(EventObject e);
}
