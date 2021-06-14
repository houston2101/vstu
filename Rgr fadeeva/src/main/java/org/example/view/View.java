package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class View {

    private static View view;
    private CustomerView customerView;
    private OrderView orderView;
    private BasketView basketView;
    private ProviderView providerView;

    public View() {
        customerView = new CustomerView();
        orderView = new OrderView();
        basketView = new BasketView();
        providerView = new ProviderView();
    }

    public static View getInstance(){
        if(view==null){
            view = new View();
        }
        return view;
    }

    public void run() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию для операции: ");
            System.out.println("Введите число : ");
            System.out.println("1. Клиент");
            System.out.println("2. Корзина");
            System.out.println("3. Продавцы");
            System.out.println("4. Товар");
            System.out.println("5. Выход");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runClient();
                    break;
                case 2:
                    runBasket();
                    break;
                case 3:
                    runSeller();
                    break;
                case 4:
                    runProduct();
                    break;
                case 5:
                    go = false;
                    break;
                default:
                    System.out.println("Не верное число");
                    System.out.println("Введите числа от 1 до 4, пожалуйста");
            }
        }
    }

    private void runClient() throws SQLException {
        customerView.run();
    }

    private void runBasket() throws SQLException {
        basketView.run();
    }

    private void runSeller() throws SQLException {
        providerView.run();
    }

    private void runProduct() throws SQLException {
        orderView.run();
    }

}
