public class matrixZigZagTraversal {
    static int Rows;
    static int Cols;

    static void printZigzag(int[][] matarr)
    {
        for (int rIdx =0; rIdx < Rows; rIdx++)
        {
            int col = 0;
            int row = rIdx;

            while( row < Rows && col < Cols && row >=0 && col >= 0)
            {
                System.out.print(" " + matarr[row][col] + " ");

                row--;
                col++;
            }
        }

        for (int cIdx = 1; cIdx < Cols; cIdx++)
        {
            int row = Rows - 1;
            int col = cIdx;

            while ( row < Rows && col < Cols && row >=0 && col >= 0)
            {
                System.out.print(" " + matarr[row][col] + " ");

                row--;
                col++;
            }
        }
    }
    public static void main(String[] args)
    {
        int[][] mat = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };
        Rows = mat.length;
        Cols = mat[0].length;

        printZigzag(mat);
    }
}
