package org.metro.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.metro.bean.Card;
import org.metro.bean.Station;


public interface CardService {
	int insertCard(Card card)throws SQLException, ClassNotFoundException;
	String swipeInCard(ArrayList al)throws SQLException, ClassNotFoundException;
	String swipeOutCard(ArrayList al)throws SQLException, ClassNotFoundException;
	String rechargeCard(ArrayList al)throws SQLException, ClassNotFoundException;
	 Card getCardById(int id)throws SQLException, ClassNotFoundException;

}
