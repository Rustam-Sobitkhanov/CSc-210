import java.util.ArrayList;
import java.util.Scanner;

/*
 * Author: Rustambek Sobithanov
 * File: ConnectFour.java
 * Assignment: Programming Assignment 1 - ConnectFour
 * Course: CSc 210; Fall 2022
 * Purpose: The program implements a game called Connect Four in which there are two players who
 *          turn by turn place a token on a grid and whoever manages to connect 3/4/5 tokens as a
 *          straight line, either horizontally or vertically or diagonally, wins the game.
 *
 */


public class ConnectFour {
    public static void main(String[] args) {
        char[][] columns = new char[7][6];      // the Grid
        int version = getGameVersion();         // version of the game
        ArrayList<String> info = playerInfo();  // has player names and their colors
        boolean notOver = true;                 // determines if the game is over or not
        boolean player1 = true;                 // helps with choosing turns
        while (notOver){                        // loops till the game is over or it grid is full
            if (player1) {
                input(columns, info.get(1).charAt(0));
                player1 = false;
            } else {
                input(columns, info.get(3).charAt(0));
                player1 = true;
            }
            printing(columns);
            if (checkForWin(columns, version)) {    // checks who won the game, if anybody did
                if (player1) {
                    System.out.println(info.get(2) + " won!");
                } else {
                    System.out.println(info.get(0) + " won!");
                }
                notOver = !checkForWin(columns, version);
            } else if (!isItOver(columns)) {
                System.out.println("Draw!");
                notOver = isItOver(columns);
            }
        }
    }


    /**
     * the function of this method is to determine if smb won the game
     * by checking the grade vertically, horizontally, and diagonally
     * @param columns 2d list which is the grid
     * @param version int specifying the version of the game
     * @return a boolean value if smb won the game or not
     */
    public static boolean checkForWin(char[][] columns, int version) {
        ArrayList<Character> checkList = new ArrayList<>();
        // vertical check
        for (char[] col: columns) {
            for (char row: col) {
                checkList.add(row);
            }
            if (check(checkList, version)) {
                return true;
            }
            checkList.removeAll(checkList);
        }

        // horizontal check
        for (int i = 0; i < columns[0].length; i++) {
            for (int j = 0; j < columns.length; j++) {
                checkList.add(columns[j][i]);
            }
            if (check(checkList, version)) {
                return true;
            }
            checkList.removeAll(checkList);
        }

        // diagonal check
        if (descendingVerticalCheck(columns, version)) {
            return true;
        }
        if (ascendingVerticalCheck(columns, version)) {
            return true;
        }
        return false;
    }


