package emp_management.sign;

import emp_management.emp.EmpVO;


public class SignService {
    private static SignService instance = new SignService();
    public static SignService getInstance() {
        return instance;
    }
    private SignService() {}

    private SignDAO dao = SignDAO.getInstance();

    public EmpVO findUser(EmpVO vo) {
        return dao.findUser(vo);
    }
   
}
