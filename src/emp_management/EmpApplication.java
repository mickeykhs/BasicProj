package emp_management;

import java.sql.SQLException;
import java.util.InputMismatchException;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import emp_management.emp.EmpVO;
import emp_management.master.MasterVO;

public class EmpApplication {
	private static EmpVO info = new EmpVO();
	private static MasterVO Info2 = new MasterVO();
	private static JdbcTemplate template = new JdbcTemplate();
	
	public static void main(String[] args) {
		try {
			new Home().initialize();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (Exception e) {
			
		}
	}
	public static EmpVO getInfo() {
		return info;
	}
	
	public static void setInfo(EmpVO info) {
		EmpApplication.info = info;
	}
	public static JdbcTemplate getTemplate() {
		try {
			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setURL("jdbc:oracle:thin:@192.168.142.26:1521:xe");
            dataSource.setUser("emp");
            dataSource.setPassword("java");
            template.setDataSource(dataSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return template;
	}
	public static MasterVO getInfo2() {
		return Info2;
	}
	public static void setInfo2(MasterVO Info2) {
		EmpApplication.Info2 = Info2;
	}
}
