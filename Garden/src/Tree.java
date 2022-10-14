/*
 * Author: Rustambek Sobithanov
 * File: Tree.java
 * Assignment: Programming Assignment 3 - Garden
 * Course: CSc 210; Fall 2022
 * Purpose: This class implements a Tree class and has methods to plant, grow,
 *          and get the name of the tree.
 *
 */


public class Tree extends Plant {
    private String name;


    /**
     * This method constructs an instance of a tree class with
     * the given name
     * @param type string, representing a type of tree
     */
    public Tree(String type) {
        super(type);
        name = type.toLowerCase();
    }


    /**
     * This method returns the name of a tree
     * @return string, representing the name of a tree
     */
    public String getName() {
        return name;
    }


    /**
     * This method creates a 5x5 grid of cells for a tree
     */
    @Override
    public void plant() {
        grid[4][2] = name.charAt(0);
    }


    /**
     * This method grows a tree a certain number of times
     * @param num integer, representing how many times a plant should grow
     */
    @Override
    public void grow(int num) {
        growthLevel += num;
        _grow(growthLevel);
    }


    /**
     * This is a recursive helper function for the above method
     * @param num integer, representing how many times a plant should grow
     */
    private void _grow(int num) {
        if (num == 0)
            return;
        if (num == 1)
            grid[3][2] = name.charAt(0);
        if (num == 2)
            grid[2][2] = name.charAt(0);
        if (num == 3)
            grid[1][2] = name.charAt(0);
        if (num == 4)
            grid[0][2] = name.charAt(0);
        _grow(num - 1);
    }


    /**
     * This method returns the name of the class
     * @return string, representing the name of the class
     */
    @Override
    public String getPlantClass() {
        return "tree";
    }


    /**
     * This method returns the name of a tree
     * @return string, representing the name of a tree
     */
    @Override
    public String getPlantName() {
        return name;
    }
}