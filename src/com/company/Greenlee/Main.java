package com.company.Greenlee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int prompt = menu();

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
        System.out.println("Exiting...");
    }

    private static List<String> tasks = new ArrayList<>();
   // private static List<String> descriptions = new ArrayList<>();

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

    public static void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the task: ");
        String addTask = input.nextLine();
        System.out.println("Adding task...");
        tasks.add(addTask);
        //System.out.println("Enter a description for that task: ");
        //String description = input.nextLine();
    }

    public static int remove() {
        Scanner input = new Scanner(System.in);
        System.out.println("Select a task to remove by index: ");
        int removeTask = input.nextInt();
        tasks.remove(removeTask);
        System.out.println("Removing task...");
        return removeTask;
    }

    public static int update() {
        Scanner input = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        System.out.println("Choose a task to update by index: ");
        int change = input.nextInt();
        System.out.println("Name the new task: ");
        String newTask = string.nextLine();
        tasks.set(change, newTask);
        return change;
    }

    public static void listAll() {
        System.out.println(tasks);
    }
}