package org.metro.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import org.metro.bean.Card;
import org.metro.bean.Station;

public interface CardDao {
	int insertCardRecord(Card card) throws SQLException, ClassNotFoundException ,IOException;
	int getCardSwipeStatus(int id)throws SQLException, ClassNotFoundException,IOException;
	int getCardAmount(int id)throws SQLException, ClassNotFoundException,IOException;
	int setcardSwipeStatus(int id,String swipeStatus)throws SQLException, ClassNotFoundException,IOException;
	int updateCardAmount(int id1,int minus)throws SQLException, ClassNotFoundException,IOException;
	int rechargeCardAmount(int id2,int amount)throws SQLException, ClassNotFoundException,IOException;
	Card getRecordsById(int id3)throws SQLException, ClassNotFoundException,IOException;
	int getRecordCnt(int id)throws SQLException, ClassNotFoundException,IOException;
	
	
	}

