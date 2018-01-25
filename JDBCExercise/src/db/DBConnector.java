package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector 
{
	//Reference to the path of the SQLite DB in the project. Declaration of the string - Initialised in the constructor.
	String path;
	
	//Constructor
	public DBConnector()
	{
		path = "jdbc:sqlite:" + DBConnector.class.getClassLoader().getResource("Employee.sqlite").getPath();
	}
	
	//Runs a query on the DB as per input string - Could potentially take in path
	//as a second parameter which could be utilised if adding a file selector.
	public ResultSet runQuery(String query)
	{
		try 
		{
			Connection conn = DriverManager.getConnection(path);
			Statement stmt = conn.createStatement();
			return stmt.executeQuery(query);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.toString());
			return null;
		}
	}
}
