import java.sql.SQLException;

import org.junit.Test;

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
	@Test
	public void givenEmployeePayrollDatabase_ShouldRetrieveData() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		try {
			employeePayrollService.queryData();
		} catch (SQLException e) {
			System.out.println("SQL exception: " + e);
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}
}
