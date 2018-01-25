package examples;

import java.sql.ResultSet;
import java.sql.SQLException;
import db.DBConnector;

/**
	Example class which demonstrates the execution of a query which returns Name, Age and Salary of
	Employees in the Employee table over Age 40 and with salaries over 40,000. Results are ordered by 
	age (lowest to highest), and secondarily by salary (lowest to highest). This Class prints the Name,
	Age and Salary.
*/
public class Example_2 {

	public static void main(String[] args) 
	{
		ResultSet rs = new DBConnector().runQuery("SELECT EmpName, Age, Salary FROM Employee WHERE Age > 40 and "
		+ "Salary > 20000 ORDER BY Age ASC, Salary ASC;");
		
		try 
		{
			while (rs.next()) 
			{ 
				String empName = rs.getString("EmpName");
				int age = rs.getInt("Age");
				double salary = rs.getDouble("Salary");
				System. out .println(empName + " - " + age + " - " + salary);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
