
import java.util.Arrays;

public class streamsRemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,5,5,5,6,6,6,7,7,8,9};

        int[] res = Arrays.stream(arr)
                    .distinct()
                    .toArray();

        System.out.println(" Result Array :" + Arrays.toString(res));
    }
}
