package BeforeFeedback;

import java.util.List;
import java.util.Scanner;

public class MenuViewer {

    MenuContext menuContext = new MenuContext();
    Order order = new Order();
    public void displayMainMenu(){
        System.out.println();
        System.out.println();
        System.out.println("SHAKEAHCK BURGER에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요 \n");

        System.out.println("[ SHAKESHACK MENU ]");

        int i = 1;
        List<Menu> mainMenus = menuContext.getMenus("Main");
        for(Menu menu : mainMenus){
            System.out.print(i++ + ". ");
            System.out.println(menu);
        }

        System.out.println();

        System.out.println("[ ORDER MENU ]");
        List<Menu> orderMenus = menuContext.getMenus("Order");
        for (Menu menu : orderMenus){
            System.out.print(i++ + ". ");
            System.out.println(menu);
        }
    }

    public void handleMainMenuInput(){
        displayMainMenu();
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        int mainMenuSize = menuContext.getMenus("Main").size();
        int orderMenuSize = menuContext.getMenus("Order").size();

        if (select <= mainMenuSize){
            displayItemMenu(menuContext.getMenus("Main").get(select-1));
        }else if(select <= mainMenuSize + orderMenuSize){
            int orderSelect = select - mainMenuSize;
            switch (orderSelect){
                case 1:
                    displayOrderMenu();
                    break;
                case 2:
                    displayCancelMenu();
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                    handleMainMenuInput();
            }
        }else {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            handleMainMenuInput();
        }
    }

    public void displayItemMenu(Menu menu){
        System.out.println();
        System.out.println();
        System.out.println("SHAKESHACK BURGER에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요. \n");

        int i = 1;
        System.out.println("[ " + menu.name + " MENU ]");
        List<Item> items = menuContext.getItem(menu.name);
        for(Item item : items){
            System.out.print(i++ + ". ");
            System.out.println(item);
        }
        handleItemInput(items);
    }

    public void handleItemInput(List<Item> items){
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        if (select >= 1 && items.size()>= select){
            Item selectedItem = items.get(select-1);
            displaySelectItem(selectedItem);
        }else {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            handleItemInput(items);
        }
    }

    public void displaySelectItem(Item selectedItem){
        System.out.println();
        System.out.println();
        System.out.println(selectedItem);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인 \t \t 2. 취소");
        handleSelectItemInput(selectedItem);
    }

    public void handleSelectItemInput(Item selectedItem){
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        if (select == 1){
            order.saveList(selectedItem);
            System.out.print(selectedItem.name);
            System.out.println("\t 장바구니에 추가되었습니다.");
            handleMainMenuInput();
        }else if (select == 2){
            handleMainMenuInput();
        }else {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            handleSelectItemInput(selectedItem);
        }
    }

    public void displayOrderMenu(){
        if(!order.savedList.isEmpty()) {
            System.out.println();
            System.out.println();
            System.out.println("아래와 같이 주문 하시겠습니까? \n");
            System.out.println("[ Orders ]");
            order.getSavedList();
            System.out.println();
            System.out.println("[ Total ]");
            order.getTotalPrice();
            System.out.println("1. 주문 \t \t 2. 메뉴판");
            handledOrderMenuInput();
        }else {
            System.out.println("장바구니가 비어있습니다.");
            handleMainMenuInput();
        }
    }

    public void handledOrderMenuInput(){
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();

        if (select == 1){
            displayOrderComplete();
        } else if (select == 2) {
            handleMainMenuInput();
        }else {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            handledOrderMenuInput();
        }

    }

    int wait = 1;
    public void displayOrderComplete(){
        System.out.println();
        System.out.println();
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.println("대기번호는 [ "+ wait++ + " ] 번 입니다.");
        System.out.println("3초후 메뉴판으로 돌아갑니다.");
        order.clearList();
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        handleMainMenuInput();
    }

    public void displayCancelMenu(){
        // 주문 취소 화면
        System.out.println();
        System.out.println();
        System.out.println("진행하던 주물을 취소하시겠습니까?");
        System.out.print("1. 확인 \t \t 2. 취소");
        handledCancelMenuInput();
    }

    public void handledCancelMenuInput(){
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();

        if (select == 1){
            order.clearList();
            System.out.println("진행하던 주문이 취소되었습니다.");
            handleMainMenuInput();
        } else if (select == 2) {
            handleMainMenuInput();
        } else {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            handledCancelMenuInput();
        }
    }

}
