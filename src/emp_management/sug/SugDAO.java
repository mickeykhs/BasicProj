package emp_management.sug;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import oracle.jdbc.driver.OracleDriver;

public class SugDAO {
	private static SugDAO instance = new SugDAO();

	public static SugDAO getInstanace() {
		return instance;
	}

	private SugDAO() {
	}

//	private JdbcTemplate template = EmpApplication.getTemplate();

	public List<SugVO> selectList() throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
		Statement statement = connection.createStatement();

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    sug_num, ");
		builder.append("    sug_tit, ");
		builder.append("    sug_con, ");
		builder.append("    sug_wrt_date, ");
		builder.append("    sug_emp_num ");
		builder.append("FROM ");
		builder.append("    sug ");
		String sql = builder.toString();

		ResultSet resultSet = statement.executeQuery(sql);

		List<SugVO> list = new ArrayList<>();
		while (resultSet.next()) {
			int sugNum = resultSet.getInt("sug_num");
			String sugTit = resultSet.getString("sug_tit");
			String sugCon = resultSet.getString("sug_con");
			Date sugWrtDate = resultSet.getDate("sug_wrt_date");
			int sugEmpNum = resultSet.getInt("sug_emp_num");

			list.add(new SugVO(sugNum, sugTit, sugCon, sugWrtDate, sugEmpNum));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	public int insertSug(SugVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO SUG ( ");
		query.append("    SUG_NUM,SUG_TIT, SUG_CON, SUG_WRT_DATE, SUG_EMP_NUM) ");
		query.append(" VALUES(SUG_SEQ.NEXTVAL,?, ?,sysdate,'202202' ) ");

		String sql = query.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getSugTit());
		statement.setString(2, vo.getSugCon());
//		statement.setInt(3, vo.getSugEmpNum());

		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;

	}

	public int modifySug(SugVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
		StringBuffer query = new StringBuffer();
		query.append("UPDATE sug ");
		query.append("    SET ");
		query.append("        sug_tit = ?, ");
		query.append("        sug_con = ? ");
		query.append("WHERE ");
		query.append("    sug_num = ? ");
		
		String sql = query.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getSugTit());
		statement.setString(2, vo.getSugCon());
		statement.setInt(3, vo.getSugNum());
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	 public int deleteSug(int deleteSug) throws Exception {
	      DriverManager.registerDriver(new OracleDriver());
	      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
	      StringBuilder builder = new StringBuilder();   
	      builder.append("DELETE FROM ");
	      builder.append("sug ");
	      builder.append("WHERE ");
	      builder.append("sug_num = ? ");
	      
	      String sql = builder.toString();
	      PreparedStatement statement = connection.prepareStatement(sql);
	      statement.setInt(1, deleteSug);
	      
	      int executeUpdate = statement.executeUpdate();
	      statement.close();
	      connection.close();
	      return executeUpdate;
	   }
}
