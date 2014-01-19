package Quiz;

import Quiz.EventHandling.QuizEventListener;
import Quiz.EventHandling.QuizEventSource;
import Utility.Funktions;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.19.14
 */
public class Quiz 
{
	private String m_questionText = "Wie heise ich?";
	private String[] m_answers = {"Aron", "Felix", "Florian", "Simon"};
	private boolean m_correctAnswer = false;
	
	public Quiz()
	{
	}
	
	public void startQuiz()
	{
		Statistics statistics = new Statistics();
		do {
			Question question = new Question(m_questionText, m_answers, 2);
			statistics.increaseAmountTotalQuestions();
			QuizEventSource handler = new QuizEventSource();
			handler.addEventListener(new QuizEventListener(this));

			System.out.println("Frage: " + question.getQuestion());
			m_answers = question.getAnswers();
			printQuestion(m_answers);
			int bla = Funktions.getUserValue();
			System.out.println(bla);
			question.answer(bla, handler);
			outputAnswerResult();
			if(m_correctAnswer)
				statistics.increaseAmountCorrectAnswer();
			System.out.println("Do another Question? (y/n)");
		} while (Funktions.validConsoleInput().equals("y"));

		statistics.outputAll();
	}
		
	private void outputAnswerResult() 
	{
		if(m_correctAnswer)
		{
			System.out.println("This answer was correct!");
			return;
		}
		System.out.println("This answer was wrong!");		
	}
	
	private void printQuestion(String[] answers)
	{
		for(int i = 0; i < m_answers.length; i++)
			System.out.print("["+(i+1)+"] " + m_answers[i] + (i < m_answers.length -1 ? ", " : "\n"));
	}
	
	public void setResult(boolean correctAnswer)
	{
		m_correctAnswer = correctAnswer;
	}
}
