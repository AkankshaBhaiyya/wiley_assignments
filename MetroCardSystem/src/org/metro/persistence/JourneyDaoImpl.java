package org.metro.persistence;

import java.io.IOException;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.metro.bean.Journey;
import org.metro.helper.MysqlConnection;
import java.sql.Timestamp; 

import java.time.Instant; 
public class JourneyDaoImpl implements JourneyDao{

	@Override
	public String getRecordName(int id)throws SQLException, ClassNotFoundException,IOException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement statement1 = connection.prepareStatement("select sourcestation from journey where cardid=? ");
		statement1.setInt(1,id);
		ResultSet resultsetone=statement1.executeQuery();
		resultsetone.next();
		String name=resultsetone.getString("sourcestation");
		 connection.close();
		return name;
	}

	@Override
	public int insertJourneyRecord(Journey journey) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("insert into journey values(?,?,?,?,?)");
		statement.setInt(1, journey.getCardid());
		statement.setString(2, journey.getSourcestation());
		statement.setString(3, journey.getDestinationstation());
		statement.setTimestamp(4,journey.getSrc());
		statement.setTimestamp(5, journey.getDes());
		
		int rows = statement.executeUpdate();
		connection.close();
        if(rows>0) {
        	return 1;
        }
		return 0;
	}
@Override
	public int setDestinationStation(int id, String destinationName,Timestamp val1) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("update journey set destinationstation=?,timestamp_dest=? where cardid=?");
		statement.setString(1,destinationName);
		statement.setTimestamp(2,val1);
		statement.setInt(3,id);
		int value=statement.executeUpdate();
		connection.close();
		if(value>0)
		{
			return 1;
		}
		return 0;
	}

	@Override
	public int getJourneyCardId(int id) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement statement1 = connection.prepareStatement("select count(*) as cnt from journey where cardid=? ");
		statement1.setInt(1,id);
		ResultSet resultsetone=statement1.executeQuery();
		resultsetone.next();
		 int idval=resultsetone.getInt("cnt");
		 
		 connection.close();
		return idval;
	}

	@Override
	public int updateJourneyCardId(int id, String source,Timestamp val1, String destination,Timestamp val2) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("update journey set sourcestation=?,destinationstation=?,timestamp_source=?,timestamp_dest=? where cardid=?");
		statement.setString(1,source);
		statement.setString(2,destination);
		statement.setTimestamp(3,val1);
		statement.setTimestamp(4,val2);
		statement.setInt(5, id);
		
		int value=statement.executeUpdate();
		connection.close();
		if(value>0)
		{
			return 1;
		}
		return 0;
	}


	@Override
	public Timestamp getSourceTimestamp(int id) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement statement1 = connection.prepareStatement("select timestamp_source from journey where cardid=? ");
		statement1.setInt(1,id);
		ResultSet resultsetone=statement1.executeQuery();
		resultsetone.next();
		Timestamp name=resultsetone.getTimestamp("timestamp_source");
		 connection.close();
		return name;
	}

	@Override
	public Timestamp getDestinationTimestamp(int id) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement statement1 = connection.prepareStatement("select timestamp_dest from journey where cardid=? ");
		statement1.setInt(1,id);
		ResultSet resultsetone=statement1.executeQuery();
		resultsetone.next();
		Timestamp name=resultsetone.getTimestamp("timestamp_dest");
		 connection.close();
		return name;
	}

	
	

}
