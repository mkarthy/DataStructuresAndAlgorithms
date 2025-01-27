import java.util.*;

public class matrixSpiralTraverse2 {
    enum Direction {
        RIGHT, LEFT, DOWN, UP
    }

    static List<Integer> spiral(int[][] matarr)
    {
        List<Integer> res = new ArrayList<>();
        int rows = matarr.length;
        int cols = matarr[0].length;
        int total = rows * cols;
        boolean[][] visited =  new boolean[rows][cols]; //visited boolean flags for every cell

        int x =0, y = 0;

        Direction direction = Direction.RIGHT;

        while( res.size() < total ) // while loop until all cells are visited by m * n
        {
            res.add(matarr[x][y]);
            visited[x][y] = true;

            switch ( direction ) //switch direction when current direction not available or visited.
            {
                case RIGHT:
                    if ( y+1 < cols && !visited[x][y+1]) //y++
                    {
                        y++;
                    }
                    else
                    {
                        direction = Direction.DOWN;
                        x++;
                    }
                    break;
                case DOWN:
                    if ( x+1 < rows && !visited[x+1][y]) //x++
                    {
                        x++;
                    }
                    else
                    {
                        direction = Direction.LEFT;
                        y--;
                    }
                    break;
                case LEFT:
                    if ( y -1 >= 0 && !visited[x][y-1]) //y--
                    {
                        y--;
                    }
                    else
                    {
                        direction = Direction.UP;
                        x--;
                    }
                    break;
                case UP:
                    if ( x -1 >= 0 && !visited[x - 1][y]) //x--
                    {
                        x--;
                    }
                    else
                    {
                        direction = Direction.RIGHT;
                        y++;
                    }
                    break;
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
