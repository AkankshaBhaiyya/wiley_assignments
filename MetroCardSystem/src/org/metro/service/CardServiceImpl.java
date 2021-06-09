package org.metro.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.metro.bean.Card;

import org.metro.persistence.CardDao;
import org.metro.persistence.CardDaoImpl;
import org.metro.persistence.StationDao;
import org.metro.persistence.StationDaoImpl;
public class CardServiceImpl implements CardService{
	private CardDao cardDao=new CardDaoImpl();
	private StationDao stationDao=new StationDaoImpl();
	private static String sourceStationName="";
	@Override
	public int insertCard(Card card) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return cardDao.insertCardRecord(card);
	}
	@Override
	public String swipeInCard(ArrayList al) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int id=(Integer)al.get(0);
		int ch=0;
		String sourceStation=(String)al.get(1);
		int idverify=cardDao.getCountId(id);
		if(idverify<=0)
			return "Please enter valid id";
		String swipeStatus=cardDao.getCardSwipeStatus(id);
		if(swipeStatus.equals("true"))
			return "Your card is not swiped out";
		int amount=cardDao.getCardAmount(id);
		if(amount<20)
			return "Please recharge and then swipe in";
		int count=stationDao.getStationNameCount(sourceStation);
		if(count<=0)
			return "please enter valid station name";
		int updatedSwipeStatus=cardDao.setcardSwipeStatus(id,"true");
		if(updatedSwipeStatus>0)
		{
			sourceStationName=sourceStation;
		}
		return "Successfully started your journey";
	}
	@Override
	public String swipeOutCard(ArrayList alo) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int id1=(Integer)alo.get(0);
		String destinationStation=(String)alo.get(1);
		String swipeStatus1=cardDao.getCardSwipeStatus(id1);
		
		if(swipeStatus1.equals("false"))
			return "Your card is not swiped in";
		int count1=stationDao.getStationNameCount(destinationStation);
		if(count1<=0)
			return "please enter valid station name";
		int sourceStationId=stationDao.getStationNameCount(sourceStationName);
		int destinationStationId=stationDao.getStationNameCount(destinationStation);
		int minus;
		if(sourceStationId > destinationStationId)
		{
			minus=sourceStationId - destinationStationId;
		}
		else
		{
			minus= destinationStationId-sourceStationId;
		}
		int updatedCardAmount=cardDao.setcardSwipeStatus(id1,"false");
		int updatedSwipeStatus=cardDao.updateCardAmount(id1,minus*5);
		if(updatedSwipeStatus >0)
		{
			return "Successfully completed your journey";
		}
		return "error in cost updation";
	}
	@Override
	public String rechargeCard(ArrayList alr) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int id2=(Integer)alr.get(0);
		int amount=(Integer)alr.get(1);
		int countR=cardDao.rechargeCardAmount(id2,amount);
		if(countR>0) {
		return "Successfully recharged";
		}
		return "recharge failed";
	}
	@Override
	public Card getCardById(int id) throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		return cardDao.getRecordsById(id);
	}

}
