import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;

public class EmployeePayrollService {

	public Connection connectDatabase() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "faraz962495");
		System.out.println("connected to database" + connection);
		return connection;

	}

	/**
	 * method to establish connection with employee payroll database
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void checkDatabaseConnection() throws ClassNotFoundException, SQLException {
		Connection connection = connectDatabase();
		listDrivers();

	}

	/**
	 * method to list the drivers
	 */
	private void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}

	/**
	 * method to select data from the database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void queryData() throws ClassNotFoundException, SQLException {
		Connection connection = connectDatabase();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " "
					+ resultSet.getDate(4));
		}

	}

	/**
	 * this method updates a column data in the database table
	 * 
	 * @return
	 * @throws EmployeePayrollException
	 */
	public boolean updateData() throws EmployeePayrollException {
		Connection connection;
		try {
			connection = connectDatabase();
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("update employee_payroll set basic_pay=300000 where name='Terisa'");
			if (result > 0) {
				System.out.println("updated salary of the employee");
				return true;
			}
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollException("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollException("sql exception");
		}

		return false;

	}

	public boolean updateSalaryPrepared() throws EmployeePayrollException {

		Connection connection;
		try {
			connection = connectDatabase();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update employee_payroll set basic_pay=? where name=?");
			preparedStatement.setDouble(1, 300000);
			preparedStatement.setString(2, "Tersia");
			return true;
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollException("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollException("sql exception");
		}

	}
	public boolean retrievePrepared(String name) throws EmployeePayrollException {
		Connection connection;

		try {
			connection = connectDatabase();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from employee_payroll where name=?");
			preparedStatement.setString(1, name);
			return true;
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollException("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollException("sql exception");
		}


	}
	
}
