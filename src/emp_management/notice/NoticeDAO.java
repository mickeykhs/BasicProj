package emp_management.notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeDAO {
	
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}
	private NoticeDAO() {}
	
//	private JdbcTemplate template = EmpApplication.getTemplate();

	public List<NoticeVO> selectList() throws Exception {	
	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
	Statement statement = connection.createStatement();
		
	StringBuilder builder = new StringBuilder();
	builder.append("SELECT ");
	builder.append("    NTC_NUM, ");
	builder.append("    NTC_MST_NUM, ");
	builder.append("    NTC_TIT, ");
	builder.append("    NTC_CON, ");
	builder.append("    NTC_WRT_DATE ");
	builder.append(" FROM");
	builder.append("   NTC ");
	String sql = builder.toString();
	
	ResultSet resultSet = statement.executeQuery(sql);
	
	
	List<NoticeVO> list = new ArrayList<>();
	while (resultSet.next()) {
		int ntcNum = resultSet.getInt("ntc_num");
		int mstNum = resultSet.getInt("ntc_mst_num");
		String ntcTit = resultSet.getString("ntc_tit");
		String ntcCon = resultSet.getString("ntc_con");
		Date ntcWrtDate = resultSet.getDate("ntc_wrt_date");
		
		list.add(new NoticeVO(ntcNum, mstNum, ntcTit, ntcCon, ntcWrtDate));
		
	}
	
	resultSet.close();
	statement.close();
	connection.close();
	return list;
	
}
	
	public int insertNotice(NoticeVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO NTC ( ");
		query.append("    NTC_NUM,NTC_MST_NUM, NTC_TIT, NTC_CON, NTC_WRT_DATE) ");
		query.append(" VALUES(NTC_SEQ.NEXTVAL,'1010001', ?,?,sysdate )");
		
		
		String sql = query.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getNtcTit());
		statement.setString(2, vo.getNtcCon());
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
		
}
	
	public int modifyNotice(NoticeVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
		StringBuffer query = new StringBuffer();
		query.append("UPDATE NTC");
		query.append("    SET ");
		query.append("    NTC_TIT = ?, ");
		query.append("    NTC_CON = ? ");
		query.append("WHERE ");
		query.append("    NTC_NUM = ?" );
		
		String sql = query.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getNtcTit());
		statement.setString(2, vo.getNtcCon());
		statement.setLong(3, vo.getNtcNum());
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}

	public int deleteNotice(int deleteNtcNum) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.26:1521:xe", "emp", "java");
		StringBuilder builder = new StringBuilder();
		
		builder.append("DELETE FROM ");
		builder.append("	NTC ");
		builder.append("WHERE ");
		builder.append("	NTC_NUM = ?");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, deleteNtcNum);
		
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
}






