package org.example.view;

import org.example.controller.OrderController;
import org.example.entity.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private OrderController orderController = new OrderController();

    public void showOrders() throws SQLException {
        List<Order> orders = orderController.getAllOrders();
        System.out.println("Список товаров : ");
        orders.forEach(product -> System.out.println(product.toString()));
    }

    public void createOrders() {
        try {
            Order newOrder = new Order();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите номер товара: ");
            Integer number = scanner.nextInt();
            newOrder.setNumber(number);

            System.out.println("Введите кол-во товаров: ");
            Integer amount = scanner.nextInt();
            newOrder.setNumber(amount);
            orderController.saveOrder(newOrder);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteOrder() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id товара, который хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        orderController.deleteOrder(id);
    }
    public void updateOrder() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id товара, который хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Order newOrder;
            newOrder = orderController.getOrderById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите номер товара: ");
            Integer number = scanner.nextInt();
            newOrder.setNumber(number);

            System.out.println("Введите кол-во товаров: ");
            Integer amount = scanner.nextInt();
            newOrder.setNumber(amount);

            orderController.editProduct(newOrder);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByIdOrder() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id товара, который хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (orderController.getOrderById(id) != null) {
                System.out.println(orderController.getOrderById(id).toString());
            } else {
                System.out.println("Такого товара не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdOrder();
        }
    }
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать все товары");
            System.out.println(" 2. Добавить новый товар");
            System.out.println(" 3. Удалить товар");
            System.out.println(" 4. Обновить информацию о товаре");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showOrders();
                    break;
                case 2:
                    createOrders();
                    break;
                case 3:
                    deleteOrder();
                    break;
                case 4:
                    updateOrder();
                    break;
                case 5:
                    getByIdOrder();
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
