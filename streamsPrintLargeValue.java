
import java.util.Arrays;

public class streamsPrintLargeValue {
    public static void main(String[] args) {
        int[] input = {20, 5, 40, 6, 7, 3, 10};
    
        int[] result = Arrays.stream(input)
                        .filter(i -> i * i > 50)
                        .toArray();

        System.out.println("Result : " + Arrays.toString(result));
    }
}
