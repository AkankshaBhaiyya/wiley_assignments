package org.assignment4;

public class QAMain {

	public static void main(String[] args) {
		QuestionAnswerCheck qacheck=new QuestionAnswerCheck();
		Thread qjob=new Thread(new QuestionJob(qacheck));
		Thread ajob=new Thread(new AnswersJob(qacheck));
		qjob.start();
		ajob.start();
	}

}
