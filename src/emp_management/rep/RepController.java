package emp_management.rep;

import java.util.List;


public class RepController {
	private static RepController instance = new RepController();
	public static RepController getInstance() {
		return instance;
	} 
	private RepController() {}
	
	private RepService service = RepService.getInstance();
	
	public List<RepVO> getRep() throws Exception {
		return service.selectList();
	}
	public int deleteRep(int deleteRep) throws Exception {
	      return service.deleteRep(deleteRep);
	   }
	public int modifyRep(RepVO vo) throws Exception {
		return service.modifyRep(vo);
	}
	public int insertRep(RepVO vo) throws Exception {
	      return service.insertRep(vo);
	   }
}
