package org.metro.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.metro.bean.Card;
import org.metro.bean.Station;


public interface CardService {
	int insertCard(Card card)throws SQLException, ClassNotFoundException,IOException;
	String swipeInCard(ArrayList<?> al)throws SQLException, ClassNotFoundException,IOException;
	String swipeOutCard(ArrayList<?> al)throws SQLException, ClassNotFoundException,IOException;
	String rechargeCard(ArrayList<?> al)throws SQLException, ClassNotFoundException,IOException;
	 Card getCardById(int id)throws SQLException, ClassNotFoundException,IOException;
      int getIdcnt(int id)throws SQLException, ClassNotFoundException,IOException;
      int getRechargeStatus(int id,int amount)throws SQLException, ClassNotFoundException,IOException;
      int getCardStatus(int id)throws SQLException, ClassNotFoundException,IOException;
      int getServiceCardAmount(int id)throws SQLException, ClassNotFoundException,IOException;
      Collection<Station> getStations()throws SQLException, ClassNotFoundException,IOException;
      int getStationId(int id)throws SQLException, ClassNotFoundException,IOException;
      String getStationName(int id)throws SQLException, ClassNotFoundException,IOException;
      int setSourceStation(int id,String name)throws SQLException, ClassNotFoundException,IOException;
      int setDestinationStation(int id,String name)throws SQLException, ClassNotFoundException,IOException;
      int getTimeGap(int id)throws SQLException, ClassNotFoundException,IOException;
}
