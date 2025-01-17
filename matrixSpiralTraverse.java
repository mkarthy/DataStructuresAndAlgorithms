import java.util.*;

public class matrixSpiralTraverse {

    static List<Integer> spiral(int[][] matrix)
    {
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        int row = 0, col =0;
        List<Integer> res = new ArrayList<>();

        while (row <= rows && col <= cols)
        {
            for(int i= col;i <= cols; i++)
            {
                res.add(matrix[row][i]);
            }
            row++;

            for(int i = row;i <= rows; i++ )
            {
                res.add(matrix[i][cols]);
            }
            cols--; //Actual column count is reduced here

            if ( row <= rows)
            {
                for(int i= cols ;i >= col; i--)
                {
                    res.add(matrix[rows][i]);
                }
                rows--;
            }

            if ( col <= cols)
            {
                for(int i = rows ; i >= row; i--)
                {
                    res.add(matrix[i][col]);
                }
                col++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int [][] mat = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };
        
        List<Integer> res = spiral(mat);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
