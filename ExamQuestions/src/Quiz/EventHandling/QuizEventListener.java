package Quiz.EventHandling;

import java.util.EventObject;

import Quiz.Quiz;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.19.14
 */
public class QuizEventListener implements QuizListener{

	private Quiz m_quiz = null;
	
	public QuizEventListener(Quiz quiz) 
	{
		m_quiz = quiz;
	}
	
	@Override
	public void handleQuizEvent(EventObject e) 
	{
		if(e instanceof AnswerEvent == false)
			return;
		AnswerEvent answerEvent = (AnswerEvent)e;
		m_quiz.setResult(answerEvent.isAnswerCorrect());
	}	
}
