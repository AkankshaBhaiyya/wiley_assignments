package org.metro.presentation;

import java.sql.SQLException;

import java.util.Collection;

import org.metro.bean.Card;
import org.metro.helper.CardInputOutput;
import org.metro.service.CardService;
import org.metro.service.CardServiceImpl;
import org.metro.service.StationService;
import org.metro.service.StationServiceImpl;


import org.metro.bean.Station;

import org.metro.helper.CardInputOutput;

public class CardPresentationImpl implements CardPresentation {

	private CardService cardService=new CardServiceImpl();
	private StationService stationService=new StationServiceImpl();
	@Override
	public void showMenu() {
		System.out.println("***************************************");
		System.out.println("WELCOME TO METRO CARD SYSTEM");
		System.out.println("1. Register User");
		System.out.println("2. Perform swipe operation");
		System.out.println("3. Recharge");
		System.out.println("4. Display Details Of Particular card");
		System.out.println("5. Display list of stations");
		System.out.println("6. Exit");
		System.out.println("***************************************");
	}

	@Override
	public void performMenu(int choice) {
		switch(choice) {
		case 1:try {
			int idval=cardService.insertCard(CardInputOutput.inputCard());
			if(idval > 0)
				System.out.println("Your card id is : "+ idval);
			else
				System.out.println("Card creation Failed");
		} catch (ClassNotFoundException | SQLException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
			break;
		case 2: try {
			int cnt=0,cnt3=0,cnt2=0;
			do {
			int idval=CardInputOutput.idInput();
			int idCount=cardService.getCardIdCount(idval);
			if(idCount>0)
			{  
				boolean swipeStatus=cardService.getCardSwipeStatus(idval);
				if(swipeStatus==false)
				{
					do {
					int getMinAccount=cardService.getAmountInfo(idval);
					if(getMinAccount>=100) {
					do {
					System.out.println("*********************");
					Collection<Station> stations1=null;
					stations1 = stationService.getAllStations();
					System.out.format("%-20s %-20s\n","Station Id","Station Name");
					for(Station station:stations1) {
						 
						   System.out.format("%-20s %-20s\n",station.getId(),station.getName());
						
					}
					System.out.println("*********************");
					System.out.println("PLEASE perform SWIPE IN");
					String stationName=CardInputOutput.inputStationName();
					int stationNameCheck=cardService.checkStationName(stationName);
					
					if(stationNameCheck > 0)
					{
						int swipeupdate=cardService.setSwipeIn(stationName,idval);
						if(swipeupdate>0) {
						System.out.println("Your journey succesfully started at "+stationName);
						cnt=0;
						cnt2=0;
						cnt3=0;
						}
						else
						{
							System.out.println("Error occured while updating swipestatus");
						}
					}
					else
					{
					   System.out.println("Please enter correct station name");	
					   cnt3=1;
					}
					}while(cnt3==1);
					}
					else
					{
						System.out.println("You have to recharge as you dont have minimum amount in your card");
						int acnt=0;
						do {
	            				int amount=CardInputOutput.cardRecharge();
	            				if(amount>0) {
	            					
	            					int recharge=cardService.rechargeCard(amount,idval);
	            					System.out.println("Successfully Recharged");
	            					cnt2=1;
	            					cnt3=1;
	            				}
	            				else
	            				{
	            					System.out.println("Enter amount greater than 0");
			    	                acnt=1;
	            				}
	            			  }while(acnt==1);
					}
					}while(cnt2==1);
				}
				else if(swipeStatus==true)
				{
				
					do {
					System.out.println("*********************");
					Collection<Station> stations1=null;
					stations1 = stationService.getAllStations();
					System.out.format("%-20s %-20s\n","Station Id","Station Name");
					for(Station station:stations1) {
						 
						   System.out.format("%-20s %-20s\n",station.getId(),station.getName());
						
					}
					System.out.println("*********************");
					System.out.println("PLEASE perform SWIPE OUT");
					String stationName1=CardInputOutput.inputStationName();
					int stationNameCheck1=cardService.checkStationName(stationName1);
					
					if(stationNameCheck1 > 0)
					{
						int swipeupdate1=cardService.setSwipeOut(stationName1,idval);
						if(swipeupdate1>0) {
						System.out.println("Your journey succesfully ended at "+stationName1);
						cnt=0;
						cnt3=0;
						}
						else
						{
							System.out.println("Error occured while updating account");
						}
					}
					else
					{
					   System.out.println("Please enter correct station name");
					   cnt3=1;
					   
					}
					}while(cnt3==1);
				}
			}
			else
			{
				System.out.println("Sorry your card id is incorrect");
				cnt=1;
			}
			}while(cnt==1);//////////////////////////////////////////////////////////////////
			}
			catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			try {
				int cnt=0,cnt2=0;
	            do {
	            		int idval=CardInputOutput.idInput();
	            		int idCount=cardService.getCardIdCount(idval);
	            		if(idCount>0) {
	            			  do {
	            				int amount=CardInputOutput.cardRecharge();
	            				if(amount>0) {
	            					int recharge=cardService.rechargeCard(amount,idval);
	            					System.out.println("Successfully Recharged");
	            					Card cards=null;
	            					cards = cardService.getCardById(idval);
	            					if(cards!=null) {
	            						 System.out.format("%-20s %-20s %-20s %-20s\n","Card Id","Name","SwipeStatus","Amount");
	            						   System.out.format("%-20s %-20s %-20s %-20s\n",cards.getId(),cards.getName(),cards.getSwipeStatus(),cards.getAmount());
	            						
	            					     }
	            					cnt2=0;
	            					cnt=0;
	            				}
	            				else
	            				{
	            					System.out.println("Enter amount greater than 0");
			    	                cnt2=1;
	            				}
	            			  }while(cnt2==1);
	            		}
	            		else
	            		{
	            			System.out.println("Sorry your card id is incorrect");
	            			cnt=1;
	            		}
				}while(cnt==1);
				
			}
			catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			Card cards=null;
			try {
				int cnt=0;
				do {
				int idval=CardInputOutput.idInput();
				int idCount=cardService.getCardIdCount(idval);
				if(idCount>0) {
				cards = cardService.getCardById(idval);
				}
				else
				{
					System.out.println("Sorry your card id is incorrect");
					cnt=1;
				}
				}while(cnt==1);
			} catch (ClassNotFoundException | SQLException e) {
				
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
			   if(cards!=null) {
				   System.out.format("%-20s %-20s %-20s %-20s\n","Card Id","Name","SwipeStatus","Amount");
				   System.out.format("%-20s %-20s %-20s %-20s\n",cards.getId(),cards.getName(),cards.getSwipeStatus(),cards.getAmount());
				}
			   else
			   {
				   System.out.println("This is was eliminated becuase of entering duplicate name");
			   }
		
			break;
		case 5:Collection<Station> stations=null;
		try {
			stations = stationService.getAllStations();
		} catch (ClassNotFoundException | SQLException e) {
			
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.format("%-20s %-20s\n","Station Id","Station Name");
		for(Station station:stations) {
			 
			   System.out.format("%-20s %-20s\n",station.getId(),station.getName());
			
		}
			break;
	
		case 6:
			System.out.println("Thanks for using Metro Card System!!!");
			System.exit(0);
		default :
			System.out.println("Invalid Choice");
		}

	}

}
