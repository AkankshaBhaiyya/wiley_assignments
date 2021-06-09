package org.metro.persistence;

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
	public int getStationNameCount(String stationName) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("select count(*) as countVal from station where name=?");
		statement.setString(1,stationName);
		ResultSet resultset=statement.executeQuery();
		resultset.next();
		int count=resultset.getInt("countVal");
		return count;
	}

	@Override
	public Collection<Station> getAllRecords() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Station> stations = null;
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from station");
		ResultSet resultset = statement.executeQuery();

		Station station= null;
		stations = new ArrayList<Station>();

		while (resultset.next()) {
			station=new Station();
			station.setId(resultset.getInt("id"));
			station.setName(resultset.getString("name"));

			stations.add(station);
		}

		connection.close();

		return stations;
	}

}
