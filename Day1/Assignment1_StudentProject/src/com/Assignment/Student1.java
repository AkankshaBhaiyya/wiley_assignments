package com.Assignment;

public class Student1 {
	private Student student[];
	private static int index;
	Student1(int numberOfStudents)
	{
		student=new Student[numberOfStudents];
	}
	public void addStudent(Student student1)
	{
		student[index++]=student1;
	}
	public void setStudent(Student[] student)
	{
		this.student = student;
	}
	public Student getStudent(int index) {
		return student[index];
	}
	/*public void displayRollNumberWise()
	{
		for(int i=0;i<student.length;i++)
		{
			System.out.println(student[i].getName()+" "+student[i].getRollNumber());
		}
	}*/
	
}
