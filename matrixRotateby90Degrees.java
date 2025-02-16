/*
 *  With Space Complexity of O(m x n)
 * as new RES array is usd to store result
 * 
 * RES array traversal with [j][rows - i - 1]
 */
public class matrixRotateby90Degrees {
    public static int[][] res;

    static void rotateMatrix(int[][] matarr)
    {
        int rows = matarr.length;
        int cols = matarr[0].length;

        res = new int[rows][cols];

        for (int i = 0; i < rows ; i++)
        {
            for( int j = 0; j < cols; j++)
            {
                res[j][rows - i -1] = matarr[i][j];
                //res[cols-j-1][i] = matarr[i][j]; //this logic for anticlockwise 90degree rotate 
            }
        }
    }

    static void printmatrix(int[][] matarr)
    {
        for (int[] matarr1 : matarr) {
            for (int j = 0; j < matarr1.length; j++) {
                System.out.print(" " + matarr1[j] + ",");
            }
            System.out.println();
        }
    }
    public static void main (String[] args)
    {
        int[][] mat = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };

        rotateMatrix(mat);
        printmatrix(res);
    }
}