    /**
     * the function of this method is to check for a win
     * diagonally from bottom left to top right
     * @param columns 2d list which is the grid
     * @param version int specifying the version of the game
     * @return boolean value if smb won the game or not
     */
    public static boolean ascendingVerticalCheck(char[][] columns, int version) {
        ArrayList<Character> checkList = new ArrayList<>();
        int y = columns.length, x = columns[0].length - 1;
        for (int i = 2 - y; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i + j >= 0 && i + j <= x) {
                    checkList.add(columns[j][i+j]);
                }
            }
            if (check(checkList, version)) {
                return true;
            }
            checkList.removeAll(checkList);
        }
        return false;
    }


    /**
     * the function of the method is to check for a win
     * diagonally from top left to bottom right
     * @param columns 2d list which is the grid
     * @param version int specifying the version of the game
     * @return boolean value if smb won or not
     */
    public static boolean descendingVerticalCheck(char[][] columns, int version) {
        ArrayList<Character> checkList = new ArrayList<>();

        for(int k = 0; k <= columns[0].length + columns.length - 2; k++) {
            for(int j = 0 ; j <= k ; j++) {
                int i = k - j;
                if( i < columns.length && j < columns[0].length ) {
                    checkList.add(columns[i][j]);
                }
            }
            if (check(checkList, version)) {
                return true;
            }
            checkList.removeAll(checkList);
        }
        return false;
    }


    /**
     * the function of this method is to check for a win by finding
     * 3/4/5 consecutive similar characters inside a given array
     * @param checkList an ArrayList which has values to check
     * @param version int specifying the version of the game
     * @return boolean value if there is win
     */
    public static boolean check(ArrayList<Character> checkList, int version) {
        ArrayList<Character> colors = new ArrayList<>();
        colors.add('R');
        colors.add('Y');

        if (version == 3) {
            for (int i = 0; i < checkList.size() - 2; i++) {
                if (checkList.get(i) == checkList.get(i + 1) &&
                        checkList.get(i) == checkList.get(i + 2)
                        && colors.contains(checkList.get(i))) {
                    return true;
                }
            }
        } else if (version == 4) {
            for (int i = 0; i < checkList.size() - 3; i++) {
                if (checkList.get(i) == checkList.get(i + 1) && checkList.get(i) ==
                        checkList.get(i + 2) && checkList.get(i) == checkList.get(i + 3)
                        && colors.contains(checkList.get(i))) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < checkList.size() - 4; i++) {
                if (checkList.get(i) == checkList.get(i + 1) && checkList.get(i) ==
                        checkList.get(i + 2) && checkList.get(i) == checkList.get(i + 3) &&
                        checkList.get(i) == checkList.get(i + 4) && colors.contains(checkList.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * the function of this method is to determine which version of the
     * game a user wants to play
     * @return integer specifying the version of the game
     */
    public static int getGameVersion() {
        System.out.println("Which version of the game do you want to play? (Connect 3/4/5)");
        int version;
        do {
            System.out.println("Please, provide a number between 3-5 (inclusive on both ends)");
            Scanner number = new Scanner(System.in);
            while (!number.hasNextInt()) {
                number.nextLine(); // Clears the invalid input
                System.out.println("Please, provide a number between 3-5 (inclusive on both ends)");
            }
            version = number.nextInt();
        } while (!(version >= 3 && version <= 5));
        return version;
    }


    /**
     * the function of the method is to input the char
     * into a column which the user choose
     * @param columns 2d list which is the grid
     * @param color char color that the user chose
     */
    public static void input(char[][] columns, char color) {
        String playerColor;
        if (color == 'Y' || color == 'y') {
            playerColor = "Yellow";
        } else {
            playerColor = "Red";
        }
        int colNum = validColNum(playerColor) - 1;
        while (columns[colNum][columns[colNum].length - 1] == 'R'
                || columns[colNum][columns[colNum].length - 1] == 'Y') {
            System.out.println("The column is full. Please, choose another column.");
            colNum = validColNum(playerColor) - 1;
        }

        for (int i = 0; i < columns[colNum].length; i++) {
            if (columns[colNum][i] == 'Y' || columns[colNum][i] == 'R') {
                continue;
            } else {
                columns[colNum][i] = color;
                break;
            }
        }
    }


    /**
     * the function of this method is to get a valid column number
     * from a player
     * @param playerColor string: player's color
     * @return valid column number the player chose
     */
    public static int validColNum(String playerColor) {
        int p1;
        do {
            System.out.println(playerColor + " to play. Pick a column(1-7):");
            Scanner number = new Scanner(System.in);
            while (!number.hasNextInt()) {
                number.nextLine();
                System.out.println(playerColor + " to play. Pick a column(1-7):");
            }
            p1 = number.nextInt();
        } while (!(p1 > 0 && p1 < 8));

        return p1;
    }


    /**
     * the function of this method is to determine if the game is
     * over by draw (there is no space on the grid)
     * @param columns 2d list which is the grid
     * @return boolean value if the game is over or not
     */
    public static boolean isItOver(char[][] columns) {
        boolean notOver = false;
        for (char[] column : columns) {
            for (char c : column) {
                if (c == 'R' || c == 'Y') {
                    continue;
                } else {
                    notOver = true;
                }
            }
        }
        return notOver;
    }


    /**
     * the function of this method is to get player's info
     * @return ArrayList which has player names and their color
     */
    public static ArrayList<String> playerInfo() {
        ArrayList<String> info = new ArrayList<>();

        ArrayList<String> colors = new ArrayList<>();
        colors.add("R");
        colors.add("Y");

        System.out.println("Player 1 Name: ");
        Scanner player1 = new Scanner(System.in);       //getting the player1 name
        String player1Name = player1.nextLine();
        String p1Color;
        do {
            System.out.println("Pick a color (R for red and Y for yellow)");
            Scanner color = new Scanner(System.in);
            p1Color = color.nextLine();
        } while (!colors.contains(p1Color.toUpperCase()));

        System.out.println("Player 2 Name: ");
        Scanner player2 = new Scanner(System.in);       //getting the player2 name
        String player2Name = player2.nextLine();
        String p2Color;
        if (p1Color.equals("Y")) {
            p2Color = "R";
        } else {
            p2Color = "Y";
        }
        info.add(player1Name);
        info.add(p1Color.toUpperCase());
        info.add(player2Name);
        info.add(p2Color.toUpperCase());

        return info;        //{player1 name, player1 color, player2 name, player2 color}
    }

    /**
     * The function of this method is to print out
     * the grid
     * @param columns 2d list which is the grid
     */
    public static void printing(char[][] columns){
        System.out.println();
        int rowIndex = 5;
        System.out.print("|");
        while (rowIndex > -1){
            int colIndex = 0;
            while (colIndex < 7){
                if (columns[colIndex][rowIndex] == 'Y' || columns[colIndex][rowIndex] == 'R'){
                    System.out.print(columns[colIndex][rowIndex]);
                } else {
                    System.out.print(" ");
                }
                colIndex++;
                if (colIndex < 7) {
                    System.out.print("|");
                } else {
                    System.out.println("|");
                }
            }
            rowIndex--;
            if (rowIndex > -1){
                System.out.print("|");
            }
        }
        System.out.println("---------------");
    }
}
