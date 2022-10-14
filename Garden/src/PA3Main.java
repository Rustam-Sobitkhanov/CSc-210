/*
 * Author: Rustambek Sobithanov
 * File: PA3Main.java
 * Assignment: Programming Assignment 3 - Garden
 * Course: CSc 210; Fall 2022
 * Purpose: The program simulates the miniature version of Garden. It accepts
 *          an input file in which there are several lines of commands. Using
 *          commands, the program will plant several types of plants (trees,
 *          flowers, vegetables), cuts them, harvests, grows etc. Also, when given
 *          the command to print, the program prints the resulting Garden. The program
 *          is case-insensitive to commands.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PA3Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));
        int rows = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        int cols = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        if (cols > 16) {
            System.out.println("Too many plot columns.");
            return;
        }
        Garden garden = new Garden(rows, cols);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().toLowerCase();
            String[] command = line.split(" ");
            convertToLowerCase(command);

            switch (command[0]) {
                case "plant":
                    gardenPlant(command, garden);
                    break;
                case "print":
                    garden.print();
                    break;
                case "grow":
                    growPlants(command, garden);
                    break;
                case "pick":
                    pickFlowers(command, garden);
                    break;
                case "cut":
                    cutTrees(command, garden);
                    break;
                case "harvest":
                    harvestVeggies(command, garden);
                    break;
            }
        }
    }


    /**
     * This method converts the given array of Strings and converts
     * all the strings to lowercase
     * @param command an array of String commands
     */
    public static void convertToLowerCase(String[] command) {
        for (int i = 0; i < command.length; i++) {
            String part = command[i];
            command[i] = part.toLowerCase();
        }
    }


    /**
     * Growns plants. The method will grow specified plants the specified
     * number of times based on the given command.
     * @param command an array of String commands
     * @param garden a garden Obj
     */
    public static void growPlants(String[] command, Garden garden) {
        int num = Integer.parseInt(command[1]);
        if (command.length == 2) {
            garden.grow(num);
        } else if (command.length == 3) {
            if (command[2].charAt(0) == '(') {
                int[] coords = getCoords(command[2]);
                int x = coords[0];
                int y = coords[1];
                garden.grow(num, x, y);
            } else {
                garden.grow(num, command[2].toLowerCase());
            }
        }
    }


    /**
     * Plants in the garden. The method will plant plants based on the
     * given command.
     * @param command an array of String commands
     * @param garden a garden Obj
     */
    public static void gardenPlant(String[] command, Garden garden) {
        int[] coords = getCoords(command[1]);
        int x = coords[0];
        int y = coords[1];
        String type = command[2];
        garden.plant(x, y, type);
    }


    /**
     * Picks flowers in the garden. The method will either pick all or
     * a type of flower based on the given command.
     * @param command an array of String commands
     * @param garden a garden Obj
     */
    public static void pickFlowers(String[] command, Garden garden) {
        if (command.length == 1)
            garden.pick();
        else if (command.length == 2) {
            if (command[1].charAt(0) == '(') {
                int[] coords = getCoords(command[1]);
                int x = coords[0];
                int y = coords[1];
                garden.pick(x, y);
            } else {
                garden.pick(command[1].toLowerCase());
            }
        }
    }


    /**
     * Cuts trees in the garden. The method will either cut all or
     * one type of tree based on the given command.
     * @param command an array of String commands
     * @param garden a garden Obj
     */
    public static void cutTrees(String[] command, Garden garden) {
        if (command.length == 1)
            garden.cut();
        else if (command.length == 2) {
            if (command[1].charAt(0) == '(') {
                int[] coords = getCoords(command[1]);
                int x = coords[0];
                int y = coords[1];
                garden.cut(x, y);

            } else {
                garden.cut(command[1].toLowerCase());
            }
        }
    }


    /**
     * Harvests the vegetables in the garden. The method will either harvest
     * all or one type of vegetable based on the given command
     * @param command an array of String commands
     * @param garden a garden Obj
     */
    public static void harvestVeggies(String[] command, Garden garden) {
        if (command.length == 1)
            garden.harvest();
        else if (command.length == 2) {
            if (command[1].charAt(0) == '(') {
                int[] coords = getCoords(command[1]);
                int x = coords[0];
                int y = coords[1];
                garden.harvest(x, y);
            } else {
                garden.harvest(command[1].toLowerCase());
            }
        }
    }


    /**
     * Accepts a String representation of xy location of a plant Obj
     * in the garden and converts them into integers
     * @param location Numeric String representing the xy coordinates
     * @return an array of integers which are xy locations
     */
    public static int[] getCoords(String location) {
        String[] coords = location.substring(1, 4).split(",");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        int[] xyCoords = { x, y };
        return xyCoords;
    }
}