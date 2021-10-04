import java.sql.SQLException;

import org.junit.Test;

import junit.framework.Assert;

public class PayrollServiceTest {
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
}
