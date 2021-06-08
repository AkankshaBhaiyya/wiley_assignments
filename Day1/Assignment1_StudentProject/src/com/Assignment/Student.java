package com.Assignment;

public class Student {
	private static int rollNumber=0;
	private String name;
	private int englishMarks,mathsMarks,scienceMarks;
	public Student(String name, int englishMarks, int mathsMarks, int scienceMarks) {
		super();
		rollNumber++;
				this.name = name;
		this.englishMarks = englishMarks;
		this.mathsMarks = mathsMarks;
		this.scienceMarks = scienceMarks;
	}
	
	public  int getRollNumber() {
		return rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnglishMarks() {
		return englishMarks;
	}
	public void setEnglishMarks(int englishMarks) {
		this.englishMarks = englishMarks;
	}
	public int getMathsMarks() {
		return mathsMarks;
	}
	public void setMathsMarks(int mathsMarks) {
		this.mathsMarks = mathsMarks;
	}
	public int getScienceMarks() {
		return scienceMarks;
	}
	public void setScienceMarks(int scienceMarks) {
		this.scienceMarks = scienceMarks;
	}

}
