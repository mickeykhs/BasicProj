package emp_management.rep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import emp_management.EmpApplication;
import emp_management.emp.EmpVO;
import oracle.jdbc.driver.OracleDriver;

public class RepDAO {
	private static RepDAO instance = new RepDAO();

	public static RepDAO getInstanace() {
		return instance;
	}

	private RepDAO() {
	}

	private JdbcTemplate template = EmpApplication.getTemplate();

	public int deleteRep(int deleteRep) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE FROM ");
		builder.append("rep ");
		builder.append("WHERE ");
		builder.append("rep_num = ? ");
		
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, deleteRep);
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	public List<RepVO> selectList() throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
		Statement statement = connection.createStatement();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    rep_num, ");
		builder.append("    rep_sug_num, ");
		builder.append("    rep_mst_num, ");
		builder.append("    rep_con ");
		builder.append("FROM ");
		builder.append("    rep ");
		String sql = builder.toString();

		ResultSet resultSet = statement.executeQuery(sql);

		List<RepVO> list = new ArrayList<>();
		while (resultSet.next()) {
			int repNum = resultSet.getInt("rep_num");
			int repSugNum = resultSet.getInt("rep_sug_num");
			int repMstNum = resultSet.getInt("rep_mst_num");
			String repCon = resultSet.getString("rep_con");
			
			list.add(new RepVO(repNum, repSugNum, repMstNum, repCon));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	
	public int modifyRep(RepVO vo) throws Exception {
//		return template.update("update rep set rep_con = ? where rep_num = ? ",vo.getRepCon(), vo.getRepNum());
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
		StringBuffer query = new StringBuffer();
		query.append(" UPDATE rep ");
		query.append("    SET ");
		query.append(" rep_con = ? ");
		query.append(" WHERE ");
		query.append(" rep_num = ?  ");
		
		String sql = query.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getRepCon());
		statement.setInt(2, vo.getRepNum());

		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	public int insertRep(RepVO vo) throws Exception {
	      DriverManager.registerDriver(new OracleDriver());
	      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
	      StringBuffer query = new StringBuffer();
	      query.append("INSERT INTO rep ( ");
	      query.append("    rep_num, ");
	      query.append("    rep_sug_num, ");
	      query.append("    rep_mst_num, ");
	      query.append("    rep_con ");
	      query.append(") VALUES ( ");
	      query.append("    rep_seq.NEXTVAL, ");
	      query.append("    ?, ");
	      query.append("    '1010001', ");
	      query.append("    ? ");
	      query.append(") ");
	      
	      String sql = query.toString();
	      PreparedStatement statement = connection.prepareStatement(sql);
	      statement.setInt(1, vo.getRepSugNum());
	      statement.setString(2, vo.getRepCon());
	      int executeUpdate = statement.executeUpdate();
	      statement.close();
	      connection.close();
	      return executeUpdate;
	   }
	
}