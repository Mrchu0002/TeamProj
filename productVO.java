package POS;

public class productVO {
    private String name; // 상품명
    private String cateId; // 분류 ID
    private String cst; // 가격
    private String cnt; // 재고

    public productVO(String name, String cateId, String cst, String cnt) {
        this.name = name;
        this.cateId = cateId;
        this.cst = cst;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "MemberVO [name=" + name + ", cateId=" + cateId + ", cost=" + cst + ", count=" + cnt
                + "]";
    }

    public String getName() {
        return cateId;
    }

    public void setName(String name) {
        this.name = cateId;
    }

    public String getCateId() {
        return name;
    }

    public void setCateId(String cateId) {
        this.cateId = name;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

}