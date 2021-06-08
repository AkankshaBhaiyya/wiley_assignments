package com.assignment;
import java.util.*;
public class TelephoneMain {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		List<Telephone> telephoneList=new ArrayList<Telephone>();
		System.out.println("Enter number of people whose details you want to add");
		int numberOfPeople=sc.nextInt();
		for(int i=0;i<numberOfPeople;i++)
		{
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter phonenumber");
			Long phoneNumber=sc.nextLong();
			System.out.println("Enter address");
			String address=sc.next();
			Telephone telephone1=new Telephone(name,phoneNumber,address);
			telephoneList.add(telephone1);
		}
		Collections.sort(telephoneList);
		for(Telephone tobject:telephoneList)
		{
			System.out.println(tobject);
		}
	}

}
