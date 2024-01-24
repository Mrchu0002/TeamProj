package POS;

import java.util.Collection;

public class listView {

    private DAO dao = new DAO();
    public void listview() {
        Collection<productVO> productList = dao.selectList();
        
        
        System.out.println("상품 목록");
        System.out.println("--------------------------------------------------------");
        System.out.printf("| %8s | %8s | %8s | %8s |\n", "상품" , "분류" , "가격" , "재고");


        productList.stream()
        .forEach(vo -> System.out.printf("| %8s | %8s | %8s | %8s |\n",
        vo.getName() , vo.getCateId(), vo.getCst() , vo.getCnt()));
        System.out.println("--------------------------------------------------------");

}
}
