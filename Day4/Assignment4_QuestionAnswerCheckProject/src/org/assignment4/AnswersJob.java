package org.assignment4;

public class AnswersJob  implements Runnable {

	private String[] answers= {"Answer1","Answer2","Answer3","Answer4","Answer5","Answer6","Answer7","Answer8","Answer9","Answer10"};
	private QuestionAnswerCheck qacheck;
	
	public AnswersJob(QuestionAnswerCheck qacheck)
	{
		this.qacheck=qacheck;
	}
	@Override
	public void run() {
		
		for(int i=0;i<answers.length;i++)
		{
			qacheck.takeAnswer(answers[i]);
		}
	}

}
