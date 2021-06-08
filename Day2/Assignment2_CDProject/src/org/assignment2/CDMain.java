package org.assignment2;
import java.util.Scanner;
public class CDMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of Singers");
		int numberOfSingers=sc.nextInt();
		for(int i=0;i<numberOfSingers;i++)
		{
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter title");
			String title=sc.next();
		    CD cd=new CD(name,title);
		    if(i==numberOfSingers-1) {
		    cd.displayCD();
		    }
		}
		
	}

}
