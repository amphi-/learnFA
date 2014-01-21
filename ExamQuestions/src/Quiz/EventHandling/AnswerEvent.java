package Quiz.EventHandling;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.19.14
 */
public class AnswerEvent extends java.util.EventObject{

	private boolean m_correctAnswer = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnswerEvent(boolean correctAnswer) 
	{
		super(correctAnswer);
		m_correctAnswer = correctAnswer;
	}
	
	public boolean isAnswerCorrect()
	{
		return m_correctAnswer;
	}
}
