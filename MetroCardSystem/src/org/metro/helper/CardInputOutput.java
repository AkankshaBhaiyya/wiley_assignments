package org.metro.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.metro.bean.Card;

public class CardInputOutput {
	public static Card inputCard() {
		Scanner scanner=new Scanner(System.in);
		
		Card card=new Card();
		System.out.println("Enter User email ");
		card.setName(scanner.next());
		card.setSwipeStatus("false");
		card.setAmount(100);
         
		return card;
	}
	public static ArrayList cardSwipeIn()
	{
		Scanner scanner=new Scanner(System.in);
		ArrayList al=new ArrayList();
		System.out.println("Enter card Id ");
		al.add(0,scanner.nextInt());
		System.out.println("Enter Source Station Name");
		al.add(1,scanner.next());
		return al;
	}
	public static ArrayList cardSwipeOut()
	{
		Scanner scanner=new Scanner(System.in);
		ArrayList alo=new ArrayList();
		System.out.println("Enter card Id ");
		alo.add(0,scanner.nextInt());
		System.out.println("Enter destination Station Name");
		alo.add(1,scanner.next());
		return alo;
	}
	public static ArrayList cardRecharge()
	{
		Scanner scanner=new Scanner(System.in);
		ArrayList alr=new ArrayList();
		System.out.println("Enter card Id ");
		alr.add(0,scanner.nextInt());
		System.out.println("Enter amount to recharge");
		alr.add(1,scanner.nextInt());
		return alr;	
	}
	public static int idInput()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter id");
		int idval=scanner.nextInt();
		return idval;
	}
	public static int amountInput()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter amount");
		int amount=scanner.nextInt();
		return amount;
	}
    public static int stationnameInput()
    {
    	Scanner scanner=new Scanner(System.in);
		System.out.println("Enter station id");
		int stid=scanner.nextInt();
		return stid;	
    }
}
