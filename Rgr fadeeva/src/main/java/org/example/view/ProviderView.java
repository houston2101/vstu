package org.example.view;

import org.example.controller.ProviderController;
import org.example.entity.Provider;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProviderView {
    private ProviderController providerController = new ProviderController();

    public void showClients() throws SQLException {
        List<Provider> providers = providerController.getAllProviders();
        System.out.println("Список продавцов: ");
        providers.forEach(provider -> System.out.println(provider.toString()));
    }

    public void createProvider() {
        try {
            Provider newProvider = new Provider();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newProvider.setName(name);

            System.out.println("Введите фамилию: ");
            String lastname = scanner.nextLine();
            newProvider.setLastname(lastname);

            System.out.println("Введите вид товаров: ");
            String sp = scanner.nextLine();
            newProvider.setSpeciality(sp);

            providerController.saveProvider(newProvider);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteProvider() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id продавца, которого хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        providerController.deleteProvider(id);
    }
    public void updateProvider() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id продавца, которого хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Provider newProvider;
            newProvider = providerController.getProviderById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newProvider.setName(name);

            System.out.println("Введите фамилию: ");
            String lastname = scanner.nextLine();
            newProvider.setLastname(lastname);

            System.out.println("Введите вид товаров: ");
            String sp = scanner.nextLine();
            newProvider.setSpeciality(sp);

            providerController.editProvider(newProvider);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByIdProvider() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id продавца, которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (providerController.getProviderById(id) != null) {
                System.out.println(providerController.getProviderById(id).toString());
            } else {
                System.out.println("Такого продавца не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdProvider();
        }
    }
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать всех продавцов");
            System.out.println(" 2. Добавить нового продавца");
            System.out.println(" 3. Удалить продавца");
            System.out.println(" 4. Обновить информацию о продавце");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showClients();
                    break;
                case 2:
                    createProvider();
                    break;
                case 3:
                    deleteProvider();
                    break;
                case 4:
                    updateProvider();
                    break;
                case 5:
                    getByIdProvider();
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
