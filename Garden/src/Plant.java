/*
 * Author: Rustambek Sobithanov
 * File: Plant.java
 * Assignment: Programming Assignment 3 - Garden
 * Course: CSc 210; Fall 2022
 * Purpose: This program implements an abstract Plant class for the Garden program.
 *
 */


abstract class Plant {
    String type;
    int growthLevel;
    char[][] grid;


    /**
     * Constructs the plant Obj and initializes a 2D array of cells
     * @param type string, representing a type of plant
     */
    public Plant(String type) {
        this.type = type.toLowerCase();
        growthLevel = 0;
        grid = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = '.';
            }
        }
    }


    /**
     * This method creates a grid of 5x5 cells for a plant
     */
    abstract void plant();


    /**
     * This method grows a plant a specified number of times
     * @param num integer, representing how many times a plant should grow
     */
    abstract void grow(int num);


    /**
     * This method returns the name of a plant class
     * @return string, the name of a plant Class
     */
    abstract String getPlantClass();


    /**
     * This method returns the name of the plant
     * @return string, representing the name of a plant
     */
    abstract String getPlantName();


    /**
     * This method prints the grid of a plant Obj
     */
    public void print() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
