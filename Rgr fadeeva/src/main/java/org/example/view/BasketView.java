package org.example.view;

import org.example.controller.BasketController;
import org.example.entity.Basket;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BasketView {
    private BasketController basketController = new BasketController();

    public void showBasket() throws SQLException {
        List<Basket> baskets = basketController.getAllBaskets();
        System.out.println("Список товаров в корзине: ");
        baskets.forEach(basket -> System.out.println(basket.toString()));
    }

    public void createBasket() {
        try {
            Basket newBasket = new Basket();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите цену: ");
            Float price = scanner.nextFloat();
            newBasket.setPrice(price);

            System.out.println("Введите дату: ");
            String date = scanner.nextLine();
            newBasket.setDate(date);
            basketController.saveBasket(newBasket);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteBasket() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id товара в корзине, который хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        basketController.deleteBasket(id);
    }
    public void updateBasket() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id товара в корзине, который хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Basket newBasket;
            newBasket = basketController.getBasketById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите цену: ");
            Float price = scanner.nextFloat();
            newBasket.setPrice(price);

            System.out.println("Введите дату: ");
            String date = scanner.nextLine();
            newBasket.setDate(date);

            basketController.editBasket(newBasket);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByIdBasket() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id товара в корзине, который хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (basketController.getBasketById(id) != null) {
                System.out.println(basketController.getBasketById(id).toString());
            } else {
                System.out.println("Такого товара не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdBasket();
        }
    }
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать все товары в корзине");
            System.out.println(" 2. Добавить новый товар в корзину");
            System.out.println(" 3. Удалить товар из корзины");
            System.out.println(" 4. Обновить информацию о товаре в корзине");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showBasket();
                    break;
                case 2:
                    createBasket();
                    break;
                case 3:
                    deleteBasket();
                    break;
                case 4:
                    updateBasket();
                    break;
                case 5:
                    getByIdBasket();
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Неверное число!");
            }
        }
    }
}
