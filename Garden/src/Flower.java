/*
 * Author: Rustambek Sobithanov
 * File: Flower.java
 * Assignment: Programming Assignment 3 - Garden
 * Course: CSc 210; Fall 2022
 * Purpose: This class implements a Flower class and has methods to plant, grow,
 *          and get the name of the flower
 *
 */


public class Flower extends Plant {
    private char letter;
    private String name;


    /**
     * This method initializes a flower Obj
     * @param type a string, representing the name of the flower
     */
    public Flower(String type) {
        super(type);
        name = type.toLowerCase();
        letter = name.charAt(0);

    }


    /**
     * This method creates a grid of 5x5 cells for the flower
     */
    @Override
    public void plant() {
        grid[2][2] = letter;
    }


    /**
     * This method grows a flower a certain times determined by the provided input
     * @param num an integer specifying how many times a flower should grow
     */
    @Override
    public void grow(int num) {
        growthLevel += num;
        _grow(growthLevel);
    }


    /**
     * A recursive helper function for the above method
     * @param num an integer specifying how many times a flower should grow
     */
    private void _grow(int num) {
        if (num == 0)
            return;
        else if (num == 1) {
            grid[1][2] = letter;
            grid[3][2] = letter;
            grid[2][1] = letter;
            grid[2][3] = letter;
        } else if (num == 2) {
            grid[0][2] = letter;
            grid[1][1] = letter;
            grid[1][3] = letter;
            grid[2][0] = letter;
            grid[2][4] = letter;
            grid[3][1] = letter;
            grid[3][3] = letter;
            grid[4][2] = letter;
        } else if (num == 3) {
            grid[0][1] = letter;
            grid[0][3] = letter;
            grid[1][0] = letter;
            grid[1][4] = letter;
            grid[3][0] = letter;
            grid[3][4] = letter;
            grid[4][1] = letter;
            grid[4][3] = letter;
        } else if (num == 4) {
            grid[0][0] = letter;
            grid[0][4] = letter;
            grid[4][0] = letter;
            grid[4][4] = letter;
        }

        _grow(num - 1);
    }


    /**
     * This method returns the class name
     * @return string representing the class name
     */
    @Override
    public String getPlantClass() {
        return "flower";
    }


    /**
     * This method returns the name of the flower
     * @return string representing the name of the flower
     */
    @Override
    public String getPlantName() {
        return name;
    }
}
