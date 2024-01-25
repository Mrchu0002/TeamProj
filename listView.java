package POS;

import java.util.Collection;

public class listView {

    private DAO dao = new DAO();
    public void listview() {
        Collection<productVO> productList = dao.selectList();
        
        String name = "상품";
        String category = "분류";
        String cost = "가격";
        String count = "재고";
        
        System.out.println("상품 목록");
        System.out.println("--------------------------------------------------------");
        System.out.printf("%s : [%s], %s, %s \n" , name, category , cost, count);


        productList.stream()
        .forEach(vo -> System.out.printf("%s : [%s], %s, %s \n",
        vo.getCateId(), vo.getName(), vo.getCst(), vo.getCnt())); //여기 순서 바꾸고
        System.out.println("--------------------------------------------------------");

}
}
