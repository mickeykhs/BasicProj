package emp_management.emp;

import emp_management.EmpApplication;
//import oracle.jdbc.driver.OracleDriver;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDAO {
	private static EmpDAO instance = new EmpDAO();

	public static EmpDAO getInstance() {
		return instance;
	}

	private EmpDAO() {
	}

	private JdbcTemplate template = EmpApplication.getTemplate();

	public List<EmpVO> find(String search) {
		return template.query("select emp_num, emp_nm, emp_add from emp where emp_nm like '%' || ? || '%'",
				new BeanPropertyRowMapper<>(EmpVO.class), search);
	}

	public List<EmpVO> selectList() throws Exception {
		StringBuffer query = new StringBuffer();
		query.append("SELECT");
		query.append("    a.emp_acc,");
		query.append("    a.emp_add,");
		query.append("    a.emp_age,");
		query.append("    a.emp_anu,");
		query.append("    b.dep_nm emp_dep_cde,");
		query.append("    a.emp_fow_date,");
		query.append("    a.emp_gen,");
		query.append("    a.emp_nm,");
		query.append("    a.emp_num,");
		query.append("    a.emp_ph_num,");
		query.append("    c.pos_nm emp_pos_cde,");
		query.append("    a.emp_sev_date,");
		query.append("    a.emp_pw ");
		query.append("FROM");
		query.append("    emp a");
		query.append("    INNER JOIN dep b ON b.dep_cde = a.emp_dep_cde");
		query.append("    INNER JOIN pos c ON c.pos_cde = a.emp_pos_cde");
		String sql = query.toString();
		return template.query(sql, new BeanPropertyRowMapper<>(EmpVO.class));

	}

	public EmpVO selectEmpInfo(int empNo) throws Exception {
		StringBuffer query = new StringBuffer();
		query.append("SELECT");
		query.append("    a.emp_acc,");
		query.append("    a.emp_add,");
		query.append("    a.emp_age,");
		query.append("    a.emp_anu,");
		query.append("    b.dep_nm emp_dep_cde,");
		query.append("    a.emp_fow_date,");
		query.append("    a.emp_gen,");
		query.append("    a.emp_nm,");
		query.append("    a.emp_num,");
		query.append("    a.emp_ph_num,");
		query.append("    c.pos_nm emp_pos_cde,");
		query.append("    a.emp_sev_date,");
		query.append("    a.emp_pw ");
		query.append("FROM");
		query.append("    emp a");
		query.append("    INNER JOIN dep b ON b.dep_cde = a.emp_dep_cde ");
		query.append("    INNER JOIN pos c ON c.pos_cde = a.emp_pos_cde ");
		query.append("WHERE a.emp_num = ? ");
		String sql = query.toString();
		return template.queryForObject(sql, new BeanPropertyRowMapper<>(EmpVO.class), empNo);
		
	}

	
	public EmpVO updateEmpInfo(int empNo) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE emp ");
		builder.append("    SET ");
		builder.append("        emp_num =?, ");
		builder.append("        emp_add =?, ");
		builder.append("        emp_acc =? ");
		builder.append("WHERE ");
		builder.append("    emp_num =? ");
		String sql = builder.toString();
		System.out.println(sql);

		return template.queryForObject(sql, new BeanPropertyRowMapper<>(EmpVO.class), empNo);
	}

	// 222.주소
	public int modifyAddress(EmpVO vo) {
		return template.update("UPDATE EMP SET EMP_ADD = ? WHERE EMP_NUM = ?", vo.getEmpAdd(), vo.getEmpNum());
	}

	// 223.전화번호
	public int modifyPhone(EmpVO vo) {
		return template.update("UPDATE EMP SET EMP_PH_NUM = ? WHERE EMP_NUM = ?", vo.getEmpPhNum(), vo.getEmpNum());
	}

	// 224.나이
	public int modifyAge(EmpVO vo) {
		return template.update("UPDATE EMP SET EMP_AGE = ? WHERE EMP_NUM = ?", vo.getEmpAge(), vo.getEmpNum());
	}

	// 225.사원계좌
	public int modifyAcc(EmpVO vo) {
		return template.update("UPDATE EMP SET EMP_ACC = ? WHERE EMP_NUM = ?", vo.getEmpAcc(), vo.getEmpNum());
	}

	// 226.부서코드
	public int modifyDep(EmpVO vo) {
		return template.update("UPDATE EMP SET EMP_DEP_CDE = ? WHERE EMP_NUM = ?", vo.getEmpDepCde(), vo.getEmpNum());
	}

	// 227.직급코드
	public int modifyPos(EmpVO vo) {
		return template.update("UPDATE EMP SET EMP_POS_CDE = ? WHERE EMP_NUM = ?", vo.getEmpPosCde(), vo.getEmpNum());
	}

	// 228.연봉수정
	public int modifyPay(EmpVO vo) {
		return template.update("UPDATE EMP SET EMP_ANU = ? WHERE EMP_NUM = ?", vo.getEmpAnu(), vo.getEmpNum());
	}
	

	public EmpVO deleteEmpInfo(int empNo) throws Exception {
		StringBuffer query = new StringBuffer();
		query.append("DELETE FROM ");
		query.append("    emp ");
		query.append("WHERE ");
		query.append("    emp_num =? ");
		String sql = query.toString();
		System.out.println(sql);

		return template.queryForObject(sql, new BeanPropertyRowMapper<>(EmpVO.class), empNo);

	}

	
	public int modifyAnu(EmpVO vo) throws Exception{
		return template.update("UPDATE EMP SET EMP_ANU = ? WHERE EMP_NUM = ? ", vo.getEmpAnu(), vo.getEmpNum()) ;
		
	}
	public int deleteEmp(int delete) {
		String query = "DELETE FROM EMP WHERE EMP_NUM = ?";
		return template.update(query, delete);
//			return template.update("DELETE FROM EMP WHERE EMP_NM = ?", delete);
	}

	public EmpVO payCheck(int empNo) throws Exception {
		String sql = "SELECT EMP_ANU,EMP_NM FROM EMP WHERE EMP_NUM = ? ";
		return template.queryForObject(sql, new BeanPropertyRowMapper<>(EmpVO.class), empNo);
	}
	
	
	
}