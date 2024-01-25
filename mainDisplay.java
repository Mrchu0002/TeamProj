package POS;

import java.util.Scanner;
import javax.swing.SwingUtilities;

public class mainDisplay {
   public static void pos() {
      System.out.println("---------------포스 실행--------------");
      System.out.println("");
      System.out.println("---------------재고 등록--------------");
      System.out.println("add 품목코드 상품명 가격 재고수량");
      System.out.println("");
      System.out.println("---------------상품 판매--------------");
      System.out.println("sell 품목코드 수량");
      System.out.println("buy 품목코드 수량");
      System.out.println("");
      System.out.println("-------------현재 보유 상품------------");
      System.out.println("list 품목코드");
      System.out.println("list 상품명");
      System.out.println("list 재고");
      System.out.println("");
      System.out.println("---------------매출 결산--------------");
      System.out.println("\t" + " " + " " + " " + " " + "printReport\t");
      System.out.println("-----------------------------------");
   }

   public static void main(String[] args) {
      pos();
      int regiCnt = 0;

      
      // 초기 기본데이터 입력
      Sample sample = new Sample();
      String[] rm100_cateId = sample.idSplitter(sample.getRM100());
      String[] rm100_name = sample.nameSplitter(sample.getRM100());
      String[] rm100_cost = sample.costSplitter(sample.getRM100());
      String[] rm100_count = sample.contSplitter(sample.getRM100());

      for (int i = 0 ; i < rm100_cateId.length ; i ++ ) {
         // System.out.println(rm100_name[i].length() + "의 길이");
         DTO dto = new DTO(rm100_cateId[i] , rm100_name[i] , rm100_cost[i] , rm100_count[i]);
         RegiProd preregSrv = new RegiProd();
            preregSrv.preregist(dto);
      }
      


      //
      Scanner sc = new Scanner(System.in);

      while (true) {
         System.out.println("명령어를 입력하세요");
         String posInput = sc.nextLine();

         String[] posInputs = posInput.split(" ");
         // 명령어 유효성 검사
         if (posInput.startsWith("add")) {
            if (posInputs.length != 5) {
               System.out.println("명령어 입력오류 다시입력하세요");
               pos();
               continue;
            }
            

            // 전달받은 데이터를 RequestDTO 객체에 담는다.
            DTO dto = new DTO(posInputs[1], posInputs[2], posInputs[3], posInputs[4]);

            RegiProd regSrv = new RegiProd();
            regSrv.regist(dto);

            if (regSrv.regist(dto) == 1)
               regiCnt++;
            System.out.println("현재 "+ regiCnt +"개의 상품이 등록되었습니다.");

         } else if (posInput.compareToIgnoreCase("list") == 0) {

            listView lstSrv = new listView();

            // 전체회원정보 목록 출력
            lstSrv.listview();

            // System.out.println(dto.getName()+dto.getCateId()+dto.getCst()+dto.getCnt());

         } // end of if

         if (posInput.startsWith("sell")) {
            if (posInputs.length != 3) {
            System.out.println("판매명령어 오류 다시입력하세요");
            continue;
         }
         change selling = new change();
         selling.sell(posInputs);

         } else if (posInput.startsWith("buy")) {
         if (posInputs.length != 3) {
         System.out.println("구매명령어 오류 다시입력하세요");
         continue;
         }
         change buying = new change();
         buying.buy(posInputs);
         } else if (posInput.startsWith("list")){
         if(!posInput.startsWith("list")){
         System.out.println("리스트명령문 오류");
         }
         // listView lstVi = new listView();
         // lstVi.listview();
         // continue;
         } else if(posInput.startsWith("printReport")) {
         if(posInputs.length != 1){
         System.out.println("결산명령어 오류 다시입력해주세요");
		 
         }
         }

      } // end of while
   }// end of main
   }
