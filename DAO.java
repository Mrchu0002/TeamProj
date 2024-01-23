package POS;

import java.util.Collection;
import java.util.HashMap;

public class DAO {
       //DB 역할
       HashMap<String , productVO> prodMap = new HashMap<String , productVO>();
   
       // 상품 추가시 저장하는 함수
       public void insert(productVO vo) {
              prodMap.put(vo.getEmail(), vo);
       }
   
       //전달받은 상품명으로 등록된 회원정보 꺼내오기
       public productVO selectOne(String name) {
           return prodMap.get(name);
       }

       //전체 상품 리스트 꺼내오기
       public Collection<productVO> selectList() {
           return prodMap.values();
       }
      
       // 재고수량 업데이트?
       public void update(productVO vo) {
              prodMap.put(vo.getCnt(), vo);
       }
   
   }
   