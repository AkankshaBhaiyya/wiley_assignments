package org.metro.service;

import java.sql.SQLException;

import java.util.ArrayList;

import org.metro.bean.Card;
import org.metro.bean.Journey;
import org.metro.persistence.CardDao;
import org.metro.persistence.CardDaoImpl;
import org.metro.persistence.StationDao;
import org.metro.persistence.StationDaoImpl;
import org.metro.persistence.JourneyDao;
import org.metro.persistence.JourneyDaoImpl;
public class CardServiceImpl implements CardService{
	private CardDao cardDao=new CardDaoImpl();
	private StationDao stationDao=new StationDaoImpl();
	private JourneyDao journeyDao=new JourneyDaoImpl();
	private static String sourceStationName="";
	private static String sourceStationNameU="";
	@Override
	public int insertCard(Card card) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return cardDao.insertCardRecord(card);
	}
	
	@Override
	public int rechargeCard(int amount,int idval) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
	
		int countR=cardDao.rechargeCardAmount(amount,idval);
		if(countR>0) {
		return 1;
		}
		return 0;
	}
	@Override
	public Card getCardById(int id) throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		return cardDao.getRecordsById(id);
	}
	@Override
	public int getCardIdCount(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int idcount=cardDao.getCountId(id);
		return idcount;
	}
	@Override
	public boolean getCardSwipeStatus(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String statusVal=cardDao.getCardSwipeStatus(id);
		if(statusVal.equals("true")) {
		return true;}
		return false;
	}
	@Override
	public int setSwipeIn(String stationName, int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		if(cardDao.setcardSwipeStatus(id,"true")>0)
		{
			int idcnt=journeyDao.getJourneyCardId(id);
			if(idcnt>0)
			{
				int cnt=journeyDao.updateJourneyCardId(id,stationName,"");
			}
			else {
			Journey journey=new Journey(id,stationName,"");
		    int cnt=journeyDao.insertJourneyRecord(journey);
			
			}
			return 1;
		}
		return 0;
	}
	@Override
	public int getAmountInfo(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int amount=cardDao.getCardAmount(id);
		return amount;
	}
	@Override
	public int checkStationName(String stationName) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return stationDao.getStationNameCount(stationName);
	}
	@Override
	public int setSwipeOut(String stationName, int id1) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String name=journeyDao.getRecordName(id1);
	
		int sourceStationId=stationDao.getStationId(name);
		
		int destinationStationId=stationDao.getStationId(stationName);
		int minus;
		if(sourceStationId > destinationStationId)
		{
			minus=sourceStationId - destinationStationId;
		}
		else
		{
			minus= destinationStationId-sourceStationId;
		}
		int updatedCardAmount=cardDao.updateCardAmount(id1,minus*5);
		int updatedSwipeStatus=cardDao.setcardSwipeStatus(id1,"false");
		if(updatedSwipeStatus >0 && updatedCardAmount>0)
		{
			int n=journeyDao.setDestinationStation(id1,stationName);
			return 1;
		}
		sourceStationNameU="";
		return 0;
	}

}
