/**
 * CS 331.02
 * Professor: Salloum
 *
 * Programming Assignment #3
 * <Dynamic Programming>
 *
 * Justin Galloway
 */

public class Main {

    public static void main(String[] args) {
        int[][] inputMatrix = { {4, 5, 6},
                {1, 2, 3},
                {0, 1, 3} };
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                inputMatrix[i][j] = (int)(Math.random()*10);
            }
        }

        System.out.println("Matrix:");
        System.out.println(inputMatrix[0][0] + " " + inputMatrix[0][1] + " " + inputMatrix[0][2]);
        System.out.println(inputMatrix[1][0] + " " + inputMatrix[1][1] + " " + inputMatrix[1][2]);
        System.out.println(inputMatrix[2][0] + " " + inputMatrix[2][1] + " " + inputMatrix[2][2]);

        System.out.println("\nMaximum cost to traverse = "+ maxCost(inputMatrix));

    }

    public static int maxCost(int[][] inputMatrix){
        int[][] mat = new int[inputMatrix.length][inputMatrix[0].length];

        mat[mat.length-1][mat[0].length-1] = inputMatrix[mat.length-1][mat[0].length-1];

        for(int j=mat[0].length-2; j>=0; j--){
            int lastRow = mat.length-1;
            mat[lastRow][j] = mat[lastRow][j+1] + inputMatrix[lastRow][j];
        }

        for(int i=mat.length-2; i>=0; i--){
            int lastCol = mat[0].length-1;
            mat[i][lastCol] = mat[i+1][lastCol] + inputMatrix[i][lastCol];
            for(int j=mat[0].length-2; j>=0; j--){
                mat[i][j] = inputMatrix[i][j] + Math.max(mat[i+1][j+1],
                        Math.max(mat[i+1][j], mat[i][j+1]));
            }
        }

        return mat[0][0];
    }
}