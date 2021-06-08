import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CDTwoMain {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		List<CDTwo> cdtwo=new ArrayList<CDTwo>();
		System.out.println("Enter number of people whose details you want to add");
		int numberOfPeople=sc.nextInt();
		for(int i=0;i<numberOfPeople;i++)
		{
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter title");
			String title=sc.next();
			CDTwo cObj=new CDTwo(name,title);
			cdtwo.add(cObj);
		}
		Collections.sort(cdtwo);
		for(CDTwo name:cdtwo)
		{
			System.out.println(name);
		}
	}

}