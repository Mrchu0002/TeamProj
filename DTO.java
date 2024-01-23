package testGit;

public class DTO {
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

	private String name;    //상품명
	 private String cateId;  //분류 ID
	 private String cst;    // 가격
	 private String cnt;   // 재고

	public DTO(String name, String cateId, String cst, String cnt) {

		this.name = name;
		this.cateId = cateId;
		this.cst = cst;
		this.cnt =  cnt;
				
	}

 
}
