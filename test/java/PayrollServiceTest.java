import java.sql.SQLException;

import org.junit.Test;

import junit.framework.Assert;

public class PayrollServiceTest {
	/**
	 * testcase for database connection
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldConnectToDatabase() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		try {
			employeePayrollService.checkDatabaseConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * testcase to read data from table in database
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldRetrieveData() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		try {
			employeePayrollService.queryData();
		} catch (SQLException e) {
			System.out.println("SQL exception: " + e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	/**
	 * test case to update the salary
	 * 
	 * @throws EmployeePayrollException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldUpdateSalary() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		boolean result;
		try {
			result = employeePayrollService.updateData();
			Assert.assertTrue(result);
		} catch (EmployeePayrollException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * test case to update the salary using prepared statement
	 * @throws EmployeePayrollException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldUpdateSalaryUsingPreparedStatement()
			throws EmployeePayrollException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		boolean result = employeePayrollService.updateSalaryPrepared();
		Assert.assertTrue(result);

	}

	/**
	 * test case to retrieve the details of employee using prepared statement
	 * @throws EmployeePayrollException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnEmployeeDetailsUsingPreparedStatement()
			throws EmployeePayrollException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		boolean result = employeePayrollService.retrievePrepared("Terisa");
		Assert.assertTrue(result);

	}
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnEmployeeDetailsUsingBasedOndate()
			throws EmployeePayrollException, ClassNotFoundException, SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.retrieveDate();

	}
}
