package org.metro.persistence;

import java.sql.SQLException;

import org.metro.bean.Card;

public interface CardDao {
	int insertCardRecord(Card card) throws SQLException, ClassNotFoundException;
	String getCardSwipeStatus(int id)throws SQLException, ClassNotFoundException;
	int getCardAmount(int id)throws SQLException, ClassNotFoundException;
	int setcardSwipeStatus(int id,String swipeStatus)throws SQLException, ClassNotFoundException;
	int updateCardAmount(int id1,int minus)throws SQLException, ClassNotFoundException;
	int rechargeCardAmount(int id2,int amount)throws SQLException, ClassNotFoundException;
	Card getRecordsById(int id3)throws SQLException, ClassNotFoundException;
	int getCountId(int idVerify)throws SQLException, ClassNotFoundException;
	}

