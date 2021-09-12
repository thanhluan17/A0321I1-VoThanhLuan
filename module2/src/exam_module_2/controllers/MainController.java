package exam_module_2.controllers;

import exam_module_2.services.impl.BenhAnServiceImpl;

import java.util.Scanner;

public class MainController {
    Scanner scanner = new Scanner(System.in);
    BenhAnServiceImpl benhAnThuong = new BenhAnServiceImpl();
    String choice;

    public void displayMainMenu() {
        System.out.println("-----Main Menu-----");
        System.out.println("1. Them moi");
        System.out.println("2. Xoa");
        System.out.println("3. Hien thi");
        System.out.println("4. Exit");
        System.out.println("-----------------");
        System.out.print("Enter your choice: ");
        choice = scanner.nextLine();
        switch (choice) {
            case "1":
                them();
                break;
            case "2":
                xoa();
                break;
            case "3":
                hienThi();
            case "4":
                System.exit(0);
        }

    }

    public void them() {
        System.out.println("Nhap 1 de them benh an thuong, 2 de them benh an vip: ");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            benhAnThuong.themThuong();
            displayMainMenu();
        }
        if (choice.equals("2")) {
            benhAnThuong.themVip();
            displayMainMenu();
        } else {
            System.out.println("Sai dinh dang!");
        }
        displayMainMenu();
    }

    public void xoa() {
        benhAnThuong.delete();
        displayMainMenu();
    }

    public void hienThi() {
        benhAnThuong.display();
        displayMainMenu();
    }
}
