/*
 * Author: Rustambek Sobithanov
 * File: Garden.java
 * Assignment: Programming Assignment 3 - Garden
 * Course: CSc 210; Fall 2022
 * Purpose: This program implements a Garden class which has methods like cut,
 *          grow, harvest etc. to perform certain actions in the garden.
 *
 */

import java.util.Arrays;


public class Garden {

    private int row;
    private int column;
    private Plant[][] plants;
    private Plant newPlant;
    private String[] flowers = { "iris", "lily", "rose", "daisy", "tulip", "sunflower" };
    private String[] trees = { "oak", "willow", "banana", "coconut", "pine" };
    private String[] vegetables = { "garlic", "zucchini", "tomato", "yam", "lettuce" };


    /**
     * Initializes the garden Obj and creates a 2D array using the given
     * inputs of row and column
     * @param row integer representation of a height of the garden
     * @param column integer representation of a width of the garden
     */
    public Garden(int row, int column) {
        this.row = row;
        this.column = column;
        plants = new Plant[row][column];

    }


    /**
     * PLants a plant. This method plants a specified plant at a given
     * xy coordinate in the garden
     * @param x x coordinate
     * @param y y coordinate
     * @param type String specifying the type of plant
     */
    public void plant(int x, int y, String type) {
        boolean foundInFlowers = Arrays.asList(flowers).contains(type);
        boolean foundInTrees = Arrays.asList(trees).contains(type);
        boolean foundInVegetables = Arrays.asList(vegetables).contains(type);

        if (foundInFlowers) {
            this.newPlant = new Flower(type);
        } else if (foundInTrees) {
            this.newPlant = new Tree(type);
        } else if (foundInVegetables) {
            this.newPlant = new Vegetable(type);
        }

        newPlant.plant();
        if (plants[x][y] != null) {
            System.out.println("Can't plant there.\n");
            return;
        }
        plants[x][y] = newPlant;
    }


