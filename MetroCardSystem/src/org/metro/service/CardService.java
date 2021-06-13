package org.metro.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.metro.bean.Card;
import org.metro.bean.Station;


public interface CardService {
	int insertCard(Card card)throws SQLException, ClassNotFoundException;
	
	int rechargeCard(int amount,int idval)throws SQLException, ClassNotFoundException;
	 Card getCardById(int id)throws SQLException, ClassNotFoundException;
	int getCardIdCount(int id)throws SQLException, ClassNotFoundException;
	boolean getCardSwipeStatus(int id)throws SQLException, ClassNotFoundException;
	int setSwipeIn(String stationName,int id)throws SQLException, ClassNotFoundException;
	int getAmountInfo(int id)throws SQLException, ClassNotFoundException;
	int checkStationName(String stationName)throws SQLException, ClassNotFoundException;
	int setSwipeOut(String stationName,int id)throws SQLException, ClassNotFoundException;

}
