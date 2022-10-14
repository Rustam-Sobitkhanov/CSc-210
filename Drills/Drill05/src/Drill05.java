import java.util.List;

public class Drill05 {

	// Given a list of lists of Shapes organized in a grid,
	// return the shape in the given row and column.
    public static Shape getShapeFromGrid(List<List<Shape>> grid, int row,
            int col) {

        return grid.get(row).get(col);
    }

    // Return true if the shape in the given location is a Triangle
    // and false otherwise.
    public static boolean isTriangle(List<List<Shape>> grid, int row, int col) {
        return grid.get(row).get(col) instanceof Triangle;
    }

    // Return true if the shape in the given location is a Square
    // and false otherwise.
    public static boolean isSquare(List<List<Shape>> grid, int row, int col) {
        return grid.get(row).get(col) instanceof Square;
    }

    // Concatenate all of the Strings in the grid by going row by row.
    // If a row or row and column location is null, then just concatenate
    // in an empty string.
    public static String byRow(List<List<String>> grid) {
        String retString = "";
        for (List row : grid){
            if (row == null){
                retString += "";
            }else{
                for (Object col : row) {
                    if (col == null) {
                        retString += "";
                    } else {
                        retString += col;
                    }
                }
            }
        }
        return retString;
    }

    // Set the given row and column in the given screen to the given character.
    public static void setArrayElem(char[][] screen, int row, int col, char c) {
        screen[row][col] = c;
    }

}
