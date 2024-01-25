package POS;

public class change {
    private DAO dao;

    public change() {
        this.dao = new DAO();
    }

    public void buy(Strin[] posInput) {
        String name = posInput[1];
        String cateId = posInput[2];
        String cst = posInput[3];
        String cnt = posInput[4];

        productVO vo = dao.selectOne(cnt);
        if (vo == null) {
            System.out.println("입력하신 상품이 존재하지 않습니다.");
            return;
        }

        if (vo.getName().equals(name)) {
            vo.setCnt(vo.getCnt() + posInput[4]);
        } else {
            System.out.println("입력하신 상품이 존재하지 않습니다.");
        }

    } // 구매

    public void sell() {
        String name = posInput[1];
        String cateId = posInput[2];
        String cst = posInput[3];
        String cnt = posInput[4];

        productVO vo = dao.selectOne(cnt);
        if (vo == null) {
            System.out.println("입력하신 상품이 존재하지 않습니다.");
            return;
        }

        if (vo.getName().equals(name)) {
            vo.setCnt(vo.getCnt - posInput[4]);
        } else {
            System.out.println("입력하신 상품이 존재하지 않습니다.");
            return;
        }
    }

    // 일정 재고 수치 이하시 알림 --내부함수

}

// else if (posInput.startsWith("buy")) {
// if (posInputs.length != 3) {
// System.out.println("구매명령어 오류 다시입력하세요");
// // pos();
// continue;
// }