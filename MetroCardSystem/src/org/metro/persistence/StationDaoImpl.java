package org.metro.persistence;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.metro.bean.Station;
import org.metro.helper.MysqlConnection;

public class StationDaoImpl implements StationDao{

	@Override
	public int getStationNameCount(String stationName) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("select count(*) as cnt from station where name=?");
		statement.setString(1,stationName);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int count=resultset.getInt("cnt");
		return count;
	}

	@Override
	public int getStationId(String stationName) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("select id from station where name=?");
		statement.setString(1,stationName);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int count=resultset.getInt("id");
		return count;
		
	}

	@Override
	public Collection<Station> getAllRecords()
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Station> stations = null;
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from station");
		ResultSet resultset = statement.executeQuery();

		Station station = null;
		stations = new ArrayList<Station>();

		while (resultset.next()) {
			station = new Station();
			station.setId(resultset.getInt("id"));
			station.setName(resultset.getString("name"));
			stations.add(station);
		}

		connection.close();

		return stations;
	}

	@Override
	public int getStationIdCount(int id)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("select count(*) as cnt from station where id=?");
		statement.setInt(1,id);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int count=resultset.getInt("cnt");
		return count;
	}

	@Override
	public String getStationName(int id)
			throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("select name  from station where id=?");
		statement.setInt(1,id);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		String name=resultset.getString("name");
		return name;
	}
	

}
