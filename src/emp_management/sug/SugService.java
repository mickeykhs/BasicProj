package emp_management.sug;

import java.util.List;

public class SugService {
	private static SugService instance = new SugService();

	public static SugService getInstance() {
		return instance;
	}

	private SugService() {
	}

	private SugDAO dao = SugDAO.getInstanace();

	public int insertSug(SugVO vo) throws Exception {
		return dao.insertSug(vo);
	}

	public List<SugVO> selectList() throws Exception {
		return dao.selectList();
	}

	public int modifySug(SugVO vo) throws Exception {
		return dao.modifySug(vo);
	}

	public int deleteSug(int deleteSug) throws Exception {
		return dao.deleteSug(deleteSug);
	}

}
