package org.metro.persistence;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.metro.bean.Card;

import org.metro.helper.MysqlConnection;


public class CardDaoImpl implements CardDao {

	@Override
	public int insertCardRecord(Card card) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("insert into card values(NULL,?,?,?)");
		statement.setString(1, card.getName());
		statement.setString(2, card.getSwipeStatus());
		statement.setInt(3, card.getAmount());
		String name=card.getName();
		int rows = statement.executeUpdate();

		if (rows > 0)
		{
			PreparedStatement statement1 = connection.prepareStatement("select id from card where name=? ");
			statement1.setString(1,name);
			ResultSet resultsetone=statement1.executeQuery();
			resultsetone.next();
			int idval=0;
			
			 idval=resultsetone.getInt("id");
			
			return idval;
		}

		connection.close();

		return 0;
	}

	@Override
	public String getCardSwipeStatus(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statementQ = connection.prepareStatement("select swipeStatus from card where id=?");
		statementQ.setInt(1,id);
		ResultSet resultsetQ=statementQ.executeQuery();
		resultsetQ.next();
		String name="";
	 name=resultsetQ.getString("swipeStatus");
		return name;
	}

	@Override
	public int getCardAmount(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select amount from card where id=?");
		statement.setInt(1,id);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int amount=resultset.getInt("amount");
		
		return amount;
	}

	@Override
	public int setcardSwipeStatus(int id, String swipeStatus) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("update card set swipeStatus=? where id=?");
		statement.setString(1,swipeStatus);
		statement.setInt(2,id);
		int value=statement.executeUpdate();
		return value;
	}

	@Override
	public int updateCardAmount(int id1, int minus) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select amount from card where id=?");
		statement.setInt(1,id1);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int amount1=resultset.getInt("amount");
        int temp=amount1-minus;
		PreparedStatement statement1 = connection.prepareStatement("update card set amount=? where id=?");
		statement1.setInt(1,temp);
		statement1.setInt(2,id1);
		int value=statement1.executeUpdate();
		return value;
	}

	@Override
	public int rechargeCardAmount(int id2, int amount) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select amount from card where id=?");
		statement.setInt(1,id2);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int amount2=resultset.getInt("amount");
        int temp1=amount2+amount;
		PreparedStatement statement1 = connection.prepareStatement("update card set amount=? where id=?");
		statement1.setInt(1,temp1);
		statement1.setInt(2,id2);
		int value1=statement1.executeUpdate();
		return value1;
		
	}

	@Override
	public Card getRecordsById(int id3) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = MysqlConnection.getConnection();
		Card card= null;

		PreparedStatement statement = connection.prepareStatement("select * from card where id=?");
		statement.setInt(1,id3);
		ResultSet resultset=statement.executeQuery();
	
		while(resultset.next())
		{
			card = new Card();
			card.setId(resultset.getInt("id"));
			card.setName(resultset.getString("name"));
			card.setSwipeStatus(resultset.getString("swipeStatus"));
			card.setAmount(resultset.getInt("amount"));
		
		}
		return card;
	}

	@Override
	public int getCountId(int idVerify) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement statement1 = connection.prepareStatement("select count(*) as countVal from card where id=? ");
		statement1.setInt(1,idVerify);
		ResultSet resultsetone=statement1.executeQuery();
		resultsetone.next();
		int idval=0;
		
		 idval=resultsetone.getInt("countVal");
		
		return idval;

	}

		
	}
	
