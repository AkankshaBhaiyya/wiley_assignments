package com.Assignment;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Standard s1=new Standard("A",90,10,100);
		Standard s2=new Standard("B",80,90,100);
		Standard s3=new Standard("C",100,100,100);
		Standard s4=new Standard("D",70,80,90);
		Standard s5=new Standard("E",67,80,95);
		Standard s6=new Standard("F",85,90,88);
		Standard s7=new Standard("G",67,87,98);
		Standard s8=new Standard("H",60,80,90);
		System.out.println("Highest percentage Student");
		s8.display();
		System.out.println("Student who scrored highest in maths");
		
		s1.maxmaths();
		System.out.println("All students");
		
		s1.displayRollNoWise();
		System.out.println("Enter number of Students");
		int numberOfStudents=sc.nextInt();
		Student1 student1=new Student1(numberOfStudents);
		for(int i=0;i<numberOfStudents;i++)
		{
			String name;
			int em,mm,sm;
			System.out.println("Enter name");
			name=sc.next();
			System.out.println("Enter english marks");
			em=sc.nextInt();
			System.out.println("Enter maths marks");
			mm=sc.nextInt();
			System.out.println("Enter science marks");
			sm=sc.nextInt();
			Student student=new Student(name,em,mm,sm);
		}
		
		//student1.displayRollNumberWise();
	}

}
