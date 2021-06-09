package org.metro.service;

import java.sql.SQLException;
import java.util.Collection;

import org.metro.bean.Station;
import org.metro.persistence.StationDao;
import org.metro.persistence.StationDaoImpl;

public class StationServiceImpl implements StationService{
	private StationDao stationDao=new StationDaoImpl();
	@Override
	public Collection<Station> getAllStations() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return stationDao.getAllRecords();
	
	}

}
