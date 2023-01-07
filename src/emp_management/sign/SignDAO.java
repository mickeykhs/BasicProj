package emp_management.sign;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import emp_management.EmpApplication;
import emp_management.emp.EmpVO;

public class SignDAO {
    private static SignDAO instance = new SignDAO();
    public static SignDAO getInstance() {
        return instance;
    }
    private SignDAO() {}

    private JdbcTemplate template = EmpApplication.getTemplate();

    public EmpVO findUser(EmpVO vo) {
        try {
        	return template.queryForObject("select emp_num, emp_nm, emp_add, emp_ph_num, emp_age, emp_dep_cde, emp_gen, emp_acc, emp_fow_date, emp_pos_cde, emp_pw, emp_sev_date, emp_anu from emp where emp_num = ? and emp_pw = ?", new BeanPropertyRowMapper<>(EmpVO.class), vo.getEmpNum(), vo.getEmpPw());
        } catch (DataAccessException e) {
            return null;
        }
    }
    
}
