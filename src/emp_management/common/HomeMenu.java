package emp_management.common;

import java.util.Scanner;

public enum HomeMenu {
	
   HOME(-1, "=========================\n| 99.로그인 | 9.프로그램 종료 |\n=========================\n메뉴 번호: ",new int[] {99, 9}),
   MAINLOGIN(99, "===========================================\n| 999.관리자 로그인 | 0.사원 로그인 | 9.프로그램 종료 |\n===========================================\n메뉴 번호: ",new int[] {999, 0, 9}),
   ADMIN_LOGIN(999, "★관리자로 로그인 합니다★\n",null),
   EMP_LOGIN(0, "★사원으로 로그인 합니다★\n아이디와 비밀번호를 입력하세요.\n\n",null),
   LOGOUT(7, "로그아웃 되었습니다.",null),
   EXIT(9, "프로그램을 종료합니다!",null),
   EMP_MAIN(6, "==========================================\n| 1.마이페이지 | 3.공지사항  | 4.건의사항 | 5.급여 |\n| 7.로그아웃  | 8.메인페이지 | 9.프로그램 종료     |\n==========================================\n★메뉴를 선택하세요: ",new int[] {1,3,4,5,7,8,9}),
   ADMIN_MAIN(66, "===========================================================\n| 2.사원의 이력관리 | 30.공지사항  | 440.건의사항   | 55.사원의 급여관리 |\n| 7.로그아웃      | 88.메인페이지 | 9.프로그램 종료                 |\n===========================================================\n★메뉴를 선택하세요: ",new int[] {2,30,440,55,7,88,9}),
   EMPMYPAGE(1,"=======================================================\n| 11.나의정보 확인하기 | 7.로그아웃 | 8.메인페이지 | 9.프로그램 종료 |\n=======================================================\n★메뉴를 선택하세요: ",new int[] {11,7,8,9}),
   MYPAGE_INFO(11,"나의 정보를 조회합니다.",null),
   EMPTOTAL(2,"============================================================================================\n| 21.사원의 총 정보 조회 | 22.사원의 정보 수정 | 23.사원의 정보 삭제 | 7.로그아웃 | 88.메인페이지 | 9.프로그램 종료 |\n============================================================================================\n★메뉴를 선택하세요: ",new int[] {21,22,23,7,88,9}),
   EMPTOTAL_INFO(21,"♥사원의 총 정보♥\n",null),
   EMPTOTAL_MODIFY_INFO(22,"==============================================================================================\n| 222.주소 | 223.전화번호 | 224.나이 | 225.사원계좌 | 226.부서코드 | 227.직급코드 | 228.연봉수정 | 88.메인페이지 |\n==============================================================================================\n메뉴를 선택하세요:",new int[] {222,223,224,225,226,227,228,88}),
   MODIFY_ADDRESS(222, "변경할 주소에 해당하는 사번",null),
   MODIFY_PHONE(223,"수정할 번호에 해당하는 사번",null),
   MODIFY_AGE(224,"수정할 나이에 해당하는 사번",null),
   MODIFY_ACC(225,"수정할 계좌에 해당하는 사번",null),
   MODIFY_DEP(226,"수정할 부서에 해당하는 사번",null),
   MODIFY_POS(227,"수정할 직급에 해당하는 사번",null),
   MODIFY_PAY(228,"수정할 급여에 해당하는 사번.",null),
   EMPTOTAL_DELETE(23,"삭제할 사원의 사원번호를 입력해주세요",null),
   EMP_NOTICE(3,"====================================================\n| 31.공지사항 조회 | 7.로그아웃 | 8.메인페이지 | 9.프로그램 종료 |\n====================================================\n★메뉴를 선택하세요: ",new int[] {31,7,8,9}),
   ADMIN_NOTICE(30,"===================================================================================================\n| 301.공지사항 조회 | 32.공지사항 등록 | 33.공지사항 수정 | 34.공지사항 삭제 | 7.로그아웃 | 88.메인페이지 | 9.프로그램 종료 | \n===================================================================================================\n★메뉴를 선택하세요: ",new int[] {301,32,33,34,7,88,9}),
   ADMIN_CHECK(301,"== 공지사항의 모든 목록 ==",null),
   NOTICE_CHECK(31,"== 공지사항의 모든 목록 ==",null),
   NOTICE_REGISTER(32,"공지사항을 등록합니다",null),
   NOTICE_MODIFY(33, "공지사항을 수정합니다.",null),
   NOTICE_DELETE(34,"공지사항을 삭제합니다.",null),
   EMPSUG(4,"=============================================================\n| 41.건의사항 목록 | 42.건의사항 등록 | 43.건의사항 수정 | 44.건의사항 삭제 |\n| 450. 답글 목록  | 7.로그아웃     | 8.메인페이지     | 9.프로그램 종료  |\n=============================================================\n★메뉴를 선택하세요: ",new int[] {41,42,43,44,450,7,8,9}),
   ADMINSUG(440,"=================================================================================\n| 411.건의사항 목록 | 412.건의사항 등록 | 413.건의사항 수정 | 414.건의사항 삭제 | 415.건의사항 답글 |\n| 7.로그아웃       | 88.메인페이지    | 9.프로그램 종료                                   |\n=================================================================================\n★메뉴를 선택하세요: ",new int[] {411,412,413,414,415,7,88,9}),
   SUG_LIST(41, "==건의사항 목록==\n",null),
   SUG_REGISTER(42, "건의사항을 등록합니다.\n",null),
   SUG_MODIFY(43,"수정할 글을 선택해주세요.",null),
   SUG_DELETE(44,"삭제할 글을 선택해주세요.",null),
   SUG_ADMINLIST(411,"==건의사항 목록==\n",null),
   SUG_ADMINREGISTER(412, "건의사항을 등록합니다.\n",null),
   SUG_ADMINMODIFY(413,"수정할 글을 선택해주세요.",null),
   SUG_ADMINDELETE(414,"삭제할 글을 선택해주세요.",null),
   SUG_ANSWER(415,"============================================================================================\n| 451.답글의 목록 | 452.답글 등록 | 453.답글 수정 | 454.답글 삭제 | 7.로그아웃 | 88.메인페이지 | 9.프로그램 종료 |\n============================================================================================\n★메뉴를 선택하세요: ",new int[] {451,452,453,454,7,88,9}),
   EMP_SUG_ANSWER_LIST(450,"==답글의 목록==",null),
   SUG_ANSWER_LIST(451,"==답글의 목록==",null),
   SUG_ANSWER_REGISTER(452,"답글을 등록합니다.",null),
   SUG_ANSWER_MODIFY(453,"답글을 수정합니다.",null),
   SUG_ANSWER_DELETE(454,"답글을 삭제합니다.",null),
   EXTRA(5, "===================================================\n| 51.급여상세조회 | 7.로그아웃 | 8.메인페이지 | 9.프로그램 종료 |\n===================================================\n★메뉴를 선택하세요: ",new int[] {51,7,8,9}),
   EXTRA2(55, "================================================================\n| 50.급여상세조회 | 52.연봉 수정 | 7.로그아웃 | 88.메인페이지 | 9.프로그램 종료 |\n================================================================\n★메뉴를 선택하세요: ",new int[] {50,52,7,88,9}),
   EXTRA_ENTER(51, "=====급여명세서=====\n",null),
   EXTRA_ENTER2(50,"=====급여명세서=====\n",null),
   EXTRA_MODIFY(52,"연봉 수정을 선택하셨습니다.\n",null),
   BACK(8, "메인으로 돌아갑니다",null),
   BACKON(60, "뒤로",null),
   ADMINBACK(88,"메인페이지",null),
   ANSBACK(61,"뒤로",null);
	
	private int menu;
	private final String menuString;
	private int[] subMenu;
	private HomeMenu(int menu, String menuString, int[] subMenu) {
		this.menu = menu;
		this.menuString = menuString;
		this.subMenu = subMenu;
	}
	public int getMenu() {
		return menu;
	}
	public String getMenuString() {
		return menuString;
	}
	
	public int[] getSubMenu() {
		return subMenu;
	}
	public static HomeMenu findMenu(int number) throws MenuNotFoundException {
		for(HomeMenu menu: values()) {
			if(menu.getMenu() ==number) {
				return menu;
			}
		}
		throw new MenuNotFoundException("\n선택하신 메뉴가 없습니다.");
	}
	public void display(Scanner scanner) {
		
	}
	
}