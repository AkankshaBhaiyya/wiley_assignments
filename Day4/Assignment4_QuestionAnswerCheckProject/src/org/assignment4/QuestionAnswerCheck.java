package org.assignment4;
import java.util.Scanner;

public class QuestionAnswerCheck extends Exception {
	public boolean flag=false;
	synchronized void showQuestion(String question) {
		if(flag==true) {
			try {
				wait(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Enter answer for :"+question);
		
		flag=true;
		
		notify();
	}
	synchronized void takeAnswer(String answer) {
		if(flag==false) {
			try {
				wait(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Scanner scanner=new Scanner(System.in);
		String useranswer=" ";
		useranswer=scanner.next();
		

			if(answer.equals(useranswer)==false) {
				System.out.println("You got failed");
				System.exit(0);

			}
			flag=false;
		notify();
	}

}
