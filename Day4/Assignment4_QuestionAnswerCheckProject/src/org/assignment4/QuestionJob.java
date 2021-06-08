package org.assignment4;

public class QuestionJob implements Runnable {

	private String[] questions= {"Question1","Question2","Question3","Question4","Question5","Question6","Question7","Question8","Question9","Question10"};
	private QuestionAnswerCheck qacheck;
	
	public QuestionJob(QuestionAnswerCheck qacheck)
	{
		this.qacheck=qacheck;
	}
	@Override
	public void run() {
		for(int i=0;i<questions.length;i++) {
		qacheck.showQuestion(questions[i]);
		}
		
	}

}
