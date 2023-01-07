package emp_management.master;

public class MasterService {
	private static MasterService instance = new MasterService();
	public static MasterService getInstance() {
		return instance;
	}
	
private MasterService() {}
	
	private MasterDAO dao = MasterDAO.getInstance();
	
	 public MasterVO findUser2(MasterVO vo) {
	        return dao.findUser2(vo);
	    }
}
