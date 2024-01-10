package BeforeFeedback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuContext {
    Map<String, List<Menu>> menus;
    Map<String, List<Item>> items;
    double totalPrice;
    int orderNumber;

    public MenuContext(){
        menus = new HashMap<>();
        items = new HashMap<>();

        initializeMenuItem();
    }

    private void initializeMenuItem(){

        List<Menu> mainMenuList = new ArrayList<>();
        mainMenuList.add(new Menu("Burgers","앵거스 비프 통살을 다져만든 버거"));
        mainMenuList.add(new Menu("Drinks","매장에서 직접 만드는 음료"));
        mainMenuList.add(new Menu("Beers","뉴욕 브루클린에서 양조한 맥주"));

        List<Menu> orderMenuList = new ArrayList<>();
        orderMenuList.add(new Menu("Order", "장바구니를 확인 후 주문합니다."));
        orderMenuList.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));

        menus.put("Main", mainMenuList);
        menus.put("Order", orderMenuList);

        List<Item> burgersMenuList = new ArrayList<>();
        burgersMenuList.add(new Item("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9));
        burgersMenuList.add(new Item("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9));
        burgersMenuList.add(new Item("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4));
        burgersMenuList.add(new Item("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9));
        burgersMenuList.add(new Item("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4));


        List<Item> drinksMenuList = new ArrayList<>();
        drinksMenuList.add(new Item("CocaCola", "근본 코카 콜라", 2.0));
        drinksMenuList.add(new Item("Sprite", "버거에는 시원한 스프라이트", 2.0));
        drinksMenuList.add(new Item("Water", "0Kcal의 물!", 1.0));

        List<Item> beersMenuList = new ArrayList<>();
        beersMenuList.add(new Item("Cass", "카-스", 4.0));
        beersMenuList.add(new Item("Terra", "테-라", 5.0));
        beersMenuList.add(new Item("Kelly", "캘-리", 6.0));

        items.put("Burgers",burgersMenuList);
        items.put("Drinks",drinksMenuList);
        items.put("Beers",beersMenuList);
    }

    public List<Menu> getMenus(String key){
        return menus.get(key);
    }

    public List<Item> getItem(String key){
        return items.get(key);
    }




}
