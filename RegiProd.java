package POS;


public class RegiProd {

  private DAO dao;

  public RegiProd() {
    this.dao = new DAO();
  }

  public int regist(DTO dto) {

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