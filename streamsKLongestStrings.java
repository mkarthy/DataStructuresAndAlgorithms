
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class streamsKLongestStrings {
    public static void main(String[] args) {
        List<String> input = List.of("January", "February", "March", "April","September", "December");
        int k = 3;

        List<String> result = input.stream()
                                .sorted(Comparator.comparingInt(String::length).reversed())
                                .limit(k)
                                .collect(Collectors.toList());

        System.out.println(" result : " + result);
    }
}
