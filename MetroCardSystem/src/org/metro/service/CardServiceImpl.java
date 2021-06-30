package org.metro.service;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.metro.bean.Card;
import org.metro.bean.Journey;
import org.metro.bean.Station;
import org.metro.bean.SystemInfo;
import org.metro.persistence.CardDao;
import org.metro.persistence.CardDaoImpl;
import org.metro.persistence.JourneyDao;
import org.metro.persistence.JourneyDaoImpl;
import org.metro.persistence.StationDao;
import org.metro.persistence.StationDaoImpl;
import org.metro.persistence.System_Info_Dao;
import org.metro.persistence.System_info_daoimpl;
public class CardServiceImpl implements CardService{
	private CardDao cardDao=new CardDaoImpl();
	private StationDao stationDao=new StationDaoImpl();
	private JourneyDao journeyDao=new JourneyDaoImpl();
	private System_Info_Dao systeminfoDao=new System_info_daoimpl();
	private static String sourceStationName="";
	@Override
	public int insertCard(Card card) throws SQLException, ClassNotFoundException ,IOException{
		// TODO Auto-generated method stub
		return cardDao.insertCardRecord(card);
	}
	@Override
	public String swipeInCard(ArrayList al) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		int id=(Integer)al.get(0);
		String sourceStation=(String)al.get(1);
		int val=cardDao.getCardSwipeStatus(id);
		String swipeStatus="";
		if(val==0)
		{
		swipeStatus="false";	
		}
		else
		{
			swipeStatus="true";	
		}
		if(swipeStatus=="true")
			return "Your card is not swiped out";
		int amount=cardDao.getCardAmount(id);
		if(amount<20)
			return "Please recharge and then swipe in";
		int count=stationDao.getStationNameCount(sourceStation);
		if(count<0)
			return "please enter valid station name";
		
		int updatedSwipeStatus=cardDao.setcardSwipeStatus(id,"true");
		if(updatedSwipeStatus>0)
		{
			sourceStationName=sourceStation;
		}
		return "Successfully started your journey";
	}
	@Override
	public String swipeOutCard(ArrayList alo) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		int id1=(Integer)alo.get(0);
		String destinationStation=(String)alo.get(1);
		int val=cardDao.getCardSwipeStatus(id1);
		String swipeStatus1="";
		if(val==0)
		{
		swipeStatus1="false";	
		}
		else
		{
			swipeStatus1="true";	
		}
		if(swipeStatus1=="false")
			return "Your card is not swiped in";
		int count1=stationDao.getStationNameCount(destinationStation);
		if(count1<0)
			return "please enter valid station name";
		//System.out.println(sourceStationName+" "+destinationStation);
		int sourceStationId=stationDao.getStationId(sourceStationName);
		int destinationStationId=stationDao.getStationId(destinationStation);
		//System.out.println(sourceStationId+" "+destinationStationId);
		int minus;
		if(sourceStationId > destinationStationId)
		{
			minus=sourceStationId - destinationStationId;
		}
		else
		{
			minus= destinationStationId-sourceStationId;
		}
		
		int updateamountStatus=cardDao.updateCardAmount(id1,minus);
		int updateSwipeStatus=cardDao.setcardSwipeStatus(id1, "false");
		if(updateSwipeStatus >0 &&  updateamountStatus>0)
		{
			return "Successfully completed your journey";
		}
		return "error in cost updation";
	}
	@Override
	public String rechargeCard(ArrayList alr) throws SQLException, ClassNotFoundException,IOException {
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
	public Card getCardById(int id) throws SQLException, ClassNotFoundException, IOException{
		// TODO Auto-generated method stub
		return cardDao.getRecordsById(id);
	}
	@Override
	public int getIdcnt(int id) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		int idcnt=cardDao.getRecordCnt(id);
		return idcnt;
	}
	@Override
	public int getRechargeStatus(int id, int amount) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		int countrecharge=cardDao.rechargeCardAmount(id,amount);
		return countrecharge;
	}
	@Override
	public int getCardStatus(int id) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return cardDao.getCardSwipeStatus(id);
		
	}
	@Override
	public int getServiceCardAmount(int id) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		int amt=cardDao.getCardAmount(id);
		if(amt>150)
			return 1;
		return 0;
	}
	@Override
	public Collection<Station> getStations() throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
	   return stationDao.getAllRecords();
	
	}
	@Override
	public int getStationId(int id) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		int stcnt=stationDao.getStationIdCount(id);
		return stcnt;
	}
	@Override
	public String getStationName(int id) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String stname=stationDao.getStationName(id);
		return stname;
	}
	@Override
	public int setSourceStation(int id, String name) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		int jid=journeyDao.getJourneyCardId(id);
		Date date1=new Date();
		long time1=date1.getTime();
		Timestamp ts1=new Timestamp(time1);
		Date date2=new Date();
		long time2=date2.getTime();
		Timestamp ts2=new Timestamp(time2);
		if(jid == 0)
		{
			Journey journey=new Journey(id,name," ",ts1,ts2);
			int journeyinsertioncount=journeyDao.insertJourneyRecord(journey);
			int updateSwipeStatus=cardDao.setcardSwipeStatus(id, "true");
			if(journeyinsertioncount>0 && updateSwipeStatus>0)
			    return 1;
			else
				return 0;
		}
		else if(jid==1)
		{
			int journeyupdatecount=journeyDao.updateJourneyCardId(id, name, ts1, " ", ts2);
			int updateSwipeStatus1=cardDao.setcardSwipeStatus(id, "true");
	
			if(journeyupdatecount>0 && updateSwipeStatus1>0)
			    return 1;
			else
				return 0;
		}
		return 0;
	}
	@Override
	public int setDestinationStation(int id, String name) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Date dateval=new Date();
		long timeval=dateval.getTime();
		Timestamp to=new Timestamp(timeval);
		int update=journeyDao.setDestinationStation(id, name, to);
		String sourcename=journeyDao.getRecordName(id);
		
		int idfrom=stationDao.getStationId(sourcename);
		int idto=stationDao.getStationId(name);
		int minus=0;
		if(idfrom > idto)
		{
			minus=idfrom-idto;
		}
		else
		{
			minus=idto-idfrom;
		}
		int timediff=getTimeGap(id);
		int value=0;
		int amount=0;
		int updateamountStatus=0;
		int updateSwipeStatus=cardDao.setcardSwipeStatus(id, "false");
		if(update>0  && updateSwipeStatus>0) {
			Timestamp fromT=journeyDao.getSourceTimestamp(id);
			Timestamp toT=journeyDao.getDestinationTimestamp(id);
			if(timediff==1) {
		     amount=minus*5;
		     updateamountStatus=cardDao.updateCardAmount(id,amount);
			 SystemInfo systeminfo=new SystemInfo(id,amount,sourcename,name,fromT,toT);
			 value=systeminfoDao.insertSystemInfo(systeminfo);}
			else
			{
				 amount=minus*5;

				 updateamountStatus=cardDao.updateCardAmount(id,amount+75);
				 SystemInfo systeminfo=new SystemInfo(id,amount+75,sourcename,name,fromT,toT);
				 value=systeminfoDao.insertSystemInfo(systeminfo);
			}
			if(value > 0 )
				return 1;
		}
		return 0;
	}
	@Override
	public int getTimeGap(int id) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Date dateval=new Date();
		long timeval=dateval.getTime();
		Timestamp cur=new Timestamp(timeval);
		Timestamp source=journeyDao.getSourceTimestamp(id);
		long dif=cur.getTime()-source.getTime();
		if((dif/1000) < 120 )
			return 1;
		return 0;
	}
	
   
}