    /**
     * Grows plants. This method grows all the plants in the garden specified
     * number of times
     * @param num an integer representing how many times plants should grow
     */
    public void grow(int num) {
        System.out.println("> GROW " + num + "\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Plant plant = plants[i][j];
                if (plant != null)
                    plant.grow(num);
            }
        }
    }


    /**
     * Grows plants. This method grows a certain plant certain number of times
     * based on the provided inputs
     * @param num an integer representing how many times plants should grow
     * @param plantType a string representing a type of plant
     */
    public void grow(int num, String plantType) {
        System.out.println("> GROW " + num + " " + plantType + "\n");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Plant plant = plants[i][j];
                if (plant != null)
                    if (plant.getPlantClass().equals(plantType))
                        plant.grow(num);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Plant plant = plants[i][j];
                if (plant != null)
                    if (plant.getPlantName().equals(plantType))
                        plant.grow(num);
            }
        }
    }


    /**
     * Grows a plant. This method grows a plant certain times at a given location.
     * If there is nothing there, it prints "Can't grow there."
     * @param num an integer representing how many times plants should grow
     * @param x x coordinate
     * @param y y coordinate
     */
    public void grow(int num, int x, int y) {
        System.out.println("> GROW " + num + " (" + x + "," + y + ")\n");
        if (x >= plants.length || x < 0 || y >= plants[0].length || y < 0) {
            System.out.println("Can't grow there.\n");
            return;
        }
        if (plants[x][y] == null) {
            System.out.println("Can't grow there.\n");
            return;
        }
        plants[x][y].grow(num);
    }


    /**
     * The method harvests (removes) all the vegetables in the garden
     */
    public void harvest() {
        System.out.println("> HARVEST\n");
        for (int i = 0; i < row; i++) {
            for (int n = 0; n < 5; n++) {
                for (int j = 0; j < column; j++) {
                    Plant plant = plants[i][j];
                    if (plant != null)
                        if (plant.getPlantClass() == "vegetable")
                            plants[i][j] = null;
                }
            }
        }
    }


    /**
     * This method harvests (removes) all vegetables of a certain type.
     * @param vegetableType a string, representing a vegetable type
     */
    public void harvest(String vegetableType) {
        System.out.println("> HARVEST " + vegetableType + "\n");
        for (int i = 0; i < row; i++) {
            for (int n = 0; n < 5; n++) {
                for (int j = 0; j < column; j++) {
                    Plant plant = plants[i][j];
                    if (plant != null)
                        if (plant.getPlantName().equals(vegetableType))
                            plants[i][j] = null;
                }
            }
        }
    }


    /**
     * This method harvests vegetable at a given location. If the location is invalid,
     * or there is nothing, it prints, "Can't harvest there."
     * @param x x coordinate
     * @param y y coordinate
     */
    public void harvest(int x, int y) {
        System.out.println("> HARVEST " + "(" + x + "," + y + ")\n");
        if (x >= plants.length || x < 0 || y >= plants[0].length || y < 0) {
            System.out.println("Can't harvest there.\n");
            return;
        }
        if (!plants[x][y].getPlantClass().equals("vegetable")) {
            System.out.println("Can't harvest there.\n");
            return;
        }
        plants[x][y] = null;
    }


    /**
     * This method picks (removes) all flowers from the garden
     */
    public void pick() {
        System.out.println("> PICK\n");
        for (int i = 0; i < row; i++) {
            for (int n = 0; n < 5; n++) {
                for (int j = 0; j < column; j++) {
                    Plant plant = plants[i][j];
                    if (plant != null)
                        if (plant.getPlantClass().equals("flower"))
                            plants[i][j] = null;
                }
            }
        }
    }


    /**
     * This method picks flowers of the provided type
     * @param type a string, representing a type of flower
     */
    public void pick(String type) {
        System.out.println("> PICK " + type + "\n");
        for (int i = 0; i < row; i++) {
            for (int n = 0; n < 5; n++) {
                for (int j = 0; j < column; j++) {
                    Plant plant = plants[i][j];
                    if (plant != null)
                        if (plant.getPlantName().equals(type.toLowerCase()))
                            plants[i][j] = null;
                }
            }
        }
    }


    /**
     * This method picks the flower at a given location. If there aren't flowers,
     * it will print, "Can't pick there."
     * @param x x coordinate
     * @param y y coordinate
     */
    public void pick(int x, int y) {
        System.out.println("> PICK " + "(" + x + "," + y + ")\n");
        if (x >= plants.length || x < 0 || y >= plants[0].length || y < 0) {
            System.out.println("Can't pick there.\n");
            return;
        }
        if (plants[x][y] == null) {
            System.out.println("Can't pick there.");
            return;
        }
        if (!plants[x][y].getPlantClass().equals("flower")) {
            System.out.println("Can't pick there.\n");
            return;
        }
        plants[x][y] = null;
    }


    /**
     * This method cuts (removes) all trees from the garden
     */
    public void cut() {
        System.out.println("> CUT\n");
        for (int i = 0; i < row; i++) {
            for (int n = 0; n < 5; n++) {
                for (int j = 0; j < column; j++) {
                    Plant plant = plants[i][j];
                    if (plant != null)
                        if (plant.getPlantClass().equals("tree"))
                            plants[i][j] = null;
                }
            }
        }
    }


    /**
     * This method cuts (removes) tree at a given location. If there are no trees,
     * it will print, "Can't cut there."
     * @param x x coordinate
     * @param y y coordinate
     */
    public void cut(int x, int y) {
        System.out.println("> CUT " + "(" + x + "," + y + ")\n");
        if (x >= plants.length || x < 0 || y >= plants[0].length || y < 0) {
            System.out.println("Can't cut there.\n");
            return;
        }
        if (!plants[x][y].getPlantClass().equals("tree")) {
            System.out.println("Can't cut there.\n");
            return;
        }
        plants[x][y] = null;
    }


    /**
     * This method cuts (removes) all trees of a certain type
     * @param type a string, representig a type of tree
     */
    public void cut(String type) {
        System.out.println("> CUT " + type + "\n");
        for (int i = 0; i < row; i++) {
            for (int n = 0; n < 5; n++) {
                for (int j = 0; j < column; j++) {
                    Plant plant = plants[i][j];
                    if (plant != null)
                        if (plant.getPlantName().equals(type.toLowerCase()))
                            plants[i][j] = null;
                }
            }
        }
    }


    /**
     * This method prints the garden
     */
    public void print() {
        System.out.println("> PRINT");
        for (int i = 0; i < row; i++) {
            for (int n = 0; n < 5; n++) {
                for (int j = 0; j < column; j++) {
                    Plant plant = plants[i][j];
                    if (plant != null)
                        System.out.print(plant.grid[n]);
                    else
                        System.out.print(".....");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
