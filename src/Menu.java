import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    protected String name;
    protected String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void display() {
        System.out.println(name + " | " + description);
    }
}

class Product extends Menu {
    protected double price;

    public Product(String name, String description, double price) {
        super(name, description);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class OrderSystem {
    private ArrayList<Product> cart;
    private double total;

    public OrderSystem() {
        cart = new ArrayList<>();
        total = 0.0;
    }

    public void displayMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");

        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. Burgers         | 앵거스 비프 통살을 다져만든 버거");
        System.out.println("2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림");
        System.out.println("3. Drinks          | 매장에서 직접 만드는 음료");
        System.out.println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n");

        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.\n");
    }

    public void displayProductMenu(String category, Product[] products) {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 " + category + " 메뉴판을 보시고 상품을 골라 입력해주세요.\n");

        System.out.println("[ " + category + " MENU ]");
        for (int i = 0; i < products.length; i++) {
            System.out.print(i + 1 + ". ");
            products[i].display();
        }

        System.out.println();
    }

    public void addToCart(Product product) {
        cart.add(product);
        total += product.getPrice();
    }

    public void displayCart() {
        System.out.println("\n[ Orders ]");
        for (Product product : cart) {
            product.display();
        }

        System.out.println("\n[ Total ]");
        System.out.println("W " + total);
    }

    public void placeOrder() {
        displayCart();
        System.out.println("\n1. 주문      2. 메뉴판");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\n주문이 완료되었습니다!\n대기번호는 [ 1 ] 번 입니다.");
            try {
                Thread.sleep(3000); // 3초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cart.clear();
            total = 0;
        }
    }

    public void cancelOrder() {
        cart.clear();
        total = 0;
        System.out.println("\n진행하던 주문이 취소되었습니다.");
    }
}
