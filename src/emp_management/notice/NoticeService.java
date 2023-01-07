package emp_management.notice;

import java.util.List;

public class NoticeService {
	private static NoticeService instance = new NoticeService();
	public static NoticeService getInstance() {
		return instance;
	}
	private NoticeService() {}
	
	private NoticeDAO dao =  NoticeDAO.getInstance();
	
	public List<NoticeVO> selectList() throws Exception{
		return dao.selectList();
	}
	
	public int insertNotice(NoticeVO vo) throws Exception {
		return dao.insertNotice(vo);
	}
	
	public int modifyNotice(NoticeVO vo) throws Exception {
		return dao.modifyNotice(vo);
	}
	
	public int deleteNotice(int deleteNtcNum) throws Exception {
		return dao.deleteNotice(deleteNtcNum);
	}
		
}
