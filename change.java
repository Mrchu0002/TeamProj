package POS;

public class change {
    private DAO dao;

    public change() {
        this.dao = new DAO();
    }

    public void buy(String[] posInputs) {
        String inputName = posInputs[1];
        int inputCnt = Integer.parseInt(posInputs[2]);

        productVO vo = dao.selectOne(posInputs[1]);
        if (vo == null) {
            System.out.println("입력하신 상품이 존재하지 않습니다.");
            return;
        }

        if (vo.getName().equals(inputName)) {
            int nowCnt = Integer.parseInt(vo.getCnt());
            // vo.setCnt(nowCnt + inputCnt);
            vo.setCnt(Integer.toString(nowCnt + inputCnt));
        } else {
            System.out.println("입력하신 상품이 존재하지 않습니다.");
            return;
        }

    } // 구매

    public void sell(String[] posInputs) {
        String inputName = posInputs[1];
        int inputCnt = Integer.parseInt(posInputs[2]);

        productVO vo = dao.selectOne(posInputs[1]);
        if (vo == null) {
            System.out.println("입력하신 상품이 존재하지 않습니다.");
            return;
        }

        if (vo.getName().equals(inputName)) {
            int nowCnt = Integer.parseInt(vo.getCnt());
            // vo.setCnt(nowCnt - inputCnt);
            vo.setCnt(Integer.toString(nowCnt - inputCnt));
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