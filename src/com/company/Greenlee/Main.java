package com.company.Greenlee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Trenton Greenlee. 1/30/2020. Project 1. CSCI 1660 - Android Programming Fundamentals (Java).
    public static void main(String[] args) {
        // Calling menu() to ask the user to select an option.
        int prompt = menu();

        // While loop to determine if option integer is not equal to 0 or any option given below.
        while (prompt != 0) {
            switch (prompt) {
                case 1:
                    add();
                    prompt = menu();
                    break;
                case 2:
                    remove();
                    prompt = menu();
                    break;
                case 3:
                    update();
                    prompt = menu();
                    break;
                case 4:
                    listAll();
                    prompt = menu();
                    break;
                default:
                    System.out.println("That is not an option, please ask again.");
                    prompt = menu();
                    break;
            }
        }
        // Will alert the user that the program is stopping if the user entered "0".
        System.out.println("Exiting program...");
    }

    // Array Lists for task names and their corresponding descriptions.
    private static List<String> tasks = new ArrayList<>();
    private static List<String> descriptions = new ArrayList<>();

    // Scanner used to determine what methods use it at least once by only one variable in a method.
    private static Scanner input = new Scanner(System.in);

    // Methods.
    // Did not have to use a return statement for methods 2-5 since both arraylists are not in the main method.
    // Provides user with options based on an integer. Used a return statement since value needs to pass into the main method.
    public static int menu() {
        System.out.println("Please choose an option:\n" +
                "(1) Add a task.\n" +
                "(2) Remove a task.\n" +
                "(3) Update a task.\n" +
                "(4) List all tasks.\n" +
                "(0) Exit.");
        int option = input.nextInt();
        return option;
    }

    // Adding a task and description.
    public static void add() {
        // Need two different scanners since there is more than one variable initialized to a Scanner value.
        Scanner input = new Scanner(System.in);
        Scanner info = new Scanner(System.in);

        System.out.println("Enter the name of the task: ");
        String addTask = input.nextLine();

        System.out.println("Enter a description for that task: ");
        String description = info.nextLine();

        System.out.println("Adding task and description...");
        descriptions.add(description);
        tasks.add(addTask);
        System.out.println("Successfully added task and description.\n");
    }

    // Remove a task, automatically removing its corresponding description based on matching indexes.
    public static void remove() {
        // Need two different scanners since there is more than one variable initialized to a Scanner value.
        Scanner input = new Scanner(System.in);
        Scanner question = new Scanner(System.in);

        // Reminds user if they want to look at the list before removing a task.
        System.out.println("Do you want to reread the list before proceeding?(Use 'yes' or 'no'): ");
        String quest = question.nextLine();
        if (quest.equals("yes")) {
            System.out.println("Processing list...");
            listAll();
        } else if (quest.equals("no")) {
            System.out.println("Proceed to the next step...");
        } else {
            System.out.println("Your answer will not be processed.");
            System.out.println("Proceeding to the next step...\n");
        }

        System.out.println("Select a task to remove by index: ");
        int removeTask = input.nextInt();
        System.out.println("Removing task and description...");
        tasks.remove(removeTask);
        descriptions.remove(removeTask);
        System.out.println("Successfully removed task and description.\n");
    }

    // Update the name of a task and its corresponding description based on matching indexes.
    public static void update() {
        // Need four different scanners since there is more than one variable initialized to a Scanner value.
        Scanner input = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        Scanner info = new Scanner(System.in);
        Scanner question = new Scanner(System.in);

        // Reminds user if they want to look at the list before removing a task.
        System.out.println("Do you want to reread the list before proceeding?(Use 'yes' or 'no'): ");
        String quest = question.nextLine();
        if (quest.equals("yes")) {
            listAll();
        } else if (quest.equals("no")) {
            System.out.println("Proceed to the next step...");
        } else {
            System.out.println("Your answer will not be processed.");
            System.out.println("Proceeding to the next step...\n");
        }

        System.out.println("Choose a task to update by index: ");
        int change = input.nextInt();

        System.out.println("Name the new task: ");
        String newTask = string.nextLine();

        System.out.println("Provide a new description: ");
        String newInfo = info.nextLine();

        System.out.println("Updating task and description...");
        // Both replacements used the change variable so it changes both elements that have matching indexes.
        tasks.set(change, newTask);
        descriptions.set(change, newInfo);
        System.out.println("Successfully updated task and description.\n");
    }

    // List all tasks and their corresponding description based on their indexes.
    public static void listAll() {
        // For loop used to print out tasks with their corresponding description based on matching indexes.
        System.out.println("To-Do List: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i) + " - " + descriptions.get(i));
        }
        System.out.println("\n");
    }
}
