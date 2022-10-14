import java.util.ArrayList;

public class test {
    public static void main(String[] args){
        int[][] columns = new int[7][6];
        int count = 1;
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 6; j++){
                columns[i][j] = count;
                count ++;
            }
        }

        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 6; j++){
                System.out.print(Integer.toString(columns[i][j]) + " ");
            }
            System.out.println();
        }

        ArrayList<Integer> checkList = new ArrayList<>();
        int y = columns.length, x = columns[0].length - 1;
        for (int i = 2 - y; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i + j >= 0 && i + j <= x) {
                    checkList.add(columns[j][i+j]);
                }
            }
            System.out.println(checkList);
            checkList.removeAll(checkList);
        }
    }
}
