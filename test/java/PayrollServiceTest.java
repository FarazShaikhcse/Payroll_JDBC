import org.junit.Test;

public class PayrollServiceTest {
	@Test
	public void givenEmployeePayrollDatabase_ShouldConnectToDatabase() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.connectDatabase();
	}
}
