package emp_management.notice;

import java.util.List;

public class NoticeController {
	private static NoticeController instance = new NoticeController();
	public static NoticeController getInstance() {
		return instance;
	} 
	private NoticeController() {}
	
	private NoticeService service = NoticeService.getInstance();
	
	public List<NoticeVO> getNotices() throws Exception {
		return service.selectList();
	}

	public int insertNotice(NoticeVO vo) throws Exception {
		return service.insertNotice(vo);
	}
	
	public int modifyNotice(NoticeVO vo) throws Exception {
		return service.modifyNotice(vo);
	}
	
	public int deleteNotice(int deleteNtcNum) throws Exception {
		return service.deleteNotice(deleteNtcNum);
	}
}