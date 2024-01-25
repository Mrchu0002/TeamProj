package POS;

import java.util.Collection;

public class listView {

    private DAO dao = new DAO();
    public void listview() {
        Collection<productVO> productList = dao.selectList();
        
        
        System.out.println("상품 목록");
        System.out.println("--------------------------------------------------------");
        System.out.println("| 상품명 | 분류 | 가격 | 재고 |");


        productList.stream()
        .forEach(vo -> System.out.printf("| %s | %s | %s | %s |\n",
        vo.getName() , vo.getCateId(), vo.getCst() , vo.getCnt()));
        System.out.println("--------------------------------------------------------");

        //add 라면0 RM101 1000 100
        //add 라면1 RM102 2000 200
        //add 라면2 RM103 3000 300
    
}
}
