package examples;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnector;

/**Example class which demonstrates the execution of a query which returns all of the
details in the Employee table. This Class prints the Employee ID, Name, Age, Salary and Hire Date.
*/
public class Example_1 
{
	public static void main(String[] args) 
	{
		ResultSet rs = new DBConnector().runQuery("select * from Employee");
		
		try 
		{
			while (rs.next()) 
			{ 
				int empID = rs.getInt("EmpID");
				String empName = rs.getString("EmpName");
				int age = rs.getInt("Age");
				double salary = rs.getDouble("Salary");
				String hireDate = rs.getString("HireDate");
				System. out .println(empID + " " + empName + " - " + salary + " - " + hireDate);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
