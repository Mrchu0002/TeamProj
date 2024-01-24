package POS;


public class RegiProd {

  private DAO dao;

  public RegiProd() {
    this.dao = new DAO();
  }

  public void regist(DTO dto) {

    productVO vo = new productVO(dto.getName(), dto.getCateId(), dto.getCst(), dto.getCnt());

    // 기존에 등록된 상품인지 확인
    if (dao.selectOne(dto.getName()) != null) {
      System.out.println("이미 등록된 회원의 이메일과 중복됩니다.");
      return;
    }

    dao.insert(vo);// MemberDAO 메소드를 통해 DB에 등록
    System.out.println("등록했습니다.");

  }// end of regist

}