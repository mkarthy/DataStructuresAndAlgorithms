
import java.util.Arrays;
import java.util.Optional;

public class streamsFind2ndlargest {
    public static void main(String[] args) {
        int[] arr = {10, 5, 7, 3, 8, 4};
/* 
        int res = Arrays.stream(arr)
                    .boxed()
                    .sorted((a,b) -> b - a)
                    .skip(1)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Wrong Argument"));

        System.err.println(" Second Largest : " + res);
*/

        Optional<Integer> result = Arrays.stream(arr)
                             .distinct()
                             .boxed()
                             .sorted((a,b) -> b - a)
                             .skip(1)
                             .findFirst();

        System.out.println(result.isPresent() ? " Second Largest :" + result.get() : "Not found");
    }
}
