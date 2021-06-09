package org.metro.service;

import java.sql.SQLException;
import java.util.Collection;

import org.metro.bean.Station;

public interface StationService {
	Collection<Station> getAllStations()throws SQLException, ClassNotFoundException;
}
