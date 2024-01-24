package POS;

import java.util.Scanner;

public class mainDisplay {
	public static void pos() {
		System.out.println("---------------포스 실행--------------");
		System.out.println("");
		System.out.println("---------------재고 등록--------------");
		System.out.println("add 상품명 품목코드 가격 재고수량");
		System.out.println("");
		System.out.println("---------------상품 판매--------------");
		System.out.println("sell 상품명 수량");
		System.out.println("buy 상품명 수량");
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
				DTO dto = new DTO(posInputs[1], posInputs[2], posInputs[3], posInputs[4]);

				//System.out.println(dto.getName()+dto.getCateId()+dto.getCst()+dto.getCnt());

			} // end of if

			if (posInput.startsWith("sell")) {
				if (posInputs.length != 3) {
					System.out.println("판매명령어 오류 다시입력하세요");
					continue;
				}


			} else if (posInput.startsWith("buy")) {
				if (posInputs.length != 3) {
					System.out.println("구매명령어 오류 다시입력하세요");
					continue;
				}
			} else if (posInput.startsWith("list")){
				if(!posInput.startsWith("list")){
					System.out.println("리스트명령문 오류");
				}

				listView lstVi = new listView();

				lstVi.listview();
				continue;
			} else if(posInput.startsWith("printReport")) {
				if(posInputs.length != 1){
					System.out.println("결산명령어 오류 다시입력해주세요");
				}
			}
			 
		} // end of while
	}// end of main
}
