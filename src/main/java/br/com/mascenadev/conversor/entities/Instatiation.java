
package br.com.mascenadev.conversor.entities;

import br.com.mascenadev.conversor.service.ConsumeApi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Instatiation {


    private final ConsumeApi consumeApi = new ConsumeApi();
    private final Scanner sc = new Scanner(System.in);

    public void displayMenu() {

        int option;
        do {
            System.out.println("""
                        ************************************************
                         Welcome to the currency converter!
                         Choose an option:
                    
                         1 - Real ==> Dollar
                         2 - Dollar ==> Real
                         3 - Euro ==> Real
                         4 - Real ==> Euro
                         5 - Euro ==> Dollar
                         6 - Dollar ==> Euro
                    
                         0 - Exit
                        ************************************************
                    """);

            option = getUserOption();
            processOption(option);
        } while (option != 0);
    }

    private int getUserOption() {
        try {
            System.out.print("Enter your choice: ");
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid option! Only numbers are allowed.\n");
            sc.nextLine();
            return -1;
        }
    }

    private void processOption(int option) {
        switch (option) {
            case 1 -> convert("USD", consumeApi.getData("BRL", "USD"));
            case 2 -> convert("BRL", consumeApi.getData("USD", "BRL"));
            case 3 -> convert("BRL", consumeApi.getData("EUR", "BRL"));
            case 4 -> convert("EUR", consumeApi.getData("BRL", "EUR"));
            case 5 -> convert("USD", consumeApi.getData("EUR", "USD"));
            case 6 -> convert("EUR", consumeApi.getData("USD", "EUR"));
            case 0 -> System.out.println("Exiting...\n");
            default -> System.out.println("Invalid option! Please choose a valid option.\n");
        }
    }

    private void convert(String currency, Double exchangeRate) {
        System.out.print("Enter the amount to be converted: ");
        try {
            double amount = Double.parseDouble(sc.next());
            if (amount <= 0) {
                System.out.println("\nEnter a value greater than 0!\n");
                return;
            }
            double result = amount * exchangeRate;
            System.out.printf("\nConverted value => %.2f %s\n\n", result, currency);
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid value! Only numbers are allowed.\n");
        }
    }
}