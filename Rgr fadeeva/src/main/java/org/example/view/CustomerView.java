package org.example.view;

import org.example.controller.CustomerController;
import org.example.entity.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private CustomerController customerController = new CustomerController();

    public void showCustomer() throws SQLException {
        List<Customer> customers = customerController.getAllCustomer();
        System.out.println("Список клиентов: ");
        customers.forEach(client -> System.out.println(client.toString()));
    }

    public void createCustomer() {
        try {
            Customer newCustomer = new Customer();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newCustomer.setName(name);

            System.out.println("Введите фамилию: ");
            String surname = scanner.nextLine();
            newCustomer.setSurname(surname);

            System.out.println("Введите телефон: ");
            String tel = scanner.nextLine();
            newCustomer.setTelephone(tel);

            System.out.println("Введите паспорт: ");
            String passport = scanner.nextLine();
            newCustomer.setPassport(passport);
            customerController.saveCustomer(newCustomer);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id клиента, которого хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        customerController.deleteCustomer(id);
    }
    public void updateCustomer() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id клиента, которого хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Customer newCustomer;
            newCustomer = customerController.getCustomerById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newCustomer.setName(name);

            System.out.println("Введите фамилию: ");
            String surname = scanner.nextLine();
            newCustomer.setSurname(surname);

            System.out.println("Введите телефон: ");
            String tel = scanner.nextLine();
            newCustomer.setTelephone(tel);

            System.out.println("Введите паспорт: ");
            String passport = scanner.nextLine();
            newCustomer.setPassport(passport);

            customerController.editCustomer(newCustomer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByIdCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id клиента которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (customerController.getCustomerById(id) != null) {
                System.out.println(customerController.getCustomerById(id).toString());
            } else {
                System.out.println("Такого клиента не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdCustomer();
        }
    }
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать всех клиентов");
            System.out.println(" 2. Добавить нового клиента");
            System.out.println(" 3. Удалить клиента ");
            System.out.println(" 4. Обновить информацию о клиенте  ");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showCustomer();
                    break;
                case 2:
                    createCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    getByIdCustomer();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Неверное число!");
            }
        }
    }
}
