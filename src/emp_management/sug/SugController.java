package emp_management.sug;

import java.util.List;

public class SugController {
	private static SugController instance = new SugController();

	public static SugController getInstance() {
		return instance;
	}

	private SugController() {
	}

	private SugService service = SugService.getInstance();

	public List<SugVO> getSug() throws Exception {
		return service.selectList();
	}

	public int insertSug(SugVO vo) throws Exception {
		return service.insertSug(vo);
	}

	public int modifySug(SugVO vo) throws Exception {
		return service.modifySug(vo);
	}

	public int deleteSug(int deleteSug) throws Exception {
		return service.deleteSug(deleteSug);
	}
}