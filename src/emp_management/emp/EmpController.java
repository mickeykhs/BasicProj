package emp_management.emp;

import java.util.List;

import emp_management.EmpApplication;
import emp_management.common.HomeMenu;

public class EmpController {
	private static EmpController instance = new EmpController();
    public static EmpController getInstance() {
        return instance;
    }
    private EmpController() {}
    
    private EmpService service = EmpService.getInstance();
//    private EmpVO info = EmpApplication.getInfo();
    
    public List<EmpVO> selectEmpList(String search){
    	return service.find(search);
    }
    
    public List<EmpVO> selectList() throws Exception{
    	return service.selectList();
    }
    
    public EmpVO selectEmpInfo() throws Exception{
    	EmpVO info = EmpApplication.getInfo();
		return service.selectEmpInfo(info.getEmpNum());
	}
   
    public int modifyInfo(EmpVO vo, HomeMenu menu) {
        return service.modifyInfo(vo, menu);
     }
    public int deleteEmp (int delete) throws Exception {
		return service.deleteEmp(delete);
	}
    public int modifyAnu(EmpVO vo) throws Exception{
    	return service.modifyAnu(vo);
    }
    public EmpVO payCheck(EmpVO vo) throws Exception {
    	return service.payCheck(vo.getEmpNum());
    }
    
}
