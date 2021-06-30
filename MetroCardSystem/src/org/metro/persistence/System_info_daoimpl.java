package org.metro.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.metro.helper.MysqlConnection;
import org.metro.bean.SystemInfo;

public class System_info_daoimpl implements System_Info_Dao{

	@Override
	public int insertSystemInfo(SystemInfo systeminfo) throws SQLException, ClassNotFoundException,IOException {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("insert into system_info values(?,?,?,?,?,?)");
		statement.setInt(1, systeminfo.getCardid());
		statement.setInt(2, systeminfo.getAmount());
		statement.setString(3,systeminfo.getSource() );
		statement.setString(4, systeminfo.getDestination());
		statement.setTimestamp(5,systeminfo.getSrcTimestamp());
		statement.setTimestamp(6,systeminfo.getDestTimestamp());
		
		int rows = statement.executeUpdate();
		connection.close();
		return rows;

		

	}

}
