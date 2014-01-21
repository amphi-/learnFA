package Quiz;

import Quiz.EventHandling.QuizEventListener;
import Quiz.EventHandling.StatisticsEventListener;
import Utility.Funktions;

/**
 * @author olaffthunder
 * @version 1.0
 * @lastChanged 01.21.14
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
			String []answers = new String[m_answers.length];
			for(int i = 0; i < m_answers.length; i++)
				answers[i] = m_answers[i];
			Question question = new Question(m_questionText, answers, 2);
			statistics.increaseAmountTotalQuestions();
			question.addEventListener(new QuizEventListener(this));
			question.addEventListener(new StatisticsEventListener(statistics));

			System.out.println("Frage: " + question.getQuestion());
			answers = question.getAnswers();
			printQuestion(answers);
			question.answer();
			outputAnswerResult();
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
		for(int i = 0; i < answers.length; i++)
			System.out.print("["+(i+1)+"] " + answers[i] + (i < answers.length -1 ? ", " : "\n"));
	}
	
	public void setResult(boolean correctAnswer)
	{
		m_correctAnswer = correctAnswer;
	}
}
