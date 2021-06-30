package org.metro.persistence;

import java.io.IOException;
import java.sql.SQLException;

import org.metro.bean.Journey;
import java.sql.Timestamp; 

import java.time.Instant; 
public interface JourneyDao {
	int insertJourneyRecord(Journey journey) throws SQLException, ClassNotFoundException,IOException;
  String getRecordName(int id)throws SQLException, ClassNotFoundException,IOException;

  int setDestinationStation(int id1, String stationName,Timestamp val1) throws SQLException, ClassNotFoundException,IOException;
   int getJourneyCardId(int id)throws SQLException, ClassNotFoundException,IOException;
  
   Timestamp getSourceTimestamp(int id)throws SQLException, ClassNotFoundException,IOException;
   Timestamp getDestinationTimestamp(int id)throws SQLException, ClassNotFoundException,IOException;
   int updateJourneyCardId(int id,String source,Timestamp val1,String destination,Timestamp val2)throws SQLException, ClassNotFoundException,IOException;
}
