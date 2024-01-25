package POS;


public class RegiProd {

  private DAO dao;

  public RegiProd() {
    this.dao = new DAO();
  }

  public int regist(DTO dto) { // 출력형 int 형으로 바꾼 이유  < -- add 시 실행되는데 추가한 건수 카운트용으로

    productVO vo = new productVO(dto.getName(), dto.getCateId(), dto.getCst(), dto.getCnt());

    // 기존에 등록된 상품인지 확인
    if (dao.selectOne(dto.getName()) != null) {
      System.out.println("이미 등록된 상품명과 중복됩니다.");
      return 0;
    }

    dao.insert(vo);// MemberDAO 메소드를 통해 DB에 등록
    System.out.println("등록했습니다.");
    
    return 1;

  }// end of regist

}