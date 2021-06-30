package org.metro.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import org.metro.bean.Station;
public interface StationDao {
	int getStationNameCount(String stationName)throws SQLException, ClassNotFoundException,IOException;
	int getStationId(String stationName)throws SQLException, ClassNotFoundException,IOException;
	Collection<Station> getAllRecords() throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException;
    int getStationIdCount(int id)throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException;
    String getStationName(int id)throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException;
}
