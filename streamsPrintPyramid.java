
import java.util.stream.IntStream;

public class streamsPrintPyramid {
    public static void main(String[] args)
    {
        int rows = 6;

        IntStream.range(1, rows + 1)
            .forEach(row -> {
                IntStream.range(0,rows-row).forEach(i -> System.out.print(" "));
                IntStream.rangeClosed(1, row).forEach(i -> System.out.print(i + " "));
                System.out.println();
            });
    }
}
