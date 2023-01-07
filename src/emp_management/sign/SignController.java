package emp_management.sign;

import emp_management.EmpApplication;
import emp_management.common.HomeMenu;
import emp_management.emp.EmpVO;

public class SignController {
    private static SignController instance = new SignController();
    public static SignController getInstance() {
        return instance;
    }
    private SignController() {}

    private SignService service = SignService.getInstance();

    private EmpVO info = EmpApplication.getInfo();

   
    
    public EmpVO signIn(EmpVO vo) {
    	EmpVO emp = service.findUser(vo);
        if (emp == null) {
            return null;
        }
        EmpApplication.setInfo(emp);
        return emp;
    }
    public int signOut() {
        
        info.invalidate();
        return HomeMenu.HOME.getMenu();
    }
}