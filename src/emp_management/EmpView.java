package emp_management;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import emp_management.common.HomeMenu;
import emp_management.common.ScannerUtil;
import emp_management.emp.EmpController;
import emp_management.emp.EmpService;
import emp_management.emp.EmpVO;
import emp_management.master.MasterController;
import emp_management.master.MasterVO;
import emp_management.notice.NoticeController;
import emp_management.notice.NoticeVO;
import emp_management.rep.RepController;
import emp_management.rep.RepVO;
import emp_management.sign.SignController;
import emp_management.sug.SugController;
import emp_management.sug.SugVO;

public class EmpView {

   private static EmpView instance = new EmpView();

   private EmpView() {
   }

   public static EmpView getInstance() {
      return instance;
   }

   private EmpService service = EmpService.getInstance();
   private EmpVO info = EmpApplication.getInfo();
   private Scanner scanner = ScannerUtil.scanner();


   
   public int init() {
      String eyes =  " ● ∪ ●│      ";
        
        System.out.println("\n\n\n□■□■□■□■□■□■□■□■□■□■□■□■□■");
        System.out.println();
        System.out.println("        ∂∂∂∂∂ ");                  
        System.out.println("      ╭∂∂∂∂∂∂╮    ╭──────────────╮     ");   
        System.out.println("      ε" + eyes +       " 처 음 처 럼");
        System.out.println("      ╰──┰┰──╯    ╰──────────────╯    ");
        System.out.println("      ╭──╲╱──╮      ");
        System.out.println("   ╞══╧══════╧══════════════════════╡▒ ");
        System.out.println("   │　　대덕인재개발원　402호  2조         │▒   ");
        System.out.println("   └──────────────────  팀장: 오재경 ");
        System.out.println("   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  팀원: 김현석 / 김효정 / 길선주 ");
        System.out.println();
        System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n");  

        System.out.println("  ●DDIT 사원 관리 프로그램입니다●");
        System.out.println("□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n");

            return HomeMenu.HOME.getMenu();
   }

   public int getMenu(HomeMenu menu) throws Exception {
      int[] subMenu = menu.getSubMenu();
      while (true) {
         int selectedMenu = Integer.parseInt(scanner.nextLine());
         if(IntStream.of(subMenu).filter(value -> value == selectedMenu).count() > 0) {
            return selectedMenu;
         } else {
            System.out.print("해당하는 메뉴를 입력하세요.\n메뉴 번호: ");
         }
      }
   }

   public int login(SignController controller) {
      int number;
      while (true) {
         try {
               System.out.print("● 아이디(사번): ");
               int empNum = Integer.parseInt(scanner.nextLine());
               System.out.print("● 비밀번호: ");
               String empPw = scanner.nextLine();
               EmpVO vo = controller.signIn(new EmpVO(empNum, empPw));
               if (vo != null) {
                  System.out.println(vo.getEmpNm() + "님 환영합니다.");
                  number = HomeMenu.EMP_MAIN.getMenu();
               } else {
                  System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
                  number = HomeMenu.HOME.getMenu();
               }
            return number;
         } catch (Exception e) {
            System.out.println("ID(사번)을 정확히 입력해주세요");
         }
      }
   }
   public int login2(MasterController controller) {
      int number;
      while (true) {
         try {
            System.out.print("● 관리자 번호: ");
               int mstId = Integer.parseInt(scanner.nextLine());
               System.out.print("● 비밀번호: ");
               String mstPw = scanner.nextLine();
            MasterVO vo = controller.signIn2(new MasterVO(mstId, mstPw));
            if (vo != null) {
               System.out.println(vo.getMstNm() + "님이 로그인하셨습니다.");
               number = HomeMenu.ADMIN_MAIN.getMenu();
            } else {
               System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
               number = HomeMenu.HOME.getMenu();
            }
            return number;
         } catch (Exception e) {
            System.out.println("ID를 정확히 입력해주세요");
         }
      }
   }

