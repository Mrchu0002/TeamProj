package TeamProject;

public class productVO {
    private String name;    //상품명
    private String cateId;  //분류 ID
    private int cst;    // 가격
    private int cnt;   // 재고


    public productVO(String name, String cateId, int cst, int cnt) {
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public int getCst() {
        return cst;
    }

    public void setCst(int cst) {
        this.cst = cst;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    

}
