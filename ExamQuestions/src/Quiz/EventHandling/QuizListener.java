package Quiz.EventHandling;

import java.util.EventListener;
import java.util.EventObject;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.19.14
 */
public interface QuizListener extends EventListener{
	public void handleQuizEvent(EventObject e);
}
