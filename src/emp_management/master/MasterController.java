package emp_management.master;

import emp_management.EmpApplication;

public class MasterController {
	private static MasterController instance = new MasterController();
	public static MasterController getInstance() {
		return instance;
	} 
	private MasterController() {}
	
private MasterService service = MasterService.getInstance();
    
//    private MasterVO info2 = EmpApplication.getInfo2();
    
    public MasterVO signIn2(MasterVO vo) {
    	MasterVO mst = service.findUser2(vo);
        if (mst == null) {
            return null;
        }
        EmpApplication.setInfo2(mst);
        return mst;
    }
	
}
