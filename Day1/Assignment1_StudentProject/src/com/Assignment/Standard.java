package com.Assignment;

public class Standard extends Student{
	static int[] rollNumbers=new int[8];
	static String[] names= new String[8];
	static int[] m1=new int[8];
	static int[] m2=new int[8];
	static int[] m3=new int[8];
	static int[] total=new int[8];
	static int i=0;
	Standard(String name,int em,int mm,int sm)
	{
		super(name,em,mm,sm);
		rollNumbers[i]=super.getRollNumber();
		names[i]=super.getName();
		m1[i]=super.getEnglishMarks();
		m2[i]=super.getMathsMarks();
		m3[i]=super.getScienceMarks();
		total[i]=m1[i]+m2[i]+m3[i];
		i++;
	}
	public void display()
	{
	int max=total[0];
	int val=0;
	for(int k=0;k<total.length;k++)
	{
		if(total[k]>max)
		{
			max=total[k];
			val=k;
		}
	}
	System.out.print(rollNumbers[val]+"\t");
	System.out.println(names[val]);
	}
	public void maxmaths()
	{
		int max=m2[0];
		int val=0;
		for(int i=0;i<m2.length;i++)
		{
			if(m2[i]>max)
			{
				max=m2[i];
				val=i;
			}
		}
		System.out.print(rollNumbers[val]+"\t");
		System.out.println(names[val]);
	}
	public void displayRollNoWise()
	{
		for(int i=0;i<m2.length;i++)
		{
			System.out.print(rollNumbers[i]+"\t");
			System.out.println(names[i]);
		
		}
	}
	
}
