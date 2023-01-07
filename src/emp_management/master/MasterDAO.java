package emp_management.master;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import emp_management.EmpApplication;


public class MasterDAO {
	private static MasterDAO instance = new MasterDAO();
	public static MasterDAO getInstance() {
		return instance;
	}
	private MasterDAO() {}
	
	private JdbcTemplate template = EmpApplication.getTemplate();
	
	public List<MasterVO> find(String search){
		return template.query("select mst_id, mst_pw where mst_id like '%' || ? || '%'", new BeanPropertyRowMapper<>(MasterVO.class), search);
	}
	public MasterVO findUser2(MasterVO vo) {
        try {
        	return template.queryForObject("select mst_num, mst_id, mst_pw, mst_nm from mst where mst_id = ? and mst_pw=?" , new BeanPropertyRowMapper<>(MasterVO.class), vo.getMstId(), vo.getMstPw());
        } catch (DataAccessException e) {
            return null;
        }
    }
	
}
