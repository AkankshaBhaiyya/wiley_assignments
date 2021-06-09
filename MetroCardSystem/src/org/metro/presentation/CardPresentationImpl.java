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
		System.out.println("2. Swipe in");
		System.out.println("3. Swipe out");
		System.out.println("4. Recharge");
		System.out.println("5. Display Details Of Particular card");
		System.out.println("6. Display list of stations");
		System.out.println("7. Exit");
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
		case 2:try {
			String swipeResult=cardService.swipeInCard(CardInputOutput.cardSwipeIn());
			System.out.println(swipeResult);
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
			break;
		case 3:try {
			String swipeResult=cardService.swipeOutCard(CardInputOutput.cardSwipeOut());
			System.out.println(swipeResult);
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
			break;
		case 4:
			try {
			String recharge=cardService.rechargeCard(CardInputOutput.cardRecharge());
			System.out.println(recharge);
			}
			catch(ClassNotFoundException | SQLException e)
			{
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			Card cards=null;
			try {
				cards = cardService.getCardById(CardInputOutput.idInput());
			} catch (ClassNotFoundException | SQLException e) {
				
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
				System.out.println(cards);
		
			break;
		case 6:Collection<Station> stations=null;
		try {
			stations = stationService.getAllStations();
		} catch (ClassNotFoundException | SQLException e) {
			
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		for(Station station:stations) {
			System.out.println(station);
		}
			break;
		case 7:
			System.out.println("Thanks for using Metro Card System!!!");
			System.exit(0);
		default :
			System.out.println("Invalid Choice");
		}

	}

}
