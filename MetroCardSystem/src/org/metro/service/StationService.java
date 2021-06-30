package org.metro.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import org.metro.bean.Station;

public interface StationService {
	Collection<Station> getStationRecords()throws SQLException, ClassNotFoundException,ClassNotFoundException, IOException;
}
