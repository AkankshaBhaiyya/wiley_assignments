package org.metro.persistence;

import java.sql.SQLException;
import java.util.Collection;

import org.metro.bean.Station;

public interface StationDao {
	int getStationNameCount(String stationName)throws SQLException, ClassNotFoundException;
	Collection<Station> getAllRecords() throws SQLException, ClassNotFoundException;
	int getStationId(String stationName)throws SQLException, ClassNotFoundException;
}
