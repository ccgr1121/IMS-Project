package com.qa.databases;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DataUtil {
	public String resultSet_toString(ResultSet rs){
		String Result = "";
		try {
			ResultSetMetaData meta = rs.getMetaData();
			while(rs.next()) {
				String row = "";
				for (int i = 1; i <=  meta.getColumnCount(); i++) {
					row +=  meta.getColumnLabel(i) + " = " + rs.getString(i) + " ";
				}
				Result += "\n" + row ;
			}
		}
		catch(SQLException e) {
			Result = "null";
		}
		return Result;
	}
	

}
 