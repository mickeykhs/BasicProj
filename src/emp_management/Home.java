package emp_management;

import java.util.InputMismatchException;
import java.util.Scanner;

import emp_management.common.HomeMenu;
import emp_management.common.MenuNotFoundException;
import emp_management.common.ScannerUtil;
import emp_management.emp.EmpController;
import emp_management.master.MasterController;
import emp_management.notice.NoticeController;
import emp_management.rep.RepController;
import emp_management.sign.SignController;
import emp_management.sug.SugController;

public class Home {
	private MasterController masterController = MasterController.getInstance();
	private RepController repController = RepController.getInstance();
	private SugController sugController = SugController.getInstance();
	private NoticeController noticeController = NoticeController.getInstance();
	private EmpController empController = EmpController.getInstance();
	private SignController signController = SignController.getInstance();

	private EmpView view = EmpView.getInstance();

	public void initialize()  {
		try {
			home(view.init());
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void home(int number) throws Exception {
		// 사번정보를 가지고있어야돼
		//
//		String loginEmpNo = "";
		Scanner scanner = ScannerUtil.scanner();
		loop:

		while (true) {
			try {
				HomeMenu menu = HomeMenu.findMenu(number);
				System.out.print(menu.getMenuString());
				switch (menu) {
				case HOME:
				case MAINLOGIN:
				case EMP_MAIN:
				case ADMIN_MAIN:
				case EMPTOTAL:
				case EMP_NOTICE:
				case ADMIN_NOTICE:
				case EMPSUG:
				case ADMINSUG:
				case EMPMYPAGE:
				case EXTRA2:
				case EXTRA:
					number = view.getMenu(menu);
					break;
				case EMP_LOGIN:
					number = view.login(signController);
					break;
				case ADMIN_LOGIN:
					number = view.login2(masterController);
					break;
				case MYPAGE_INFO:
					number = view.getEmpInfo(empController);
					break;
				case LOGOUT:
					number = signController.signOut();
					break;
				case EMPTOTAL_INFO:
					number = view.getEmpList(empController);
					break;
				case EMPTOTAL_MODIFY_INFO:
					number = view.getMenu(menu);
					break;
				case MODIFY_ADDRESS:
				case MODIFY_PHONE:
				case MODIFY_AGE:
				case MODIFY_ACC:
				case MODIFY_DEP:
				case MODIFY_POS:
				case MODIFY_PAY:
					number = view.modifyInfo(empController, menu);
					break;
				case EMPTOTAL_DELETE:
					number = view.deleteEmp(empController, menu);
					break;
				case ADMIN_CHECK:
		               number = view.notice2(noticeController);
		               break;
				case NOTICE_CHECK:
					number = view.notice(noticeController);
					break;
				case NOTICE_REGISTER:
					number = view.ntcRegister(noticeController);
					break;
				case NOTICE_MODIFY:
					number = view.ntcModify(noticeController);
					break;
				case NOTICE_DELETE:
					number = view.ntcDelete(noticeController);
					break;
				case SUG_ADMINLIST:
					number = view.sug2(sugController);
					break;
				case SUG_ADMINREGISTER:
					number =view.sugRegister2(sugController);
					break;
				case SUG_ADMINMODIFY:
					number = view.sugModify2(sugController);
					break;
				case SUG_ADMINDELETE:
					number = view.sugDelete2(sugController);
					break;
				case SUG_LIST:
					number = view.sug(sugController);
					break;
				case SUG_REGISTER:
					number = view.sugRegister(sugController);
					break;
				case SUG_MODIFY:
					number = view.sugModify(sugController);
					break;
				 case SUG_DELETE:
		               number = view.sugDelete(sugController);
		               break;
				case SUG_ANSWER:
					number = view.getMenu(menu);
					break;
				case SUG_ANSWER_LIST:
					number = view.rep(repController);
					break;
				case EMP_SUG_ANSWER_LIST:
					number = view.rep1(repController);
					break;
				case SUG_ANSWER_REGISTER:
					number = view.repRegister(repController);
					break;
				case SUG_ANSWER_MODIFY:
					number = view.repModify(repController);
					break;
				case SUG_ANSWER_DELETE:
					number = view.repDelete(repController);
					break;

				case EXTRA_ENTER:
					number = view.payCheck(empController);
					break;
				case EXTRA_ENTER2:
					number = view.payCheck2(empController);
					break;
				case EXTRA_MODIFY:
					number = view.anuModify(empController);
					break;
				case BACKON:
					number = view.backon(empController);
					break;
				case BACK:
					number = view.back(empController);
					break;
				case ANSBACK:
					number = view.ansback(repController);
					break;
				case ADMINBACK:
					number = view.adminBack(masterController);
					break;
				case EXIT:
					break loop;
				}

			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("숫자로 입력해주세요");
				scanner.next();
				continue;
			} catch (MenuNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.print(HomeMenu.HOME.getMenuString());
			} 
//			 catch(NoSuchElementException e) {
//				System.out.print("메뉴의 해당하는 숫자로 입력 : ");
//				System.out.print(HomeMenu.HOME.getMenuString());
//				scanner.next();
//				continue;
//				
//			}catch(IllegalArgumentException e) {
//				e.printStackTrace();
//			}
			System.out.println();
		}
	}
}