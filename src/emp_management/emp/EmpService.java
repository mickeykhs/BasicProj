package emp_management.emp;

import java.util.List;

import emp_management.common.HomeMenu;

public class EmpService {
	private static EmpService instance = new EmpService();
	public static EmpService getInstance() {
		return instance;
	}
	private EmpService() {}
	
	private EmpDAO dao = EmpDAO.getInstance();
	
	public List<EmpVO> find(String search){
		return dao.find(search);
		
	}
	
	public List<EmpVO> selectList() throws Exception{
		return dao.selectList();
	}
	
	public EmpVO selectEmpInfo(int empNo) throws Exception{
		return dao.selectEmpInfo(empNo);
	}
	public int modifyAnu(EmpVO vo) throws Exception{
		return dao.modifyAnu(vo);
	}

	public int deleteEmp(int delete) {
		return dao.deleteEmp(delete);
	}
	public EmpVO payCheck(int empNo) throws Exception{
		return dao.payCheck(empNo);
	}
	
	
	
	public int modifyInfo(EmpVO vo, HomeMenu menu) {
		int result= 0;
		switch (menu) {
         case MODIFY_ADDRESS:
        	 result = dao.modifyAddress(vo);
        	 break;
         case MODIFY_PHONE:
        	 result = dao.modifyPhone(vo);
        	 break;
         case MODIFY_AGE:
        	 result = dao.modifyAge(vo);
        	 break;
         case MODIFY_ACC:
        	 result = dao.modifyAcc(vo);
        	 break;
         case MODIFY_DEP:
        	 result = dao.modifyDep(vo);
        	 break;
         case MODIFY_POS:
        	 result = dao.modifyPos(vo);
        	 break;
         case MODIFY_PAY:
        	 result = dao.modifyPay(vo);
        	 break;
		}
		return result;
	}

}

