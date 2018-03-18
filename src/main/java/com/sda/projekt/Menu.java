package com.sda.projekt;

import java.util.Scanner;

public class Menu {

    public static void showMenu() {
        CommandOnDB commandOnDB = new CommandOnDB();

        System.out.println("Wybierz opcję: ");
        System.out.println("1 - Dodaj klienta");
        System.out.println("2 - Wyświetl klientów");
        System.out.println("3 - Edytuj klienta");
        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();

        switch (wybor) {
            case 1:
                commandOnDB.addCustommer();
                break;
            case 2:
                commandOnDB.showCustommers();
                break;
            case 3:
                commandOnDB.editCustomer();
                break;
                default:
                    System.out.println("Bład wyboru!");


        }
    }

}