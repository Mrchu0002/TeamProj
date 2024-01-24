package POS;

import java.util.Collection;

public class listView {

    private DAO dao = new DAO();
    public void listview() {
        Collection<productVO> productList = dao.selectList();
        
        
        System.out.println("상품 목록");
        System.out.println("--------------------------------------------------------");
        System.out.println("| 상품명 \t| 분류 \t| 가격 \t| 재고 \t|");


        productList.stream()
        .forEach(vo -> System.out.printf("| %s \t| %s \t| %s \t| %s \t|\n",
        vo.getName() , vo.getCateId(), vo.getCst() , vo.getCnt()));
        System.out.println("--------------------------------------------------------");

}
}
