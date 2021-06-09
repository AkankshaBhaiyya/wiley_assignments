package org.metro.client;

import java.util.Scanner;

import org.metro.presentation.CardPresentation;
import org.metro.presentation.CardPresentationImpl;

public class MetroMain {
public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		CardPresentation presentation=new CardPresentationImpl();
		while(true) {
			presentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=sc.nextInt();
			presentation.performMenu(choice);
		}
		

	}

}