   public int getEmpInfo(EmpController controller) {
      try {
         EmpVO info = controller.selectEmpInfo();
         System.out.println("\n\n사번\t이름\t주소\t\t  \t전화번호\t\t나이\t성별\t계좌번호\t\t\t\t  입사일\t\t비밀번호\t\t퇴사일\t\t연봉\t\t부서코드\t직급코드\n");
         System.out.print(info);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return HomeMenu.EMPMYPAGE.getMenu();
   }

   public int getEmpList(EmpController controller) throws Exception {
      List<EmpVO> list = controller.selectList();
      System.out.println("사원번호\t 이름\t   주소\t\t\t  전화번호\t\t나이    성별\t    계좌번호\t\t\t  입사일\t\t비밀번호\t\t퇴사일\t\t연봉\t\t부서코드\t직급코드");
      for(EmpVO empVO : list) {
         System.out.println(empVO.toString());
      }
      return HomeMenu.EMPTOTAL.getMenu();
   }

   public int deleteEmp(EmpController empController, HomeMenu menu) throws Exception {
      while (true) {
         try {
            System.out.print("삭제할 사번 입력: ");
            int strDel = Integer.parseInt(scanner.nextLine());
            int delet = empController.deleteEmp(strDel);
            if (delet == 1) {
               System.out.println("삭제 성공");

            } else {
               System.out.println("삭제 실패");
            }
            return HomeMenu.EMPTOTAL.getMenu();
         } catch (Exception e) {
            System.out.println("사번이 틀렸습니다. 다시 입력해주세요");
            scanner.next();
            continue;
         }
      }
   }

   public int back(EmpController controller) throws Exception {
      return HomeMenu.EMP_MAIN.getMenu();
   }
   public int adminBack(MasterController controller) throws Exception{
      return HomeMenu.ADMIN_MAIN.getMenu();
   }

   public int backon(EmpController controller) throws Exception {
      return HomeMenu.EMPTOTAL.getMenu();
   }

   public int payCheck(EmpController controller) throws Exception {
      while (true) {
         try {

            System.out.print("본인의 사원 번호를 입력 : ");
            int enterNum = Integer.parseInt(scanner.nextLine());
            EmpVO vo = controller.payCheck(new EmpVO(enterNum));
            System.out.printf("%s님의 월급 명세서\n", vo.getEmpNm());
            System.out.printf("소득세:   %,-7.1f원\n", vo.getEmpAnu() * 0.00859 / 12);
            System.out.printf("지방소득세: %,-7.1f원\n", vo.getEmpAnu() * 0.000859 / 12);
            System.out.printf("주민세:   %,-7.1f원\n", vo.getEmpAnu() * 0.00098 / 12);
            System.out.printf("고용보험:  %,-7.1f원\n", vo.getEmpAnu() * 0.006175 / 12);
            System.out.printf("국민연금:  %,-7.1f원\n", vo.getEmpAnu() * 0.04275 / 12);
            System.out.printf("장기요양:  %,-7.1f원\n", vo.getEmpAnu() * 0.0019 / 12);
            System.out.printf("건강보험:  %,-7.1f원\n", vo.getEmpAnu() * 0.02907 / 12);
            System.out.printf("공제합계:  %,-7.1f원\n", vo.getEmpAnu() * 0.090324 / 12);
            System.out.printf("월급(세전): %,-7.1f원\n", (double) vo.getEmpAnu() / 12);
            System.out.printf("월급(세후): %,-7.1f원\n", vo.getEmpAnu() / 12 - ((vo.getEmpAnu() * 0.090324) / 12));
            System.out.println("--------------------------------------");
            System.out.println("귀하의 노고에 감사드립니다. -(주) DDIT- ");
            return HomeMenu.EXTRA.getMenu();
         } catch (Exception e) {
            System.out.println("사번이 올바르지 않습니다. 다시 입력해주세요");

         }
         
      }
   }
   public int payCheck2(EmpController controller) throws Exception {
      while (true) {
         try {

            System.out.print("조회할 사원의 사원번호를 입력 : ");
            int enterNum = Integer.parseInt(scanner.nextLine());
            EmpVO vo = controller.payCheck(new EmpVO(enterNum));
            System.out.printf("%s님의 월급 명세서\n", vo.getEmpNm());
            System.out.printf("소득세:   %,-7.1f원\n", vo.getEmpAnu() * 0.00859 / 12);
            System.out.printf("지방소득세: %,-7.1f원\n", vo.getEmpAnu() * 0.000859 / 12);
            System.out.printf("주민세:   %,-7.1f원\n", vo.getEmpAnu() * 0.00098 / 12);
            System.out.printf("고용보험:  %,-7.1f원\n", vo.getEmpAnu() * 0.006175 / 12);
            System.out.printf("국민연금:  %,-7.1f원\n", vo.getEmpAnu() * 0.04275 / 12);
            System.out.printf("장기요양:  %,-7.1f원\n", vo.getEmpAnu() * 0.0019 / 12);
            System.out.printf("건강보험:  %,-7.1f원\n", vo.getEmpAnu() * 0.02907 / 12);
            System.out.printf("공제합계:  %,-7.1f원\n", vo.getEmpAnu() * 0.090324 / 12);
            System.out.printf("월급(세전): %,-7.1f원\n", (double) vo.getEmpAnu() / 12);
            System.out.printf("월급(세후): %,-7.1f원\n", vo.getEmpAnu() / 12 - ((vo.getEmpAnu() * 0.090324) / 12));
            System.out.println("--------------------------------------");
            System.out.println("귀하의 노고에 감사드립니다. -(주) DDIT- ");
            return HomeMenu.EXTRA2.getMenu();
         } catch (Exception e) {
            System.out.println("사번이 올바르지 않습니다. 다시 입력해주세요");

         }
      }
   }
   
   //관리자모드 공지사항 조회
   public int notice2(NoticeController controller) throws Exception {

      while (true) {
         List<NoticeVO> notices = controller.getNotices();
         System.out.println("============================================================");
         System.out.println("글번호 \t 작성자\t\t등록일\t\t\t제목\t\t\t내용");
         for (NoticeVO vo : notices) {
            System.out.println(vo);
         }
         break;
      }
      return HomeMenu.ADMIN_NOTICE.getMenu();
   }
   

   // 공지사항 조회
   public int notice(NoticeController controller) throws Exception {
//      Scanner scanner = new Scanner(System.in);
//      if (scanner.hasNextLine()) {
//         scanner.nextLine();
//      }
      while (true) {
         List<NoticeVO> notices = controller.getNotices();
         System.out.println("============================================================");
         System.out.println("글번호 \t 작성자\t\t등록일\t\t\t제목\t\t\t내용");
         for (NoticeVO vo : notices) {
            System.out.println(vo);
         }
         break;
      }
      return HomeMenu.EMP_NOTICE.getMenu();
   }

   // 공지사항 등록
   public int ntcRegister(NoticeController controller) throws Exception {
      while (true) {
         System.out.print("제목: ");
         String title = scanner.nextLine();
         System.out.print("내용: ");
         String contents = scanner.nextLine();
         int insertNotice = controller.insertNotice(new NoticeVO(title, contents));
         if (insertNotice == 1) {
            System.out.println("등록 성공!");
         } else {
            System.out.println("등록 실패!");
         }
         break;
      }
      return HomeMenu.ADMIN_NOTICE.getMenu();
   }

   // 공지사항 수정
   public int ntcModify(NoticeController controller) throws Exception {
      while (true) {
         System.out.print("수정할 글 번호 입력: ");
         int searchNtcNum = Integer.parseInt(scanner.nextLine());
         System.out.print("수정할 제목 입력: ");
         String modifyTitle = scanner.nextLine();
         System.out.print("수정할 내용 입력: ");
         String modifyContents = scanner.nextLine();
         int modifyNotice = controller.modifyNotice(new NoticeVO(searchNtcNum, modifyTitle, modifyContents));
         if (modifyNotice == 1) {
            System.out.println("수정 완료");
         } else {
            System.out.println("수정 실패");
         }
         break;
      }
      return HomeMenu.ADMIN_NOTICE.getMenu();

   }

   // 공지사항 삭제
   public int ntcDelete(NoticeController controller) throws Exception {
      while (true) {
         System.out.print("삭제할 글 번호 입력: ");
         int deleteNtcNum = Integer.parseInt(scanner.nextLine());
         int deleteNotice = controller.deleteNotice(deleteNtcNum);
         if (deleteNotice == 1) {
            System.out.println("삭제 성공");
         } else {
            System.out.println("삭제 실패");
         }
         break;
      }

      return HomeMenu.ADMIN_NOTICE.getMenu();
   }

   // 사원정보 수정
   public int modifyInfo(EmpController controller, HomeMenu menu) {
      while (true) {
         try {
            System.out.print(" 입력해주세요: ");
            String strNum = scanner.nextLine();
            EmpVO vo = new EmpVO();
            vo.setEmpNum(Integer.parseInt(strNum));
            switch (menu) {
            case MODIFY_ADDRESS:
               System.out.print("수정할 주소 입력: ");
               vo.setEmpAdd(scanner.nextLine());
               break;
            case MODIFY_PHONE:
               System.out.print("수정할 전화번호 입력: ");
               vo.setEmpPhNum(scanner.nextLine());
               break;
            case MODIFY_AGE:
               System.out.println("수정할 나이 입력: ");
               vo.setEmpAge(Integer.parseInt(scanner.nextLine()));
               break;
            case MODIFY_ACC:
               System.out.println("수정할 계좌번호 입력: ");
               vo.setEmpAcc(scanner.nextLine());
               break;
            case MODIFY_DEP:
               System.out.println("수정할 부서코드 입력: ");
               vo.setEmpDepCde(scanner.nextLine());
               break;
            case MODIFY_POS:
               System.out.println("수정할 직급코드 입력: ");
               vo.setEmpPosCde(scanner.nextLine());
               break;
            case MODIFY_PAY:
               System.out.println("수정할 급여 입력: ");
               vo.setEmpAnu(Integer.parseInt(scanner.nextLine()));
               break;
            default:
               break;
            }
            controller.modifyInfo(vo, menu);
//            return service.modifyInfo(vo, menu);
         } catch (Exception e) {
            System.out.println("입력값이 올바르지 않습니다. 다시 입력해주세요");
         }
         System.out.println("수정 완료!");
         return HomeMenu.EMPTOTAL.getMenu();
      }
   }

   // 건의사항 등록
   public int sugRegister(SugController controller) throws Exception {

      while (true) {
         System.out.print("제목: ");
         String title = scanner.nextLine();
         System.out.print("내용: ");
         String contents = scanner.nextLine();
         int insertNotice = controller.insertSug(new SugVO(title, contents));
         if (insertNotice == 1) {
            System.out.println("등록 성공!");
         } else {
            System.out.println("등록 실패!");
         }
         break;
      }
      return HomeMenu.EMPSUG.getMenu();
   }
   public int sugRegister2(SugController controller) throws Exception {

      while (true) {
         System.out.print("제목: ");
         String title = scanner.nextLine();
         System.out.print("내용: ");
         String contents = scanner.nextLine();
         int insertNotice = controller.insertSug(new SugVO(title, contents));
         if (insertNotice == 1) {
            System.out.println("등록 성공!");
         } else {
            System.out.println("등록 실패!");
         }
         break;
      }
      return HomeMenu.ADMINSUG.getMenu();
   }

   public int sug(SugController controller) throws Exception {
      List<SugVO> sug = controller.getSug();
      System.out.println("============================================================");
      System.out.println("글번호 \t  제목 \t\t\t\t내용\t\t\t\t\t\t\t 등록일\t\t작성자 사원번호");
      for (SugVO vo : sug) {
         System.out.println(vo);
      }
//            break;
//            }
      return HomeMenu.EMPSUG.getMenu();
   }
   public int sug2(SugController controller) throws Exception {
      List<SugVO> sug = controller.getSug();
      System.out.println("============================================================");
      System.out.println("글번호 \t  제목 \t\t\t\t내용\t\t\t\t\t\t\t 등록일\t\t작성자 사원번호");
      for (SugVO vo : sug) {
         System.out.println(vo);
      }
//            break;
//            }
      return HomeMenu.ADMINSUG.getMenu();
   }

   // 건의사항 수정
   public int sugModify(SugController controller) throws Exception {
      while (true) {
         System.out.print("수정할 글 번호: ");
         int searchSugNum = Integer.parseInt(scanner.nextLine());
         System.out.print("수정할 제목: ");
         String modifySugTit = scanner.nextLine();
         System.out.print("수정할 내용: ");
         String modifySugCon = scanner.nextLine();
         int modifySug = controller.modifySug(new SugVO(searchSugNum, modifySugTit, modifySugCon));
         if (modifySug == 1) {
            System.out.println("수정 완료");
         } else {
            System.out.println("수정 실패");
         }
         break;
      }
      return HomeMenu.EMPSUG.getMenu();

   }
   public int sugModify2(SugController controller) throws Exception {
      while (true) {
         System.out.print("수정할 글 번호: ");
         int searchSugNum = Integer.parseInt(scanner.nextLine());
         System.out.print("수정할 제목: ");
         String modifySugTit = scanner.nextLine();
         System.out.print("수정할 내용: ");
         String modifySugCon = scanner.nextLine();
         int modifySug = controller.modifySug(new SugVO(searchSugNum, modifySugTit, modifySugCon));
         if (modifySug == 1) {
            System.out.println("수정 완료");
         } else {
            System.out.println("수정 실패");
         }
         break;
      }
      return HomeMenu.ADMINSUG.getMenu();

   }


   // 건의사항 삭제
   public int sugDelete(SugController controller) throws Exception {

      while (true) {
         try {
            while (true) {
               System.out.println("삭제할 글 번호를 선택하세요.");
               int deletesug = Integer.parseInt(scanner.nextLine());
               int deletesug1 = controller.deleteSug(deletesug);
               if (deletesug1 == 1) {
                  System.out.println("삭제 성공");
               } else {
                  System.out.println("삭제 실패");
               }
               break;
            }
            return HomeMenu.EMPSUG.getMenu();
         } catch (Exception e) {
            System.out.println("글 번호가 올바르지 않습니다. 다시 입력해주세요");
         }
      }
   }
   public int sugDelete2(SugController controller) throws Exception {

      while (true) {
         try {
            while (true) {
               System.out.println("삭제할 글 번호를 선택하세요.");
               int deletesug = Integer.parseInt(scanner.nextLine());
               int deletesug1 = controller.deleteSug(deletesug);
               if (deletesug1 == 1) {
                  System.out.println("삭제 성공");
               } else {
                  System.out.println("삭제 실패");
               }
               break;
            }
            return HomeMenu.ADMINSUG.getMenu();
         } catch (Exception e) {
            System.out.println("글 번호가 올바르지 않습니다. 다시 입력해주세요");
         }
      }
   }

   public int back1(EmpController controller) {
      return HomeMenu.EMP_MAIN.getMenu();
   }

   // 급여 수정
   public int anuModify(EmpController controller) throws Exception {

      while (true) {
         try {
            while (true) {
               System.out.print("수정할 사원의 사원번호 입력: ");
               int etNum = Integer.parseInt(scanner.nextLine());
               
               System.out.print("수정할 금액을 입력 : ");
               int etNum2 = Integer.parseInt(scanner.nextLine());
               int modifyAnu = controller.modifyAnu(new EmpVO(etNum, etNum2));
               if (modifyAnu == 1) {
                  System.out.println("수정 완료");
               } else {
                  System.out.println("수정 실패");
               }
               return HomeMenu.EXTRA2.getMenu();
            }
         } catch (Exception e) {
            System.out.println("수정할 사원번호를 다시 입력해주세요");
            scanner.next();
            continue;
         }
      }
   }

   // 답글 삭제
   public int repDelete(RepController controller) throws Exception {
      while (true) {
         System.out.println("삭제할 글 번호를 선택하세요.");
         int deleterpe = Integer.parseInt(scanner.nextLine());
         int deleterep1 = controller.deleteRep(deleterpe);
         if (deleterep1 == 1) {
            System.out.println("삭제 성공");
         } else {
            System.out.println("삭제 실패");
         }
         break;
      }

      return HomeMenu.SUG_ANSWER.getMenu();
   }

   public int back2(EmpController controller) {
      return HomeMenu.EMP_MAIN.getMenu();
   }

   // 답글조회
   public int rep(RepController controller) throws Exception {
      List<RepVO> rep = controller.getRep();
      System.out.println("============================================================");
      System.out.println("글번호 \t건의사항(글번호) \t  작성자 \t\t 내용");
      for (RepVO vo : rep) {
         System.out.println(vo);
      }

      return HomeMenu.SUG_ANSWER.getMenu();
   }
   public int rep1(RepController controller) throws Exception {

      List<RepVO> rep1 = controller.getRep();
      System.out.println("============================================================");
      System.out.println("글번호 \t 작성자 \t   등록일 \t\t 제목");
      for (RepVO vo : rep1) {
         System.out.println(vo);
      }

      return HomeMenu.EMPSUG.getMenu();
   }

   // 답글사항 수정
      public int repModify(RepController controller) throws Exception {

         while (true) {
            try {
               while (true) {
                  System.out.print("수정할 내용을 입력: ");
                  String repCon = scanner.nextLine();
                  System.out.print("수정할 글 번호를 입력: ");
                  int repNum = Integer.parseInt(scanner.nextLine());
                  int modifyrep = controller.modifyRep(new RepVO(repCon,repNum));
                  if (modifyrep == 1) {
                     System.out.println("수정 완료");
                  } else {
                     System.out.println("수정 실패");
                  }
                  break;
               }
               return HomeMenu.SUG_ANSWER.getMenu();
            } catch (Exception e) {
               System.out.println("수정할 글 번호가 올바르지 않습니다. 다시 입력해주세요");
            }
         }
      }

   // 답글등록
   public int repRegister(RepController controller) throws Exception {

      while (true) {
         try {
            while (true) {

               System.out.print("답글번호: ");
               int repSumNum = scanner.nextInt();
               scanner.nextLine();
               System.out.print("내용: ");
               String repCon = scanner.nextLine();
               int insertRep = controller.insertRep(new RepVO(repSumNum, repCon));
               if (insertRep == 1) {
                  System.out.println("등록 성공!");
               } else {
                  System.out.println("등록 실패!");
               }
               break;
            }

            return HomeMenu.SUG_ANSWER.getMenu();
         } catch (Exception e) {
            System.out.println("답글번호가 올바르지 않습니다. 다시 입력해주세요");
//            scanner.next();
            continue;
         }
      }
   }

   // 뒤로
   public int ansback(RepController repController) {
      return HomeMenu.EMPSUG.getMenu();
   }
}