package emp_management.rep;

import java.util.List;

public class RepService {
	private static RepService instance = new RepService();
	public static RepService getInstance() {
		return instance;
	}
	private RepService() {}
	
	private RepDAO dao = RepDAO.getInstanace();
	
	public List<RepVO> selectList() throws Exception {
		 return dao.selectList();
	}
	public int deleteRep(int deleteRep) throws Exception {
	      return dao.deleteRep(deleteRep);
	   }
	public int modifyRep(RepVO vo) throws Exception{
		return dao.modifyRep(vo);
	}
	public int insertRep(RepVO vo) throws Exception {
	      return dao.insertRep(vo);
	   }
}
