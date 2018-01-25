package examples;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnector;

/**
	Example class which demonstrates the execution of a query which returns Name, Age and Salary of
	Employees who work in the Marketing Department and either have a salary lower than 30,000 or are younger than 25.
	This Class prints the Name, Age and Salary.
*/
public class Example_3 {

	public static void main(String[] args) 
	{
		ResultSet rs = new DBConnector().runQuery("SELECT Employee.EmpName, Employee.Age, Employee.Salary "
				+ "FROM Employee, Work, Department WHERE Employee.EmpID=Work.EmpID AND Department.DeptID=Work.DeptID "
				+ "AND Department.DeptName='Marketing' AND (Employee.Salary < 30000 or Employee.Age < 25);");
		
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
