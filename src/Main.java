import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderSystem orderSystem = new OrderSystem();

        while (true) {
            orderSystem.displayMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 5) {
                orderSystem.placeOrder();
            } else if (choice == 6) {
                System.out.println("\n진행하던 주문을 취소하시겠습니까?");
                System.out.println("1. 확인        2. 취소");
                int cancelChoice = scanner.nextInt();

                if (cancelChoice == 1) {
                    orderSystem.cancelOrder();
                }
            } else if (choice >= 1 && choice <= 4) {
                Product[] products = null;
                String category = "";

                switch (choice) {
                    case 1:
                        category = "Burgers";
                        products = new Product[]{
                                new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9),
                                new Product("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9),
                                new Product("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4),
                                new Product("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9),
                                new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4)
                        };
                        break;
                    // Add other categories here

                }
                orderSystem.displayProductMenu(category, products);

                int productChoice = scanner.nextInt();
                if (productChoice >= 1 && productChoice <= products.length) {
                    orderSystem.addToCart(products[productChoice - 1]);
                    System.out.println("\n" + products[productChoice - 1].getName() + " 가 장바구니에 추가되었습니다.\n");
                }
            }
        }
    }
}