package BeforeFeedback;

import java.util.ArrayList;
import java.util.List;
public class Order {
    /*
     * 선택 상품 저장
     * 선택 상품 출력*/

    List<Item> savedList = new ArrayList<>();

    public void saveList (Item item){
        // 주문 리스트 저장
        savedList.add(item);
    }
    public void clearList(){
        // 주문 리스트 초기화
        savedList.clear();
    }

    public void getSavedList() {
        // 주문 리스트 출력
        for (Item item : savedList){
            System.out.println(item);
        }
    }

    public void getTotalPrice(){
        // 주문 리스트 총 금액
        Double totalPrice = savedList.stream().mapToDouble(Item::getPrice).sum();
        System.out.println("W " + totalPrice);
    }
}