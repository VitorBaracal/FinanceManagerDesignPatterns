package Menus.Entities;

import Controllers.PaymentController;

import java.util.Scanner;

public class PaymentMenu {

    private final PaymentController controller;
    private final Scanner input = new Scanner(System.in);

    public PaymentMenu(PaymentController controller) {
        this.controller = controller;
    }

    public void showMenu() {

        System.out.println();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║                    PAYMENT                     ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║  1. Card                                       ║");
        System.out.println("║  2. Pix                                        ║");
        System.out.println("║  0. Back to Main Menu                          ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("Enter your choice: ");

        resolvePaymentOptions();

    }

    public void resolvePaymentOptions() {

        int option = input.nextInt();
        input.nextLine();
        navigate(option);

    }

    public void navigate(int option) {

        switch (option) {
            case 1:
                controller.pay(1);
                showMenu();
                break;
            case 2:
                controller.pay(2);
                showMenu();
                break;
            case 0:
                break;
        }

    }
}
