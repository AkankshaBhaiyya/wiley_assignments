package org.metro.persistence;

import java.io.IOException;

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
	public int insertCardRecord(Card card) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("insert into card values(Null,?,?,?)");
		statement.setString(1, card.getName());
		statement.setString(2, card.getSwipeStatus());
		statement.setInt(3, card.getAmount());
		
		int rows = statement.executeUpdate();

		if (rows > 0) {
			PreparedStatement stmt=connection.prepareStatement("select id from card where name=?");
			stmt.setString(1,card.getName());
			ResultSet rs=stmt.executeQuery();
			rs.next();
			int val=rs.getInt("id");
			return val;
		}
		connection.close();

		return 0;
	}

	@Override
	public int getCardSwipeStatus(int id) throws SQLException, ClassNotFoundException ,IOException{
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select swipeStatus from card where id=?");
		statement.setInt(1,id);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		String name=resultset.getString("swipeStatus");
		connection.close();
		if(name.equals("true"))
			return 1;
		return 0;
	} 

	@Override
	public int getCardAmount(int id) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select amount from card where id=?");
		statement.setInt(1,id);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int amount=resultset.getInt("amount");
		connection.close();
		return amount;
	}

	@Override
	public int setcardSwipeStatus(int id, String swipeStatus) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("update card set swipeStatus=? where id=?");
		statement.setString(1,swipeStatus);
		statement.setInt(2,id);
		int value=statement.executeUpdate();
		connection.close();
		return value;
	}

	@Override
	public int updateCardAmount(int id1, int minus) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select amount from card where id=?");
		statement.setInt(1,id1);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int amount1=resultset.getInt("amount");
		
         int dif=amount1-minus;
		PreparedStatement statement1 = connection.prepareStatement("update card set amount=? where id=?");
		statement1.setInt(1,dif);
		statement1.setInt(2,id1);
		int value=statement1.executeUpdate();
		connection.close();
		return value;
	}

	@Override
	public int rechargeCardAmount(int id2, int amount) throws SQLException, ClassNotFoundException ,IOException{
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select amount from card where id=?");
		statement.setInt(1,id2);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int amount2=resultset.getInt("amount");
         int sum=amount2+amount;
		PreparedStatement statement1 = connection.prepareStatement("update card set amount=? where id=?");
		statement1.setInt(1,sum);
		statement1.setInt(2,id2);
		int value1=statement1.executeUpdate();
		connection.close();
		return value1;
		
	}

	@Override
	public Card getRecordsById(int id3) throws SQLException, ClassNotFoundException, IOException {
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
		connection.close();
		return card;
	}

	@Override
	public int getRecordCnt(int id) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		Card card= null;

		PreparedStatement statement = connection.prepareStatement("select count(id) as cnt from card where id=?");
		statement.setInt(1,id);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int count=resultset.getInt("cnt");
		connection.close();
		return count;
	}



		
	}
	
