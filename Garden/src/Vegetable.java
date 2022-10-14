/*
 * Author: Rustambek Sobithanov
 * File: Vegetable.java
 * Assignment: Programming Assignment 3 - Garden
 * Course: CSc 210; Fall 2022
 * Purpose: This class implements a Vegetable Class and has methods to plant, grow,
 *          and get the name of the vegetable
 *
 */


public class Vegetable extends Plant {
    private String name;


    /**
     * This method constructs an instance of a vegetable class with
     * a given type of vegetable
     * @param type string, representing a type of vegetable
     */
    public Vegetable(String type) {
        super(type);
        name = type.toLowerCase();

    }


    /**
     * This method creates a 5x5 grid of cells for a vegetable
     */
    @Override
    public void plant() {
        grid[0][2] = type.charAt(0);
    }


    /**
     * This method grows a vegetable a certain number of times
     * @param num integer, representing how many times a plant should grow
     */
    @Override
    public void grow(int num) {
        growthLevel += num;
        _grow(growthLevel);
    }


    /**
     * This is a recursive helper method for the above method
     * @param num integer, representing how many times a plant should grow
     */
    private void _grow(int num) {
        if (num == 0)
            return;
        if (num == 1)
            grid[1][2] = name.charAt(0);
        if (num == 2)
            grid[2][2] = name.charAt(0);
        if (num == 3)
            grid[3][2] = name.charAt(0);
        if (num == 4)
            grid[4][2] = name.charAt(0);
        _grow(num - 1);
    }


    /**
     * This method returns the name of a vegetable class
     * @return string, representing the name of a vegetable class
     */
    @Override
    public String getPlantClass() {
        return "vegetable";
    }


    /**
     * This method returns the name of a vegetable
     * @return string, representing the name of a vegetable
     */
    @Override
    public String getPlantName() {
        return name;
    }
}
