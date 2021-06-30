package org.metro.persistence;

import java.io.IOException;
import java.sql.SQLException;

import org.metro.bean.SystemInfo;

public interface System_Info_Dao {
	public int insertSystemInfo(SystemInfo systeminfo)throws SQLException,ClassNotFoundException,IOException;
}
