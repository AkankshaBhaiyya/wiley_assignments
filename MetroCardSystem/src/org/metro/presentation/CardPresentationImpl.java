package org.metro.presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import org.metro.bean.Card;
import org.metro.bean.Station;
import org.metro.exception.StationNameException;
import org.metro.exception.TimeExcludedException;
import org.metro.helper.CardInputOutput;
import org.metro.service.CardService;
import org.metro.service.CardServiceImpl;

public class CardPresentationImpl implements CardPresentation {

	private CardService cardService=new CardServiceImpl();
	@Override
	public void showMenu() {
		System.out.println("WELCOME TO METRO CARD SYSTEM");
		System.out.println("1. Register User");
		System.out.println("2. Swipe operation");
		System.out.println("3. Recharge");
		System.out.println("4. Display");
		System.out.println("5. Exit");
	}

	@Override
	public void performMenu(int choice) {
		switch(choice) {
		case 1:try {
			int id=cardService.insertCard(CardInputOutput.inputCard());
			if(id >0) {
				System.out.println("Card created Succefully with id : "+id);
			}
			else
				System.out.println("Card creation Failed");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			break;
		case 2:try {
			int idwrong=0;
			int minamount=0;
			int cardstatus=0;
			int recharge=0;
			Collection<Station> stations=null;	
			while(idwrong==0) {
			int id=CardInputOutput.idInput();
			if(id>0)
			{
				cardstatus=cardService.getCardStatus(id);
				if(cardstatus==0)
				{
					System.out.println("swipein");
					while(recharge==0) {
					minamount=cardService.getServiceCardAmount(id);
					if(minamount>0)
					{
					    stations=cardService.getStations();
					    System.out.format("%-15s%-15s\n","ID","Name");
					    for(Station s:stations)
					    {
					    	System.out.format("%-15s%-15s\n",s.getId(),s.getName());
					    }
					    int sourcestation=CardInputOutput.stationnameInput();
					    int sourcecnt=cardService.getStationId(sourcestation);
					    if(sourcecnt>0)
					    {
					    	String sourcename=cardService.getStationName(sourcestation);
					    	int cnt=cardService.setSourceStation(id,sourcename);
					    	if(sourcename!=null && cnt>0 ) {
					    	System.out.println("Your journey successfully started at "+sourcename);
					    	}
					    }
					    else
					    {
					      throw new StationNameException("You entered wrong ID");	
					    }
						recharge=1;
					}
					else
					{
						int amountwrong=0;
						System.out.println("As you dont have minimum amount please recharge");
						while(amountwrong==0) {
			                int amount=CardInputOutput.amountInput();
			                if(amount>0) {
			                int recharge1=cardService.getRechargeStatus(id,amount);
			                if(recharge1>0) {
			            	 recharge=1;
			            	
			            	idwrong=1;
			            	amountwrong=1;
			            	}
			                else
			                {
			                	System.out.println("Recharge Failed");
			                	idwrong=0;
			                	recharge=0;
			                }
			                }
			                else
			                {
			                	System.out.println("Amount should be positive number");
			                	amountwrong=0;
			                	recharge=0;
			                }
							}
						recharge=0;
					}
					}
				}
				else
				{
					System.out.println("swipeout");
			        int time=cardService.getTimeGap(id);
					stations=cardService.getStations();
					 System.out.format("%-15s%-15s\n","ID","Name");
				    for(Station s:stations)
				    {
				    	System.out.format("%-15s%-15s\n",s.getId(),s.getName());
				    }
				    int sourcestation=CardInputOutput.stationnameInput();
				    int sourcecnt=cardService.getStationId(sourcestation);
				    if(sourcecnt>0)
				    {
				    	String destinationname=cardService.getStationName(sourcestation);
				    	int cnt=cardService.setDestinationStation(id,destinationname);
				    	if(destinationname!=null && cnt>0 ) {
				        if(time==1) {		
				    	System.out.println("Your journey successfully ended at "+ destinationname);
				        }
				        else
				        {
				        	System.out.println("Your journey successfully ended at "+ destinationname+" with Rs 75 fine");
				        }
				    	}
				    }
				    else
				    {
				      throw new StationNameException("You entered wrong ID");	
				    }
				}
				idwrong=1;
			}
			else
			{
			  System.out.println("ID should be positive number");
			  idwrong=0;
			}
			}}
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(StationNameException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		case 3:Card cards=null;
			try {
				
				int  idwrong=0;
				int amountwrong=0;
				while(idwrong==0) {
					int id=CardInputOutput.idInput();
					if(id>0) {
					int idcnt=cardService.getIdcnt(id);
					if(idcnt>0)
					{
						while(amountwrong==0) {
		                int amount=CardInputOutput.amountInput();
		                if(amount>0) {
		                int recharge=cardService.getRechargeStatus(id,amount);
		                if(recharge>0) {
		            	cards = cardService.getCardById(id);
		            	if(cards!=null)
		            	{
		            		System.out.format("%-15s%-15s%-15s%-15s\n","ID","Name","SwipeStatus","Amount");
		            		System.out.format("%-15s%-15s%-15s%-15s\n",cards.getId(),cards.getName(),cards.getSwipeStatus(),cards.getAmount());
		            	}
		            	idwrong=1;
		            	amountwrong=1;
		            	}
		                else
		                {
		                	System.out.println("Recharge Failed");
		                	idwrong=0;
		                }
		                }
		                else
		                {
		                	System.out.println("Amount should be positive number");
		                	amountwrong=0;
		                }
						}
					}
					else
					{
						System.out.println("Entered Id is incorrect");
		            	idwrong=0;
					}
					}
					else
					{
						System.out.println("ID should be positive number");
						idwrong=0;
					}
				}
			}
			catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			if(cards!=null) {
				System.out.println(cards);
			}
			break;
		case 4:
			Card cards1=null;
			try {
				int  idwrong=0;
				while(idwrong==0) {
				int id=CardInputOutput.idInput();
				if(id>0) {
				int idcnt=cardService.getIdcnt(id);
	            if(idcnt > 0) {
	            idwrong=1;
				cards1 = cardService.getCardById(id);
				
				}
	            else
	            {
	            	System.out.println("Entered Id is incorrect");
	            	idwrong=0;
	            }}
				else
				{
					System.out.println("Id should be positive number");
				 	idwrong=0;
				}
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			if(cards1!=null) {
				System.out.format("%-15s%-15s%-15s%-15s\n","ID","Name","SwipeStatus","Amount");
				System.out.format("%-15s%-15s%-15s%-15s\n",cards1.getId(),cards1.getName(),cards1.getSwipeStatus(),cards1.getAmount());
		
			}
			break;
		case 5:
			System.out.println("Thanks for using Metro Card System!!!");
			System.exit(0);
			break;
		default :
			System.out.println("Invalid Choice");
		}

	}

}
